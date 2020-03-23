package utils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigFileReader {

	private static Properties properties;
	private final String propertyFilePath = "src//conf//conf.properties//";
	
	// loads config file
		public ConfigFileReader() {
			BufferedReader reader;
			try {
				reader = new BufferedReader(new FileReader(propertyFilePath));
				properties = new Properties();
				try {
					properties.load(reader);
					reader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			} catch (FileNotFoundException e) {
				e.printStackTrace();
				throw new RuntimeException("Configuration.properties not found at "+ propertyFilePath);
			}
		}

		public static String getAppURL() {
			String url = properties.getProperty("URL");
			if (url != null)
				return url;
			else
				throw new RuntimeException("url not specified in the Configuration.properties file.");
		}

		public static String getBrowserName() {
			String browser = properties.getProperty("BROWSER");
			if (browser != null)
				return browser;
			else
				throw new RuntimeException("browser not specified in the Configuration.properties file.");
		}
}

