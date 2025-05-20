package day031_DropDown;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class AB_BootStrap {

	public static void main(String[] args) throws InterruptedException {

		// Note - bootstrap and multiselect

		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		String baseUrl = "https://jquery-az.com/boots/demo.php?ex=63.0_2";
		driver.get(baseUrl);

		// selecting single option
		driver.findElement(By.xpath("//span[contains(@class,'multiselect')]")).click();// open the dropdown
		driver.findElement(By.xpath("//input[@value='Java']")).click();

		// deselecting specific options (HTML, CSS, Java)
		List<WebElement> options = driver.findElements(By.xpath("//ul[contains(@class, 'multiselect')]//label"));
		for (int i = 0; i < options.size(); i++) {
			if (options.get(i).getText().equals("HTML") || options.get(i).getText().equals("CSS")
					|| options.get(i).getText().equals("Java")) {
				options.get(i).click();
				Thread.sleep(500);
			}
		}

		// selecting all options
		for (WebElement option : options) {
			if (!option.isSelected()) {
				option.click();
				Thread.sleep(500);
			}
		}

		// displaying size and text

		System.out.println(options.size());
		for (WebElement temp : options) {
			System.out.println(temp.getText());
		}

		driver.quit();

	}

}
