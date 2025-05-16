package day024_Locators_XPath;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class AB_d_Relative_InnerText {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String xPathWithInnerTextAndLink = "//*[text() = 'PlaywrightPractice']";
		String xPathWithInnerTextOnly = "//*[text() = 'Tabs']";

		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		String baseUrl = "https://testautomationpractice.blogspot.com/";

		driver.get(baseUrl);
		String text = driver.findElement(By.xpath(xPathWithInnerTextOnly)).getText(); // getting the text of the element
		System.out.println(text);
		driver.findElement(By.xpath(xPathWithInnerTextAndLink)).click();
		System.out.println(driver.getCurrentUrl());

		driver.quit();

	}

}
