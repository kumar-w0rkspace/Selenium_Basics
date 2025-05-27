package day035_Action_s;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

public class AD_DragAndDrop {

	public static void main(String[] args) {
		// navigate to baseurl
		// drag the element and drop into provided spacs

		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		String baseUrl = "https://testautomationpractice.blogspot.com/";
		driver.get(baseUrl);

		WebElement elementToDrag = driver.findElement(By.xpath("//div[@id='draggable']"));
		WebElement placeToDrop = driver.findElement(By.xpath("//div[@id='droppable']"));

		Actions act = new Actions(driver);

		act.dragAndDrop(elementToDrag, placeToDrop).perform();
	}

}
