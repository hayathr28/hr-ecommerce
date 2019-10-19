package com.hr.ecommerce.exception;

import java.text.MessageFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

@Service
public class HREcommerceExceptionFactoryImpl implements HREcommerceExceptionFactory{
	
	@Autowired
	private Environment env;

	public HREcommerceException createException(String message) {
		
		return new HREcommerceException(message);
	}

	public HREcommerceException createException(String message, Throwable error) {
		
		return new HREcommerceException(message,error);
	}

	public HREcommerceException createException(String errorKey, Object[] params) {
		return  new HREcommerceException(getErrorMessage(errorKey,params));
	}

	private String getErrorMessage(String errorKey, Object[] params) {
		try {
		return new MessageFormat(env.getProperty(errorKey)).format(params);
		}catch(Exception e) {
			return errorKey;
		}
	}

}
