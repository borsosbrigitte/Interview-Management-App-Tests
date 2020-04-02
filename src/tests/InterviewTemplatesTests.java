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
		Thread.sleep(2000);
		assertEquals("Test"+randomstr, interviewTemplatesPage.getLastInterviewTemplate());
		assertEquals(Messages.ADDED_INTERVIEW_TEMPLATE, interviewTemplatesPage.getMessageWindowText());

//		seniorityFlow.editLast("Test"+randomstr+randomstr);
//		Thread.sleep(2000);
//		assertEquals("Test"+randomstr+randomstr, senioritylevelsPage.getLastName());
//		Thread.sleep(2000);
//		assertEquals(Messages.UPDATED_SENIORITY, senioritylevelsPage.getMessageWindowText());
//		
//		seniorityFlow.deleteLast();
//		Thread.sleep(2000);
//		assertNotEquals("Test"+randomstr+randomstr, senioritylevelsPage.getLastName());
//		Thread.sleep(2000);
//
//		assertEquals(Messages.DELETED_SENIORITY, senioritylevelsPage.getMessageWindowText());
	}
	@AfterClass
	public static void CloseTest() {
		Page.close();
	}
}
