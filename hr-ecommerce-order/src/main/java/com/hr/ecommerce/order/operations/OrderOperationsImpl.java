package com.hr.ecommerce.order.operations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hr.ecommerce.common.HREcommerceErrorConstants;
import com.hr.ecommerce.exception.HREcommerceExceptionFactory;
import com.hr.ecommerce.model.Product;
import com.hr.ecommerce.order.model.Order;
import com.hr.ecommerce.order.tasks.OrderCreationFactory;
import com.hr.ecommerce.persistence.helper.PersistenceHelper;
import com.hr.ecommerce.rquest.beans.AddToCartRequest;

@Service
public class OrderOperationsImpl implements OrderOperations {
	
	@Autowired
	private PersistenceHelper persistenceHelper;
	
	@Autowired
	private HREcommerceExceptionFactory exceptionFactory;
	
	@Autowired
	private OrderCreationFactory orderFactory;
	


	public String addToCart(AddToCartRequest addToCartRequest) throws Exception {
		
		/**
		 * Step1 : get the product information from the catalog
		 */
		Product product = retriveProduct(addToCartRequest.getProductCode());
		
		/**
		 * Check if product is still buyable
		 */
		if(null==product || !product.isBuyable()) {
			throw exceptionFactory.createException(HREcommerceErrorConstants.ERROR_PRODUCT_NOT_AVAILABLE,new Object[] {addToCartRequest.getProductCode()});
		}
		
		/**
		 * If product is buyable then add it to cart
		 */
		Order order = orderFactory.addToCart(product);
		
		/**
		 * Create an object of cart with product information.
		 */
		persistenceHelper.saveOrder(order);
		/**
		 *  Save cart.
		 */
		
		return new ObjectMapper().writeValueAsString(order);
	}

	private Product retriveProduct(String productCode) throws Exception {
		
		return persistenceHelper.findByProductCode(productCode);
	}

}
