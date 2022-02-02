package com.cmsService.testcases;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.cmsBonusService.pages.LoginPage;
import com.cmsBonusService.testng.api.base.ProjectSpecificMethods;

public class TC001_LoginLogOut extends ProjectSpecificMethods{	

	@BeforeTest
	public void setValues() {
		testCaseName = "ServiceNow Login";
		testDescription = "Login with positive data";
		authors = "Ramesh";
		category = "Smoke";
		dataSheetName = "TC001";
	}

	@Test(dataProvider = "fetchData")
	public void login(String uName, String pwd) {
		new LoginPage()
		.enterUserName(uName)
		.enterPassword(pwd)
		.clickLogin()
		.verifyLandingPage("Title");
	}


}





