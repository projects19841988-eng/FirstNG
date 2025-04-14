package OrangePOM;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import OrangePOM.PageLogin;

public class testloginproba2 extends BaseOrange {
//	WebElement username;
	//WebElement password;
//	WebElement buttonLogin;
	
	  


	@DataProvider 
	public Object[][] nazivDataProvidera() {
	 return new Object [][] {{1,"", ""}, {2,"", "aaa"}, {3,"aaa", "aaa"}, {4,"Admin", "admin123"}};
	}

	
	@Test (dataProvider = "nazivDataProvidera")
	public void enterUsernamePassword(Integer id, String username, String password) {
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		System.out.println(driver.getCurrentUrl());
		System.out.println(id);
		plogin.enterUsername(username);
		plogin.enterPassword(password);
		plogin.clickLogin();
		
	}
	

}
