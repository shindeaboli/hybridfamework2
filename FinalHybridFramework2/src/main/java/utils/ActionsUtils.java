package utils;


import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import DriverManagement.DriverManager;

public class ActionsUtils {
	
	private static Actions getActions()
	{
		return new Actions(DriverManager.getInstance().getDriver());
	}
	
	
	public static void click(WebElement element)
	{
		getActions().click(WaitUtils.visibilityOf(element)).build().perform();	
	}
	
	
	public static void doubleClick(WebElement element)
	{
		getActions().doubleClick(WaitUtils.visibilityOf(element)).build().perform();
	}
	
	public static void contextClick(WebElement element)
	{
		getActions().contextClick(WaitUtils.visibilityOf(element)).build().perform();
	}
	
	public static void moveToElement(WebElement element)
	{
		getActions().moveToElement(WaitUtils.visibilityOf(element)).build().perform();
	}
	
	public static void scrollToElement(WebElement element)
	{
		getActions().scrollToElement(WaitUtils.visibilityOf(element)).build().perform();
	}
	
	
	public static void clickAndHold(WebElement element)
	{
		getActions().clickAndHold(WaitUtils.visibilityOf(element)).build().perform();
	}
	
	public static void release(WebElement element)
	{
		getActions().release(WaitUtils.visibilityOf(element)).build().perform();
	}
	
	public static void dragAndDrop(WebElement sourceElement, WebElement targetElement)
	{
		getActions().dragAndDrop(WaitUtils.visibilityOf(sourceElement), WaitUtils.visibilityOf(targetElement)).build().perform();
	}
	
	
	public static void sendKeys(WebElement element, String value)
	{
		getActions().sendKeys(WaitUtils.visibilityOf(element), value).build().perform();
		
	}
	
	public static void sendKeys(WebElement element, Keys keys)
	{
		getActions().sendKeys(WaitUtils.visibilityOf(element), keys).build().perform();
	}
	
	
	public static void keyDown(Keys keys)
	{
		getActions().keyDown(keys).build().perform();
		
	}
	
	public static void keyUp(Keys keys)
	{
		getActions().keyUp(keys).build().perform();
	}
	
	
	
	

}
