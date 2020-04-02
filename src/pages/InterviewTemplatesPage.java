package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class InterviewTemplatesPage {
	public WebDriver driver;

	public InterviewTemplatesPage(WebDriver driver) {
		this.driver = driver;
	}
	
	// UI Mapper
	
	By templatesDashboard = By.xpath("//div[@class='templates-container']");
	By newBtn = By.xpath("//button[@class='mat-focus-indicator mat-icon-button mat-button-base']");
	By titleField = By.xpath("//input[@name='title']");
	By titleFieldInvalid = By.xpath("//input[@name='title'][@aria-invalid='true']");
	By lastInterviewTemplate = By.xpath("//div/following::mat-card-title[last()]");
	By lastEditBtn = By.xpath("//div/following::span[contains(.,'Edit')][last()]");
	By lastDeleteBtn = By.xpath("//div/following::span[contains(.,'Delete')][last()]");
	By confirmBtn = By.xpath("//span[contains(text(),'Confirm')]/parent::button");
	By confirmBtnDisabled = By.xpath("//button[@disabled='true']/span[contains(text(),'Confirm')]");
	By cancelBtn = By.xpath("//button/span[text()='Cancel']");
	By questionsCheckbox = By.xpath("//mat-checkbox/label");
	
	// Actions
		public void clickNewButton() {
			driver.findElement(newBtn).click();
		}

		public String getInterviewTemplates() {
			return driver.findElement(templatesDashboard).getText();

		}
		
		public void enterTitle(String interviewtitle) {
			driver.findElement(titleField).clear();
			driver.findElement(titleField).sendKeys(interviewtitle);
		}
		public void clickCheckbox() {
			driver.findElement(questionsCheckbox).click();
		}
		public String getLastInterviewTemplate() {
			return driver.findElement(lastInterviewTemplate).getText();
		}
		public void clickEdit() {
			driver.findElement(lastEditBtn).click();
		}
		public void clickDelete() {
			driver.findElement(lastDeleteBtn).click();
		}
		public void clickConfirm() {
			driver.findElement(confirmBtn).click();
		}

		public void clickCancel() {
			driver.findElement(cancelBtn).click();
		}
		
		public Boolean confirmIsDisabled(){
			String enabled = driver.findElement(confirmBtn).getAttribute("disabled");
			System.out.println("!!!!"+enabled);	
			return Boolean.valueOf(enabled);
		}
		
		public Boolean titleisInvalid(){
			Boolean present = false;
			if (driver.findElement(titleFieldInvalid).isDisplayed()){
				present = true;
			}
			return present;
		}
		public void clearTitle() {
			driver.findElement(titleField).clear();
			driver.findElement(titleField).sendKeys(" ");
			driver.findElement(titleField).sendKeys(Keys.BACK_SPACE);
		}
		
		public String getMessageWindowText() {
			By messageWindow = By.xpath("//simple-snack-bar/span");
			return driver.findElement(messageWindow).getText();
		}
}
