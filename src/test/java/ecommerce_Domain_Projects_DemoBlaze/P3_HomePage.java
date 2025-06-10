package ecommerce_Domain_Projects_DemoBlaze;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import generic.Utility;

public class P3_HomePage {
	
	private WebDriver driver;
	// constructor
	public P3_HomePage(WebDriver driver) {
		
		this.driver=driver;
		PageFactory.initElements(driver,this);	
	}

	//Locators
	@FindBy(xpath ="//span[@class='carousel-control-next-icon']")
	WebElement nextpromo;
	
	@FindBy(xpath ="//span[@class='carousel-control-prev-icon']")
	WebElement prepromo;
	
	@FindBy(linkText ="Monitors")
	WebElement optionMonitors;
	
	@FindBy(linkText ="Laptops")
	WebElement optionLaptops;
	
	@FindBy(linkText ="Phones")
	WebElement optionPhones;
	
	@FindBy(xpath ="//a[@class='hrefch']")
	List<WebElement> productList;
	
	@FindBy(linkText="Home ")
	WebElement homeoption; 
	@FindBy(id = "next2")
	WebElement nextButton;
	
	//actions
	public P3_HomePage promoSlide() {
		nextpromo.click();
		nextpromo.click();
		addwait();
		prepromo.click();
		nextpromo.click();
		return this;
	}

	public P3_HomePage allProductList() {
		 Utility.getScreenshot(driver, "homepage");
		optionPhones.click();
		addwait();
		System.out.println("Number of products available for Phone Categery "+ productList.size());
		for(WebElement i:productList)
		{
			System.out.println(i.getText());
		}
		System.out.println("----------------------------");
		
		addwait();
		optionLaptops.click();
		addwait();
			System.out.println("Number of products available for Laptop Categery "+ productList.size());
			for(WebElement i:productList)
			{
				System.out.println(i.getText());
			}
			System.out.println("----------------------------");
			
			addwait();
			optionMonitors.click();
			addwait();
			System.out.println("Number of products available for Monitor Categery "+ productList.size());
			for(WebElement i:productList)
			{
				System.out.println(i.getText());
			}
		return this;
	}

	public P3_HomePage refreshHomePage() {
		driver.navigate().refresh();
		return this;
	}
	
public void addwait() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
	
	

