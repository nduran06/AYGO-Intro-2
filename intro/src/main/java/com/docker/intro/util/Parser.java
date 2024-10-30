package com.docker.intro.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

public class Parser {
	
	private static ObjectWriter objectWriter = new ObjectMapper().writer().withDefaultPrettyPrinter();
	private static SimpleDateFormat sdfDefault = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ");

	
	public static String objectToJson(Object object) throws JsonProcessingException {
		
		return objectWriter.writeValueAsString(object);
	}
	
	@SuppressWarnings("finally")
	public static String defaultFormatDateTime(Date date) {
		
		sdfDefault.setTimeZone(TimeZone.getTimeZone("GMT-0500"));
		
		String dateValue = null;
		
		try {
			dateValue = sdfDefault.format(date);;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			return dateValue;
		}
	}

}
