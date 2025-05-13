package day022_Locators_Basic;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class AD_ClassName {

	public static void main(String[] args) {
		// eg for elements that can use class name - radio buttons, dropdowns etc

		WebDriver driver = new EdgeDriver();

		driver.get("https://demoblaze.com/");

		// by class name
		List<WebElement> items = driver.findElements(By.className("list-group-item"));
		System.out.println(items.size()); // 4

		// List<WebElement> headerItems = driver.findElements(By.className("nav-item"));

		System.out.println(driver.findElements(By.className("nav-item")).size()); // 8

	}

}
