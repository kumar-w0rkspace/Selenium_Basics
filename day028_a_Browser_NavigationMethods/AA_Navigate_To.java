package day028_a_Browser_NavigationMethods;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class AA_Navigate_To {

	public static void main(String[] args) throws URISyntaxException, MalformedURLException {

		// Note - java.net.URL object creation is deprecated in java from v20
		// Recommended - use java.net.URI and convert to URL when needed

		String baseUrl = "https://testautomationpractice.blogspot.com/";

		WebDriver driver = new EdgeDriver();

		driver.get(baseUrl); // get method - accepts url only in string format
		System.out.println(driver.getTitle());

		driver.navigate().to("https://www.saucedemo.com/"); // navigate to method - accepts url as string and object
															// (line 31)
		System.out.println(driver.getTitle());

		//URI myUri = new URI("https://katalon-demo-cura.herokuapp.com/"); // object creation of URI
		URL myUrl = new URI("https://katalon-demo-cura.herokuapp.com/").toURL(); // convertion of URI to URL

		driver.navigate().to(myUrl); // accepts url as an object
		System.out.println(driver.getTitle());

		driver.quit();
	}

}
