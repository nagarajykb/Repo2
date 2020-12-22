package com.app.actTime.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;

import com.app.actTime.BasePage.BasePage;
import com.app.actTime.Util.Utility;

public class LicensePage extends BasePage {

	public LicensePage(WebDriver driver){
		super(driver);
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath = "//td[contains(text(),'Jun 02, 2017')]") private WebElement issueDate;
	
	public void verifyIssueDate(String expected) {
		Utility.waitForWebElement(driver, issueDate, 15);
		Reporter.log(issueDate.getText(),true);
		Assert.assertEquals(issueDate.getText(), expected);
	}
}
