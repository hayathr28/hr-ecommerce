package com.hr.ecommerce.common;

import java.util.Map;

import com.hr.ecommerce.order.model.AppliedPayment;
import com.hr.ecommerce.order.model.Order;
import com.hr.ecommerce.rquest.beans.SubmitOrderReqBean;
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
	/**
	 * Authorize payment with credit card.
	 * @param appliedPayment
	 * @param submitOrderReqBean
	 * @return
	 */
	public AppliedPayment authorizeCreditCard(AppliedPayment appliedPayment, SubmitOrderReqBean submitOrderReqBean);
	
	/**
	 * Authorize payment with gift card.
	 * @param appliedPayment
	 * @param submitOrderReqBean
	 * @return
	 */
	
	public AppliedPayment authorizeGiftCard(AppliedPayment appliedPayment, SubmitOrderReqBean submitOrderReqBean);

}
