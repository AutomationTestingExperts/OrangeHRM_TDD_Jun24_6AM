package com.hrm.config;

import java.lang.reflect.Method;
import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentTest;
import com.hrm.reports.Report;
import com.hrm.utils.Util;

public class BaseClass {

	public WebDriver driver;
	public static ExtentTest report;
	public static Logger log = LogManager.getLogger(BaseClass.class.getName());
	
	@BeforeSuite
	public void beforeSuite() {
		
	}

	@BeforeMethod
	public void beforeMethod(Method method) {
		log.info("*********** Execution started ***********");
		report = Report.startReport(System.getProperty("user.dir")+"//Reports//ExtentReport.html", method.getName(), "");
		launchBrowser(Util.getProperty("browser"), Util.getProperty("url"));
		
		Report.infoTest("Launched "+Util.getProperty("browser")+", Opened "+Util.getProperty("url"));
	}

	@AfterMethod
	public void afterMethod() {
		
		Report.infoTest("*********** Execution complted ***********");
		if (driver != null) {
			driver.quit();
		}
		Report.getReporter(System.getProperty("user.dir")+"//Reports//ExtentReport.html").flush();
	}

	@AfterSuite
	public void afterSuite() {

	}

	public void launchBrowser(String browser, String url) {
		if (browser.equalsIgnoreCase("chrome")) {
			/*System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir")+"\\OrangrHRM_TDD_May22\\Drivers\\chromedriver.exe");*/

			driver = new ChromeDriver();

		} else if (browser.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		} else if (browser.equalsIgnoreCase("edge")) {

		} else if (browser.equalsIgnoreCase("ie")) {

		} else if (browser.equalsIgnoreCase("safari")) {

		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(url);

	}

}
