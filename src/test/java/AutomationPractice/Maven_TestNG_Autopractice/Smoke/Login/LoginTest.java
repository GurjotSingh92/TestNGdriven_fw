package AutomationPractice.Maven_TestNG_Autopractice.Smoke.Login;

import java.io.IOException;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import AutomationPractice.Maven_TestNG_Autopractice.Driver_class.driver_class;

public class LoginTest extends driver_class{
	
	Login loginobj;
	
	@BeforeTest
	public void beforelogin() throws IOException
	{
		initialization();
		loginobj=new Login(driver);
		
	}
	
	@Test
	public void loginmethod(){
		
		loginobj.logininwebsite();
	}
	
	
	@AfterTest
	public void afterlogin(){
		closebrowser();
	}

}
