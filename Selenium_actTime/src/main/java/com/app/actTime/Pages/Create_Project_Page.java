package com.app.actTime.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.app.actTime.BasePage.BasePage;
import com.app.actTime.Util.Utility;

public class Create_Project_Page extends BasePage {

	Utility utility = new Utility(driver);
	public Create_Project_Page(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath = "//span[contains(text(),'Create Project')]") private WebElement clickCreateProjectBTN;
	@FindBy(xpath = "//input[@id='projectPopup_projectNameField']")	private WebElement enterProjectName;
	//tbody/tr[@id='ext-gen105']/td[2]/em[1]
	@FindBy(xpath = "//tbody/tr[@id='ext-gen29']/td[2]/em[1]")  //div[@id='projectPopup_customerSelectorPlaceholder']
	private WebElement clickCustomerListBox;
		
	@FindBy(xpath = "//tbody/tr[1]/td[2]/div[1]/div[1]/span[1]")
	private WebElement submit_CreateProjectBTN;

	
	public void clickCreateProject() {
		clickCreateProjectBTN.click();
	}
	public void enterProjectName(String pName) {
		enterProjectName.sendKeys(pName);
	}
	public void selectCustomListBoxValues(String exptecteValue) {
		clickCustomerListBox.click();
		utility.customListBoxGetText(BasePage.allOptions, exptecteValue);
	}

	public void submitCreateProjectBTN() {
		submit_CreateProjectBTN.click();
	}
	
}
