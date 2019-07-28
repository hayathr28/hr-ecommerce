package com.hr.ecommerce.persistence.helper;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hr.ecommerce.model.Product;
import com.hr.ecommerce.product.MongoProductRepository;

@Service
public class PersistenceHelperImpl implements PersistenceHelper {

	@Autowired
	private MongoProductRepository prodrep;

	public Product saveProduct(Product prod) throws Exception {

		try {
			prodrep.save(prod);
		} catch (Exception e) {
			throw e;
		}

		return prod;
	}

	public Product retrieveProduct(String productId) throws Exception {

		try {

			Optional<Product> response = prodrep.findById(productId);
			if (!response.isPresent()) {
				throw new Exception("Product not found");
			}
			return response.get();
		} catch (Exception e) {
			throw e;
		}
	}

}
