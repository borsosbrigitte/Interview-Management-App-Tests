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

	@BeforeClass
	public static void Start() {

	}

	@Test 
	//Smoke test 
	public void addEditDeleteSeniority() throws InterruptedException {
		Page.navigateTo(ConfigFileReader.getAppURL());
		assertEquals(Messages.APPLICATION_TITLE, Page.getTitle());

		loginFlow.login("Yonder1", "1Yonder");
		assertEquals("home works!", loginPage.getDashboardAreaMessage());

		menu.openSeniorityLevelsPage();
	
		seniorityFlow.addNew("TestSeniority");
		Thread.sleep(2000);
		assertEquals("TestSeniority", senioritylevelsPage.getLastName());

		seniorityFlow.editLast("TestSeniorityEdit");
		Thread.sleep(2000);
		assertEquals("TestSeniorityEdit", senioritylevelsPage.getLastName());

		seniorityFlow.deleteLast();
		assertNotEquals("TestSeniorityEdit", senioritylevelsPage.getLastName());
	}
	
	//Negative scenarios
	@Test @Ignore
	// Creating Seniority Level with already existing Name
	public void addNewWithAlreadyExistingName() throws InterruptedException {
		Page.navigateTo(ConfigFileReader.getAppURL());
		assertEquals(Messages.APPLICATION_TITLE, Page.getTitle());

		loginFlow.login("Yonder1", "1Yonder");
		assertEquals("home works!", loginPage.getDashboardAreaMessage());
		
		menu.openSeniorityLevelsPage();

		seniorityFlow.addNew("Junior");
		Thread.sleep(3000);
		assertTrue(senioritylevelsPage.confirmIsDisabled());
		assertEquals(Messages.EXISTING_SENIORITY, Page.getAlertText());
		assertTrue(senioritylevelsPage.nameisInvalid());
	}
	@Test @Ignore
	// Creating Seniority Level with special characters
	public void addNewWithSpecialCharacters() throws InterruptedException {
		Page.navigateTo(ConfigFileReader.getAppURL());
		assertEquals(Messages.APPLICATION_TITLE, Page.getTitle());
		
		loginFlow.login("Yonder1", "1Yonder");
		assertEquals("home works!", loginPage.getDashboardAreaMessage());
		
		menu.openSeniorityLevelsPage();

		seniorityFlow.addNew("#$%Intern@#$");
		Thread.sleep(2000);
		assertTrue(senioritylevelsPage.confirmIsDisabled());
		assertEquals(Messages.INVALID_SENIORITY, Page.getAlertText());
		assertTrue(senioritylevelsPage.nameisInvalid());
	}
	
	@Test @Ignore
	public void editWithInvalidData() throws InterruptedException{
		Page.navigateTo(ConfigFileReader.getAppURL());
		assertEquals(Messages.APPLICATION_TITLE, Page.getTitle());

		loginFlow.login("Yonder1", "1Yonder");
		assertEquals("home works!", loginPage.getDashboardAreaMessage());

		menu.openSeniorityLevelsPage();
		
		seniorityFlow.addNew("SeniorityTest");
		Thread.sleep(2000);
		assertEquals("SeniorityTest", senioritylevelsPage.getLastName());

		seniorityFlow.editLast("$%SeniorityTestEdit%$");
		Thread.sleep(2000);
		assertTrue(senioritylevelsPage.confirmIsDisabled());
		assertEquals(Messages.INVALID_SENIORITY, Page.getAlertText());
		assertTrue(senioritylevelsPage.nameisInvalid());

	}
	
	@AfterClass
	public static void CloseTest() {
		Page.close();
	}

}
