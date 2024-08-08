package com.hrm.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.hrm.config.BaseClass;
import com.hrm.reports.Report;
import com.hrm.utils.Util;

public class LoginPage /*extends BaseClass*/ {
	
	private WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name = "username")
	WebElement username;
	
	@FindBy(name = "password")
	WebElement password;
	
	@FindBy(xpath = "//button[@type='submit']")
	WebElement login;
	
	
	String expectedTitle = "OrangeHRMjff";
	
	public void isPageOpened() {
		
		String actualTitle = driver.getTitle();
		Assert.assertEquals(actualTitle, expectedTitle, "Login page not launched!!!!!!!!!!!");
		
		
		
		/*if(expectedTitle.equals(actualTitle)) {
			System.out.println("Login page is succesfully launched!!!!!!!!!!!");
		}else {
			System.out.println("Login page not launched!!!!!!!!!!!");
		}*/
	}
	
	
	public void enterUserName(String userName) {
		Util.sendKeys(driver, username, userName, "User Name");
		Report.passTest(driver, "Login page is succesfully launched!!!!!!!!!!!");
	}
	
	public void enterPassWord(String passWord) {
		Util.sendKeys(driver, password, passWord, "Password");
	}
	
	public void clickOnLogin() {
		Util.click(driver, login, "Login");
	}

}
