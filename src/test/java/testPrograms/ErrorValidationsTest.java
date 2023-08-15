package testPrograms;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import rahulshettyacademy.TestComponents.BaseTest;

public class ErrorValidationsTest extends BaseTest {

	@Test(groups= {"ErrorHandlingTest"})
	public void submiteOrder() throws IOException
	{
		String productName = "ZARA COAT 3";
	
	 landingpage.LoginApplication("shiva.swami88@gmail.com", "Sbg@20230"); 
	 
	 Assert.assertEquals("Incorrect email or password.", landingpage.getErrorMessage());
	 
	}
}
