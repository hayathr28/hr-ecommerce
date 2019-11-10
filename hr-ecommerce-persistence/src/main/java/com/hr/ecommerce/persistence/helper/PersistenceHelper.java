package com.hr.ecommerce.persistence.helper;

import com.hr.ecommerce.model.Product;
import com.hr.ecommerce.order.model.Order;

public interface PersistenceHelper {
	public Product saveProduct(Product prod) throws Exception;
	
	public Product retrieveProduct(String productCode) throws Exception;
	
	public Product findByProductCode(String productCode) throws Exception;
	
	public Order saveOrder(Order order) throws Exception;
	
	public Order retrieveOrder(String orderId) throws Exception;

}
