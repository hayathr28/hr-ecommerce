package com.hr.ecommerce.api.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hr.ecommerce.request.CreateProductRequest;

@RestController
@RequestMapping(value = "/ecom/catalog", produces = MediaType.APPLICATION_JSON_VALUE)
public class CatalogController {
	@PostMapping("/product")
	public String createproduct(@RequestBody CreateProductRequest productrequest) throws Exception {
		System.out.println(productrequest);
		String response = "success";
		return response;
		
	}

}
