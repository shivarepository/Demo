package testPrograms;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;
import rahulshettyacademy.pageobjects.CartPage;
import rahulshettyacademy.pageobjects.CheckOutPage;
import rahulshettyacademy.pageobjects.LandingPage;
import rahulshettyacademy.pageobjects.OrderConfirmationPage;
import rahulshettyacademy.pageobjects.ProductCatalogue;

public class SubmitOrderTest {

	public static void main(String[] args) throws InterruptedException {
		
		String productName = "ZARA COAT 3";
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		
		driver.get("https://rahulshettyacademy.com/client/");
		LandingPage landingpage = new LandingPage(driver);
		landingpage.goTo();		
		ProductCatalogue productCatalogue = landingpage.LoginApplication("shiva.swami88@gmail.com", "Sbg@2023");
		
		List<WebElement> products = productCatalogue.getProductList();
		productCatalogue.addProductToCart(productName);		
		
		CartPage cartpage = productCatalogue.gotoCartPage();
		Boolean match = cartpage.VerifyProductDisplay(productName);
		Assert.assertTrue(match);		
		
		CheckOutPage checkoutpage = cartpage.goToCheckOut();
		checkoutpage.selectCountry("India");
		OrderConfirmationPage orderconfirmationpage = checkoutpage.placeOrder();

		String ConfirmMessage = orderconfirmationpage.getconfirmationMessage();
		
		Assert.assertTrue(ConfirmMessage.equalsIgnoreCase("Thankyou for the order."));
		driver.close();
	}
}
