package com.hr.ecommerce.api.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/ecom/catalog", produces = MediaType.APPLICATION_JSON_VALUE)
public class CatalogController {
	@PostMapping("/product")
	public String createproduct() {
		String response = "success";
		return response;
	}

}
