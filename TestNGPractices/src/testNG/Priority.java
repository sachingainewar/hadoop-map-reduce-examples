package testNG;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class Priority {
	public WebDriver driver;
	 
	  @Test(priority = 0)
	 
	  public void One() {
	 
	      System.out.println("This is the Test Case number One");
	 
	  }
	 
	  @Test(priority = 1)
	 
	  public void Two() {
	 
		  System.out.println("This is the Test Case number Two");
	 
	  }
	 
	  @Test(priority = 2, enabled = false)
	 
	  public void Three() {
	 
		  System.out.println("This is the Test Case number Three");
	 
	  }
	 
	  @Test(priority = 3, alwaysRun =true)
	 
	  public void Four() {
	 
		  System.out.println("This is the Test Case number Four");
	 
	  }
//allowing the user to specify the type of exceptions that are expected to be thrown by a test method during execution.	  
	  @Test(priority = 4, alwaysRun =true, expectedExceptions = ArithmeticException.class)
		 
	  public void division() {
	 
		  int i = 1 / 0;
		  
		  System.out.println("Invalid test Data  ");
	 
	  }
	  
///@Test(invocationCount=?): The invocationcount tells how many times TestNG should run this test method
	
	  @Test(priority = 5, invocationCount =3)
		 
	  public void six() {
	 
		  System.out.println("This is the Test Case number Six");
	  }
	  
//@Test (threadPoolSize=?): The threadPoolSize attributes tell TestNG to form a thread pool to run the test method through multiple threads. With threadpool, the running time of the test method reduces greatly.	  
// this attribute ignored if invocationCount is not specified

	  @Test(priority = 5,invocationCount =3 , threadPoolSize  =2,timeOut = 1000             )
		 
	  public void seven() {
	 
		  System.out.println("This is the Test Case number seven");
	  }
	  
	  
	 
}
