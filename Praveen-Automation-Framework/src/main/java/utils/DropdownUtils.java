package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class DropdownUtils {

	public static void SelectUtil(WebDriver driver, String selectType, String selectInput, By DropDownLocator) {

		WebElement selectOption = driver.findElement(DropDownLocator);

		Select select = new Select(selectOption);

		if (selectType.equalsIgnoreCase("Text")) {
			select.selectByVisibleText(selectInput);
		}

		else if (selectType.equalsIgnoreCase("Value")) {
			select.selectByValue(selectInput);
		} else if (selectType.equalsIgnoreCase("Index")) {
			int selectIndex = Integer.parseInt(selectInput);
			select.selectByIndex(selectIndex);
		}
	}

}
