package day025_Locators_XPath_Axes;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class AH_Following_Preceding_Siblings {

	public static void main(String[] args) throws InterruptedException {

		// Note - Following siblings / preceding siblings - these are only sibling
		// relation
		String baseUrl = "https://testautomationpractice.blogspot.com/";
		String xPathFollowingSibling = "//input[@placeholder='Enter EMail']/following-sibling::label";
		String xPathPrecedingSibling = "//input[@placeholder='Enter EMail']/preceding-sibling::input";

		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get(baseUrl);
		System.out.println(driver.findElement(By.xpath(xPathFollowingSibling)).getText());
		driver.findElement(By.xpath(xPathPrecedingSibling)).sendKeys("Name");
		Thread.sleep(3000);
		driver.quit();

	}

}
