package com.app.actTime.Testscripts;

import org.testng.annotations.Test;

import com.app.actTime.Generics.BaseTest;
import com.app.actTime.Generics.Excel;
import com.app.actTime.Pages.EnterTimeTrackPage;
import com.app.actTime.Pages.LoginPage;

public class ValidLogin extends BaseTest {
	
	@Test
	public void testValidLogin() throws InterruptedException {
		String un = Excel.getData(XL_PATH, "validLogin", 1, 0);
		String pwd = Excel.getData(XL_PATH, "validLogin", 1, 1);
//		String title = Excel.getData(XL_PATH, "validLogin", 1, 2);
		//Enter valid username
		LoginPage lp = new LoginPage(driver);
		Thread.sleep(2000);
		lp.setUsername(un);
		lp.setPassword(pwd);
		lp.clickLogin();
		//Verify home page is displayed or not
		EnterTimeTrackPage timeTrack_hp = new EnterTimeTrackPage(driver);
//		timeTrack_hp.verifyPageIsDisplayed(title);
	}

}
