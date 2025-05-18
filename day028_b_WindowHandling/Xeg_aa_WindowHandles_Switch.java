package day028_b_WindowHandling;

import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class Xeg_aa_WindowHandles_Switch {

	public static void main(String[] args) throws InterruptedException {
		/*
		 * baseUrl - https://testautomationpractice.blogspot.com/ 
		 * 1> provide search parameter on the wiki icon 
		 * 2> count number of links 
		 * 3> click on each link 
		 * 4> get windowIds 
		 * 5> close specific windows
		 */
		WebDriver driver = new EdgeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		driver.manage().window().maximize();
		String baseUrl = "https://testautomationpractice.blogspot.com/";
		driver.get(baseUrl);

		driver.findElement(By.xpath("//input[@id='Wikipedia1_wikipedia-search-input']")).sendKeys("Selenium");
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		List<WebElement> searchResults = driver.findElements(By.xpath("//div[@id='wikipedia-search-result-link']/a"));
		System.out.println("Number of links: " + searchResults.size());

		for (WebElement result : searchResults) {
			result.click();
		}

		String seleniumTab =null;
		Set<String> tabsSet = driver.getWindowHandles();
		for (String tab : tabsSet) {
			String title = driver.switchTo().window(tab).getTitle();
			if (title.contains("Selenium (software)")) seleniumTab = driver.getWindowHandle();
			else driver.close();
		}
		
		driver.switchTo().window(seleniumTab);
		System.out.println("Title: "+driver.getTitle());

		System.out.println("\nExplanation of Selenium Software from Wikipedia:\n\n"
				+ driver.findElement(By.xpath("//div[@id='mw-content-text']//p[3]")).getText());

		driver.quit();

	}

}
