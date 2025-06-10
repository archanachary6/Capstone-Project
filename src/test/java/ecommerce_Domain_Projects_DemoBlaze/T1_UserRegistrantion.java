package ecommerce_Domain_Projects_DemoBlaze;

import org.testng.annotations.Test;
import org.testng.annotations.Test;

public class T1_UserRegistrantion  extends BaseClass {
	
	@Test
	public void signup() {
	p1.signup(prop.getData("signun"),prop.getData("signpw"));
	
	}
}
