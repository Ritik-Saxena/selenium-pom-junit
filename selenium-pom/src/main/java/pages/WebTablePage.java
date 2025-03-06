package pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utils.ElementUtils;

public class WebTablePage {
	private WebDriver driver;
	ElementUtils elementUtils;
	
	// locators
	By webtable = By.id("table2");
	By allTableHeaders = By.xpath("//table[@id='table2']//th/span");
	By rowTag = By.tagName("tr");
	By lastNameHeader = By.xpath("//table[@id='table2']//th[@class='header']/span[@class='last-name']");
	By firstNameHeader = By.xpath("//table[@id='table2']//th[@class='header']/span[@class='first-name']");
	By emailHeader = By.xpath("//table[@id='table2']//th[@class='header']/span[@class='email']");
	By duesHeader = By.xpath("//table[@id='table2']//th[@class='header']/span[@class='dues']");
	By websiteHeader = By.xpath("//table[@id='table2']//th[@class='header']/span[@class='web-site']");
	By actionHeader = By.xpath("//table[@id='table2']//th[@class='header']/span[@class='action']");
	By lastNameData = By.xpath("//table[@id='table2']//td[@class='last-name']");
	By firstNameData = By.xpath("//table[@id='table2']//td[@class='first-name']");
	By emailData = By.xpath("//table[@id='table2']//td[@class='email']");
	By duesData = By.xpath("//table[@id='table2']//td[@class='dues']");
	By websiteData = By.xpath("//table[@id='table2']//td[@class='web-site']");
	By actionData = By.xpath("//table[@id='table2']//td[@class='action']");
	
	
	public WebTablePage(WebDriver driver) {
		this.driver = driver;
		elementUtils = new ElementUtils(this.driver);
	}
	
	public List<String> getColumnHeaders() {
		List<String> headerText = new ArrayList<String>();
		List<WebElement> tableHeaders = elementUtils.getAllWebElements(allTableHeaders);
		
		for (WebElement header: tableHeaders) {
			headerText.add(header.getText());
		}
		
		return headerText;
	}
	
	public List<WebElement> getAllRows() {
		List<WebElement> tableRowsList = new ArrayList<WebElement>();
		WebElement table = elementUtils.getWebElement(webtable);
		List<WebElement> tableRows = table.findElements(rowTag);
		
		for (WebElement row : tableRows) {
			tableRowsList.add(row);
		}
		
		return tableRowsList;
	}
}
