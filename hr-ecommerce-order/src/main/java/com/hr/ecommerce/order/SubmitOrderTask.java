package com.hr.ecommerce.order;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hr.ecommerce.common.EnterpriseServices;
import com.hr.ecommerce.common.HREcommerceErrorConstants;
import com.hr.ecommerce.common.OrderStatus;
import com.hr.ecommerce.common.PaymentMethods;
import com.hr.ecommerce.common.PaymentStatus;
import com.hr.ecommerce.exception.HREcommerceExceptionFactory;
import com.hr.ecommerce.order.calculation.CalculateOrderTask;
import com.hr.ecommerce.order.common.CCValidator;
import com.hr.ecommerce.order.common.DBUtils;
import com.hr.ecommerce.order.common.DateHelper;
import com.hr.ecommerce.order.model.AppliedPayment;
import com.hr.ecommerce.order.model.CustomerAddress;
import com.hr.ecommerce.order.model.Order;
import com.hr.ecommerce.rquest.beans.SubmitOrderReqBean;

@Service
public class SubmitOrderTask {

	@Autowired
	private HREcommerceExceptionFactory exceptionFactory;

	@Autowired
	private CalculateOrderTask calculateOrderTask;
	
	@Autowired
	private EnterpriseServices enterpriseServices;
	
	

	public String submitOrder(String orderId, SubmitOrderReqBean submitOrderReqBean) throws Exception {

		Order order = DBUtils.retrieveOrder(orderId);
		AppliedPayment appliedPayment =null;

		if (null == order) {
			throw exceptionFactory.createException(HREcommerceErrorConstants.ERROR_ORDER_DOES_NOT_EXIST,
					new Object[] { orderId });
		}
		
		/**
		 * Save customers billing address on order.
		 */
		validateAndSaveCustomerAddress(order, submitOrderReqBean);

		/**
		 * Recalculate order one more time before submitting it.
		 */

		calculateOrderTask.calculateOrder(orderId);

		/**
		 * Process payment method    
		 */

		appliedPayment = validateAndProcessPayment(order, submitOrderReqBean);
		
		if(! StringUtils.equalsAnyIgnoreCase(appliedPayment.getPaymentStatus(), PaymentStatus.APPROVED.toString())) {
			 throw exceptionFactory.createException(HREcommerceErrorConstants.PAYMENT_DECLINED);
		}
		List<AppliedPayment> appliedPayments = (null != order.getAppliedPayments()) ? order.getAppliedPayments()
				: new ArrayList<AppliedPayment>();
		appliedPayments.add(appliedPayment);
		order.setAppliedPayments(appliedPayments);
		order.setOrderStatus(OrderStatus.COMPLETED.toString());
		DBUtils.saveOrder(order);
		return "SUCCESSS";
	}
	

	private AppliedPayment validateAndProcessPayment(Order order, SubmitOrderReqBean submitOrderReqBean) throws Exception {
		AppliedPayment appliedPayment = getAppliedPayment(order, submitOrderReqBean);

		PaymentMethods paymentMethod = PaymentMethods
				.getPaymentMethod(submitOrderReqBean.getPayment().getPaymentMethod());

		switch (paymentMethod) {

		case CREDITCARD:
			return processPaymentWithCreditCard(appliedPayment, submitOrderReqBean);
			
		case GIFTCARD:
			return processPaymentWithGiftCard(appliedPayment, submitOrderReqBean);

		default:
			throw exceptionFactory.createException(HREcommerceErrorConstants.INVALID_PAYMENT_METHOD);
		}

	}

	private AppliedPayment processPaymentWithCreditCard(AppliedPayment appliedPayment,
			SubmitOrderReqBean submitOrderReqBean) throws Exception {
		if (!CCValidator.validateCard(submitOrderReqBean.getPayment().getAccountNumber()))
			throw exceptionFactory.createException(HREcommerceErrorConstants.INVALID_CREDIT_CARD_NUMBER);

		if (DateHelper.convertToDate(submitOrderReqBean.getPayment().getExpirationYear(),
				submitOrderReqBean.getPayment().getExpirationMonth(), "28").before(Calendar.getInstance()))
			throw exceptionFactory.createException(HREcommerceErrorConstants.EXPIRED_CREDIT_CARD,
					new Object[] { submitOrderReqBean.getPayment().getExpirationMonth(),
							submitOrderReqBean.getPayment().getExpirationYear() });

		if (StringUtils.isEmpty(submitOrderReqBean.getPayment().getCvv())) {
			throw exceptionFactory.createException(HREcommerceErrorConstants.CVV_IS_REQUIRED);
		}

		return enterpriseServices.authorizeCreditCard(appliedPayment, submitOrderReqBean);
	}

	private AppliedPayment processPaymentWithGiftCard(AppliedPayment appliedPayment, SubmitOrderReqBean submitOrderReqBean) {
		
		if (StringUtils.isEmpty(submitOrderReqBean.getPayment().getCvv())) {
			throw exceptionFactory.createException(HREcommerceErrorConstants.GIFT_CARD_IS_REQUIRED);
		}
		 return enterpriseServices.authorizeGiftCard(appliedPayment, submitOrderReqBean);
	}

	private AppliedPayment getAppliedPayment(Order order, SubmitOrderReqBean submitOrderReqBean) {

		List<AppliedPayment> appliedPayments = (null != order.getAppliedPayments()) ? order.getAppliedPayments()
				: new ArrayList<AppliedPayment>();
		for (AppliedPayment appliedPayment : appliedPayments) {
			if (StringUtils.equalsIgnoreCase(appliedPayment.getPaymentStatus(), PaymentStatus.PENDING.toString())
					&& StringUtils.equalsIgnoreCase(appliedPayment.getPaymentMethod(),
							submitOrderReqBean.getPayment().getPaymentMethod()))
				return appliedPayment;
		}
		AppliedPayment newPayment = new  AppliedPayment();
		newPayment.setPaymentMethod(submitOrderReqBean.getPayment().getPaymentMethod());
		newPayment.setPaymentStatus( PaymentStatus.PENDING.toString());
		newPayment.setRequestedAmount(order.getOrderTotal());
		return newPayment;
	}

	private void validateAndSaveCustomerAddress(Order order, SubmitOrderReqBean submitOrderReqBean) {
		com.hr.ecommerce.order.model.Customer customer = null != order.getCustomer() ? order.getCustomer()
				: new com.hr.ecommerce.order.model.Customer();
		customer.setCustomerAddress(getBillingAddress(submitOrderReqBean));
		customer.setDateCreated(DateHelper.getCurrentTime());
		customer.setLastUpdated(DateHelper.getCurrentTime());
		order.setCustomer(customer);

	}

	private CustomerAddress getBillingAddress(SubmitOrderReqBean submitOrderReqBean) {
		CustomerAddress billingAddress = new CustomerAddress();
		BeanUtils.copyProperties(submitOrderReqBean.getCustomer().getBillingAddress(), billingAddress);
		return billingAddress;
	}

}
