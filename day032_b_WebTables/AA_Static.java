package day032_b_WebTables;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class AA_Static {

	public static void main(String[] args) {

		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://testautomationpractice.blogspot.com/");

		String tablePath = "//table[@name='BookTable']";
// finding the total no of rows in table
		// Type 1
		int tableRowsize = driver.findElements(By.xpath(tablePath.concat("//tr"))).size();
		System.out.println("No. of rows in the table: " + tableRowsize);

		// Type 2
		System.out.println(
				"No. of all the rows in the page (by tagName): " + driver.findElements(By.tagName("tr")).size());

// finding the no of columns in the table
		// Type 1
		int tableColumnSize = driver.findElements(By.xpath(tablePath.concat("//th"))).size();
		System.out.println("No of columns in the table : " + tableColumnSize);

		// Type 2
		System.out.println(
				"No. of all the columns in the page (by tagName): " + driver.findElements(By.tagName("th")).size());

		driver.quit();

	}

}
