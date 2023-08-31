package rahulshettyacademy.TestComponents;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.github.bonigarcia.wdm.WebDriverManager;
import rahulshettyacademy.pageobjects.LandingPage;

public class BaseTest  {
	
	public WebDriver driver;
	public LandingPage landingpage;
	public WebDriver initializeDriver() throws IOException
	{
		Properties prop = new Properties();
		FileInputStream fis = new 
		FileInputStream(System.getProperty("user.dir")+"//src//main//java//rahulshettyacademy//resources//GlobalData.properties");
		prop.load(fis);
		
		/*
		 * String path = "F:\\Soft\\chromedriver.exe";
		 * System.setProperty("webdriver.chrome.driver", path); ChromeOptions options =
		 * new ChromeOptions(); options.addArguments("--remote-allow-origins=*");
		 */
		
		String browserName = prop.getProperty("browser");
		if(browserName.equalsIgnoreCase("Chrome"))
		{
	//	WebDriverManager.chromedriver().setup();
	//    driver = new ChromeDriver();
			driver = new ChromeDriver();
		}else if (browserName.equalsIgnoreCase("Firefox")) {
			
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().deleteAllCookies();
		return driver;
	}

	@BeforeMethod(alwaysRun=true)
	public LandingPage launchApplication() throws IOException
	{
		driver = initializeDriver();
	    landingpage = new LandingPage(driver);
		landingpage.goTo();
		return landingpage;
	}
	
	public  List<HashMap<String, String>> getJsonDataToMap(String filePath) throws IOException
	{
		String jsonContent = FileUtils.readFileToString(new File(filePath), StandardCharsets.UTF_8);
		ObjectMapper mapper = new ObjectMapper();
		List<HashMap<String,String>> data = mapper.readValue(jsonContent, new TypeReference<List<HashMap<String,String>>>()
				{
				});
		return data;
	}
	
	public String getScreenShot(String testCaseName, WebDriver driver) throws IOException
	{
		TakesScreenshot ts = (TakesScreenshot)driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File file = new File(System.getProperty("user.dir") + "//screenShots" + testCaseName + ".png");
		FileUtils.copyFile(source, file);
		return System.getProperty("user.dir") + "//screenShots" + testCaseName + ".png";
	}
	
	@AfterMethod(alwaysRun=true)
	public void tearDown()
	{ 
		driver.quit();
	}
}
