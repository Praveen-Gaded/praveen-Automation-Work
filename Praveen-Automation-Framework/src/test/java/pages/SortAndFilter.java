package pages;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.WebElement;

public class SortAndFilter {
	public static boolean isSortedAlphabeticallyAZ(List<WebElement> items) {
		List<String> itemTexts = new ArrayList<>();
		for (WebElement item : items) {
			itemTexts.add(item.getText());
		}

		// Create a sorted copy of the list
		List<String> sortedItemTexts = new ArrayList<>(itemTexts);
		Collections.sort(sortedItemTexts);

		// Return whether the original list matches the sorted list
		return itemTexts.equals(sortedItemTexts);
	}

	public static boolean isSortedAlphabeticallyZA(List<WebElement> items) {
		List<String> itemTexts = new ArrayList<>();
		for (WebElement item : items) {
			itemTexts.add(item.getText());
		}

		// Create a sorted copy of the list
		List<String> reverseSortedTexts = new ArrayList<String>(itemTexts);
		Collections.sort(reverseSortedTexts, Collections.reverseOrder());
		// Return whether the original list matches the sorted list
		return itemTexts.equals(reverseSortedTexts);

	}

	public static List<Double> extractPrices(List<WebElement> priceElements) {
		List<Double> prices = new ArrayList<>();

		for (WebElement element : priceElements) {
			try {
				// Extract text, remove '$' symbol, and convert to double
				String priceText = element.getText().replace("$", "");
				double price = Double.parseDouble(priceText);
				prices.add(price);
			} catch (NumberFormatException e) {

			}
		}
		return prices;
	}

	public static boolean isSortedPricesHighToLow(List<Double> prices) {

		for (int i = 0; i < prices.size() ; i++) {

			if (prices.get(i) > prices.get(i - 1)) {
				return false;

			}
		}

		return true;

	}

	public static boolean isSortedPricesLowToHigh(List<Double> prices) {
		for (int i = 0; i < prices.size() ; i++) {

			if (prices.get(i) > prices.get(i - 1)) {
				return false;

			}
		}

		return true;
	}


}
