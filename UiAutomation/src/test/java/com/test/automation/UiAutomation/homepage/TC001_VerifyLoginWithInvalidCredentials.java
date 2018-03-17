package com.test.automation.UiAutomation.homepage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
public class TC001_VerifyLoginWithInvalidCredentials 

{
	WebDriver driver;
@BeforeTest
public void setup()
{

	System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir")+"//driver//geckodriver.exe");
	driver=new FirefoxDriver();
	driver.get("http://automationpractice.com/index.php");
}
@Test
public void verifyloginwithinvalidcredentials() throws InterruptedException
{
	
	driver.findElement(By.xpath("//*[@id='header']/div[2]/div/div/nav/div[1]/a")).click();
	driver.findElement(By.xpath("//*[@id='email']")).sendKeys("rakesh.iter10@gmail.com");
	driver.findElement(By.xpath("//*[@id='passwd']")).sendKeys("SWIFT@0467");
	driver.findElement(By.xpath("//*[@id='SubmitLogin']")).click();
	Thread.sleep(3000);
}

public void endTest()
{
	driver.close();
}
}
