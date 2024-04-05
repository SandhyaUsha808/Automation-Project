package ProjPage;

import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProjectPage {
WebDriver driver;

By logo=By.xpath("//*[@id=\"masthead\"]/div[1]/div[2]/div[1]/div[1]/a/picture/img");
By usericon=By.xpath("//*[@id=\"masthead\"]/div[1]/div[2]/div[3]/div/div[2]/a/i");
By createaccount=By.xpath("//*[@id=\"masthead\"]/div[1]/div[2]/div[3]/div/div[2]/div/div/div/div[1]/span[2]/a");
By username=By.xpath("//*[@id=\"reg_username\"]");
By email=By.xpath("//*[@id=\"reg_email\"]");
By password=By.xpath("//*[@id=\"reg_password\"]");
By registerbtn=By.name("register");
By loginemail=By.xpath("//*[@id=\"masthead\"]/div[1]/div[2]/div[3]/div/div[2]/div/div/div/form/p[1]/input");
By loginpswd=By.xpath("//*[@id=\"masthead\"]/div[1]/div[2]/div[3]/div/div[2]/div/div/div/form/p[2]/input");
By loginbtn=By.xpath("//*[@id=\"masthead\"]/div[1]/div[2]/div[3]/div/div[2]/div/div/div/form/button");
By categorylink1=By.xpath("//*[@id=\"menu-item-15156\"]/a");
By categorylink2=By.xpath("//*[@id=\"menu-item-15162\"]");
By categorylink3=By.xpath("//*[@id=\"menu-item-15165\"]/a");
By wellness=By.xpath("//*[@id=\"menu-item-15170\"]/a");
By pdtlink=By.xpath("//*[@id=\"main\"]/ul/li[1]/div/div[1]/div[2]/div/div/a");
By signouticon=By.xpath("//*[@id=\"masthead\"]/div[1]/div[2]/div[3]/div/div[2]/a");



//-----------------------constructor-----------------------

public ProjectPage(WebDriver driver)
{
this.driver=driver;
}

//--------------------------title verification-----------------------------

public void titleverify()
{
String actualtitle=driver.getTitle();
String expectedtitle="Grab the Best Ayurvedic Products Online at FLAT 20% OFF";
if(actualtitle.equals(expectedtitle))
{
	System.out.println("Title Verified");
	}
else
{
	System.out.println("Title not Verified");	
}
}

//-----------------------link validation----------------------------

public void linkvalidation() throws Exception
{
String baseurl="https://www.dhathriayurveda.in/";
driver.get(baseurl);
URL ob=new URL(baseurl);	
HttpURLConnection con=(HttpURLConnection)ob.openConnection();
con.connect();

if(con.getResponseCode()==200)
{
	System.out.println("Valid URL : "+baseurl);
}
else
{
	System.out.println("Invalid URL : "+baseurl);
}
}

//---------------------------logo is present or not --------------------------------

public void logo()
{
WebElement logos=driver.findElement(logo);
if(logos.isDisplayed())	
	{
		System.out.println("Logo is present");
	}
else
{
	System.out.println("Logo is not present");	
	}
}


//--------------------------------content verification-----------------------------------

public void contentverification()
{
String content=driver.getPageSource();

if(content.contains("SUPER SAVER DEALS"))
{
	System.out.println("Content Verified");
}
else
{
System.out.println("Content not Verified");	
}
}
//-----------------------Screenshot-----------------------------

public void fullscreenshot() throws Exception
{
	File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);	
	FileHandler.copy(src,new File("D://scrnshtproject.png"));
	System.out.println("---full screenshot---");
}

//---------------------Element Screenshot---------------------------

public void elementscreenshot() throws IOException
{
	WebElement ele=driver.findElement(logo);
	File src2=ele.getScreenshotAs(OutputType.FILE);	
	FileHandler.copy(src2,new File("./Screenshotlogo//logoelement.png")); 
	System.out.println("---screenshot of an element---");
}

//-----------------------Registration-----------------------------

public void registration(String uname,String mailid,String pswd) throws Exception
{
	Thread.sleep(7000);
	
	driver.findElement(usericon).click();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
	driver.findElement(createaccount).click();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
	
	driver.findElement(username).sendKeys(uname);
	System.out.println("username : "+uname);
	driver.findElement(email).sendKeys(mailid);
	System.out.println("email : "+mailid);
	driver.findElement(password).sendKeys(pswd);
	System.out.println("password : "+pswd);
	driver.findElement(registerbtn).click();
	System.out.println("-----registration successfull-----");
	
	
	
	//-------------------Add to Cart-----------------------------
	
	WebElement ele1=driver.findElement(categorylink1); //mouse hover
	Actions act1=new Actions(driver);
	act1.moveToElement(ele1).perform();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
	
	WebElement ele2=driver.findElement(categorylink2);	//mouse hover
	Actions act2=new Actions(driver);
	act2.moveToElement(ele2).perform();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
	
	WebElement ele3=driver.findElement(categorylink3);	//mouse hover
	Actions act3=new Actions(driver);
	act3.moveToElement(ele3).perform();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
	
	driver.findElement(wellness).click();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
	
	//------------------scroll down-------------------
	
	JavascriptExecutor jes=(JavascriptExecutor) driver;	
	jes.executeScript("window.scrollBy(0,500)", "");
		
	driver.findElement(pdtlink).click();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
	System.out.println("---Product added to cart---");
	
	driver.navigate().to("https://www.dhathriayurveda.in/");
	
	//--------------------Sign out--------------------------
	
	driver.findElement(signouticon).click();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
	
	//-------------------explicit wait-----------------------
	
	WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(100)); 
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"masthead\"]/div[1]/div[2]/div[3]/div/div[2]/div/div/div/ul/li[6]/a")));
	driver.findElement(By.xpath("//*[@id=\"masthead\"]/div[1]/div[2]/div[3]/div/div[2]/div/div/div/ul/li[6]/a")).click();

	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
	System.out.println("-----signout successfull-----");
	driver.close();

} 
}

