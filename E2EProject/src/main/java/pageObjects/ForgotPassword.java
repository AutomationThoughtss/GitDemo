package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ForgotPassword {

public WebDriver driver;
	
	//By signin = By.xpath("//span[contains(text(),'Login')]");//CSS -- "a[href*= 'sign_in']"
	By email = By.cssSelector("input#user_email");
	By sendmeinstruction = By.cssSelector("input[name='commit']");
	//By navigationbar = By.cssSelector(".nav.navbar-nav.navbar-right");
	
	public ForgotPassword(WebDriver driver)
	{
		this.driver= driver;
	}
	
	public WebElement Email()
	{
		return driver.findElement(email);
	}
	
	public WebElement SendmeInstruction()
	{
		return driver.findElement(sendmeinstruction);
	}
	

	
}
