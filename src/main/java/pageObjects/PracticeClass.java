package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PracticeClass {
	public WebDriver driver;
	
	public PracticeClass(WebDriver driver) {
		this.driver = driver;
	}
	
	By Practice = By.xpath("//a[text()='Practice']");
	
	public WebElement getPracticePage() {
		return driver.findElement(Practice);
	}

}
