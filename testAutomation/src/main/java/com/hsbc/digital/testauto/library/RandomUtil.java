package com.hsbc.digital.testauto.library;

import java.text.DecimalFormat;
import java.util.concurrent.ThreadLocalRandom;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;

/*
 * <p>
 * <b> Class to generate different types of random Number ,String or Special
 *  Characters .</b> 
 */

public class RandomUtil {
	
	private static final String SPECIAL_CHARS ="!#$%&'()*+,-./:;<=>?@[]^_`{|}~";
	private static final String NUMBER_FORMAT_EXP="#.";
	private static final String NUMBER_FORMAT_DECIMAL_EXP="0";
	
	private RandomUtil() {
		
	}
	
	public static String generateSpecialCharacterText(final int length){
		char[] specialChars =RandomUtil.SPECIAL_CHARS.toCharArray();
		return RandomStringUtils.random(length,0,specialChars.length,false,false,specialChars);
	}
	
	/*
	 * 
	 * <p>
	 * <b> Generates Alhabetics and numeric Text for given length.</b>
	 * </p>
	 * 
	 * @param length
	 * @return alphanumeric text
	
	 */
	
	
	public static String generateAlphaNumericText(final int length){
		return RandomStringUtils.randomAlphanumeric(length);
	}
	
	/*
	 * <p>
	 * <b> Generate String of integer number for given length .</b>
	 * </p>
	 * 
	 * @param length
	 * @return Numeric String
	 */
	
	
	public static String generateIntNumber(final int length){
		return RandomStringUtils.randomNumeric(length);
	}
	
	
	/*
	 * <p>
	 * <b> Generate of integer number randomly between  given start and end integer .</b>
	 * </p>
	 * 
	 * @param start -starting limit for random integer
	 * @param end - end limit (exclusive) for random integer
	 * @return integer number
	 */
	
	
	public static int generateIntNumber(final int start,final int end){
		return ThreadLocalRandom.current().nextInt(start,end);
	}
	
	
	/*
	 * <p>
	 * <b> Generate of double number in given start and range .</b>
	 * </p>
	 * 
	 * @param start -starting limit for random double
	 * @param end - end limit (exclusive) for random double
	 * @return double number
	 */
	
	public static int generateDoubleNumber(final int start,final int end){
		return ThreadLocalRandom.current().nextInt(start,end);
	}
	
	
	/*
	 * <p>
	 * <b> Generate  String represention of Double number for given range and given no of decimal places .</b>
	 * </p>
	 * 
	 * @param start -starting limit for random double
	 * @param decimalPlace -no of decimal palces required
	 * @param end - end limit (exclusive) for random double
	 * @return double number
	 */
	
	
	public static String generateDoubleNumber(final int start,final int end,final int decimalPlaces){
		double number =generateDoubleNumber(start,end);
		return formatDouble(number,getDecimalFormat(decimalPlaces));
	}
	
	
	/*
	 * <p>
	 * <b> Gets Decmial format for given decimal precision.</b>
	 * </p>
	 * 
	 * @param decimalplaces no of decimal places
	 * 
	 * @return format for java  Decimal formatter in string format
	
	 */
	
	public static String getDecimalFormat(final int decimalPlaces){
		return new StringBuilder(RandomUtil.NUMBER_FORMAT_EXP).append(StringUtils.repeat(RandomUtil.NUMBER_FORMAT_DECIMAL_EXP, decimalPlaces)).toString();
	}
	
	
	
	/*
	 * <p>
	 * <b> Format given double number in given format.</b>
	 * </p>
	 * 
	 * @param number =Double  number to format
	 * 
	 * @param format = format in which double number need to be modified 
	 * 
	 * @return String of double formatted
	 * 
	 */
	
	public static String formatDouble(final double number,final String format){
		
		DecimalFormat df =new DecimalFormat(format);
		return df.format(number);
	}
	
	
	/*
	 * 
	 * <p>
	 * <b> Generate Alphabetics String for given length randomly .</b>
	 * </p>
	 * @param length = length of string required
	 * 
	 * @return String of random alphabetic character
	 
	 * 
	 */
	
	
	public static String generateAlphabatic(final int length){
		return RandomStringUtils.randomAlphabetic(length);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
