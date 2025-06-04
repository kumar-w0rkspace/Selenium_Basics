package day021_SettingUp;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class AB_Initializing {

	public static void main(String[] args) {

		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();

		String webSite = "https://testautomationpractice.blogspot.com/";

		driver.get(webSite);

		WebElement nameElement = driver.findElement(By.id("name"));

		nameElement.sendKeys("Arun Kumar MS");

		WebElement radioElement = driver.findElement(By.id("male"));

		radioElement.click();
		
		String actualTitle = driver.getTitle();
		String expectedTitle = "Automation Testing Practice";
		
		if (actualTitle.equals(expectedTitle)) System.out.println("Titles match, Pass");
		else System.out.println("Title mismatch, Fail");
		

	}

}
