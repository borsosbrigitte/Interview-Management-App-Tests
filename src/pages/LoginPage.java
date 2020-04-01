package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.Menu;
public class LoginPage {
	public WebDriver driver;
	
	public LoginPage(WebDriver driver){
		this.driver = driver;
	}
	//UI Mapper
	By usernameField = By.xpath("//input[@name='username']");	
	By passwordField = By.xpath("//input[@name='password']");
	// check daca fieldul e marcat ca si mandatory
	By usernameFieldInvalid = By.xpath("//input[@name='username'][@aria-invalid='true']");
	By passwordFieldInvalid = By.xpath("//input[@name='password'][@aria-invalid='true']");
	By loginBtn = By.xpath("//button/span[text()='Login']");
	By signOutBtn = By.xpath("//button/span[text()='Sign out']");
	
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
	public void signOut() {
		driver.findElement(signOutBtn).click();
	}
	
	public Boolean userIsSignedIn(){
		Boolean present = false;
		if (driver.findElement(signOutBtn).isDisplayed()){
			present = true;
		}
		return present;
	}
	
	public Boolean usernameIsInvalid(){
		Boolean present = false;
		if (driver.findElement(usernameFieldInvalid).isDisplayed()){
			present = true;
		}
		return present;
	}
	public Boolean passwordIsInvalid(){
		Boolean present = false;
		if (driver.findElement(passwordFieldInvalid).isDisplayed()){
			present = true;
		}
		return present;
	}
	
}

