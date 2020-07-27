package Framework.E2EProject;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import pageObjects.LandingPage;
import resources.base;

public class ValidationTitle extends base {

	public WebDriver driver;
	@Test
	public void Validatepagetitle() throws IOException
	{
		driver=  initializedriver();
		driver.get(prop.getProperty("url"));
		
		LandingPage l = new LandingPage(driver);
		//Validating title of text is "Featured Courses"
		
		Assert.assertEquals(l.getCourseText().getText().toUpperCase(), "Featured Cour".toUpperCase());
			
	} 
	
	@AfterTest
	public void TearDown()
	{
		driver.quit();
	}
}
