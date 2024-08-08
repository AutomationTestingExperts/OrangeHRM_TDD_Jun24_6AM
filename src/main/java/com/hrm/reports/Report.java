package com.hrm.reports;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.hrm.config.BaseClass;
import com.hrm.utils.Util;

public class Report {
	static ExtentReports extent;

	public static ExtentReports getReporter(String reportName) {
		if (extent == null) {
			ExtentSparkReporter html = new ExtentSparkReporter(reportName);
			html.config().setDocumentTitle("Orange HRM");
			html.config().setReportName("QA xperts");
			html.config().setTheme(Theme.DARK);
			extent = new ExtentReports();
			extent.attachReporter(html);
		}
		return extent;
	}

	public static ExtentTest startReport(String reportName, String testName, String desc) {
		return getReporter(reportName).createTest(testName, desc);
	}

	public static void passTest(String desc) {
		BaseClass.log.info(desc);
		BaseClass.report.pass(desc);
	}

	public static void passTest(WebDriver driver, String desc) {
		BaseClass.log.info(desc);
		BaseClass.report.pass(desc,
				MediaEntityBuilder.createScreenCaptureFromPath(Util.takeScreenShot(driver)).build());
	}

	public static void failTest(String desc) {
		BaseClass.log.info(desc);
		BaseClass.report.fail(desc);
	}

	public static void failTest(WebDriver driver, String desc) {
		BaseClass.log.info(desc);
		BaseClass.report.fail(desc,
				MediaEntityBuilder.createScreenCaptureFromPath(Util.takeScreenShot(driver)).build());
	}

	public static void infoTest(String desc) {
		BaseClass.log.info(desc);
		BaseClass.report.info(desc);
	}
}
