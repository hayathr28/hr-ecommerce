package com.hr.ecommerce.order;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hr.ecommerce.common.HREcommerceErrorConstants;
import com.hr.ecommerce.common.OrderStatusValidationUtil;
import com.hr.ecommerce.exception.HREcommerceExceptionFactory;
import com.hr.ecommerce.order.common.DBUtils;
import com.hr.ecommerce.order.model.Address;
import com.hr.ecommerce.order.model.Order;
import com.hr.ecommerce.order.model.OrderItem;
import com.hr.ecommerce.rquest.beans.ShippingAddress;
import com.hr.ecommerce.rquest.beans.ShippingAddressReqBean;

@Service
public class AddShippingTask {

	@Autowired
	private HREcommerceExceptionFactory exceptionFactory;

	public String saveShippingAddress(String orderId, ShippingAddressReqBean shippingAddressBean) throws Exception {
		Order order = DBUtils.retrieveOrder(orderId);

		if (null == order) {
			throw exceptionFactory.createException(HREcommerceErrorConstants.ERROR_ORDER_DOES_NOT_EXIST,
					new Object[] { orderId });
		}
		OrderStatusValidationUtil.isOrderInRightState(order);
		OrderItem orderItem = getOrderItemFromOrder(shippingAddressBean.getOrderItemId(), order);

		if (null == orderItem) {
			throw exceptionFactory.createException(HREcommerceErrorConstants.ERROR_ORDERITEM_DOES_NOT_EXIST,
					new Object[] { shippingAddressBean.getOrderItemId() });
		}
		orderItem.setAddress(processAddress(shippingAddressBean.getShippingAddress()));
		DBUtils.saveOrder(order);
		return "SUCCESS";
	}

	private OrderItem getOrderItemFromOrder(String orderItemId, Order order) {

		for (OrderItem orderItem : order.getOrderItems()) {
			if (StringUtils.equalsIgnoreCase(orderItemId, orderItem.getOrderItemId()))
				return orderItem;
		}

		return null;
	}

	private Address processAddress(ShippingAddress shippingAddress) {
		Address address = new Address();
		BeanUtils.copyProperties(shippingAddress, address);
		return address;
	}

}
