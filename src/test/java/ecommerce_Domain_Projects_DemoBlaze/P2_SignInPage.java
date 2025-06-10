package ecommerce_Domain_Projects_DemoBlaze;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import generic.Utility;

public class P2_SignInPage {
	
	private WebDriver driver;
	// constructor
	public P2_SignInPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
//Locators
	
	@FindBy(linkText="Log in")
	WebElement signinButton;
	
	@FindBy(linkText="Log out")
	WebElement signoutButton;
	
	@FindBy(id="loginusername")
	WebElement userName;
	
	
	@FindBy(id="loginpassword")
	WebElement userPassword;
	
	@FindBy(xpath="//button[@onclick='logIn()']")
	WebElement loginButton;
	
	@FindBy(linkText="Welcome stranger")
	WebElement hometext;
	
	@FindBy(xpath="(//button[@class='btn btn-secondary'])[3]")
	WebElement wrongpwalt;
	
	//actions
	public String getAppUrl() {
		return driver.getCurrentUrl();
	}

	public String getAppTiTle() {
		return driver.getTitle();
	}
	
	public P2_SignInPage doLogin(String username,String password) {
		signinButton.click();
		userName.sendKeys(username);
		userPassword.sendKeys(password);
		Utility.getScreenshot(driver, "Login");
		loginButton.click();
		String text=hometext.getText();
		Assert.assertTrue(text.contains("Welcome stranger"));
		System.out.println("Title matched....." + text);
		return this;
		
	}
	
	
	public void dosignout() {
	
		signoutButton.click();
	}
}
