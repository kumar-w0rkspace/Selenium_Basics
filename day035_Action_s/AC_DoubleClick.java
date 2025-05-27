package day035_Action_s;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

public class AC_DoubleClick {

	public static void main(String[] args) throws InterruptedException {
		// double click on the field and find the text in the field

		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		String baseUrl = "https://testautomationpractice.blogspot.com/";
		String dblClkPath = "//button[@ondblclick='myFunction1()']";

		driver.get(baseUrl);
		WebElement dblClkElement = driver.findElement(By.xpath(dblClkPath));

		Actions act = new Actions(driver);
		act.doubleClick(dblClkElement).perform();
		Thread.sleep(3000);
		driver.quit();

	}

}
