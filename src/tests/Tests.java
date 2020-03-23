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

public class Tests extends BasePage {
	 
	@BeforeClass
	public static void Start(){
		
	}	
	//Login scenarios
	//Positive scenario
	@Test @Ignore
	//Logging in 
	public void Login() throws InterruptedException{
		Page.navigateTo(ConfigFileReader.getAppURL());
		assertEquals(Messages.APPLICATION_TITLE, Page.getTitle());
		
		loginFlow.login("Yonder1", "1Yonder");

		assertEquals("home works!", loginPage.getDashboardAreaMessage());
	}
	
	//Negative scenarios
	//login leaving mandatory fields empty
	@Test @Ignore
	public void LoginWithEmptyFields() throws InterruptedException {
		Page.navigateTo(ConfigFileReader.getAppURL());
		assertEquals(Messages.APPLICATION_TITLE, Page.getTitle());
		
		loginFlow.login("", "");

		assertNotEquals("home works!", loginPage.getDashboardAreaMessage());
	}
	
	//login leaving Username field empty
	@Test @Ignore
	public void LoginWithEmptyUsername() throws InterruptedException{
		Page.navigateTo(ConfigFileReader.getAppURL());
		assertEquals(Messages.APPLICATION_TITLE, Page.getTitle());
		
		loginFlow.login("", "1Yonder");	
		assertNotEquals("home works!", loginPage.getDashboardAreaMessage());	
	}
	
	//login leaving Password field empty
	@Test @Ignore
	public void LoginWithEmptyPassword() throws InterruptedException{
		Page.navigateTo(ConfigFileReader.getAppURL());
		assertEquals(Messages.APPLICATION_TITLE, Page.getTitle());
		
		loginFlow.login("Yonder1", "");	
		assertNotEquals("home works!", loginPage.getDashboardAreaMessage());	
	}
		
	//login with unmatching Password
	@Test @Ignore
	public void LoginWithUnmatchingPassword() throws InterruptedException{
		Page.navigateTo(ConfigFileReader.getAppURL());
		assertEquals(Messages.APPLICATION_TITLE, Page.getTitle());
		
		loginFlow.login("Yonder1", "unmatchingPassWorD100");		
		assertNotEquals("home works!", loginPage.getDashboardAreaMessage());			
	}
	
	//login with inexisting user
	@Test @Ignore
	public void LoginWithInexistingUser() throws InterruptedException{
		Page.navigateTo(ConfigFileReader.getAppURL());
		assertEquals(Messages.APPLICATION_TITLE, Page.getTitle());
		
		loginFlow.login("InexistingUser101", "InexistingUserPassword");
		assertNotEquals("home works!", loginPage.getDashboardAreaMessage());			

	}
	
	//Seniority Levels Scenarios
	//Positive scenario
	//Create new Seniority
	@Test @Ignore
	public void addNewSeniority() throws InterruptedException{
		Page.navigateTo(ConfigFileReader.getAppURL());
		assertEquals(Messages.APPLICATION_TITLE, Page.getTitle());
		
		seniorityFlow.addSeniority("TestSeniority");
		assertEquals("TestSeniority", senioritylevelsPage.getLastSeniorityLevelName());
	}
	
	//Negative scenarios
	//Adding seniority with empty name
	@Test @Ignore
	public void addNewSeniorityWithEmptyName() throws InterruptedException{
		Page.navigateTo(ConfigFileReader.getAppURL());
		assertEquals(Messages.APPLICATION_TITLE, Page.getTitle());
		
		seniorityFlow.addSeniority("");
		assertEquals("", senioritylevelsPage.getLastSeniorityLevelName());
	}
	
	@Test @Ignore
	//Cancelling the creation of a new Seniority Level
	public void cancelCreatingSeniority() throws InterruptedException{
		Page.navigateTo(ConfigFileReader.getAppURL());
		assertEquals(Messages.APPLICATION_TITLE, Page.getTitle());
		
		cancelseniorityFlow.cancelAddingSeniority();
	}
	
	@Test @Ignore
	//Creating Seniority Level with an Invalid Name
	public void addNewSenioritywithInvalidName() throws InterruptedException{
		Page.navigateTo(ConfigFileReader.getAppURL());
		assertEquals(Messages.APPLICATION_TITLE, Page.getTitle());
		
		seniorityFlow.addSeniority("OOP");
		assertEquals("OOP", senioritylevelsPage.getLastSeniorityLevelName());
	}
	
	@Test @Ignore
	//Creating Seniority Level with special characters
		public void addNewSenioritywithSpecialCharacters() throws InterruptedException{
			Page.navigateTo(ConfigFileReader.getAppURL());
			assertEquals(Messages.APPLICATION_TITLE, Page.getTitle());
			
			seniorityFlow.addSeniority("#$%Intern@#$");
			assertEquals("#$%Intern@#$", senioritylevelsPage.getLastSeniorityLevelName());
		}
	
	@Test @Ignore
	//Creating Seniority Level with too short Name
			public void addNewSenioritywithTooShortName() throws InterruptedException{
				Page.navigateTo(ConfigFileReader.getAppURL());
				assertEquals(Messages.APPLICATION_TITLE, Page.getTitle());
				
				seniorityFlow.addSeniority("B");
				assertEquals("B", senioritylevelsPage.getLastSeniorityLevelName());
			}
	
	@Test @Ignore
	//Creating Seniority Level with too long Name
	public void addNewSenioritywithTooLongName() throws InterruptedException{
		Page.navigateTo(ConfigFileReader.getAppURL());
		assertEquals(Messages.APPLICATION_TITLE, Page.getTitle());
		
		seniorityFlow.addSeniority("SeniorSeniorSeniorTestTestTestTest");
		assertEquals("SeniorSeniorSeniorTestTestTestTest", senioritylevelsPage.getLastSeniorityLevelName());
		}
	
	@Test
	//Creating Seniority Level with already existing Name
	public void addNewSenioritywithAlreadyExistingName() throws InterruptedException{
		Page.navigateTo(ConfigFileReader.getAppURL());
		assertEquals(Messages.APPLICATION_TITLE, Page.getTitle());
		
		seniorityFlow.addSeniority("Junior");
		assertEquals("Junior", senioritylevelsPage.getSeniorities());
	}
	
	@AfterClass
	public static void CloseTest(){
		Page.close();
	}

}
