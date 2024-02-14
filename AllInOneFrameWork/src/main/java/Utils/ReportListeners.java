package Utils;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;

public class ReportListeners implements ITestListener {

	ExtentReports extentReport = ExtentReport.getExtentReport();
	ExtentTest extentTest;
	String testName;

	public void onTestStart(ITestResult result) {
		testName = result.getName();
		extentTest = extentReport.createTest(testName);
		Log.beginTestCase(testName);
		extentTest.log(Status.INFO, testName + " execution started..");
	}

	public void onTestSuccess(ITestResult result) {
		Log.message(testName + " executed succesfully");
		extentTest.log(Status.PASS, testName + " executed succesfully");
	}

	public void onTestFailure(ITestResult result) {

		Log.message(testName + " got failed");
		extentTest.log(Status.FAIL, testName + " got failed");

		WebDriver driver = null;

		try {

			driver = (WebDriver) result.getTestClass().getRealClass().getDeclaredField("driver")
					.get(result.getInstance());

		} catch (Exception e) {

		}
		// This Steps to capture the screenshot and added in that as Preview mode
		extentTest.log(Status.FAIL, MediaEntityBuilder
				.createScreenCaptureFromPath(TakeScreenshot.takeScreenShot(testName, driver), testName).build());

		// This Steps to capture the screenshot and added in that as Hyper Link
		extentTest.log(Status.FAIL, "<b>* <font color='red'>  Actual Result : </font> </b>" + testName + "*" + " "
				+ TakeScreenshot.setHyperLink(testName, TakeScreenshot.takeScreenShot(testName, driver)));

		extentTest.log(Status.INFO, result.getThrowable());

	}

	public void onTestSkipped(ITestResult result) {

		Log.message(testName + " got skipped");
		extentTest.log(Status.SKIP, testName + " got skipped");
		extentTest.log(Status.INFO, result.getThrowable());

	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

	}

	public void onTestFailedWithTimeout(ITestResult result) {

	}

	public void onStart(ITestContext context) {

	}

	public void onFinish(ITestContext context) {

		Log.message("Execution completed...");
		extentReport.flush();

	}

}
