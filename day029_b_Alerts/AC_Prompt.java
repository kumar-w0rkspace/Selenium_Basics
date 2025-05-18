package day029_b_Alerts;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class AC_Prompt {

	public static void main(String[] args) throws InterruptedException {
		// Prompt alerts have input box, ok and cancel

		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		String baseUrl = "https://the-internet.herokuapp.com/javascript_alerts";

		driver.get(baseUrl);

		WebElement promptAlert = driver.findElement(By.xpath("//button[@onclick='jsPrompt()']"));
		promptAlert.click(); // capturing alert element and clicking
		Alert myPromptAlert = driver.switchTo().alert(); // capturing alert window into alert type
		System.out.println(myPromptAlert.getText()); // capturing alert text
		myPromptAlert.sendKeys("She sells sea shells on the sea shore"); // sending keys to alert
		myPromptAlert.accept();
		WebElement result = driver.findElement(By.xpath("//p[@id='result']"));
		System.out.println(result.getText());

		Thread.sleep(3000);
		promptAlert.click();
		myPromptAlert.accept();
		System.out.println(result.getText());

		Thread.sleep(3000);
		promptAlert.click();
		myPromptAlert.dismiss();
		System.out.println(result.getText());
		driver.quit();

	}

}
