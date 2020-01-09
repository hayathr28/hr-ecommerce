package com.hr.ecommerce.order.calculation;

import java.math.RoundingMode;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hr.ecommerce.common.EnterpriseServices;
import com.hr.ecommerce.common.HREcommerceErrorConstants;
import com.hr.ecommerce.common.OrderStatusValidationUtil;
import com.hr.ecommerce.common.OrderUtils;
import com.hr.ecommerce.exception.HREcommerceExceptionFactory;
import com.hr.ecommerce.order.common.DBUtils;
import com.hr.ecommerce.order.model.Address;
import com.hr.ecommerce.order.model.Order;
import com.hr.ecommerce.order.model.OrderItem;
import com.hr.ecommerce.order.model.ShippingCharge;
import com.hr.ecommerce.order.model.Tax;
import com.hr.ecommerce.shipping.ShippingChargeResponseBean;
import com.hr.ecommerce.taxes.TaxResponseBean;

@Service
public class CalculateOrderTask {
	
	@Autowired
	private HREcommerceExceptionFactory exceptionFactory;
	
	@Autowired
	private EnterpriseServices enterpriseServices;
	
	@Autowired
	private PrepareOrderTask prepareOrderTask;
	
	
	public String calculateOrder(String orderId) throws Exception {
		
		Order order = null;
		
		/**
		 * Retrieve order from database
		 */
		if(StringUtils.isNotEmpty(orderId)){
			order = DBUtils.retrieveOrder(orderId);
		}
		if(null!=order) {
			/**
			 * 
			 * validate order before processing it further
			 */
			validateOrder(order);
			/**
			 * Calculate Shipping
			 */
			 Map<String,ShippingChargeResponseBean> shippingCharges = enterpriseServices.calculateShipping(order);
			 processShipping(order,shippingCharges);
			 
			 /**
			  * Calculate Taxes
			  */
			 Map<String,TaxResponseBean> taxes = enterpriseServices.calculateTaxes(order);
			 processTaxes(order,taxes);
			 order = prepareOrderTask.prepareOrder(order);
			 DBUtils.saveOrder(order);
			 
		} else {
			throw exceptionFactory.createException(HREcommerceErrorConstants.ERROR_ORDER_DOES_NOT_EXIST,new Object[] {orderId});
		}
		
		
		return "SUCCESS";
		
		
	}
    
	private void validateOrder(Order order) {
		
		 OrderStatusValidationUtil.isOrderInRightState(order);	
	     List<OrderItem> orderItems = order.getOrderItems();
	     if(null==orderItems || orderItems.isEmpty()) {
	    	 throw exceptionFactory.createException(HREcommerceErrorConstants.ORDER_HAS_NO_ITEMS);
	     }	 
	      for(OrderItem orderItem : orderItems) {
	    	  if(null==orderItem.getAddress() || hasPartialAddress(orderItem.getAddress())) 
	    		  throw exceptionFactory.createException(HREcommerceErrorConstants.ITEM_HAS_INCOMPLETE_ADDRESS);  
	      }
		}

		private boolean hasPartialAddress(Address address) {
			
			return StringUtils.isEmpty(address.getAddress1())
					|| StringUtils.isEmpty(address.getCity())
					|| StringUtils.isEmpty(address.getState())
					|| StringUtils.isEmpty(address.getPinCode())
					|| StringUtils.isEmpty(address.getFirstName())
					|| StringUtils.isEmpty(address.getLastName());
		}

	private void processTaxes(Order order, Map<String, TaxResponseBean> taxes) {
		if(taxes!=null) {
	    	for(OrderItem orderItem : order.getOrderItems()) {
	    		if(taxes.containsKey(orderItem.getOrderItemId())) {
	    			TaxResponseBean taxResponse = taxes.get(orderItem.getOrderItemId());
	    			orderItem.setTax(getCalculatedTaxes(taxResponse));
	    		}
	    	}
	    }
		
	}


	private Tax getCalculatedTaxes(TaxResponseBean taxResponse) {
		Tax tax = new Tax();
		BeanUtils.copyProperties(taxResponse, tax);
		tax.setTotalTax(OrderUtils.convertAmount(tax.getMerchandiseTax()).add(OrderUtils.convertAmount(tax.getShippingTax())).setScale(2, RoundingMode.HALF_DOWN).toPlainString());
		return tax;
	}


	private void processShipping(Order order, Map<String, ShippingChargeResponseBean> shippingCharges) {
		
	    if(shippingCharges!=null) {
	    	for(OrderItem orderItem : order.getOrderItems()) {
	    		if(shippingCharges.containsKey(orderItem.getOrderItemId())) {
	    			ShippingChargeResponseBean shippingResponse = shippingCharges.get(orderItem.getOrderItemId());
	    			orderItem.setShippingCharge(getShippingCharges(shippingResponse));
	    		}
	    	}
	    }
		
	}


	private ShippingCharge getShippingCharges(ShippingChargeResponseBean shippingResponse) {
		ShippingCharge shippingCharge = new ShippingCharge();
		BeanUtils.copyProperties(shippingResponse, shippingCharge);
		shippingCharge.setTotalShipping(OrderUtils.convertAmount(shippingCharge.getBaseCharge()).add(OrderUtils.convertAmount(shippingCharge.getUpCharge())).setScale(2, RoundingMode.HALF_DOWN).toPlainString());
		return shippingCharge;
	}


	
}
