package StepDefinition;

import org.openqa.selenium.WebDriver;
import browserConfig.BrowserConfig;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import locators.Locators;
import pages.Login_Page;
import userData.Exp_Data;

public class Login_Scenario {

	WebDriver driver;

	@Given("user is on login page")
	public void user_is_on_login_page() {

		driver = BrowserConfig.openDriver("Chrome");
		BrowserConfig.maximizeBrowser(driver);
		BrowserConfig.enterUrl(driver, "https://www.saucedemo.com/");
		BrowserConfig.implicitWait(driver, 10);

	}

	@When("user enters {string} and {string}")
	public void user_enters_and(String userName, String passWord) {

		Login_Page.userCredentials(driver, userName, passWord);

	}

	@When("click on login button")
	public void click_on_login_button() {

		Login_Page.clickLogin(driver);

	}

	@Then("user should be navigated to home page")
	public void user_should_be_navigated_to_home_page() {

		if (driver.findElement(Locators.homepageTitle).getText().equalsIgnoreCase(Exp_Data.homePageHeader)) {

			System.out.println("User is on homePage");

		}
		BrowserConfig.closebrowser(driver);

	}

	@Then("{string} is displayed for {string}")
	public void is_displayed_for(String Result, String inputType) {
		if (inputType.equalsIgnoreCase("valid Data")) {

			System.out.println("User is on homePage");

		}

		else if (inputType.equalsIgnoreCase("invalid Data")) {

			if (driver.findElement(Locators.invalidUsernamePassword).getText()
					.equalsIgnoreCase(Exp_Data.userNameAndPasswordIsWrong)) {
				System.out.println("input Type is: " + inputType + " And Error Message is: "
						+ Exp_Data.userNameAndPasswordIsWrong);
			}
			
		}
		
		else if (inputType.equalsIgnoreCase("only with username")) {

			if (driver.findElement(Locators.passwordIsEmpty).getText()
					.equalsIgnoreCase(Exp_Data.onlyPasswordIsEmpty)) {
				System.out.println("input Type is: " + inputType + " And Error Message is: "
						+ Exp_Data.onlyPasswordIsEmpty);
			}
			
		}
		
		else if (inputType.equalsIgnoreCase("only with password")) {

			if (driver.findElement(Locators.usernameIsEmpty).getText()
					.equalsIgnoreCase(Exp_Data.onlyUserNameIsEmpty)) {
				System.out.println("input Type is: " + inputType + " And Error Message is: "
						+ Exp_Data.onlyUserNameIsEmpty);
			}
			
		}
		
		else if (inputType.equalsIgnoreCase("empty username and password")) {

			if (driver.findElement(Locators.usernameAndPasswordIsEmpty).getText()
					.equalsIgnoreCase(Exp_Data.userNameAndPasswordIsEmty)) {
				System.out.println("input Type is: " + inputType + " And Error Message is: "
						+ Exp_Data.userNameAndPasswordIsEmty);
			}
			
		}
		
		BrowserConfig.closebrowser(driver);
		
	}
}
