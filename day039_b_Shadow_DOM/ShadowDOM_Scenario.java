package day039_b_Shadow_DOM;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class ShadowDOM_Scenario {
	static void preReq(WebDriver driver) {
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	public static void main(String[] args) throws InterruptedException {
		// https://books-pwakit.appspot.com/
		// input data into the search field and search

		WebDriver driver = new EdgeDriver();
		preReq(driver);
		String baseUrl = "https://books-pwakit.appspot.com/";
		driver.get(baseUrl);
		SearchContext shadow = driver.findElement(By.cssSelector("book-app[apptitle='BOOKS']")).getShadowRoot();
		shadow.findElement(By.cssSelector("#input")).sendKeys("Game of Thrones");
		SearchContext shadow1 = shadow.findElement(By.cssSelector("book-input-decorator")).getShadowRoot();
		String searchBtnPath = "svg[viewBox='0 0 24 24']";
		shadow1.findElement(By.cssSelector(searchBtnPath)).click();
		Thread.sleep(5000);
		driver.quit();
	}

}
