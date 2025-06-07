package day036_Sliders_KeyBoardActions;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

public class AC_a_Open_NewTab_KeyBoardAction {
	static void preReq(WebDriver driver) {
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	public static void main(String[] args) throws InterruptedException {
		// navigate https://testautomationpractice.blogspot.com/
		// click on the home link and open new tab keeping the parent window
		// use ctrl + click to open new tab in the background
		// switch to the second window and get title

		WebDriver driver = new EdgeDriver();
		preReq(driver);
		driver.get("https://testautomationpractice.blogspot.com/");
		System.out.println("Main Window " + driver.getTitle());
		WebElement pageToOpen = driver.findElement(By.xpath("//a[normalize-space()='Online Trainings']"));
		Actions act = new Actions(driver);
		act.keyDown(Keys.CONTROL).click(pageToOpen).keyUp(Keys.CONTROL).perform();
		List<String> windowsList = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(windowsList.get(1));
		System.out.println("Secondary Window " + driver.getTitle());
		System.out.println(driver.findElement(By.xpath("//p[@class='description']/span")).getText());
		driver.switchTo().window(windowsList.get(0));
		System.out.println(driver.getTitle());
		driver.quit();
	}

}
