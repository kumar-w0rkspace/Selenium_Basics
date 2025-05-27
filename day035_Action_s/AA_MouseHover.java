package day035_Action_s;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

public class AA_MouseHover {

	public static void main(String[] args) {
		// get https://testautomationpractice.blogspot.com/
		// hover mouse at the mouse hover element
		// select laptops
		// hover again
		// select mobiles

		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		String baseUrl = "https://testautomationpractice.blogspot.com/";
		driver.get(baseUrl);

		WebElement button = driver.findElement(By.xpath("//button[@class='dropbtn']"));
		WebElement laptopLink = driver.findElement(By.xpath("//div[@class='dropdown-content']/a[2]"));
		WebElement mobileLink = driver.findElement(By.xpath("//div[@class='dropdown-content']/a[1]"));

		// Actions class object
		Actions action = new Actions(driver);

		// Type 1
		// Mouse Hover action (click included)
		action.moveToElement(button).moveToElement(laptopLink).click().build().perform();

		// Type 2
		// without build
		action.moveToElement(button).moveToElement(mobileLink).click().perform();
		driver.quit();
	}

}
