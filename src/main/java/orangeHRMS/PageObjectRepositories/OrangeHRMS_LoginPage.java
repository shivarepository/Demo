package orangeHRMS.PageObjectRepositories;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.AbstractComponents;

public class OrangeHRMS_LoginPage extends AbstractComponents{

	WebDriver driver;
	public OrangeHRMS_PIMAddEmpPage ornghrmshome;
	
	@FindBy(name="username")
	WebElement UserName;
	
	@FindBy(name="password")
	WebElement UserPassword;
	
	@FindBy(xpath="//button[@type='submit']")
	WebElement btnLogin;
	
	public OrangeHRMS_LoginPage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}	
	
	public OrangeHRMS_PIMAddEmpPage LoginToApp(String userName, String userPassword)
	{		
		waitforElementToAppear(UserName);
		UserName.sendKeys(userName);
		UserPassword.sendKeys(userPassword);
		btnLogin.click();
		ornghrmshome = new OrangeHRMS_PIMAddEmpPage(driver);
		return ornghrmshome;
	}
	
	public void Goto() {
		driver.get("https://opensource-demo.orangehrmlive.com/");
	}
}
