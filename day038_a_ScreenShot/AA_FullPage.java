package day038_a_ScreenShot;

import java.io.File;
import java.time.Duration;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class AA_FullPage {

	static void preReq(WebDriver driver) {
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	public static void main(String[] args) {
		// https://demo.nopcommerce.com/

		WebDriver driver = new EdgeDriver();
		preReq(driver);
		String baseUrl = "https://demo.nopcommerce.com/";
		driver.get(baseUrl);
// Taking screenshot
		TakesScreenshot scr = (TakesScreenshot) driver; // same as JSE
		File sourceFile = scr.getScreenshotAs(OutputType.FILE); // Returns a file type of variable
		File targetFile = new File(
				System.getProperty("user.dir") + "\\src\\test\\java\\day038_a_ScreenShot\\screenshots\\fullpage.png");
// System.getProperty("user.dir") returns the project folder dynamically
		sourceFile.renameTo(targetFile); // copying source file to targetfile
		System.out.println(System.getProperty("user.dir"));
		driver.quit();
	}

}
