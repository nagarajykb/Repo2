package com.app.actTime.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

import com.app.actTime.BasePage.BasePage;
import com.app.actTime.Util.Utility;

public class EnterTimeTrackPage extends BasePage {
	
	public EnterTimeTrackPage(WebDriver driver){
		super(driver);
		PageFactory.initElements(driver, this);
	}
	

	
	
	public void verifyPageIsDisplayed(String title) {
//		WebDriverWait wait = new WebDriverWait(driver,time);
		try {
//			wait.until(ExpectedConditions.titleContains(title));
			Utility.waitForWebElement(driver, 20, title);
			Reporter.log("Home page is displayed", true);
		}catch(Exception e) {
			Reporter.log("Home page is not displayed", true);
			Assert.fail();
		}
	}

}
