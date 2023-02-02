package Utils;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

public class ScrollMethods {
	
	/*
	 * This is scroll down the page or screen by moving form Bottom point to centre point screen.
	 * 
	 * Note: Below scrollToDown method works only for Appium Java client 7 version not latest Version 8,
	 * since io.appium.java_client.PerformsTouchActions; io.appium.java_client.TouchAction; are deprecated in Appium 8
	 */

	public static void scrollToDown(AppiumDriver driver) {
		try {
			Dimension dimension = driver.manage().window().getSize();
			int scrollStart = (int) (dimension.getHeight() * 0.5);
			int scrollEnd = (int) (dimension.getHeight() * 0.2);
			
			new TouchAction((PerformsTouchActions) driver).press(PointOption.point(250, scrollStart))
			.waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1))).moveTo(PointOption.point(250, scrollEnd))
			.release().perform();
			
		}catch(Exception e) {
			e.getMessage();
			e.printStackTrace();
		}
	}
	

	/*
	 * This is scroll down till the Text is present in the List 
	 * Note: this method works only for List Element text
	 * 
	 * @Parameter By element - here we have to pass the element ID or locator which is identified for all the Element text
	 * @Parameter AppiumDriver driver
	 * @Parameter String text
	 * @Parameter String platform
	 * 
	 * @return boolean
	 */
	public static boolean scrollToText(AppiumDriver driver, By element, String text, String platform) {
		boolean flag = false;
		try {
			while(true) {
				List<WebElement> listele = driver.findElements(element);
				for(WebElement ele : listele) {
					if(platform.toLowerCase().contains("android")) {
						if(ele.getAttribute("text").equals(text)){
							flag = true;
							break;
						}
					}else {
						if(ele.getAttribute("name").equals(text)){
							flag = true;
							break;
						}
					}
					
				}
				if(flag)
					break;
				else
					scrollToDown(driver);
			}
		}catch(Exception e){
			e.getMessage();
			e.printStackTrace();
		}
		return flag;
	}
	
	/*
	 * This is scroll down till the specified element is present in the screen 
	 * 
	 * @Parameter element - here we have to pass the element ID/xpath/other locator strategies  which is identified the Element text
	 * @Parameter AppiumDriver driver
	 * @Parameter MobileElement
	 * @Parameter int retryCount
	 * 
	 * @return boolean
	 */
	public static boolean scrollToElement(AppiumDriver driver, MobileElement element, int retryCount) {
		boolean flag = false;
		try {
			while(retryCount>0) {
				element.isDisplayed();
				flag = true;
			}
		}catch(org.openqa.selenium.NoSuchElementException e) {
			scrollToDown(driver);
			retryCount--;
		}
		return flag;
	}
	
	/*
	 * This is scroll down till the specified text is present in the screen 
	 * Note: This is for only Android Applications
	 * 
	 * @Parameter text - here we have to pass the element text
	 * 
	 * @return boolean
	 */
	
	public static boolean scrollToText(AppiumDriver driver, String text) {
		boolean flag = true;
		try {
			String strCriteria = "new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView("
					+ "new UiSelector().textContains(\"" + text + "\")" + ");";
			By byCriteria = MobileBy.AndroidUIAutomator(strCriteria);
			
			List listElement = ((AndroidDriver) driver).findElementsByAndroidUIAutomator(strCriteria);
			
			if (listElement.size() != 0)
				flag = true;
			else
				flag = false;
			
		}catch(Exception e) {
			e.getMessage();
			e.printStackTrace();
		}
		return flag;
	}
	
	
	
}
