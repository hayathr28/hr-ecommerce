package com.hr.ecommerce.common;

import org.apache.commons.lang3.StringUtils;

import com.hr.ecommerce.exception.HREcommerceException;
import com.hr.ecommerce.order.model.Order;

public class OrderStatusValidationUtil {
	
	public static boolean isOrderInRightState(Order order) {
		if(!StringUtils.equalsIgnoreCase(order.getOrderStatus(), OrderStatus.PENDING.toString()))
			throw new HREcommerceException("ORDER IS NOT IN RIGHT STATE");
		return true;
	}

}
