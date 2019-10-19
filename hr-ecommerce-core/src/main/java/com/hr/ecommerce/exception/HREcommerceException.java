package com.hr.ecommerce.exception;

public class HREcommerceException extends RuntimeException {

	/**
		 * 
		 */
	private static final long serialVersionUID = 1L;

	public HREcommerceException(String message) {
		super(message);
	}

	public HREcommerceException(String message, Throwable error) {
		super(message, error);
	}

}
