package Utils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;

/**
 * This class contains KeyBoard related methods
 *
 */
public class KeyBoard {
	
	
	/**
	 * To hide the keyboard
	 * 
	 * @param AppiumDriver<MobileElement> driver
	 * 
	 * @return void
	 */
	
	public static void hideKeyboard(AppiumDriver<MobileElement> driver, String platform) {
    	try {
    		
    		if(platform.toLowerCase().equals("android")) {
    			driver.hideKeyboard();
    		}else {
    			driver.findElement(MobileBy.AccessibilityId("Return")).click();
    		}
    		
    	}catch(Exception e) {
    		Log.error("Unable to hide the keyboard "+ e.getMessage());
    	}
    }
	
	

}
