package com.project.MavenProject.framesandwindows;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;



public class windowsHandle 
{

	public static void main(String[] args) throws Exception 
	{
		
		 System.setProperty("webdriver.chrome.driver", "C:\\Users\\DELL\\Desktop\\Drivers\\chromedriver.exe");
		  WebDriver driver=new ChromeDriver();
		  driver.manage().window().maximize();
		  driver.manage().deleteAllCookies();
		  driver.get("http://www.hdfcbank.com/");
		  
		  driver.findElement(By.xpath("//img[@class='popupCloseButton']")).click();  
		  
		  System.out.println(driver.getTitle());	  
		  String homeWindow=driver.getWindowHandle();
		  System.out.println("Parent Window is ... " + homeWindow);

		  Thread.sleep(2000);
		  driver.findElement(By.id("loginsubmit")).click();
		  Set<String> cWindow=driver.getWindowHandles();
		  System.out.println("Child Window is... " + cWindow.size());
		  
		  
		  Iterator<String> itr=cWindow.iterator();
		  while(itr.hasNext())
		  {
			  String currentWindowId=itr.next();
			  System.out.println("Windows are...:" + currentWindowId);
			  if(!currentWindowId.equals(homeWindow))
			  {
				  driver.switchTo().window(currentWindowId);
				  System.out.println(driver.getTitle());
			  }
		  }
		  //Thread.sleep(6000);
	
		  driver.manage().window().maximize();
		//wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("(//a[text()='Continue to NetBanking'])[2]")))).click();
		  driver.findElement(By.xpath("(//a[text()='Continue to NetBanking'])[2]")).click();
		  //Thread.sleep(6000);
		  driver.close(); 
		  
		  driver.switchTo().window(homeWindow);
		  System.out.println(driver.getTitle());
		  
		 
	}
}
