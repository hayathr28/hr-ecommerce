package com.hr.ecommerce.order.operations;

import com.hr.ecommerce.rquest.beans.AddToCartRequest;

public interface OrderOperations {
	
	public String addToCart(AddToCartRequest addToCartRequest) throws Exception;

}
