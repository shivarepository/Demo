package rahulshettyacademy.resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporterNG {

	public static ExtentReports getReportObject()
	{
		String path = System.getProperty("user.dir") + "\\Reports\\index.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		reporter.config().setReportName("Web Automation Test Results");
		reporter.config().setDocumentTitle("Test Results");
		
		ExtentReports extentreport = new ExtentReports();
		extentreport.attachReporter(reporter);
		extentreport.setSystemInfo("Tester", "Shivanagayya Garampalli");
		return extentreport;
		
	}
}
