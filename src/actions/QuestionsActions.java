package actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import pages.QuestionsPage;

public class QuestionsActions {
	public WebDriver driver;
	public QuestionsActions(WebDriver driver) {
		this.driver = driver;
	}
	
	By checkBoxNames = By.xpath("//label/span[contains(text(),name)]");
	
	public WebElement checkboxName(String name) {
		return driver.findElement(By.xpath("//label/span[contains(text(),'"+name+"'')]"));
	}
	
	public void clickCheckBox() {
		driver.findElement(checkBoxNames).click();
	}
}