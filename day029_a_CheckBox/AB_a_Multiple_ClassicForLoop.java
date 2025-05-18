package day029_a_CheckBox;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class AB_a_Multiple_ClassicForLoop {

	public static void main(String[] args) {

		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		String baseUrl = "https://testautomationpractice.blogspot.com/";
		driver.get(baseUrl);

		// Note - find common xpath for all element, iterate with forloop and click

		String daysElement = "//input[@class='form-check-input' and @type= 'checkbox']";

		List<WebElement> days = driver.findElements(By.xpath(daysElement));

		System.out.println(days.size());
		// for loop

		for (int i = 0; i < days.size(); i++) {
			days.get(i).click();
		}
		driver.quit();
	}

}
