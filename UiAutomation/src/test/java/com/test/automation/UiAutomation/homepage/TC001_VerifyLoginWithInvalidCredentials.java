package com.test.automation.UiAutomation.homepage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
public class TC001_VerifyLoginWithInvalidCredentials 

{
public void setup()
{
	WebDriver driver;
	
	System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir")+"//driver//geckodriver.exe");
	driver=new FirefoxDriver();
	driver.get("http://automationpractice.com/index.php");
	
	
	
}
}
