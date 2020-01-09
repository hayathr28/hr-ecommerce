package com.hr.ecommerce.order.common;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class DateHelper {
	public static final String DATE_FORMAT_DD_MM_YYYY_HH_MM_SS = "dd-MM-yyyy HH:mm.ss";
	 public static String getCurrentTime() {
	        return new SimpleDateFormat(DATE_FORMAT_DD_MM_YYYY_HH_MM_SS).format(Calendar.getInstance().getTime());
	    }
	 
	 public static Calendar convertToDate(String strYear, String strMonth, String strDay) throws Exception {
	        Calendar date = Calendar.getInstance();
	        int year = Integer.parseInt(strYear);
	        int month = Integer.parseInt(strMonth);
	        int day = Integer.parseInt(strDay);
	        date.set(year, month-1, day);
	        return date;
	    }

}
