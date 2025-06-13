package day042_TestNG;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

/*
 * Open orangeHRM app
 * test logo presence
 * login
 * close
 */
public class AB_OrangeHRM {

	WebDriver driver;

	void preReq(WebDriver driver) {
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	@Test(priority = 1)
	void openApp() {
		driver = new FirefoxDriver();
		preReq(driver);
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

	}

	@Test(priority = 2)
	void testLogo() throws InterruptedException {
		Thread.sleep(1000);
		boolean logoStatus = driver.findElement(By.xpath("//img[@alt='company-branding']")).isDisplayed();
		System.out.println("Logo display status " + logoStatus);
	}

	@Test(priority = 3)
	void login() {
		driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("Admin");
		driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("admin123");
		driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
	}

	@Test(priority = 4)
	void closeApp() {
		driver.close();
	}

}
