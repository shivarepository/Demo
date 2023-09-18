package orangeHRMS.Tests;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import orangeHRMS.PageObjectRepositories.OrangeHRMS_PIMSearchEmp;

public class SubmitTest extends BaseTest {
	
	
	String firstName;
	
	@Test(groups= {"Smoke"})
	public void OrangeHRMS_LoginPage()
	{		
		ornghrmslogin.LoginToApp("Admin","admin123");	
	}
	
	@Test(dataProvider="getInputData", dependsOnMethods= {"OrangeHRMS_LoginPage"},groups= {"Smoke"})
	public void OrangeHRMS_OpenPIMPage_AddEmployee(String firstName,String lastName)
	{
		ornghrmslogin.ornghrmshome.Click_menuButton_PIM();
		ornghrmslogin.ornghrmshome.AddEmployee(this.firstName=firstName,lastName);
	}	
	
	
	@Test(dependsOnMethods= {"OrangeHRMS_LoginPage","OrangeHRMS_OpenPIMPage_AddEmployee"},groups= {"Sanity"})
	public void OrangeHRMS_OpenPIMPage_SearchEmployee() throws InterruptedException
	{
		OrangeHRMS_PIMSearchEmp ornghrmempsearch = new OrangeHRMS_PIMSearchEmp(driver);		
		softassert.assertEquals(ornghrmempsearch.SearchEmployee(firstName), firstName);
	}
}
