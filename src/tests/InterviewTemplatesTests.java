package tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import pagedriver.Page;
import utils.ConfigFileReader;
import utils.Messages;
import utils.Util;
import actions.LoginActions;
import pages.LoginPage;
import pages.BasePage;
import pagedriver.Page;
import actions.LoginActions;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import actions.LoginActions;

import pagedriver.BrowserInstance;
import pagedriver.Page;
import pages.BasePage;
import pages.LoginPage;

import utils.ConfigFileReader;
import utils.Constants;
import utils.Messages;
import utils.Util;
public class InterviewTemplatesTests extends BasePage {
	
	String randomstr=Util.generateRandomString();
	
	@BeforeClass
	public static void Start() {

	}
	
	@Test 
	//Smoke test 
	public void addEditDeleteInterviewTemplate() throws InterruptedException{
		Page.navigateTo(ConfigFileReader.getAppURL());
		assertEquals(Messages.APPLICATION_TITLE, Page.getTitle());
		
		loginFlow.login("Yonder1", "1Yonder");
		assertTrue(loginPage.userIsSignedIn());
		
		interviewFlow.addNew("Test"+randomstr);
		assertEquals(Messages.ADDED_INTERVIEW_TEMPLATE, interviewTemplatesPage.getMessageWindowText());
		Thread.sleep(1000);
		assertEquals("Test"+randomstr, interviewTemplatesPage.getLastInterviewTemplate());

		interviewFlow.editLast("Test"+randomstr+randomstr);
		assertEquals(Messages.UPDATED_INTERVIEW_TEMPLATE, interviewTemplatesPage.getMessageWindowText());
		Thread.sleep(1000);
		assertEquals("Test"+randomstr+randomstr, interviewTemplatesPage.getLastInterviewTemplate());
		
		interviewFlow.deleteLast();
		assertEquals(Messages.DELETED_INTERVIEW_TEMPLATE,interviewTemplatesPage.getMessageWindowText());
		Thread.sleep(1000);
		assertNotEquals("Test"+randomstr+randomstr, interviewTemplatesPage.getLastInterviewTemplate());
	}
	
	//Negative scenarios
	@Test @Ignore
	public void addNewWithAlreadyExistingTitle() throws InterruptedException{
		Page.navigateTo(ConfigFileReader.getAppURL());
		assertEquals(Messages.APPLICATION_TITLE, Page.getTitle());
		
		loginFlow.login("Yonder1", "1Yonder");
		assertTrue(loginPage.userIsSignedIn());
		
		interviewFlow.addNew("Test"+randomstr);
		assertEquals(Messages.ADDED_INTERVIEW_TEMPLATE, interviewTemplatesPage.getMessageWindowText());
		Thread.sleep(1000);
		assertEquals("Test"+randomstr, interviewTemplatesPage.getLastInterviewTemplate());
		
		interviewFlow.addNew("Test"+randomstr);
		assertEquals(Messages.ERROR_EXISTING_INTERVIEW_TITLE, interviewTemplatesPage.getMessageWindowText());

	}
	
	@Test @Ignore
	//momentan se pot adauga caractere speciale
	public void addNewWithSpecialCharacters() throws InterruptedException {
		Page.navigateTo(ConfigFileReader.getAppURL());
		assertEquals(Messages.APPLICATION_TITLE, Page.getTitle());
		
		loginFlow.login("Yonder1", "1Yonder");
		assertTrue(loginPage.userIsSignedIn());
		
		interviewFlow.addNew("Test#%"+randomstr);
		assertEquals(Messages.ERROR_INVALID_INTERVIEW_TITLE, interviewTemplatesPage.getMessageWindowText());
		Thread.sleep(1000);
		assertNotEquals("Test#%"+randomstr, interviewTemplatesPage.getLastInterviewTemplate());

	}
	
	@Test @Ignore
	//momentan se poate edita cu caractere speciale
	public void editWithInvalidData() throws InterruptedException{
		Page.navigateTo(ConfigFileReader.getAppURL());
		assertEquals(Messages.APPLICATION_TITLE, Page.getTitle());

		loginFlow.login("Yonder1", "1Yonder");
		assertTrue(loginPage.userIsSignedIn());

		interviewFlow.addNew("Test"+randomstr);
		Thread.sleep(1000);
		assertEquals(Messages.ADDED_INTERVIEW_TEMPLATE, interviewTemplatesPage.getMessageWindowText());
		Thread.sleep(1000);
		assertEquals("Test"+randomstr, interviewTemplatesPage.getLastInterviewTemplate());

		interviewFlow.editLast("Test$%#"+randomstr);
		assertEquals(Messages.ERROR_INVALID_INTERVIEW_TITLE, interviewTemplatesPage.getMessageWindowText());
		Thread.sleep(1000);
		assertNotEquals("Test$%#"+randomstr, interviewTemplatesPage.getLastInterviewTemplate());

	}
	@Test @Ignore
	//momentan se poate edita cu un titlu deja existent
	public void editWithAlreadyExistingTitle() throws InterruptedException{
		Page.navigateTo(ConfigFileReader.getAppURL());
		assertEquals(Messages.APPLICATION_TITLE, Page.getTitle());

		loginFlow.login("Yonder1", "1Yonder");
		assertTrue(loginPage.userIsSignedIn());

		interviewFlow.addNew("Test"+randomstr);
		assertEquals(Messages.ADDED_INTERVIEW_TEMPLATE, interviewTemplatesPage.getMessageWindowText());
		Thread.sleep(1000);
		assertEquals("Test"+randomstr, interviewTemplatesPage.getLastInterviewTemplate());

		interviewFlow.editLast("Test"+randomstr);
		assertEquals(Messages.ERROR_EXISTING_INTERVIEW_TITLE, interviewTemplatesPage.getMessageWindowText());
		Thread.sleep(1000);
		assertNotEquals("Test"+randomstr, interviewTemplatesPage.getLastInterviewTemplate());
	}
	@AfterClass
	public static void CloseTest() {
		Page.close();
	}
}
