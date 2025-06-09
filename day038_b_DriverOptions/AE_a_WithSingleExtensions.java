package day038_b_DriverOptions;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

public class AE_a_WithSingleExtensions {

	public static void main(String[] args) throws InterruptedException {

		EdgeOptions options = new EdgeOptions();
		File file = new File("C:\\Users\\ARUN\\Downloads\\SelectorsHubXPath-Helper.crx");
		// setting path for crx file
		options.addExtensions(file);
		WebDriver driver = new EdgeDriver(options);
		driver.manage().window().maximize();
		String baseUrl = "https://text-compare.com/";
		driver.get(baseUrl);
		Thread.sleep(5000);
		// driver.quit();

	}

}
