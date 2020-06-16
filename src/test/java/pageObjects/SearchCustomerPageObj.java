package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import utilities.WaitHelper;

public class SearchCustomerPageObj 
{
	public WebDriver driver;
	WaitHelper wh;
	public SearchCustomerPageObj(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		wh=new WaitHelper(driver);
	}
	
	@FindBy(how = How.ID, using = "SearchEmail")
	@CacheLookup
	WebElement txtEmail;
	public void setEmail(String email)
	{
		wh.waitForElement(txtEmail, 30);
		txtEmail.clear();
		txtEmail.sendKeys(email);
	}
	
	@FindBy(how = How.ID, using = "SearchFirstName")
	@CacheLookup
	WebElement txtFirstName;
	public void setFirstName(String fname)
	{
		wh.waitForElement(txtFirstName, 30);
		txtFirstName.clear();
		txtFirstName.sendKeys(fname);
	}
	
	@FindBy(how = How.ID, using = "SearchLastName")
	@CacheLookup
	WebElement txtLastName;
	public void setLastName(String lname)
	{
		wh.waitForElement(txtLastName, 30);
		txtLastName.clear();
		txtLastName.sendKeys(lname);
	}
	
	@FindBy(how = How.ID, using = "SearchMonthOfBirth")
	@CacheLookup
	WebElement drpdobMonth;
	
	@FindBy(how = How.ID, using = "SearchDayOfBirth")
	@CacheLookup
	WebElement drpdobDay;
	
	@FindBy(how = How.ID, using = "SearchCompany")
	@CacheLookup
	WebElement txtCompany;
	
	@FindBy(how = How.XPATH, using = "//div[@class='k-multiselect-wrap k-floatwrap']")
	@CacheLookup
	WebElement txtcustomerRoles;
	
	@FindBy(how = How.XPATH, using = "//li[contains(text(),'Administrators')]")
	@CacheLookup
	WebElement lstitemAdministrators;
	
	@FindBy(how = How.XPATH, using = "//li[contains(text(),'Registered')]")
	@CacheLookup
	WebElement lstitemRegistered;
	
	@FindBy(how = How.XPATH, using = "//li[contains(text(),'Guests')]")
	@CacheLookup
	WebElement lstitemGuests;
	
	@FindBy(how = How.XPATH, using = "//li[contains(text(),'Vendors')]")
	@CacheLookup
	WebElement lstitemVendors;
	
	@FindBy(how = How.ID, using = "search-customers")
	@CacheLookup
	WebElement btnSearch;
	public void clickSearch()
	{
		btnSearch.click();
		wh.waitForElement(btnSearch, 30);
	}
	
	@FindBy(how = How.XPATH, using = "//table[@role='grid']")
	@CacheLookup
	WebElement tblSearchResults;
	
	@FindBy(how = How.XPATH, using = "//table[@id='customers-grid']")
	@CacheLookup
	WebElement table;
	public boolean searchCustomerByEmail(String email)
	{
		boolean flag=false;
		for(int i=1;i<=getNoOfRows();i++)
		{
			String emailid=table.findElement(By.xpath("//table[@id='customers-grid']/tbody/tr["+i+"]/td[2]")).getText();
			if(emailid.equals(email))
			{
				flag=true;
			}
		}
		return flag;
	}
	
	public boolean searchCustomerByName(String Name)
	{
		boolean flag=false;
		for(int i=1;i<=getNoOfRows();i++)
		{
			String name=table.findElement(By.xpath("//table[@id='customers-grid']/tbody/tr["+i+"]/td[3]")).getText();
			String names[]=name.split(" ");
			if(names[0].equals("Victoria") && names[1].equals("Terces"))
			{
				flag=true;
			}
		}
		return flag;
	}
	
	@FindBy(how = How.XPATH, using = "//table[@id='customers-grid']//tbody/tr")
	@CacheLookup
	List<WebElement> tableRows;
	public int getNoOfRows()
	{
		return (tableRows.size());
	}
	
	@FindBy(how = How.XPATH, using = "//table[@id='customers-grid']//tbody/tr/td")
	@CacheLookup
	List<WebElement> tableColumns;
	public int getNoOfColumns()
	{
		return (tableColumns.size());
	}

}
