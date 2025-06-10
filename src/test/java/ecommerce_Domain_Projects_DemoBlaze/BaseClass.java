package ecommerce_Domain_Projects_DemoBlaze;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import generic.*;

public class BaseClass {

	public WebDriver driver;
	public PropertiesUtil prop;
	public P1_UserRegistration p1;
	public P2_SignInPage p2;
	public P3_HomePage p3;
	public P4_ShoppingPage p4;
	public P5_CartPage p5;
	public P6_CheckOutPage p6;
	
	@BeforeClass
	public void setUp() {
		prop = new PropertiesUtil("config");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.demoblaze.com/");
		driver.manage().window().maximize();
		
		p1=new P1_UserRegistration(driver);
		p2=new P2_SignInPage(driver);
		p3 =new P3_HomePage(driver);
		p4=new P4_ShoppingPage(driver);
		p5=new P5_CartPage(driver);
		p6=new P6_CheckOutPage(driver);
	}
	
	@AfterClass
	public void tearDown() {
		
	//	p2.dosignout();
		driver.quit();	
	}
	
}
