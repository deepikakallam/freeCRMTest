package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase {
	@FindBy(name = "email")
 WebElement username;
	@FindBy(name = "password")
	 WebElement password;
	@FindBy(xpath = "//div[text()='Login']")
	 WebElement loginBtn;
	@FindBy(xpath = "//a[text()='Sign Up']")
 WebElement signUpBtn;
	@FindBy(xpath = "//a[text()='Forgot your password?']")
	 WebElement forgotpasswordBtn;

	public  LoginPage() {
		PageFactory.initElements(driver, this);
	}

	public String validateLoginpagetitle() {
		return driver.getTitle();
	}
	public HomePage login(String em,String pwd) {
		username.sendKeys(em);
		password.sendKeys(pwd);
		loginBtn.click();
		return new HomePage();
	}
	public boolean signUpButton() {
		return signUpBtn.isDisplayed();
	}

}
