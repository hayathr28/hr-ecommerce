package com.hr.ecommerce.common;

import org.apache.commons.lang3.StringUtils;

public enum OrderStatus {
	
	PENDING("Pending"), 
	COMPLETED("Completed"),
	CANCELLED("Cancelled");

	private final String orderStatus;

	OrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	public static OrderStatus getOrderStatus(String ordStatus) {
		for (OrderStatus orderStatus : OrderStatus.values()) {
			if (StringUtils.isNotEmpty(ordStatus)
					&& StringUtils.equalsIgnoreCase(orderStatus.orderStatus, ordStatus)) {
				return orderStatus;
			}

		}
		return null;
	}

	public String toString() {
		return orderStatus;
	}

}
