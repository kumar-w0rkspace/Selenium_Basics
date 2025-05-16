package day025_Locators_XPath_Axes;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class AB_Parent {

	public static void main(String[] args) {

		String baseUrl = "https://www.saucedemo.com/";
		String xPathParent = "//*[@class='btn btn_primary btn_small btn_inventory ']/parent::div";

		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get(baseUrl);

		driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys("visual_user");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("secret_sauce");
		driver.findElement(By.xpath("//input[@id='login-button']")).click();

		List<WebElement> elements = driver.findElements(By.xpath(xPathParent));

		for (WebElement temp : elements) {
			System.out.println(temp.getText().replace("Add to cart", ""));
		}
		driver.quit();
	}

}
