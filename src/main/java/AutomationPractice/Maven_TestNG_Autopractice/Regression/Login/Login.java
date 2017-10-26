package AutomationPractice.Maven_TestNG_Autopractice.Regression.Login;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import AutomationPractice.Maven_TestNG_Autopractice.utilities.CommonFunctions;


public class Login extends CommonFunctions{
	public WebDriver driver;
	public Login(WebDriver driver)
	{
		this.driver=driver;
		
	}
	
	//login in the website method
	public boolean logininwebsite()
	{
		System.out.println("reached in registerwebsite method");
		click(By.xpath("//a[@class='login' and @title='Log in to your customer account']"),driver);
		enter_text(By.xpath("//input[@type='text' and @id='email_create']"),driver,"gurjot1234565@gmail.com");
		//driver.findElement(By.xpath("//input[@type='text' and @id='email_create']")).sendKeys("gurjot1234565@gmail.com");
		driver.findElement(By.xpath("//span/i[@class='icon-user left']")).click();
		Integer sizeofele=driver.findElements(By.xpath("//h1[contains(text(),'Create an account')]")).size();
		if(sizeofele==1)
		{
			System.out.println("create account is tapped");
			return true;
		}
		else
		{
			return false;
		}	
	}
	
	//check title of registeration page
	public boolean checktitleregisterpage()
	{
		boolean boolval=element_exist_check(By.xpath("//h3[contains(text(),'Your personal information') and @class='page-subheading']"), driver);
		if(boolval==true)
		{
			Assert.assertTrue(true, "title found");
			return true;
		}
		else{
			Assert.assertTrue(false, "title not found");
			return false;
		}
		
		
	}

}
