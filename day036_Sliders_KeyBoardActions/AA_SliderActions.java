package day036_Sliders_KeyBoardActions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

public class AA_SliderActions {

	static void preReq(WebDriver driver) {
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	public static void main(String[] args) {

		WebDriver driver = new EdgeDriver();

		String baseUrl = "https://www.jqueryscript.net/demo/Price-Range-Slider-jQuery-UI/";
		preReq(driver);
		driver.get(baseUrl);
		WebElement minSlider = driver.findElement(By.xpath("//span[1]"));
		WebElement maxSlider = driver.findElement(By.xpath("//span[2]"));
		// getting the location of minSlider web element
		System.out.println("Default location of Min slider: " + minSlider.getLocation()); // before moving
		System.out.println("Default location of Max slider: " + maxSlider.getLocation()); // before moving
		// returns a Point type object
//		System.out.println("X axis Location of the min slider is " + minSlider.getLocation().getX());
		// returns the x axis location
//		System.out.println("Y axis Location of the min slider is " + minSlider.getLocation().getY());
		// returns the y axis location

		Actions act = new Actions(driver);
		act.dragAndDropBy(minSlider, 100, 194).perform();
		System.out.println(minSlider.getLocation()); // after moving 100 points
		act.dragAndDropBy(maxSlider, -100, 194).perform();
		System.out.println(maxSlider.getLocation()); // after moving 100 points backwards

		 driver.quit();
	}

}
