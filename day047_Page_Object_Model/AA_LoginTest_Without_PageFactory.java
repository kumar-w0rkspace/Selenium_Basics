package day047_Page_Object_Model;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class AA_LoginTest_Without_PageFactory {

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
		AA_LoginPage_Without_PageFactory lp = new AA_LoginPage_Without_PageFactory(driver);
		lp.setUserName("Admin");
		lp.setPassWord("admin123");
		lp.clickLoginBtn();
		Assert.assertEquals(driver.getTitle(), "OrangeHRM");
	}

	@AfterClass
	void tearDown() {
		driver.quit();
	}

}
