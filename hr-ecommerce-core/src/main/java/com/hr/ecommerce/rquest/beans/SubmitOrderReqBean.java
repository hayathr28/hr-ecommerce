package com.hr.ecommerce.rquest.beans;

import javax.validation.Valid;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "customer", "payment" })
public class SubmitOrderReqBean {
	@Valid
	@JsonProperty("customer")
	private Customer customer;
	@Valid
	@JsonProperty("payment")
	private Payment payment;

	@JsonProperty("customer")
	public Customer getCustomer() {
		return customer;
	}

	@JsonProperty("customer")
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	@JsonProperty("payment")
	public Payment getPayment() {
		return payment;
	}

	@JsonProperty("payment")
	public void setPayment(Payment payment) {
		this.payment = payment;
	}

}