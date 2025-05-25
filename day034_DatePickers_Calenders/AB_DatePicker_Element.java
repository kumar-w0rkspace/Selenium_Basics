package day034_DatePickers_Calenders;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class AB_DatePicker_Element {
	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		String baseUrl = "https://jqueryui.com/datepicker/";
		driver.get(baseUrl);
		driver.switchTo().frame(0);
		// poping datepicker element and selecting the date via element
		WebElement dateField = driver.findElement(By.xpath("//input[@id='datepicker']"));
		dateField.click();

		// Note - capture the month and year on date element and compare it to our data.
		// while loop is prefered since we dont know how many loops it take

		// capturing month and year from element
		String monthElement = "//div[@class='ui-datepicker-title']/span[1]";
		String yearElement = "//div[@class='ui-datepicker-title']/span[2]";
		String dayElement = "//table[@class='ui-datepicker-calendar']//tbody//tr/td/a";
		String year = "2026";
		String month = "June";
		String day = "15";
		// selecting month and year from webpage
		while (true) {
			String capturedMonth = driver.findElement(By.xpath(monthElement)).getText();
			String capturedYear = driver.findElement(By.xpath(yearElement)).getText();

			if (capturedMonth.equals(month) && capturedYear.equals(year))
				break; // exit from loop
			driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-e']")).click(); // next

			// selecting day by foreach loop
			List<WebElement> dayElements = driver.findElements(By.xpath(dayElement));
			for (WebElement dayEle : dayElements) {
				if (dayEle.getText().equals(day)) {
					dayEle.click();
					break;
				}
			}
			Thread.sleep(5000);
			driver.quit();
		}
	}
}
