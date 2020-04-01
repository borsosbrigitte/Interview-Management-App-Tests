package actions;

import org.openqa.selenium.WebDriver;

import pages.SeniorityLevelsPage;

public class SeniorityLevelsActions {
	public WebDriver driver;
	public SeniorityLevelsActions(WebDriver driver){
		this.driver = driver;
	}
	
	public void addNew(String seniorityname){
		SeniorityLevelsPage senioritylevelsPage = new SeniorityLevelsPage(driver);
		senioritylevelsPage.clickNewButton();
		senioritylevelsPage.enterName(seniorityname);
		senioritylevelsPage.clickConfirm();
	}
	public void editLast(String seniorityname){
		SeniorityLevelsPage senioritylevelsPage = new SeniorityLevelsPage(driver);
		senioritylevelsPage.clickEdit();
		senioritylevelsPage.clearName();
		senioritylevelsPage.enterName(seniorityname);
		senioritylevelsPage.clickConfirm();
	}
	public void deleteLast(){
		SeniorityLevelsPage senioritylevelsPage = new SeniorityLevelsPage(driver);
		senioritylevelsPage.clickDelete();
		senioritylevelsPage.clickConfirm();
	}
	public void cancelAdding() {
		SeniorityLevelsPage senioritylevelsPage = new SeniorityLevelsPage(driver);
		senioritylevelsPage.clickNewButton();
		senioritylevelsPage.clickCancel();
	}
	
}
