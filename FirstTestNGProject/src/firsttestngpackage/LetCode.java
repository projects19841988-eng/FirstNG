package firsttestngpackage;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LetCode {
	
	public String baseUrl = "https://letcode.in/test";
    String driverPath = "C:\\chromedriver\\chromedriver-win64\\chromedriver.exe";
    public WebDriver driver ; 
    
     @BeforeTest
  public void launchBrowser() {
	 // System.out.println("launching chrome browser"); 
      System.setProperty("webdriver.chrome.driver", driverPath);
      driver = new ChromeDriver();
      driver.get(baseUrl);
  }
  @BeforeMethod
  public void backToHome() {
	  driver.get(baseUrl);
  }
  
  @Test
  public void dropdown() {
  WebElement dd = driver.findElement(By.linkText("Drop-Down"));
//  System.out.println(dd.getText());
	Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(2));
	wait.until(ExpectedConditions.elementToBeClickable(dd));
	
	String p1 = driver.getWindowHandle();
	System.out.println(p1);
	
  dd.click();

	  WebElement select1 = driver.findElement(By.id("fruits"));
	  Select dropdown = new Select(select1);
	  dropdown.selectByIndex(2);
	  assertEquals(driver.findElement(By.cssSelector(".notification.is-success")).getText(), "You have selected Mango");
	  
  
  }
  	 
}
