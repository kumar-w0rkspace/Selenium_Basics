package day024_Locators_XPath;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class AB_a_Relative_SingleAttribute {

	public static void main(String[] args) {

		String xPathWithSingleAttribute = "//*[@value='male']";

		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		String baseUrl = "https://testautomationpractice.blogspot.com/";

		driver.get(baseUrl);
		driver.findElement(By.xpath("//*[@placeholder='Enter Name']")).sendKeys("Arun Kumar MS");
		driver.findElement(By.xpath("//*[@id='email']")).sendKeys("arunkumar123@gmail.com");
		driver.findElement(By.xpath("//*[@id='phone']")).sendKeys("1239398383");
		driver.findElement(By.xpath("//*[@id='textarea']"))
				.sendKeys("House name, Street name, City name, State name, Pincode");
		driver.findElement(By.xpath("//*[@value='male']")).click();
		System.out.println(driver.findElement(By.xpath(xPathWithSingleAttribute)).isEnabled());
		driver.quit();
	}

}
