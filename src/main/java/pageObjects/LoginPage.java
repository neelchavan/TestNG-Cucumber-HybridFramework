package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
	
	public WebDriver driver;
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}
	
	By username = By.id("user_email");
	By password = By.id("user_password");
	By btn = By.cssSelector("input[type='submit']");
	
	public WebElement getEmail() {
		return driver.findElement(username);
		
	}
	
	public WebElement getPassword() {
		return driver.findElement(password);
	}
	
	public WebElement getLgnBtn() {
		return driver.findElement(btn);
	}

}
