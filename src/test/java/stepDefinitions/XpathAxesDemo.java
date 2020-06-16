package stepDefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class XpathAxesDemo 
{
	public static WebDriver oBrowser=null;
	public static void main(String[] args) throws Exception {
		launchBrowser();
		navigate();
	//	followingsiblingDemo();
		followingDemo();
		//precedingsiblingDemo();
		//precedingDemo();
	}
	
	static void launchBrowser() throws Exception
	{
		String path=System.getProperty("user.dir");
		System.out.println(path);
		System.setProperty("webdriver.chrome.driver", path+"\\Drivers\\chromedriver.exe");
		oBrowser=new ChromeDriver();
	}
	
	static void navigate()throws Exception
	{
		oBrowser.get("file:///C:/Users/Naveen/Desktop/WebTableHTML.html");
		Thread.sleep(2000);
	}

	static void followingsiblingDemo()
	{
		oBrowser.findElement(By.xpath("//td[text()='Sachin Tendulkar']/following-sibling::td/following-sibling::td/following-sibling::td/following-sibling::td/input")).sendKeys("25000");
	}
	
	static void followingDemo()
	{
		oBrowser.findElement(By.xpath("//td[text()='Rahul Dravid']/following::tr[1]/td[6]/input")).sendKeys("25000");
	}
	
	static void precedingsiblingDemo()
	{
		oBrowser.findElement(By.xpath("//td[text()='Indian Freedom Fighter']/preceding-sibling::td/preceding-sibling::td/input")).click();
	}
	
	static void precedingDemo()
	{
		oBrowser.findElement(By.xpath("//td[text()='Sachin Tendulkar']/preceding::tr[2]/td[1]/input")).click();
	}
}
