package com.app.actTime.Testscripts;

import org.testng.annotations.Test;

import com.app.actTime.Generics.BaseTest;
import com.app.actTime.Pages.Create_Project_Page;
import com.app.actTime.Pages.LoginPage;

public class AT_ProjectCreate extends BaseTest {

	@Test
	public void testProjectCreate() {
		LoginPage lp = new LoginPage(driver);
		lp.login(un, pw);
		Create_Project_Page cproject = new Create_Project_Page(driver);
		cproject.goToCustomerPage();
		cproject.clickCreateProject();
		cproject.enterProjectName(pName);
		cproject.selectCustomListBoxValues(cName);
		cproject.submitCreateProjectBTN();
		
	}
}
