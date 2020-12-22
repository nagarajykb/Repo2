package com.app.actTime.Testscripts;

import org.testng.annotations.Test;

import com.app.actTime.Generics.BaseTest;
import com.app.actTime.Generics.Excel;
import com.app.actTime.Pages.EnterTimeTrackPage;
import com.app.actTime.Pages.LicensePage;
import com.app.actTime.Pages.LoginPage;


public class CheckIssueDate extends BaseTest {
	
	@Test
	public void testIssueDate() throws InterruptedException {
		String un = Excel.getData(XL_PATH, "CheckIssuseDate", 1, 0);
		 String pw = Excel.getData(XL_PATH, "CheckIssuseDate", 1, 1);
		 String iDate = Excel.getData(XL_PATH, "CheckIssuseDate", 1, 2);
		 //Enter valid username
		 LoginPage lp=new LoginPage(driver);
		 Thread.sleep(2000);
		 lp.setUsername(un);
		 lp.setPassword(pw);
		 lp.clickLogin();
		 EnterTimeTrackPage e=new EnterTimeTrackPage(driver);
		 Thread.sleep(2000);
		 e.clickSettings();
		 Thread.sleep(2000);
		 e.clickLicenses();
		 LicensePage license = new LicensePage(driver);
		 Thread.sleep(2000);
		 license.verifyIssueDate(iDate);
		
		
	}

}
