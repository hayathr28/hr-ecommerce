package com.hr.ecommerce.services;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import com.hr.ecommerce.order.model.Order;
import com.hr.ecommerce.order.model.OrderItem;
import com.hr.ecommerce.shipping.ShippingChargeResponseBean;

@Service
public class ShippingService {
	
	public  Map<String,ShippingChargeResponseBean> calculateShipping(Order order){
		// temporarily return mock shipping response;
		return createMockResponse(order);
	}

	private  Map<String,ShippingChargeResponseBean> createMockResponse(Order order) {
		 Map<String,ShippingChargeResponseBean> shippingCharges = new HashMap();
		
		for(OrderItem orderItem: order.getOrderItems()) {
			if(canCalculateShipping(orderItem))
			 shippingCharges.put(orderItem.getOrderItemId(), fakeShippignCharge());
		}
		
		return shippingCharges;
	}

	private boolean canCalculateShipping(OrderItem orderItem) {
		return orderItem.getAddress() !=null && StringUtils.isNotEmpty(orderItem.getAddress().getPinCode()); 
		
	}

	private ShippingChargeResponseBean fakeShippignCharge() {
		ShippingChargeResponseBean shippingBean = new ShippingChargeResponseBean();
		shippingBean.setBaseCharge("14.99");
		shippingBean.setUpCharge("2.99");
		shippingBean.setShippingMethod("Ground");
		return shippingBean;
	}

	

}
