package AutomationPractice.Maven_TestNG_Autopractice.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Propertyreader {
	public Properties locators;
	public File configFile;
	FileInputStream fileStream;
	
	public String getlocatorval(String loc) throws IOException{
		readlocatorProperties();
		String path=locators.getProperty(loc);
		return path;
		
	}
	
	public void readlocatorProperties() throws IOException{
		locators=new Properties();
		configFile = new File(System.getProperty("user.dir")+"D:\\Selenium_workspace\\Maven_TestNG_Autopractice\\src\\main\\java\\AutomationPractice\\Maven_TestNG_Autopractice\\config\\locators.properties");
		fileStream = new FileInputStream(configFile);
		locators.load(fileStream);
		
	}
	
	

}
