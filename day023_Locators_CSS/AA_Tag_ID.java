package day023_Locators_CSS;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class AA_Tag_ID {

	public static void main(String[] args) {
		// https://demo.nopcommerce.com/

		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		String baseUrl = "https://demo.nopcommerce.com/#main";
		String searchQuery = "Samsung";
		driver.get(baseUrl);

		// CSS selector using tag#id
		driver.findElement(By.cssSelector("input#small-searchterms")).sendKeys(searchQuery);

		driver.quit();
	}

}
