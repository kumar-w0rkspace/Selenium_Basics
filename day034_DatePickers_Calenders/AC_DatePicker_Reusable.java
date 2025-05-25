package day034_DatePickers_Calenders;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class AC_DatePicker_Reusable {

	// making the datepicker code reusable
	static void selectFutureDate(WebDriver driver, String month, String year, String day) {
		while (true) {
			String capturedMonth = driver.findElement(By.xpath("//div[@class='ui-datepicker-title']/span[1]"))
					.getText();
			String capturedYear = driver.findElement(By.xpath("//div[@class='ui-datepicker-title']/span[2]")).getText();

			if (capturedMonth.equals(month) && capturedYear.equals(year))
				break; // exit from loop
			driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-e']")).click(); // next

		}

		List<WebElement> dayElements = driver
				.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//tbody//tr/td/a"));
		for (WebElement dayEle : dayElements) {
			if (dayEle.getText().equals(day)) {
				dayEle.click();
				break;
			}
		}
	}

	static void selectPastDate(WebDriver driver, String month, String year, String day) {
		while (true) {
			String capturedMonth = driver.findElement(By.xpath("//div[@class='ui-datepicker-title']/span[1]"))
					.getText();
			String capturedYear = driver.findElement(By.xpath("//div[@class='ui-datepicker-title']/span[2]")).getText();

			if (capturedMonth.equals(month) && capturedYear.equals(year))
				break; // exit from loop
			driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-w']")).click(); // previous

		}

		List<WebElement> dayElements = driver
				.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//tbody//tr/td/a"));
		for (WebElement dayEle : dayElements) {
			if (dayEle.getText().equals(day)) {
				dayEle.click();
				break;
			}
		}
	}

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		String baseUrl = "https://jqueryui.com/datepicker/";
		driver.get(baseUrl);
		driver.switchTo().frame(0);
		WebElement dateField = driver.findElement(By.xpath("//input[@id='datepicker']"));
		dateField.click();
		selectFutureDate(driver, "June", "2026", "13");
		dateField.click();
		selectPastDate(driver, "January", "2024", "13");
		Thread.sleep(5000);
		driver.quit();
	}

}
