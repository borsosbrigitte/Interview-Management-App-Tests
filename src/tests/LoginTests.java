package tests;

import utils.Util;
import static org.junit.Assert.*;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import pagedriver.Page;
import pages.BasePage;
import pages.Menu;
import utils.ConfigFileReader;
import utils.Messages;

public class LoginTests extends BasePage{

	@BeforeClass
	public static void Start() {

	}
	
	//Positive scenario
	@Test
	// Logging in - successfully
	public void Login() throws InterruptedException {
		Page.navigateTo(ConfigFileReader.getAppURL());
		assertEquals(Messages.APPLICATION_TITLE, Page.getTitle());

		loginFlow.login("Yonder1", "1Yonder");

		assertTrue(loginPage.userIsSignedIn());
	}

	// Negative scenarios
	@Test @Ignore
	// login leaving mandatory fields empty
	public void LoginWithEmptyFields() throws InterruptedException {
		Page.navigateTo(ConfigFileReader.getAppURL());
		assertEquals(Messages.APPLICATION_TITLE, Page.getTitle());

		loginPage.clickLogin();

		assertTrue(loginPage.usernameIsInvalid());
		assertTrue(loginPage.passwordIsInvalid());
		assertEquals(Messages.LOGIN_ERROR, Page.getAlertText());

	}
	
	@Test @Ignore
	public void LoginWithUnmatchingPassword() throws InterruptedException {
		Page.navigateTo(ConfigFileReader.getAppURL());
		assertEquals(Messages.APPLICATION_TITLE, Page.getTitle());

		loginFlow.login("Yonder1", "unmatchingPassword"+Util.generateRandomInt(2000));
		
		assertEquals(Messages.LOGIN_ERROR, Page.getAlertText());
	}

	@Test @Ignore
	public void LoginWithInexistingUser() throws InterruptedException {
		Page.navigateTo(ConfigFileReader.getAppURL());
		assertEquals(Messages.APPLICATION_TITLE, Page.getTitle());

		loginFlow.login("InexistingUser"+Util.generateRandomInt(2000), "InexistingUserPassword"+Util.generateRandomInt(2000));
		
		assertEquals(Messages.LOGIN_ERROR, Page.getAlertText());
	}

	@AfterClass
	public static void CloseTest() {
		Page.close();
	}

}
