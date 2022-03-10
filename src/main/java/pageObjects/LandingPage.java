package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {

	public WebDriver driver;

	By SignIn = By.cssSelector("a[href*='sign_in']");
	By Banner = By.cssSelector(".video-banner");
	By popUp = By.xpath("//button[text()=\"NO THANKS\"]");
	
	public LandingPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
	}

	public WebElement getLogin() {
		return driver.findElement(SignIn);
	}
	
	public WebElement getBannerText() {
		return driver.findElement(Banner);
	}
	
	public WebElement getPopUp() {
		return driver.findElement(popUp);
	}
	
	public int getPopUpSize() {
		return driver.findElements(popUp).size();
	}
}
