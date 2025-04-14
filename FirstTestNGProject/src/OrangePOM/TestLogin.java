package OrangePOM;
import org.testng.annotations.*;

import com.google.common.io.Files;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;
import java.util.logging.FileHandler;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import OrangePOM.PageLogin;

public class TestLogin extends BaseOrange {
//	WebElement username;
	//WebElement password;
//	WebElement buttonLogin;
	
	WebDriverWait  wait = new WebDriverWait(driver, Duration.ofSeconds(5));


	@DataProvider 
	public Object[][] nazivDataProvidera() {
	 return new Object [][] {{1,"", ""}, {2,"", "aaa"}, {3,"aaa", "aaa"}, {4,"Admin", "admin123"}};
	}

	@Test(priority=0)
	public void empty() throws IOException
	{
		plogin.enterUsername("");
		plogin.enterPassword("");
		plogin.clickLogin();
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		// Now you can do whatever you need to do with it, for example copy somewhere
		Files.copy(scrFile, new File("d:\\screenshot.png"));
		
	}
	
	@Test(priority=1)
	public void wrong() throws IOException, InterruptedException
	{
		plogin.enterUsername("aaa");
		plogin.enterPassword("aaa");
		plogin.clickLogin();
		Thread.sleep(5000);
//		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector(".orangehrm-login-slot"))));
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		// Now you can do whatever you need to do with it, for example copy somewhere
		Files.copy(scrFile, new File("d:\\screenshot1.png"));

	}

	@Test(priority=2)
	public void aempty() throws IOException
	{
		plogin.enterUsername("");
		plogin.enterPassword("aaa");
		plogin.clickLogin();
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		// Now you can do whatever you need to do with it, for example copy somewhere
		Files.copy(scrFile, new File("d:\\screenshot2.png"));

		
	}

	@Test(priority=3, groups="grouping")
	public void correct() throws InterruptedException, IOException 
	{
		plogin.enterUsername("Admin");
		plogin.enterPassword("admin123");
		plogin.clickLogin();
		Thread.sleep(5000);
//		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector(".orangehrm-login-slot"))));
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		// Now you can do whatever you need to do with it, for example copy somewhere
		Files.copy(scrFile, new File("d:\\screenshot3.png"));

//		driver.navigate().back();

		
	}
//	@Test (priority=4, dataProvider = "nazivDataProvidera")
//	public void enterUsernamePassword(Integer id, String username, String password) throws IOException {
//		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		
//		driver.get(baseUrl);
//		System.out.println(driver.getCurrentUrl());
//		System.out.println(id);
//		plogin.enterUsername(username);
//		plogin.enterPassword(password);
//		plogin.clickLogin();

		
//	}
	

}
