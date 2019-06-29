/**
 * 
 */
package com.hsbc.digital.testauto.exceptions;

/**
 * @author Rajendra
 *
 */
public class UnsupportBrowserException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID=1L;
	public UnsupportBrowserException(final String msg) {
		super(msg);
	}
	
	public UnsupportBrowserException() {
		super("Either browser ame is not valid or browser name not supplied properly");
	}

}
