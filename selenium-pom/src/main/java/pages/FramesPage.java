package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utils.ElementUtils;

public class FramesPage {
	WebDriver driver;
	ElementUtils elementUtils;
	By frameText = By.tagName("body");
	
	public FramesPage(WebDriver driver) {
		this.driver = driver;
		elementUtils = new ElementUtils(driver);
	}
	
	public void switchUsingFrameName(String frameName) {
		driver.switchTo().frame(frameName);
	}
	
	public void switchUsingFrameIndex(int frameIndex) {		
		driver.switchTo().frame(frameIndex);
	}
	
	public void switchUsingFrameElement(WebElement frameElement) {		
		driver.switchTo().frame(frameElement);
	}
	
	public void switchToParentFrame() {
		driver.switchTo().parentFrame();
	}
	
	public void switchToMainPage() {
		driver.switchTo().defaultContent();
	}
	
	public String getFrameText() {
		return elementUtils.getText(frameText);
	}
	
}
