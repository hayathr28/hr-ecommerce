package com.hr.ecommerce.rquest.beans;

import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "orderItemId", "calculateOrder" })
public class RemoveItemReqBean {
    @NotEmpty(message="orderItemId can not be empty.")
	@JsonProperty("orderItemId")
	private String orderItemId;
	@JsonProperty("calculateOrder")
	private Boolean calculateOrder;

	@JsonProperty("orderItemId")
	public String getOrderItemId() {
		return orderItemId;
	}

	@JsonProperty("orderItemId")
	public void setOrderItemId(String orderItemId) {
		this.orderItemId = orderItemId;
	}

	@JsonProperty("calculateOrder")
	public Boolean getCalculateOrder() {
		return calculateOrder;
	}

	@JsonProperty("calculateOrder")
	public void setCalculateOrder(Boolean calculateOrder) {
		this.calculateOrder = calculateOrder;
	}

}