package OrangeHRM_POM;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;

import generic.*;

public class BaseClass {

	public WebDriver driver;
	public P1_LoginPage lpage;
	public P2_AdminPage apage;
	public PropertiesUtil prop;

	@BeforeClass
	public void setUp() {

		prop = new PropertiesUtil("config");
		driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
		lpage = new P1_LoginPage(driver);
		apage = new P2_AdminPage(driver);
	}

}
