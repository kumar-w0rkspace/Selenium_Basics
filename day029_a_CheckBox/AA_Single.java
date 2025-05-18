package day029_a_CheckBox;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class AA_Single {

	public static void main(String[] args) throws InterruptedException {
		
		// handling single checkboxes / radio buttons
		
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		String baseUrl = "https://testautomationpractice.blogspot.com/";
		driver.get(baseUrl);
		String maleRadioBtn = "//*[@id='male']";
		String sundayBox = "//input[@id='sunday']";
		
		driver.findElement(By.xpath(maleRadioBtn)).click();
		
		driver.findElement(By.xpath(sundayBox)).click();
		
		Thread.sleep(5000); // intentional pause
		
		driver.quit();

	}

}
