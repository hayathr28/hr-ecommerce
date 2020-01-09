package com.hr.ecommerce.services;

import org.springframework.stereotype.Service;

import com.hr.ecommerce.common.PaymentStatus;
import com.hr.ecommerce.order.model.AppliedPayment;
import com.hr.ecommerce.rquest.beans.SubmitOrderReqBean;

@Service
public class CreditCardAuthorizationService {
	
	public AppliedPayment authorizeCC(AppliedPayment appliedPayment,SubmitOrderReqBean submitOrderReqBean) {
		return fakeCreditCardAuthorization(appliedPayment, submitOrderReqBean);
	}

	private AppliedPayment fakeCreditCardAuthorization(AppliedPayment appliedPayment,
			SubmitOrderReqBean submitOrderReqBean) {
		/**
		 * return Decline case - if credit cards used was 4111111111111111
		 */
		if(submitOrderReqBean.getPayment().getAccountNumber().equalsIgnoreCase("4111111111111111")) {
			appliedPayment.setApprovedAmount(appliedPayment.getRequestedAmount());
			appliedPayment.setTrandactionId("XRES543!");
			appliedPayment.setAuthCode("601");
			appliedPayment.setAvsValue("100");
			appliedPayment.setPaymentStatus(PaymentStatus.DECLINED.toString());
			return appliedPayment;
		}else {
			appliedPayment.setApprovedAmount(appliedPayment.getRequestedAmount());
			appliedPayment.setTrandactionId("XRES543!");
			appliedPayment.setAuthCode("601");
			appliedPayment.setAvsValue("100");
			appliedPayment.setPaymentStatus(PaymentStatus.APPROVED.toString());
			return appliedPayment;
		}
	}

}
