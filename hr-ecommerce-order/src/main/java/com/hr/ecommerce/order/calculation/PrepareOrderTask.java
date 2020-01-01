package com.hr.ecommerce.order.calculation;

import org.springframework.stereotype.Service;

import com.hr.ecommerce.order.model.Order;

@Service
public class PrepareOrderTask {
	
	
	
	public Order prepareOrder(Order order) {
		
		/**
		 * Calculate all order entities at order item level and then promote total charge to orderLevel;
		 */
		
		if(null != order && null!=order.getOrderItems() && ! order.getOrderItems().isEmpty()) {
			calculateOreder(order);
		}else {
			resetOrder(order);
		}
		
		return order;
		
	}

	private void resetOrder(Order order) {
		// TODO Auto-generated method stub
		
	}

	private void calculateOreder(Order order) {
		// TODO Auto-generated method stub
		
	}

}
