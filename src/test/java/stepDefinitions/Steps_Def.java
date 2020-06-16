package stepDefinitions;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.AddCustomerPageObj;
import pageObjects.LoginPageObj;
import pageObjects.SearchCustomerPageObj;

public class Steps_Def extends TestBase
{
	@Before//hooks
	public void setUp() throws IOException
	{
		//Reading properties
		configProp=new Properties();
		FileInputStream configPropfile=new FileInputStream("config.properties");
		configProp.load(configPropfile);
				
		//Browser set up
		String br=configProp.getProperty("browser");
		//String path = System.getProperty("user.dir");
		if(br.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", configProp.getProperty("chromepath"));
			driver = new ChromeDriver();
		}
		else if(br.equals("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", configProp.getProperty("firefoxpath"));
			driver = new FirefoxDriver();
		}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		//BasicConfigurator.configure();
		//logger=Logger.getLogger("Steps_Def");//Here we mention the project name
		//PropertyConfigurator.configure("log4j.properties");//Here we mention the path of log4j properties file
		//logger.info("****************Lauching Browser********************");

	}
	@Given("User Launch Chrome Browser")
	public void user_Launch_Chrome_Browser() 
	{
		lpo = new LoginPageObj(driver);
	}

	@When("User Opens URL {string}")
	public void user_Opens_URL(String url) 
	{
		driver.get(url);
	}

	@When("User Enters Email As {string} and Password As {string}")
	public void user_Enters_Email_As_and_Password_As(String email, String password) 
	{
		lpo.setUserName(email);
		lpo.setPassword(password);
	}

	@When("Click On Login")
	public void click_On_Login() 
	{
		lpo.clickLogin();
	}

	@Then("Page Title After Login Should Be {string}")
	public void page_Title_After_Login_Should_Be(String logintitle) 
	{
		String pagesrc = driver.getPageSource();
		if (pagesrc.contains("Login was unsuccessful.")) 
		{
			driver.close();
			Assert.assertTrue(false);
		}
		else 
		{
			Assert.assertEquals(logintitle, driver.getTitle());
		}
	}

	@When("User Click On Log Out Link")
	public void user_Click_On_Log_Out_Link() 
	{
		lpo.clickLogout();
	}

	@Then("Page Title After Logout Should Be {string}")
	public void page_Title_After_Logout_Should_Be(String logouttitle) 
	{
		String actualtitle = driver.getTitle();
		if (actualtitle.contains(logouttitle)) 
			Assert.assertTrue("Logout Successful", true);
		else
			Assert.assertTrue("Logout Unsuccessful", false);
	}

	@Then("Close Browser")
	public void close_Browser() 
	{
		driver.close();
	}
	
	///Customers add feature
	@Then("User Can View Dashboard")
	public void user_Can_View_Dashboard() 
	{
		acpo=new AddCustomerPageObj(driver);
		Assert.assertEquals("Dashboard / nopCommerce administration", acpo.getPageTitle());	
	}

	@When("User Click On Customers Menu")
	public void user_Click_On_Customers_Menu() 
	{
		acpo.clickOnCustomersMenu();
	}

	@When("Click On Customers Menu Item")
	public void click_On_Customers_Menu_Item() 
	{
		acpo.clickOnCustomersMenuItem();
	}

	@When("Click On Add New Button")
	public void click_On_Add_New_Button() 
	{
		acpo.clickOnAddNew();
	}

	@Then("User Can View Add New Customer Page")
	public void user_Can_View_Add_New_Customer_Page() 
	{
		Assert.assertEquals("Add a new customer / nopCommerce administration", acpo.getPageTitle());
	}

	@When("User Enter Customer Info")
	public void user_Enter_Customer_Info() throws InterruptedException 
	{
		String email=randomStringGenerator()+"@gmail.com";
		acpo.setEmail(email);
		acpo.setPassword("test123");
		acpo.setFirstName("Mahesh");
		acpo.setLastName("SC");
		acpo.setGender("Male");
		acpo.setDob("04/11/1991");
		acpo.setCompanyName("VMD");
		acpo.setNewsLetter("Your store name");
		//Registered default
		//The customer cannot be in both 'Guests' & 'Registered' customer roles
		//Add the customer to 'Guests' or 'Registered' customer role
		acpo.setCustomerRoles("Guest");
		acpo.setManagerOfVendor("Vendor 2");
		acpo.setAdminContent("This is for Testing..........");
	}

	@When("Click On Save Button")
	public void click_On_Save_Button() 
	{
		acpo.clickOnSave();
	}

	@Then("User Can View Confirmation Message {string}")
	public void user_Can_View_Confirmation_Message(String string) 
	{
		String text=driver.findElement(By.tagName("body")).getText();
		Assert.assertTrue(text.contains("The new customer has been added successfully"));
		//Assert.assertTrue(text.contains("My name is mahesh"));
		//Verify.verify(text.contains("My Name is Mahesh"));
	}
	
	//Searching customer using Email ID
	@When("Enter Customer Email")
	public void enter_Customer_Email() 
	{
		scpo=new SearchCustomerPageObj(driver);
		scpo.setEmail("victoria_victoria@nopCommerce.com");
	}

	@When("Click On Search button")
	public void click_On_Search_Button() 
	{
		scpo.clickSearch();
	}

	@Then("User Should Find Email In The Search Table")
	public void user_Should_Find_Email_In_The_Search_Table() 
	{
		boolean status=scpo.searchCustomerByEmail("victoria_victoria@nopCommerce.com");
		Assert.assertEquals(true, status);
	}
	
	//Searching customer by Name
	@When("Enter Customer FirstName")
	public void enter_Customer_FirstName() 
	{
		scpo=new SearchCustomerPageObj(driver);
		scpo.setFirstName("Victoria");
	}

	@When("Enter Customer LastName")
	public void enter_Customer_LastName() 
	{
		scpo.setLastName("Terces");
	}

	@Then("User Should Find Name In The Search Table")
	public void user_Should_Find_Name_In_The_Search_Table() 
	{
		boolean status=scpo.searchCustomerByName("Victoria Terces");
		Assert.assertEquals(true, status);
	}
}
