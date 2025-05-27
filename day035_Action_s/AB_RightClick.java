package day035_Action_s;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

public class AB_RightClick {

	public static void main(String[] args) throws InterruptedException {

		// https://swisnl.github.io/jQuery-contextMenu/demo.html
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		String baseUrl = "https://swisnl.github.io/jQuery-contextMenu/demo.html";
		driver.get(baseUrl);
		WebElement rightClickElement = driver
				.findElement(By.xpath("//span[@class='context-menu-one btn btn-neutral']"));
		WebElement copyOption = driver.findElement(By.xpath("//span[normalize-space()='Copy']"));

		Actions act = new Actions(driver);
		act.contextClick(rightClickElement).moveToElement(copyOption).click().perform();

		System.out.println(driver.switchTo().alert().getText()); // getting alert text
		Thread.sleep(3000); // intentional pause
		driver.switchTo().alert().dismiss(); // dismissing alert
		driver.quit();

	}

}
