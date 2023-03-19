package Utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;

/**
 * This class contains All Elements related methods
 * Example: present, enable, selected, disable, click, sendKeys, tap, navigate, etc...
 *
 */
public class ActionsMethodsOnElements {
	
	/**
	 * 
	 * @param arr
	 * @return By
	 */
	public static By getLocator(String[] arr) {
		switch(arr[0]) {
		case "xpath":
			return By.xpath(arr[1]);
		case "classname":
			return By.className(arr[1]);
		case "name":
			return By.name(arr[1]);
		case "linkText":
			return By.linkText(arr[1]);
		case "partialLinkText":
			return By.partialLinkText(arr[1]);
		case "UIAutomatorSelector":
			return MobileBy.AndroidUIAutomator(arr[1]);
		case "id":
			return By.id(arr[1]);
		case "accessbilityID":
			return MobileBy.AccessibilityId(arr[1]);
		default:
			Log.message("Please Specify the correct locator value...");
			return null;
		}
		
	}
	
	/**
	 * 
	 * @param driver
	 * @param arr
	 * @return WebElement
	 */
	public static WebElement fetchElement(AppiumDriver driver, String[] arr) {
        switch (arr[0]) {
            case "xpath":
                return driver.findElement(By.xpath(arr[1]));
            case "className":
                return driver.findElement(By.className(arr[1]));
            case "name":
                return driver.findElement(By.name(arr[1]));
            case "linkText":
                return driver.findElement(By.linkText(arr[1]));
            case "partialLinkText":
                return driver.findElement(By.partialLinkText(arr[1]));
            case "UIAutomatorSelector":
                return driver.findElement(MobileBy.AndroidUIAutomator(arr[1]));
            case "id":
                return driver.findElement(By.id(arr[1]));
            case "accessbilityID":
    			return driver.findElement(MobileBy.AccessibilityId(arr[1]));
 
            default:
            	Log.message("Please Specify the correct locator value...");
                return null;
        }
    }
	
	
	/**
	 * To click on the Element
	 * 
	 * @param MobileElement - element
	 * 
	 * @return boolean
	 */
	
	
	public static boolean click(MobileElement element) {
		boolean status = false;
		try {
			if(isPresent(element)) {
				element.click();
				status = true;
			}else {
				status = false;
			}
		}catch(Exception e) {
			Log.message("Unable to click on the element and the error message is "+ e.getMessage());
		}
		return status;
	}
	
	/**
	 * To click on the Element
	 * 
	 * @param AppiumDriver - driver
	 * @param By element
	 * 
	 * @return boolean
	 */
	
	
	public static boolean click(AppiumDriver driver, By element) {
		boolean status = false;
		try {
			if(isPresent(driver, element)) {
				driver.findElement(element).click();
				status = true;
			}else {
				status = false;
			}
		}catch(Exception e) {
			Log.message("Unable to click on the element and the error message is "+ e.getMessage());
		}
		return status;
	}
	
	/**
	 * To check the Element presence 
	 * 
	 * @param MobileElement - element
	 * 
	 * @return boolean
	 */
	
	
	public static boolean isPresent(MobileElement element) {
		boolean status = false;
		try {
			if(element.isDisplayed())
				status = true;
			else
				status = false;
			
		}catch(Exception e) {
			Log.message("Unable to validate presence of the element "+element+" and the error message is "+ e.getMessage());
		}
		return status;
	}
	
	/**
	 * To check the Element presence 
	 * 
	 * @param AppiumDriver - driver
	 * @param MobileElement - element
	 * 
	 * @return boolean
	 */
	
	
	public static boolean isPresent(AppiumDriver driver, By element) {
		boolean status = false;
		try {
			if(driver.findElement(element).isDisplayed())
				status = true;
			else
				status = false;
			
		}catch(Exception e) {
			Log.message("Unable to validate presence of the element "+element+" and the error message is "+ e.getMessage());
		}
		return status;
	}
	
	/**
	 * To check the Element state 
	 * 
	 * @param AppiumDriver - driver
	 * @param MobileElement - element
	 * 
	 * @return boolean
	 */
	
	
	public static boolean isEnable(MobileElement element) {
		boolean status = false;
		try {
			if(element.isDisplayed() && element.isEnabled())
				status = true;
			else
				status = false;
			
		}catch(Exception e) {
			Log.message("Unable to validate state of the element "+element+" and the error message is "+ e.getMessage());
		}
		return status;
	}
	
	/**
	 * To check the Element state 
	 * 
	 * @param AppiumDriver - driver
	 * @param MobileElement - element
	 * 
	 * @return boolean
	 */
	
	
	public static boolean isEnable(AppiumDriver driver, By element) {
		boolean status = false;
		try {
			if(driver.findElement(element).isDisplayed() && driver.findElement(element).isEnabled())
				status = true;
			else
				status = false;
			
		}catch(Exception e) {
			Log.message("Unable to validate state of the element "+element+" and the error message is "+ e.getMessage());
		}
		return status;
	}
	
	/**
	 * To check the Element state 
	 * 
	 * @param AppiumDriver - driver
	 * @param MobileElement - element
	 * 
	 * @return boolean
	 */
	
	
	public static boolean isDisable(MobileElement element) {
		boolean status = false;
		try {
			if(!(element.isDisplayed() && element.isEnabled()))
				status = true;
			else
				status = false;
			
		}catch(Exception e) {
			Log.message("Unable to validate state of the element "+element+" and the error message is "+ e.getMessage());
		}
		return status;
	}
	
	/**
	 * To check the Element state 
	 * 
	 * @param AppiumDriver - driver
	 * @param MobileElement - element
	 * 
	 * @return boolean
	 */
	
	
	public static boolean isDisable(AppiumDriver driver, By element) {
		boolean status = false;
		try {
			if(!(driver.findElement(element).isDisplayed() && driver.findElement(element).isEnabled()))
				status = true;
			else
				status = false;
			
		}catch(Exception e) {
			Log.message("Unable to validate state of the element "+element+" and the error message is "+ e.getMessage());
		}
		return status;
	}
	
	/**
	 * To send the text to the Text field
	 * 
	 * @param MobileElement - element
	 * 
	 * @return boolean
	 */
	
	public static boolean enterText(MobileElement element, String text) {
		boolean status = false;
		try {
			if(isPresent(element)) {
				element.clear();
				element.sendKeys(text);
				status = true;
			}else {
				status = false;
			}
			
		}catch(Exception e) {
			Log.message("Unable to enter the text "+text+" to the element "+element+" and the error message is "+ e.getMessage());
		}
		return status;
	}
	
	/**
	 * To send the text to the Text field
	 * 
	 * @param MobileElement - element
	 * 
	 * @return boolean
	 */
	
	public static boolean enterText(AppiumDriver driver, By element, String text) {
		boolean status = false;
		try {
			if(isPresent(driver, element)) {
				driver.findElement(element).clear();
				driver.findElement(element).sendKeys(text);
				status = true;
			}else {
				status = false;
			}
			
		}catch(Exception e) {
			Log.message("Unable to enter the text "+text+" to the element "+element+" and the error message is "+ e.getMessage());
		}
		return status;
	}
	
	/**
	 * To send the text to the Text field without clearing the existing value
	 * 
	 * @param MobileElement - element
	 * 
	 * @return boolean
	 */
	
	public static boolean enterTextWithoutClear(MobileElement element, String text) {
		boolean status = false;
		try {
			if(isPresent(element)) {
				element.sendKeys(text);
				status = true;
			}else {
				status = false;
			}
			
		}catch(Exception e) {
			Log.message("Unable to enter the text "+text+" to the element "+element+" and the error message is "+ e.getMessage());
		}
		return status;
	}
	
	/**
	 * To send the text to the Text field without clearing the existing value
	 * 
	 * @param MobileElement - element
	 * 
	 * @return boolean
	 */
	
	public static boolean enterTextWithoutClear(AppiumDriver driver, By element, String text) {
		boolean status = false;
		try {
			if(isPresent(driver, element)) {
				driver.findElement(element).sendKeys(text);
				status = true;
			}else {
				status = false;
			}
			
		}catch(Exception e) {
			Log.message("Unable to enter the text "+text+" to the element "+element+" and the error message is "+ e.getMessage());
		}
		return status;
	}
	
	/**
	 * To get the text value
	 * 
	 * @param MobileElement - element
	 * 
	 * @return boolean
	 */
	
	public static boolean getText(MobileElement element) {
		boolean status = false;
		try {
			if(isPresent(element)) {
				element.getText();
				status = true;
			}else {
				status = false;
			}
			
		}catch(Exception e) {
			Log.message("Unable to get the text from the element "+element+" and the error message is "+ e.getMessage());
		}
		return status;
	}
	
	/**
	 * To get the text value
	 * 
	 * @param MobileElement - element
	 * 
	 * @return boolean
	 */
	
	public static boolean getText(AppiumDriver driver, By element) {
		boolean status = false;
		try {
			if(isPresent(driver, element)) {
				driver.findElement(element).getText();
				status = true;
			}else {
				status = false;
			}
			
		}catch(Exception e) {
			Log.message("Unable to get the text from the element "+element+" and the error message is "+ e.getMessage());
		}
		return status;
	}
	
	/**
	 * To get the Attribute value
	 * 
	 * @param MobileElement - element
	 * 
	 * @return boolean
	 */
	
	public static boolean getAtributeValue(MobileElement element, String atributeValue) {
		boolean status = false;
		try {
			if(isPresent(element)) {
				element.getAttribute(atributeValue);
				status = true;
			}else {
				status = false;
			}
			
		}catch(Exception e) {
			Log.message("Unable to get the attribute value from the element "+element+" and the error message is "+ e.getMessage());
		}
		return status;
	}
	
	/**
	 * To get the Attribute value
	 * 
	 * @param MobileElement - element
	 * 
	 * @return boolean
	 */
	
	public static boolean getAtributeValue(AppiumDriver driver, By element, String atributeValue) {
		boolean status = false;
		try {
			if(isPresent(driver, element)) {
				driver.findElement(element).getAttribute(atributeValue);
				status = true;
			}else {
				status = false;
			}
			
		}catch(Exception e) {
			Log.message("Unable to get the attribute value from the element "+element+" and the error message is "+ e.getMessage());
		}
		return status;
	}
	
}
