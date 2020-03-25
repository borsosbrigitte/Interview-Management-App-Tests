package pagedriver;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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
	public static String getAlertText(){
		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.alertIsPresent());
		Alert alert = driver.switchTo().alert();
		String alertMessage = alert.getText();
		alert.accept();
		return alertMessage;
	}
}
