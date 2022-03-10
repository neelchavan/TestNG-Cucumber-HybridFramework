package stepDefinations;

import java.io.IOException;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resources.Base;

public class stepDefination extends Base {

	@Given("Navigate to QAClickAcademy site")
	public void navigate_to_qa_click_academy_site() throws IOException {
		// Write code here that turns the phrase above into concrete actions
		driver = initializeDriver();
		driver.get("http://qaclickacademy.com");
	}

	@Given("click on login link on home page to land on sign in page")
	public void click_on_login_link_on_home_page_to_land_on_sign_in_page() {
		// Write code here that turns the phrase above into concrete actions
		// To get landing page methods
		LandingPage land = new LandingPage(driver);

		// If popUp arrives handle it
		if (land.getPopUpSize() > 0) {
			land.getPopUp().click();
		}
		// Click on login link
		land.getLogin().click();
	}

	@When("^User enters (.+) and (.+) and click on login$")
	public void user_enters_and_and_click_on_login(String username, String password) throws Throwable {
		// Fill the Credentials and press login btn.
		// To get login page methods
		LoginPage cred = new LoginPage(driver);

		cred.getEmail().sendKeys(username);
		cred.getPassword().sendKeys(password);
		cred.getLgnBtn().click();
	}

	@Then("verify user is successfully logged in")
	public void verify_user_is_successfully_logged_in() {
		// Write code here that turns the phrase above into concrete actions
		System.out.println("invalid credentials");
		driver.close();
	}
}
