package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import utils.WaitUtils;

public class DragAndDropPage {
	WebDriver driver;
	By sourceLocator = By.id("column-a");
	By destinationLocator = By.id("column-b");
	
	public DragAndDropPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void performDragAndDrop() {
		WebElement sourceElement = WaitUtils.waitForElementToBeVisible(driver, sourceLocator);
		WebElement destinationElement = WaitUtils.waitForElementToBeVisible(driver, destinationLocator);
		
		Actions action = new Actions(driver);
		action.dragAndDrop(sourceElement, destinationElement).perform();
	}
}
