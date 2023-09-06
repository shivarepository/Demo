package rahulshettyacademy.AbstractComponents;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Timeouts;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import rahulshettyacademy.pageobjects.CartPage;
import rahulshettyacademy.pageobjects.OrdersPage;

public class AbstractComponent {
	
	WebDriver driver;
	public AbstractComponent(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(css="[routerlink*=cart]")
	WebElement cartHeader;
	
	@FindBy(css="[routerlink*= myorders]")
	WebElement orderHeader;
	
	public void waitForElementToAppear(By findBy)
	{
	    WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
	    wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));
	}
	
	public void waitForWebElementToAppear(WebElement ele)
	{
	    WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
	    wait.until(ExpectedConditions.visibilityOf(ele));
	}
	
	public void waitForElementToDisAppear(WebElement ele)
	{
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.invisibilityOf(ele));
		
	}
	
	public CartPage gotoCartPage()
	{
		cartHeader.click();
		return new CartPage(driver);
	}
	
	public OrdersPage gotoOrdersPage()
	{
		orderHeader.click();
		return new OrdersPage(driver);
	}
	
	public  Timeouts implicitWaitCall()
	{
		return driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}
}
