package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.apache.commons.io.*;

public class base {
	
	public WebDriver driver;
	public Properties prop;
	
	//Method to initialize Web Driver object
	public WebDriver initializedriver() throws IOException
	{
		
		 prop = new Properties();
		 //user.dir will get system path till the current project
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "\\src\\main\\java\\resources\\data.properties");
		
		prop.load(fis);
		
		//Fetching value of browser property from data properties files
		//String browsername  = prop.getProperty("browser");
		
		//Fetching value from Maven command mvn test -Dbrowser=chromes
		String browsername = System.getProperty("browser");
		
		if(browsername.contains("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\Browser_Driver\\chromedriver.exe");
			ChromeOptions options = new ChromeOptions();
			if(browsername.contains("headless"))
			{
				options.addArguments("headless");
			}
			driver = new ChromeDriver(options);
		}
		else if(browsername.equalsIgnoreCase("firefox"))
		{
			System.setProperty("webdriver.gecko.driver","C:\\Selenium\\Browser_Driver\\geckodriver.exe");
			driver = new FirefoxDriver();
			
		}
		else if(browsername.equalsIgnoreCase("IE"))
		{
			System.setProperty("webdriver.ie.driver","C:\\Selenium\\Browser_Driver\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
			
		}
	
	int time_out = Integer.parseInt(prop.getProperty("timeout")); 
	driver.manage().timeouts().implicitlyWait(time_out, TimeUnit.SECONDS);
		
	return driver;
	}
	
	
	
	  public String getScreenshotPath(String testCasename,WebDriver driver) throws
	  IOException{
	  
	  TakesScreenshot ts = (TakesScreenshot) driver; 
	  File source =	  ts.getScreenshotAs(OutputType.FILE);
	  String destinationFile =	  System.getProperty("user.dir") +"\\reports\\"+ testCasename + ".png";
	   
	  FileUtils.copyFile(source, new  File(destinationFile));
	 
	  return destinationFile;
	  
	  
	  }
	 
	

}
