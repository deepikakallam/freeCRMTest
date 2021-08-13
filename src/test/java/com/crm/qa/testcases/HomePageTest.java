package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class HomePageTest extends TestBase {
	LoginPage loginpage;
	HomePage homepage;
	ContactsPage contactsPage;
	public HomePageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initialization();
		loginpage = new LoginPage();
		contactsPage=new ContactsPage();
		homepage = loginpage.login(prop.getProperty("email"), prop.getProperty("password"));
	}

	@Test(priority=1)
	public void verifyHomePageTitleTest() {
		String homepagetitle = homepage.verifyhomepageTitle();
		Assert.assertEquals(homepagetitle, "Cogmento CRM", "homepage title not matched");
	}

	@Test(priority=2)
	public void usernameLabelTest() {
		Assert.assertTrue(homepage.usernameLabel());
	}
	@Test(priority=3)
	public void verifyContactsLinkTest() {
		contactsPage=homepage.clickOnContactslink();
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
