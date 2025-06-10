package OrangeHRM_POM;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.Assert;
import org.testng.annotations.Test;

public class T1_LoginPage extends BaseClass {

	@Test(priority = 1)
	public void validateUrl() {
		String actUrl = lpage.getAppUrl();
		AssertJUnit.assertTrue(actUrl.contains("orangehrm"));
		System.out.println("Url matched....." + actUrl);
	}

	@Test(priority = 2)
	public void validateTitle() {
		String actTitle = lpage.getAppTiTle();
		AssertJUnit.assertTrue(actTitle.contains("OrangeHRM"));
		System.out.println("Title matched....." + actTitle);
	}

	@Test(priority = 3)
	public void validatelogin() {
		lpage.doLogin(prop.getData("un"), prop.getData("pw"));
		System.out.println(prop.getData("un") + "   " + prop.getData("pw"));
		String dashboardUrl = lpage.getAppUrl();
		AssertJUnit.assertTrue(dashboardUrl.contains("dashboard"));
		System.out.println("Title matched....." + dashboardUrl);
	}
}
