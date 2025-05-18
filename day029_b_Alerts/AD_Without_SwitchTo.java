package day029_b_Alerts;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AD_Without_SwitchTo {

	public static void main(String[] args) {
		// handle alert without using switchTo method
		// Note - we have to implement explicit wait for expected conditions

		String baseUrl = "https://the-internet.herokuapp.com/javascript_alerts";

		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		WebDriverWait myWait = new WebDriverWait(driver, Duration.ofSeconds(3));

		driver.get(baseUrl);
		WebElement simpleAlert = driver.findElement(By.xpath("//button[@onclick='jsAlert()']"));
		simpleAlert.click();

		// Implementing explicitwait conditions to check for alert availability
		Alert myAlert = myWait.until(ExpectedConditions.alertIsPresent());
		System.out.println(myAlert.getText());
		myAlert.accept();
		System.out.println(driver.findElement(By.xpath("//p[@id ='result']")).getText());
		driver.quit();
	}

}
