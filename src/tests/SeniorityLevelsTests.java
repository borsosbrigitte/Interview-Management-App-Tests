package tests;

import static org.junit.Assert.*;

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

public class SeniorityLevelsTests extends BasePage {
	
	String randomstr=Util.generateRandomString();
	
	@BeforeClass
	public static void Start() {

	}

	@Test 
	//Smoke test 
	public void addEditDeleteSeniority() throws InterruptedException {
		Page.navigateTo(ConfigFileReader.getAppURL());
		assertEquals(Messages.APPLICATION_TITLE, Page.getTitle());

		loginFlow.login("Yonder1", "1Yonder");
		assertTrue(loginPage.userIsSignedIn());

		menu.openSeniorityLevelsPage();
	
		seniorityFlow.addNew("Test"+randomstr);
		Thread.sleep(2000);
		assertEquals("Test"+randomstr, senioritylevelsPage.getLastName());
		Thread.sleep(2000);
		assertEquals(Messages.ADDED_SENIORITY, senioritylevelsPage.getMessageWindowText());

//		seniorityFlow.editLast("Test"+randomstr+randomstr);
//		Thread.sleep(2000);
//		assertEquals("Test"+randomstr+randomstr, senioritylevelsPage.getLastName());
//		assertEquals(Messages.UPDATED_SENIORITY, senioritylevelsPage.getMessageWindowText());
//		
//		seniorityFlow.deleteLast();
//		Thread.sleep(2000);
//		assertNotEquals("Test"+randomstr+randomstr, senioritylevelsPage.getLastName());
//		assertEquals(Messages.DELETED_SENIORITY, senioritylevelsPage.getMessageWindowText());
	}
	
	//Negative scenarios
	@Test @Ignore
	// Creating Seniority Level with already existing Name
	public void addNewWithAlreadyExistingName() throws InterruptedException {
		Page.navigateTo(ConfigFileReader.getAppURL());
		assertEquals(Messages.APPLICATION_TITLE, Page.getTitle());

		loginFlow.login("Yonder1", "1Yonder");
		assertTrue(loginPage.userIsSignedIn());
		
		menu.openSeniorityLevelsPage();

		seniorityFlow.addNew("Junior"+randomstr);
		Thread.sleep(2000);
		assertEquals("Junior"+randomstr, senioritylevelsPage.getLastName());
		assertEquals(Messages.ADDED_SENIORITY, senioritylevelsPage.getMessageWindowText());
		Thread.sleep(2000);
	
		seniorityFlow.addNew("Junior"+randomstr);
		Thread.sleep(2000);
		assertEquals(Messages.ERROR_EXISTING_SENIORITY, senioritylevelsPage.getMessageWindowText());
		Thread.sleep(2000);

	}
	@Test @Ignore
	// Creating Seniority Level with special characters
	//nu e implementat
	public void addNewWithSpecialCharacters() throws InterruptedException {
		Page.navigateTo(ConfigFileReader.getAppURL());
		assertEquals(Messages.APPLICATION_TITLE, Page.getTitle());
		
		loginFlow.login("Yonder1", "1Yonder");
		assertTrue(loginPage.userIsSignedIn());
		
		menu.openSeniorityLevelsPage();

		seniorityFlow.addNew("#$%Intern@#$"+randomstr);
		Thread.sleep(2000);
		assertEquals(Messages.ERROR_INVALID_SENIORITY, senioritylevelsPage.getMessageWindowText());
		Thread.sleep(2000);
	}
	
	@Test @Ignore
	//se poate edita cu caractere speciale
	public void editWithInvalidData() throws InterruptedException{
		Page.navigateTo(ConfigFileReader.getAppURL());
		assertEquals(Messages.APPLICATION_TITLE, Page.getTitle());

		loginFlow.login("Yonder1", "1Yonder");
		assertTrue(loginPage.userIsSignedIn());

		menu.openSeniorityLevelsPage();
		
		seniorityFlow.addNew("Test"+randomstr);
		Thread.sleep(2000);
		assertEquals("Test"+randomstr, senioritylevelsPage.getLastName());
		
		seniorityFlow.editLast("Test"+randomstr+"4%");
		Thread.sleep(2000);
		assertEquals(Messages.ERROR_INVALID_SENIORITY, senioritylevelsPage.getMessageWindowText());
		Thread.sleep(2000);

	}
	@Test @Ignore
	public void editWithAlreadyExistingName() throws InterruptedException{
		Page.navigateTo(ConfigFileReader.getAppURL());
		assertEquals(Messages.APPLICATION_TITLE, Page.getTitle());

		loginFlow.login("Yonder1", "1Yonder");
		assertTrue(loginPage.userIsSignedIn());

		menu.openSeniorityLevelsPage();
		
		seniorityFlow.addNew("Test"+randomstr);
		Thread.sleep(2000);
		assertEquals("Test"+randomstr, senioritylevelsPage.getLastName());
		
		Thread.sleep(2000);
	
		seniorityFlow.editLast("Test"+randomstr);
		Thread.sleep(2000);
		assertEquals(Messages.ERROR_EDIT_WITH_EXISTING_SENIORITY, senioritylevelsPage.getMessageWindowText());
		Thread.sleep(2000);
	}
	@AfterClass
	public static void CloseTest() {
		Page.close();
	}

}
