package com.hr.ecommerce.order;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hr.ecommerce.common.HREcommerceErrorConstants;
import com.hr.ecommerce.exception.HREcommerceExceptionFactory;
import com.hr.ecommerce.order.common.DBUtils;
import com.hr.ecommerce.order.model.Order;

@Service
public class RetrieveOrderTask {
	
	@Autowired
	private HREcommerceExceptionFactory exceptionFactory;
	
	public String retrieveOrder(String orderId) throws Exception{
		
		if(StringUtils.isEmpty(orderId)) {
			throw exceptionFactory.createException(HREcommerceErrorConstants.ERROR_ORDER_DOES_NOT_EXIST,new Object[] {orderId});
		}
		Order order = DBUtils.retrieveOrder(orderId);
		return new ObjectMapper().writeValueAsString(order);
	}

}
