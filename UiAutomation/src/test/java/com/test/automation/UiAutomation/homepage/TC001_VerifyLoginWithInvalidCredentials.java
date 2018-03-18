package com.test.automation.UiAutomation.homepage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.test.automation.UiAutomation.TestBase.TestBase;
import com.test.automation.UiAutomation.UiActions.Homepage;
public class TC001_VerifyLoginWithInvalidCredentials extends TestBase

{
	Homepage homepage;
@BeforeTest
public void setup()
{
	log.info("================Setting up for Testing==================");
	init();
}
@Test
public void verifyloginwithinvalidcredentials() throws InterruptedException
{
	
	log.info("====================Starting Test==============");
	
	homepage=new Homepage(driver);
	homepage.LoginToApplication("rakesh.iter10@gmail.com","test");
	Assert.assertEquals(homepage.getInvalidLoginText(), "Invalid password.");
	
	log.info("====================Test Ended==================");
}
@AfterTest
public void endTest()
{
	driver.close();
}
}
