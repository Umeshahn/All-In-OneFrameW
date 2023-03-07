package Utils;

import java.io.File;
import java.io.IOException;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReport {
	
	
	public static ExtentReports getExtentReport() {
		ExtentReports extentReport = new ExtentReports();
		try {
			File extentReportFile = new File(System.getProperty("user.dir") + "/test-output/ExtentReport.html");
			ExtentSparkReporter extentSparkReporter = new ExtentSparkReporter(extentReportFile);
			extentSparkReporter.config().setReportName("Automation Result...");
			extentSparkReporter.config().setDocumentTitle("Automation Execution...");
			extentSparkReporter.config().setTimeStampFormat("dd/MM/YYYY hh:mm:ss");
			extentReport.attachReporter(extentSparkReporter);

		} catch (Exception e) {
			Log.error("The Error message is " + e.getMessage());
		}

		return extentReport;

	}

}
