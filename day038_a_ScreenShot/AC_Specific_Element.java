package day038_a_ScreenShot;

import java.io.File;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class AC_Specific_Element {
	static void preReq(WebDriver driver) {
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	public static void main(String[] args) {
		// capture the image of logo only

		WebDriver driver = new EdgeDriver();
		preReq(driver);
		String baseUrl = "https://demo.nopcommerce.com/";
		driver.get(baseUrl);
		WebElement logoElement = driver.findElement(By.xpath("//img[@alt='nopCommerce demo store']"));
		File sourceFile = logoElement.getScreenshotAs(OutputType.FILE);
		File targetFile = new File(
				System.getProperty("user.dir") + "\\src\\test\\java\\day038_a_ScreenShot\\screenshots\\logoimage.png");
		sourceFile.renameTo(targetFile);
		driver.quit();

	}

}
