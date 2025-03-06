package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import utils.WaitUtils;

public class DropdownPage {
	WebDriver driver;
	private By dropdownElement = By.id("dropdown");
	
	public DropdownPage(WebDriver driver) {
		this.driver = driver;
		
	}
	
	public Select getDropdown() {
		WebElement webElement = WaitUtils.waitForElementToBeVisible(driver, dropdownElement);
		return new Select(webElement);
	}
	
	public void selectDropdownByValue(String value) {
		getDropdown().selectByValue(value);
	}
	
	public void selectDropdownByIndex(int index) {
		getDropdown().selectByIndex(index);
	}
	
	public void selectDropdownByVisibleText(String visibleText) {
		getDropdown().selectByVisibleText(visibleText);
	}
	
	public String getSelectedDropdownOption() {
		return getDropdown().getFirstSelectedOption().getText();
	}

}
