package locators;

import org.openqa.selenium.By;

public interface Locators {
	
	//Login Page Locators
	By usernameField = By.xpath("//input[contains(@name,'user-name')]");

	By passwordField = By.xpath("//input[contains(@name,'password')]");
	
	By loginButton = By.xpath("//input[contains(@name,'login-button')]");
	
	
	//Homepage Title
	By homepageTitle = By.xpath("//div[contains(@class,'app_logo')]");

	
	//Error Messages
	By invalidUsernamePassword = By.xpath("//h3[.='Epic sadface: Username and password do not match any user in this service']");
	
	By passwordIsEmpty = By.xpath("//h3[.='Epic sadface: Password is required']");
	
	By usernameIsEmpty = By.xpath("//h3[.='Epic sadface: Username is required']");
	
	By usernameAndPasswordIsEmpty = By.xpath("//h3[.='Epic sadface: Username is required']");
	
	//SortAndFilter
	
	By dropdown = By.xpath("//select[@class='product_sort_container']");
	
	//Product Text
	By items = By.xpath("//div[contains(@class,'inventory_item_name ')]");
	
	//Product Prices
	By priceElements = By.xpath("//div[@class='inventory_item_price']");
	
	By cartIcon = By.id("shopping_cart_container");
	
	By AddToCart = By.xpath("//button[.='Add to cart']");
	
	By checkoutBTN = By.id("checkout");
	
	By FirstName = By.name("firstName");
	By LastName = By.name("lastName");
	By PostCode = By.name("postalCode");
	
	By ContinueButton = By.name("continue");
	
	By finishButton = By.name("finish");
	
	By successMessage = By.xpath("//h2[@class='complete-header']");
	
	
	
	
	
}
