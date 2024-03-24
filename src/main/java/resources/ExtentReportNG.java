package resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportNG {

	public static ExtentReports getReportObj() {
		String path = System.getProperty("user.dir") + "//reports//index.html";
		ExtentSparkReporter repo = new ExtentSparkReporter(path);
		repo.config().setReportName("Web Automation Rewsults");
		repo.config().setDocumentTitle("Test Results");

		ExtentReports extent = new ExtentReports();
		extent.attachReporter(repo);
		extent.setSystemInfo("Tester", "Mukesh");
		return extent;

	}

}
