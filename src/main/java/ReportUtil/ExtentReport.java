package ReportUtil;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReport {

	public static ExtentReports getTestReport()
	{
		String filePath = System.getProperty("user.dir") + "\\TestReport\\index.html";
		ExtentSparkReporter extentrpt = new ExtentSparkReporter(filePath);
		extentrpt.config().setDocumentTitle("Test Report");
		extentrpt.config().setReportName("Automation Test Report");
		
		ExtentReports extentReport = new ExtentReports();
		extentReport.attachReporter(extentrpt);
		extentReport.setSystemInfo("Tester", "Shivanagayya Garampalli");
		return extentReport;
		
	}
	
}
