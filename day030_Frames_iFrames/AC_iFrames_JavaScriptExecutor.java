package day030_Frames_iFrames;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class AC_iFrames_JavaScriptExecutor {

	public static void main(String[] args) throws InterruptedException {
		// Note - In Selenium’s JavaScript execution, `arguments` are placeholders for
		// parameters passed from Java.

		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

		String baseUrl = "https://ui.vision/demo/webtest/frames/";
		driver.get(baseUrl);

		// switching to frameThree
		WebElement frameThree = driver.findElement(By.xpath("//frame[@src='frame_3.html']"));
		driver.switchTo().frame(frameThree);
		driver.findElement(By.xpath("//input[@name ='mytext3']")).sendKeys("Frame Three");

		// entering the iframe inside frameThree
		// Note - use index of the iframe iff there is only one
		driver.switchTo().frame(0); // switching to iframe
		driver.findElement(By.xpath("//span[contains(text(),'Next')]")).click();

		// using javaScript Executor for inaccessible elements
		WebElement shortText = driver.findElement(By.xpath("//input[@type='text']"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		String smallText = "Never submit passwords through Google Forms.";
		js.executeScript("arguments[0].value = arguments[1];", shortText, smallText);

		WebElement longText = driver.findElement(By.xpath("//textarea[@aria-label='Your answer']"));
		String bigText = "Lorem ipsum dolor sit amet, consectetuer adipiscing elit.";
		js.executeScript("arguments[0].value = arguments[1];", longText, bigText);
		Thread.sleep(3000); // intentional pause

		WebElement submit = driver.findElement(By.xpath("//span[contains(text(),'Submit')]"));
		js.executeScript("arguments[0].click();", submit);
		System.out.println(driver.findElement(By.xpath("//div[@class='vHW8K']")).getText());

		driver.quit();

	}

}
