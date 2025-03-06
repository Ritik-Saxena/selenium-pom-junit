package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utils.ElementUtils;

public class AlertsPage {
	WebDriver driver;
	ElementUtils elementUtils;
	By simpleAlert = By.xpath("//button[text()=\"Click for JS Alert\"]");
	By confirmationAlert = By.xpath("//button[text()=\"Click for JS Confirm\"]");
	By promptAlert = By.xpath("//button[text()=\"Click for JS Prompt\"]");
	By alertResult = By.id("result");
	
	public AlertsPage(WebDriver driver) {
		this.driver = driver;
		elementUtils = new ElementUtils(this.driver);
	}
	
	
	public void clickSimpleAlert() {
		elementUtils.clickElement(simpleAlert);
	}
	
	public void clickConfirmationAlert() {
		elementUtils.clickElement(confirmationAlert);
	}
	
	public void clickPromptAlert() {
		elementUtils.clickElement(promptAlert);
	}
	
	public void acceptAlert() {
		driver.switchTo().alert().accept();
	}
	
	public void dismissAlert() {
		driver.switchTo().alert().dismiss();
	}

	public void enterTextInPromptAlert(String alertText) {		
		driver.switchTo().alert().sendKeys(alertText);
	}
	
	
	public String getAlertResult() {
		return elementUtils.getText(alertResult);
	}
}
