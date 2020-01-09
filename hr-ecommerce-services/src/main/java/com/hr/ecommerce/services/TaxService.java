package com.hr.ecommerce.services;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import com.hr.ecommerce.order.model.Order;
import com.hr.ecommerce.order.model.OrderItem;
import com.hr.ecommerce.taxes.TaxResponseBean;

@Service
public class TaxService {
	
	public Map<String, TaxResponseBean> calculateTaxes(Order order){
		return caluclateFakeTaxes(order);
	}

	private Map<String, TaxResponseBean> caluclateFakeTaxes(Order order) {
		Map<String, TaxResponseBean> taxes = new HashMap<String, TaxResponseBean>();
		
		for(OrderItem orderItem: order.getOrderItems()) {
			if(canCalculateTaxes(orderItem))
				taxes.put(orderItem.getOrderItemId(), fakeTaxes());
		}
		
		return taxes;
	}
	
	private TaxResponseBean fakeTaxes() {
		TaxResponseBean taxBean = new TaxResponseBean();
		taxBean.setMerchandiseTax("3.89");
		taxBean.setShippingTax("1.98");
		return taxBean;
	}

	private boolean canCalculateTaxes(OrderItem orderItem) {
		return orderItem.getAddress() !=null && StringUtils.isNotEmpty(orderItem.getAddress().getPinCode()); 
		
	}


}
