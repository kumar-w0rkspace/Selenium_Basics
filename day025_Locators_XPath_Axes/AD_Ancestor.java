package day025_Locators_XPath_Axes;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class AD_Ancestor {

	public static void main(String[] args) {

		String xPathAncestor = "//*[@id='txt_comment']/ancestor::div";
		String baseUrl = "https://katalon-demo-cura.herokuapp.com/";

		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		driver.get(baseUrl);
		driver.findElement(By.xpath("//a[@id='btn-make-appointment']")).click();
//		
//		
		driver.findElement(By.xpath("//input[@id='txt-username']")).sendKeys("John Doe");
		driver.findElement(By.xpath("//input[@id='txt-password']")).sendKeys("ThisIsNotAPassword");
		driver.findElement(By.xpath("//button[@id='btn-login']")).click();
		List<WebElement> elements = driver.findElements(By.xpath(xPathAncestor));

		System.out.println(elements.size());
		driver.quit();
	}

}
