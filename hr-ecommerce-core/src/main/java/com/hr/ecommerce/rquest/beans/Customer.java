package com.hr.ecommerce.rquest.beans;

import javax.validation.Valid;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "billingAddress", "emailOptIn", "smsOptIn" })
public class Customer {
    @Valid
	@JsonProperty("billingAddress")
	private BillingAddress billingAddress;
	@JsonProperty("emailOptIn")
	private Boolean emailOptIn;
	@JsonProperty("smsOptIn")
	private Boolean smsOptIn;

	@JsonProperty("billingAddress")
	public BillingAddress getBillingAddress() {
		return billingAddress;
	}

	@JsonProperty("billingAddress")
	public void setBillingAddress(BillingAddress billingAddress) {
		this.billingAddress = billingAddress;
	}

	@JsonProperty("emailOptIn")
	public Boolean getEmailOptIn() {
		return emailOptIn;
	}

	@JsonProperty("emailOptIn")
	public void setEmailOptIn(Boolean emailOptIn) {
		this.emailOptIn = emailOptIn;
	}

	@JsonProperty("smsOptIn")
	public Boolean getSmsOptIn() {
		return smsOptIn;
	}

	@JsonProperty("smsOptIn")
	public void setSmsOptIn(Boolean smsOptIn) {
		this.smsOptIn = smsOptIn;
	}

}