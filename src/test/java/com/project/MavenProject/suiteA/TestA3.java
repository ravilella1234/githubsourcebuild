package com.project.MavenProject.suiteA;

import java.net.MalformedURLException;

import org.testng.annotations.Test;

public class TestA3 
{
  
	@Test
	public void testA3() throws InterruptedException, MalformedURLException 
	{
		System.out.println("Starting A3");
		Thread.sleep(5000);
		System.out.println("Ending A3");
	}
}
