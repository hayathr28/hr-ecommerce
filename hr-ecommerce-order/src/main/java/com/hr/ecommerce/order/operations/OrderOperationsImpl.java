package com.hr.ecommerce.order.operations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hr.ecommerce.model.Product;
import com.hr.ecommerce.persistence.helper.PersistenceHelper;
import com.hr.ecommerce.rquest.beans.AddToCartRequest;

@Service
public class OrderOperationsImpl implements OrderOperations {
	
	@Autowired
	private PersistenceHelper persistenceHelper;

	public String addToCart(AddToCartRequest addToCartRequest) throws Exception {
		
		/**
		 * Step1 : get the product information from the catalog
		 */
		Product product = retriveProduct(addToCartRequest.getProductCode());
		
		/**
		 * Check if product is still buyable
		 */
		
		/**
		 * If product is buyable then add it to cart
		 */
		
		/**
		 * Create an object of cart with product information.
		 */
		
		/**
		 *  Save cart.
		 */
		
		return null;
	}

	private Product retriveProduct(String productCode) throws Exception {
		
		return persistenceHelper.findByProductCode(productCode);
	}

}
