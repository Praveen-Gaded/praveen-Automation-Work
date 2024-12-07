package StepDefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;


import browserConfig.BrowserConfig;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import locators.Locators;
import pages.Login_Page;
import pages.SortAndFilter;
import utils.DropdownUtils;

public class SortAndFilter_Scenario {
	
	WebDriver driver;
	
	@Given("user is on home page after entering {string} and {string}")
	public void user_is_on_home_page_after_entering_and(String username, String password) {
		driver = BrowserConfig.openDriver("Chrome");
		BrowserConfig.maximizeBrowser(driver);
		BrowserConfig.enterUrl(driver, "https://www.saucedemo.com/");
		BrowserConfig.implicitWait(driver, 10);
		Login_Page.userCredentials(driver, username, password);
		Login_Page.clickLogin(driver);
	}

	@When("user click on Sort and filter dropdown")
	public void user_click_on_sort_and_filter_dropdown() {
		driver.findElement(Locators.dropdown).click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@When("selects {string}")
	public void selects(String option) {
		DropdownUtils.SelectUtil(driver, "text", option, Locators.dropdown);
	  
	}

	@Then("items reflected according to sorted options")
	public void items_reflected_according_to_sorted_options() {
		System.out.println("items sorted according to filters");
		BrowserConfig.closebrowser(driver);
	  
	}

	@Then("{string} is applied")
	public void is_applied(String FilterOption) {
		if(FilterOption.equalsIgnoreCase("Name (A to Z)")) {
			if(SortAndFilter.isSortedAlphabeticallyAZ(driver.findElements(Locators.items))) {
				System.out.println("Items arranged alphabetically : " + FilterOption);
			}
		}
		else if(FilterOption.equalsIgnoreCase("Name (Z to A)")) {
			if(SortAndFilter.isSortedAlphabeticallyZA(driver.findElements(Locators.items))) {
				System.out.println("Items arranged alphabetically : " + FilterOption);
			}
		}else if(FilterOption.equalsIgnoreCase("Price (low to high)")) {
			if(SortAndFilter.isSortedPricesLowToHigh(SortAndFilter.extractPrices(driver.findElements(Locators.priceElements)))) {
				System.out.println("Price list sorted according to " + FilterOption);
			}
		}
		else if(FilterOption.equalsIgnoreCase("Price (high to low)")) {
			if(SortAndFilter.isSortedPricesHighToLow(SortAndFilter.extractPrices(driver.findElements(Locators.priceElements)))) {
				System.out.println("Price list sorted according to " + FilterOption);
			}
		}
		
		
		BrowserConfig.closebrowser(driver);
	   
	}



}
