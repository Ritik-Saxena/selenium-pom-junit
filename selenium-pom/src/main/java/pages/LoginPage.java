package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utils.ElementUtils;
import utils.WaitUtils;

public class LoginPage {
	private WebDriver driver;
	ElementUtils elementUtils;
	
	// locators
	private By usernameField = By.id("username");
	private By passwordField = By.id("password");
	private By submitButton = By.xpath("//button[@type=\"submit\"]");
	private By errorMessage = By.id("flash");
	
	// constructor
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		elementUtils = new ElementUtils(driver);
	}
	
	// Methods
	public void enterUsername(String username) {
		elementUtils.enterText(usernameField, username);
	}
	
	public void enterPassword(String password) {
		elementUtils.enterText(passwordField, password);
	}
	
	public void clickSubmit() {
		elementUtils.clickElement(submitButton);
	}
	
	public String getLoginStatusMessage() {
		WaitUtils.waitForElementToBeVisible(driver, errorMessage);
		
		String statusText = elementUtils.getText(errorMessage);
		statusText = statusText.split("\n")[0].trim();
		return statusText;
	}
}
