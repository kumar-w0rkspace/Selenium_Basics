package day039_b_Shadow_DOM;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class Xeg_ab_Nested_WithoutVariables {
	public static void preReq(WebDriver driver) {
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	public static void main(String[] args) {
		// print Nested Shadow Element in console
		WebDriver driver = new EdgeDriver();
		preReq(driver);
		String baseUrl = "https://dev.automationtesting.in/shadow-dom";
		driver.get(baseUrl);

		String nestedElementText = driver.findElement(By.cssSelector("#shadow-root")).getShadowRoot()
				.findElement(By.cssSelector("#inner-shadow-dom")).getShadowRoot()
				.findElement(By.cssSelector("#nested-shadow-element")).getText();
		System.out.println(nestedElementText);
		driver.quit();

	}

}
