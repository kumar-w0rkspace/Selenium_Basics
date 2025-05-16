package day024_Locators_XPath;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class AC_Chained_xPath {

	public static void main(String[] args) {

		// checking if the images are displayed or not

		String chainedxPath = "//*[@class='inventory_item']/div/a/img";
		boolean imgStat = false;

		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		String baseUrl = "https://www.saucedemo.com/";

		driver.get(baseUrl);
		driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys("problem_user");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("secret_sauce");
		driver.findElement(By.xpath("//input[@id='login-button']")).click();
		List<WebElement> imageElements = driver.findElements(By.xpath(chainedxPath));

		for (WebElement temp : imageElements) {
			imgStat = temp.isDisplayed();
			if (!imgStat) {
				System.out.println("Image not found");
				break;
			}
		}
		if (imgStat)
			System.out.println("All good");
		driver.quit();
	}

}
