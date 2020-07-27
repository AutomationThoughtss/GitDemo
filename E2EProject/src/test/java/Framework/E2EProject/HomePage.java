package Framework.E2EProject;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.ForgotPassword;
import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resources.base;

public class HomePage extends base{
	public WebDriver driver;
	private static Logger Log = LogManager.getLogger(HomePage.class.getName());
	
	@Test(dataProvider = "getData")
	public void basePageNavigation(String username,String password,String text) throws IOException 
	{
		
		driver=  initializedriver();
		Log.info("Driver is initialized");
		driver.get(prop.getProperty("url"));
		Log.info("Navigated to Home Page");
		LandingPage l = new LandingPage(driver);
		l.Signin().click();
		
		LoginPage lp = new LoginPage(driver);
		lp.getEmail().sendKeys(username);
		Log.info("Entering Username");
		lp.getPassword().sendKeys(password);
		Log.info("Entering Password");
		lp.getLogin().click();
		Log.info(text);
		
		ForgotPassword fp =  lp.ForgotPasswordPage();
		fp.Email().sendKeys("test.test@xyz.com");
		fp.SendmeInstruction().click();
		
		driver.quit();
				
	}
	
	@DataProvider
	public Object[][] getData()
	{
		//row -- number of repetition to be done
		//column -- how many type of values to be provided like 3 in below example
		Object[][] data= new Object[2][3];
		
		//0th row
		data[0][0] = "restricteduser@xyz.com";
		data[0][1] = "badpasswrd";
		data[0][2] = "Restricteduser";
		
		
		//1st row
		data[1][0] = "unrestricted@xyz.com";
		data[1][1] = "goodpassword";
		data[1][2] = "Unrestricted";
		
		return data;
		
	}
	
			
}
