package day032_b_WebTables;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class Xeg_xa_BlazeDemo {

	public static void main(String[] args) {
		/*
		 * 1> go to https://blazedemo.com/ 
		 * 2> select departure, destination 
		 * 3> find available flights 
		 * 4> find lowest price from table (HINT : data to array ,then sort, then pick first value) 
		 * 5> choose flight with low cost 
		 * 6> fill all the dummy data fields >> click checkbox✔️ >> purchase flight 
		 * 7> validate the "Thank you for your purchase today!" message. 
		 * 8> capture the ticket details (ID to Date)
		 */
		
		// exercise to get familiar with multiple topics
		
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		String baseUrl = "https://blazedemo.com/";
		String tableElement = "//table[@class='table']";
		String priceArray[] = new String[5];
		driver.get(baseUrl);
		driver.findElement(By.xpath("//input[@value='Find Flights']")).click();
		int rows = driver.findElements(By.xpath(tableElement.concat("//tr"))).size();
		//System.out.println("Rows size: " + rows);

		for (int row = 1; row < rows; row++) {
			String price = driver.findElement(By.xpath(tableElement.concat("//tr[" + row + "]//td[6]"))).getText();
			priceArray[row - 1] = price;
		}

		Arrays.sort(priceArray);
		System.out.println("The lowest value ticket is " + priceArray[0]);
		List<WebElement> priceList = driver.findElements(By.xpath(tableElement.concat("//tr//td[6]")));
		try {
			for (WebElement pl : priceList) {
				String priceElement = pl.getText();
				if (priceElement.equalsIgnoreCase(priceArray[0])) {
					driver.findElement(By.xpath(tableElement.concat("//tr//td[1]"))).click();
				}
			}
		} catch (StaleElementReferenceException e) {
			//System.out.println(e.getMessage());
		}

		driver.findElement(By.xpath("//input[@id='inputName']")).sendKeys("Guy Name");
		driver.findElement(By.xpath("//input[@id='address']")).sendKeys("Address lane 1, Address lane 2");
		driver.findElement(By.xpath("//input[@id='city']")).sendKeys("City Details");
		driver.findElement(By.xpath("//input[@id='state']")).sendKeys("State Details");
		driver.findElement(By.xpath("//input[@id='zipCode']")).sendKeys("32542");
		driver.findElement(By.xpath("//input[@id='creditCardNumber']")).sendKeys("1233");
		driver.findElement(By.xpath("//input[@id='nameOnCard']")).sendKeys("Doe's Card");
		driver.findElement(By.xpath("//input[@id='rememberMe']")).click();
		driver.findElement(By.xpath("//input[@value='Purchase Flight']")).click();

		System.out.println("Validation message: "+ driver.findElement(By.xpath("//div[@class='container hero-unit']//h1")).getText());
		int r = driver.findElements(By.xpath("//table[@class='table']//tbody//tr")).size();
		int c = driver.findElements(By.xpath("//table[@class='table']//tr[1]/td")).size();
		//System.out.println(r + " " + c);

		for (int i = 1; i <= r; i++) {
			System.out.println(" ");
			for (int j = 1; j <= c; j++) {
				String temp = driver.findElement(By.xpath("//table[@class='table']//tr[" + i + "]/td[" + j + "]"))
						.getText();
				System.out.print(temp + "\t");
			}
		}

		driver.quit();

	}

}
