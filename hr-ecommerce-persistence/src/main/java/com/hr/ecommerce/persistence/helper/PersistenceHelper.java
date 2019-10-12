package com.hr.ecommerce.persistence.helper;

import com.hr.ecommerce.model.Product;

public interface PersistenceHelper {
	public Product saveProduct(Product prod) throws Exception;
	
	public Product retrieveProduct(String productCode) throws Exception;
	
	public Product findByProductCode(String productCode) throws Exception;

}
