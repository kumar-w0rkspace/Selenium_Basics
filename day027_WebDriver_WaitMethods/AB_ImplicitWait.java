package day027_WebDriver_WaitMethods;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class AB_ImplicitWait {

	public static void main(String[] args) {

		String baseUrl = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";

		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		// implementing implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5)); // 5 seconds
		// Note - we only need to use it once and it is valid for the whole script and
		// is active till we close driver

		driver.get(baseUrl);

		driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("Admin");

		System.out.println(driver.getTitle());

		driver.close();
	}

}
