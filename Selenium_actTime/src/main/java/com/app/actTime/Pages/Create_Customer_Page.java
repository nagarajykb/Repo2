package com.app.actTime.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.app.actTime.BasePage.BasePage;
import com.app.actTime.Util.Utility;

public class Create_Customer_Page extends BasePage {
	
	public Create_Customer_Page(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath = "//div[@id='ext-comp-1002']//span[contains(text(),'Create Customer')]")	private WebElement clickCreateCustBTN;
	@FindBy(id = "customerLightBox_nameField") private WebElement enterCustName;
	@FindBy(xpath = "//span[@class='buttonTitle'][contains(text(),'Create Customer')]")	private WebElement clickCreateCustSubmitBTN;
	
	public void clickCreateCustomer() {
		clickCreateCustBTN.click();
	}
	public void enterCustomerName(String cName) {
		enterCustName.sendKeys(cName);
	}
	public void clickCreateCustSubmitBTN() {
		Utility.waitForWebElement(driver, clickCreateCustSubmitBTN, 30);
		clickCreateCustSubmitBTN.click();
	}

}
