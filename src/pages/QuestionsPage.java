package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class QuestionsPage {
public WebDriver driver;
	
	public QuestionsPage(WebDriver driver) {
		this.driver = driver;
	}
	
	//UI Mapper
	By clickAddNewQuestionsBtn = By.xpath("//button[@id='addButton']");
	By textField = By.xpath("//input[@name='title']");
	By clickOpenDepartmentSelect = By.xpath("//div[@class='mat-select-value ng-tns-c65-61']");
//	By selectDepartmentField = By.xpath("//mat-select[@id='mat-select-0']");
	By selectDepartmentField = By.xpath("//mat-option/span[contains(text(),'test')] ");	
	By selectSeniorityField = By.xpath("//mat-select[@id='mat-select-1']");
	By checkQuestionsCompetencies = By.xpath("//label/span[contains(text(),'test')]");
	By confirmBtn = By.xpath("//span[contains(text(),'Confirm')]/parent::button");
	By saveBtn = By.xpath("//button[contains(.,'Save')]");
	By cancelBtn = By.xpath("//button/span[text()='Cancel']");
	
	//Actions
	
}