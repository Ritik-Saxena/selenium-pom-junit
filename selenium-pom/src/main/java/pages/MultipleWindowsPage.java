package pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;

public class MultipleWindowsPage {
	private WebDriver driver;
	
	public MultipleWindowsPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public String getCurrentWindowHandle() {
		return driver.getWindowHandle();
	}
	
	public int getOpenWindowsCount() {
		return driver.getWindowHandles().size();
	}
	
	public void switchToWindowByTabNumber(int tabNumber) {	// Tab number is not index number here
		List<String> windowHandles = new ArrayList<String>(driver.getWindowHandles());
		
		if (tabNumber<1 && tabNumber>windowHandles.size()) {
			throw new IllegalArgumentException("Invalid tab number: " + tabNumber);
		}
		driver.switchTo().window(windowHandles.get(tabNumber-1));
	}
	
	public void switchToWindowByTitle(String windowTitle) {
		List<String> windowHandles = new ArrayList<String>(driver.getWindowHandles());
		
		for (String window : windowHandles) {
			driver.switchTo().window(window);
			if (driver.getTitle().equalsIgnoreCase(windowTitle)) {
				break;
			}
		}
	}
	
	public void closeWindowByTitle(String windowTitle) {
		List<String> windowHandles = new ArrayList<String>(driver.getWindowHandles());
		
		for (String window : windowHandles) {
			driver.switchTo().window(window);
			if (driver.getTitle().equalsIgnoreCase(windowTitle)) {
				driver.close();
			}
		}
		
		// switching to the 0th Index window after closing specific window
		windowHandles = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(windowHandles.get(0));
	}
	
	public void closeAllOpenedWindows() {
		List<String> windowHandles = new ArrayList<String>(driver.getWindowHandles());
		
		for (String window : windowHandles) {
			driver.switchTo().window(window);
			driver.close();
		}
		
	}
}
