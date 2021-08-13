package com.crm.qa.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.log4testng.Logger;

public class Logintest {
	WebDriver driver;
Logger log=Logger.getLogger(Logintest.class);
	@BeforeMethod
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "./Resources/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.google.com/");
	}

	@Test(priority=1)
	public void googleTitle() {
		String title = driver.getTitle();
		System.out.println(title);
		Assert.assertEquals(title, "Google","title is not matched");
	}
	@Test(priority=2)
	public void googleImage() {
		boolean msgDisplayed = driver.findElement(By.xpath("//img[@alt='Google']")).isDisplayed();
		Assert.assertTrue(msgDisplayed);
	}

	@AfterMethod
	public void tearDown() {
		driver.close();
	}
}
