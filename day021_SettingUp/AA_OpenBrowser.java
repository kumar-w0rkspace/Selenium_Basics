package day021_SettingUp;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class AA_OpenBrowser {

	public static void main(String[] args) {

		// launch browser
		// launch a url
		// validate title
		// close browser

		// EdgeDriver driver = new EdgeDriver();
		WebDriver driver = new EdgeDriver(); // initializing browser
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login"); // launching url
		boolean status = driver.getTitle().equals("OrangeHRM");

		System.out.println("Title status: " + status); // checking title status

		if (status)
			System.out.println("Test Passed!");
		else
			System.out.println("Test Failed!");

		// driver.close(); // closing browser
		driver.quit();// quitting browser

	}

}
