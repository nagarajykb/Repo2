package com.app.actTime.Testscripts;

import org.testng.Reporter;
import org.testng.annotations.Test;

import com.app.actTime.Generics.BaseTest;
import com.app.actTime.Generics.Excel;
import com.app.actTime.Pages.LoginPage;

public class InvalidLogin extends BaseTest {
	
	@Test
	public void testInvalidLogin() throws InterruptedException {
		int rc = Excel.getRowCount(XL_PATH, "InvalidLogin");
		Reporter.log("Row count: "+rc, true);
		
		for(int i=1; i<=rc; i++) {
			String un = Excel.getData(XL_PATH, "InvalidLogin", i, 0);
			String pwd = Excel.getData(XL_PATH, "InvalidLogin", i, 1);
			Reporter.log("Username: "+un, true);
			Reporter.log("Password: "+pwd, true);
			// Enter Invalid username and password
			LoginPage lp = new LoginPage(driver);
			lp.setUsername(un);
			lp.setPassword(pwd);
			lp.clickLogin();
			//Verify Error message is displayed
			Thread.sleep(2000);
			lp.VerifyErrMsgDisplayed();
			Thread.sleep(1000);
		}
	}

}
