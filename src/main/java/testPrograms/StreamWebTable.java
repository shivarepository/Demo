package testPrograms;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class StreamWebTable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		driver.findElement(By.xpath("//span[contains(text(),'Veg/fruit name')]")).click();
		List<WebElement> elementsList = driver.findElements(By.xpath("//tbody/tr/td[1]"));
		List<String> originalList = elementsList.stream().map(s->s.getText()).collect(Collectors.toList());
		List<String> newList = originalList.stream().sorted().collect(Collectors.toList());
		Assert.assertTrue(originalList.equals(newList));
		
		List<String> price = elementsList.stream().filter(s->s.getText().contains("Beans")).map(s->getPriceVeggies(s))
				.collect(Collectors.toList());
		price.forEach(a->System.out.println(a));
		
		
				
	}

	private static String getPriceVeggies(WebElement s) {
		String priceValue = s.findElement(By.xpath("//tr/td[1]/following-sibling::td[1]")).getText();
		return priceValue;
	}
}