package com.hsbc.digital.testauto.pageObject.uk;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hsbc.digital.testauto.pageObject.UpdatePersonalInformationModel;

public class UpdatePersonalInformation  extends UpdatePersonalInformationModel{
	

	
public UpdatePersonalInformation(final WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

@FindBy(xpath="//*[@id='group")
private WebElement confirmButtonOnCapturePage;
	
@Override
public void clickOnConfirmButtonOnCapturePage(){
	confirmButtonOnCapturePage.click();
}
	
	
	
}
