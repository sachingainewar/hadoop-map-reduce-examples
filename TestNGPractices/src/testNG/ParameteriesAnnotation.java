package testNG;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParameteriesAnnotation {
	

	 @Test 
	 @Parameters({ "sUsername", "sPassword" })
	 
	  public void test(String sUsername, String sPassword) {
	
			System.out.println("sUsername from -->"+sUsername);
			System.out.println(sPassword +"Password ");

	 }

}
