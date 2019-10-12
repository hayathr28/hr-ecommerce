package com.hr.ecommerce.persistence.helper;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hr.ecommerce.model.Product;
import com.hr.ecommerce.product.MongoProductRepository;

@Service
public class PersistenceHelperImpl implements PersistenceHelper{

	@Autowired
	private MongoProductRepository prodrep;
	
	public Product saveProduct(Product prod) throws Exception {
		
		try {
			prodrep.save(prod);
		} 
		catch (Exception e) {
			throw e;
		}
		
		return prod;
	}

	public Product retrieveProduct(String productCode) throws Exception {
		
		Optional<Product> response = prodrep.findById(productCode);
		return response.get();
	}
	
public Product findByProductCode(String productCode) throws Exception {
	    List<Product>  products = prodrep.findByProductCode(productCode);
		return (null!=products && !products.isEmpty()) ? products.get(0) : null;
	}

}
