package com.project.MavenProject.suiteB;

import java.net.MalformedURLException;

import org.testng.annotations.Test;

public class TestB2 
{
  
	@Test
	public void testB2() throws InterruptedException, MalformedURLException 
	{
		System.out.println("Starting B2");
		Thread.sleep(5000);
		System.out.println("Ending B2");
	}
}
