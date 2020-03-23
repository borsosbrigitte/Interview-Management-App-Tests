package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SeniorityLevelsPage {
public WebDriver driver;
	
	public SeniorityLevelsPage(WebDriver driver){
		this.driver = driver;
	}
	//UI Mapper
	By seniorityLevelsNav = By.xpath("//div/a[@href='/seniorities']");
	By senioritiesDashboard = By.xpath("//*[@class=\"elements-container\"]");
	By newSeniorityButton = By.xpath("//button[@class='mat-focus-indicator mat-icon-button mat-button-base']");
	By seniorityNameField= By.xpath("//input[@name='name']");
	By lastSeniorityName = By.xpath("(//span[contains(.,'edit')])[last()]");
	By confirmButton = By.xpath("//button/span[text()='Confirm']");
	By cancelButton = By.xpath("//button/span[text()='Cancel']");
	//Actions

		public void clickSeniorityLevelsNav() {
			driver.findElement(seniorityLevelsNav).click();
		}
		
		public void clickNewSeniorityButton() {
			driver.findElement(newSeniorityButton).click();
		}
		public String getSeniorities() {
			return driver.findElement(senioritiesDashboard).getText();
			
		}
		public void enterSeniorityLevelName(String seniorityname){
			driver.findElement(seniorityNameField).sendKeys(seniorityname);
		}
		
		public String getLastSeniorityLevelName() {
			return driver.findElement(lastSeniorityName).getText();
		}
		
		public void clickConfirm(){
			driver.findElement(confirmButton).click();
		}
		
		public void clickCancel() {
			driver.findElement(cancelButton).click();
		}

		
		
		
}
