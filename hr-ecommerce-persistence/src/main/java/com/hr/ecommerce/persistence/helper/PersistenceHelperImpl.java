package com.hr.ecommerce.persistence.helper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hr.ecommerce.model.Product;
import com.hr.ecommerce.product.MongoProductRepository;
@Service
public class PersistenceHelperImpl implements PersistenceHelper{

	@Autowired
	private MongoProductRepository prodrep;
	public Product saveProduct(Product prod) {
		
		try {
			prodrep.save(prod);
		} 
		catch (Exception e) {
			
		}
		
		return prod;
	}

}
