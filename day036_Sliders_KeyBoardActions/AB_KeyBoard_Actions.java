package day036_Sliders_KeyBoardActions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

public class AB_KeyBoard_Actions {

	static void preReq(WebDriver driver) {
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	public static void main(String[] args) throws InterruptedException {
		// https://text-compare.com/
		// navigate, send keys to textarea
		// use ctrl a to select all
		// use ctrl c to copy
		// use tab to go next text area
		// use ctrl v to paste
		// click compare
		// verify the text is same

		WebDriver driver = new EdgeDriver();
		preReq(driver);
		String baseUrl = "https://text-compare.com/";
		String textArea1 = "//textarea[@id='inputText1']";
		String textToSend = "The quick brown fox jumps over the lazy dog";
		// String textArea2 = "//textarea[@id='inputText2']"; // not necessary since we
		// use keyboard action TAB to switch
		String compareBtn = "//div[@class='compareButtonText']";
		String userMsgLoc = "//span[@class='messageForUser']";
		String confirmMsg = "The two texts are identical!";

		driver.get(baseUrl);
		driver.findElement(By.xpath(textArea1)).sendKeys(textToSend);
// keyboard actions
		Actions act = new Actions(driver);
// Ctrl + A		
		act.keyDown(Keys.CONTROL).sendKeys("A").keyUp(Keys.CONTROL).perform();
// Ctrl + C	
		act.keyDown(Keys.CONTROL).sendKeys("C").keyUp(Keys.CONTROL).perform();
// Tab		
		act.keyDown(Keys.TAB).perform();
// Ctrl + V		
		act.keyDown(Keys.CONTROL).sendKeys("V").keyUp(Keys.CONTROL).perform();

		driver.findElement(By.xpath(compareBtn)).click();
		Thread.sleep(3000);
		System.out.println(driver.findElement(By.xpath(userMsgLoc)).getText());
		System.out.println("Identical msg notification display status: "
				+ driver.findElement(By.xpath(userMsgLoc)).getText().equalsIgnoreCase(confirmMsg));

		// driver.quit();

	}

}
