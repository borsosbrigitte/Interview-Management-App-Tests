package actions;

import org.openqa.selenium.WebDriver;

import pages.SeniorityLevelsPage;

public class SeniorityLevelsActions {
	public WebDriver driver;
	public SeniorityLevelsActions(WebDriver driver){
		this.driver = driver;
	}
	
	public void addSeniority(String seniorityname){
		SeniorityLevelsPage senioritylevelsPage = new SeniorityLevelsPage(driver);
		senioritylevelsPage.clickSeniorityLevelsNav();
		senioritylevelsPage.clickNewSeniorityButton();
		senioritylevelsPage.enterSeniorityLevelName(seniorityname);
		senioritylevelsPage.clickConfirm();
		
	}
	
	public void cancelAddingSeniority() {
		SeniorityLevelsPage senioritylevelsPage = new SeniorityLevelsPage(driver);
		senioritylevelsPage.clickSeniorityLevelsNav();
		senioritylevelsPage.clickNewSeniorityButton();
		senioritylevelsPage.clickCancel();
	}
	

}
