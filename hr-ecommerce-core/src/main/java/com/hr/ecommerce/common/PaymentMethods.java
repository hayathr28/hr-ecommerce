package com.hr.ecommerce.common;

import org.apache.commons.lang3.StringUtils;

public enum PaymentMethods {
	CREDITCARD("creditCard"), GIFTCARD("giftCard");

	private final String paymentMethod;

	PaymentMethods(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	public static PaymentMethods getPaymentMethod(String payMethod) {
		for (PaymentMethods paymentMethod : PaymentMethods.values()) {
			if (StringUtils.isNotEmpty(payMethod)
					&& StringUtils.equalsIgnoreCase(paymentMethod.paymentMethod, payMethod)) {
				return paymentMethod;
			}

		}
		return null;
	}

	public String toString() {
		return paymentMethod;
	}


}
