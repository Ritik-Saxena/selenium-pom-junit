package tests;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

import pages.LoginPage;
import utils.ConfigReader;
import utils.ElementUtils;
import utils.ExcelUtils;
import utils.LogUtils;
import utils.ScreenshotUtils;
import base.BaseTest;

public class LoginTest extends BaseTest {
	ElementUtils elementUtils;
	LoginPage loginPage;
	By loginPageLink = By.xpath("//a[text()=\"Form Authentication\"]");
	
	@Before
	public void setup() {
		super.setup();
		loginPage = new LoginPage(driver);
		elementUtils = new ElementUtils(driver);
	}
	
	@Test
	public void testValidLogin() {
		elementUtils.clickElement(loginPageLink);
		
		loginPage.enterUsername(ConfigReader.getProperty("username"));
		loginPage.enterPassword(ConfigReader.getProperty("password"));
		loginPage.clickSubmit();
		
		String statusMessage = loginPage.getLoginStatusMessage();
		if (statusMessage.contains("secure area")) {
			LogUtils.logInfo("Login successful: " + statusMessage);
		} else {
			LogUtils.logError("Failed to login: " + statusMessage);
		}
	}
	
	@Test
	public void testInvalidLogin() {
		elementUtils.clickElement(loginPageLink);
		
		loginPage.enterUsername("random");
		loginPage.enterPassword("random");
		loginPage.clickSubmit();
		
		String statusMessage = loginPage.getLoginStatusMessage();
		if (statusMessage.contains("username is invalid")) {
			LogUtils.logInfo("Login failed as expected: " + statusMessage);
		} else {
			LogUtils.logError("Unexpected login behaviour: " + statusMessage);
		}
	}
	
	@Test
	public void testValidLoginAndTakeScreenshot() {
		elementUtils.clickElement(loginPageLink);
		
		loginPage.enterUsername(ConfigReader.getProperty("username"));
		loginPage.enterPassword(ConfigReader.getProperty("password"));
		loginPage.clickSubmit();
		
		LogUtils.logInfo(loginPage.getLoginStatusMessage());
		
		String statusMessage = loginPage.getLoginStatusMessage();
		if (statusMessage.contains("secure area")) {
			LogUtils.logInfo("Login successful: " + statusMessage);
			ScreenshotUtils.takeScreenshot(driver, "loginSuccess");
		} else {
			LogUtils.logError("Failed to login: " + statusMessage);
		}
	}
	
	@Test
	public void testLoginWithExcelData() {
		LogUtils.logInfo("Starting login test with Excel data...");
		
		elementUtils.clickElement(loginPageLink);
		
		String sheetName = "Sheet1";
		ExcelUtils excelUtil = new ExcelUtils(sheetName);
		int rowCount = excelUtil.getTotalRowCount()-1;	// Total rows - 1 => because we don't want Header

		excelUtil.setCellData(0, 2, "Status");
	
		for (int rowNum=1; rowNum<=rowCount; rowNum++) {
			String username = excelUtil.getCellData(rowNum, 0);
			String password = excelUtil.getCellData(rowNum, 1);
			
			LogUtils.logInfo("Attempting login for user: " + username);
			loginPage.enterUsername(username);		// performing login
			loginPage.enterPassword(password);
			loginPage.clickSubmit();
			
			String alertMessage =  loginPage.getLoginStatusMessage();		// fetching error message
			
			String loginStatus = "Access Denied";	
			if (alertMessage.equals("You logged into a secure area!")) {
				loginStatus="Access Granted";
				LogUtils.logInfo("Login Successful!");
			} else {
				LogUtils.logError("Failed to login!");
			}
			
			excelUtil.setCellData(rowNum, 2, loginStatus);	// setting the login status to new created cell
		}
		
		excelUtil.saveAndClose();	// closing the workbook
		LogUtils.logInfo("Excel test completed. Data saved.");
	}
	
}
