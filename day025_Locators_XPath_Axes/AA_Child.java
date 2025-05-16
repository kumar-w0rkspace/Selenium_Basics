package day025_Locators_XPath_Axes;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class AA_Child {

	public static void main(String[] args) throws InterruptedException {

		String baseUrl = "https://www.saucedemo.com/";
		String xPathChild = "//*[@class='social_linkedin']/child::a";

		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get(baseUrl);

		driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys("visual_user");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("secret_sauce");
		driver.findElement(By.xpath("//input[@id='login-button']")).click();
		driver.findElement(By.xpath(xPathChild)).click();

		driver.quit();

	}
}
