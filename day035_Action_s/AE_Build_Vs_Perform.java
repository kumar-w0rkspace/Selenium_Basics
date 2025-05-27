package day035_Action_s;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class AE_Build_Vs_Perform {

	public static void main(String[] args) {
		// Store actions in a variable and execute it
		// Action vs Actions
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		String baseUrl = "https://swisnl.github.io/jQuery-contextMenu/demo.html";
		driver.get(baseUrl);
		WebElement rcElement = driver.findElement(By.xpath("//span[@class='context-menu-one btn btn-neutral']"));
		WebElement copyOption = driver.findElement(By.xpath("//span[normalize-space()='Copy']"));

		Actions act = new Actions(driver);

		Action act1 = act.contextClick(rcElement).build(); // building an action and storing to a variable
		act1.perform(); // performing the action by calling the method through the Action interface
						// objRef
		Action act2 = act.moveToElement(copyOption).click().build();
		act2.perform();

		Alert tempAlert = driver.switchTo().alert();
		System.out.println(tempAlert.getText());
		tempAlert.dismiss();
		driver.quit();
	}

}
