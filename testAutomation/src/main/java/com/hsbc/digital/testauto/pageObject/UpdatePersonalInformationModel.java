package com.hsbc.digital.testauto.pageObject;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;


/* Contains model class will hold locator and functinolity to update contact
 * Details page.
 * 
 */
public abstract class UpdatePersonalInformationModel {
	protected final WebDriver driver;
	protected final WebDriverWait wait;
	private static final String FAILURE_MESSAGE ="error icon is displyed";
	
	
	@FindBy(xpath ="//button[contains(@class,'editIcon')")
	protected WebDriver changeAddressButton;
	
	@FindBy(xpath ="//input[contains(@id,'email')")
	protected WebDriver emailInput;
	
	@FindBy(xpath ="//input[contains(@id,'homePhNo')")
	protected WebDriver homePhoneInput;
	
	
	@FindBy(xpath="//div[contains(@id,'homeCountry')]/div[contains(@class,'dijivalidationContainer')]")
	private WebElement errorIcon;
	
	@FindBy(xpath="//button[text()='update details']")
	private WebElement updateDetailsButton;
	
	
	public void verificationForWithOutCountryInput(){
		((JavascriptExecutor) driver).executeScript("argument[0].scrollIntoView(true);",errorIcon);
		Assert.assertTrue(errorIcon.isDisplayed(),UpdatePersonalInformationModel.FAILURE_MESSAGE);
		Reporter.log("successfully verified error message");
		
	}
	
	public UpdatePersonalInformationModel(final WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver,30);	
	}
	
	public void clickOnUpdateDetails(){
		wait.until(ExpectedConditions.elementToBeClickable(updateDetailsButton));
		updateDetailsButton.click();
	}
	
	public void clickOnConfirmButtonOnCapturePage(){}
	
	
	
	
	
	
	
	
	

}
