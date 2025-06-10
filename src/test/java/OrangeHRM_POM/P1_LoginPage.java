package OrangeHRM_POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import generic.Utility;

public class P1_LoginPage {

	private WebDriver driver;

	// constructor
	public P1_LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	// Locators
	@FindBy(xpath = "//input[@placeholder='Username']")
	private WebElement username;

	@FindBy(xpath = "//input[@placeholder='Password']")
	private WebElement password;

	@FindBy(xpath = "//button[@type='submit']")
	private WebElement loginButton;

	// actions
	public P2_AdminPage doLogin(String un, String pw) {
		
		username.sendKeys(un);
		password.sendKeys(pw);
		Utility.getScreenshot(driver, "loginpage");
		loginButton.click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Utility.getScreenshot(driver, "dashboardpage");
		return new P2_AdminPage(driver);
	}

	public String getAppUrl() {
		return driver.getCurrentUrl();
	}

	public String getAppTiTle() {

		return driver.getTitle();
	}
}
