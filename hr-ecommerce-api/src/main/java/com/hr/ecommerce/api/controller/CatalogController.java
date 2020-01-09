package com.hr.ecommerce.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hr.ecommerce.operations.EcomOperations;
import com.hr.ecommerce.request.CreateProductRequest;

@RestController
@RequestMapping(value = "/ecom/catalog", produces = MediaType.APPLICATION_JSON_VALUE)
public class CatalogController {
    @Autowired
	private EcomOperations ecomops;
	
	@PostMapping("/product")
	public String createproduct(@RequestBody CreateProductRequest productrequest) throws Exception {
		String response;
		try{
			
			System.out.println(productrequest);
			response = ecomops.saveProduct(productrequest);
			
		}
		catch(Exception e){
			throw e;
		}
		return response;
		
	}
	
	@GetMapping("/product/{productCode}")
	public String retrieveProduct(@PathVariable("productCode") String productCode) throws Exception {
		String response;
		try{
			
			System.out.println(productCode);
			response = ecomops.retrieveProduct(productCode);
			
		}
		catch(Exception e){
			throw e;
		}
		return response;
		
	}

}
