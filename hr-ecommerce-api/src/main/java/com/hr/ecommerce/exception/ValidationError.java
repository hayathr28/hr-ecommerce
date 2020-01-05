package com.hr.ecommerce.exception;

public class ValidationError {
  private String fieldName;
  private String defaultMessage;
  
  
public ValidationError(String fieldName, String defaultMessage) {
	this.fieldName = fieldName;
	this.defaultMessage=defaultMessage;
}
public String getFieldName() {
	return fieldName;
}
public void setFieldName(String fieldName) {
	this.fieldName = fieldName;
}
public String getDefaultMessage() {
	return defaultMessage;
}
public void setDefaultMessage(String defaultMessage) {
	this.defaultMessage = defaultMessage;
}
}
