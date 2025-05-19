package day030_Frames_iFrames;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class AB_iFrames {

	public static void main(String[] args) throws InterruptedException {
		// interacting with frame inside frame (iFrame)

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

		// Note - its better to find the address of inner frame and inspect elements on
		// new window while scripting
		driver.findElement(By.xpath("//div[@id='i12']//div[@class='AB7Lab Id5V1']")).click();
		driver.findElement(By.xpath("//div[@class='pIDwKe']//input[@type='text']"))
				.sendKeys("She sells seashells on the seashore");
		driver.findElement(By.xpath("//div[@id='i27']//div[@class='uHMk6b fsHoPb']")).click();
		driver.findElement(By.xpath("//span[contains(text(),'Next')]")).click();

		// switching to basewindow
		driver.switchTo().defaultContent();
		// switching to frame one
		driver.switchTo().frame(driver.findElement(By.xpath("//frame[@src ='frame_1.html']")));
		driver.findElement(By.xpath("//input[@name='mytext1']")).sendKeys("FRAME ONE"); // dummy check
		Thread.sleep(3000); // intentional pause
		driver.quit();

	}

}
