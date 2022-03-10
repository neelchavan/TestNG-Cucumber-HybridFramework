package Academy;

import org.testng.annotations.Test;
import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resources.Base;

public class HomePage extends Base {
	public WebDriver driver;
	Logger log = LogManager.getLogger(Base.class.getName());

	@BeforeTest
	public void initialize() throws IOException {
		// Initialize driver
		driver = initializeDriver();
		log.info("Driver is initialized");
	}

	@Test(dataProvider = "getData")
	public void homePageNavigation(String username, String password) throws IOException {

		// Open website
		driver.get("http://qaclickacademy.com");
		log.info("Navigated to home page");
		// Get all the the methods related to landing page
		// By inheritance or by creating object of that class.

		LandingPage land = new LandingPage(driver);
		LoginPage cred = new LoginPage(driver);
		
		// Get Text
		land.getBannerText().getText();

		// Click the login link
		land.getLogin().click();

		// Fill the Credentials and press login btn.
		cred.getEmail().sendKeys(username);
		cred.getPassword().sendKeys(password);
		log.info("Successfully Entered Credentials");
		cred.getLgnBtn().click();
	}

	@AfterTest
	public void tearDown() {
		driver.close();
	}

	@DataProvider
	public Object[][] getData() {

		// First block of array is for how many test cases in this case '2'
		// Second block of array is for how many values in this case '2' username,
		// passwd.
		Object[][] data = new Object[2][2];

		// 0th row
		data[0][0] = "nonrestrickteduser@gmail.com";
		data[0][1] = "12345677";

		// 1th row
		data[1][0] = "restricteduser@gmail.com";
		data[1][1] = "23432432";

		return data;
	}

}
