package day026_WebDriver_Methods;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class AA_Get {

	public static void main(String[] args) {

		// getUrl, getTitle, getCurrentUrl, getPageSource, getWindowHandle/s

		String baseUrl = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";

		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		driver.get(baseUrl); // navigates to the url

		System.out.println("Title is " + driver.getTitle()); // return the title of the page

		System.out.println("Url is " + driver.getCurrentUrl()); // return the url of current page

		String pageSource = driver.getPageSource(); // returns html of page
		// System.out.println(pageSource);

		System.out.println("Window id is " + driver.getWindowHandle()); // returns the id of single browser window
		// Note - window/s id is always dynamic. not constant

		driver.findElement(By.xpath("//a[normalize-space()='OrangeHRM, Inc']")).click(); // opens new window

		Set<String> windowsID = driver.getWindowHandles(); // returns a set string array of windows id (1+)

		System.out.println(windowsID); // string array

		driver.quit();

	}

}
