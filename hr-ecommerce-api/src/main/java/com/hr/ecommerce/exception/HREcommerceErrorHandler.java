package com.hr.ecommerce.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class HREcommerceErrorHandler {
	@ExceptionHandler(Exception.class)
	public ResponseEntity<HRECommerceErrorResponse> generalException(Exception e) throws Exception {
		String errorMessage = e.getLocalizedMessage();
		HRECommerceErrorResponse errorResponse = new HRECommerceErrorResponse(errorMessage,
				HttpStatus.INTERNAL_SERVER_ERROR.value());
		return new ResponseEntity<HRECommerceErrorResponse>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(HREcommerceException.class)
	public ResponseEntity<HRECommerceErrorResponse> generalException(HREcommerceException e) throws Exception {
		String errorMessage = e.getLocalizedMessage();
		HRECommerceErrorResponse errorResponse = new HRECommerceErrorResponse(errorMessage,
				HttpStatus.INTERNAL_SERVER_ERROR.value());
		return new ResponseEntity<HRECommerceErrorResponse>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
