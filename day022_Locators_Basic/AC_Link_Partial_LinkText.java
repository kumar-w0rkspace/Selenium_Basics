package day022_Locators_Basic;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class AC_Link_Partial_LinkText {

	public static void main(String[] args) {

		WebDriver driver = new EdgeDriver();

		driver.get("https://testautomationpractice.blogspot.com/");

		// linkText

		driver.findElement(By.linkText("Udemy Courses")).click();
		System.out.println(driver.getTitle()); // SDET-QA: Udemy Courses

		// partial linkText

		driver.navigate().back();
		driver.findElement(By.partialLinkText("ightPr")).click();
		System.out.println(driver.getTitle()); // Automation Testing Practice: PlaywrightPractice
		
		driver.quit();
	}

}
