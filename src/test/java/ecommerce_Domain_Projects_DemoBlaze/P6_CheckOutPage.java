package ecommerce_Domain_Projects_DemoBlaze;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import generic.Utility;

public class P6_CheckOutPage {
	
private WebDriver driver;
	
	public P6_CheckOutPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}

	//locators
	@FindBy(linkText="Cart")
	WebElement cart;
	
	@FindBy(xpath="//button[@class='btn btn-success']")
	WebElement placeOrder;
	
	@FindBy(xpath="//h5[@id='orderModalLabel']")
	WebElement labelplaceorder;
		
	@FindBy(xpath="//input[@id='name']")
	WebElement cmname;
	
	@FindBy(xpath="//input[@id='country']")
	WebElement cmcountry;
	
	@FindBy(xpath="//input[@id='city']")
	WebElement cmcity;

	@FindBy(xpath="//input[@id='card']")
	WebElement cmcardno;
	
	@FindBy(xpath="//input[@id='month']")
	WebElement month;
	
	@FindBy(xpath="//input[@id='year']")
	WebElement year;
	
	@FindBy(xpath="//button[@onclick='purchaseOrder()']")
	WebElement purchase;
	
	@FindBy(xpath="(//h2)[3]")
	WebElement confirmationmsg;
	
	@FindBy(xpath="//p[@class='lead text-muted ']")
	List<WebElement> confirmationmsg1;
	
	@FindBy(xpath="//button[@class='confirm btn btn-lg btn-primary']")
	WebElement ok;
	
	//actions
	public void checkout() {
		cart.click();
		placeOrder.click();
		addwait();
		
		String text=labelplaceorder.getText();
		Assert.assertTrue(text.contains("Place order"));
		System.out.println("Title matched.....");
		
		cmname.sendKeys("stranger");
		cmcountry.sendKeys("India");
		cmcity.sendKeys("Hyderabad");
		cmcardno.sendKeys("4444 3333 2222 1111");
		month.sendKeys("Oct");
		year.sendKeys("2025");
		 Utility.getScreenshot(driver, "order");
		addwait();
		
		purchase.click();
		
		String msg=confirmationmsg.getText();
		Assert.assertTrue(msg.contains("Thank you for your purchase!"));
		System.out.println("Title matched....."+msg);
		addwait();
		
		for(WebElement i:confirmationmsg1) {
		System.out.println(i.getText());
		}
		 Utility.getScreenshot(driver, "ok");
		ok.click();
	
	}
	
	public void addwait() {
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}	
	}
	
	
}
