package com.hr.ecommerce.order.model;

public class AppliedPayment {
	
	private String paymentMethod;
	private String paymentStatus;
	private String trandactionId;
	private String approvedAmount;
	private String requestedAmount;
	private String authCode;
	private String avsValue;
	
	public String getPaymentMethod() {
		return paymentMethod;
	}
	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}
	public String getPaymentStatus() {
		return paymentStatus;
	}
	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}
	public String getTrandactionId() {
		return trandactionId;
	}
	public void setTrandactionId(String trandactionId) {
		this.trandactionId = trandactionId;
	}
	public String getApprovedAmount() {
		return approvedAmount;
	}
	public void setApprovedAmount(String approvedAmount) {
		this.approvedAmount = approvedAmount;
	}
	public String getAuthCode() {
		return authCode;
	}
	public void setAuthCode(String authCode) {
		this.authCode = authCode;
	}
	public String getAvsValue() {
		return avsValue;
	}
	public void setAvsValue(String avsValue) {
		this.avsValue = avsValue;
	}
	public String getRequestedAmount() {
		return requestedAmount;
	}
	public void setRequestedAmount(String requestedAmount) {
		this.requestedAmount = requestedAmount;
	}
	

}
