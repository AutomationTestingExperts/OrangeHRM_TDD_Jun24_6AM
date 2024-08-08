package com.hrm.testcases;

import org.testng.annotations.Test;

import com.hrm.config.BaseClass;
import com.hrm.pages.HomePage;
import com.hrm.pages.LoginPage;
import com.hrm.reports.Report;
import com.hrm.utils.Util;

public class LoginTest extends BaseClass{
	
	@Test
	public void validateLogin() {
		try {
			LoginPage log = new LoginPage(driver);
			log.isPageOpened();
			log.enterUserName(Util.getProperty("username"));
			log.enterPassWord(Util.getProperty("password"));
			log.clickOnLogin();
			HomePage home = new HomePage(driver);
			home.isPageOpened();
		}catch (AssertionError e) {
			Report.failTest("Test case failed due to : "+e.getMessage());
			e.printStackTrace();
		}
	}
	
	@Test
	public void validateLoginTest() {
		LoginPage log = new LoginPage(driver);
		log.isPageOpened();
		log.enterUserName(Util.getProperty("username"));
		log.enterPassWord(Util.getProperty("password"));
		log.clickOnLogin();
		HomePage home = new HomePage(driver);
		home.isPageOpened();
	}

}
