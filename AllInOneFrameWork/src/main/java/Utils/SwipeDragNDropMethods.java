package Utils;

import java.time.Duration;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.interactions.touch.TouchActions;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

public class SwipeDragNDropMethods {
	/**
	 * This class contains Swipe and DragNDrop Elements to Particular Position
	 * Elements.
	 */
	static TouchAction touchAction;

	/**
	 * This is to swipe the Screen based on Swipe Action
	 * 
	 * @Parameter driver
	 * @Parameter - String swipe Action Ex: UP, Down, Left, and Right
	 */
	public static boolean Swipe(AppiumDriver driver, String swipeAction) {
		int startX = 0;
		int endX = 0;
		int startY = 0;
		int endY = 0;
		boolean status = false;
		try {
			Dimension size = driver.manage().window().getSize();

			switch (swipeAction.toUpperCase()) {
			case "RIGHT":
				startY = (int) (size.height / 2);
				startX = (int) (size.width * 0.90);
				endX = (int) (size.width * 0.05);
				swipeUsingCoordinates(driver, startX, startY, endX, startY);
				break;

			case "LEFT":
				startY = (int) (size.height / 2);
				startX = (int) (size.width * 0.05);
				endX = (int) (size.width * 0.90);

				swipeUsingCoordinates(driver, startX, startY, endX, startY);
				break;

			case "UP":
				endY = (int) (size.height * 0.70);
				startY = (int) (size.height * 0.30);
				startX = (size.width / 2);

				swipeUsingCoordinates(driver, startX, startY, endX, endY);
				break;

			case "DOWN":
				startY = (int) (size.height * 0.70);
				endY = (int) (size.height * 0.30);
				startX = (size.width / 2);

				swipeUsingCoordinates(driver, startX, startY, startX, endY);
				break;

			}
			status = true;
		} catch (Exception e) {
			Log.error("Unable to swipe " + swipeAction + " and the Error message is " + e.getMessage());
			status = false;
		}
		return status;
	}

	/**
	 * This is to hold the element and drag to the particular position
	 * 
	 * @param driver
	 * @param -      MobileElement fromElement
	 * @param -      MobileElement toElement
	 * @param -      int holdSeconds
	 *
	 */
	public static boolean holdAndDrag(AppiumDriver driver, MobileElement fromElement, MobileElement toElement,
			int holdSeconds) {

		boolean status = false;

		try {
			touchAction = new TouchAction(driver);
			Point c1 = fromElement.getCenter();
			Point c2 = toElement.getCenter();
			touchAction.longPress(PointOption.point(c1.x, c1.y))
					.waitAction(WaitOptions.waitOptions(Duration.ofSeconds(holdSeconds)))
					.moveTo(PointOption.point(c2.x, c2.y)).release().perform();
			status = true;

		} catch (Exception e) {
			Log.error("Unable to hold and drag the element to the specified loaction...and The Error message is "
					+ e.getMessage());
			status = false;
		}
		return status;

	}

	/**
	 * This is to swipe using coordinates
	 * 
	 * @param driver
	 * @param -      int x_Start
	 * @param -      int y_Start
	 * @param -      int x_End
	 * @param -      int y_End
	 *
	 */

	public static boolean swipeUsingCoordinates(AppiumDriver driver, int startX, int startY, int endX, int endY) {
		boolean status = false;

		try {
			touchAction = new TouchAction(driver);
			touchAction.press(PointOption.point(startX, startY))
					.waitAction(WaitOptions.waitOptions(Duration.ofSeconds(4))).moveTo(PointOption.point(endX, endY))
					.release().perform();
			status = true;

		} catch (Exception e) {
			Log.error("Unable to hold and drag the element to the specified loaction...and The Error message is "
					+ e.getMessage());
			status = false;
		}
		return status;
	}

}
