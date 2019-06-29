/**
 * 
 */
package com.hsbc.digital.testauto.pageObject;

/**
 * @author Rajendra
 *
 */
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



public class LoginGmail {

	WebDriverWait wait;
	WebDriver driver;
	GenericActions actions;
	public LoginGmail(WebDriver driver){
		this.driver =driver;
		this.wait=new WebDriverWait(driver, 40);
		this.actions=new GenericActions(driver);
		PageFactory.initElements(driver, this);
		
	}
	
	
	@FindBy(id="identifierId")
	WebElement userName;
	
	@FindBy(xpath="//span[contains(text(),'Next')]")
	WebElement firstclick;
	
	
	@FindBy(xpath="//input[@type='password']")
	WebElement Password;
	
	
	@FindBy(xpath="(//span[@class='RveJvd snByac'])[1]")
	WebElement nxtclick;
	
	public WebElement enteremail(){
		return userName;
	}
	
	public boolean enterclick(){
		return this.actions.clickOnElement(this.firstclick);
	}
	
	public boolean enterpassword(String pwdVal){
		return this.actions.inputValue(this.Password, pwdVal);	
		
	}
	
	public boolean clickNext(){
		return this.actions.clickOnElement(this.nxtclick);
	}
	
	public void gmaillogin(String username,String password){
		this.enteremail().sendKeys(username);
		this.enterclick();
		this.enterpassword(password);
		this.clickNext();
		
	}
	
	@FindBy(xpath="//div[contains(text(),'COMPOSE')]")
	WebElement composemsg;
	
	@FindBy(name="to")
	WebElement senderEmail;
	
	@FindBy(name="subjectbox")
	WebElement subjectBox;
	
	@FindBy(xpath="(//div[contains(text(),'Send')])[2]")
	WebElement clicksend;
	
	
	
	
	public boolean clickOnCompose(){
		return this.actions.clickOnElement(this.composemsg);
	}
	
	
	public boolean enterEmailSender(String email){
		return this.actions.inputValue(this.senderEmail,email);
	}
	
	public boolean EnterText(String sample){
		return this.actions.inputValue(this.subjectBox, sample);
	}
	
	public boolean clickOnSend(){
		return this.actions.clickOnElement(this.clicksend);
	}
	
	
	public void composemail(String email,String sample){
		this.clickOnCompose();
		this.enterEmailSender(email);
		this.EnterText(sample);
		this.clickOnSend();
	}
	
	@FindBy(xpath="//tr[@jsmodel='nXDxbd']/td[8]")
	List<WebElement> dates;
	
	
	
	public boolean dates(){
		
		boolean flag=false;
		wait.until(ExpectedConditions.visibilityOfAllElements(this.dates));
		for(WebElement ele:dates){
			System.out.println(ele.getText());
			flag=true;
		}
		return flag;
	}
	
	
	
	@FindBy(xpath="//span[text()='View message']")
	WebElement msg_sucess;
	
	@FindBy(xpath="//a[contains(text(),'Sent Mail')]")
	WebElement sentbox;
	
	@FindBy(xpath="(//span[contains(text(),'this is sample text')])")
	WebElement msgsentcheck;
	
	public boolean isSuccessMsgDisplayed(){
		return this.actions.isElementDisplayed(this.msg_sucess);
	}
	
	public boolean sentboxcheck(){
		return this.actions.clickOnElement(this.sentbox);
	}
	public boolean SentMsgCheck(){
		return this.actions.isElementDisplayed(this.msgsentcheck);
	}
		
	}
	

	
	
	
	
	
	
	
	
	
	
	
	
		

	


