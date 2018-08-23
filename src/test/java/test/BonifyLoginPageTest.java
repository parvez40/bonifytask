package test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import page_objects.BonifyLoginPage;
import page_objects.BonifyProfilePage;

public class BonifyLoginPageTest {

	WebDriver driver;
	BonifyLoginPage objLogin;
	BonifyProfilePage objProfile;

	String testUrl = "http://my.bonify.de";
	String projectLocation = System.getProperty("user.dir");
	String gecko_driver = "webdriver.gecko.driver";
	String gekco_driver_path = projectLocation + "/lib/geckodriver/geckodriver.exe";

	@BeforeTest

	public void setup() {

		System.setProperty(gecko_driver, gekco_driver_path);

		driver = new FirefoxDriver();

		// driver = new FirefoxDriver();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.get(testUrl);

	}

	@Test(priority = 1)
	public void blankLoginTest() throws Exception {

		// Create Login Page object

		objLogin = new BonifyLoginPage(driver);

		// login to application

		objLogin.loginToBonify("", "");

		// Implicit Wait for messages to be appeared

		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

		// Verify Error Messages

		String emailErrorMessage = objLogin.getEmailErrorMessage();

		Assert.assertTrue(emailErrorMessage.contains("Trage bitte Deine Email-Adresse ein"));

		String passwordErrorMessage = objLogin.getPasswordErrorMessage();

		Assert.assertTrue(passwordErrorMessage.contains("Trage bitte Dein Passwort ein"));

	}

	@Test(priority = 2)
	public void blankEmailLoginTest() throws Exception {

		// Refresh the page

		driver.navigate().refresh();

		// Create Login Page object

		objLogin = new BonifyLoginPage(driver);

		// login to application with blank username and password

		objLogin.loginToBonify("", "test123#");

		// Implicit Wait for messages to be appeared

		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

		// Verify Error Messages

		String emailErrorMessage = objLogin.getEmailErrorMessage();

		Assert.assertTrue(emailErrorMessage.contains("Trage bitte Deine Email-Adresse ein"));

	}

	@Test(priority = 3)
	public void blankPasswordLoginTest() throws Exception {

		// Refresh the page

		driver.navigate().refresh();

		// Create Login Page object

		objLogin = new BonifyLoginPage(driver);

		// login to application

		objLogin.loginToBonify("testuser@yopmail.com", "");

		// Implicit Wait for messages to be appeared

		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

		// Verify Error Messages

		String passwordErrorMessage = objLogin.getPasswordErrorMessage();

		Assert.assertTrue(passwordErrorMessage.contains("Trage bitte Dein Passwort ein"));

	}

	@Test(priority = 4)
	public void InvalidLoginTest() throws Exception {

		// Refresh the page

		driver.navigate().refresh();

		// Create Login Page object

		objLogin = new BonifyLoginPage(driver);

		// login to application

		objLogin.loginToBonify("test@yopmail.com", "tets234#");

		// Implicit Wait for message to be appeared

		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

		// Verify Error Messages

		String generalErrorMessage = objLogin.getGeneralErrorMessage();

		Assert.assertTrue(generalErrorMessage.contains("Leider passen Benutzername und Passwort nicht zusammen."));

	}

	@Test(priority = 5)
	public void ForgotPasswordLinkTest() throws Exception {

		// Create Login Page object

		objLogin = new BonifyLoginPage(driver);

		// Click Forgot Password Link

		objLogin.clickForgotPassword();

		// Verify Password Recovery Page Title

		String ForgotPasswordPageTitle = objLogin.getPasswordRecoveryPageTitle();

		Assert.assertTrue(ForgotPasswordPageTitle.contains("Email senden"));

	}

	@Test(priority = 6)
	public void RegisterLinkTest() throws Exception {

		driver.get(testUrl);

		// Create Login Page object

		objLogin = new BonifyLoginPage(driver);

		// Click Register Link

		objLogin.clickRegister();

		// Verify Register Page Title

		String registrationPageTitle = objLogin.getRegistrationPageTitle();

		Assert.assertTrue(registrationPageTitle.contains("Willkommen bei bonify!"));

	}

	@Test(priority = 7)
	public void ValidLoginTest() throws Exception {

		// Navigate to the Login Page

		driver.get(testUrl);

		// Create Login Page object

		objLogin = new BonifyLoginPage(driver);

		objProfile = new BonifyProfilePage(driver);

		// login to application

		objLogin.loginToBonify("testuser@yopmail.com", "test123#");

		// Verify Logged In Success

		String loggedInSuccessMessage = objProfile.getLoggedInSuccessMessage();

		Assert.assertTrue(loggedInSuccessMessage.contains("Hey Parvez, schön Dich zu sehen!"));

	}
	
	@Test(priority = 8)
	public void LogoutTest() throws Exception {

		// Create Login Page object

		objProfile = new BonifyProfilePage(driver);

		// Click on profile drop down

		objProfile.clickProfile();

		// Click on logout button
		//Thread.sleep(2000);

		objProfile.clickLogout();

		// Verify Logged Out Success

		String loggedOutSuccessMessage = objLogin.getLoginPageTitle();

		Assert.assertTrue(loggedOutSuccessMessage.contains("Willkommen bei bonify!"));

	}

	@Test(priority = 9)
	public void ImpressumLinkTest() throws Exception {

		// Create Login Page object

		objLogin = new BonifyLoginPage(driver);

		// Click Forgot Password Link

		objLogin.clickImpressum();
		//Thread.sleep(2000);

	}

	@Test(priority = 10)
	public void AgbLinkTest() throws Exception {

		// Create Login Page object

		objLogin = new BonifyLoginPage(driver);

		// Click Forgot Password Link

		objLogin.clickAgb();
		//Thread.sleep(2000);

	}

	@Test(priority = 11)
	public void DatenschutzLinkTest() throws Exception {

		// Create Login Page object

		objLogin = new BonifyLoginPage(driver);

		// Click Forgot Password Link

		objLogin.clickDatenschutz();
		//Thread.sleep(2000);

		driver.quit();

	}
}