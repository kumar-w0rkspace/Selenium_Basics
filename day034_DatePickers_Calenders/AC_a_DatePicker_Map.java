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

public class AC_a_DatePicker_Map {
	// userdefined method to convert string to Month object
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

	public static void main(String[] args) {

		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		String baseUrl = "https://testautomationpractice.blogspot.com/";
		driver.get(baseUrl);

		// Required input DOB
		String reqYear = "2023";
		String reqMonth = "Dec";
		String reqDay = "12";

		driver.findElement(By.xpath("//input[@id='txtDate']")).click();

		WebElement yearDropDown = driver.findElement(By.xpath("//select[@class='ui-datepicker-year']"));
		Select selectYear = new Select(yearDropDown);
		selectYear.selectByVisibleText(reqYear);
		//select month
		while (true) {
			String currentMonth = driver.findElement(By.xpath("//select[@aria-label='Select month']/option[@selected='selected']")).getText();
			
			// converting required and current to month objects
			Month expectedMonth = convertMonth(reqMonth);
			Month monthDisplayed = convertMonth(currentMonth);
			System.out.println(expectedMonth.toString());
			System.out.println(monthDisplayed.toString());
			// comparing
			int result = expectedMonth.compareTo(monthDisplayed);
			/*
			 * Note - if current month is less than 0, then the expected month is past month
			 * Note - if current month is greater than 0, then the expected month is future month
			 * Note - if current month returns 0, then the expected month is current month
			 */

			// if 0, months are equal
			// if > 0, then reqMonth is future
			// if < 0, then reqMonth is past

			if (result < 0) { // past
				driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-w']")).click();
			} else if (result > 0) { // future
				driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-e']")).click();
			} else { // same
				break;
			}
			
			// date
			List<WebElement> allDates = driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//tbody//tr//td//a"));
			for (WebElement date : allDates) {
				if(date.getText().equals(reqDay)) {
					date.click();
					break;
				}
			}
		}

	}

}
