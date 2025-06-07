package day036_Sliders_KeyBoardActions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

public class Xeg_aa_Slider_Test {

	static void preReq(WebDriver driver) {
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	public static void main(String[] args) {
		// navigate - https://testautomationpractice.blogspot.com/
		// move the sliders (just move element interaction and logic objective)

		WebDriver driver = new EdgeDriver();
		preReq(driver);
		String baseUrl = "https://testautomationpractice.blogspot.com/";
		driver.get(baseUrl);
		WebElement minSlider = driver.findElement(By.xpath("//div[@id='HTML7']//span[1]"));
		WebElement maxSlider = driver.findElement(By.xpath("//div[@id='HTML7']//span[2]"));
		System.out.println("Min Slider Location: " + minSlider.getLocation()); // (1092, 2020)
		System.out.println("Max slider Location: " + maxSlider.getLocation()); // (1222, 2020)
		Actions myAct = new Actions(driver);
		myAct.dragAndDropBy(minSlider, 100, 2020).perform();
		myAct.dragAndDropBy(maxSlider, -50, 2020).perform();
		System.out.println(minSlider.getLocation() + " " + maxSlider.getLocation());
	}

}
