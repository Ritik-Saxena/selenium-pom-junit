package tests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

import base.BaseTest;
import pages.DropdownPage;
import utils.ElementUtils;
import utils.LogUtils;

public class DropdownTest extends BaseTest {
	DropdownPage dropdownPage;
	ElementUtils elementUtils;
	By dropdownLink = By.xpath("//a[text()=\"Dropdown\"]");
	
	@Before
	public void setup() {
		super.setup();
		dropdownPage = new DropdownPage(driver);
		elementUtils = new ElementUtils(driver);
		elementUtils.clickElement(dropdownLink);
	}
	
	@Test
	public void validateDropdown() {
		// select option by value
		dropdownPage.selectDropdownByValue("1");
		Assert.assertEquals("Option 1", dropdownPage.getSelectedDropdownOption());
		LogUtils.logInfo("Selected dropdown option: " + dropdownPage.getSelectedDropdownOption());
		
		// select option by text
		dropdownPage.selectDropdownByVisibleText("Option 2");
		Assert.assertEquals("Option 2", dropdownPage.getSelectedDropdownOption());
		LogUtils.logInfo("Selected dropdown option: " + dropdownPage.getSelectedDropdownOption());
		
		// select option by index number
		dropdownPage.selectDropdownByIndex(1);
		Assert.assertEquals("Option 1", dropdownPage.getSelectedDropdownOption());
		LogUtils.logInfo("Selected dropdown option: " + dropdownPage.getSelectedDropdownOption());
	}
}

//1. @Before in BaseTest → Initializes WebDriver (driver)
//2. @Before in DropdownTest → Initializes Page Objects (DropdownPage, ElementUtils)
//3. @Test method executes
//4. @After in BaseTest → Closes WebDriver

