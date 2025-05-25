package day033_Paginated_Dynamic_WebTables;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class AA_a_Handling_Dynamic {
	public static void main(String[] args) {

		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		String baseUrl = "https://practice.expandtesting.com/dynamic-pagination-table";
		driver.get(baseUrl);
		// getting number of pages 
		String text = driver.findElement(By.xpath("//div[@class='dataTables_paginate paging_simple_numbers']//li[5]/a"))
				.getText();
		int numberOfPages = Integer.parseInt(text);
		int rows = driver.findElements(By.xpath("//tbody//tr")).size();
		// clicking pages using loop

		for (int i = 1; i <= numberOfPages; i++) {

			if (i > 1) {
				WebElement pageClicked = driver
						.findElement(By.xpath("//ul[@class='pagination']//*[text()='" + i + "']"));
				pageClicked.click();
			}
			try { // reading data from first two columnsF
				for (int row = 1; row <= rows; row++) {
					String name = driver.findElement(By.xpath("//tbody//tr[" + row + "]/td[1]")).getText();
					String gender = driver.findElement(By.xpath("//tbody//tr[" + row + "]/td[2]")).getText();
					System.out.println(name + "\t" + gender);
				}
			} catch (NoSuchElementException e) {
				System.out.println("Only one row in last page");
			}
		}

		driver.quit();
	}
}
