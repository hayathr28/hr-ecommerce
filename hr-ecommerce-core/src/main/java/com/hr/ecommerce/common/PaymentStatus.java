package com.hr.ecommerce.common;

import org.apache.commons.lang3.StringUtils;

public enum PaymentStatus {

	INITIALIZED("Initialized"), PENDING("Pending"), APPROVED("Approved"), DECLINED("Declined"),
	CANCELLED("Cancelled");

	private final String paymentStatus;

	PaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}

	public static PaymentStatus getPaymentStatus(String payStatus) {
		for (PaymentStatus paymentStatus : PaymentStatus.values()) {
			if (StringUtils.isNotEmpty(payStatus)
					&& StringUtils.equalsIgnoreCase(paymentStatus.paymentStatus, payStatus)) {
				return paymentStatus;
			}

		}
		return null;
	}

	public String toString() {
		return paymentStatus;
	}

}
