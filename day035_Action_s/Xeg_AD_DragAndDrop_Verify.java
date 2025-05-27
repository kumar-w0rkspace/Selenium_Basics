package day035_Action_s;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

public class Xeg_AD_DragAndDrop_Verify {

	public static void main(String[] args) throws InterruptedException {
		// navigate https://techbeamers.com/selenium-practice-test-page/
		// drag all the dragable elements and drop them at space provided

		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		String baseUrl = "https://techbeamers.com/selenium-practice-test-page/";
		driver.get(baseUrl);

		WebElement firstItem = driver.findElement(By.xpath("//div[@id='item1']"));
		WebElement secondItem = driver.findElement(By.xpath("//div[@id='item2']"));
		WebElement thirdItem = driver.findElement(By.xpath("//div[@id='item3']"));
		WebElement dropZone = driver.findElement(By.xpath("//div[@id='dropzone']"));

		Actions act = new Actions(driver);
		act.dragAndDrop(firstItem, dropZone).perform();
		Thread.sleep(500);
		act.dragAndDrop(secondItem, dropZone).perform();
		Thread.sleep(500);
		act.dragAndDrop(thirdItem, dropZone).perform();
		Thread.sleep(500);
		driver.quit();

	}

}
