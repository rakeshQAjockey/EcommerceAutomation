package com.test.automation.UiAutomation.homepage;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.test.automation.UiAutomation.TestBase.TestBase;
import com.test.automation.UiAutomation.UiActions.Homepage;

public class TC003_VerifyLoginWithDifferentData extends TestBase
{

	public static final Logger log=Logger.getLogger(TC003_VerifyLoginWithDifferentData.class.getName());
			Homepage homepage;
			
			
			String Email_Address="Rakesh.iter10@gmail.com";
			String Password="test1456";
			
			@DataProvider(name="LoginData")
			public String[][] getTestData()
			{
				String[][] testRecords=getdata("LoginTestData", "TestData");
				return testRecords;
			}
			@Test
			public void setup()
			{
				init();
			}
			@Test(dataProvider="LoginData")
			public void testLogin(String Email_Address,String Password ,String Runmode)
			{
				if(Runmode.equalsIgnoreCase("n"))
				{
					throw new SkipException("User Marked this record as no run");
				}
				homepage=new Homepage(driver);
				homepage.LoginToDemoSite(Email_Address, Password);
				boolean status=homepage.GmailLoginSuccess();
				if(status)
				{
					homepage.ClickOnSignOut();
					
				}
				Assert.assertEquals(true, status);
				log.info("===Fineshed Verify Login with Different user");
			}
}
