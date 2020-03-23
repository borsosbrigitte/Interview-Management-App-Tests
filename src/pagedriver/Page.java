package pagedriver;

import org.openqa.selenium.WebDriver;

public class Page {
	public static WebDriver driver = BrowserInstance.driver;
	
	public static void navigateTo(String pageURL){
		driver.get(pageURL);
	}
	public static void close(){
		driver.quit();
	}
	public static String getTitle(){
		return driver.getTitle();
	}
}
