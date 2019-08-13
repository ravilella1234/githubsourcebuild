package com.project.MavenProject;

import org.testng.annotations.Test;

import com.project.MavenProject.BaseTest;
import com.relevantcodes.extentreports.LogStatus;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;

public class TC_005 extends BaseTest
{
	

  @BeforeMethod(groups= {"regression"})
  @Parameters("browser")
  public void startProcess(String browserType) throws Exception 
  {
	  test=report.startTest("TC_005");
	  
	  loadData();
	  test.log(LogStatus.INFO, "loading the cofig files....");
	  Reporter.log("loading the cofig files....");
		
	  launch(browserType);
	  test.log(LogStatus.INFO, "Opened the Browser :- " +p.getProperty("firefoxbrowser"));
	  Reporter.log("Opened the Browser :- " +p.getProperty("firefoxbrowser"));
		
	  navigateUrl("amazonurl");
	  test.log(LogStatus.INFO, "Navigated to site :- " + p.getProperty("amazonurl"));
	  Reporter.log("Navigated to site :- " + p.getProperty("amazonurl"));
  }
  

  @Test(priority=1,groups= {"regression"})
  public void amazon()
  {
	    selectItem("amazonsearchdropdown_id","amazonvalue");
		test.log(LogStatus.INFO, "Selected the item :- "+ or.getProperty("amazonvalue") + "by using locator :- " + or.get("amazonsearchdropdown_id"));
		Reporter.log("Selected the item :- "+ or.getProperty("amazonvalue") + "by using locator :- " + or.get("amazonsearchdropdown_id"));
		
		type("amazonsearchtextbox_id","amazontext");
		test.log(LogStatus.INFO, "Entered the value :- " + or.getProperty("amazontext") + "by using locator :- "+ or.getProperty("amazonsearchtextbox_id"));
		Reporter.log("Entered the value :- " + or.getProperty("amazontext") + "by using locator :- "+ or.getProperty("amazonsearchtextbox_id"));
		
		click("amazonsearchbutton_xpath");
		test.log(LogStatus.INFO, "Clicked on Amozon search Button by using the locator :- " + or.getProperty("amazonsearchbutton_xpath"));
		Reporter.log("Clicked on Amozon search Button by using the locator :- " + or.getProperty("amazonsearchbutton_xpath"));
  }
  

  @AfterMethod(groups= {"regression"})
  public void endProcess() 
  {
	 closeBrowser();
	 report.endTest(test);
	 report.flush();
  }

}
