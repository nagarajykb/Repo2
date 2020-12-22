package com.app.actTime.Testscripts;

import org.testng.annotations.Test;

import com.app.actTime.Generics.BaseTest;
import com.app.actTime.Pages.Create_Customer_Page;
import com.app.actTime.Pages.LoginPage;

public class AT_CustomerCreate extends BaseTest {

	@Test() 
	public void testAT_CustomerCreate() { 
		LoginPage lp = new LoginPage(driver);
		lp.login(un, pw);
		Create_Customer_Page ccp = new Create_Customer_Page(driver);
		ccp.goToCustomerPage();
		ccp.clickCreateCustomer();
		ccp.enterCustomerName(cName);
		ccp.clickCreateCustSubmitBTN();
	//	ccp.verifySuccessMSG("successmsg");
	}
}