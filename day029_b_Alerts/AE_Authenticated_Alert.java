package day029_b_Alerts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class AE_Authenticated_Alert {

	public static void main(String[] args) throws InterruptedException {
		// username and password entry alert
		// Note - we need to give the credentials at the url itself (injection process)
		// syntax - https://username:password@websiteUrl
		
		String baseUrl = "https://the-internet.herokuapp.com/basic_auth";
		String urlWithCredentials = "https://admin:admin@the-internet.herokuapp.com/basic_auth";

		WebDriver driver = new EdgeDriver();

		driver.get(baseUrl); // cant go in because of credentials
		
		Thread.sleep(3000);

		driver.navigate().to(urlWithCredentials);

		System.out.println(driver.findElement(By.xpath("//div[@class='example']/p")).getText());
		driver.quit();
	}

}
