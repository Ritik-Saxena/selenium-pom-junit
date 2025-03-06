package tests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;



@RunWith(Suite.class)
@Suite.SuiteClasses({
	LoginTest.class,
	WebTableTest.class,
	AlertsTest.class,
	DragAndDropTest.class,
	DropdownTest.class,
	FramesTest.class,
	MultipleWindowsTest.class
})

public class RegressionTestSuite {}
