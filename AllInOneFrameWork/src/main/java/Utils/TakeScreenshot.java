package Utils;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

public class TakeScreenshot {

	static String screenShotLink = "";
	public static String getScreenshotPath(String name) {
		return  System.getProperty("user.dir")+"/test-output/ScreenShots/"+ name+".png";
	}
	
	/*
	 * To take the Screenshot and Store it to specified folder
	 * 
	 */

	public static String takeScreenShot(String testName, WebDriver driver) {
		File destinationScreenshotFile = null;
		try {
			File sourceScreenShotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

			destinationScreenshotFile = new File(getScreenshotPath(testName));
			FileUtils.copyFile(sourceScreenShotFile, destinationScreenshotFile);
		} catch (IOException e) {
			e.printStackTrace();
			Log.error("The error message is " + e.getMessage());
		}

		return destinationScreenshotFile.getAbsolutePath();

	}

	/*
	 * Capture the full page screenshot, which is more than the currently visible
	 * part on the screen. In the below code, 1000 is scrolled out time in
	 * milliseconds. In other words, it means that the program will scroll for each
	 * 1000 msec to take a screenshot.
	 * 
	 * if full screenshot is not visible, use below piece of code
	 * ShootingStrategies.scaling(2f) inside the viewportPasting method
	 */

	public static String takeFullScreenShot(String testName, WebDriver driver) {
		File destinationScreenshotFile = null;
		try {
			
			Screenshot screen = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(ShootingStrategies.scaling(2f), 1000))
					.takeScreenshot(driver);

			destinationScreenshotFile = new File(getScreenshotPath(testName));

			ImageIO.write(screen.getImage(), "PNG", destinationScreenshotFile);
		} catch (IOException e) {
			e.printStackTrace();
			Log.error("The error message is " + e.getMessage());
		}

		return destinationScreenshotFile.getAbsolutePath();
	}

	/*
	 * Capture the Particular element screen/Image using webElement
	 * 
	 */

	public static void takeElementScreenShot(WebDriver driver, String elementName, WebElement element) {
		File destinationScreenshotFile = null;
		try {

			// Get the screenshot of the visible part of page
			File file = element.getScreenshotAs(OutputType.FILE);

			destinationScreenshotFile = new File(getScreenshotPath(elementName));

			FileUtils.copyFile(file, destinationScreenshotFile);
		} catch (Exception e) {
			e.printStackTrace();
			Log.error("The error message is " + e.getMessage());
		}
	}
	
	public static String setHyperLink(String hyperLinkName, String filePath) {
		
		screenShotLink = "";
//		screenShotLink = "<a href=\"." + File.separator + "ScreenShot" + File.separator + hyperLinkName + File.separator + filePath
//				+ "\" target=\"_blank\" >[" + filePath + "]</a>";
		
		String abc = "ScreenShots/verifyLoginScreen.png";
		System.out.println("The Image file pathe is " +filePath);
		
		screenShotLink = "<a href=\"." + File.separator + abc
				+ "\" target=\"_blank\" >[" + abc + "]</a>";
		
		
		
		System.out.println("The Screen shot is "+screenShotLink);
		return screenShotLink;
		
	}
	
}
