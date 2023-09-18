package orangeHRMS.PageObjectRepositories;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.AbstractComponents;

public class OrangeHRMS_PIMAddEmpPage extends  AbstractComponents{
	
	WebDriver driver;
	
	@FindBy(xpath="//span[normalize-space()='PIM']")
	WebElement menuButton_PIM;
	
	@FindBy(xpath="//a[text()='Add Employee']")
	WebElement menuButton_AddEmp;
	
	@FindBy(css="input[name='firstName']")
	WebElement firstName;
	
	@FindBy(css="input[name='lastName']")
	WebElement lastName;
	
	@FindBy(xpath="//div[@class='oxd-input-group oxd-input-field-bottom-space']//input[@class='oxd-input oxd-input--active']")
	WebElement EmployeeId;
	
	@FindBy(xpath="//button[starts-with(@class,'oxd-icon-button oxd-icon-button')]")
	WebElement photoUploadBtn;
	
	@FindBy(xpath="//button[@type='submit']")
	WebElement submitBtn;
	
	@FindBy(xpath="//button[@xpath=1]")
	WebElement cancelBtn;
	
	@FindBy(xpath="//a[text()='Employee List']")
	WebElement menuButton_EmpList;
	
	@FindBy(css=".oxd-userdropdown-tab")
	WebElement logout_drpdown;
	
	public OrangeHRMS_PIMAddEmpPage(WebDriver driver)
	{
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void Click_menuButton_PIM()
	{
		waitforElementToAppear(menuButton_PIM);
		menuButton_PIM.click();
	}
	
	public OrangeHRMS_PIMSearchEmp AddEmployee(String FirstName, String LastName)
	{
		waitforElementToAppear(menuButton_AddEmp);
		menuButton_AddEmp.click();
		waitforElementToAppear(firstName);
		firstName.sendKeys(FirstName);
		lastName.sendKeys(LastName);
		String filePath = "‪C:\\Users\\shiva\\Downloads\\laptop.jpg";
		photoUploadBtn.sendKeys(filePath);
		submitBtn.click();	
		return new OrangeHRMS_PIMSearchEmp(driver);
	}

	public void VerifyNewAddedEmployee()
	{
		
	}
}
