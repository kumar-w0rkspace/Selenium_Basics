package day032_b_WebTables;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class Xeg_AA_c_ConditionalDataPull {

	public static void main(String[] args) {
		// find the total price of books
		// the answer should equate to 7100

		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://testautomationpractice.blogspot.com/");

		String tableElement = "//table[@name='BookTable']";
		int totalBookPrice = 0;
		int rows = driver.findElements(By.xpath(tableElement.concat("//tr"))).size();
		for (int row = 2; row <= rows; row++) {
			String bookPrice = driver.findElement(By.xpath(tableElement.concat("//tr[" + row + "]//td[4]"))).getText();
			totalBookPrice += Integer.parseInt(bookPrice);
		}
		System.out.println("The total cost for books are: " + totalBookPrice); // 7100
		driver.quit();
	}

}
