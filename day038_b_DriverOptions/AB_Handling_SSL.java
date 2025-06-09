package day038_b_DriverOptions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

public class AB_Handling_SSL {

	public static void main(String[] args) {
		// https://expired.badssl.com/
		// handle the SSL

		EdgeOptions options = new EdgeOptions();
		options.setAcceptInsecureCerts(true); // accepts SSL certificates
		WebDriver driver = new EdgeDriver(options);
		driver.get("https://expired.badssl.com/");
// without driverOptions
//		System.out.println("Error page title " + driver.getTitle()); // privacy error
// with driverOptions
		System.out.println(driver.getTitle());
		driver.quit();

	}

}
