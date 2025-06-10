package ecommerce_Domain_Projects_DemoBlaze;

import java.util.Random;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import generic.Utility;

public class P1_UserRegistration {

	private WebDriver driver;
	// constructor
	public P1_UserRegistration(WebDriver driver) {
		
		this.driver=driver;
		PageFactory.initElements(driver,this);	
	}
	
//	Locators
	
	@FindBy(linkText="Sign up")
	WebElement signup;
	
	@FindBy(id="sign-username")
	WebElement signupname;
	
	@FindBy(id="sign-password")
	WebElement signuppassword;
	
	@FindBy (xpath="(//button[@class='btn btn-primary'])[2]")
	WebElement signupbutton;
	
//actions
	
	public void signup(String s1,String pw1) {
		signup.click();
		signupname.sendKeys(s1);
		signuppassword.sendKeys(pw1);
		addwait();
		signupbutton.click();
		
		Utility.getScreenshot(driver, "signup");
		addwait();
		Alert alt = driver.switchTo().alert();
		System.out.println("Aert text is: " + alt.getText());
		alt.accept();
	}
	
	public void addwait(){
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	
}
