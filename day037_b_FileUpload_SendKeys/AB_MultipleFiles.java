package day037_b_FileUpload_SendKeys;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class AB_MultipleFiles {
	static void preReq(WebDriver driver) {
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	public static void main(String[] args) throws InterruptedException {
		// https://davidwalsh.name/demo/multiple-file-upload.php
		WebDriver driver = new EdgeDriver();
		preReq(driver);
		String baseUrl = "https://davidwalsh.name/demo/multiple-file-upload.php";
		String file1 = "D:\\notice button empty.jpg";
		String file2 = "D:\\Screenshot 2025-05-29 124758.png";
		driver.get(baseUrl);
		WebElement fileInputBox = driver.findElement(By.xpath("//input[@id='filesToUpload']"));
		fileInputBox.sendKeys(file1 + "\n" + file2);
// validation
		Thread.sleep(3000);
		String space1 = driver.findElement(By.xpath("//ul[@id='fileList']/li[1]")).getText();
		String space2 = driver.findElement(By.xpath("//ul[@id='fileList']/li[2]")).getText();
//		if (space1.equalsIgnoreCase("notice button empty.jpg")
//				&& space2.equalsIgnoreCase("Screenshot 2025-05-29 124758.png")) {
//			System.out.println("Match");
//		} else {
//			System.out.println("Dont match");
//		}
		System.out.println((driver.findElements(By.xpath("//ul[@id='fileList']/li")).size() == 2) ? "All files uploaded"
				: "Error in upload");
		System.out.println((space1.equalsIgnoreCase("notice button empty.jpg")
				&& space2.equalsIgnoreCase("Screenshot 2025-05-29 124758.png") ? "Names Match" : "Names Dont Match"));
		driver.quit();
	}

}
