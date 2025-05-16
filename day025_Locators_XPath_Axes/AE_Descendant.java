package day025_Locators_XPath_Axes;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class AE_Descendant {

	public static void main(String[] args) {

		String xPathDescendant = "//div[@id='leftmenuinner']//a[3]";
		String baseUrl = "https://www.w3schools.com/java/java_intro.asp";

		WebDriver driver = new EdgeDriver();

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		driver.get(baseUrl);
		List<WebElement> elements = driver.findElements(By.xpath(xPathDescendant));
		System.out.println(elements.size());
		driver.quit();

	}

}
