package rahulshettyacademy.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import rahulshettyacademy.AbstractComponents.AbstractComponent;

public class CheckOutPage extends AbstractComponent{
	
	WebDriver driver;
	
	@FindBy(css="[placeholder='Select Country']")
	WebElement selectCountry;
	
	@FindBy(xpath="//button[contains(@class,'ta-item')][2]")
	WebElement country;
	
	@FindBy(css=".action__submit")
	WebElement placeOderbtn;
	
	By countryList = By.cssSelector(".ta-results");
	
	public CheckOutPage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void selectCountry(String Country)
	{
		Actions a = new Actions(driver);
		a.sendKeys(selectCountry,Country).build().perform();
	//	waitForElementToAppear(countryList);
		country.click();
	}
	
	public OrderConfirmationPage placeOrder()
	{
		placeOderbtn.click();
		implicitWaitCall();
		return new OrderConfirmationPage(driver);
	}
	
}
