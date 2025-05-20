package day031_DropDown;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class AC_Hidden {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		String baseUrl = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
		String hiddenDropDown = "//div[@class='oxd-select-dropdown --positon-bottom']/div[4]";

		driver.get(baseUrl);
		driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("Admin");
		driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("admin123");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		driver.findElement(By.xpath("//ul[@class='oxd-main-menu']//li[2]")).click();

		// locating the dropdown element
		driver.findElement(By.xpath("//div[@class='oxd-select-text-input']")).click();
		Thread.sleep(5000);
		// count total options (after expanding the dropdown)
		List<WebElement> elements = driver.findElements(By.xpath("//div[@role='listbox']//span"));
		System.out.println(elements.size());

		// printing all elements
		for (WebElement element : elements) {
			System.out.println(element.getText());
		}
		// selecting option from hidden dropdown
		driver.findElement(By.xpath(hiddenDropDown)).click();

		driver.findElement(By.xpath("//button[@type='submit']")).click();

		System.out.println(driver.findElement(By.xpath("//span[@class='oxd-text oxd-text--span']")).getText());
		System.out.println(driver
				.findElement(By.xpath("//div[@role='row' and contains(@class, 'clickable')]//div[3]/div")).getText());

		driver.quit();
	}

}
