package tests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

import base.BaseTest;
import pages.FramesPage;
import utils.ElementUtils;

public class FramesTest extends BaseTest {
	ElementUtils elementUtils;
	FramesPage framesPage;
	By framesPageLink = By.xpath("//a[text()=\"Nested Frames\"]");
	
	@Before
	public void setup() {
		super.setup();
		elementUtils = new ElementUtils(driver);
		framesPage = new FramesPage(driver);
	}
	
	@Test
	public void testNestedFrameTop() {
		elementUtils.clickElement(framesPageLink);
		
		framesPage.switchUsingFrameName("frame-top");
		framesPage.switchUsingFrameName("frame-left");
		Assert.assertEquals("LEFT", framesPage.getFrameText());
		
		framesPage.switchToParentFrame();
		framesPage.switchUsingFrameName("frame-middle");
		Assert.assertEquals("MIDDLE", framesPage.getFrameText());
		
		framesPage.switchToParentFrame();
		framesPage.switchUsingFrameName("frame-right");
		Assert.assertEquals("RIGHT", framesPage.getFrameText());
		
		framesPage.switchToMainPage();
	}
	
	@Test
	public void testNestedFrameBottom() {
		elementUtils.clickElement(framesPageLink);
		
		framesPage.switchUsingFrameName("frame-bottom");
		Assert.assertEquals("BOTTOM", framesPage.getFrameText());
		
		framesPage.switchToMainPage();
	}
	
}
