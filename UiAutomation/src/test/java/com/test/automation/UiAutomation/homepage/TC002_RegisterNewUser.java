package com.test.automation.UiAutomation.homepage;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.test.automation.UiAutomation.TestBase.TestBase;
import com.test.automation.UiAutomation.UiActions.Homepage;

public class TC002_RegisterNewUser extends TestBase
{
	Homepage hompage;
	@BeforeTest
	public void setup()
	{
		init();
		
	}
	
	@Test
	public void RegisterNewUser() throws InterruptedException
	{
		
		log.info("====================Starting Test==============");
		
		hompage=new Homepage(driver);
		hompage.NewUserRegistration("Rakesh.it@gmail.com", "Rakesh", "Nayak", "SWIFT@0467", "Rakesh", "Nayak", "Kondapur", "Hyderabad", "Indiana", "50008", "7218494792", "My New Address");
		Thread.sleep(10000);
		Assert.assertEquals(hompage.NewUserRegisteredSuccessfully(),"MY ACCOUNT");
		
		log.info("====================Test Ended==================");
	}
	@AfterTest
	public void endTest()
	{
		driver.quit();
	}
	}
