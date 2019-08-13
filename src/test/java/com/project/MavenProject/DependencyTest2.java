package com.project.MavenProject;

import org.testng.SkipException;
import org.testng.annotations.Test;

import junit.framework.Assert;

public class DependencyTest2 
{
	
  @Test(priority=1)
  public void orange() 
  {
	  System.out.println("orange");
  }
  
  @Test(priority=2,enabled=false)
  public void blue() 
  {
	  System.out.println("blue");
	  //throw new SkipException("Blue is skipped");
  }
  
  @Test(priority=3)
  public void white() 
  {
	  System.out.println("white");
	 // Assert.fail("white Test Failed...");
  }
  
  @Test(priority=4)
  public void green() 
  {
	  System.out.println("green");
  }
  
  
  @Test(priority=5)
  public void yellow()
  {
	  System.out.println("yellow");
  }
}
