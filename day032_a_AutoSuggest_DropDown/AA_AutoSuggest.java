package day032_a_AutoSuggest_DropDown;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class AA_AutoSuggest {

	public static void main(String[] args) throws InterruptedException {
		// Search selenium on google and select the selenium webdriver dropdown
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		String baseUrl = "https://www.google.co.in/";
		driver.get(baseUrl);
		driver.findElement(By.xpath("//textarea[@name='q']")).sendKeys("selenium");
		List<WebElement> searchResults = driver.findElements(By.xpath("//li[@role='presentation']//span/b"));
		System.out.println("No. of search results: " + searchResults.size());
		try {
			for (WebElement result : searchResults) {
				if (result.getText().equalsIgnoreCase("webdriver")) {
					result.click();
				}
			}
		} catch (StaleElementReferenceException e) {
			Thread.sleep(20000); // captcha bypass
		}

		System.out.println(driver.getTitle());

		driver.quit();

	}

}
