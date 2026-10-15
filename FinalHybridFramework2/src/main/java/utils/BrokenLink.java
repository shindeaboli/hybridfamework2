package utils;

import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import DriverManagement.DriverManager;

public class BrokenLink {

	public static void findBrokenLinks() {
		
		List<WebElement> listLinks = DriverManager.getInstance().getDriver().findElements(By.tagName("a"));

		for (WebElement link : WaitUtils.visibilityOfAllElements(listLinks)) 
		{
			
			String linkAddress = link.getAttribute("href");

			if (linkAddress == null || linkAddress.isBlank() || linkAddress.isEmpty()
					|| !linkAddress.startsWith("http")) {

				System.err.println("Link is invalid " + linkAddress);

				continue;
			}

			try {

				HttpURLConnection httpConnection = (HttpURLConnection) new URL(linkAddress).openConnection();

				httpConnection.connect();

				int code = httpConnection.getResponseCode();

				if (code >= 400) {
					System.err.println("Link is invalid " + linkAddress);
				} else {
					System.out.println("Link is valid " + linkAddress);
				}
			} catch (Exception e) {
				e.getLocalizedMessage();
			}

		}

	}

}
