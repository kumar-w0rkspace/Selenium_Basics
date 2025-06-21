package day047_Page_Object_Model;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

// WITHOUT PAGEFACTORY
public class AA_LoginPage_Without_PageFactory {

	WebDriver driver;

	// Constructors
	AA_LoginPage_Without_PageFactory(WebDriver driver) {
		this.driver = driver;
	}
	// Locators
/*
 *  the findElement method is identifying the element, based on the locator
 *  WebElement element = driver.findElement(By.xpath("Location"));
 *	locater = By.xpath("//xpath location")
 *	so, we can rewrite it as
 *	WebElement element = driver.findElement(locator)
 *	the By returns a locator
 */	
	By loc_txt_userName = By.xpath("//input[@placeholder='Username']");
	By loc_txt_passWord = By.xpath("//input[@placeholder='Password']");
	By loc_btn_login = By.xpath("//button[@type='submit']");
	
	// Action Methods
	public void setUserName(String userName) {
		driver.findElement(loc_txt_userName).sendKeys(userName);
	}
	
	public void setPassWord(String passWord) {
		driver.findElement(loc_txt_passWord).sendKeys(passWord);
	}
	
	public void clickLoginBtn() {
		driver.findElement(loc_btn_login).click();
	}
	
}
