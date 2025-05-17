package day026_WebDriver_Methods;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class AC_b_Browser_Quit {

	public static void main(String[] args) {

		String baseUrl = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";

		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get(baseUrl);
		System.out.println(driver.getTitle());
		driver.findElement(By.xpath("//a[normalize-space()='OrangeHRM, Inc']")).click(); // new window
		String parentWindow = driver.getWindowHandle();
		Set<String> windowHandles = driver.getWindowHandles();

		for (String window : windowHandles) {
			if (!window.equals(parentWindow)) {
				driver.switchTo().window(window);
			}
		}
		System.out.println(driver.getTitle());
		driver.quit(); // quits the whole browser

	}

}
