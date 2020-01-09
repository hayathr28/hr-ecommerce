package com.hr.ecommerce.order.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "merchandiseTax", "shippingTax", "totalTax" })
public class Tax {

	@JsonProperty("merchandiseTax")
	private String merchandiseTax;
	@JsonProperty("shippingTax")
	private String shippingTax;
	@JsonProperty("totalTax")
	private String totalTax;

	@JsonProperty("merchandiseTax")
	public String getMerchandiseTax() {
		return merchandiseTax;
	}

	@JsonProperty("merchandiseTax")
	public void setMerchandiseTax(String merchandiseTax) {
		this.merchandiseTax = merchandiseTax;
	}

	@JsonProperty("shippingTax")
	public String getShippingTax() {
		return shippingTax;
	}

	@JsonProperty("shippingTax")
	public void setShippingTax(String shippingTax) {
		this.shippingTax = shippingTax;
	}

	@JsonProperty("totalTax")
	public String getTotalTax() {
		return totalTax;
	}

	@JsonProperty("totalTax")
	public void setTotalTax(String totalTax) {
		this.totalTax = totalTax;
	}

}