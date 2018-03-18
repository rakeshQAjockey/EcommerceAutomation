package com.test.automation.UiAutomation.TestBase;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.test.automation.UiAutomation.excelReader.ExcelReader;

public class TestBase 
{
	ExcelReader excel;
	
	public static final Logger log=Logger.getLogger(TestBase.class.getName());
	public WebDriver driver;
	String url="https://www.gmail.com";
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
	
	public String[][] getdata(String sheetname,String excelname)
	{
		//C:\Users\Rakesh\git\EcommerceRepository\UiAutomation\src\main\java\com\test\automation\UiAutomation\data\TestData.xlsx
		String path=System.getProperty("user.dir")+"\\src\\main\\java\\com\\test\\automation\\UiAutomation\\data\\"+excelname+".xlsx";
	
		excel= new ExcelReader(path);
		String [][]data=excel.getDataFromSheet(sheetname, excelname);
		return data;
	}
	
	public void waitForElement(int timeoutInSeconds,WebElement element)
	{
		WebDriverWait wait=new WebDriverWait(driver, timeoutInSeconds);
		wait.until(ExpectedConditions.visibilityOf(element));
		
	}
	

}
