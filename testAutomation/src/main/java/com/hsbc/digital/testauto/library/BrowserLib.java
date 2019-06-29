
/**
 * 
 */
package com.hsbc.digital.testauto.library;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.apache.commons.exec.util.StringUtils;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.hsbc.digital.testauto.exceptions.*;
/**
 * @author Rajendra
 *
 */
public class BrowserLib {

	/**
	 * Driver instance declaration
	 */
	WebDriver driver=null;
	public static final org.apache.log4j.Logger logger=org.apache.log4j.Logger.getLogger(BrowserLib.class);
	private static final String FIREFOX="firefox";
	private static final String INTERNET_EXP="ie";
	private static final String CHROME="chrome";
	/*
	 * Construct for initializing class with given browser type based on
	 * configuration.
	 * 
	 * @param browser:Browser name Which will be passed from configuration/caller
	 */
	public BrowserLib(final String browser){
		try{
			this.setUpDriver(browser);
		}catch(Exception e){
			BrowserLib.logger.error("Exception throw:",e);	
		}
	}
	
/*
 * Method to instantiate Driver instance for this class based on browser passed.
 * 
 * @param browser
 * @throws malformedUrlException
 * @throw Exception	
 */
	
	
	
	public void setUpDriver(final String browser) throws MalformedURLException{
		
		
		
		
		String gridUrl=System.getProperty("gridurl");
		
		
		
		
		//check if parameter passed from TestNg is 'firefox'
		
//		if (BrowserLib.FIREFOX.equalsIgnoreCase(browser)){
//		  DesiredCapabilities capabilities =DesiredCapabilities.firefox();
//		  capabilities.setCapability(CapabilityType.ForSeleniumServer.ENSURING_CLEAN_SESSION, true);
//		  if(StringUtils.isNotEmpty(gridUrl)){
//			  driver=new RemoteWebDriver(new URL(gridUrl),capabilities);
//		  }
//		  else{
//			  driver =new FirefoxDriver(capabilities);
//		  }
		  
		
		if(BrowserLib.FIREFOX.equalsIgnoreCase(browser)){
			
			 DesiredCapabilities capabilities =DesiredCapabilities.firefox();
//			  capabilities.setCapability(CapabilityType.ForSeleniumServer.ENSURING_CLEAN_SESSION, true);
			 
			  final String firebugpath1="src//main//resource//firepath-0.9.7.1-fx.xpi";
			  final String firebugpath ="src//main//resource//firebug-1.12.8.xpi";
			  FirefoxProfile profile=new FirefoxProfile();
//		        System.setProperty("webdriver.firefox.driver", "C:\\Program Files\\MozillaFirefox\\firefox.exe");

			  
			  try{
				  profile.addExtension(new File(firebugpath));
				  profile.addExtension(new File(firebugpath1));	  
			  }catch (IOException e){
				  logger.error("Exception:",e);
			  }
			  
			  profile.setPreference("extensions.firebug.allpagesActivation", "on");
//			  capabilities.setCapability(FirefoxDriver.PROFILE,profile);
			  capabilities.setCapability(CapabilityType.ForSeleniumServer.ENSURING_CLEAN_SESSION, true);
			  System.setProperty("webdriver.firefox.driver", "C:\\Program Files\\MozillaFirefox\\firefox.exe");
			  //if (StringUtils.isNotEmpty(gridUrl)){
			  if(gridUrl==null){
				  driver =new FirefoxDriver(capabilities); 
      			  
			  }else{
				  driver=new RemoteWebDriver(new URL(gridUrl),capabilities);
			  }
		}else if(BrowserLib.CHROME.equalsIgnoreCase(browser)){
			 DesiredCapabilities capabilities =DesiredCapabilities.chrome();
			 capabilities.setCapability(CapabilityType.ForSeleniumServer.ENSURING_CLEAN_SESSION, true);
			 if(gridUrl==null){
				 driver =new ChromeDriver();	 
			 }else{
				 driver=new RemoteWebDriver(new URL(gridUrl),capabilities);
			 }
			
			
			  
		}else if(BrowserLib.INTERNET_EXP.equalsIgnoreCase(browser)){
//			set path to iedriver.exe you may need to download it from 32 bits
			
			
			System.setProperty("webDriver.ie.driver", System.getProperty("user.dir")+"/src/main/resource/"+ "IEDriverserver.exe");
//			 create ie instance
			 DesiredCapabilities capabilities =DesiredCapabilities.internetExplorer();
			 capabilities.setCapability(CapabilityType.ForSeleniumServer.ENSURING_CLEAN_SESSION, true);
//			 if (StringUtils.isNotEmpty(gridUrl)){
//     			  driver=new RemoteWebDriver(new URL(gridUrl),capabilities);
//			  }else{
//				  driver =new FirefoxDriver(capabilities);  
//			  }
			 if(gridUrl.isEmpty()){
				  driver =new InternetExplorerDriver(capabilities); 
     			  
			  }else{
				  driver=new RemoteWebDriver(new URL(gridUrl),capabilities);
			  }
			 
		}else{
//			if no browser passed throw exception
			throw new UnsupportBrowserException();
		}
		
		
		
		this.driver.manage().deleteAllCookies();
		this.browserMaximize();
		this.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		
	}
	/*
	 * method to maximize browser window for current instance
	 * 
	 */
	
	public void browserMaximize(){
		
		driver.manage().window().maximize();
		
	}
	/*
	 * method to minimize browser window for current instance
	 */
	
	public void browserMinimize(){
		driver.manage().window().maximize();
	}
	
	
	/*
	 *method to close all browser window for current instance 
	 */
	
	public void closeAllBrowser(){
	driver.quit();	
	}
	
	/*
	 * Return current instance of driver
	 * 
	 * @return driver
	 */
	
	public WebDriver getDriver(){
		return this.driver;
			 
		  }
}
