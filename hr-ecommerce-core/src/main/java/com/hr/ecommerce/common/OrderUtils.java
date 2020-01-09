package com.hr.ecommerce.common;

import java.math.BigDecimal;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;

public class OrderUtils {
	
	public static BigDecimal convertAmount(String amount) {
		return StringUtils.isNotEmpty(amount) ? new BigDecimal(amount): new BigDecimal(NumberUtils.INTEGER_ZERO);
		
	}

}
