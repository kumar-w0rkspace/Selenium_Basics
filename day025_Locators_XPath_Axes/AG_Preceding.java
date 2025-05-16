package day025_Locators_XPath_Axes;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class AG_Preceding {

	public static void main(String[] args) throws InterruptedException {
		// not just siblings, but every elements comes into picture

		String baseUrl = "https://testautomationpractice.blogspot.com/";
		String xPathPreceeding = "//input[@placeholder='Enter Phone']/preceding::input[1]";
		String xPathPreceedingLast = "//input[@placeholder='Enter Phone']/preceding::input[last()]";

		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get(baseUrl);
		driver.findElement(By.xpath(xPathPreceeding)).sendKeys("randomemail@mail.com");
		driver.findElement(By.xpath(xPathPreceedingLast)).sendKeys("Name");
		Thread.sleep(3000);
		driver.quit();

	}

}
