package ecommerce_Domain_Projects_DemoBlaze;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import generic.Utility;

public class P4_ShoppingPage extends BaseClass {
	private WebDriver driver;
	
	// constructor
	public P4_ShoppingPage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

//locators
	@FindBy(xpath = "(//a[@class='nav-link'])[1] ")
	WebElement homePage;


	@FindBy(xpath = "//h3[@class='price-container']")
	WebElement price;

	@FindBy(xpath = "(//p)[4]")
	WebElement description;

	@FindBy(linkText = "Add to cart")
	WebElement addCart;
	
	@FindBy(linkText ="Monitors")
	WebElement optionMonitors;
	
	@FindBy(linkText ="Laptops")
	WebElement optionLaptops;
	
	@FindBy(linkText ="Phones")
	WebElement optionPhones;
	
	@FindBy(xpath ="//a[@class='hrefch']")
	List<WebElement> productList;
	
	@FindBy(linkText="Cart")
	WebElement cart;
	
	@FindBy(xpath="//tbody[@id='tbodyid']//tr")
	List<WebElement>  cartrows;
	
	// action
	
	public P4_ShoppingPage addToCart(String productname) {
		
		addCart.click();
		addwait();
		
		Alert alt = driver.switchTo().alert();
		System.out.println("Aert text is: " + alt.getText());
		alt.accept();
		Utility.getScreenshot(driver, "item");
		addwait();
		System.out.println("Product   :  "+productname);
		System.out.println("Product Price  :" + price.getText());
		System.out.println("Product Description   :" + description.getText());
		System.out.println("------------------------------------------------------------------");
		homePage.click();
		return this;
	}
	
	public P4_ShoppingPage addProduct (String productname) {   
		optionPhones.click();
		addwait();
		for(WebElement i:productList)
		{	if(i.getText().contains(productname))
			{i.click();
			addToCart(productname);
			
			break;
			}
		}		
		addwait();
		homePage.click();
		optionLaptops.click();
		addwait();
			for(WebElement i:productList)
			{
				if(i.getText().contains(productname))
				{i.click();
				
				addToCart(productname);
				
				break;
				}
			}
			addwait();
			homePage.click();
			optionMonitors.click();
			addwait();
			for(WebElement i:productList)
			{
				if(i.getText().contains(productname))
				{i.click();
				
				addToCart(productname);
				
				break;
				}
			} 
			
			return this;
	}
	
	public P5_CartPage shoppingcart(String product1,String product2,String product3) {
	driver.navigate().refresh();
	addProduct(product1);
	addProduct(product2);
	addProduct(product3);
	
	addwait();
	cart.click();
	System.out.println("No of items added to cart : "+cartrows.size());
	
	addwait();
	return p5;
	}
	public void addwait() {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
