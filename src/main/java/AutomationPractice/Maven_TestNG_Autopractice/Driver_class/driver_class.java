package AutomationPractice.Maven_TestNG_Autopractice.Driver_class;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

public class driver_class {
	
	/*
	 * Author: Gurjot Singh Description: This class is the initialization class
	 * in which all the driver methods like launch browser, select browser and
	 * title verification is defined.
	 */
	
	public static WebDriver driver;
	public Properties rProperties;
	public Properties locators;
	public File configFile;
	FileInputStream fileStream;

	// this is the initialization method
	public void initialization() throws IOException {
		selectbrowser(getdataval("browser"));
		driver.get(getdataval("baseurl"));
		verifytitle(getdataval("titleval"));
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	}
	
	//load data value
	public String getdataval(String loc) throws IOException{
		loadproperties();
		String path=rProperties.getProperty(loc);
		return path;
		
	}

	// load properties file
	public void loadproperties() throws IOException {
		 rProperties = new Properties();
		configFile = new File(System.getProperty("user.dir") + "/src/main/java/AutomationPractice/Maven_TestNG_Autopractice/config/testdata.properties");
		fileStream = new FileInputStream(configFile);
		rProperties.load(fileStream);
	}
	
	//load locator properties file
	public String getlocatorval(String loc) throws IOException{
		loadlocatorproperties();
		String path=locators.getProperty(loc);
		return path;
		
	}
	
	//load testdata properties file
	public void loadlocatorproperties() throws IOException {
		 locators = new Properties();
		configFile = new File(System.getProperty("user.dir") + "/src/main/java/AutomationPractice/Maven_TestNG_Autopractice/config/locators.properties");
		fileStream = new FileInputStream(configFile);
		locators.load(fileStream);
	}

	// this is title verification
	public void verifytitle(String webtitle) {
		String actual = driver.getTitle();
		String expected = webtitle;
		Assert.assertEquals(actual, expected);
		System.out.println("title matches");
	}

	// this is browser selection
	public void selectbrowser(String browsername) {
		if (browsername.equalsIgnoreCase("chrome")) {
			System.out.println(System.getProperty("user.dir"));
			//System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/drivers/chromedriver.exe");
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/new_driver/chromedriver.exe");
			driver = new ChromeDriver();

		} else if (browsername.equals("firefox")) {
			driver = new FirefoxDriver();

		}
	}

	// this is browser closing method
	public void closebrowser() {
		driver.close();
	}

}
