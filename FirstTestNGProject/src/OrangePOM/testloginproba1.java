package OrangePOM;
import org.testng.annotations.*;

import com.google.common.io.Files;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import OrangePOM.PageLogin;

public class testloginproba1 extends BaseOrange {
//	WebElement username;
	//WebElement password;
//	WebElement buttonLogin;
	
	  


	@Test(priority=0)
	public void empty()
	{
		plogin.enterUsername("");
		plogin.enterPassword("");
		plogin.clickLogin();
		
	}
	
	@Test(priority=1)
	public void wrong() throws IOException
	{
		plogin.enterUsername("aaa");
		plogin.enterPassword("aaa");
		plogin.clickLogin();

		
	}
	@Test(priority=2, groups="grouping")
	public void emptyUsername() throws IOException
	{
		plogin.enterUsername("");
		plogin.enterPassword("aaa");
		plogin.clickLogin();
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		// Now you can do whatever you need to do with it, for example copy somewhere
		Files.copy(scrFile, new File("d:\\screenshot2.png"));
		}
	@Test(priority=3)
	public void correct() throws IOException
	{
		plogin.enterUsername("Admin");
		plogin.enterPassword("admin123");
		plogin.clickLogin();

	}
}
