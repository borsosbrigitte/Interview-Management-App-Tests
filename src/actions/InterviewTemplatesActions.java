package actions;

import org.openqa.selenium.WebDriver;

import pages.InterviewTemplatesPage;

public class InterviewTemplatesActions {
	public WebDriver driver;
	public InterviewTemplatesActions(WebDriver driver){
		this.driver = driver;
	}
	
	public void addNew(String interviewtitle) throws InterruptedException{
		InterviewTemplatesPage interviewTemplatesPage = new InterviewTemplatesPage(driver);
		interviewTemplatesPage.clickNewButton();
		interviewTemplatesPage.enterTitle(interviewtitle);
		Thread.sleep(2000);
		interviewTemplatesPage.clickCheckbox();
		interviewTemplatesPage.clickConfirm();

	}
	public void editLast(String interviewtitle){
		InterviewTemplatesPage interviewTemplatesPage = new InterviewTemplatesPage(driver);
		interviewTemplatesPage.clickEdit();
		interviewTemplatesPage.clearTitle();
		interviewTemplatesPage.enterTitle(interviewtitle);
		interviewTemplatesPage.clickCheckbox();
		interviewTemplatesPage.clickConfirm();	
		
	}
	public void deleteLast(){
		InterviewTemplatesPage interviewTemplatesPage = new InterviewTemplatesPage(driver);
		interviewTemplatesPage.clickDelete();
		interviewTemplatesPage.clickConfirm();	
	
	}
}
