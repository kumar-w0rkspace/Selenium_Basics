package day030_Frames_iFrames;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class AA_Frames {
	public static void main(String[] args) {

		String baseUrl = "https://ui.vision/demo/webtest/frames/";

		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.get(baseUrl);

		WebElement frame1 = driver.findElement(By.xpath("//frame[@src='frame_1.html']"));
		// saving the whole frame into a webelement

		driver.switchTo().frame(frame1);
		String frameOneText = "//input[@name='mytext1']";
		driver.findElement(By.xpath(frameOneText)).sendKeys("Random Name");
		driver.switchTo().defaultContent(); // going back to main page
		System.out.println(driver.getTitle());

		WebElement frame2 = driver.findElement(By.xpath("//frame[@src = 'frame_2.html']"));
		String frameTextTwo = "//input[@name='mytext2']";

		driver.switchTo().frame(frame2).findElement(By.xpath(frameTextTwo)).sendKeys("Selenium");

		driver.quit();
	}
}
