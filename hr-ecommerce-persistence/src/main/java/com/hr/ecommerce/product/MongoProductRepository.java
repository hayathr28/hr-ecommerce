package com.hr.ecommerce.product;



import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.hr.ecommerce.model.Product;


public interface MongoProductRepository extends MongoRepository<Product, String> {
	
	public List<Product> findByProductCode(String productCode);

}