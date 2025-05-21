package day032_b_WebTables;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class Xeg_AA_b_ConditionalReadData {

	public static void main(String[] args) {
		// Print book names written by Mukesh

		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://testautomationpractice.blogspot.com/");

		String tableElement = "//table[@name='BookTable']";

		int rows = driver.findElements(By.xpath(tableElement.concat("//tr"))).size();
		for (int row = 2; row <= rows; row++) {
			String authorName = driver.findElement(By.xpath(tableElement.concat("//tr[" + row + "]//td[2]"))).getText();
			if (authorName.equalsIgnoreCase("mukesh")) {
				String bookName = driver.findElement(By.xpath(tableElement.concat("//tr[" + row + "]//td[1]")))
						.getText();
				System.out.println(bookName + "-\t" + authorName);
			}
		}
		driver.quit();
	}
}
