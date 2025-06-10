package ecommerce_Domain_Projects_DemoBlaze;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import generic.Utility;

public class P5_CartPage {
	
	
	private WebDriver driver;
	//constructor
	public P5_CartPage(WebDriver driver) {
		
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}

//	Locators
	@FindBy(linkText="Delete")
	WebElement deleteButton;
	
	@FindBy(xpath="//tbody[@id='tbodyid']//tr")
	List<WebElement>  rows;
	
	@FindBy(xpath="//tbody[@id='tbodyid']//tr//td")
	List<WebElement> cells;
	
	@FindBy(xpath="//h3[@id='totalp']")
	WebElement amount;
	
	@FindBy(linkText="Cart")
	WebElement cart;
	//actions
	public P5_CartPage cartList() {
		
		cart.click();
		int count=rows.size();
		System.out.println("Number Items in Cart-------"+count);
		for(WebElement i:cells)
		{
			
			System.out.println(i.getText());
		}	
		System.out.println("Total Amount for "+count+" Items :"+amount.getText());
		
		return this;
	}
	
	public void delete(String del1) {
		cart.click();
		for(WebElement i:cells)
		{
			if (i.getText().contains(del1))
			{
			addwait();
			deleteButton.click();
			}
		}	
	}
	
	public P5_CartPage myCart(String del1) {
		cart.click();
		addwait();
		delete(del1);
		 Utility.getScreenshot(driver, "delete");
		addwait();
		cartList();
		return this;
	}
	
	public void addwait() {
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
}
