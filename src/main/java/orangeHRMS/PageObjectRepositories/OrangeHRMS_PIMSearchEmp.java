package orangeHRMS.PageObjectRepositories;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import utilities.AbstractComponents;

public class OrangeHRMS_PIMSearchEmp extends AbstractComponents{
	
	WebDriver driver;
	String EmpName;
	
	@FindBy(xpath="//a[contains(text(),'Employee List')]")
	WebElement menuEmpList;
	
	@FindBy(xpath="(//input[@placeholder='Type for hints...'])[1]")
	WebElement EmployeeName;
	
	@FindBy(xpath="//button[@type='submit']")
	WebElement Searchbtn;
	
	@FindBy(xpath="(//div[@class='oxd-table-header']//div[3]")
	WebElement tableFirstName;
	
	@FindBy(css="div[class='orangehrm-horizontal-padding orangehrm-vertical-padding'] span[class='oxd-text oxd-text--span']")
	WebElement NumOfRecords;
	
	@FindBy(xpath="//div[@class='oxd-table-header']//div[3]/../../../div[2]//div[starts-with(@class,'oxd-table-cell')][3]//div")
	List<WebElement> FNamesList;
	
	@FindBy(xpath="(//div[@role='rowgroup'])[2]//div[@role='cell']//div")
	List<WebElement> empRecords;
	
	public OrangeHRMS_PIMSearchEmp(WebDriver driver)
	{
		super(driver);
		this.driver = driver;
	}

	public String SearchEmployee(String FirstName) throws InterruptedException
	{
		waitforElementToAppear(menuEmpList);
		menuEmpList.click();
		waitforElementToAppear(EmployeeName);
		EmployeeName.sendKeys(FirstName);
		Thread.sleep(2000);
		Searchbtn.click();
		Thread.sleep(2000);
		String NumOfRecordsStr = NumOfRecords.getText();
		int NumOfRecords = Integer.parseInt(NumOfRecordsStr.replaceAll("[^0-9]", ""));
		if(NumOfRecords>0)
		{			
			for(int i=0;i<empRecords.size();i++)
			{
				if(empRecords.get(i).getText().contains(FirstName))
				{
					System.out.println(empRecords.get(i).getText());
					EmpName =  empRecords.get(i).getText();	
				}
			}
		}
		return EmpName;
	}
}
