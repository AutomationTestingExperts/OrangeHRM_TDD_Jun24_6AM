package com.hrm.utils;

import java.io.File;
import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.hrm.config.BaseClass;
import com.hrm.reports.Report;

public class Util {
	
	
	public static void sendKeys(WebDriver driver, WebElement element, String value, String desc) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement webelement = wait.until(ExpectedConditions.visibilityOf(element));
		webelement.sendKeys(value);
		Report.infoTest("User eneters "+value+ " into " + desc);
	}
	
	public static void click(WebDriver driver, WebElement element, String desc) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement webelement = wait.until(ExpectedConditions.elementToBeClickable(element));
		webelement.click();
		Report.infoTest("User clicks on "+desc);
	}
	
	public static String getText(WebDriver driver, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement webelement = wait.until(ExpectedConditions.visibilityOf(element));
		String text = webelement.getText();
		return text;
	}
	
	public static String getProperty(String key) {
		String value = "";
		try {
			File file = new File(System.getProperty("user.dir")+"\\src\\main\\resources\\config.properties");
			FileInputStream fi = new FileInputStream(file);
			Properties prop = new Properties();
			prop.load(fi);
			value = prop.getProperty(key);
		}catch (Exception e) {
			// TODO: handle exception
		}
		return value;
	}
	
	public static String takeScreenShot(WebDriver driver) {
		String path = System.getProperty("user.dir")+"\\sshots\\myfirrstss.png";
		try {
			TakesScreenshot screen = (TakesScreenshot) driver;
			File src = screen.getScreenshotAs(OutputType.FILE);
			File agt = new File(path);
			FileUtils.copyFile(src, agt);
		}catch (Exception e) {
			// TODO: handle exception
		}
		return path;
	}

}
