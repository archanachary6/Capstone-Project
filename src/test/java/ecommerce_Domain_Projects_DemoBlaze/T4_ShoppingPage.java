package ecommerce_Domain_Projects_DemoBlaze;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.*;

public class T4_ShoppingPage extends BaseClass {
	@BeforeClass
	public void pageSetUp() {
		p2.doLogin(prop.getData("username"), prop.getData("password"));
	}

	@Test(priority=1)
	public void shoppingcart() {	
		
	p4.shoppingcart(prop.getData("product1"),prop.getData("product2"),prop.getData("product3"));
		
	}
	
}
