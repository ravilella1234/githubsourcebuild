package com.project.MavenProject.suiteB;

import java.net.MalformedURLException;

import org.testng.annotations.Test;

public class TestB3 
{
  
	@Test
	public void testB3() throws InterruptedException, MalformedURLException 
	{
		System.out.println("Starting B3");
		Thread.sleep(5000);
		System.out.println("Ending B3");
	}
}
