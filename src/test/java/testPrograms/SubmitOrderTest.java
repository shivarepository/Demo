package testPrograms;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import rahulshettyacademy.TestComponents.BaseTest;
import rahulshettyacademy.pageobjects.CartPage;
import rahulshettyacademy.pageobjects.CheckOutPage;
import rahulshettyacademy.pageobjects.LandingPage;
import rahulshettyacademy.pageobjects.OrderConfirmationPage;
import rahulshettyacademy.pageobjects.OrdersPage;
import rahulshettyacademy.pageobjects.ProductCatalogue;

public class SubmitOrderTest extends BaseTest{
	
	 String productName = "ZARA COAT 3";
	@Test(dataProvider="getData",groups= {"purchaseOrder"}) 
		public void submiteOrder(HashMap<String,String> input) throws IOException		
	{	
	//	WebDriverManager.chromedriver().setup();	
		ProductCatalogue productCatalogue = landingpage.LoginApplication(input.get("email"), input.get("password")); 		
		List<WebElement> products = productCatalogue.getProductList();
		productCatalogue.addProductToCart(input.get("product"));		
		CartPage cartpage = productCatalogue.gotoCartPage();
		Boolean match = cartpage.VerifyProductDisplay(input.get("product"));
		Assert.assertTrue(match);		
		CheckOutPage checkoutpage = cartpage.goToCheckOut();
		checkoutpage.selectCountry("India");
		OrderConfirmationPage orderconfirmationpage = checkoutpage.placeOrder();
		String ConfirmMessage = orderconfirmationpage.getconfirmationMessage();		
		Assert.assertTrue(ConfirmMessage.equalsIgnoreCase("Thankyou for the order."));
		
		
	}
	
	@Test(dependsOnMethods = {"submiteOrder"})
	public void orderHistoryTest()
	{
		ProductCatalogue productCatalogue = landingpage.LoginApplication("shiva.swami88@gmail.com", "Sbg@2023");
		OrdersPage orderspage = productCatalogue.gotoOrdersPage();
		Assert.assertTrue(orderspage.VerifyOrdersDisplay(productName));
	}
	
	@DataProvider
	public Object[][] getData() throws IOException
	{
	//	return new Object[][] {{"shiva.swami88@gmail.com", "Sbg@2023","ZARA COAT 3"},{"shiva.swami88@gmail.com","Sbg@2023","ADIDAS ORIGINAL"}};
		
	//	HashMap<String,String> map = new HashMap<String,String>();
	//	map.put("email", "shiva.swami88@gmail.com");
		//map.put("password", "Sbg@2023");
		//map.put("product", "ZARA COAT 3");
		
	//HashMap<String,String> map1 = new HashMap<String,String>();
		//map1.put("email", "shiva.swami88@gmail.com");
		//map1.put("password", "Sbg@2023");
		//map1.put("product", "ADIDAS ORIGINAL");
		
		List<HashMap<String, String>> data = getJsonDataToMap(System.getProperty("user.dir") + "//src//test//java//rahulshettyacademy//data//PurchaseOrder.json");
		
		return new Object[][] {{data.get(0)},{data.get(1)}};
	}

}
