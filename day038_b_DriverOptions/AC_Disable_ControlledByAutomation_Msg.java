package day038_b_DriverOptions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

public class AC_Disable_ControlledByAutomation_Msg {

	public static void main(String[] args) {
		EdgeOptions options = new EdgeOptions();
		options.setExperimentalOption("excludeSwitches", new String[] { "enable-automation" }); 
		// setting for removing being controlled notice
		WebDriver driver = new EdgeDriver(options);
		String baseUrl = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
		driver.get(baseUrl);
		System.out.println((driver.getTitle().equals("OrangeHRM")) ? "Titles match" : "Titles dont match");

		driver.quit();

	}

}
