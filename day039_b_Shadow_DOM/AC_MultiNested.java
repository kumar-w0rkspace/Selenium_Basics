package day039_b_Shadow_DOM;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class AC_MultiNested {
	public static void preReq(WebDriver driver) {
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	public static void main(String[] args) {
		// print Multi-nested Shadow Element in console
		WebDriver driver = new EdgeDriver();
		preReq(driver);
		String baseUrl = "https://dev.automationtesting.in/shadow-dom";
		driver.get(baseUrl);
// via SelectorsHub
		SearchContext shadowHost1 = driver.findElement(By.cssSelector("#shadow-root")).getShadowRoot();
		SearchContext shadowHost2 = shadowHost1.findElement(By.cssSelector("#inner-shadow-dom")).getShadowRoot();
		SearchContext shadowHost3 = shadowHost2.findElement(By.cssSelector("#nested-shadow-dom")).getShadowRoot();
		WebElement multiNestedElement = shadowHost3.findElement(By.cssSelector("#multi-nested-shadow-element"));
		System.out.println(multiNestedElement.getText());

		driver.quit();
	}

}
