package day032_b_WebTables;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class Xeg_AA_a_ReadData {

	public static void main(String[] args) {

		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://testautomationpractice.blogspot.com/");

// Read the data from third row, second column (output should be "Animesh")
		String tableElement = "//table[@name='BookTable']";
		System.out.println("Data from Third row, and Second column: "
				+ driver.findElement(By.xpath(tableElement.concat("//tr[4]/td[2]"))).getText());
// size of rows
		int rows = driver.findElements(By.xpath(tableElement.concat("//tr"))).size();
		int cols = driver.findElements(By.xpath(tableElement.concat("//tr[2]//td"))).size();

// read all data from the table
		for (int row = 2; row <= rows; row++) {

			for (int col = 1; col <= cols; col++) {
				String dataValue = driver
						.findElement(By.xpath(tableElement.concat("//tr[" + row + "]/td[" + col + "]"))).getText();
				System.out.print(dataValue + "\t");
			}
			System.out.println();
		}

		driver.quit();
	}

}
