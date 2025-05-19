package day030_Frames_iFrames;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class Xeg_AA_AllFrames_Interaction {

	public static void main(String[] args) {
		// input data into all frames

		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		
		String baseUrl = "https://ui.vision/demo/webtest/frames/";
		driver.get(baseUrl);

		System.out.println(driver.getTitle()); // base page title

		String frameOne = "//frame[@src='frame_1.html']";
		String frameTwo = "//frame[@src='frame_2.html']";
		String frameFour = "//frame[@src='frame_4.html']";
		String frameFive = "//frame[@src='frame_5.html']";

		// switching to frameOne
		driver.switchTo().frame(driver.findElement(By.xpath(frameOne)));
		driver.findElement(By.xpath("//input[@name='mytext1']")).sendKeys("FRAME ONE");

		// switching to basepage
		driver.switchTo().defaultContent();

		// switching to frameTwo
		driver.switchTo().frame(driver.findElement(By.xpath(frameTwo)));
		driver.findElement(By.xpath("//input[@name='mytext2']")).sendKeys("FRAME TWO");

		// switching to basepage
		driver.switchTo().defaultContent();

		// switching to frameFour
		driver.switchTo().frame(driver.findElement(By.xpath(frameFour)));
		driver.findElement(By.xpath("//input[@name='mytext4']")).sendKeys("FRAME FOUR");

		// switching to basepage
		driver.switchTo().defaultContent();

		// switching to frameFive
		driver.switchTo().frame(driver.findElement(By.xpath(frameFive)));
		driver.findElement(By.xpath("//input[@name='mytext5']")).sendKeys("FRAME FIVE");

		// switching to basepage
		driver.switchTo().defaultContent();

		driver.quit();
	}

}
