package com.hr.ecommerce.order.tasks;

import com.hr.ecommerce.model.Product;
import com.hr.ecommerce.order.model.Order;

public interface OrderCreationFactory {
	
	 Order addToCart(Product product);

}
