package com.hsbc.digital.testauto.listners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer {
	
	int counter=0;
	int retryLimit=1;

	
	/*
	 * (non-Javadoc)
	 * @see org.testng.IRetryAnalyzer#retry(org.testng.ITestResult)
	 * 
	 * THIS METHOD DECIDES how many times a test need to be rerun
	 * Testng will call this method every time a test fails.so we can put some code in hero to decide when to run the test
	 * 
	 * 
	 * Note : this method will return true if a test needs to retried and false it not
	 */
	

	@Override
	public boolean retry(final ITestResult result) {
		if(this.counter<this.retryLimit){
			this.counter++;
			return true;
		}
		return false;
	}

}
