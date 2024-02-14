package Test;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Utils.ReportListeners;
import io.github.bonigarcia.wdm.WebDriverManager;

@Listeners(ReportListeners.class)
public class DemoTest {
	
	public WebDriver driver;
	
	
	@BeforeMethod
	public void launch() throws InterruptedException {
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy-hh-mm-ss");
	    System.setProperty("current.date.time", dateFormat.format(new Date()));
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://emcamobileappmgmt-qa.azurewebsites.net/okta");
		Thread.sleep(10000);
	}
	
	@Test
	public void verifyLoginScreen() {
		int a = 10/0;
		System.out.println("Exceution Failed...");
		
		
	}
	
	@AfterMethod
	public void close() {
		driver.quit();
	}

}
