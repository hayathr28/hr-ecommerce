package com.hr.ecommerce.order.operations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hr.ecommerce.order.AddShippingTask;
import com.hr.ecommerce.order.CreateOrderTask;
import com.hr.ecommerce.order.RemoveOrderItemTask;
import com.hr.ecommerce.order.RetrieveOrderTask;
import com.hr.ecommerce.order.SubmitOrderTask;
import com.hr.ecommerce.order.calculation.CalculateOrderTask;
import com.hr.ecommerce.order.model.Order;
import com.hr.ecommerce.rquest.beans.AddToCartRequest;
import com.hr.ecommerce.rquest.beans.RemoveItemReqBean;
import com.hr.ecommerce.rquest.beans.ShippingAddressReqBean;
import com.hr.ecommerce.rquest.beans.SubmitOrderReqBean;

@Service
public class OrderOperationsImpl implements OrderOperations {

	@Autowired
	private CalculateOrderTask calculateOrderTask;

	@Autowired
	private CreateOrderTask createOrderTask;

	@Autowired
	private AddShippingTask addShippingTask;

	@Autowired
	private RetrieveOrderTask retrieveOrderTask;
	
	@Autowired
	private SubmitOrderTask submitOrderTask;
	
	@Autowired
	private RemoveOrderItemTask removeOrderItemTask;

	public String addToCart(AddToCartRequest addToCartRequest) throws Exception {

		Order order = createOrderTask.createOrder(addToCartRequest);

		return new ObjectMapper().writeValueAsString(order);
	}

	public String addShipping(String orderId, ShippingAddressReqBean shippingAddressBean) throws Exception {

		return addShippingTask.saveShippingAddress(orderId, shippingAddressBean);
	}

	public String retrieveCart(String orderId) throws Exception {

		return retrieveOrderTask.retrieveOrder(orderId);
	}

	public String calculateOrder(String orderId) throws Exception {

		return calculateOrderTask.calculateOrder(orderId);
	}

	public String submitOrder(String orderId,SubmitOrderReqBean submitOrderReqBean) throws Exception {
	
		return submitOrderTask.submitOrder(orderId, submitOrderReqBean);
	}

	public String deleteOrderItem(String orderId, RemoveItemReqBean removeItemRequestBean) throws Exception {
		
		return removeOrderItemTask.deleteOrderItem(orderId, removeItemRequestBean);
	}

}
