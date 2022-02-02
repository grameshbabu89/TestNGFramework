package com.cmsBonusService.testng.api.base;

import java.io.IOException;

import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import com.cmsBonusService.selenium.api.base.SeleniumBase;

import utils.DataLibrary;


public class ProjectSpecificMethods extends SeleniumBase {

	public String dataSheetName;		

	@DataProvider(name = "fetchData")
	public String[][] fetchData() throws IOException {
		return DataLibrary.readExcelData(dataSheetName);
	}	

	/*
	 * @Parameters({"browser","urlToBeTested"})
	 * 
	 * @BeforeMethod public void beforeMethod(String browser,String url) { driver =
	 * startApp(browser,url ); node = test.createNode(testCaseName); }
	 */

	/*
	 * @AfterMethod(alwaysRun = true) public void afterMethod() { quit(); }
	 */
	
	@Parameters({"browser","urlToBeTested"})
	@BeforeClass
	public void report(String browser,String url) throws IOException {
		test = extent.createTest(testCaseName, testDescription);
		test.assignAuthor(authors);
		test.assignCategory(category);  
		driver = startApp(browser,url );
		node = test.createNode(testCaseName);
	}













}
