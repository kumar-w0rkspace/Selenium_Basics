package day029_b_Alerts;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class AA_Simple {

	public static void main(String[] args) throws InterruptedException {
		// Note - normal alert - only ok button

		String baseUrl = "https://the-internet.herokuapp.com/javascript_alerts";

		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();

		driver.get(baseUrl);
		WebElement simpleAlert = driver.findElement(By.xpath("//button[@onclick='jsAlert()']"));
		simpleAlert.click();
		Alert myAlert = driver.switchTo().alert();
		System.out.println(myAlert.getText()); // capturing the text inside alert
		Thread.sleep(3000); // Intentional pause

		myAlert.accept(); // simple alert accepting
		System.out.println(driver.findElement(By.xpath("//p[@id ='result']")).getText());
		simpleAlert.click();
		Thread.sleep(3000); // Intentional pause

		driver.switchTo().alert().dismiss(); // simple alert denying
		Thread.sleep(3000); // Intentional pause

		driver.quit();

	}

}
