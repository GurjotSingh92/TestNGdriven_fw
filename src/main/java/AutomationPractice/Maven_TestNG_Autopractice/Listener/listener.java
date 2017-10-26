package AutomationPractice.Maven_TestNG_Autopractice.Listener;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Random;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import AutomationPractice.Maven_TestNG_Autopractice.Driver_class.driver_class;

public class listener extends driver_class implements ITestListener{
	

public void onFinish(ITestContext arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext Result) {
		
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailure(ITestResult Result) {
		 System.out.println("The name of the testcase failed is :"+Result.getName());
		 
		 Random ran = new Random();
		 
				String screenShotLocation = System.getProperty("user.dir") + "\\screenshots\\";
				String screenShotName = screenShotLocation + ran.nextInt(100) +"-"+Result.getMethod().getMethodName()+ ".png";
				System.out.println(screenShotName);
				//String screenShotName="screenshot.png";
				
				File srcFile =((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
				try {
					FileUtils.copyFile(srcFile,new File(screenShotName));
					System.out.println("scshot location"+screenShotLocation);
					System.out.println("scshot name"+screenShotName);
				}catch(Exception e) {
					e.printStackTrace();
				}
				
				//String userDirector = System.getProperty("user.dir") + "/";
				   Reporter.log("<a href=\"" + screenShotName + "\"><img src=\"file:///" + screenShotName +"\" alt=\"\"" + "height='100' width='100'/> " + "<br />");
				   //Reporter.log("<a href=\""+ failureImageFileName + "\">");
				   Reporter.setCurrentTestResult(null);
				   Reporter.log(Result.getName()+ "--Test method failed\n");	
	}

	public void onTestSkipped(ITestResult Result) {
		System.out.println("The name of the testcase skipped is :"+Result.getName());
		
	}

	public void onTestStart(ITestResult Result) {
		System.out.println("this is the start of test case"+Result.getName());
		
	}

	public void onTestSuccess(ITestResult Result) {
		System.out.println("The name of the testcase passed is :"+Result.getName());
		
	}
	
	
}
