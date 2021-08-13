package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

@Listeners(com.crm.qa.testutil.CustomListeners.class)
public class ContactsPageTest extends TestBase {
	LoginPage loginpage;
	HomePage homepage;
	ContactsPage contactsPage;

	public ContactsPageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initialization();
		loginpage = new LoginPage();
		contactsPage = new ContactsPage();
		homepage = loginpage.login(prop.getProperty("email"), prop.getProperty("password"));
		homepage.clickOnContactslink();
	}

	@Test(priority = 1)
	public void verifycontactslabelTest() {
		Assert.assertTrue(contactsPage.verifycontactsLabel(), "contacts label is missing");
	}

	@Test(priority = 2)
	public void verifySelectSinglechechboxText() {
		contactsPage.selectCheckbox("Deepika Reddy");
	}

	@Test(priority = 3)
	public void verifySelectMultiplechechboxText() {
		contactsPage.selectCheckbox("Deepika Reddy");
		contactsPage.selectCheckbox("jfdhjvnc");
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
