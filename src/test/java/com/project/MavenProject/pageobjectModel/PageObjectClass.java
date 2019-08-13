package com.project.MavenProject.pageobjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.project.MavenProject.BaseTest;

public class PageObjectClass extends BaseTest
{

	@Test
	public void aumationPractice() throws Exception
	{
		  loadData();
		  launch("chrome");
		  navigateUrl("automationurl");
		  
		  WebElement loc = driver.findElement(By.linkText("Sign in"));
		  loc.click();
		  driver.findElement(By.id("email_create")).sendKeys("qatest8758487@gmail.com");
		  driver.findElement(By.xpath("//button[@id='SubmitCreate']")).click();
		  
		  Thread.sleep(3000);
		  
		  driver.findElement(By.id("id_gender1")).click();
		  driver.findElement(By.id("customer_firstname")).sendKeys("qa");
		  driver.findElement(By.id("customer_lastname")).sendKeys("test");
		  driver.findElement(By.id("passwd")).sendKeys("password");
		  driver.findElement(By.id("days")).sendKeys("20");
		  driver.findElement(By.id("months")).sendKeys("April");
		  driver.findElement(By.id("years")).sendKeys("2015");
		  driver.findElement(By.id("address1")).sendKeys("hyderabad");
		  driver.findElement(By.id("city")).sendKeys("hyderabad");
		  driver.findElement(By.id("id_state")).sendKeys("California");
		  driver.findElement(By.id("postcode")).sendKeys("50000");
		  driver.findElement(By.id("id_country")).sendKeys("United States");
		  driver.findElement(By.id("phone_mobile")).sendKeys("1234567890");
		  driver.findElement(By.id("submitAccount")).click();
		  
		  
		  
		  

	}

}
