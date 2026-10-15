package utils;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import DriverManagement.DriverManager;
import constant.WaitConstant;

public class WaitUtils {
	
	
	public static WebDriverWait getWebDriverWait()
	{
		return new WebDriverWait(DriverManager.getInstance().getDriver(), Duration.ofSeconds(WaitConstant.EXPLICIT_WAIT));		
	}
	
	
	public static WebElement visibilityOf(WebElement element)
	{
		
		return getWebDriverWait().until(ExpectedConditions.visibilityOf(element));		
	}
	
	public static List<WebElement> visibilityOfAllElements(List<WebElement> listElements)
	{
		
		return getWebDriverWait().until(ExpectedConditions.visibilityOfAllElements(listElements));		
	}
	

}
