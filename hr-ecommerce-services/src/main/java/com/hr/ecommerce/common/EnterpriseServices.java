package com.hr.ecommerce.common;

import java.util.Map;

import com.hr.ecommerce.order.model.Order;
import com.hr.ecommerce.shipping.ShippingChargeResponseBean;
import com.hr.ecommerce.taxes.TaxResponseBean;

public interface EnterpriseServices {
	
	/**
	 * calculates shipping charges for order
	 * @param order
	 * @return
	 */
	public Map<String,ShippingChargeResponseBean> calculateShipping(Order order);
	
	/**
	 * Calculates taxes for order
	 * @param order
	 * @return
	 */
	
	public Map<String,TaxResponseBean> calculateTaxes(Order order);

}
