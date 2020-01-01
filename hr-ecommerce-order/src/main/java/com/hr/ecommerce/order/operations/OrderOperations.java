package com.hr.ecommerce.order.operations;

import com.hr.ecommerce.rquest.beans.AddToCartRequest;
import com.hr.ecommerce.rquest.beans.ShippingAddressReqBean;

public interface OrderOperations {
	
	public String addToCart(AddToCartRequest addToCartRequest) throws Exception;
	public String addShipping(String orderId, ShippingAddressReqBean shippingAddressBean) throws Exception;
	public String retrieveCart(String orderId) throws Exception;
	/**
	 * Services for calculating order inlcuding shipping and taxes
	 * @param orderId
	 * @return
	 * @throws Exception
	 */
	public String calculateOrder(String orderId) throws Exception;

}
