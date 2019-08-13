package com.project.MavenProject;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;

public class Class2 
{
  @Test
  public void f() 
  {
	  System.out.println("f - Class2");
  }
  @BeforeMethod
  public void beforeMethod() 
  {
	  System.out.println("beforemethod - class2");
  }

  @AfterMethod
  public void afterMethod() 
  {
	  System.out.println("aftermethod - class2");
  }

}
