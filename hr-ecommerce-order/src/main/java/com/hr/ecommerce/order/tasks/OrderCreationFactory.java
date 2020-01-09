package com.hr.ecommerce.order.tasks;

import com.hr.ecommerce.model.Product;
import com.hr.ecommerce.order.model.Order;
import com.hr.ecommerce.rquest.beans.AddToCartRequest;

public interface OrderCreationFactory {
	
	Order addToCart(Product product, AddToCartRequest addToCartRequest);

}
