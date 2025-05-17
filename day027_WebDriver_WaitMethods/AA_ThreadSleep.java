package day027_WebDriver_WaitMethods;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class AA_ThreadSleep {

	public static void main(String[] args) throws InterruptedException {

		// implementing Thread.sleep method
		// Note - Thread.sleep is java method

		String baseUrl = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";

		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.get(baseUrl);

		Thread.sleep(3000); // in milliseconds
		// Note - Thread will wait for the specified time nonetheless

		driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("Admin");

		driver.quit();

	}

}
