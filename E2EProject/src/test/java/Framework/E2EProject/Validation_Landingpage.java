package Framework.E2EProject;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.LandingPage;
import resources.base;

public class Validation_Landingpage extends base{
	
	public WebDriver driver;
	@BeforeTest
	public void OpenURL() throws IOException
	{
		driver=  initializedriver();
		driver.get(prop.getProperty("url"));
	}

	@Test
	public void ValidateTitle() throws IOException 
	{
					
		LandingPage l = new LandingPage(driver);
		//Validating title of text is "Featured Courses"
		
		Assert.assertEquals(l.getCourseText().getText().toUpperCase(), "Featured Courses".toUpperCase()); 
		
			}
	
	@Test
	public void ValidateNavigationBar() throws IOException
	{
			
		LandingPage l = new LandingPage(driver);
		//Validating title of text is "Featured Courses"
		
		Assert.assertTrue(l.getNavigationbar().isDisplayed());
		
	}
	
	@AfterTest
	public void TearDown()
	{
		driver.quit();
	}
			
}
