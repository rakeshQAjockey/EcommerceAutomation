package com.test.automation.UiAutomation.UiActions;

import org.apache.commons.logging.Log;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.test.automation.UiAutomation.TestBase.TestBase;

public class Homepage extends TestBase
{
	public static final Logger log=Logger.getLogger(Homepage.class.getName());
	WebDriver driver;
	
	@FindBy(xpath="//*[@id='header']/div[2]/div/div/nav/div[1]/a")
	WebElement SignIn;
	
	@FindBy(xpath="//*[@id='email']")
	WebElement EmailAddress;
	
	@FindBy(xpath="//*[@id='passwd']")
	WebElement Password;
	
	@FindBy(xpath="//*[@id='SubmitLogin']")
	WebElement Submit;
	
	@FindBy(xpath="//*[@id='center_column']/div[1]/ol/li")
	WebElement LoginFailedMessage;
	
	@FindBy(xpath = "//*[@id='email_create']")
	WebElement CreateEmail;
	@FindBy(xpath = "//*[@id='SubmitCreate']")
	WebElement SubmitCreate;
	@FindBy(xpath = "//*[@id='id_gender1']")
	WebElement Gender;
	@FindBy(xpath = "//*[@id='customer_firstname']")
	WebElement FirstName;
	@FindBy(xpath = "//*[@id='customer_lastname']")
	WebElement LastName;

	@FindBy(xpath = "//*[@id='passwd']")
	WebElement NewUserPassword;
	@FindBy(xpath = "//*[@id='days']")
	WebElement DOB_Days;

	@FindBy(xpath = "//*[@id='months']")
	WebElement DOB_Months;
	
	//*[@id='years']
	@FindBy(xpath = "//*[@id='years']")
	WebElement DOB_Years;
	
	@FindBy(xpath = "//*[@id='firstname']")
	WebElement Address_Firstname;
	
	@FindBy(xpath = "//*[@id='lastname']")
	WebElement Address_Lastname;
	
	@FindBy(xpath = "//*[@id='address1']")
	WebElement Address_address1;
	
	@FindBy(xpath = "//*[@id='city']")
	WebElement Address_City;
	
	
	@FindBy(xpath = "//*[@id='id_state']")
	WebElement Address_State;
	
	@FindBy(xpath = "//*[@id='postcode']")
	WebElement Address_PostalCode;
	
	@FindBy(xpath = "//*[@id='id_country']")
	WebElement Address_Country;
	
	@FindBy(xpath = "//*[@id='phone_mobile']")
	WebElement Address_MobileNo;
	
	
	@FindBy(xpath = "//*[@id='alias']")
	WebElement Address_alias;
	
	@FindBy(xpath = "//*[@id='submitAccount']")
	WebElement Register_NewUser;
	
	
	@FindBy(xpath = "//div[@id='center_column']/h1")
	WebElement NewUser_RegistorSuccessfully;
	
	
	@FindBy(xpath = "html/body/nav/div/a[2]")
	WebElement Gmail_SIGNIN;
	
	@FindBy(xpath="//*[@id='identifierId']")
	WebElement Gmail_Username;
	
	@FindBy(xpath="//*[@id='identifierNext']/content/span")
	WebElement Gmail_Next;
	
	@FindBy(xpath="//*[@id='password']/div[1]/div/div[1]/input")
	WebElement Gmail_Password;
	
	@FindBy(xpath=".//*[@id='passwordNext']/content/span")
	WebElement Gmail_PassNExt;
	
	
	
	@FindBy(xpath="//*[@id='gb']/div[1]/div[1]/div[2]/div[5]/div[1]/a/span")
	WebElement Gmail_Profile;
	
	@FindBy(xpath="//*[@id='gb_71']")
	WebElement SignOut;
	
	
	
	@FindBy(xpath="//*[@id='gbq1']/div/a/span")
	WebElement lOGIN_SUCCESS;
	
	public Homepage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	public void LoginToApplication(String Username,String password)
	{
		SignIn.click();
		log.info("Clicked in SignIn Button :"+SignIn.toString());
		EmailAddress.sendKeys(Username);
		log.info("Email Adress is entered :"+EmailAddress.toString());
		Password.sendKeys(password);
		log.info("Password is entered :"+Password.toString());
		Submit.click();
		log.info("Clicked on Submit Button"+Submit.toString());
		
		
	}
	
	public String getInvalidLoginText()
	{
		log.info("Login Failed :"+ "Invalid Credentials");
		return LoginFailedMessage.getText();
	}

	public void NewUserRegistration(String C_email,String customer_firstname,String customer_lastname,String customer_password,String address_firstname,String address_lastname,String address_1,String address_city,
			String address_state,String address_postal,String address_mobile,String address_alias)
	{
		SignIn.click();
		CreateEmail.sendKeys(C_email);
		log.info("New User email id Entered");
		SubmitCreate.click();
		log.info("Create button is clicked");
		Gender.click();
		log.info("Gender is selected");
		FirstName.clear();
		FirstName.sendKeys(customer_firstname);
		log.info("FirstName is entered");
		LastName.clear();
		LastName.sendKeys(customer_lastname);
		log.info("LastName is entered");
		NewUserPassword.clear();
		NewUserPassword.sendKeys(customer_password);
		Select dob_day=new Select(DOB_Days);
		dob_day.selectByIndex(14);
		Select dob_month=new Select(DOB_Months);
		dob_month.selectByIndex(7);
		Select dob_years=new Select(DOB_Years);
		dob_years.selectByIndex(27);
		log.info("DOB is selected");
		Address_Firstname.clear();
		Address_Firstname.sendKeys(address_firstname);
		log.info("Address section FirstName is entered");
		Address_Lastname.clear();
		Address_Lastname.sendKeys(address_lastname);
		log.info("Address section LastName is entered");
		Address_address1.clear();
		Address_address1.sendKeys(address_1);
		log.info("Address 1  is entered");
		Address_City.clear();
		Address_City.sendKeys(address_city);
		log.info("Address city is entered");
		Select add_state=new Select(Address_State);
		add_state.selectByVisibleText(address_state);
		log.info("Address state is entered");
		Address_PostalCode.clear();
		Address_PostalCode.sendKeys(address_postal);
		log.info("Postal Code is entered");
		Select add_country=new Select(Address_State);
		add_country.selectByIndex(21);
		log.info("Address Country is entered");
		Address_MobileNo.clear();
		Address_MobileNo.sendKeys(address_mobile);
		log.info("Mobile No  is entered");
		Address_alias.clear();
		Address_alias.sendKeys(address_alias);
		log.info("Address alias is entered");
		Register_NewUser.click();
		
		
	}
	
	public String NewUserRegisteredSuccessfully() {
		log.info("New User Registered Successfully :" +NewUser_RegistorSuccessfully.toString());
		return NewUser_RegistorSuccessfully.getText();
		
	}
	
	public void LoginToDemoSite(String Email,String Pass)
	{
		
		Gmail_Username.sendKeys(Email);
		Gmail_Next.click();
		Gmail_Password.sendKeys(Pass);
		Gmail_PassNExt.click();
		
	}
	
	
	public boolean GmailLoginSuccess()
	{
		try
		{
		//waitForElement(300, lOGIN_SUCCESS);
		log.info("Gmail User Logged in Successfully");
		lOGIN_SUCCESS.isDisplayed();
		return true;
	}catch(Exception e)
		{
		return false;
		}
}
	public void ClickOnSignOut()
	
	{
		
		Gmail_Profile.click();
		SignOut.click();
		log.info("User Logout from gmail" );
	}
}
