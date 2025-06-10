package ecommerce_Domain_Projects_DemoBlaze;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.*;

public class T5_CartPage extends BaseClass {
	@BeforeClass
	public void pageSetUp() {
	p2.doLogin(prop.getData("username"), prop.getData("password"));
	}
	
	@Test
	public void myCart() {
		p5.myCart(prop.getData("product1"));
		
	}
		
}
