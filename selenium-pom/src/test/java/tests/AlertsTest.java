package tests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

import base.BaseTest;
import pages.AlertsPage;
import utils.ElementUtils;

public class AlertsTest extends BaseTest {
	ElementUtils elementUtils;
	AlertsPage alertPage;
	By alertPageLink = By.xpath("//a[text()=\"JavaScript Alerts\"]");
	
	@Before
	public void setup() {
		super.setup();
		elementUtils = new ElementUtils(driver);
		alertPage = new AlertsPage(driver);
		elementUtils.clickElement(alertPageLink);
	}
	
	@Test
	public void testSimpleAlert() {
		alertPage.clickSimpleAlert();
		alertPage.acceptAlert();
		String alertResult = alertPage.getAlertResult();
		
		Assert.assertEquals("You successfully clicked an alert", alertResult);
	}
	
	@Test
	public void testConfirmationAlertAccept() {
		alertPage.clickConfirmationAlert();
		alertPage.acceptAlert();
		
		String alertResult = alertPage.getAlertResult();
		
		Assert.assertEquals("You clicked: Ok", alertResult);
	}

	@Test
	public void testConfirmationAlertDismiss() {
		alertPage.clickConfirmationAlert();
		alertPage.dismissAlert();
		
		String alertResult = alertPage.getAlertResult();
		
		Assert.assertEquals("You clicked: Cancel", alertResult);
	}
	
	@Test
	public void testPromptAlertTextField() {
		String promptText = "Hello World!";
		
		alertPage.clickPromptAlert();
		alertPage.enterTextInPromptAlert(promptText);
		alertPage.acceptAlert();
				
		String alertResult = alertPage.getAlertResult();
		
		Assert.assertEquals("You entered: " + promptText, alertResult);
	}
	
	@Test
	public void testPromptAlertDismiss() {
		alertPage.clickPromptAlert();
		alertPage.dismissAlert();
		
		String alertResult = alertPage.getAlertResult();
		
		Assert.assertEquals("You entered: null", alertResult);
	}
}
