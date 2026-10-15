package config;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import base.BaseTest;

public class ConfigManager {

	private static final Logger logger = LogManager.getLogger(BaseTest.class);
	private final static Properties prop = new Properties();

	// Singleton Design Pattern
	private ConfigManager() {

	}

	public static ConfigManager getInstance() {
		return new ConfigManager();
	}

	// Load Config file
	public void loadConfig(String env) throws IOException {

		String path = System.getProperty("user.dir") + "//src//test//resources//config//" + env + ".properties";

		logger.info("Reading Config file content");
		FileInputStream fis = new FileInputStream(path);

		logger.info("Loading Config file");

		prop.load(fis);

	}

	// capture property from properties file
	public String getUrl() {
		logger.info("Get URL from Config file");

		return prop.getProperty("URL");
	}

	public String getUsername() {
		logger.info("Get USERNAME from Config file");

		return prop.getProperty("USERNAME");
	}

	public String getPassword() {
		logger.info("Get PASSWORD from Config file");

		return prop.getProperty("PASSWORD");
	}

}
