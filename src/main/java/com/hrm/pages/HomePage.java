package com.hrm.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.hrm.config.BaseClass;
import com.hrm.reports.Report;
import com.hrm.utils.Util;

public class HomePage {

	private WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//h6")
	WebElement pageHeader;

	String expectedHeader = "Dashboard";

	public void isPageOpened() {
		String actualHeader = Util.getText(driver, pageHeader);
		Assert.assertEquals(actualHeader, expectedHeader, "Login failed!!!!!!!!!!!");
		Report.passTest("Succefully Loggedin!!!!!!!!!!!");
	}

}
