package utils;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class DropdownUtils {

	private static Select getSelect(WebElement element) {
		return new Select(WaitUtils.getWebDriverWait().until(ExpectedConditions.visibilityOf(element)));
	}

	public static void selectByVisibleText(WebElement element, String visibleText) {

		getSelect(element).selectByVisibleText(visibleText);
	}

	public static void selectByIndex(WebElement element, int index) {
		getSelect(element).selectByIndex(index);
	}

	public static void selectByValue(WebElement element, String value) {
		getSelect(element).selectByValue(value);
	}

	public static String getFirstSelectedOption(WebElement element) {
		return getSelect(element).getFirstSelectedOption().getText();
	}

	public static List<String> getOptions(WebElement element) {
		return getSelect(element).getOptions().stream().map(WebElement::getText).collect(Collectors.toList());
	}

	public static boolean isMultiple(WebElement element) {
		return getSelect(element).isMultiple();
	}

	public static void deselectByVisibleText(WebElement element, String visibleText) {
		getSelect(element).deselectByVisibleText(visibleText);
	}

	public static void deselectByValue(WebElement element, String value) {
		getSelect(element).deselectByValue(value);
	}

	public static void deselectByIndex(WebElement element, int index) {

		getSelect(element).deselectByIndex(index);
	}

	public static void selectValue(List<WebElement> listElements, String expectedValue) {
		
		for (WebElement element : WaitUtils.getWebDriverWait().until(ExpectedConditions.visibilityOfAllElements(listElements))) {	
			if (element.getText().equalsIgnoreCase(expectedValue)) {
				element.click();
				break;
			}
		}

	}

}
