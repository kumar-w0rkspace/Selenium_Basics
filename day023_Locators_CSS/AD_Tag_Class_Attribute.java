package day023_Locators_CSS;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class AD_Tag_Class_Attribute {

	public static void main(String[] args) {

		String baseUrl = "https://www.saucedemo.com/";
		String usernameSelector = "input.input_error[data-test = 'username']";
		String passwordSelector = "input.input_error[name = 'password']";
		String loginSelector = "input.submit-button[type = 'submit']";
		String username = "performance_glitch_user";
		String password = "secret_sauce";

		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get(baseUrl);
		driver.findElement(By.cssSelector(usernameSelector)).sendKeys(username);
		driver.findElement(By.cssSelector(passwordSelector)).sendKeys(password);
		driver.findElement(By.cssSelector(loginSelector)).click();

		System.out.println(driver.getTitle());
		driver.close();

	}

}
