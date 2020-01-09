package com.hr.ecommerce.exception;

public interface HREcommerceExceptionFactory {
	
	public HREcommerceException createException(String message);
	
	public HREcommerceException createException(String message, Throwable error);
	
	public HREcommerceException createException(String errorKey, Object[] params);

}
