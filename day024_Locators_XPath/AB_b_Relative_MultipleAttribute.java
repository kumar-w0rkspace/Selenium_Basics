package day024_Locators_XPath;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class AB_b_Relative_MultipleAttribute {

	public static void main(String[] args) {

		String xPathwithMultipleAttribute = "//*[@type='checkbox'][@class='form-check-input']";

		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		String baseUrl = "https://testautomationpractice.blogspot.com/";

		driver.get(baseUrl);

		// selecting multiple checkbox using multiple attribute
		List<WebElement> days = driver.findElements(By.xpath(xPathwithMultipleAttribute));
		for (WebElement temp : days) {
			temp.click();
		}

	}

}
