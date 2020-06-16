package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AddCustomerPageObj 
{
	public WebDriver driver;
	public AddCustomerPageObj(WebDriver driver) 
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public String getPageTitle()
	{
		return driver.getTitle();
	}
	
	By lnkCustomers_menu = By.xpath("//a[@href='#']//span[contains(text(),'Customers')]");
	public void clickOnCustomersMenu() 
	{
		driver.findElement(lnkCustomers_menu).click();
	}

	By lnkCustomers_menuitem = By.xpath("//span[@class='menu-item-title'][contains(text(),'Customers')]");
	public void clickOnCustomersMenuItem() 
	{
		driver.findElement(lnkCustomers_menuitem).click();
	}

	By btnAddnew = By.xpath("//a[@class='btn bg-blue']");
	public void clickOnAddNew() 
	{
		driver.findElement(btnAddnew).click();
	}

	By txtEmail = By.xpath("//input[@id='Email']");
	public void setEmail(String email) 
	{
		driver.findElement(txtEmail).sendKeys(email);
	}

	By txtPassword = By.xpath("//input[@id='Password']");
	public void setPassword(String password) 
	{
		driver.findElement(txtPassword).sendKeys(password);
	}
	
	By txtFirstName = By.xpath("//input[@id='FirstName']");
	public void setFirstName(String fname)
	{
		driver.findElement(txtFirstName).sendKeys(fname);
	}
	
	By txtLastName = By.xpath("//input[@id='LastName']");
	public void setLastName(String lname)
	{
		driver.findElement(txtLastName).sendKeys(lname);
	}
	
	By rdMaleGender = By.id("Gender_Male");
	By rdFemaleGender = By.id("Gender_Female");
	public void setGender(String gender) 
	{
		if (gender.equals("Male")) 
		{
			driver.findElement(rdMaleGender).click();
		}
		else if (gender.equals("Female")) 
		{
			driver.findElement(rdFemaleGender).click();
		}
		else 
		{
			driver.findElement(rdMaleGender).click();
		}
	}
	
	By txtDob = By.xpath("//input[@id='DateOfBirth']");
	public void setDob(String dob)
	{
		driver.findElement(txtDob).sendKeys(dob);
	}
	
	By txtCompanyName = By.xpath("//input[@id='Company']");
	public void setCompanyName(String comname)
	{
		driver.findElement(txtCompanyName).sendKeys(comname);
	}
	
	By txtnewsletter=By.xpath("//ul[@id='SelectedCustomerRoleIds_taglist']/preceding::div[5]");
	By yourstorename=By.xpath("//li[contains(text(),'Your store name')]");
	By storename2=By.xpath("//li[contains(text(),'Test store 2')]");
	public void setNewsLetter(String letter)
	{
		driver.findElement(txtnewsletter).click();
		WebElement letteritem = null;
		if(letter.equals("Your store name"))
		{
			letteritem=driver.findElement(yourstorename);
		}
		else if(letter.equals("Test store 2"))
		{
			letteritem=driver.findElement(storename2);
		}
		//letteritem.click();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", letteritem);
	}
	//By txtcustomerRoles = By.xpath("//div[@class='k-multiselect-wrap k-floatwrap']");
	By txtcustomerRoles = By.xpath("//ul[@id='SelectedCustomerRoleIds_taglist']/preceding::div[5]/following::div[8]");
	By lstitemAdmininstrators = By.xpath("//li[contains(text(),'Administrators')]");
	By lstitemRegistered = By.xpath("//li[contains(text(),'Registered')]");
	By lstitemGuests = By.xpath("//li[contains(text(),'Guests')]");
	By lstitemVendors = By.xpath("//li[contains(text(),'Vendors')]");
	public void setCustomerRoles(String role) throws InterruptedException
	{
		if (!role.equals("Vendors")) 
		{
			driver.findElement(By.xpath("//*[@id=\"SelectedCustomerRoleIds_taglist\"]/li/span[2]")).click();
		}
		driver.findElement(txtcustomerRoles).click();
		WebElement listitem;
		Thread.sleep(3000);
		if (role.equals("Administrators")) 
		{
			listitem = driver.findElement(lstitemAdmininstrators);
		} 
		else if (role.equals("Guests")) 
		{
			listitem = driver.findElement(lstitemGuests);
		}
		else if (role.equals("Registered")) 
		{
			listitem = driver.findElement(lstitemRegistered);
		}
		else if (role.equals("Vendors")) 
		{
			listitem = driver.findElement(lstitemVendors);
		}
		else
		{
			listitem = driver.findElement(lstitemGuests);
		}
		//listitem.click();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", listitem);
	}

	By drpmgrOfVendor = By.xpath("//*[@id='VendorId']");
	public void setManagerOfVendor(String value) 
	{
		Select drp = new Select(driver.findElement(drpmgrOfVendor));
		drp.selectByVisibleText(value);
	}

	/*By txtNewsLetter = By.xpath("//li[contains(text(),'Your store name')]");
	public void setNewsLetter()
	{
		driver.findElement(txtNewsLetter).click();
	}*/
	
	By txtAdminContent = By.xpath("//textarea[@id='AdminComment']");
	public void setAdminContent(String content)
	{
		driver.findElement(txtAdminContent).sendKeys(content);
	}
	
	By btnSave = By.xpath("//button[@name='save']");
	public void clickOnSave()
	{
		driver.findElement(btnSave).click();
	}
}
