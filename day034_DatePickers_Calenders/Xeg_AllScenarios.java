package day034_DatePickers_Calenders;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Xeg_AllScenarios {
	static void preReq(WebDriver driver) {
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	public static void main(String[] args) throws InterruptedException {
		// dummyticket.com/dummy-ticket-for-visa-application/
		// interact the whole elements in the page
		// objective - elements familiarity

		WebDriver driver = new EdgeDriver();
		preReq(driver);

		String baseUrl = "https://www.dummyticket.com/dummy-ticket-for-visa-application/";
		String alertNotice = "added to your order. Complete your order below.";
		String comments = "Lorem ipsum dolor siti whatever";
		String yearOfBirth = "1980";
		String additionalPassenger = "Number of additional passengers: (optional)";

		driver.get(baseUrl);
		System.out.println("Logo is displayed?: " + driver.findElement(By.xpath("//a/img[1]")).isDisplayed());
		driver.findElement(By.xpath("//ul[@id='checkout-products']//input[@id='product_3186']")).click();
		System.out.println("Alert Notice is displayed?: "
				+ driver.findElement(By.xpath("//div[@role='alert']")).getText().contains(alertNotice));
		driver.findElement(By.xpath("//input[@id='travname']")).sendKeys("John");
		driver.findElement(By.xpath("//input[@id='travlastname']")).sendKeys("Doe");
		driver.findElement(By.xpath("//textarea[@id='order_comments']")).sendKeys(comments);
		driver.findElement(By.xpath("//input[@id='dob']")).click();
		Select yearDropDown = new Select(
				driver.findElement(By.xpath("//div[@id='ui-datepicker-div']//select[@aria-label='Select year']")));
		yearDropDown.selectByValue(yearOfBirth);
		Select monthDropDown = new Select(
				driver.findElement(By.xpath("//div[@id='ui-datepicker-div']//select[@aria-label='Select month']")));
		monthDropDown.selectByValue("2");
		List<WebElement> days = driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//tr/td"));
		for (WebElement day : days) {
			if (day.getText().equals("12")) {
				day.click();
				break;
			}
		}

		driver.findElement(By.xpath("//input[@id='sex_1']")).click();
//		Actions myAct = new Actions(driver);
//		myAct.moveToElement(driver.findElement(By.xpath("//input[@id='addmorepax']"))).click().perform();
//		System.out.println("Add more passengers notice present?: "
//				+ driver.findElement(By.xpath("//label[@for='addpaxno']")).getText().contains(additionalPassenger));
//		driver.findElement(By.xpath("//span[@id='select2-addpaxno-container']")).click();
//		List<WebElement> passengersList = driver.findElements(By.xpath("//ul[@role='listbox']/li"));
//		for (WebElement tempList : passengersList) {
//			if (tempList.getText().contains("add 1 more passenger (100%)")) {
//				tempList.click();
//				break;
//			}
//		}
//		driver.findElement(By.xpath("//input[@id='travname2']")).sendKeys("Jane");
//		driver.findElement(By.xpath("//input[@id='travlastname2']")).sendKeys("Doe");
//		driver.findElement(By.xpath("//input[@id='dob2']")).click();
//		yearDropDown.selectByValue("1981");
//		monthDropDown.selectByValue("2");
//		for (WebElement day : days) {
//			if (day.getText().equals("12")) {
//				day.click();
//				break;
//			}
//		}
//
//		driver.findElement(By.xpath("//input[@id='sex2_2']")).click();
//		driver.findElement(By.xpath("//span[@id='select2-paxtype2-container']")).click();
//		driver.findElement(By.xpath("//ul[@class='select2-results__options']/li[1]")).click();
		driver.findElement(By.xpath("//input[@id='traveltype_2']")).click();
		driver.findElement(By.xpath("//input[@id='fromcity']")).sendKeys("Indianapwolis");
		driver.findElement(By.xpath("//input[@id='tocity']")).sendKeys("Massachoochoosets");
		driver.findElement(By.xpath("//input[@id='departon']")).click();
		Select departureYear = new Select(driver.findElement(By.xpath("//select[@aria-label='Select year']")));
		departureYear.selectByVisibleText("2025");
		Select departureMonth = new Select(driver.findElement(By.xpath("//select[@aria-label='Select month']")));
		departureMonth.selectByVisibleText("Nov");
		List<WebElement> departureDay = driver
				.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//tr/td"));

		for (WebElement day : departureDay) {
			if (day.getText().equals("25")) {
				day.click();
				break;
			}
		}
		driver.findElement(By.xpath("//input[@id='returndate']")).click();
		Select returnYear = new Select(driver.findElement(By.xpath("//select[@aria-label='Select year']")));
		returnYear.selectByContainsVisibleText("2026");
		Select returnMonth = new Select(driver.findElement(By.xpath("//select[@aria-label='Select month']")));
		returnMonth.selectByVisibleText("May");
		List<WebElement> returnDay = driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//tr/td"));
		for (WebElement day : returnDay) {
			if (day.getText().equals("10")) {
				day.click();
				break;
			}
		}
		driver.findElement(By.xpath("//textarea[@id='notes']"))
				.sendKeys("A bunch of additional information through send keys");
		driver.findElement(By.xpath("//span[@id='select2-reasondummy-container']")).click();
		List<WebElement> purposeList = driver.findElements(By.xpath("//ul[@class='select2-results__options']//li"));
		for (WebElement purposeTemp : purposeList) {
			if (purposeTemp.getText().equals("Prank a friend")) {
				purposeTemp.click();
				break;
			}
		}
		driver.findElement(By.xpath("//input[@id='deliverymethod_3']")).click();
		driver.findElement(By.xpath("//input[@id='billname']")).sendKeys("Total OverDoes Company of Doing");
		driver.findElement(By.xpath("//input[@id='billing_phone']")).sendKeys("9876543210");
		driver.findElement(By.xpath("//input[@id='billing_email']")).sendKeys("randomguy@dodomail.com");
		driver.findElement(By.xpath("//span[@id='select2-billing_country-container']")).click();
		List<WebElement> countriesList = driver
				.findElements(By.xpath("//span[@class='select2-dropdown select2-dropdown--below']//ul/li"));
		for (int i = 0; i < countriesList.size(); i++) {
			if (countriesList.get(i).getText().equalsIgnoreCase("India")) {
				countriesList.get(i).click();
				break;
			}
		}
		driver.findElement(By.xpath("//input[@id='billing_address_1']"))
				.sendKeys("Address one, lane two, street three");
		driver.findElement(By.xpath("//input[@id='billing_address_2']")).sendKeys("Apartment number xyz09235");
		driver.findElement(By.xpath("//input[@id='billing_city']")).sendKeys("Town name random junction");
		driver.findElement(By.xpath("//span[@id='select2-billing_state-container']")).click();
		List<WebElement> stateDropList = driver.findElements(By.xpath("//ul[@id='select2-billing_state-results']/li"));
		for (WebElement state : stateDropList) {
			if (state.getText().equals("Kerala")) {
				state.click();
				break;
			}
		}
		driver.findElement(By.xpath("//input[@id='billing_postcode']")).sendKeys("123456");

		System.out.println("Product: " + driver.findElement(By.xpath("//div[@class='product-details']")).getText()
				+ "\n" + "Price: "
				+ (driver.findElement(By.xpath("//div[@class='opc_order_review']//tbody//td[2]/span"))).getText());
		driver.findElement(By.xpath("//button[@id='place_order']")).click();
		Thread.sleep(5000);

		System.out.println(
				"Page redirected to " + driver.findElement(By.xpath("//div[@class='merchant-name']")).getText());
		driver.quit();
	}

}
