package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class ContactsPage extends TestBase {
	@FindBy(xpath = "//th[text()='Name']")
	WebElement contactsLabel;
	@FindBy(xpath = "//input[@type='checkbox']")
	WebElement checkbok;

	public ContactsPage() {
		PageFactory.initElements(driver, this);
	}

	public boolean verifycontactsLabel() {
		return contactsLabel.isDisplayed();
	}

	public void selectCheckbox(String name) {
		driver.findElement(By.xpath("//a[text()='" + name
				+ " ']//parent::td//preceding-sibling::td//div[@class='ui fitted read-only checkbox']//input[@name='id']")).click();
	}
}
