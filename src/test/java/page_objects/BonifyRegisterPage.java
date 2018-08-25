package page_objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BonifyRegisterPage {

	protected WebDriver driver;

	By registerEmail = By.name("email");

	By registerPassword = By.name("password");

	By register = By.cssSelector("button[type=submit]");

	By emailExistErrorMessage = By.xpath("//*[@id=\"step-{{$index}}\"]/div/div/form/div[7]/p");

	// Constructor
	public BonifyRegisterPage(WebDriver driver) {

			this.driver = driver;

		}
	
	//Click Kostenlos Register Button
	
	public void clickRegister() {

		driver.findElement(register).click();

	}
	// Set Username/Email in textbox

	public void setUserName(String strUserName) {

		driver.findElement(registerEmail).sendKeys(strUserName);

	}

	// Set password in password textbox

	public void setPassword(String strPassword) {

		driver.findElement(registerPassword).sendKeys(strPassword);

	}

	// Get the Password Error Message

	public String getEmailExistErrorMessage() {

		return driver.findElement(emailExistErrorMessage).getText();

	}

}
