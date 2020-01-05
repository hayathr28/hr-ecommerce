package com.hr.ecommerce.common;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hr.ecommerce.order.model.AppliedPayment;
import com.hr.ecommerce.order.model.Order;
import com.hr.ecommerce.rquest.beans.SubmitOrderReqBean;
import com.hr.ecommerce.services.CreditCardAuthorizationService;
import com.hr.ecommerce.services.GiftCardAuthorizationService;
import com.hr.ecommerce.services.ShippingService;
import com.hr.ecommerce.services.TaxService;
import com.hr.ecommerce.shipping.ShippingChargeResponseBean;
import com.hr.ecommerce.taxes.TaxResponseBean;

@Service
public class EnterpriseServicesImpl implements EnterpriseServices {

	@Autowired
	private ShippingService shippingService;
	
	@Autowired
	private TaxService taxService;
	
	@Autowired
	private CreditCardAuthorizationService creditCardAuthorizationService;
	
	@Autowired
	private GiftCardAuthorizationService giftCardAuthorizationService;
	
	public  Map<String,ShippingChargeResponseBean> calculateShipping(Order order) {
	   
		return shippingService.calculateShipping(order);
	}

	public Map<String, TaxResponseBean> calculateTaxes(Order order) {
		
		return taxService.calculateTaxes(order);
	}

	public AppliedPayment authorizeCreditCard(AppliedPayment appliedPayment, SubmitOrderReqBean submitOrderReqBean) {
		
		return creditCardAuthorizationService.authorizeCC(appliedPayment, submitOrderReqBean);
	}

	public AppliedPayment authorizeGiftCard(AppliedPayment appliedPayment, SubmitOrderReqBean submitOrderReqBean) {
		
		return giftCardAuthorizationService.authorizeGC(appliedPayment, submitOrderReqBean);
	}

}
