package com.hr.ecommerce.order.common;
import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.hr.ecommerce.order.model.Order;
import com.hr.ecommerce.order.model.Product;
import com.hr.ecommerce.persistence.helper.PersistenceHelper;

@Component
public class DBUtils {
	
	
	private static PersistenceHelper persistenceHelper;
	
	@Autowired
	private PersistenceHelper aPersistenceHelper;
	
	@PostConstruct
	public void init() {
		setPersistenceHelper(aPersistenceHelper);
	}

    public static Order saveOrder(Order order) throws Exception {
    	return persistenceHelper.saveOrder(order);
    }
    
    public static Order retrieveOrder(String orderId) throws Exception {
    	return persistenceHelper.retrieveOrder(orderId);
    }
    
    public static com.hr.ecommerce.model.Product  retriveProduct(String productCode) throws Exception {
    	return persistenceHelper.findByProductCode(productCode);
    }

	public static void setPersistenceHelper(PersistenceHelper persistenceHelper) {
		DBUtils.persistenceHelper = persistenceHelper;
	}
	

}
