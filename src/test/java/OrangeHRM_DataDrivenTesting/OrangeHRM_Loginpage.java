package OrangeHRM_DataDrivenTesting;
import org.testng.annotations.Test;
import generic.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class OrangeHRM_Loginpage {	
  @Test(dataProvider = "excelfile",dataProviderClass = CustomData.class)
   public void LoginPage(String un,String pw) throws InterruptedException {
	
	  WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		
		//2 Pass cases and 2 Fail cases
		  driver.findElement(By.name("username")).sendKeys(un);
		  driver.findElement(By.name("password")).sendKeys(pw);
		  System.out.println(un+ "  "+pw);
		  Utility.getScreenshot(driver, "orangehrm");
		  driver.findElement(By.xpath("//button[@type='submit']")).click();	  
		  Thread.sleep(4000);
		  Utility.getScreenshot(driver, "loginhrm");
		  			 
		  //validation
		  Assert.assertTrue(driver.getCurrentUrl().contains("dashboard"),"Login Fail for Invalid Credentials");
		  System.out.println("Login successful");	   
		  Thread.sleep(3000);	
		  //Logout
		  driver.findElement(By.xpath("//i[@class='oxd-icon bi-caret-down-fill oxd-userdropdown-icon']")).click();
		  driver.findElement(By.linkText("Logout")).click();
	driver.quit();
  }
}
