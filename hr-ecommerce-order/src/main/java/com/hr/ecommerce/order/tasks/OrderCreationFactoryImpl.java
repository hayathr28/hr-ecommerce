package com.hr.ecommerce.order.tasks;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.hr.ecommerce.model.Product;
import com.hr.ecommerce.order.model.ItemInfo;
import com.hr.ecommerce.order.model.Order;
import com.hr.ecommerce.order.model.OrderItem;

@Service
public class OrderCreationFactoryImpl implements OrderCreationFactory {
	
	
	public Order addToCart(Product product) {
		Order order = new Order();
		order.setOrderItems(getOrderItem(order,product));
		return order;
		
	}

	private List<OrderItem> getOrderItem(Order order,Product product) {
		List<OrderItem> orderItems = (null != order.getOrderItems()) ? order.getOrderItems() : new ArrayList<OrderItem>();
		OrderItem orderItem = new OrderItem();
		orderItem.setItemInfo(getItemInfo(product));
		orderItems.add(orderItem);
		return orderItems;
	}

	private ItemInfo getItemInfo(Product product) {
		ItemInfo itemInfo = new ItemInfo();
	    itemInfo.setPrice(product.getPrice());	
	    itemInfo.setProductCode(product.getProductCode());
	    itemInfo.setQuantity("1");
	    return itemInfo;
	}

}
