package page_objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BonifyLoginPage {

	WebDriver driver;

	By loginEmail = By.name("email");

	By loginPassword = By.name("password");

	By login = By.cssSelector("button[type=submit]");

	By register = By.cssSelector("button[type=button]");

	By passwordRecoveryPageTitle = By.tagName("h1");

	By loginPageTitle = By.tagName("h1");

	By registrationPageTitle = By.tagName("h1");

	By passwordLink = By.xpath("//a[@href='/recover']");

	By emaliErrorMessage = By.xpath("//*[@id=\"content\"]/div/div[2]/div/div[2]/div/form/div[1]/div[2]/span");

	By passwordErrorMessage = By.xpath("//*[@id=\"content\"]/div/div[2]/div/div[2]/div/form/div[2]/div[2]/span");

	By generalErrorMessage = By.className("general-error");

	By impressumLink = By.xpath("//a[@href='http://bonify.de/impressum']");

	By agbLink = By.xpath("//a[@href='http://bonify.de/agb']");

	By datenschutzLink = By.xpath("//a[@href='http://bonify.de/datenschutz']");

	// Constructor
	public BonifyLoginPage(WebDriver driver) {

		this.driver = driver;

	}

	// Set Username/Email in textbox

	public void setUserName(String strUserName) {

		driver.findElement(loginEmail).sendKeys(strUserName);

	}

	// Set password in password textbox

	public void setPassword(String strPassword) {

		driver.findElement(loginPassword).sendKeys(strPassword);

	}

	// Click on login button

	public void clickLogin() {

		driver.findElement(login).click();

	}

	public void clickRegister() {

		driver.findElement(register).click();

	}

	// Click on Forgot Password Link

	public void clickForgotPassword() {

		driver.findElement(passwordLink).click();

	}

	// Click on Impressum Link

	public void clickImpressum() {

		driver.findElement(impressumLink).click();

	}

	// Click on AGB Link

	public void clickAgb() {

		driver.findElement(agbLink).click();

	}

	// Click on Datenschutz Link

	public void clickDatenschutz() {

		driver.findElement(datenschutzLink).click();

	}

	// Get the title of Password Recovery Page

	public String getPasswordRecoveryPageTitle() {

		return driver.findElement(passwordRecoveryPageTitle).getText();

	}

	// Get the title of Login Page

	public String getLoginPageTitle() {

		return driver.findElement(registrationPageTitle).getText();

	}

	// Get the title of Registration Page

	public String getRegistrationPageTitle() {

		return driver.findElement(registrationPageTitle).getText();

	}

	// Get the Email Error Message

	public String getEmailErrorMessage() {

		return driver.findElement(emaliErrorMessage).getText();

	}

	// Get the Password Error Message

	public String getPasswordErrorMessage() {

		return driver.findElement(passwordErrorMessage).getText();

	}

	// Get the General Error Message

	public String getGeneralErrorMessage() {

		return driver.findElement(generalErrorMessage).getText();

	}

	// Function to perform Login

	public void loginToBonify(String strUserName, String strPassword) {

		// Fill user name

		this.setUserName(strUserName);

		// Fill password

		this.setPassword(strPassword);

		// Click Login button

		this.clickLogin();

	}

}
