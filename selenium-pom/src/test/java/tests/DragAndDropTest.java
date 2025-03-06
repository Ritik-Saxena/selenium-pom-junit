package tests;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

import base.BaseTest;
import pages.DragAndDropPage;
import utils.ElementUtils;

public class DragAndDropTest extends BaseTest {
	DragAndDropPage dragAndDropPage;
	ElementUtils elementUtils;
	By dragAndDropLink = By.xpath("//a[text()=\"Drag and Drop\"]");
	
	@Before
	public void setup() {
		super.setup();
		elementUtils = new ElementUtils(driver);
		dragAndDropPage = new DragAndDropPage(driver);
		elementUtils.clickElement(dragAndDropLink);
	}
	
	@Test
	public void testDragAndDrop() {
		dragAndDropPage.performDragAndDrop();
	}
}
