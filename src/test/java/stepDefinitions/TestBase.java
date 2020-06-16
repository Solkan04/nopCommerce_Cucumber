package stepDefinitions;

import java.util.Properties;

import org.apache.commons.lang.RandomStringUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import pageObjects.AddCustomerPageObj;
import pageObjects.LoginPageObj;
import pageObjects.SearchCustomerPageObj;

public class TestBase 
{
	public WebDriver driver;
	public LoginPageObj lpo;
	public AddCustomerPageObj acpo;
	public SearchCustomerPageObj scpo;
	public static Logger logger;
	public Properties configProp;
	
	//Created for generating random string for unique email id
	public static String randomStringGenerator()
	{
		String generateString1=RandomStringUtils.randomAlphabetic(5);
		return generateString1;
	}
}
