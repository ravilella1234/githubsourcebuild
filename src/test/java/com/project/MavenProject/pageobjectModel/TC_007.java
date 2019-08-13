package com.project.MavenProject.pageobjectModel;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.project.MavenProject.BaseTest;

public class TC_007 extends BaseTest
{
	
	 PageObjectClass2 page;
	
  @BeforeMethod
  public void startProcess() throws Exception
  {
	  loadData();
	  launch("chrome");
	  navigateUrl("automationurl");
  }
	
	
  @Test
  public void registration() throws InterruptedException  
  {
	  page=new PageObjectClass2(driver);
	  page.customerRegistration();
	  
  }
}
