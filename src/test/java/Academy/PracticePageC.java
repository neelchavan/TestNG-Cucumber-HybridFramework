package Academy;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.PracticeClass;

import org.apache.logging.log4j.Logger;

import resources.Base;
public class PracticePageC extends Base {
	public WebDriver driver;
	Logger log = LogManager.getLogger(Base.class.getName());
	
	@BeforeTest
	public void initialize() throws IOException {
		// Initialize driver
		driver = initializeDriver();
		log.info("Driver is initialized");
	}
	
	@Test
	public void PracticePageNavigation() {
	// Open website
			driver.get("http://qaclickacademy.com");
			log.info("Navigated to home page");
			
			PracticeClass prac = new PracticeClass(driver);
			
			// Click the link
			prac.getPracticePage().click();
	}

	@AfterTest
	public void tearDown() {
		driver.close();
	}
}
