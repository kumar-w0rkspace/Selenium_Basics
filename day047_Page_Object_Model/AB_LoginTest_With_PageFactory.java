package day047_Page_Object_Model;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class AB_LoginTest_With_PageFactory {

	WebDriver driver;
	String baseUrl = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";

	@BeforeClass
	void setUp() {
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(baseUrl);
	}

	@Test
	void testLogin() {
		AB_LoginPage_With_PageFactory logpage = new AB_LoginPage_With_PageFactory(driver);
		logpage.setUserName("Admin");
		logpage.setPassWord("admin123");
		logpage.clickLoginBtn();
		Assert.assertEquals(driver.getTitle(), "OrangeHRM");
	}

	@AfterClass
	void tearDown() {
		driver.quit();
	}

}
