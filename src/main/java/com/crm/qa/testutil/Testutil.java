package com.crm.qa.testutil;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.crm.qa.base.TestBase;
import com.google.common.io.Files;

public class Testutil extends TestBase {
	public static long PAGE_LOAD_TIMEOUT = 20;
	public static long IMPLICIT_WAIT = 10;

	public static void failed(String testMethodName) {

		File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		try {
			Files.copy(srcFile, new File("./FailedScreenshots/" + testMethodName + ".png"));
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}

	public static void takeScreenshotAtEndOfTest() throws IOException {
		File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String currentDir = System.getProperty("user.dir");
		Files.copy(srcFile, new File(currentDir + "/Screenshots/" + System.currentTimeMillis() + ".png"));

	}

}
