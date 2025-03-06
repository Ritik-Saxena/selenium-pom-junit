package tests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

import base.BaseTest;
import pages.MultipleWindowsPage;
import utils.ElementUtils;
import utils.LogUtils;

public class MultipleWindowsTest extends BaseTest {
	ElementUtils elementUtils;
	MultipleWindowsPage multipleWindowPage;
	By multipleWindowsLink = By.xpath("//a[text()=\"Multiple Windows\"]");
	By secondWindowLink = By.xpath("//div[@id=\"content\"]/div/a[text()=\"Click Here\"]");
	By thirdWindowLink = By.xpath("//div[@id=\"page-footer\"]/div/div/a[text()=\"Elemental Selenium\"]");
	
	@Before
	public void setup() {
		super.setup();
		multipleWindowPage = new MultipleWindowsPage(driver);
		elementUtils = new ElementUtils(driver);
	}
	
	public void openAllWindows() {	// method to open the windows
		LogUtils.logInfo("Opening all windows...");
		
		elementUtils.clickElement(multipleWindowsLink);
		LogUtils.logInfo("Clicked on 'Multiple Windows' link.");
		
		elementUtils.clickElement(secondWindowLink);
		LogUtils.logInfo("Clicked on second window link.");
		
		multipleWindowPage.switchToWindowByTitle("The Internet");
		LogUtils.logInfo("Switched to 'The Internet' window.");
		
		elementUtils.clickElement(thirdWindowLink);
		LogUtils.logInfo("Clicked on third window link.");
	}
	
	@Test
	public void testSwitchToWindowByTabNumber() {
		openAllWindows();
		
		multipleWindowPage.switchToWindowByTabNumber(3);
		Assert.assertEquals("Error for Assert Title of Tab 3", "Home | Elemental Selenium", driver.getTitle());
	}
	
	@Test
	public void testSwitchToWindowByTitle() {
		openAllWindows();
		
		multipleWindowPage.switchToWindowByTitle("New Window");
		LogUtils.logInfo("Switched to tab 3. Verifying title...");
		Assert.assertEquals("Error for Assert Title - New Window" , "New Window" , driver.getTitle());
		LogUtils.logInfo("Title verified successfully.");
	}
	
	@Test
	public void testCloseWindowByTitle() {
		LogUtils.logInfo("Starting test: testSwitchToWindowByTitle.");
		openAllWindows();
		
		int windowsCountBefore = multipleWindowPage.getOpenWindowsCount();
		LogUtils.logInfo("Number of open windows before closing: " + windowsCountBefore);
		
		multipleWindowPage.closeWindowByTitle("The Internet");
		LogUtils.logInfo("Closed window with title 'The Internet'.");
		
		int windowsCountAfter = multipleWindowPage.getOpenWindowsCount();
		LogUtils.logInfo("Number of open windows after closing: " + windowsCountAfter);

		Assert.assertTrue("Windows count should be less by 1", windowsCountAfter == windowsCountBefore-1);
		LogUtils.logInfo("Window close validation passed.");
	}
	
	@Test
	public void testCloseAllWindow() {
		LogUtils.logInfo("Starting test: testCloseAllWindow.");
		openAllWindows();
		
		multipleWindowPage.closeAllOpenedWindows();
		LogUtils.logInfo("All windows closed successfully.");
	}
	
}
