package StepDefinition;

import org.openqa.selenium.WebDriver;

import browserConfig.BrowserConfig;
import io.cucumber.java.en.*;
import locators.Locators;
import pages.Login_Page;

public class E2E_Checkout_StepDef {
	
	WebDriver driver;
	
	@Given("user is on logged in with {string} and {string} and adds {string} items to cart")
	public void user_is_on_logged_in_with_and_and_adds_items_to_cart(String Username, String password, String Count) {
		
		driver = BrowserConfig.openDriver("Chrome");
		BrowserConfig.maximizeBrowser(driver);
		BrowserConfig.enterUrl(driver, "https://www.saucedemo.com/");
		BrowserConfig.implicitWait(driver, 10);
		Login_Page.userCredentials(driver, Username, password);
		Login_Page.clickLogin(driver);
		
		int countnum = Integer.parseInt(Count);
		for(int i = 0; i < countnum; i ++) {
			driver.findElements(Locators.AddToCart).get(i).click();
		}
		
		
	 
	}

	@When("user navigate to cart page and click on checkout, then  enters {string} {string} and {string}")
	public void user_navigate_to_cart_page_and_click_on_checkout_then_enters_and(String FirstName, String LastName, String ZipCode) {
		
		driver.findElement(Locators.cartIcon).click();
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	   
		driver.findElement(Locators.checkoutBTN).click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		driver.findElement(Locators.FirstName).sendKeys(FirstName);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		driver.findElement(Locators.LastName).sendKeys(LastName);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		driver.findElement(Locators.PostCode).sendKeys(ZipCode);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@When("user clicks continue, they are directed to checkout overview page")
	public void user_clicks_continue_they_are_directed_to_checkout_overview_page() {
		driver.findElement(Locators.ContinueButton).click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
	}

	@Then("user clicks finish, the order confirmation message is displayed")
	public void user_clicks_finish_the_order_confirmation_message_is_displayed() {
		
		driver.findElement(Locators.finishButton).click();
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(driver.findElement(Locators.successMessage).getText().equalsIgnoreCase("Thank you for your order!")) {
			System.out.println("your order is success");
			BrowserConfig.closebrowser(driver);
		}
	    
	}

}
