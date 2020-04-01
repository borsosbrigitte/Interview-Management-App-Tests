package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class SeniorityLevelsPage {
	public WebDriver driver;

	public SeniorityLevelsPage(WebDriver driver) {
		this.driver = driver;
	}
	// UI Mapper
	
	By senioritiesDashboard = By.xpath("//div[@class='elements-container']");
	By newBtn = By.xpath("//button[@class='mat-focus-indicator mat-icon-button mat-button-base']");
	By nameField = By.xpath("//input[@name='name']");
	By nameFieldInvalid = By.xpath("//input[@name='name'][@aria-invalid='true']");
	By lastSeniority = By.xpath("//div/following::mat-card-title[last()]");
	By lastEditBtn = By.xpath("//div/following::span[contains(.,'Edit')][last()]");
	By lastDeleteBtn = By.xpath("//div/following::span[contains(.,'Delete')][last()]");
	By confirmBtn = By.xpath("//span[contains(text(),'Confirm')]/parent::button");
	By confirmBtnDisabled = By.xpath("//button[@disabled='true']/span[contains(text(),'Confirm')]");
	By cancelBtn = By.xpath("//button/span[text()='Cancel']");
	
	// Actions

	public void clickNewButton() {
		driver.findElement(newBtn).click();
	}

	public String getSeniorities() {
		return driver.findElement(senioritiesDashboard).getText();

	}
	
	public void enterName(String seniorityname) {
		driver.findElement(nameField).clear();
		driver.findElement(nameField).sendKeys(seniorityname);
	}

	public String getLastName() {
		return driver.findElement(lastSeniority).getText();
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
	
	public Boolean nameisInvalid(){
		Boolean present = false;
		if (driver.findElement(nameFieldInvalid).isDisplayed()){
			present = true;
		}
		return present;
	}
	public void clearName() {
		driver.findElement(nameField).clear();
		driver.findElement(nameField).sendKeys(" ");
		driver.findElement(nameField).sendKeys(Keys.BACK_SPACE);
	}
	
	public String getMessageWindowText() {
		By messageWindow = By.xpath("//simple-snack-bar/span");
		return driver.findElement(messageWindow).getText();
	}
}
