package day023_Locators_CSS;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class AB_Tag_Class {

	public static void main(String[] args) {

		// https://demo.nopcommerce.com/

		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		String baseUrl = "https://demo.nopcommerce.com/#main";
		String searchQuery = "Samsung";
		driver.get(baseUrl);

		// CSS selector using tag.class
		WebElement searchBox = driver.findElement(By.cssSelector(".search-box-text"));
		searchBox.sendKeys(searchQuery);

		driver.findElement(By.cssSelector(".ico-register")).click();

		System.out.println(driver.getTitle());

	}

}
