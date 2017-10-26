package AutomationPractice.Maven_TestNG_Autopractice.Regression.Registration;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import AutomationPractice.Maven_TestNG_Autopractice.Driver_class.driver_class;
//import io.qameta.allure.Step;

public class RegistrationTest extends driver_class{
	
	Registration register;
	
	
	@BeforeTest
	public void setup() throws IOException
	{
		initialization();
		register=new Registration(driver);
	}
	
	@Test(priority = 0, enabled = true) //@Step
	public void registration() throws IOException
	{
		boolean registermethod=register.registerinwebsite();
		if(registermethod==true)
		{
			Assert.assertTrue(true, "first part of registration successfully");
		}
		else
		{
			Assert.assertTrue(false, "test failed");
		}
	
	}
	
	@Test(priority = 1, enabled = true)
	public void registrationfullinformation()
	{
		System.out.println("this is second test");
	
	}
	
	@AfterTest
	public void closebrowseraftertest()
	{
		closebrowser();
	}

}
