package day038_a_ScreenShot;

import java.io.File;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class AB_Specific_Area {
	static void preReq(WebDriver driver) {
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	public static void main(String[] args) {
		// Capture the featured products only
		WebDriver driver = new EdgeDriver();
		preReq(driver);
		String baseUrl = "https://demo.nopcommerce.com/";
		String featuredProduct = "//div[@class='product-grid home-page-product-grid']";
		driver.get(baseUrl);
		WebElement featuredProductElement = driver.findElement(By.xpath(featuredProduct));
// calling getScreenShot method from WebElement interface instead of TakesScreenShot interface
		File sourceFile = featuredProductElement.getScreenshotAs(OutputType.FILE);
		File targetFile = new File(System.getProperty("user.dir")
				+ "\\src\\test\\java\\day038_a_ScreenShot\\screenshots\\specificArea.png");
		sourceFile.renameTo(targetFile);
		driver.quit();
	}

}
