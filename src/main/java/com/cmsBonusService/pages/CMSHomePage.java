package com.cmsBonusService.pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.aventstack.extentreports.ExtentTest;
import com.cmsBonusService.testng.api.base.ProjectSpecificMethods;

import io.cucumber.java.en.Then;


public class CMSHomePage extends ProjectSpecificMethods{
	
	// Home page elements
	String cmsAuditViewTab_xpath = "//*[@role='navigation']//p[text()='CMS Audit View']";
	String cmsAuditViewTitle_xpath = "//span[text()='CMS Audit View ']";

	

	public CMSHomePage verifyLandingPage(String title) throws WebDriverException {
		verifyTitle(title);
		return this;
	}
	public CMSHomePage clickCMSauditViewTab() throws InterruptedException {
		
		clickElement("xpath",cmsAuditViewTab_xpath);
		Thread.sleep(3000);
		return this;
	}
	
	public CMSHomePage verifyCMSHomePage() {
		verifyDisplayed(locateElementByXpath(cmsAuditViewTitle_xpath));
		System.out.println("*** Landed on CMS Audit View page ***");
		return this;
	}


}










