package com.hr.ecommerce.persistence.helper;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hr.ecommerce.model.Product;
import com.hr.ecommerce.order.model.Order;
import com.hr.ecommerce.product.MongoOrderRepository;
import com.hr.ecommerce.product.MongoProductRepository;

@Service
public class PersistenceHelperImpl implements PersistenceHelper{

	@Autowired
	private MongoProductRepository prodrep;
	
	@Autowired
	private MongoOrderRepository orderRep;
	
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

public Order saveOrder(Order order) throws Exception {
	try {
		orderRep.save(order);
	} 
	catch (Exception e) {
		throw e;
	}
	
	return order;
}

public Order retrieveOrder(String orderId) throws Exception {
	Optional<Order> response = orderRep.findById(new Long(orderId));
	return response.get();
}

}
