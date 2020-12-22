package com.app.actTime.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class LoginPage {
	
	public LoginPage(WebDriver driver){
		PageFactory.initElements(driver, this);
	}
	@FindBy(id = "username") private WebElement unTB;
	@FindBy(name = "pwd") private WebElement pwTB;
	@FindBy(id = "loginButton") private WebElement loginBTN;
	
	@FindBy(xpath="//span[contains(text(),'Username or Password is invalid. Please try again.')]")
	private WebElement errMsg;
	
	//set Username
	public void setUsername(String un) {
		unTB.sendKeys(un);
	}
	//set password
	public void setPassword(String pw) {
		pwTB.sendKeys(pw);
	}
	public void clickLogin() {
		loginBTN.click();
	}
	public void VerifyErrMsgDisplayed()
	{
	/*	boolean actual = errMsg.isDisplayed();
		Assert.assertEquals(actual, true);*/
		
		Assert.assertTrue(errMsg.isDisplayed());
	}
	public void login(String un, String pw) {
		unTB.sendKeys(un);
		pwTB.sendKeys(pw);
		loginBTN.click();
	}

}
