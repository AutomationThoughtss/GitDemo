package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

	public WebDriver driver;
	
	By email = By.cssSelector("input#user_email");
	By password = By.cssSelector("input#user_password");
	By login = By.cssSelector("input[value='Log In']");
	By forgotpassword = By.cssSelector("input[type='submit']");
	
	public LoginPage(WebDriver driver)
	{
		this.driver= driver;
	}
	
	public WebElement getEmail()
	{
		return driver.findElement(email);
	}
	
	public WebElement getPassword()
	{
		return driver.findElement(password);
	}
	
	public WebElement getLogin()
	{
		return driver.findElement(login);
	}
	
	public ForgotPassword ForgotPasswordPage()
	{
		 driver.findElement(forgotpassword).click();
		 ForgotPassword fp =  new ForgotPassword(driver);
		 return fp;
	}
	
	
}
