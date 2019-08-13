package com.project.MavenProject.suiteA;

import java.net.MalformedURLException;

import org.testng.annotations.Test;

public class TestA2 
{
  
	@Test
	public void testA2() throws InterruptedException, MalformedURLException 
	{
		System.out.println("Starting A2");
		Thread.sleep(5000);
		System.out.println("Ending A2");
	}
}
