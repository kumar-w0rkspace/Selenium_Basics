package day024_Locators_XPath;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class AB_cb_Relative_MultipleAttributes_And_Or_Operator {

	public static void main(String[] args) {

		String xPathDynamic = "//button[@name= 'start' or @name= 'stop']";
		// this specific element will change its attribute once clicked

		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		String baseUrl = "https://testautomationpractice.blogspot.com/";

		driver.get(baseUrl);

		WebElement stButton = driver.findElement(By.xpath(xPathDynamic));
		System.out.println(stButton.getText());
		stButton.click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			System.out.println("THREADS");
		}
		System.out.println(stButton.getText());
		stButton.click();
		driver.quit();
	}

}
