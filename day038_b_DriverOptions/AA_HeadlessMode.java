package day038_b_DriverOptions;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

public class AA_HeadlessMode {
	static void preReq(WebDriver driver) {
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	public static void main(String[] args) {
		// in headless mode
		// launch browser
		// launch a url
		// validate title
		// close browser

		EdgeOptions options = new EdgeOptions();
		options.addArguments("--headless=new"); // setting for headless testing
		WebDriver driver = new EdgeDriver(options);
		String baseUrl = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
		driver.get(baseUrl);
		System.out.println((driver.getTitle().equals("OrangeHRM")) ? "Titles match" : "Titles dont match");

		driver.quit();

	}

}
