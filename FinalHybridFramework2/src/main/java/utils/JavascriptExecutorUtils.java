package utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import DriverManagement.DriverManager;

public class JavascriptExecutorUtils {

	private static JavascriptExecutor getJavascriptExecutor() {
		return (JavascriptExecutor) DriverManager.getInstance().getDriver();
	}

	private static void executeScript(String format, WebElement element) {
		getJavascriptExecutor().executeScript(format, element);
	}

	public static void click(WebElement element) {
		executeScript("arguments[0].click()", element);
	}

	public static void enterValue(WebElement element, String value) {
		executeScript("arguments[0].value='" + value + "'", element);
	}

	public static void scrollDownUpToElement(WebElement element) {

		executeScript("arguments[0].scrollIntoView()", element);

	}

	public static void createBorder(WebElement element) {

		executeScript("arguments[0].style.border='3px solid green'", element);

	}

	public static void openUrl(String url) {
		getJavascriptExecutor().executeScript("window.location='" + url + "'");

	}

	public static void back() {
		getJavascriptExecutor().executeScript("history.go(-1)");
	}

	public static void forward() {
		getJavascriptExecutor().executeScript("history.go(+1)");

	}

	public static void refresh() {
		getJavascriptExecutor().executeScript("history.go(0)");

	}

	public static String getTitle() {
		return getJavascriptExecutor().executeScript("return document.title").toString();

	}

	public static String getCurrentUrl() {
		return getJavascriptExecutor().executeScript("return document.URL").toString();
	}

}
