package day036_Sliders_KeyBoardActions;

import java.time.Duration;
import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.edge.EdgeDriver;

public class AC_b_SwitchNewTab_WithoutWindowHandles {
	static void preReq(WebDriver driver) {
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	public static void main(String[] args) {
		// navigate https://testautomationpractice.blogspot.com/
		// click on the home link and open new tab keeping the parent window
		// use ctrl + click to open new tab in the background
		// switch to the second window and get title without getWindowHandles

		WebDriver driver = new EdgeDriver();
		preReq(driver);
		driver.get("https://testautomationpractice.blogspot.com/");
		System.out.println(driver.getTitle());
// Focused new tab
		driver.switchTo().newWindow(WindowType.TAB);
		driver.get("https://www.example.com");
		System.out.println(driver.getTitle());
// Focused new window
		driver.switchTo().newWindow(WindowType.WINDOW);
		driver.get("https://www.testyou.com");
		System.out.println(driver.getTitle());
// Printing the windowHandles
		for (String window : new ArrayList<String>(driver.getWindowHandles())) {
			System.out.println(window + " ");
		}

		driver.quit();

	}

}
