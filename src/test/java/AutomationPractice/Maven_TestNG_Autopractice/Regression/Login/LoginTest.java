package AutomationPractice.Maven_TestNG_Autopractice.Regression.Login;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import AutomationPractice.Maven_TestNG_Autopractice.Driver_class.driver_class;

public class LoginTest extends driver_class{
	Login log;
	
	@BeforeMethod
	public void setup() throws IOException
	{
		initialization();
		log=new Login(driver);
	}
	
	@Test(priority=0)
	public void signin()
	{
		boolean checklogin=log.logininwebsite();
		if(checklogin==true)
		{
			Assert.assertTrue(true, "login first step is completed");
		}
		else
		{
			Assert.assertTrue(false, "login first step is NOT completed");
		}
	}
	
	/*@Test(priority=1)
	public void checktitleoflogin()
	{
		
		log.checktitleregisterpage();
		
	}*/
	
	@AfterMethod
	public void closebrowserfunction()
	{
		closebrowser();
	}
	
	
	

}
