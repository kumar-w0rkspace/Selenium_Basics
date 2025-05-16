package day024_Locators_XPath;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class AB_f_Relative_StartWith {

	public static void main(String[] args) {

		String xPathThatStartsWith = "//button[starts-with(@class, 'st')]";

		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		String baseUrl = "https://testautomationpractice.blogspot.com/";

		driver.get(baseUrl);

		WebElement stButton = driver.findElement(By.xpath(xPathThatStartsWith));
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
