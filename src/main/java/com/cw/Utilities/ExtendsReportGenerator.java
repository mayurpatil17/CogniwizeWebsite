package com.cw.Utilities;


import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import org.testng.ITestListener;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.cw.commosActions.BaseTest;
import com.cw.commosActions.BaseTest1;

public class ExtendsReportGenerator implements ITestListener {

	public static ExtentReports extent;

	public static ExtentReports extentreprts() {

		String str = "C:\\Users\\HP\\Desktop\\CogniWebsite\\CogniwizeWebsite.com\\Reports";

		ExtentSparkReporter reporter = new ExtentSparkReporter(str);

		reporter.config().setDocumentTitle("Cogniwize web Automation Project");

		reporter.config().setReportName("Cogniwize Automation");

		reporter.config().setTheme(Theme.DARK);

		ExtentReports extent = new ExtentReports();

		extent.attachReporter(reporter);

		extent.setSystemInfo("Project Name", "Cogniwize Website Automation");

		extent.setSystemInfo("User Name", "Mayur Patil");

		extent.setSystemInfo("EmpId", "CZ116");

		extent.setSystemInfo("Environment", "Automation Testing");

		extent.setSystemInfo("State Demo", " All State is Passed");

		return extent;
	}
}
