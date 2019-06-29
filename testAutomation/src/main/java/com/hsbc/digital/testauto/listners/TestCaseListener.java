package com.hsbc.digital.testauto.listners;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.hsbc.digital.testauto.library.ScreenShot;

/*
 * <br>
 * Custom Listener for test case to log additional result and screen shots
 * for reporting purpose</b>
 *  
 */

public class TestCaseListener extends TestListenerAdapter {
	/*
	 * method name constant which will return object instance for current reporting purpose</b>
	 * 
	 * Need to be preset  in all scripts.
	 
	 */
	
	private static final String DRIVER_METHOD_NAME ="getDriver";
	
	/*
	 * Logger utility for logging as Apache logger in separate log file for project 
	 * 
	 * need to be present in all classes.
	 */
	
	public static final org.apache.log4j.Logger logger =org.apache.log4j.Logger.getLogger(TestCaseListener.class);
	
	
	@Override
	public void onTestStart(final ITestResult tr){
		TestCaseListener.logger.info("test method name:" + tr.getName());
		TestCaseListener.logger.info("test started..");
	}
	
	
	
	@Override
	public void  onTestSuccess(final ITestResult tr){
		TestCaseListener.logger.info("Test " + tr.getName() + "'PASSED");
		TestCaseListener.logger.info(tr.getTestClass());
		doProcessScreenShot(tr);
	}
	
	
	@Override
	public void onTestFailure(final ITestResult tr){
		TestCaseListener.logger.info("Test " + tr.getName() + "'FAILED");
		doProcessScreenShot(tr);
	}
	
	@Override
	public void onTestSkipped(final ITestResult tr){
		TestCaseListener.logger.info("Test " + tr.getName() + " 'SKIPPED");
	}

	/*
	 * Method to process screenshot capture activity.
	 * 
	 * @param testResult
	 */
	
	private void doProcessScreenShot(final ITestResult testResult){
		Object testScriptObj = testResult.getInstance();
		try{
			for (Method method :testScriptObj.getClass().getMethods()){
				if(method.getName().equals(TestCaseListener.DRIVER_METHOD_NAME)){
					WebDriver driver =(WebDriver) method.invoke(testResult.getInstance());
					ScreenShot.takeScreenShot(driver);
					break;
				}
			}
		}catch (Exception e){
			TestCaseListener.logger.error("Exception throw at TestCaseListener class :onTestSuccess():",e);
		}
	}

}
