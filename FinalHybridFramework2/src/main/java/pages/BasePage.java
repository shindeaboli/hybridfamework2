package pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import DriverManagement.DriverManager;
import constant.WaitConstant;

public class BasePage {

	protected static WebDriver driver;

	public BasePage() {
		driver = DriverManager.getInstance().getDriver();
	}
	
	public void click(WebElement element)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(WaitConstant.ELEMENT_TO_BE_CLICKABLE));
		wait.until(ExpectedConditions.elementToBeClickable(element)).click();
	}
	
	public void sendKeys(WebElement element, String value)
	{
	
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(WaitConstant.VISIBILITY_OF));
		wait.until(ExpectedConditions.visibilityOf(element)).sendKeys(value);
		
	}

}
