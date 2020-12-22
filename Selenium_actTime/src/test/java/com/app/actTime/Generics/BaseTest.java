package com.app.actTime.Generics;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class BaseTest implements IAutoConst {
	
	public WebDriver driver;
	public ExtentReports report;
	public static ExtentTest Logger;
//	public static ExtentReports report;
	
	@BeforeSuite
	public void setupReport() {
		System.out.println("============== Report Started ==============");
		report = new ExtentReports(System.getProperty("user.dir")+"/Reports/"+getDate()+".html");
		/*
		 * System.out.println("Log:INFO- Report is getting setup");
		 * 
		 * ExtentHtmlReporter htmlReporter=new
		 * ExtentHtmlReporter(System.getProperty("user.dir")+
		 * "\\Reports\\ExtentReport.html");
		 * 
		 * report=new ExtentReports();
		 * 
		 * report.attachReporter(htmlReporter);
		 * 
		 * System.out.println("Log:INFO- Report value "+report);
		 * 
		 * System.out.println("Log:INFO- Report setup ready");
		 */
	}
	@BeforeMethod
	public void openApp() {
		AutoLib getDriver = new AutoLib();
		driver = getDriver.getDriver(browser);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(ITO, TimeUnit.SECONDS);
		driver.get(APP_URL);
	}
	@AfterMethod 
	  public void closeApp(ITestResult iTestResult){
//		path = IMG_PATH+"Screenshot_"+AutoLib.getCurrentTime()+".png";
		int status = iTestResult.getStatus(); 
		System.out.println("Get Status: "+status);  // 1

		String name = iTestResult.getName();
			System.out.println("Result name:"+name);
			if(status == 1) {
				Reporter.log("Test "+name+" is Pass",true);
			//	Logger.log(LogStatus.PASS, Logger.getDescription());
			}else if(status == 0) {
				Reporter.log("Test "+name+" is FAIL",true);
			//	AutoLib.getPhoto(driver,IMG_PATH+name+".png"); // ./screenshot/InvalidLogin.png
				AutoLib.getPhoto(driver,IMG_PATH+"Screenshot_"+AutoLib.getCurrentTime()+".png");

			}else if(status == 2){
				Reporter.log("Test "+name+" is SKIP",true);
			}
		//	report.endTest(Logger);
			System.out.println("===== Report for test is generated");
		//	driver.close();
	}
	@AfterSuite
	public void endReport()
	{
		report.flush();
		System.out.println("AfterSuite:- Extent report is generated>>> Kindly check report folder");
	}
	
	public static String getDate() {
		long time=System.currentTimeMillis();
		
		SimpleDateFormat userformat=new SimpleDateFormat("MMM-dd-yyyy-HH-mm-ss");
		
		Date date=new Date(time);
		
		String newDate=userformat.format(date);

	    return newDate;
		
	}

}
