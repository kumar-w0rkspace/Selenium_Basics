package day039_b_Shadow_DOM;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class AA_Basic {
	static void preReq(WebDriver driver) {
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	public static void main(String[] args) {
		// https://dev.automationtesting.in/shadow-dom
		// get the text 'Shadow Element' on console

		WebDriver driver = new EdgeDriver();
		preReq(driver);
		String baseUrl = "https://dev.automationtesting.in/shadow-dom";
		driver.get(baseUrl);
// capturing the shadow host (Selectors hub can help with code generation)
// Note - we can only get the shadow dom elements by CSS selector
		String cssSelectorHost1 = "#shadow-root";
		SearchContext shadowRootHost1 = driver.findElement(By.cssSelector(cssSelectorHost1)).getShadowRoot();
		WebElement host1Element = shadowRootHost1.findElement(By.cssSelector("#shadow-element"));
		System.out.println(host1Element.getText());

		driver.quit();
	}

}
