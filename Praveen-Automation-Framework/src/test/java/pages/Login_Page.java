package pages;

import org.openqa.selenium.WebDriver;

import locators.Locators;

public class Login_Page {
	
	public static void userCredentials(WebDriver driver , String username , String password )   {
		
		
		driver.findElement(Locators.usernameField).sendKeys(username);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		driver.findElement(Locators.passwordField).sendKeys(password);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		
	}
	
	public static void clickLogin(WebDriver driver)  {
		
		
		driver.findElement(Locators.loginButton).click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
	}
	
	
}
