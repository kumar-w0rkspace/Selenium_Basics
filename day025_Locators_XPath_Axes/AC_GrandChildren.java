package day025_Locators_XPath_Axes;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class AC_GrandChildren {

	public static void main(String[] args) throws InterruptedException {

		String baseUrl = "https://testautomationpractice.blogspot.com/";
		String xPathGrandChild = "//div[@class='post-body entry-content']/div/input[3]";
		String xPathTwo = "//div[@class='post-body entry-content']/div/textarea";

		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get(baseUrl);

		driver.findElement(By.xpath(xPathGrandChild)).sendKeys("1234567891");
		driver.findElement(By.xpath(xPathTwo)).sendKeys("Address, District, State, Country");
		Thread.sleep(3000);
		driver.quit();

	}

}
