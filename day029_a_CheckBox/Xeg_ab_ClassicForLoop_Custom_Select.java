package day029_a_CheckBox;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class Xeg_ab_ClassicForLoop_Custom_Select {

	public static void main(String[] args) throws InterruptedException {

		// select the first three days
		// select last three days
		// select days from 3 to 5

		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		String baseUrl = "https://testautomationpractice.blogspot.com/";
		driver.get(baseUrl);

		// Note - find common xpath for all element, iterate with forloop and click

		String daysElement = "//input[@class='form-check-input' and @type= 'checkbox']";

		List<WebElement> days = driver.findElements(By.xpath(daysElement));

		System.out.println(days.size());
		// forloop (selecting the first three days)

		for (int i = 0; i < 3; i++) days.get(i).click();
		Thread.sleep(3000); // intentional pause

		// resetting

		for (WebElement day : days) {
			if (day.isSelected()) {
				day.click();
			}
		}

		// forloop (selecting the last three days)
		for (int i = days.size()-1; i >= days.size() - 3; i--) days.get(i).click();
		Thread.sleep(3000); // intentional pause

		// reseting
		for (WebElement day : days) {
			if (day.isSelected()) {
				day.click();
			}
		}

		// forloop (selecting the days from 3 - 5)
		for (int i = 2; i < days.size() - 2; i++) days.get(i).click();
		Thread.sleep(3000); // intentional pause

		driver.quit();

	}

}
