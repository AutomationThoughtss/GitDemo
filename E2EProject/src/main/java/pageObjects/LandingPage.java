package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {

	public WebDriver driver;
	
	By signin = By.xpath("//span[contains(text(),'Login')]");//CSS -- "a[href*= 'sign_in']"
	By coursetext = By.cssSelector(".text-center>h2");
	By navigationbar = By.cssSelector(".nav.navbar-nav.navbar-right");
	
	public LandingPage(WebDriver driver)
	{
		this.driver= driver;
	}
	
	public WebElement Signin()
	{
		return driver.findElement(signin);
	}
	
	public WebElement getCourseText()
	{
		return driver.findElement(coursetext);
	}
	
	public WebElement getNavigationbar()
	{
		return driver.findElement(navigationbar);
	}
	
}
