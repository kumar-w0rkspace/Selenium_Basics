package day034_DatePickers_Calenders;

import java.time.Duration;
import java.time.Month;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;

public class AC_b_DatePicker_Map_Reusable {
	static Month convertMonth(String month) {
		HashMap<String, Month> monthMap = new HashMap<String, Month>();
		monthMap.put("Jan", Month.JANUARY);
		monthMap.put("Feb", Month.FEBRUARY);
		monthMap.put("Mar", Month.MARCH);
		monthMap.put("Apr", Month.APRIL);
		monthMap.put("May", Month.MAY);
		monthMap.put("Jun", Month.JUNE);
		monthMap.put("Jul", Month.JULY);
		monthMap.put("Aug", Month.AUGUST);
		monthMap.put("Sep", Month.SEPTEMBER);
		monthMap.put("Oct", Month.OCTOBER);
		monthMap.put("Nov", Month.NOVEMBER);
		monthMap.put("Dec", Month.DECEMBER);

		Month monthValue = monthMap.get(month);
		if (monthValue == null) {
			System.out.println("Invalid month..");
		}

		return monthValue;
	}

	static void selectDate(WebDriver driver, String reqYear, String reqMonth, String reqDay) {

		WebElement yearDropDown = driver.findElement(By.xpath("//select[@class='ui-datepicker-year']"));
		Select selectYear = new Select(yearDropDown);
		selectYear.selectByVisibleText(reqYear);
		while (true) {
			String currentMonth = driver
					.findElement(By.xpath("//select[@aria-label='Select month']/option[@selected='selected']"))
					.getText();
			Month expectedMonth = convertMonth(reqMonth);
			Month monthDisplayed = convertMonth(currentMonth);
			System.out.println(expectedMonth.toString());
			System.out.println(monthDisplayed.toString());
			int result = expectedMonth.compareTo(monthDisplayed);

			if (result < 0) {
				driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-w']")).click();
			} else if (result > 0) {
				driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-e']")).click();
			} else {
				break;
			}
			List<WebElement> allDates = driver
					.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//tbody//tr//td//a"));
			for (WebElement date : allDates) {
				if (date.getText().equals(reqDay)) {
					date.click();
					break;
				}
			}
		}
	}

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		String baseUrl = "https://testautomationpractice.blogspot.com/";
		driver.get(baseUrl);
		// Required input DOB
		String reqYear = "2022";
		String reqMonth = "Feb";
		String reqDay = "17";

		driver.findElement(By.xpath("//input[@id='txtDate']")).click();
		selectDate(driver, reqYear, reqMonth, reqDay);

		Thread.sleep(5000);
		driver.quit();

	}

}
