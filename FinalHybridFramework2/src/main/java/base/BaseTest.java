package base;

import java.io.IOException;
import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

import DriverManagement.DriverManager;
import config.ConfigManager;
import constant.WaitConstant;

public class BaseTest {

	private static final Logger logger = LogManager.getLogger(BaseTest.class);

	public static void initialization(String browser) throws IOException {

		logger.info("Configuring browser in ThreadLocal class");
		DriverManager.getInstance().setDriver(browser);

		logger.info("Capture driver from ThreadLocal class");

		WebDriver driver = DriverManager.getInstance().getDriver();

		logger.info("Open Environment URL");
		driver.get(ConfigManager.getInstance().getUrl());

		logger.info("Adding GLobal Implicitly Wait");

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(WaitConstant.IMPLICITLY_WAIT));

		logger.info("Adding Page Load timeout Wait");

		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(WaitConstant.PAGE_LOAD_TIME_OUT));

		logger.info("Maximizing browser");
		driver.manage().window().maximize();

	}

}
