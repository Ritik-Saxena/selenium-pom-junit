package tests;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import base.BaseTest;
import pages.WebTablePage;
import utils.ElementUtils;

public class WebTableTest extends BaseTest {
	WebTablePage webTablePage;
	ElementUtils elementUtils;
	By webTableLink = By.xpath("//a[text()=\"Sortable Data Tables\"]");
	
	@Before
	public void setup() {
		super.setup();
		webTablePage = new WebTablePage(driver);
		elementUtils = new ElementUtils(driver);
	}
	
	@Test
	public void testValidColumnHeaders() {
		elementUtils.clickElement(webTableLink);
		
		List<String> columnHeadersList = webTablePage.getColumnHeaders();
		
		List<String> expectedHeader = List.of("Last Name", "First Name", "Email", "Due", "Web Site", "Action");
		
		Assert.assertEquals(expectedHeader, columnHeadersList);
	}
	
	@Test
	public void testPrintWebTableData() {
		elementUtils.clickElement(webTableLink);
		
		List<WebElement> tableRows = webTablePage.getAllRows();
		for (WebElement row : tableRows) {
			System.out.println(row.getText());
		}
	}
}
