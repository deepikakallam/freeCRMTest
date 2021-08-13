package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

@Listeners(com.crm.qa.testutil.CustomListeners.class)
public class LoginPageTest extends TestBase {
	LoginPage loginpage;
	HomePage homepage;

	public LoginPageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initialization();
		loginpage = new LoginPage();
	}

	@Test(priority = 1)
	public void loginPageTitleTest() {

		String title = loginpage.validateLoginpagetitle();
		Assert.assertEquals(title, "Cogmento CRM");
	}

	@Test(priority = 2)
	public void signUpBtnTest() {
		Assert.assertTrue(loginpage.signUpButton());
	}

	@Test(priority = 3)
	public void logintest() {
		homepage = loginpage.login(prop.getProperty("email"), prop.getProperty("password"));

	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
