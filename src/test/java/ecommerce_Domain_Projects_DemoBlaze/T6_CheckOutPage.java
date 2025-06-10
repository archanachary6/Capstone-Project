package ecommerce_Domain_Projects_DemoBlaze;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.*;

public class T6_CheckOutPage extends BaseClass {
	@BeforeClass
	public void pageSetUp() {
		p2.doLogin(prop.getData("username"), prop.getData("password"));
	}

	
	@Test
	public void placeOrder() {	
		p6.checkout();
		
	}
	
}
