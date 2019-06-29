package com.hsbc.digital.testauto.exceptions;


/*
 * <p>
 * <b> thrown when there is no message to read in secure message.</b>
 * </p> 
 */


public class SecureMessageNotFoundException extends RuntimeException{
	private static final long serialVersionUID =1L;

	public SecureMessageNotFoundException(final String message) {
		
		super(message);
	}

}
