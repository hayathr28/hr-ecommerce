package com.hr.ecommerce.common;

import org.apache.commons.lang3.StringUtils;

public enum DiscountType {

	ORDER("Order"), SHIPPING("Shipping");

	private final String discountType;

	DiscountType(String discountType) {
		this.discountType = discountType;
	}

	public static DiscountType getDiscountType(String disType) {
		for (DiscountType discountType : DiscountType.values()) {
			if (StringUtils.isNotEmpty(disType) && StringUtils.equalsIgnoreCase(discountType.discountType, disType)) {
				return discountType;
			}

		}
		return null;
	}

	public String toString() {
		return discountType;
	}
}
