package Utils;

import java.time.Duration;
import java.util.concurrent.TimeoutException;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

/**
 * This class contains KeyBoard related methods
 *
 */
public class WaitActions {

	/**
	 * To wait specified seconds 
	 * @param seconds - int
	 * 
	 * @return void
	*/
	public static void performSleep(int seconds) {
		try {
			Thread.sleep(seconds*1000);
		}catch(Exception e) {
			Log.message("Unable to wait for the specified seconds and the error is "+e.getMessage());
		}
	}
	
	/**
	 * To wait till the specified element is present with specified max wait in seconds
	 * 
	 * @param MobileElement - element
	 * @param seconds - int
	 * 
	 * @return boolean
	*/
	
	public static boolean waitTillElementPresent(AppiumDriver driver, MobileElement element) {
		boolean status = false;
		try {
			Wait wait = new FluentWait(driver).withTimeout(Duration.ofSeconds(60)).ignoring(NoSuchElementException.class)
					.ignoring(TimeoutException.class)
					.pollingEvery(Duration.ofMillis(500));
			wait.until(ExpectedConditions.visibilityOf(element));
			
			status = true;
					
		}catch(Exception e) {
			Log.message("Error while checking presence of " + element + "The error message is:" + e.getMessage());
		}
		return status;
	}
	
	/**
	 * To wait till the specified element is present with specified max wait in seconds
	 * 
	 * @param MobileElement - element
	 * @param seconds - int
	 * 
	 * @return boolean
	*/
	
	public static boolean waitTillElementPresent(AppiumDriver driver, By element) {
		boolean status = false;
		try {
			Wait wait = new FluentWait(driver).withTimeout(Duration.ofSeconds(60)).ignoring(NoSuchElementException.class)
					.ignoring(TimeoutException.class)
					.pollingEvery(Duration.ofMillis(500));
			wait.until(ExpectedConditions.visibilityOfElementLocated(element));
			
			status = true;
					
		}catch(Exception e) {
			Log.message("Error while checking presence of " + element + "The error message is:" + e.getMessage());
		}
		return status;
	}
	
	/**
	 * To wait till the specified element is absent with specified max wait in seconds
	 * 
	 * @param MobileElement - element
	 * @param seconds - int
	 * 
	 * @return boolean
	*/
	
	public static boolean waitTillElementAbsent(AppiumDriver driver, MobileElement element) {
		boolean status = false;
		try {
			Wait wait = new FluentWait(driver).withTimeout(Duration.ofSeconds(60)).ignoring(TimeoutException.class)
					.ignoring(TimeoutException.class)
					.pollingEvery(Duration.ofMillis(500));
			wait.until(ExpectedConditions.invisibilityOf(element));
			
			status = true;
					
		}catch(Exception e) {
			Log.message("Error while checking obsence of " + element + "The error message is:" + e.getMessage());
		}
		return status;
	}
	
	/**
	 * To wait till the specified element is absent with specified max wait in seconds
	 * 
	 * @param MobileElement - element
	 * @param seconds - int
	 * 
	 * @return boolean
	*/
	
	public static boolean waitTillElementAbsent(AppiumDriver driver, By element) {
		boolean status = false;
		try {
			Wait wait = new FluentWait(driver).withTimeout(Duration.ofSeconds(60)).ignoring(TimeoutException.class)
					.pollingEvery(Duration.ofMillis(500));
			wait.until(ExpectedConditions.invisibilityOfElementLocated(element));
			
			status = true;
					
		}catch(Exception e) {
			Log.message("Error while checking obsence of " + element + "The error message is:" + e.getMessage());
		}
		return status;
	}
	
	/**
	 * To wait till the Alert is present with specified max wait in seconds
	 * 
	 * @param MobileElement - element
	 * @param seconds - int
	 * 
	 * @return boolean
	*/
	
	public static boolean waitTillAlertPresent(AppiumDriver driver) {
		boolean status = false;
		try {
			Wait wait = new FluentWait(driver).withTimeout(Duration.ofSeconds(60)).ignoring(NoSuchElementException.class)
					.ignoring(TimeoutException.class).ignoring(NoAlertPresentException.class)
					.pollingEvery(Duration.ofMillis(500));
			wait.until(ExpectedConditions.alertIsPresent());
			
			status = true;
					
		}catch(Exception e) {
			Log.message("Error while checking presence of alert and The error message is:" + e.getMessage());
		}
		return status;
	}
	
	/**
	 * To wait till the element is clickable with specified max wait in seconds
	 * 
	 * @param MobileElement - element
	 * @param seconds - int
	 * 
	 * @return boolean
	*/
	
	public static boolean waitTillElementToBeClickable(AppiumDriver driver, MobileElement element) {
		boolean status = false;
		try {
			Wait wait = new FluentWait(driver).withTimeout(Duration.ofSeconds(60)).ignoring(NoSuchElementException.class)
					.ignoring(TimeoutException.class).ignoring(NoAlertPresentException.class)
					.pollingEvery(Duration.ofMillis(500));
			wait.until(ExpectedConditions.elementToBeClickable(element));
			
			status = true;
					
		}catch(Exception e) {
			Log.message("Error while checking presence of " + element + "The error message is:" + e.getMessage());
		}
		return status;
	}
	
	/**
	 * To wait till the element is clickable with specified max wait in seconds
	 * 
	 * @param By - element
	 * @param seconds - int
	 * 
	 * @return boolean
	*/
	
	public static boolean waitTillElementToBeClickable(AppiumDriver driver, By element) {
		boolean status = false;
		try {
			Wait wait = new FluentWait(driver).withTimeout(Duration.ofSeconds(60)).ignoring(NoSuchElementException.class)
					.ignoring(TimeoutException.class).ignoring(NoAlertPresentException.class)
					.pollingEvery(Duration.ofMillis(500));
			wait.until(ExpectedConditions.elementToBeClickable(element));
			
			status = true;
					
		}catch(Exception e) {
			Log.message("Error while checking presence of " + element + "The error message is:" + e.getMessage());
		}
		return status;
	}
	
	
	
}
