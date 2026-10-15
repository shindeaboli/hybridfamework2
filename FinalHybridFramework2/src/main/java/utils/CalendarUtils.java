package utils;

import java.util.List;

import org.openqa.selenium.WebElement;

public class CalendarUtils {
	
	public static void selectMonthYear(WebElement monthYearElement, WebElement nextElement, String expectedMonthYear)
	{
		while(true)
		{
			String actualMonthYear = monthYearElement.getText();
			
			if(actualMonthYear.equalsIgnoreCase(expectedMonthYear))
			{
				break;
			}
			else
			{
				nextElement.click();
			}
		}
		
		
	}
	
	
	public static void selectDate(List<WebElement> listDates, String expectedDate)
	{
		for(WebElement date : listDates)
		{
			if(date.getText().equals(expectedDate))
			{
				date.click();
				break;
			}
		}
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
