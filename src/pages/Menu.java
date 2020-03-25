package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Menu {

	public WebDriver driver;

	public Menu(WebDriver driver) {
		this.driver = driver;
	}
	//UI Mapper
	By homeMenu = By.xpath("//div/a[@href='/home']");
	By departmentsMenu = By.xpath("//div/a[@href='/departments']");
	By questionsMenu = By.xpath("//div/a[@href='/questions']");
	By competenciesMenu = By.xpath("//div/a[@href='/competencies']");
	By seniorityLevelsMenu = By.xpath("//div/a[@href='/seniorities']");
	
	//Actions
	public void openHomePage() {
		driver.findElement(homeMenu).click();
	}
	public void openDepartmentsPage() {
		driver.findElement(departmentsMenu).click();
	}
	public void openQuestions() {
		driver.findElement(questionsMenu).click();
	}
	public void openCompetenciesPage() {
		driver.findElement(competenciesMenu).click();
	}
	public void openSeniorityLevelsPage() {
		driver.findElement(seniorityLevelsMenu).click();
	}
}
