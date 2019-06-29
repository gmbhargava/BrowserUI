package com.hsbc.digital.testauto.library;

import java.io.File;
import java.util.Calendar;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;

/*
 * <p>
 * <b> Class for taking screenshot at any instance in automation execution
 * </b>
 * </p>
 * 
 */
public class ScreenShot {
	
	
	private static String fileSeperator =System.getProperty("file.separator");
	/*
	 * Logger Utility for loggin as per Apache Logger in separate in Log file for project.<br>
	 * 
	 * Need to be present in all class. 
	 */
	
	
	public static final org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(ScreenShot.class);
	private static final String SCREENSHOT_DIR_NAME="screenshots";
	private static final String RESULT_DIR_NAME="Result";

	public ScreenShot() {
		
	}
	
	public static void takeScreenShot(final WebDriver driver){
		Calendar cal =Calendar.getInstance();
		String toDay =cal.get(Calendar.DATE) + "_" + (cal.get(Calendar.MONTH) + 1) + "-" + cal.get(Calendar.YEAR);
		String screenShotName =cal.getTimeInMillis() + ".png";
		try{
			File file = new File(ScreenShot.SCREENSHOT_DIR_NAME + ScreenShot.fileSeperator +ScreenShot.RESULT_DIR_NAME);
			if(!file.exists()){
				file.mkdir();
			}
			File screenshotFile =((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			File targetFile = new File(ScreenShot.SCREENSHOT_DIR_NAME + ScreenShot.fileSeperator + ScreenShot.RESULT_DIR_NAME + ScreenShot.fileSeperator 
					+ toDay,screenShotName);
			FileUtils.copyFile(screenshotFile, targetFile);
			Reporter.log("ScreenShot :<a href ='../../" + targetFile.getPath() +"'target='_blank'>View Screenshot</a>");	
		}catch (Exception e){
			ScreenShot.logger.error("Exception at ScreenSHOT:takeScreenShot():" , e);
		}
	}
	
}
