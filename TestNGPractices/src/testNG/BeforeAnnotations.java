package testNG;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.BeforeSuite;

public class BeforeAnnotations {
  @Test
  public void f() {
	  System.out.println("Execution of Test Method ");
  }
  @BeforeMethod
  public void beforeMethod() {
	  System.out.println("Execution Before Method");
  }

  @BeforeClass
  public void beforeClass() {
	  System.out.println("Execution before Class Sequence ");
  }

  @BeforeTest
  public void beforeTest() {
	  System.out.println("Sequece of Before Test ");
  }

  @BeforeSuite
  public void beforeSuite() {
	  System.out.println("SqQesuce of Before Suite ");
  }

}
