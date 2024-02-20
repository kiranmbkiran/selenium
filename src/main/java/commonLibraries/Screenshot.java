package commonLibraries;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Screenshot {
	
	public static String getSceenshotPath(String TestCaseName, WebDriver driver)
			throws IOException, InterruptedException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String destPath = System.getProperty("user.dir")+ "/ScreenShots/" +TestCaseName+".png";
		 Files.deleteIfExists(Paths.get(destPath));
//		File existingFile = new File(destPath);
//		if (existingFile.delete()) {
//			System.out.println("Existing Screenshot deleted successfully");
//		} else {
//			System.out.println("Failed to delete the Existing Screenshot");
//		}
		Thread.sleep(3000);
		File file = new File(destPath);
		FileUtils.copyFile(source, file);
		Thread.sleep(3000);
		return destPath;
	}
}


