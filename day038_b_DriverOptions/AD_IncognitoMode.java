package day038_b_DriverOptions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

public class AD_IncognitoMode {

	public static void main(String[] args) throws InterruptedException {
		EdgeOptions options = new EdgeOptions();
		options.addArguments("--inPrivate");
		// setting for running in incognito mode
		WebDriver driver = new EdgeDriver(options);
		driver.manage().window().maximize();
		String baseUrl = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
		driver.get(baseUrl);
		System.out.println((driver.getTitle().equals("OrangeHRM")) ? "Titles match" : "Titles dont match");
		Thread.sleep(5000);
		driver.quit();

	}

}
