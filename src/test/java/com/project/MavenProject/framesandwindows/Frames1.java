package com.project.MavenProject.framesandwindows;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Frames1 
{

WebDriver driver;
boolean flag=true;

	@BeforeMethod
	public void setUp()
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\DELL\\Desktop\\Drivers\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		//driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.get("http://www.angelfire.com/super/badwebs/");
	}
	
	
	@Test(enabled=false)
	public void frameDemo() throws InterruptedException
	{
		//driver.switchTo().frame(1);
		//driver.switchTo().frame(driver.findElement(By.name("contents")));
		Thread.sleep(3000);
		driver.findElement(By.xpath("//font[contains(text(),'International I Hate Frames Club')]")).click();
	}
	
	
	@Test()
	public void framesTest()
	{
		List<WebElement> myframes=driver.findElements(By.tagName("frame"));
		System.out.println(myframes.size());
		//String wh=driver.getWindowHandle();
		for(int i=0;i<myframes.size();i++)
		{
		   driver.switchTo().frame(i);
		    try
		    {
		    	System.out.println("Frame index is : "+ i);
		    	if(flag==true)
		    	driver.findElement(By.xpath("html/body/p[7]/b/a/font")).click();
		    	System.out.println("Element clicked using index --"+ i);
		    	break;
		    }
		    	
		    catch(Exception e)
		    {
		    	//e.printStackTrace();
		    	System.out.println("Element not exist in frame .." + i);
		    }
		    driver.switchTo().defaultContent();	 	
		}
		
	}
	
	
	

	@AfterMethod
	public void kill()
	{
		//driver.close();
	}
}
