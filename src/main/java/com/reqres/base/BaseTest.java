package com.reqres.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

import org.testng.log4testng.Logger;

public class BaseTest {
	public static Properties prop;
	public Logger logger;

	public String initilizeProperties(String key) {
		prop = new Properties();
		String value = null;
		try {
			FileInputStream propFile = new FileInputStream("./config/application.properties");
			prop.load(propFile);
			value = prop.getProperty(key);
		} catch (FileNotFoundException e) {
			logger.error("Exception while performing input operations in properties file" + e.getMessage());

		} catch (Exception e) {
			logger.error("Exception while performing input operations in properties file" + e.getMessage());
		}
		return value;
	}
}
