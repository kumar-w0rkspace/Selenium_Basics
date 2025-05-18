package day029_b_Alerts;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class AB_Confirmation {

	public static void main(String[] args) throws InterruptedException {
		// Confirmation alert has ok and cancel

		String baseUrl = "https://the-internet.herokuapp.com/javascript_alerts";

		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.get(baseUrl);
		WebElement alertButton = driver.findElement(By.xpath("//button[@onclick ='jsConfirm()']"));
		alertButton.click();
		Alert myAlert = driver.switchTo().alert();
		System.out.println(myAlert.getText()); // text in the alert
		myAlert.accept(); // clicking ok
		System.out.println(driver.findElement(By.xpath("//p[@id ='result']")).getText());

		Thread.sleep(3000); // intentional pause
		alertButton.click();
		myAlert.dismiss(); // clicking cancel
		System.out.println(driver.findElement(By.xpath("//p[@id ='result']")).getText());

		Thread.sleep(3000);
		driver.quit();

	}

}
