package day045_Parameterization;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class AB_Browser_SetUp_Via_XML {

	WebDriver driver;

	@BeforeClass()
	@Parameters({ "browser", "url" }) // passing browser as parameter which is defined on xml
	void setup(String br, String url) throws InterruptedException {
		switch (br.toLowerCase()) {
		case "chrome":
			driver = new ChromeDriver();
			break;
		case "edge":
			driver = new EdgeDriver();
			break;
		case "firefox":
			driver = new FirefoxDriver();
			break;
		default:
			System.out.println("Invalid browser");
			return;
		}

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(url);
		Thread.sleep(5000); // intentional pause for parallel browser all at once monitoring
	}

	@Test(priority = 1)
	void testLogo() {
		Assert.assertEquals(driver.findElement(By.xpath("//img[@alt='company-branding']")).isDisplayed(), true);
	}

	@Test(priority = 2)
	void testTitle() {
		Assert.assertEquals(driver.getTitle(), "OrangeHRM");
	}

	@Test(priority = 3)
	@Parameters({ "url" })
	void testUrl(String url) {
		Assert.assertEquals(driver.getCurrentUrl(), url);
	}

	@Test(priority = 4, dependsOnMethods = { "testUrl" })
	@Parameters({ "userName", "passWord" })
	void testLogin(String userName, String passWord) throws InterruptedException {
		driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys(userName);
		driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys(passWord);
		driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
		Assert.assertEquals(driver.findElement(By.xpath("//div[@id='app']//h6")).getText(), "Dashboard");
		Thread.sleep(2000);
	}

	@Test(priority = 5, dependsOnMethods = { "testLogin" })
	void testLogout() {
		driver.findElement(By.xpath("//div[@id='app']//i[@class='oxd-icon bi-caret-down-fill oxd-userdropdown-icon']"))
				.click();
		driver.findElement(By.xpath("//div[@id='app']//a[@class='oxd-userdropdown-link'][.='Logout']")).click();
	}

	@Test(priority = 6, dependsOnMethods = { "testLogout" })
	void testLoginIcon() {
		Assert.assertEquals(driver.findElement(By.xpath("//div[@id='app']//h5")).getText(), "Login");
	}

	@AfterClass
	void tearDown() {
		driver.quit();
	}
}
