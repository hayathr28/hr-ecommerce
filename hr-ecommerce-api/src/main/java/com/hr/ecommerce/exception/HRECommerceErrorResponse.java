package com.hr.ecommerce.exception;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

public class HRECommerceErrorResponse {

	private String timeStamp;
	private String errorMessage;
	private int errorCode;
	private List<ValidationError> validationErrors;

	public HRECommerceErrorResponse() {

	}

	public HRECommerceErrorResponse(String errorMessage, int errorCode) {

		this.timeStamp = new SimpleDateFormat("dd-MMM-yyyy").format(Calendar.getInstance().getTime());
		this.errorMessage = errorMessage;
		this.errorCode = errorCode;

	}

	public HRECommerceErrorResponse(List<ValidationError> validationErrors, int errorCode) {
		this.timeStamp = new SimpleDateFormat("dd-MMM-yyyy").format(Calendar.getInstance().getTime());
		this.validationErrors = validationErrors;
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

	public List<ValidationError> getValidationErrors() {
		return validationErrors;
	}

	public void setValidationErrors(List<ValidationError> validationErrors) {
		this.validationErrors = validationErrors;
	}

}
