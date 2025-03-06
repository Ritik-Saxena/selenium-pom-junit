package utils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenshotUtils {
	// getting absolute path of file from relative path
	private static String relativeExcelFilePath = ConfigReader.getProperty("screenshot_path");
	private static String filePath = Paths.get(relativeExcelFilePath).toAbsolutePath().toString();
	
	public static void takeScreenshot(WebDriver driver, String filename) {		
		File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(file, new File(filePath, filename + ".png"));
			LogUtils.logInfo("Screenshot taken successfully!");
			
		} catch (IOException e) {
			LogUtils.logError("Failed to take screenshot!");
			throw new RuntimeException("Failed to save screenshot: " + e);
		}
	}
}
