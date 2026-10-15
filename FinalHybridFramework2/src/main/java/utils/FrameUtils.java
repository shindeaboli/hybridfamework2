package utils;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import DriverManagement.DriverManager;

public class FrameUtils {

	public static void switchToFrame(String idOrName) {
		WaitUtils.getWebDriverWait().until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(idOrName));
	}

	public static void switchToFrame(int index) {
		WaitUtils.getWebDriverWait().until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(index));

	}

	public static void switchToFrame(WebElement element) {
		WaitUtils.getWebDriverWait().until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(element));
	}

	public static void switchToParentFrame() {
		DriverManager.getInstance().getDriver().switchTo().parentFrame();
	}

	public static void switchToDefaultContent() {
		DriverManager.getInstance().getDriver().switchTo().defaultContent();
	}

}
