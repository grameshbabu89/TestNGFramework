package com.cmsBonusService.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.aventstack.extentreports.ExtentTest;
import com.cmsBonusService.testng.api.base.ProjectSpecificMethods;

import io.cucumber.java.en.Given;


public class LoginPage extends ProjectSpecificMethods{
	
	
	
	public LoginPage enterUserName(String data) {	
		switchToFrame(0);
		clearAndType(locateElement("user_name"), data);
		return this;
	}	

	
	public LoginPage enterPassword(String data) {
		clearAndType(locateElement("user_password"), data);
		return this;
	}	
	
	public CMSHomePage clickLogin() {
		click(locateElement("sysverb_login"));
		defaultContent();
		return new CMSHomePage();		
	}

}
