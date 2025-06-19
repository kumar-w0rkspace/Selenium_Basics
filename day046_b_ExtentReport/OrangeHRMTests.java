package day046_b_ExtentReport;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class OrangeHRMTests {

	WebDriver driver;

	@BeforeClass
	void openApp() {
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	}

	@Test(priority = 1)
	void testLogo() throws InterruptedException { // pass
		Thread.sleep(1000);
		Assert.assertEquals(driver.findElement(By.xpath("//img[@alt='company-branding']")).isDisplayed(), true);
	}

	@Test(priority = 2)
	void testUrl(String url) { // fail
		Assert.assertEquals(driver.getCurrentUrl(),
				("https:abc//opensource-demo.orangehrmlive.com/web/index.php/auth/login")); // intentional mistake
	}

	@Test(priority = 3, dependsOnMethods = { "testUrl" })
	void testTitle() { // skip
		Assert.assertEquals(driver.getTitle(), "OrangeHRM");
	}

	@AfterClass
	void tearDown() {
		driver.quit();
	}
}
