package com.hr.ecommerce.exception;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
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
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<HRECommerceErrorResponse> methodArgumentExceptions(MethodArgumentNotValidException e) throws Exception{
		
		HRECommerceErrorResponse errorResponse = new HRECommerceErrorResponse(processValidationErros(e),HttpStatus.BAD_REQUEST.value());
		return new ResponseEntity<HRECommerceErrorResponse>(errorResponse,HttpStatus.BAD_REQUEST);
	}

	private List<ValidationError> processValidationErros(MethodArgumentNotValidException e) {
	
		List<ValidationError> errors = new ArrayList<ValidationError>();
		BindingResult result = e.getBindingResult();
	    for(FieldError err : result.getFieldErrors()) {
	    	errors.add(new ValidationError(err.getField(), err.getDefaultMessage()));
	    }
		return errors;

	}			
}
