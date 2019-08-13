package com.project.MavenProject.suiteB;

import java.net.MalformedURLException;

import org.testng.annotations.Test;

public class TestB1 
{
  
	@Test
	public void testB1() throws InterruptedException, MalformedURLException 
	{
		System.out.println("Starting B1");
		Thread.sleep(5000);
		System.out.println("Ending B1");
	}
}
