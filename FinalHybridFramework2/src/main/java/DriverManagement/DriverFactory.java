package DriverManagement;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class DriverFactory {
	
	public static WebDriver setDriver(String browser)
	{
		WebDriver driver;
		
		if(browser.equalsIgnoreCase("CHROME"))
		{
			driver = new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("EDGE"))
		{
			driver = new EdgeDriver();
		}
		else if(browser.equalsIgnoreCase("FIREFOX"))
		{
			driver = new FirefoxDriver();
		}
		else if(browser.equalsIgnoreCase("IE"))
		{
			driver = new InternetExplorerDriver();
		}
		else if(browser.equalsIgnoreCase("INCOGNITO"))
		{
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--incognito");
			driver = new ChromeDriver(options);
		}
		else if(browser.equalsIgnoreCase("HEADLESS"))
		{
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--headless");
			driver = new ChromeDriver(options);
		}
		else 
		{
			throw new RuntimeException("Invalid Browser");
		}
		
		
		return driver;
		
	}

}
