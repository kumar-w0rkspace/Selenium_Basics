package day033_Paginated_Dynamic_WebTables;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class AA_b_Handling_Dynamic_AllData {

	public static void main(String[] args) throws InterruptedException {

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
		int cols = driver.findElements(By.xpath("//tbody//tr[1]/td")).size();
		// clicking pages using loop

		for (int i = 1; i <= numberOfPages; i++) {

			if (i > 1) {
				WebElement pageToClick = driver
						.findElement(By.xpath("//ul[@class='pagination']//*[text()='" + i + "']"));
				pageToClick.click();
				Thread.sleep(500);
			}
			try { // reading data from first two columnsF
				for (int row = 1; row <= rows; row++) {
					for (int col = 1; col <= cols; col++) {
						String temp = driver.findElement(By.xpath("//tbody//tr[" + row + "]/td[" + col + "]"))
								.getText();
						System.out.print(temp + "\t");
					}
					System.out.println(" ");

				}
			} catch (NoSuchElementException e) {
				System.out.println("Only one row in last page");
			}
		}

		driver.quit();

	}

}
