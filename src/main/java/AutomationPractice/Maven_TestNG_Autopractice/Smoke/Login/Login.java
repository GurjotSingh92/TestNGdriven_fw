package AutomationPractice.Maven_TestNG_Autopractice.Smoke.Login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Login {
	
	WebDriver driver;
	
	public Login(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public void logininwebsite()
	{
		System.out.println("this is login method in smoke");
	}

}
