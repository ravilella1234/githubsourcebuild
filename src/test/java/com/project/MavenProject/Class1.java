package com.project.MavenProject;

import org.testng.annotations.Test;
import org.testng.internal.thread.ThreadTimeoutException;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.ThreadPoolExecutor;

import org.testng.annotations.AfterMethod;

public class Class1 
{
  @Test
  public void f() 
  {
	  System.out.println("f - Class1");
  }
  
  
  @Test
  public void g() 
  {
	  System.out.println("g - Class1");
  }
  
  
  @Test
  public void h() 
  {
	  System.out.println("h - Class1");
  }
  
  
  
  @BeforeMethod
  public void beforeMethod() 
  {
	  System.out.println("beforemethod - class1");
  }

  @AfterMethod
  public void afterMethod() 
  {
	  System.out.println("aftermethod - class1");
  }

}
