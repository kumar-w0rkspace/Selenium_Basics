package day026_WebDriver_Methods;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class AB_Conditional {

	public static void main(String[] args) {

		// isDisplayed, isEnabled, isSelected
		// Note - returns boolean

		String baseUrl = "https://demo.nopcommerce.com/register";
		String logoXpath = "//img[@alt='nopCommerce demo store']";
		String nameElement = "//input[@id='small-searchterms']";
		String radioElement = "//input[@id='gender-male']";

		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		driver.get(baseUrl);
// isDisplayed
		WebElement logo = driver.findElement(By.xpath(logoXpath));
		System.out.println("Logo display status " + logo.isDisplayed());
// isEnabled
		boolean nameField = driver.findElement(By.xpath(nameElement)).isEnabled();
		System.out.println("Name element enabled status " + nameField);
// isSelected
		driver.findElement(By.xpath(radioElement)).click(); // selecting male radio button
		boolean maleButton = driver.findElement(By.xpath(radioElement)).isSelected();
		boolean femaleButton = driver.findElement(By.xpath("//input[@id='gender-female']")).isSelected();
		System.out.println("Male button status: " + maleButton);
		System.out.println("Female button status: " + femaleButton);

		driver.quit();
	}

}
