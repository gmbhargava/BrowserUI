package com.hsbc.digital.testauto.scripts.communication;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.hsbc.digital.testauto.library.BrowserLib;
import com.hsbc.digital.testauto.library.FileUtil;
import com.hsbc.digital.testauto.library.ReflectionUtil;
import com.hsbc.digital.testauto.pageObject.LoginGmail;
import com.hsbc.digital.testauto.pageObject.UpdatePersonalInformationModel;

public class LoginTest {

	WebDriver driver;
	BrowserLib browserLib;
	Map<String,String> envProperties;
	LoginGmail loginGmail;
	Map<String,String> profileProperties;
	public static final org.apache.log4j.Logger logger=org.apache.log4j.Logger.getLogger(LoginTest.class);
	
	
	@Parameters({"browser"})
	@BeforeTest()
	public void testlogin(final String browser){
		try{
			this.browserLib= new BrowserLib(browser);
			this.driver=browserLib.getDriver();
			profileProperties=FileUtil.getconfigproperties("us");
			this.driver.get(profileProperties.get("URL"));
		//	loginGmail =new LoginGmail(driver);
			loginGmail=(LoginGmail)ReflectionUtil.getEntityPOM("LoginGmail" , driver);	
			loginGmail.gmaillogin(profileProperties.get("userName"),profileProperties.get("password"));
			
			
		}catch(Exception e){
			logger.error(" Exception thrown at login constructor ", e);
		}

	
	}
	@Test
	public void sentmessage(){
		loginGmail.composemail(profileProperties.get("sentuser"),profileProperties.get("sampleText") );
		System.out.println("sucessfully sent message");
	}
}






































