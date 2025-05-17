package day027_WebDriver_WaitMethods;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AC_ExplicitWait {

	public static void main(String[] args) throws InterruptedException {

		// Note - normally we dont use explicit wait for every element

		String baseUrl = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";

		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();

		WebDriverWait myWait = new WebDriverWait(driver, Duration.ofSeconds(5)); // declaration of explicit wait

		driver.get(baseUrl);

		// Note - driver will wait till the condition is true.
		// The condition will be true when the element is located
		// first it will consider condition, then it consider time
		
		WebElement userName = myWait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Username']")));

		userName.sendKeys("Admin");
		WebElement passWord = myWait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Password']")));
		passWord.sendKeys("admin123");

		WebElement loginButton = myWait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@type='submit']")));
		loginButton.click();

		System.out.println(driver.getTitle());

		Thread.sleep(5000); // intentional pause

		driver.quit();

	}

}
