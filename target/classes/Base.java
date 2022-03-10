package resources;

import java.io.File;
import java.io.FileInputStream;

import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Base {

	// Always define driver at the global level
	public WebDriver driver;
	public Properties prop;

	public WebDriver initializeDriver() throws IOException {

		// SetUp Environment variable for browsers in file named "data.properties"

		prop = new Properties();

		// Set that file location here
		FileInputStream fis = new FileInputStream(
				"/home/neel/eclipse-workspace/E2EProject/src/main/java/resources/data.properties");

		// Load that file
		prop.load(fis);

		// Now get the bowser name.
		String browserName = prop.getProperty("browser");

		if (browserName.contains("chrome")) {
			// Execute chrome browser
			System.setProperty("webdriver.chrome.driver", "/home/neel/SeleniumSetup/chromedriver");
			ChromeOptions options = new ChromeOptions();
			if(browserName.contains("chrome")) {
				options.addArguments("headless");
			}
			driver = new ChromeDriver();
			driver.manage().window().maximize();
		} else if (browserName.equals("firefox")) {
			// Execute firefox browser

		} else if (browserName.equals("IE")) {
			// Execute IE browser
		}

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		return driver;
	}

	public String getScreenShotPath(String testCaseName, WebDriver driver) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String destinationFile = System.getProperty("user.dir") + "\\reports\\" + testCaseName + ".png";
		FileUtils.copyFile(source, new File(destinationFile));
		return destinationFile;

	}
}
