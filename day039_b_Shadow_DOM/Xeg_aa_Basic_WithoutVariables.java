package day039_b_Shadow_DOM;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class Xeg_aa_Basic_WithoutVariables {
	static void preReq(WebDriver driver) {
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	public static void main(String[] args) {
		// without creating variables

		WebDriver driver = new EdgeDriver();
		preReq(driver);
		String baseUrl = "https://dev.automationtesting.in/shadow-dom";
		driver.get(baseUrl);
		String host1ElementText = driver.findElement(By.cssSelector("#shadow-root")).getShadowRoot()
				.findElement(By.cssSelector("#shadow-element")).getText();
		System.out.println(host1ElementText);

		driver.quit();
	}

}
