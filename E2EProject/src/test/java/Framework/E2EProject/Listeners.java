package Framework.E2EProject;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import resources.ExtentReporterNG;
import resources.base;

public class Listeners extends base implements ITestListener{
	ExtentReports extent = ExtentReporterNG.getReportobject();
	ExtentTest test;
	ThreadLocal<ExtentTest> extenttest = new ThreadLocal<ExtentTest>();
		
	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
				
		String testMethodName= result.getMethod().getMethodName();
		 test = extent.createTest(testMethodName);
		 extenttest.set(test);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		//test.log(Status.PASS, "Test Passed");
		extenttest.get().log(Status.PASS, "Test Passed");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		extenttest.get().fail(result.getThrowable()); // to log failure info of Test
		
		WebDriver driver = null;
		String testMethodName= result.getMethod().getMethodName();
		 
		try {
			driver= (WebDriver) result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
			} catch (Exception e) {
					} 
		
		 try {
			 //Taking screenshot and adding it to extent reports
			 extenttest.get().addScreenCaptureFromPath(getScreenshotPath(testMethodName,driver), result.getMethod().getMethodName());
			 //getScreenshotPath(testMethodName,driver);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
		extent.flush();
	}
	
	
	

}
