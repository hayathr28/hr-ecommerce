package com.hr.ecommerce.services;

import org.springframework.stereotype.Service;

import com.hr.ecommerce.common.PaymentStatus;
import com.hr.ecommerce.order.model.AppliedPayment;
import com.hr.ecommerce.rquest.beans.SubmitOrderReqBean;

@Service
public class GiftCardAuthorizationService {

	public AppliedPayment authorizeGC(AppliedPayment appliedPayment, SubmitOrderReqBean submitOrderReqBean) {
		return fakeCreditCardAuthorization(appliedPayment, submitOrderReqBean);
	}

	private AppliedPayment fakeCreditCardAuthorization(AppliedPayment appliedPayment,
			SubmitOrderReqBean submitOrderReqBean) {
		/**
		 * return Decline case - if credit cards used was 2430063
		 */
		if (submitOrderReqBean.getPayment().getAccountNumber().equalsIgnoreCase("2430063")) {
			appliedPayment.setApprovedAmount(appliedPayment.getRequestedAmount());
			appliedPayment.setTrandactionId("XRES543!");
			appliedPayment.setAuthCode("4121");
			appliedPayment.setAvsValue("100");
			appliedPayment.setPaymentStatus(PaymentStatus.DECLINED.toString());
			return appliedPayment;
		} else {
			appliedPayment.setApprovedAmount(appliedPayment.getRequestedAmount());
			appliedPayment.setTrandactionId("XRES543!");
			appliedPayment.setAuthCode("4121");
			appliedPayment.setAvsValue("100");
			appliedPayment.setPaymentStatus(PaymentStatus.APPROVED.toString());
			return appliedPayment;
		}
	}
}
