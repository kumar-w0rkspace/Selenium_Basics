package day024_Locators_XPath;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class AA_Absolute {

	public static void main(String[] args) {

		String absoluteXpath = "/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/nav[1]/a[2]";

		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		String baseUrl = "https://www.saucedemo.com/";

		driver.get(baseUrl);
		System.out.println(driver.getTitle());

		driver.findElement(
				By.xpath("/html[1]/body[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/form[1]/div[1]/input[1]"))
				.sendKeys("problem_user");
		driver.findElement(
				By.xpath("/html[1]/body[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/form[1]/div[2]/input[1]"))
				.sendKeys("secret_sauce");
		driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/form[1]/input[1]"))
				.click();
		driver.findElement(
				By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/button[1]"))
				.click();
		driver.findElement(By.xpath(absoluteXpath)).click();
		System.out.println(driver.getCurrentUrl());

		driver.quit();

	}

}
