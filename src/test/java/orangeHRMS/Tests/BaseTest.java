package orangeHRMS.Tests;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.asserts.SoftAssert;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import io.github.bonigarcia.wdm.WebDriverManager;
import orangeHRMS.PageObjectRepositories.OrangeHRMS_LoginPage;
import utilities.ExcelDataOperations;

public class BaseTest {
	public WebDriver driver;
	public OrangeHRMS_LoginPage ornghrmslogin;
	public ExcelDataOperations ExcelData;
	public Object[][] arrdata;
	public SoftAssert softassert;
	
	 public static final Logger logger = Logger.getLogger(BaseTest.class.getName());
	 
	 public WebDriver initialize()
	 {
		 softassert = new SoftAssert();
		 WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			return driver;
	 }
			
	@BeforeTest(alwaysRun=true)
	public OrangeHRMS_LoginPage LaunchApp()
	{
		driver = initialize();
		ornghrmslogin = new OrangeHRMS_LoginPage(driver);
		ornghrmslogin.Goto();
		return ornghrmslogin;
	}

	public String getScreenShot(String testCase, WebDriver driver) throws IOException
	{
		TakesScreenshot screenShot = (TakesScreenshot)driver;
		File srcFile = screenShot.getScreenshotAs(OutputType.FILE);
		File destFile = new File(System.getProperty("user.dir") + "//screenShots//" +testCase+ ".png");
		FileUtils.copyFile(srcFile, destFile);
		return System.getProperty("user.dir") + "//screenShots//" +testCase+ ".png";
	}	
	
	@DataProvider
	public Object[][] getInputData() throws IOException
	{
		ExcelData = new ExcelDataOperations();
		arrdata = ExcelData.getExceldata("NewEmpData");
		return arrdata;
	} 
	
	@AfterClass
	public void tearDown()
	{
		driver.quit();
	}
}
