package day028_b_WindowHandling;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class AA_b_TargettedClosing {

	public static void main(String[] args) {

		String baseUrl = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";

		WebDriver driver = new EdgeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();

		driver.get(baseUrl); // parent window
		driver.findElement(By.xpath("//a[normalize-space()='OrangeHRM, Inc']")).click(); // child window

		Set<String> tabsSet = driver.getWindowHandles();
//		List<String> tabsList = new ArrayList<String>(tabsSet);

		// closing parent window and switching to child window
		for (String tab : tabsSet) {
			if (driver.switchTo().window(tab).getTitle().equals("OrangeHRM")) {
				driver.close();
			}
		}

//		driver.switchTo().window(tabsList.get(1));
//		System.out.println("Child tab logo display stat: "
//				+ driver.findElement(By.xpath("/html/body/nav/div/a/img")).isDisplayed());

		driver.quit();

	}

}
