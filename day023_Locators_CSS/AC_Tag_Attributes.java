package day023_Locators_CSS;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class AC_Tag_Attributes {

	public static void main(String[] args) {
		// css selector for tag[attribute]

		WebDriver driver = new EdgeDriver();
		String baseUrl = "https://demo.nopcommerce.com/";
		String element = "input[type='text']"; // tag[attribute = 'value']
		String query = "Iphone";
		driver.get(baseUrl);
		driver.findElement(By.cssSelector(element)).sendKeys(query);

	}

}
