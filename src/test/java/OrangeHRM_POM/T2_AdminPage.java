package OrangeHRM_POM;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.*;

public class T2_AdminPage extends BaseClass {

	@BeforeClass
	public void pageSetUp() {
		apage = lpage.doLogin(prop.getData("un"), prop.getData("pw"));
	}

	@Test(priority = 1, description = "This is for search List--------")
	public void adminpage() {
		apage.searchAdmin(prop.getData("un"));
	}

	@Test(priority = 2, description = "This is for search By UserName--------")
	public void userName() {
		apage.selectByUserName(prop.getData("un"));
	}

	@Test(priority = 3, description = "This is for search By UserRole--------")
	public void userRole() {
		apage.selectByUserRole(prop.getData("role"));
	}

	@Test(priority = 4, description = "This is for search By UserStatus--------")
	public void userStatus() {
		apage.selectByUserStatus(prop.getData("status"));
	}
}
