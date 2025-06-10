package OrangeHRM_POM;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import generic.Utility;

public class P2_AdminPage {
	private WebDriver driver;
	
	//constructor
	public P2_AdminPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}

	//locators
	@FindBy(xpath="//ul[@class='oxd-main-menu']//li//a//span")
	List<WebElement> searchOptions;
	
	@FindBy(xpath="(//input[@class='oxd-input oxd-input--active'])[2]")
	 WebElement inputusername;
	
	//UserRole
	@FindBy(xpath="(//div[@class='oxd-select-text--after'])[1]")
	 WebElement userroleselect;
	
	@FindBy(xpath="//div[@role='listbox']//div")
	List<WebElement> userroleoptions;
	
	//userstatus
	@FindBy(xpath="(//div[@class='oxd-select-text--after'])[2]")
	private WebElement userstatusselect;
	
	@FindBy(xpath="//div[@role='listbox']//div")
	List<WebElement> userstatusoptions;
	
	@FindBy(xpath="//button[@class='oxd-button oxd-button--medium oxd-button--secondary orangehrm-left-space']")
	private WebElement submitbutton;
	
	@FindBy(xpath="//button[@class='oxd-button oxd-button--medium oxd-button--ghost']")
	private WebElement resetbutton;
	
	@FindBy(xpath="//span[@class='oxd-text oxd-text--span']")
	private WebElement getRecord;
	
	//actions------------------------------------------------------------------
	
	public  P2_AdminPage searchAdmin(String un) {
		System.out.println("Number of Search Options :"+searchOptions.size());
		WebElement ele=null;
		for(WebElement i:searchOptions)
		{
			System.out.println(i.getText());
			if(i.getText().contains(un))
			{						
				ele=i;
			}
		}
		ele.click();
		
		System.out.println("Total number of Records in this Page ----:");
		getRecords(un);
		return this;
	}
	//---------------------------------------------------------------------
	public P2_AdminPage selectByUserName(String un) {
		System.out.println("Select By UserName ----------");
		if (inputusername.isEnabled()) {
			inputusername.sendKeys(un);
		}
		submitbutton.click();
		 Utility.getScreenshot(driver, "AdminUsername");
		getRecords(un);
		refreshPage();
		return this;
	}
	
	//---------------------------------------------------------------------------
	public P2_AdminPage selectByUserRole(String role) {
	System.out.println("Select By UserRole ----------");
	userroleselect.click();
		for(WebElement i:userroleoptions)
		{
			if(i.getText().contains(role))
			{
				System.out.println("User-role Selected Option :"+i.getText());
				i.click();
				submitbutton.click();break;		
			}
		}
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		getRecords(role);
		 Utility.getScreenshot(driver, "Userrole");
		refreshPage();
		return this;
	}
	//---------------------------------------------------------------------	
	public P2_AdminPage selectByUserStatus(String status) {
		System.out.println("Select By UserStatus ----------");
		userstatusselect.click();
		for(WebElement i:userstatusoptions)
		{
			if(i.getText().contains(status))
			{
				System.out.println("User-Status Selected Option :"+i.getText());
				i.click();
				submitbutton.click();break;
			}
		}
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		getRecords(status);
		Utility.getScreenshot(driver, "userstatus");
		refreshPage();
		return this;
	}
	//----------------------------------------------------------------------------------------
	public P2_AdminPage getRecords(String a) {
		
		System.out.println(a+"   "+getRecord.getText());
	
		return this;
		}
		
	public P2_AdminPage refreshPage() {
		
		driver.navigate().refresh();
		return this;
	}
}
