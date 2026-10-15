package utils;

import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AlertUtils {

	
	private static Alert alertIsPresent() {
		return WaitUtils.getWebDriverWait().until(ExpectedConditions.alertIsPresent());
	}

	
	public static void accept() {
		alertIsPresent().accept();
	}

	public static void dismiss() {
		alertIsPresent().dismiss();
	}

	public static String getText() {
		return alertIsPresent().getText();
	}

	public static void sendKeys(String value) {
		alertIsPresent().sendKeys(value);
	}

}
