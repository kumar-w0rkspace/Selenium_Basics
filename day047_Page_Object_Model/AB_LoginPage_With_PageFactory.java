package day047_Page_Object_Model;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

// WITH PAGEFACTORY
public class AB_LoginPage_With_PageFactory {

	WebDriver driver;

// constructor
	AB_LoginPage_With_PageFactory(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

// Locators - use @FindBy annotation (return is webelement)
	@FindBy(xpath = "//input[@placeholder='Username']")
	WebElement txt_userName;
	@FindBy(xpath = "//input[@placeholder='Password']")
	WebElement txt_passWord;
	@FindBy(css = "button[type='submit']")
	WebElement btn_login;
//	@FindBy(tagName = "//a")
//	List<WebElement> links;
	
/* Another flavor
	@FindBy(how = How.XPATH, using = "//input[@placeholder='Username']")
	WebElement txt2_userName;
*/
	// action method
	public void setUserName(String userName) {
		txt_userName.sendKeys(userName);
	}

	public void setPassWord(String passWord) {
		txt_passWord.sendKeys(passWord);
	}

	public void clickLoginBtn() {
		btn_login.click();
	}

}
