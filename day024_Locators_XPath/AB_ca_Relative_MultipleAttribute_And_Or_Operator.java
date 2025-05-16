package day024_Locators_XPath;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class AB_ca_Relative_MultipleAttribute_And_Or_Operator {

	public static void main(String[] args) {

		String xPathWithAndOperator = "//textarea[@id='textarea' and @class='form-control']";
		String xPathWithOrOperator = "//*[@placeholder = 'Enter Eail' or @id='email']"; // intentional mistake

		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		String baseUrl = "https://testautomationpractice.blogspot.com/";

		driver.get(baseUrl);

		driver.findElement(By.xpath(xPathWithAndOperator)).sendKeys("Address");
		driver.findElement(By.xpath(xPathWithOrOperator)).sendKeys("randoxyEmail@gmail.com");
		driver.quit();

	}

}
