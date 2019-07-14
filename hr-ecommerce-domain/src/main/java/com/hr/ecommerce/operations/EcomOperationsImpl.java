package com.hr.ecommerce.operations;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.hr.ecommerce.model.Product;
import com.hr.ecommerce.request.CreateProductRequest;

@Service
public class EcomOperationsImpl implements EcomOperations {

	public String retrieveProduct() {
		
		return null;
	}

	public String saveProduct(CreateProductRequest productrequest) {
		Product prod = new Product();
		BeanUtils.copyProperties(productrequest, prod );
		return null;
	}

}
