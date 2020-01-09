package com.hr.ecommerce.order.operations;

import com.hr.ecommerce.rquest.beans.AddToCartRequest;
import com.hr.ecommerce.rquest.beans.RemoveItemReqBean;
import com.hr.ecommerce.rquest.beans.ShippingAddressReqBean;
import com.hr.ecommerce.rquest.beans.SubmitOrderReqBean;

public interface OrderOperations {
	
	public String addToCart(AddToCartRequest addToCartRequest) throws Exception;
	/**
	 * Adds shipping address to the items in the order
	 * @param orderId
	 * @param shippingAddressBean
	 * @return
	 * @throws Exception
	 */
	public String addShipping(String orderId, ShippingAddressReqBean shippingAddressBean) throws Exception;
	/**
	 * retrieves order information from database.
	 * @param orderId
	 * @return
	 * @throws Exception
	 */
	public String retrieveCart(String orderId) throws Exception;
	/**
	 * Services for calculating order inlcuding shipping and taxes
	 * @param orderId
	 * @param submitOrderReqBean 
	 * @return
	 * @throws Exception
	 */
	public String calculateOrder(String orderId ) throws Exception;
	/**
	 * Validates payment and completes an orders.
	 * @param orderId
	 * @return
	 * @throws Exception
	 */
	public String submitOrder(String orderId,SubmitOrderReqBean submitOrderReqBean) throws Exception;
	/**
	 * Removes item form order.
	 * @throws Exception 
	 */
	public String deleteOrderItem(String orderId, RemoveItemReqBean removeItemRequestBean) throws Exception;

}
