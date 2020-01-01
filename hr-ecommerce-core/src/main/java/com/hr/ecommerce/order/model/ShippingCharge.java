package com.hr.ecommerce.order.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "baseCharge", "upCharge", "shippingMethod","totalShipping" })
public class ShippingCharge {

	@JsonProperty("baseCharge")
	private String baseCharge;
	@JsonProperty("upCharge")
	private String upCharge;
	@JsonProperty("shippingMethod")
	private String shippingMethod;
	
	@JsonProperty("totalShipping")
	private String totalShipping;

	@JsonProperty("baseCharge")
	public String getBaseCharge() {
		return baseCharge;
	}

	@JsonProperty("baseCharge")
	public void setBaseCharge(String baseCharge) {
		this.baseCharge = baseCharge;
	}

	@JsonProperty("upCharge")
	public String getUpCharge() {
		return upCharge;
	}

	@JsonProperty("upCharge")
	public void setUpCharge(String upCharge) {
		this.upCharge = upCharge;
	}

	@JsonProperty("shippingMethod")
	public String getShippingMethod() {
		return shippingMethod;
	}

	@JsonProperty("shippingMethod")
	public void setShippingMethod(String shippingMethod) {
		this.shippingMethod = shippingMethod;
	}
	@JsonProperty("totalShipping")
	public String getTotalShipping() {
		return totalShipping;
	}
	@JsonProperty("totalShipping")
	public void setTotalShipping(String totalShipping) {
		this.totalShipping = totalShipping;
	}

}