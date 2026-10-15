package tests;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import DriverManagement.DriverManager;
import base.BaseTest;
import config.ConfigManager;
import pages.LoginPage;

public class LoginPageTest {

	private static final Logger logger = LogManager.getLogger(LoginPageTest.class);

	@Parameters({ "env" })
	@BeforeSuite(alwaysRun = true)
	public void loadEnvironment(String env) throws IOException {

		ConfigManager.getInstance().loadConfig(env);

		logger.info("Executing Test Cases on " + env + " Environment");

	}

	@Parameters({ "browser" })
	@BeforeTest
	public void setUp(String browser) throws IOException {
		BaseTest.initialization(browser);
		logger.info("Executing Test Cases on " + browser);
	}

	@Test
	public void validateLoginFunctionality() throws IOException, InterruptedException {

		LoginPage loginPage = new LoginPage();

		logger.info("Reading username value from config file");

		String username = ConfigManager.getInstance().getUsername();

		logger.info("Entering value in Username Text box");
		loginPage.enterUsername(username);

		logger.info("Reading Password value from config file");
		logger.info("Entering value in Password Text box");
		loginPage.enterPassword(ConfigManager.getInstance().getPassword());

		Thread.sleep(4000);

		logger.info("Clicking on Login button");

		loginPage.clickOnLoginButton();
		Thread.sleep(4000);

	}

	@AfterTest
	public void tearDown() {
		DriverManager.getInstance().getDriver().quit();
	}

}
