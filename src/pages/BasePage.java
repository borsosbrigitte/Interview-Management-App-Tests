package pages;

import org.openqa.selenium.WebDriver;

import actions.LoginActions;
import actions.SeniorityLevelsActions;
import pagedriver.BrowserInstance;

public class BasePage {
	protected static WebDriver driver = BrowserInstance.readBrowser();
	
	//pages
	protected LoginPage loginPage = new LoginPage(driver);
	protected SeniorityLevelsPage senioritylevelsPage = new SeniorityLevelsPage(driver);
	protected Menu menu = new Menu(driver);
	
	//actions
	protected LoginActions loginFlow = new LoginActions(driver);
	protected SeniorityLevelsActions seniorityFlow = new SeniorityLevelsActions(driver);
		
}
