package com.hr.ecommerce.exception;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class HRECommerceErrorResponse {

	private String timeStamp;
	private String errorMessage;
	private int errorCode;
	
	public HRECommerceErrorResponse() {
		
	}
	
public HRECommerceErrorResponse(String errorMessage, int erroCode) {
	
	this.timeStamp = new SimpleDateFormat("dd-MMM-yyyy").format(Calendar.getInstance().getTime());
	this.errorMessage=errorMessage;
	this.errorCode = errorCode;
	
		
}
	

	public String getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(String timeStamp) {
		this.timeStamp = timeStamp;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public int getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}

}
