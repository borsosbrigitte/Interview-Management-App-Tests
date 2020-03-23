package pagedriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import utils.ConfigFileReader;
import utils.Constants;

public class BrowserInstance {
    //path chrome
	public static WebDriver driver;
	
	public static WebDriver readBrowser(){
		ConfigFileReader configReader = new ConfigFileReader();
		String browserName = configReader.getBrowserName();
		
		if (browserName.equalsIgnoreCase("chrome")){
			return buildChromeDriver();
		}
		else return buildFirefoxDriver();
		
	}
	public static WebDriver buildChromeDriver(){
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Constants.IMPLICIT_WAIT, TimeUnit.SECONDS);
		return driver;
	}
	public static WebDriver buildFirefoxDriver(){
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(Constants.IMPLICIT_WAIT, TimeUnit.SECONDS);
		return driver;
	}
}
