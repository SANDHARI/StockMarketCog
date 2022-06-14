package com.stock.market.stock.utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateUtils {
	
	private static final String DATE_TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";
	
	public static LocalDateTime convertStringToLocalDateTime(String dateTime) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATE_TIME_FORMAT); 
    	return LocalDateTime.parse(dateTime, formatter);
	}

}
