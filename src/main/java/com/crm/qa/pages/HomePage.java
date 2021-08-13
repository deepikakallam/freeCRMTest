package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase {
	@FindBy(xpath = "//span[contains(text(),'deepika kallam')]")
	WebElement username;

	@FindBy(xpath = "//span[contains(text(),'Contacts')]")
	WebElement contactslink;

	@FindBy(xpath = "//span[contains(text(),'Deals')]")
	WebElement dealslink;

	public HomePage() {
		PageFactory.initElements(driver, this);
	}

	public String verifyhomepageTitle() {
		return driver.getTitle();
	}

	public boolean usernameLabel() {
		return username.isDisplayed();
	}

	public ContactsPage clickOnContactslink() {
		contactslink.click();
		return new ContactsPage();
	}

	public DealsPage clickOnDealslink() {
		dealslink.click();
		return new DealsPage();
	}

}
