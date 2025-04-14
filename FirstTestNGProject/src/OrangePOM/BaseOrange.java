package OrangePOM;

import org.openqa.selenium.chrome.ChromeDriver;

import OrangePOM.PageLogin;
import OrangePOM.PageDashboard;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;
import org.testng.annotations.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseOrange {
	  public String baseUrl = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
	  public String driverPath = "C:\\chromedriver\\chromedriver-win64\\chromedriver.exe";
	  public WebDriver driver ; 
	  public PageLogin plogin;
	  public PageDashboard pdashboard;
	
	  @BeforeTest  (alwaysRun = true)
	public void launchBrowser() {
		  System.out.println("launching chrome browser"); 
		  System.setProperty("webdriver.chrome.driver", driverPath);
	      driver = new ChromeDriver();
	      driver.get(baseUrl);
	      plogin = new PageLogin(driver);
	      pdashboard = new PageDashboard(driver);

	  }
	  @BeforeMethod  (alwaysRun = true)
	  public void backToHome() {
		  driver.get(baseUrl);
	  }  
	  @AfterMethod  (alwaysRun = true)
		  public void ToHome() {
			  driver.get(baseUrl);
	   }
//	  @AfterTest
//	  public void Cclose() {
//		  driver.close();
//	   }

}
