package com.hr.ecommerce.api.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hr.ecommerce.order.operations.OrderOperations;
import com.hr.ecommerce.rquest.beans.AddToCartRequest;
import com.hr.ecommerce.rquest.beans.ShippingAddressReqBean;

@RestController
@RequestMapping(value = "/ecom", produces = MediaType.APPLICATION_JSON_VALUE)
public class OrderController {

	@Autowired
	private OrderOperations orderOps;

	@PostMapping("/order/addtocart")
	public String addToCart(@Valid @RequestBody AddToCartRequest addToCartRequest) throws Exception {
		String response;
		try {

			response = orderOps.addToCart(addToCartRequest);

		} catch (Exception e) {
			throw e;
		}
		return response;

	}
	
	@GetMapping("/order/{orderId}")
	public String addToCart(@PathVariable("orderId") String orderId) throws Exception {
		String response;
		try {

			response = orderOps.retrieveCart(orderId);

		} catch (Exception e) {
			throw e;
		}
		return response;

	}
	
	@PostMapping("order/{orderId}/addshipping")
	public String addShipping(@PathVariable("orderId") String orderId, @Valid @RequestBody ShippingAddressReqBean shippingAdressBean) throws Exception {
		String response;
		try {

			response = orderOps.addShipping(orderId,shippingAdressBean);

		} catch (Exception e) {
			throw e;
		}
		return response;

	}
	
	@PutMapping("order/{orderId}/calculate")
	public String calulateOrder(@PathVariable("orderId") String orderId) throws Exception {
		String response;
		try {

			response = orderOps.calculateOrder(orderId);

		} catch (Exception e) {
			throw e;
		}
		return response;

	}

}
