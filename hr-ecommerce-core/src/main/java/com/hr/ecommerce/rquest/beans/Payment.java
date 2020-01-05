package com.hr.ecommerce.rquest.beans;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "paymentMethod", "accountNumber", "brand", "cvv", "expirationMonth", "expirationYear",
		"nameOnCreditCard" })
public class Payment {

	@NotEmpty(message="payment method is required field.")
	@JsonProperty("paymentMethod")
	private String paymentMethod;
	@JsonProperty("accountNumber")
	private String accountNumber;
	@JsonProperty("brand")
	private String brand;
	@Pattern(regexp="(^[0-9]{3,4}$|^$)",message="Invalid cvv number")
	@JsonProperty("cvv")
	private String cvv;
	@Pattern(regexp="(^(0[1-9]|1[012])$|^$)",message="Invalid card expiry month")
	@JsonProperty("expirationMonth")
	private String expirationMonth;
	@Pattern(regexp="(^[0-9]{4}$|^$)",message="Invalid card expiry year. Year should be in yyyy format.")
	@JsonProperty("expirationYear")
	private String expirationYear;
	@JsonProperty("nameOnCreditCard")
	private String nameOnCreditCard;

	@JsonProperty("paymentMethod")
	public String getPaymentMethod() {
		return paymentMethod;
	}

	@JsonProperty("paymentMethod")
	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	@JsonProperty("accountNumber")
	public String getAccountNumber() {
		return accountNumber;
	}

	@JsonProperty("accountNumber")
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	@JsonProperty("brand")
	public String getBrand() {
		return brand;
	}

	@JsonProperty("brand")
	public void setBrand(String brand) {
		this.brand = brand;
	}

	@JsonProperty("cvv")
	public String getCvv() {
		return cvv;
	}
	
	@JsonProperty("cvv")
	public void setCvv(String cvv) {
		this.cvv = cvv;
	}

	@JsonProperty("expirationMonth")
	public String getExpirationMonth() {
		return expirationMonth;
	}

	@JsonProperty("expirationMonth")
	public void setExpirationMonth(String expirationMonth) {
		this.expirationMonth = expirationMonth;
	}

	@JsonProperty("expirationYear")
	public String getExpirationYear() {
		return expirationYear;
	}

	@JsonProperty("expirationYear")
	public void setExpirationYear(String expirationYear) {
		this.expirationYear = expirationYear;
	}

	@JsonProperty("nameOnCreditCard")
	public String getNameOnCreditCard() {
		return nameOnCreditCard;
	}

	@JsonProperty("nameOnCreditCard")
	public void setNameOnCreditCard(String nameOnCreditCard) {
		this.nameOnCreditCard = nameOnCreditCard;
	}

}