package com.app.actTime.Generics;

import java.io.File;
import java.io.IOException;
import java.sql.Driver;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.codehaus.plexus.util.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class AutoLib implements IAutoConst {
	
	public WebDriver driver;
	
	public WebDriver getDriver(String browserType) {
		System.out.println("============== Browser is getting ready ===========");
		if(browserType.equalsIgnoreCase("firefox")){
		System.setProperty(GECKO_KEY, GECKO_VALUE);
		driver = new FirefoxDriver();
		}else if(browserType.equalsIgnoreCase("chrome")) {
				System.setProperty(CHROME_KEY, CHROME_VALUE);
				driver = new ChromeDriver();
		}else if(browserType.equalsIgnoreCase("IE")) {
			System.setProperty(IE_KEY, IE_VALUE);
			driver = new InternetExplorerDriver();
		}
		return driver;

	}
	
	public static void getPhoto(WebDriver driver,String path) {
		TakesScreenshot t= (TakesScreenshot) driver;
	//	EventFiringWebDriver efDriver=new EventFiringWebDriver(driver);
		File srcFile =t.getScreenshotAs(OutputType.FILE);
		File destFile = new File(path);
		try {
			FileUtils.copyFile(srcFile, destFile);
		}catch(IOException e) {
			e.printStackTrace();
			System.out.println("Failed to capture screenshot");
		}
	}
	
	public static String getCurrentTime() {
		DateFormat df = new SimpleDateFormat("ss_mm_HH_dd_MM_yyyy");

		Date date = new Date();

		return df.format(date);

	}
}