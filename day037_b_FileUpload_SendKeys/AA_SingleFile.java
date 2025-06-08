package day037_b_FileUpload_SendKeys;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class AA_SingleFile {
	static void preReq(WebDriver driver) {
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	public static void main(String[] args) {
		// https://davidwalsh.name/demo/multiple-file-upload.php
		WebDriver driver = new EdgeDriver();
		preReq(driver);
		String fileName = "notice button empty.jpg";
		driver.get("https://davidwalsh.name/demo/multiple-file-upload.php");
		WebElement fileInputBox = driver.findElement(By.xpath("//input[@id='filesToUpload']"));
// fileInputBox.sendKeys("D:\\Screenshot 2025-05-29 124758.jpg");
		fileInputBox.sendKeys("D:\\".concat(fileName));
// validation
		String uploadSpace = driver.findElement(By.xpath("//ul[@id='fileList']/li")).getText();
		System.out.println((uploadSpace.equalsIgnoreCase(fileName) ? "Match" : "No Match"));
		driver.quit();
	}

}
