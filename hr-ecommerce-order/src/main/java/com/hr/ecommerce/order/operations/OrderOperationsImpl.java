package com.hr.ecommerce.order.operations;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hr.ecommerce.common.HREcommerceErrorConstants;
import com.hr.ecommerce.exception.HREcommerceExceptionFactory;
import com.hr.ecommerce.model.Product;
import com.hr.ecommerce.order.model.Address;
import com.hr.ecommerce.order.model.Order;
import com.hr.ecommerce.order.model.OrderItem;
import com.hr.ecommerce.order.tasks.OrderCreationFactory;
import com.hr.ecommerce.persistence.helper.PersistenceHelper;
import com.hr.ecommerce.rquest.beans.AddToCartRequest;
import com.hr.ecommerce.rquest.beans.ShippingAddress;
import com.hr.ecommerce.rquest.beans.ShippingAddressReqBean;

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

	public String addShipping(String orderId, ShippingAddressReqBean shippingAddressBean) throws Exception {
		
		Order order= persistenceHelper.retrieveOrder(orderId);
		
		if(null==order) {
			throw exceptionFactory.createException(HREcommerceErrorConstants.ERROR_ORDER_DOES_NOT_EXIST,new Object[] {orderId});
		}
		OrderItem orderItem = getOrderItemFromOrder(shippingAddressBean.getOrderItemId(),order);
		
		if(null==orderItem) {
			throw exceptionFactory.createException(HREcommerceErrorConstants.ERROR_ORDERITEM_DOES_NOT_EXIST,new Object[] {shippingAddressBean.getOrderItemId()});
		}
		orderItem.setAddress(processAddress(shippingAddressBean.getShippingAddress()));
		persistenceHelper.saveOrder(order);
		return "SUCCESS";
	}

	private Address processAddress(ShippingAddress shippingAddress) {
		Address address= new Address();
		BeanUtils.copyProperties(shippingAddress, address);
		return address;
	}

	private OrderItem getOrderItemFromOrder(String orderItemId, Order order) {
		
		for(OrderItem orderItem : order.getOrderItems()) {
			if(StringUtils.equalsIgnoreCase(orderItemId, orderItem.getOrderItemId()))
				return orderItem;
		}
		
		return null;
	}

	public String retrieveCart(String orderId) throws Exception {
		
		if(StringUtils.isEmpty(orderId)) {
			throw exceptionFactory.createException(HREcommerceErrorConstants.ERROR_ORDER_DOES_NOT_EXIST,new Object[] {orderId});
		}
		Order order = persistenceHelper.retrieveOrder(orderId);
		return new ObjectMapper().writeValueAsString(order);
	}

}
