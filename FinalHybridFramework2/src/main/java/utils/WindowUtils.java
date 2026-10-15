package utils;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import DriverManagement.DriverManager;

public class WindowUtils {

	
	public static void switchFocusToWindowUsingWindowTitle(String expectedWindowTitle)
	{	
		Set<String> allWindowIds =DriverManager.getInstance().getDriver().getWindowHandles();
		
		for(String windowId : allWindowIds)
		{
			DriverManager.getInstance().getDriver().switchTo().window(windowId);
			
			String currentWindowTitle = DriverManager.getInstance().getDriver().getTitle();
			
			if(currentWindowTitle.equalsIgnoreCase(expectedWindowTitle))
			{
				break;
			}
		}	
	}
	
	public static void switchFocusToWindowUsingWindowUrl(String expectedWindowUrl)
	{	
		Set<String> allWindowIds =DriverManager.getInstance().getDriver().getWindowHandles();
		
		for(String windowId : allWindowIds)
		{
			DriverManager.getInstance().getDriver().switchTo().window(windowId);
			
			String currentWindowUrl = DriverManager.getInstance().getDriver().getCurrentUrl();
			
			if(currentWindowUrl.contains(expectedWindowUrl))
			{
				break;
			}
		}	
	}
	
	
	public static void switchFocusToWindowUsingWindowIndexPosition(int indexPosition)
	{
		Set<String> setAllWindowIds = DriverManager.getInstance().getDriver().getWindowHandles();
		
		List<String> listAllWindowIds = new ArrayList<String>();
		
		Iterator<String> it = setAllWindowIds.iterator();
		
		while(it.hasNext())
		{
			listAllWindowIds.add(it.next());
		}
		
		DriverManager.getInstance().getDriver().switchTo().window(listAllWindowIds.get(indexPosition));
		

	}
	
	
	
	
	
	
	
	
	
}
