package day034_DatePickers_Calenders;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class AA_DirectInput {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		String baseUrl = "https://jqueryui.com/datepicker/";
		driver.get(baseUrl);
		driver.switchTo().frame(0);
		// picking date via sendkeys (Direct)
		WebElement dateField = driver.findElement(By.xpath("//input[@id='datepicker']"));
		dateField.clear();
		dateField.sendKeys("05/23/2025");
		System.out.println(dateField.isDisplayed());
		Thread.sleep(3000);
		driver.quit();

	}

}
