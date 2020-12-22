package com.app.actTime.Extentreport;

import java.io.IOException;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeSuite;
/*
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;
*/
public class ExtentReport {
/*
	public static ExtentHtmlReporter htmlReporter;
	public static ExtentReports report;
	public ExtentTest extentTest;
	
	@BeforeSuite
	public void setUp() {
		htmlReporter = new ExtentHtmlReporter("user.dir"+"EXTENTREPORT_PATH");
		report = new ExtentReports();
		report.attachReporter(htmlReporter);
		htmlReporter.setAppendExisting(false);
		
		report.setSystemInfo("OS", "Windows 10");
		report.setSystemInfo("Host Name", "192.168.43.23");
		report.setSystemInfo("Environment", "QA");
		report.setSystemInfo("Username", "Nagaraj");
		
		htmlReporter.config().setChartVisibilityOnOpen(true);
		htmlReporter.config().setDocumentTitle("Extent Report");
		htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
		htmlReporter.config().setTheme(Theme.STANDARD);
	
	}
	@AfterMethod()
	 public void getResult(ITestResult result) throws IOException {
		
		if (result.getStatus() == ITestResult.FAILURE) {
		    extentTest.log(Status.FAIL, 
		    		MarkupHelper.createLabel(result.getName() + " Test case FAILED due to below issues:", ExtentColor.RED));
			extentTest.fail(result.getThrowable());
			
		} else if (result.getStatus() == ITestResult.SUCCESS) {
			extentTest.log(Status.PASS,
					MarkupHelper.createLabel(result.getName() + " Test Case PASSED", ExtentColor.GREEN));
			
		} else {
			extentTest.log(Status.SKIP,
					MarkupHelper.createLabel(result.getName() + " Test Case SKIPPED", ExtentColor.ORANGE));
			extentTest.skip(result.getThrowable());
			
		}
		
		report.flush();
	}
	/*
	@AfterSuite()
	public void tearDown() {
		
		

	}*/

} 

