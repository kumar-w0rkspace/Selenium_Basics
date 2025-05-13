package day022_Locators_Basic;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class AA_Name {

	public static void main(String[] args) {

		WebDriver driver = new EdgeDriver();
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
		
		// finding element by name
		WebElement element = driver.findElement(By.name("input1")); // returns a webelement
		
		element.sendKeys("test");

	}

}
