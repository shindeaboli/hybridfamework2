package DriverManagement;

import org.openqa.selenium.WebDriver;

public class DriverManager {

	private static ThreadLocal<WebDriver> threadLocal = new ThreadLocal<WebDriver>();

	private DriverManager() {
	}

	public static DriverManager getInstance() {
		return new DriverManager();
	}

	public void setDriver(String browser) {
		WebDriver driver = DriverFactory.setDriver(browser);

		threadLocal.set(driver);
	}

	public WebDriver getDriver() {
		return threadLocal.get();
	}

}
