package day038_b_DriverOptions;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

public class AE_b_WithMultipleExtension {

	public static void main(String[] args) throws InterruptedException {

		EdgeOptions options = new EdgeOptions();
		File selectorsHub = new File("C:\\Users\\ARUN\\Downloads\\SelectorsHubXPath-Helper.crx");
		File uBlock = new File("C:\\Users\\ARUN\\Downloads\\uBlock-Origin.crx");
		List<File> extensions = new ArrayList<File>();
		extensions.add(selectorsHub);
		extensions.add(uBlock);
		options.addExtensions(extensions);
		WebDriver driver = new EdgeDriver(options);
		driver.manage().window().maximize();
		String baseUrl = "https://text-compare.com/";
		driver.navigate().to(baseUrl);
		Thread.sleep(5000);
		// driver.quit();

	}

}
