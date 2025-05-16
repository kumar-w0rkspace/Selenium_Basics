package day024_Locators_XPath;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class AB_e_Relative_Contains {

	public static void main(String[] args) {

		String xPathThatContains = "//button[contains (@class, 'st')]";
		// useful for an element with two function
		// eg a start and stop button. each have st in their name

		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		String baseUrl = "https://testautomationpractice.blogspot.com/";

		driver.get(baseUrl);
		WebElement stButton = driver.findElement(By.xpath(xPathThatContains));

		stButton.click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			System.out.println("Threads");
		}

		stButton.click();

		System.out.println(stButton.getText());
		driver.quit();
	}

}
