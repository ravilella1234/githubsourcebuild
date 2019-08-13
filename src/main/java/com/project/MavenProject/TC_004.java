package com.project.MavenProject;

import com.relevantcodes.extentreports.LogStatus;

public class TC_004 extends BaseTest
{
	

	public static void main(String[] args) throws Exception 
	{
		
		test=report.startTest("TC_004");
		
		loadData();
		test.log(LogStatus.INFO, "loading the cofig files....");
		
		launch("chromebrowser");
		test.log(LogStatus.INFO, "Opened the Browser :- " +p.getProperty("chromebrowser"));
		
		navigateUrl("amazonurl");
		test.log(LogStatus.INFO, "Navigated to site :- " + p.getProperty("amazonurl"));
		
		selectItem("amazonsearchdropdown_id","amazonvalue");
		test.log(LogStatus.INFO, "Selected the item :- "+ or.getProperty("amazonvalue") + "by using locator :- " + or.get("amazonsearchdropdown_id"));
		
		type("amazonsearchtextbox_id","amazontext");
		test.log(LogStatus.INFO, "Entered the value :- " + or.getProperty("amazontext") + "by using locator :- "+ or.getProperty("amazonsearchtextbox_id"));
		
		click("amazonsearchbutton_xpath");
		test.log(LogStatus.INFO, "Clicked on Amozon search Button by using the locator :- " + or.getProperty("amazonsearchbutton_xpath"));
		
		report.endTest(test);
		report.flush();
	}
	
}
