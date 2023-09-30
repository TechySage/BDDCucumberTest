package Utilities;

import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {

	Properties prop;
	String path = "C:\\Users\\brnat\\OneDrive\\Desktop\\Javaproject\\CucumberBDD\\config.properties";

	// constructor
	public ReadConfig() {
		try {

			prop = new Properties();
			FileInputStream fis = new FileInputStream(path);
			prop.load(fis);

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	public String getBrowser() {

		String DriverBrowser = prop.getProperty("browse");

		if (DriverBrowser != null) {

			return DriverBrowser;
		} else {
			throw new RuntimeException("Browser not specified in config file");
		}

	}

}
