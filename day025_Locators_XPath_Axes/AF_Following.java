package day025_Locators_XPath_Axes;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class AF_Following {

	public static void main(String[] args) throws InterruptedException {

		// not just siblings, but every elements comes into picture

		String baseUrl = "https://testautomationpractice.blogspot.com/";
		String xPathFollowing = "//input[@placeholder='Enter Name']/following::textarea";
		String xPathFollowingLast = "//input[@placeholder='Enter Name']/following::input[last()]";
		String address = "Address, District, State, Country";

		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get(baseUrl);

		driver.findElement(By.xpath(xPathFollowing)).sendKeys(address);
		driver.findElement(By.xpath(xPathFollowingLast)).sendKeys("Randoxy para");
		driver.findElement(By.xpath("//button[@id='btn3']")).click();

		Thread.sleep(3000);
		driver.quit();

	}

}
