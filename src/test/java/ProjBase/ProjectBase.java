package ProjBase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

public class ProjectBase {
	public WebDriver driver;

	@BeforeTest
	public void set()
	{
		ChromeOptions obj=new ChromeOptions();
		obj.addArguments("--remote-allow-origins=*");
		driver=new ChromeDriver(obj);	
	}
	
	@BeforeMethod 
		public void urlload()
		{
			driver.get("https://www.dhathriayurveda.in/");
			driver.manage().window().maximize();
		}
}
