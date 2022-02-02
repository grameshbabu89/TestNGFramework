package com.cmsService.testcases;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.cmsBonusService.pages.CMSHomePage;
import com.cmsBonusService.pages.LoginPage;
import com.cmsBonusService.testng.api.base.ProjectSpecificMethods;

public class TC003_CMSAuditView extends ProjectSpecificMethods{	

	@BeforeTest
	public void setValues() {
		testCaseName = "TC001";
		testDescription = "CMSedit";
		authors = "Ramesh";
		category = "Smoke";
		//dataSheetName = "TC003";
	}

	@Test()
	public void AuditViewPass() throws Exception {
		new CMSHomePage()
		.verifyLandingPage("CMSBonus Service")
		.clickCMSauditViewTab()
		.verifyCMSHomePage();		
			
	}	
	@Test()
	public void AuditViewFail() throws Exception {
		new CMSHomePage()
		.verifyLandingPage("CMSBonusService")
		.clickCMSauditViewTab()
		.verifyCMSHomePage();		
			
	}
				
	@Test (enabled=false)
	public void runSqlQuery() throws InterruptedException, SQLException {
		ResultSet res=executeSqlQuery("select * from Config where Description like '%version'");
		System.out.println("-----> Query Result <-------");
		while (res.next())
    	{
			System.out.print(res.getString("Description"));
	    	System.out.print(" " + res.getString(2));
	    	System.out.print(" " + res.getString(3));
	    	System.out.println(" " + res.getString(4));
    		
    	}
		System.out.println("---------------------");
		
	}

}