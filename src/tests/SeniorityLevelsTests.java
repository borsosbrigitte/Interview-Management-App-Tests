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

	@Test @Ignore
	//Smoke test 
	public void addEditDeleteSeniority() throws InterruptedException {
		Page.navigateTo(ConfigFileReader.getAppURL());
		assertEquals(Messages.APPLICATION_TITLE, Page.getTitle());

		loginFlow.login("Yonder1", "1Yonder");
		assertEquals("home works!", loginPage.getDashboardAreaMessage());

		menu.openSeniorityLevelsPage();
	
		seniorityFlow.addNew("TestSeniority"+randomstr);
		Thread.sleep(2000);
		assertEquals("TestSeniority"+randomstr, senioritylevelsPage.getLastName());

		seniorityFlow.editLast("TestSeniorityEdit"+randomstr);
		Thread.sleep(2000);
		assertEquals("TestSeniorityEdit"+randomstr, senioritylevelsPage.getLastName());

		seniorityFlow.deleteLast();
		assertNotEquals("TestSeniorityEdit"+randomstr, senioritylevelsPage.getLastName());
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

		seniorityFlow.addNew("Junior"+randomstr);
		Thread.sleep(3000);
		assertEquals("Junior"+randomstr, senioritylevelsPage.getLastName());
		seniorityFlow.addNew("Junior"+randomstr);
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

		seniorityFlow.addNew("#$%Intern@#$"+randomstr);
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
		
		seniorityFlow.addNew("SeniorityTest"+randomstr);
		Thread.sleep(2000);
		assertEquals("SeniorityTest"+randomstr, senioritylevelsPage.getLastName());

		seniorityFlow.editLast("$%SeniorityTestEdit%$"+randomstr);
		Thread.sleep(2000);
		assertTrue(senioritylevelsPage.confirmIsDisabled());
		assertEquals(Messages.INVALID_SENIORITY, Page.getAlertText());
		assertTrue(senioritylevelsPage.nameisInvalid());

	}
	@Test 
	public void editWithAlreadyExistingName() throws InterruptedException{
		Page.navigateTo(ConfigFileReader.getAppURL());
		assertEquals(Messages.APPLICATION_TITLE, Page.getTitle());

		loginFlow.login("Yonder1", "1Yonder");
		assertEquals("home works!", loginPage.getDashboardAreaMessage());

		menu.openSeniorityLevelsPage();
		
		seniorityFlow.addNew("AlreadyExistingEdit"+randomstr);
		Thread.sleep(2000);
		assertEquals("AlreadyExistingEdit"+randomstr, senioritylevelsPage.getLastName());
		
		senioritylevelsPage.getSeniorities();
		Thread.sleep(2000);
	
		seniorityFlow.editLast("AlreadyExistingEdit"+randomstr);
		assertTrue(senioritylevelsPage.confirmIsDisabled());
		assertEquals(Messages.EXISTING_SENIORITY, Page.getAlertText());
		assertTrue(senioritylevelsPage.nameisInvalid());
	}
	@AfterClass
	public static void CloseTest() {
		Page.close();
	}

}
