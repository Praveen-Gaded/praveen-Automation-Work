package browserConfig;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserConfig {
	
	
	public static WebDriver openDriver(String BrowserType) {
		if(BrowserType.equalsIgnoreCase("Chrome")) {
			return new ChromeDriver();
			}
		
		else {
			return new FirefoxDriver();
			}
		
	}

	public  static void maximizeBrowser(WebDriver driver) {
		
		driver.manage().window().maximize();
		
	}
	
	
	public static void enterUrl(WebDriver driver,String Url) {
		
		driver.get(Url);
	}
	
	
	public static void implicitWait(WebDriver driver, int time){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(time));
    }

	
    public static void closebrowser(WebDriver driver){
        driver.close();
    }
    
    

}
