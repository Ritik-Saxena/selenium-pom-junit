package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserUtils {
	public static WebDriver driver;
	
	public static WebDriver getDriver() {
		String browser = ConfigReader.getProperty("browser");
		
		if (driver==null) {
			switch (browser.toLowerCase()) {
			case "chrome":
				driver = new ChromeDriver();			
				break;
			case "firefox":
				driver = new FirefoxDriver();
				break;
			case "edge":
				driver = new EdgeDriver();
				break;
			default:
				driver = new ChromeDriver();								
				break;
			}
		}
		return driver;
	}
	
	public static void closeDriver() {
		if (driver!=null) {
			driver.quit();
			driver=null;
		}
	}
}
