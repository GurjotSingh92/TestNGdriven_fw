package AutomationPractice.Maven_TestNG_Autopractice.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CommonFunctions {
	
	//this method is used to click the element
	public void click(By by, WebDriver driver){
		driver.findElement(by).click();
		
	}
	
	//this method is used to enter text in the element
	public void enter_text(By by, WebDriver driver,String enterval){

		driver.findElement(by).sendKeys(enterval);
		
	}
	
	//this method is used to check the element existence
	public boolean element_exist_check(By by, WebDriver driver)
	{
		Integer sizeofele=driver.findElements(by).size();
		if(sizeofele==1)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	

}
