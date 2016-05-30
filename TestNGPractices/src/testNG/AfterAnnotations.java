package testNG;

import org.testng.annotations.Test;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.AfterSuite;

public class AfterAnnotations {
  @Test
  public void f() {
	  System.out.println("Execution sequence fo Test Annotation ");
  }
  @AfterMethod
  public void afterMethod() {
	  System.out.println("Execution sequence fo AfterMethod  Annotation ");

  }

  @AfterClass
  public void afterClass() {
	  System.out.println("Execution sequence fo AfterClass Annotation ");

  }

  @AfterTest
  public void afterTest() {
	  System.out.println("Execution sequence fo AfterTest Annotation ");

  }

  @AfterSuite
  public void afterSuite() {
	  System.out.println("Execution sequence fo AfterSuite Annotation ");

  }

}
