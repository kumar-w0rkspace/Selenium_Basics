package day037_a_JavaScriptExecutor;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class AC_ZoomIn_ZoomOut {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new EdgeDriver();
		String baseUrl = "https://www.countries-ofthe-world.com/flags-of-the-world.html";
		driver.get(baseUrl);
		Thread.sleep(3000);
		driver.manage().window().maximize(); // maximize
		Thread.sleep(3000);
		driver.manage().window().minimize(); // minimize to taskbar
		Thread.sleep(3000);
		driver.manage().window().maximize(); // maximize again
// Setting zoom level
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("document.body.style.zoom='100%'");
	}

}
