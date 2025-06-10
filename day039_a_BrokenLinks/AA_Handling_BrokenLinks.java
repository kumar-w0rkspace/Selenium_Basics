package day039_a_BrokenLinks;

import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

/*
 * Link must have href attribute and value
 * When hitting the link, there will be a status code return
 * If status code is greater than 400, then its a broken link
 */
public class AA_Handling_BrokenLinks {
	static void preReq(WebDriver driver) {
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	public static void main(String[] args) {
		// http://www.deadlinkcity.com/
		// check if all the links are broken or not
		// Note - use tagName

		WebDriver driver = new EdgeDriver();
		preReq(driver);
		driver.get("http://www.deadlinkcity.com/");
		List<WebElement> links = driver.findElements(By.tagName("a"));
// Total links
		System.out.println(links.size());
// checking if href links has value
		int brokenLinkCount = 0;
		for (WebElement linkElement : links) {
			String hrefAttribute = linkElement.getDomProperty("href"); // getAttribute() is deprecated

			if (hrefAttribute == null || hrefAttribute.isEmpty()) { // checking if the hrefattrubute have value or not
				System.out.println("href attrubite is not available");
				continue;
			}
// sending the request to server if the hrefattribute has value
// we need to convert the href value from string to URL
			try {
				URL linkUrl = new URI(hrefAttribute).toURL(); // URL url = new URL is deprecated
				HttpURLConnection connectLinkURL = (HttpURLConnection) linkUrl.openConnection(); // open connection
				connectLinkURL.connect(); // send request to server
//getting status code from the connectLinkURL
				if (connectLinkURL.getResponseCode() >= 400) {
					System.out.println(hrefAttribute + " is broken");
					brokenLinkCount++;
				} else
					System.out.println(hrefAttribute + " is not a broken");
			} catch (Exception e) { // catching all exceptions instead of URISyntaxException, IOException

			}
		}
		System.out.println("Total broken Links " + brokenLinkCount);
		driver.quit();
	}

}
