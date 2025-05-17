package day027_WebDriver_WaitMethods;

import java.time.Duration;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException; // selenium
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;



public class AD_FluentWait {

	public static void main(String[] args) throws InterruptedException {
		
		String baseUrl = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";

		WebDriver driver = new EdgeDriver();
		
		// Declaration
		Wait<WebDriver> myWait = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(10)) // Maximum wait time
				.pollingEvery(Duration.ofSeconds(2)) // Frequency of checks [10 / 2 = 5 hits] (only difference b/w explicit and fluent)
				.ignoring(NoSuchElementException.class); // Ignore exceptions till max timeout
		// Note - NoSuchElementException - import should be from org.openqa.selenium

		driver.manage().window().maximize();
		
		driver.get(baseUrl);
		
		// implementation
		WebElement userName = myWait.until(new Function<WebDriver, WebElement>() {
			public WebElement apply(WebDriver driver) {
				return driver.findElement(By.xpath("//input[@placeholder='Username']"));
			}
		});

		userName.sendKeys("Admin");

		WebElement password = myWait.until(new Function<WebDriver, WebElement>() {
			public WebElement apply(WebDriver driver) {
				return driver.findElement(By.xpath("//input[@placeholder='Password']"));
			}
		});

		password.sendKeys("admin123");

		WebElement submitBtn = myWait.until(new Function<WebDriver, WebElement>() {
			public WebElement apply(WebDriver driver) {
				return driver.findElement(By.xpath("//button[@type='submit']"));
			}
		});

		submitBtn.click();

		Thread.sleep(5000); // intentional pause

		System.out.println(driver.getTitle());
		driver.quit();

	}

}
