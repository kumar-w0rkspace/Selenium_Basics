package day035_Action_s;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class Xeg_xx_MouseActions {

	static void preReq(WebDriver driver) {
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	public static void main(String[] args) throws InterruptedException {
		// navigate https://demo.guru99.com/test/drag_drop.html
		// drag and drop the items correctly

		WebDriver driver = new EdgeDriver();
		preReq(driver);
		String baseUrl = "https://demo.guru99.com/test/drag_drop.html";
		String bankElement = "//li[@class='block14 ui-draggable']";
		String salesElement = "//li[@class='block15 ui-draggable']";
		String moneyElement = "//li[@class='block13 ui-draggable'][1]";
		String bankEleDesti = "//ol[@id='bank']//li[@class='placeholder']";
		String moneyEleDesti1 = "//ol[@id='amt7']//li[@class='placeholder']";
		String salesEleDesti = "//ol[@id='loan']//li[@class='placeholder']";
		String moneyEleDesti2 = "//ol[@id='amt8']//li[@class='placeholder']";

		driver.get(baseUrl);

		Actions myAct = new Actions(driver);
		myAct.dragAndDrop(driver.findElement(By.xpath(bankElement)), driver.findElement(By.xpath(bankEleDesti)))
				.perform();
		Thread.sleep(500);
		myAct.dragAndDrop(driver.findElement(By.xpath(moneyElement)), driver.findElement(By.xpath(moneyEleDesti1)))
				.perform();
		Thread.sleep(500);
		myAct.dragAndDrop(driver.findElement(By.xpath(salesElement)), driver.findElement(By.xpath(salesEleDesti)))
				.perform();
		Thread.sleep(500);
		myAct.dragAndDrop(driver.findElement(By.xpath(moneyElement)), driver.findElement(By.xpath(moneyEleDesti2)))
				.perform();

		Thread.sleep(5000);
		driver.quit();
	}

}
