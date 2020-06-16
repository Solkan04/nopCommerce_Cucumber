package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageObj 
{
	public WebDriver driver;
	public LoginPageObj(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="Email")
	@CacheLookup
	WebElement txtEmail;
	public void setUserName(String uname)
	{
		txtEmail.clear();
		txtEmail.sendKeys(uname);
	}
	
	@FindBy(id="Password")
	@CacheLookup
	WebElement txtPassword;
	public void setPassword(String pwd)
	{
		txtPassword.clear();
		txtPassword.sendKeys(pwd);
	}
	
	@FindBy(xpath="//input[@value='Log in']")
	@CacheLookup
	WebElement btnLogin;
	public void clickLogin()
	{
		btnLogin.click();
	}
	
	@FindBy(linkText="Logout")
	@CacheLookup
	WebElement lnkLogout;
	public void clickLogout()
	{
		lnkLogout.click();
	}
}
