package day037_a_JavaScriptExecutor;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class AB_a_ScrollBar_Vertical {

	public static void main(String[] args) throws InterruptedException {
		//
		WebDriver driver = new EdgeDriver();
		preReq(driver);
		String baseUrl = "https://www.countries-ofthe-world.com/flags-of-the-world.html";
		driver.get(baseUrl);

		JavascriptExecutor js = (JavascriptExecutor) driver;
// Scrolling till fixed pixel
		System.out.println(js.executeScript("return window.pageYOffset;"));
		js.executeScript("window.scrollBy(0,1500)", "");
		Thread.sleep(3000);
// capturing the value
		System.out.println(js.executeScript("return window.pageYOffset;"));
// Scrolling till element visibility
		WebElement element = driver.findElement(By.xpath("//img[@alt='Flag of India']"));
		js.executeScript("arguments[0].scrollIntoView();", element);
		System.out.println(js.executeScript("return window.pageYOffset;"));
		Thread.sleep(3000);
// Scrolling till the bottom
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
		System.out.println(js.executeScript("return window.pageYOffset;"));
		Thread.sleep(3000);
// Scrolling to the top
		js.executeScript("window.scrollBy(0,-document.body.scrollHeight)");
		Thread.sleep(3000);
		driver.quit();
	}

	static void preReq(WebDriver driver) {
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

}
