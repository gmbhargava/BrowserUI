package com.hsbc.digital.testauto.models;

import java.util.List;

public class UpdatePersonalInformation {

	String onlineGreeting;
	String noOfDependent;
	String emailAddress;
	String maritalStatus;
	String primaryNumber;
	String alternateNumber;
	String workNumber;
	String workExtenstionNumber;
	String otpNumber;
	List<String> correspondenceAddress;
	List<String> bpfoAddress;
	
	
	
	
	public String getMaritalStatus(){ 				//getter is used  get a value.startWith get(letter) along with method name
		return maritalStatus;
	}
	
	public void setMaritalStatus(String maritalStatus){     //setter is used to set a value.StartWith set(letter) along with method name
		this.maritalStatus=maritalStatus;
	}
	
	public String getOnlineGreeting(){
		return onlineGreeting;
	}
	public void setOnlineGreeting(String onlineGreeting){
		this.onlineGreeting=onlineGreeting;
	}
	
	public String getEmailAddress(){
		return emailAddress;
	}
	
	public void setEmailAddress(String emailAddress){
		this.emailAddress=emailAddress;
	}
	
	public List<String> getbpfoAddress(){
		return bpfoAddress;
	}
	
	public void setbpfoAddress(List<String> bpfoAddress){
		this.bpfoAddress=bpfoAddress;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
