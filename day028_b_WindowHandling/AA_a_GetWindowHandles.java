package day028_b_WindowHandling;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class AA_a_GetWindowHandles {

	public static void main(String[] args) {

		// Note - use driver.switchto() - to switch to specific windows id

		String baseUrl = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";

		WebDriver driver = new EdgeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();

		driver.get(baseUrl);
		driver.findElement(By.xpath("//a[normalize-space()='OrangeHRM, Inc']")).click();

		Set<String> tabsSet = driver.getWindowHandles(); // no indexing

		// Type 1 converting to List
		List<String> tabsList = new ArrayList<String>(tabsSet); // has indexing
		String parentId = tabsList.get(0);
		String childId = tabsList.get(1);

		System.out.println("Parent title: " + driver.getTitle());
		driver.switchTo().window(childId);
		System.out.println("Child title: " + driver.getTitle());

		// Type 2 (for more than three tabs)

		for (String tab : tabsList) {
			String tempUrl = driver.switchTo().window(tab).getCurrentUrl(); // iterating over tabsList to get current
																			// url
			if (tempUrl.equals("https://www.orangehrm.com/")) {
				System.out.println(driver.getTitle());
			} else
				driver.close(); // closes all other tabs

		}

		driver.quit();

	}

}
