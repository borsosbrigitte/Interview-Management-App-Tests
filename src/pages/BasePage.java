package pages;

import org.openqa.selenium.WebDriver;


import actions.LoginActions;
import actions.SeniorityLevelsActions;
import pagedriver.BrowserInstance;
public class BasePage {
	protected static WebDriver driver = BrowserInstance.readBrowser();
	
	protected LoginPage loginPage = new LoginPage(driver);
	protected LoginActions loginFlow = new LoginActions(driver);

	protected SeniorityLevelsPage senioritylevelsPage = new SeniorityLevelsPage(driver);
	protected SeniorityLevelsActions seniorityFlow = new SeniorityLevelsActions(driver);
	protected SeniorityLevelsActions cancelseniorityFlow = new SeniorityLevelsActions(driver);
}
