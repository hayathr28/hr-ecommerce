package com.hr.ecommerce.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hr.ecommerce.common.HREcommerceErrorConstants;
import com.hr.ecommerce.exception.HREcommerceExceptionFactory;
import com.hr.ecommerce.model.Product;
import com.hr.ecommerce.order.calculation.PrepareOrderTask;
import com.hr.ecommerce.order.common.DBUtils;
import com.hr.ecommerce.order.model.Order;
import com.hr.ecommerce.order.tasks.OrderCreationFactory;
import com.hr.ecommerce.rquest.beans.AddToCartRequest;

@Service
public class CreateOrderTask {
	
	@Autowired
	private OrderCreationFactory orderFactory;
	
	@Autowired
	private HREcommerceExceptionFactory exceptionFactory;
	
	@Autowired
	private PrepareOrderTask prepareOrderTask;
	
	public Order createOrder(AddToCartRequest addToCartRequest) throws Exception {
		/**
		 * Step1 : get the product information from the catalog
		 */
		Product product = DBUtils.retriveProduct(addToCartRequest.getProductCode());
		
		/**
		 * Check if product is still buyable
		 */
		if(null==product || !product.isBuyable()) {
			throw exceptionFactory.createException(HREcommerceErrorConstants.ERROR_PRODUCT_NOT_AVAILABLE,new Object[] {addToCartRequest.getProductCode()});
		}
		
		/**
		 * If product is buyable then add it to cart
		 */
		Order order = orderFactory.addToCart(product,addToCartRequest);
		
		/**
		 * Create an object of cart with product information.
		 */
		order = prepareOrderTask.prepareOrder(order);
		DBUtils.saveOrder(order);
		/**
		 *  Save cart.
		 */
		return order;
	}
	


}
