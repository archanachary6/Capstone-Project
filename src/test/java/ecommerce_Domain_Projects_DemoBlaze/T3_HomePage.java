package ecommerce_Domain_Projects_DemoBlaze;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class T3_HomePage extends BaseClass {
	@BeforeClass
	public void pageSetUp() {
		p2.doLogin(prop.getData("username"), prop.getData("password"));
	}
	
	@Test(priority = 1)
	public void navigateSlidePromotions() {
		p3.promoSlide();
	}
	
	@Test(priority = 3)
	public void selectLaptopList() {
		
		p3.allProductList();
		p3.refreshHomePage();
	}
}
