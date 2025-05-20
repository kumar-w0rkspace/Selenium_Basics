package day031_DropDown;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;

public class AA_Select {

	public static void main(String[] args) {

		// Note - there should be select tag for us to use the select class

		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		String baseUrl = "https://testautomationpractice.blogspot.com/";
		driver.get(baseUrl);
		WebElement dropDownOptions = driver.findElement(By.xpath("//select[@id='country']"));
		Select mySelect = new Select(dropDownOptions);
		// selecting by text
		mySelect.selectByVisibleText("Germany");

		// select by value
		mySelect.selectByValue("australia");

		// select by index
		mySelect.selectByIndex(8);

		// capturing the options
		List<WebElement> options = mySelect.getOptions();

		System.out.println(options.size());
		for (WebElement option : options) {
			System.out.println(option.getText());
		}
/*
		// using classic forloop (in reverse)
		for (int i = options.size() - 1; i >= 0; i--) {
			System.out.println(options.get(i).getText());
		}
*/
		driver.quit();
	}

}
