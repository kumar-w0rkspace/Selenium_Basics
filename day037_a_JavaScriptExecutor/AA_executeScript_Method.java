package day037_a_JavaScriptExecutor;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class AA_executeScript_Method {

	static void preReq(WebDriver driver) {
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	public static void main(String[] args) {
		// use JSExecutor for click() and sendKeys()
		// https://testautomationpractice.blogspot.com/

		WebDriver driver = new EdgeDriver();
		preReq(driver);
		String baseUrl = "https://testautomationpractice.blogspot.com/";
		driver.get(baseUrl);
		WebElement name = driver.findElement(By.xpath("//input[@id='name']"));
// sendKeys alternate
		JavascriptExecutor jsE = (JavascriptExecutor) driver; // upcasting
		jsE.executeScript("arguments[0].setAttribute('value', 'John')", name);
		jsE.executeScript("arguments[0].setAttribute('value', 'randomemail@mailcom')",
				driver.findElement(By.xpath("//input[@id='email']")));
		jsE.executeScript("arguments[0].setAttribute('value', '9876543210')",
				driver.findElement(By.xpath("//input[@id='phone']")));
// click alternate
		jsE.executeScript("arguments[0].click()", driver.findElement(By.xpath("//input[@id='male']")));
		jsE.executeScript("arguments[0].click()", driver.findElement(By.xpath("//input[@id='sunday']")));

	}

}
