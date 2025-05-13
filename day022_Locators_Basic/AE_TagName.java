package day022_Locators_Basic;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class AE_TagName {

	public static void main(String[] args) {

		// Tagname could be same for multiple webelements
		
		WebDriver driver = new EdgeDriver();

		// no of links in the page
		driver.get("https://demoblaze.com/");
		List<WebElement> links = driver.findElements(By.tagName("a"));
		System.out.println(links.size()); // 15

		// no of images in the link
		List<WebElement> images = driver.findElements(By.tagName("img"));
		System.out.println(images.size()); // 14

	}

}
