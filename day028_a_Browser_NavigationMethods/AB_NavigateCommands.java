package day028_a_Browser_NavigationMethods;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class AB_NavigateCommands {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new EdgeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		driver.manage().window().maximize();

		String baseUrl = "https://katalon-demo-cura.herokuapp.com/";
		String secondUrl = "https://www.saucedemo.com/";
		String thirdUrl = "https://testautomationpractice.blogspot.com/";

		driver.get(baseUrl);
		System.out.println("Base Title: " + driver.getTitle());
		driver.navigate().to(secondUrl);
		System.out.println("Second Title: " + driver.getTitle());

		// navigate.back
		driver.navigate().back();
		System.out.println("Navigate Back: " + driver.getTitle());

		// navigate.forward
		driver.navigate().forward();
		System.out.println("Navigate Forward: " + driver.getTitle());
		driver.get(thirdUrl);
		System.out.println("Third Title: " + driver.getTitle());
		Thread.sleep(3000); // intentional pause

		// navigate.refresh
		driver.navigate().refresh();
		System.out.println("Refresh: " + driver.getTitle());

		driver.quit();

	}

}
