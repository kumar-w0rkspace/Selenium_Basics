package day035_Action_s;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

public class Xeg_AC_DoubleClick_Verify {

	public static void main(String[] args) throws InterruptedException {
		// enter text
		// double click copy
		// verify both text fields

		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		String baseUrl = "https://testautomationpractice.blogspot.com/";
		driver.get(baseUrl);

		WebElement textBox1 = driver.findElement(By.xpath("//input[@id='field1']"));
		WebElement textBox2 = driver.findElement(By.xpath("//input[@id='field2']"));
		WebElement button = driver.findElement(By.xpath("//button[normalize-space()='Copy Text']"));
		textBox1.clear();
		textBox1.sendKeys("This is an auto-generated text");

		Actions act = new Actions(driver);
		act.doubleClick(button).perform();
		// Verification
		String textB1 = textBox1.getDomProperty("value");
		String textB2 = textBox2.getDomProperty("value");

		if (textB2.equals(textB1)) {
			System.out.println("Text copied successfully");
		} else {
			System.out.println("Text copy unsuccessfull");
		}

		Thread.sleep(3000);
		driver.quit();

	}

}
