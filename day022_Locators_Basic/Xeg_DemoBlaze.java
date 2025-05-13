package day022_Locators_Basic;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class Xeg_DemoBlaze {

	public static void main(String[] args) {
		// demoblaze.com
		// total no of links, and print them
		// total no of images
		// click on any product using link / partial link

		WebDriver driver = new EdgeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://demoblaze.com/");

		System.out.println("Total number of links: " + driver.findElements(By.tagName("a")).size());
		System.out.println("Total number of images: " + driver.findElements(By.tagName("img")).size());
		driver.findElement(By.linkText("Iphone 6 32gb")).click(); // linkText action
		System.out.println("Image status displayed? " + driver.findElement(By.tagName("img")).isDisplayed());

		driver.navigate().back();
		driver.findElement(By.partialLinkText("xperia")).click();
		System.out.println(driver.findElement(By.className("name")).getText());

	}

}
