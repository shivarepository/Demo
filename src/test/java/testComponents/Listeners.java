package testComponents;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import ReportUtil.ExtentReport;
import orangeHRMS.Tests.BaseTest;

public class Listeners extends BaseTest implements ITestListener{
	
	ExtentTest Test;
	ExtentReports extentReport = ExtentReport.getTestReport();
	ThreadLocal<ExtentTest> ExtentTest = new ThreadLocal<ExtentTest>();
	
	@Override
	public void onTestStart(ITestResult result)
	{
		Test = extentReport.createTest(result.getMethod().getMethodName());
		ExtentTest.set(Test);
	}
	@Override
	public void onTestSuccess(ITestResult result)
	{
		ExtentTest.get().log(Status.PASS, "Test Passed");
	}
	@Override
	public void onTestFailure(ITestResult result)
	{
		ExtentTest.get().fail(result.getThrowable());
		try {
			driver = (WebDriver)result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String filepath = null;
		try {
			filepath = getScreenShot(result.getMethod().getMethodName(),driver);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ExtentTest.get().addScreenCaptureFromPath(filepath, result.getMethod().getMethodName());
	}
	
	@Override
	public void onFinish(ITestContext context) 
	{
		extentReport.flush();
	}

}
