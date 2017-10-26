package AutomationPractice.Maven_TestNG_Autopractice.Regression.Registration;




import java.io.IOException;
import java.util.logging.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import AutomationPractice.Maven_TestNG_Autopractice.Driver_class.driver_class;
import AutomationPractice.Maven_TestNG_Autopractice.utilities.Propertyreader;


public class Registration {

	WebDriver driver;
	Logger log = Logger.getLogger("devpinoyLogger");
driver_class driverclass=new driver_class();
	public Registration(WebDriver driver) {
		this.driver = driver;
	}

	public boolean registerinwebsite() throws IOException {

		// System.out.println("reached in registerwebsite method");
		
		driver.findElement(By.xpath(driverclass.getlocatorval("sign_in"))).click();
		driver.findElement(By.xpath(driverclass.getlocatorval("create_email"))).sendKeys(driverclass.getdataval("email_id"));
	//	log.info("entered email id");
		driver.findElement(By.xpath(driverclass.getlocatorval("submitbutton"))).click();
		Integer sizeofele = driver.findElements(By.xpath(driverclass.getlocatorval("create_account"))).size();
		if (sizeofele == 1) {
			return true;
		} else {
			return false;
		}

	}

}
