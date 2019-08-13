package com.project.MavenProject.framesandwindows;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class MultiFrame {

WebDriver driver;
	
	@BeforeMethod
	public void setup()
	{
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\latestdrivers\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	
	@Test
	public void testMultiFrame() throws InterruptedException
	{
		
		driver.get("http://seleniumhq.github.io/selenium/docs/api/java/index.html");
		
		//List<WebElement> f=driver.findElements(By.tagName("frame"));
		//System.out.println("No of Frames : "+f.size());
		
		//Switch driver focus to 1st frame
		driver.switchTo().frame(0);
		driver.findElement(By.linkText("com.thoughtworks.selenium")).click();
		
		//Switch driver focus outside frame
		driver.switchTo().defaultContent();
		
		//Switch driver focus to 2nd frame
		driver.switchTo().frame(1);
		driver.findElement(By.linkText("Selenium")).click();
		
		//Switch driver focus outside frame
		driver.switchTo().defaultContent();
		
		//Switch driver focus to 3rd frame
		driver.switchTo().frame(2);
		driver.findElement(By.linkText("DefaultSelenium")).click();

	}
	
	
	@AfterMethod
	public void tearDown()
	{
		//driver.quit();
	}
	
	
	
}
