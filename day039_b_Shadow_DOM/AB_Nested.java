package day039_b_Shadow_DOM;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class AB_Nested {

	public static void main(String[] args) throws InterruptedException {
		// print Nested Shadow Element in console
		WebDriver driver = new EdgeDriver();
		preReq(driver);
		String baseUrl = "https://dev.automationtesting.in/shadow-dom";
		driver.get(baseUrl);
// via SelectorsHub		
		// This Element is inside 2 nested shadow DOM. 
		String cssSelectorForHost1 = "#shadow-root";
		String cssSelectorForHost2 = "#inner-shadow-dom";
		SearchContext shadow0 = driver.findElement(By.cssSelector(cssSelectorForHost1)).getShadowRoot();
		SearchContext shadow1 = shadow0.findElement(By.cssSelector(cssSelectorForHost2)).getShadowRoot();
		WebElement nestedElement = shadow1.findElement(By.cssSelector("#nested-shadow-element"));
		System.out.println(nestedElement.getText());
		driver.quit();
	}

	public static void preReq(WebDriver driver) {
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

}
