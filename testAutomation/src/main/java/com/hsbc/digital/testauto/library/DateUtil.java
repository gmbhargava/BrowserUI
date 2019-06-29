/**
 * 
 */
package com.hsbc.digital.testauto.library;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * <p> 
 * <b> Class is used to format Date format,Add Days to Date,
 * Get Next Date and valid later or Recurring Date.</b>
 * 
 * @version 1.0.0
 * @author Rajendra
 *
 *  </p>
 */
public class DateUtil {

	public static final String TWO_DECIMAL_PLACE_FORMATTER="#.00";
	public static final String DATE_FORMAT_MMDDYYYY="MM/dd/yyyy";
	public static final String DATE_FORMAT_DDMMMYYYY="dd MMM yyyy";
	public static final String DATE_FORMAT_MMMDDYYYY="MMM dd, yyyy";
	public static final String DATE_FORMAT_MMMDYYYY="MMM d, yyyy";
	public static final String DATE_FORMAT_MMDDYYYY_SPACE="MMM dd yyyy";
	public static final String DATE_FORMAT_DDMMYYYY="dd/MM/yyyy";
	public static final String DATE_FORMAT_MMMMDDYYYY="MMMM dd,yyyy";
	public static final String DATE_FORMAT_MMMMDYYYY="MMMM d,yyyy";
	
	public DateUtil() {
		
	}

	public static final org.apache.log4j.Logger logger=org.apache.log4j.Logger.getLogger(DateUtil.class);
	/*
	 * This Method is used to parse input date in Date format
	 * 
	 * @param inputDataFormat
	 * @param inputDate
	 * @return Parsed date in Date format
	 * @throw ParseExcption
	 * 
	 */
	
	
	public static Date getStringToDate(final String inputDateFormat,final String inputDate) throws ParseException{
		Date parsedDate =null;
		SimpleDateFormat format= new SimpleDateFormat(inputDateFormat);
		parsedDate =format.parse(inputDate);
		return parsedDate;
		
	}
	
	/*
	 * Return Date String from Date
	 */
	
	/*
	 * This method is used to parse input date in String format
	 * 
	 * 
	 * @param targetDateFormat
	 * @param inputDate
	 * @return parsed date in String format
	 * @throw parseException
	 */
	
	public static String getDateToString (final String targetDateFormat,final Date inputDate) throws ParseException{
		String parsedDate =null;
		SimpleDateFormat format= new SimpleDateFormat(targetDateFormat);
		parsedDate =format.format(inputDate);
		return parsedDate;
	}
	
	
	/*
	 * This method is used to add days to the selected date
	 * 
	 * 
	 * @param inputDate
	 * @param daysToAdd
	 * @return processed date in Date format
	 * 
	 */
	
	public static Date addDays (final Date inputDate,final int daysToAdd) {
		Date userDate;
		Calendar cal= Calendar.getInstance();
		cal.setTime(inputDate);
		cal.add(Calendar.DAY_OF_YEAR, daysToAdd);
		userDate=cal.getTime();
		return userDate;
	}
	
	/*
	 * This method is used to add years to the selected date
	 * 
	 * 
	 * @param inputDate
	 * @param yearsToAdd
	 * @return processed date in Date format
	 * 
	 */
	
	public static Date addYear (final Date inputDate,final int yearsToAdd) {
		Date userDate;
		Calendar cal= Calendar.getInstance();
		cal.setTime(inputDate);
		cal.add(Calendar.YEAR, yearsToAdd);
		userDate=cal.getTime();
		return userDate;
	}
	
	
	
	/*
	 * This method is used to return current system date
	 * 
	 * @return Current system Date in Date format
	 * @throw parseException
	 * 
	 */
	
	
	public static Date getSystemDate() throws ParseException{
		Date date= new Date();
		return date;
		
	}
	
	/*
	 * This method is used to find the differnce in data in number of days
	 * 
	 * 
	 * @param startDate
	 * @param endDate
	 * @return
	 * 
	 */
	
	
	public static long dateDifferinceinDays(final Date startDate,final Date endDate){
		long dateDifference;
		dateDifference =endDate.getTime()-startDate.getTime();
		dateDifference=dateDifference/(1000*60*60*24);
		return dateDifference;
	}
	

	
}
