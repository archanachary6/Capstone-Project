package ecommerce_Domain_Projects_DemoBlaze;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

public class T2_SignInPage extends BaseClass {
	
	@Test(priority = 1)
	public void validateUrl() {
		String actUrl = p2.getAppUrl();
		AssertJUnit.assertTrue(actUrl.contains("demoblaze"));
		System.out.println("Url matched....." + actUrl);
	}

	@Test(priority = 2)
	public void validateTitle() {
		String actTitle = p2.getAppTiTle();
		AssertJUnit.assertTrue(actTitle.contains("STORE"));
		System.out.println("Title matched....." + actTitle);
	}

	@Test(priority = 3)
	public void Dologin() {
		p2.doLogin(prop.getData("username"), prop.getData("password"));
		System.out.println(prop.getData("username") + "   " + prop.getData("password"));		
	}
}
