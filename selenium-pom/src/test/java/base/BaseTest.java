package base;

import java.time.Duration;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;

import utils.BrowserUtils;
import utils.ConfigReader;

public class BaseTest {
	protected WebDriver driver;
	
	@Before
	public void setup() {
		driver = BrowserUtils.getDriver();
		driver.get(ConfigReader.getProperty("base_url"));
		
		Long implicit_wait_duration = Long.valueOf(ConfigReader.getProperty("implicit_wait"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(implicit_wait_duration));
		
		driver.manage().window().maximize();
	}
	
	@After
	public void tearDown() {
		BrowserUtils.closeDriver();
	}
}
