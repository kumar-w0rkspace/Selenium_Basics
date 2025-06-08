package day037_a_JavaScriptExecutor;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class AB_b_ScrollBar_Horizontal {
	static void preReq(WebDriver driver) {
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	public static void main(String[] args) throws InterruptedException {
		// https://home.tobias-schwarz.com/tests/viewport/scroll-horizontal-scalable.php
		WebDriver driver = new EdgeDriver();
		String baseUrl = "https://home.tobias-schwarz.com/tests/viewport/scroll-horizontal-scalable.php";
		preReq(driver);
		driver.get(baseUrl);
		JavascriptExecutor js = (JavascriptExecutor) driver;
// Horizontal scroll till pixel
		Thread.sleep(3000);
		System.out.println(js.executeScript("return window.pageXOffset;"));
		js.executeScript("window.scrollBy(3000,0)", "");
		System.out.println(js.executeScript("return window.pageXOffset;"));
		Thread.sleep(3000);
// Horizontal scroll till element
		WebElement element = driver.findElement(By.xpath("//td[normalize-space()='result-load']"));
		js.executeScript("arguments[0].scrollIntoView();", element);
		System.out.println(js.executeScript("return window.pageXOffset;"));
		Thread.sleep(3000);
// Horizontal scroll till end
		js.executeScript("window.scrollBy(document.body.scrollWidth,0)");
		System.out.println(js.executeScript("return window.pageXOffset;"));
		Thread.sleep(3000);
// Horizontal scroll till beginning
		js.executeScript("window.scrollBy(-document.body.scrollWidth,0)");
		System.out.println(js.executeScript("return window.pageXOffset;"));
		Thread.sleep(3000);
	}

}
