package com.test.automation.UiAutomation.homepage;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.test.automation.UiAutomation.TestBase.TestBase;
import com.test.automation.UiAutomation.UiActions.Homepage;

public class TC002_RegisterNewUser extends TestBase
{
	public static final Logger log=Logger.getLogger(TC002_RegisterNewUser.class.getName());
			Homepage homepage;
	@BeforeTest
	public void setup()
	{
		init();
		
	}
	
	@Test
	public void RegisterNewUser() throws InterruptedException
	{
		
		log.info("====================Starting Test==============");
		
		homepage=new Homepage(driver);
		homepage.NewUserRegistration("Rakesh.it@gmail.com", "Rakesh", "Nayak", "SWIFT@0467", "Rakesh", "Nayak", "Kondapur", "Hyderabad", "Indiana", "50008", "7218494792", "My New Address");
		Thread.sleep(10000);
		Assert.assertEquals(homepage.NewUserRegisteredSuccessfully(),"MY ACCOUNT");
		
		log.info("====================Test Ended==================");
	}
	@AfterTest
	public void endTest()
	{
		driver.quit();
	}
	}
