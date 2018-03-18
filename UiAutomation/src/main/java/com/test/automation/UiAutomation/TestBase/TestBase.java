package com.test.automation.UiAutomation.TestBase;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestBase 
{
	
	public static final Logger log=Logger.getLogger(TestBase.class.getName());
	public WebDriver driver;
	String url="http://automationpractice.com/index.php";
	String browser="Firefox";
	
	public void init()
	{
		SelectBrowser(browser);
		geturl(url);
		String log4jconfigpath="log4j.properties";
		PropertyConfigurator.configure(log4jconfigpath);
		
	}

	private void geturl(String url) 
	{
		log.info("Navigating to Url");
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		
		
	}

	private void SelectBrowser(String browser) 
	{
		if(browser.equalsIgnoreCase("Firefox"))
		{
			log.info("Creating Object Of Browser");
			driver=new FirefoxDriver();
			
		}
		
	}
	

}
