package page_objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BonifyProfilePage {

	WebDriver driver;

	By loggedInSuccessMessage = By.xpath("//*[@id=\"dashboard\"]/section[1]/div[1]/div/div[1]/div/div/span");

	By profileDropDown = By.xpath("//*[@id=\"main-header\"]/div[1]/div/div[2]/button/div");

	By logoutButton = By.xpath("//*[@id=\"main-body\"]/ul[1]/li[4]/button");

	// Constructor
	public BonifyProfilePage(WebDriver driver) {

		this.driver = driver;

	}

	// Get the Title when user is logged in successfully

	public String getLoggedInSuccessMessage() {

		return driver.findElement(loggedInSuccessMessage).getText();

	}

	// Click on Profile Link

	public void clickProfile() {

		driver.findElement(profileDropDown).click();

	}

	// Click on Abmelden Link

	public void clickLogout() {

		driver.findElement(logoutButton).click();

	}

}
