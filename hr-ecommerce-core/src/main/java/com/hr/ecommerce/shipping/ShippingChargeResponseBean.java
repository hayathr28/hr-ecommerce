package com.hr.ecommerce.shipping;

public class ShippingChargeResponseBean {
	
	
	private String baseCharge;

	private String upCharge;

	private String shippingMethod;

	public String getBaseCharge() {
		return baseCharge;
	}

	public void setBaseCharge(String baseCharge) {
		this.baseCharge = baseCharge;
	}

	public String getUpCharge() {
		return upCharge;
	}

	public void setUpCharge(String upCharge) {
		this.upCharge = upCharge;
	}

	public String getShippingMethod() {
		return shippingMethod;
	}

	public void setShippingMethod(String shippingMethod) {
		this.shippingMethod = shippingMethod;
	}
}
