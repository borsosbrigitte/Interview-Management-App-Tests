package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	public WebDriver driver;
	
	public LoginPage(WebDriver driver){
		this.driver = driver;
	}
	//UI Mapper
	By usernameField = By.xpath("//input[@name='username']");
	By passwordField = By.xpath("//input[@name='password']");
	By loginBtn = By.xpath("//button/span[text()='Login']");
	By dashboardArea = By.xpath("//app-home");
	//Actions
	public void enterUsername(String username){
		driver.findElement(usernameField).sendKeys(username);
	}
	public void enterPassword(String password){
		driver.findElement(passwordField).sendKeys(password);
	}
	public void clickLogin(){
		driver.findElement(loginBtn).click();
	}
	
	public String getDashboardAreaMessage() {
		return driver.findElement(dashboardArea).getText();
		
	}
	
	
}
