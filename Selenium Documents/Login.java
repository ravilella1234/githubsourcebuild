package abcpack;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Login {
	WebDriver d;
	@Test
	public void testLogin() throws Exception
	{
		//Load web page
		d.get("http://183.82.118.175:8080/Cyclos/do/login");
		assertEquals("City Bank of Japan",d.getTitle());
		//Enter user name
		d.findElement(By.id("cyclosUsername")).clear();
		d.findElement(By.id("cyclosUsername")).sendKeys("gfsdgfdfgdf");
		String uname=d.findElement(By.id("cyclosUsername")).getAttribute("value");
		//Enter password
		d.findElement(By.id("cyclosPassword")).clear();
		d.findElement(By.id("cyclosPassword")).sendKeys("dfsdgfd");
		String password=d.findElement(By.id("cyclosPassword")).getAttribute("value");
		//Click on Login
		d.findElement(By.xpath("//input[@value='Submit']")).click();
		Thread.sleep(1000);
		//Blank user & Blank password
		if(uname.equals("") && password.equals(""))
		{
			Alert al=d.switchTo().alert();
			assertEquals("Login name is required\nPassword is required\n",al.getText());
			al.accept();
		}
		//Blank user name & Valid/invalid password
		else if(uname.equals("") && !(password.equals("")))
		{
			Alert al=d.switchTo().alert();
			assertEquals("Login name is required\n",al.getText());
			al.accept();
		}
		//Blank password & Valid/Invalid user name
		else if(password.equals("") && !(uname.equals("")))
		{
			Alert al=d.switchTo().alert();
			assertEquals("Password is required\n",al.getText());
			al.accept();
		}
		//Valid user name & valid password
		else if(isElementPresent(d,By.xpath("//span[text()='Logout']")))
		{
			d.findElement(By.xpath("//span[text()='Logout']")).click();
			//Switch driver focus to alert
			Alert al=d.switchTo().alert();
			al.accept();
		}
		//Invalid user name & invalid password
		else if(isElementPresent(d,By.id("btn")))
		{
			d.findElement(By.id("btn")).click();
		}
		
		
		Thread.sleep(4000);
		
	}
	 private boolean isElementPresent(WebDriver driver,By by)
	 {
		 driver.manage().timeouts().implicitlyWait(0,TimeUnit.SECONDS);   
		 try {
		      driver.findElement(by);
		      return true;
		    } catch (NoSuchElementException e) {
		      return false;
		    }
	 }
	 
	@BeforeMethod
	public void setUp()
	{
		//Launch browser
		System.setProperty("webdriver.gecko.driver","F:\\Driver Server\\geckodriver.exe");
		d=new FirefoxDriver();
		System.setProperty("webdriver.chrome.driver", "F:\\Driver Server\\chromedriver.exe");
	    //d=new ChromeDriver();
		//Maximize browser
		d.manage().window().maximize();
		d.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
	}
	@AfterMethod
	public void tearDown()
	{
		//Close browser
		d.quit();
	}

}
