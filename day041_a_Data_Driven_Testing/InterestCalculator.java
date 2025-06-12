package day041_a_Data_Driven_Testing;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class InterestCalculator {
	static void preReq(WebDriver driver) {
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	public static void main(String[] args) throws IOException, InterruptedException {

		WebDriver driver = new FirefoxDriver();
		preReq(driver);
		String baseUrl = "https://www.moneycontrol.com/fixed-income/calculator/state-bank-of-india-sbi/fixed-deposit-calculator-SBI-BSB001.html";
		driver.get(baseUrl);
		String filePath = System.getProperty("user.dir") + "\\TestData\\IntrestCalcTC.xlsx";
		int rows = Utility_Excel.getRowCount(filePath, "Sheet1");
		for (int i = 1; i <= rows; i++) {
// read data from excel
			String principalAmount = Utility_Excel.getCellData(filePath, "Sheet1", i, 0);
			String rateOfInterest = Utility_Excel.getCellData(filePath, "Sheet1", i, 1);
			String periodInt = Utility_Excel.getCellData(filePath, "Sheet1", i, 2);
			String periodDuration = Utility_Excel.getCellData(filePath, "Sheet1", i, 3);
			String frequency = Utility_Excel.getCellData(filePath, "Sheet1", i, 4);
			String expectedMaturityVal = Utility_Excel.getCellData(filePath, "Sheet1", i, 5);

// pass above data into app
			driver.findElement(By.xpath("//input[@id='principal']")).sendKeys(principalAmount);
			driver.findElement(By.xpath("//input[@id='interest']")).sendKeys(rateOfInterest);
			driver.findElement(By.xpath("//input[@id='tenure']")).sendKeys(periodInt);

			Select tenureDD = new Select(driver.findElement(By.xpath("//select[@id='tenurePeriod']")));
			tenureDD.selectByVisibleText(periodDuration);
			Select frequencyDD = new Select(driver.findElement(By.xpath("//select[@id='frequency']")));
			frequencyDD.selectByVisibleText(frequency);
			driver.findElement(By.xpath("//div[@class='cal_div']//a[1]")).click(); // calculate btn

// validation
			String actualMaturityVal = driver.findElement(By.xpath("//span[@id='resp_matval']//strong")).getText();
			if (Double.parseDouble(expectedMaturityVal) == Double.parseDouble(actualMaturityVal)) {
				System.out.println("Test Passed");
				Utility_Excel.setCellData(filePath, "Sheet1", i, 7, "Passed");
				Utility_Excel.fillGreenColor(filePath, "Sheet1", i, 7);
			} else {
				System.out.println("Test Failed");
				Utility_Excel.setCellData(filePath, "Sheet1", i, 7, "Failed");
				Utility_Excel.fillRedColor(filePath, "Sheet1", i, 7);
			}
// clearing data before next round
			Thread.sleep(2500);
			driver.findElement(By.xpath("//img[@class='PL5']")).click();
		}
		driver.close();
	}

}
