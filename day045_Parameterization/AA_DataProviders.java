package day045_Parameterization;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class AA_DataProviders {

	WebDriver driver;
	String baseUrl = "https://tutorialsninja.com/demo/index.php?route=account/login";

	@BeforeClass
	void setup() {
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	@Test(dataProvider = "hardCoded")
	void testLogin(String email, String password) {
		driver.get(baseUrl);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.xpath("//input[@id='input-email']")).sendKeys(email);
		driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys(password);
		driver.findElement(By.xpath("//input[@value='Login']")).click();
		if (driver.findElement(By.xpath("//h2[normalize-space()='My Account']")).isDisplayed()) {
			driver.findElement(By.xpath("//div[@class='list-group']//a[13]")).click();
			Assert.assertTrue(true);
		} else {
			Assert.fail();
		}
	}

	@AfterClass
	void tearDown() {
		driver.quit();
	}

	@DataProvider(name = "hardCoded", indices = { 0, 1, 3 })
	// without indices, all cases will be tested. with indices, only selected index
	// will execute
	Object[][] loginData() { // object will be better since test data can have any variable
		String data[][] = { { "abc@gmail.com", "test123'" }, { "xyz@gmail.com", "test012" },
				{ "john@gmail.com", "test@123" }, { "roona@doonamail.com", "roonadoona" },
				{ "randomguy@mail.com", "randompw" } };

		return data;
	}

}
