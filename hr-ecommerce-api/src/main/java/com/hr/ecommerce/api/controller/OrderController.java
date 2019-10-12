package com.hr.ecommerce.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hr.ecommerce.order.operations.OrderOperations;
import com.hr.ecommerce.rquest.beans.AddToCartRequest;

@RestController
@RequestMapping(value = "/ecom/order", produces = MediaType.APPLICATION_JSON_VALUE)
public class OrderController {
	
	 @Autowired
		private OrderOperations orderOps;
		
		@PostMapping("/addtocart")
		public String addToCart(@RequestBody AddToCartRequest addToCartRequest) throws Exception {
			String response;
			try{
				
				
				response = orderOps.addToCart(addToCartRequest);
				
			}
			catch(Exception e){
				throw e;
			}
			return response;
			
		}

}
