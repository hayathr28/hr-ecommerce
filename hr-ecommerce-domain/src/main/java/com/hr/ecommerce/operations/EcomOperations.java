package com.hr.ecommerce.operations;

import com.hr.ecommerce.request.CreateProductRequest;

public interface EcomOperations {
	public String saveProduct(CreateProductRequest productrequest);
	public String retrieveProduct();
	
	

}
