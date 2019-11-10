package com.hr.ecommerce.rquest.beans;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "orderItemId", "shippingAddress" })
public class ShippingAddressReqBean {

	@JsonProperty("orderItemId")
	@NotEmpty(message="OrderItemId can not be null.")
	private String orderItemId;
	@JsonProperty("shippingAddress")
	@Valid
	private ShippingAddress shippingAddress;

	@JsonProperty("orderItemId")
	public String getOrderItemId() {
		return orderItemId;
	}

	@JsonProperty("orderItemId")
	public void setOrderItemId(String orderItemId) {
		this.orderItemId = orderItemId;
	}

	@JsonProperty("shippingAddress")
	public ShippingAddress getShippingAddress() {
		return shippingAddress;
	}

	@JsonProperty("shippingAddress")
	public void setShippingAddress(ShippingAddress shippingAddress) {
		this.shippingAddress = shippingAddress;
	}

}