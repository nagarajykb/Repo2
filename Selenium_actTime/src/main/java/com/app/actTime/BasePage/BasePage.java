package com.app.actTime.BasePage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.app.actTime.Util.Utility;

public class BasePage {
	
	public WebDriver driver;
	public BasePage(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath = "//a[@id='logoutLink']") private WebElement logoutLink;
	@FindBy(xpath = "//div[contains(text(),'TASKS')]") private WebElement tasksMenu;
	@FindBy(linkText = "Projects & Customers") private WebElement projectCustomerLink;
	@FindBy(xpath = "//div[@class='popup_menu_label'][contains(text(),'Settings')]") private WebElement settings;
	@FindBy(linkText = "Licenses") private WebElement licenses;
	
	public static final By allOptions=By.xpath("//ul/li");
	public static final By allDates = By.xpath("//table[@class='x-date-inner']//td");
	
	//"//span[@class='successmsg']"
	@FindBy(className = "successmsg") private WebElement successMSG;
	//xpath = "//span[contains(text(),'Username or Password is invalid. Please try again.')]")
	@FindBy(className = "errormsg") private WebElement errMsg;
	
	
	
	public void logout() {
		logoutLink.click();
	}
	public void goToCustomerPage() {
		Utility.waitForWebElement(driver, tasksMenu, 20);
		tasksMenu.click();
		Utility.waitForWebElement(driver, projectCustomerLink, 20);
		projectCustomerLink.click();
	}
	public void clickSettings() {
		Utility.waitForWebElement(driver, settings, 20);
		settings.click();
	}
	public void clickLicenses() {
		Utility.waitForWebElement(driver, licenses, 20);
		licenses.click();
		
	}
}
