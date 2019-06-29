package com.hsbc.digital.testauto.pageObject;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class GenericActions {
	
	
	WebDriverWait wait;
	WebDriver driver;
	public GenericActions(WebDriver driver){
		this.driver =driver;
		this.wait=new WebDriverWait(driver, 40);
	}
	
	public boolean inputValue(WebElement locator,String value){
		boolean flag=false;
		wait.until(ExpectedConditions.elementToBeClickable(locator));
		if(locator.isDisplayed()){
			locator.sendKeys(value);
			flag=true;
			}
		return flag;
	}
	
	
	public boolean clickOnElement(WebElement locator){
		boolean flag=false;
		wait.until(ExpectedConditions.elementToBeClickable(locator));
		if(locator.isDisplayed()){
			locator.click();
			flag=true;
			}
		return flag;
	}
	
	public boolean isElementDisplayed(WebElement locator){
		boolean flag=false;
		wait.until(ExpectedConditions.visibilityOf(locator));
		if(locator.isDisplayed()){
			flag=true;
			}
		return flag;
	}
	
	
	

}

