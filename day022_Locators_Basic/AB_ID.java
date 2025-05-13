package day022_Locators_Basic;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class AB_ID {

	public static void main(String[] args) {

		WebDriver driver = new EdgeDriver();

		// find element by ID
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.findElement(By.id("textarea")).sendKeys("This is my random address");

// 		  checking another website if it is displaying logo
//		  driver.get("https://demoblaze.com/");
//		  boolean logoDisplayStat = driver.findElement(By.id("nava")).isDisplayed();
//		  System.out.println(logoDisplayStat);
//		 

	}

}
