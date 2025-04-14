package firsttestngpackage;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;
import org.testng.annotations.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ThirdTestNGFile {
    public String baseUrl = "https://magento.softwaretestingboard.com";
    String driverPath = "C:\\chromedriver\\chromedriver-win64\\chromedriver.exe";
    public WebDriver driver ; 
    
     @BeforeTest
  public void launchBrowser() {
	  System.out.println("launching chrome browser"); 
      System.setProperty("webdriver.chrome.driver", driverPath);
      driver = new ChromeDriver();
      driver.get(baseUrl);
  }
  @BeforeMethod
  public void backToHome() {
	  driver.get(baseUrl);
   }
  
@Test
  public void Liste() {
	Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(2));
	
	driver.findElement(By.linkText("Create an Account")).click();
	
	WebElement first = driver.findElement(By.name("firstname"));
	wait.until(ExpectedConditions.visibilityOf(first));
	first.sendKeys("bbccdd");
	driver.findElement(By.name("lastname")).sendKeys("bbccdd");
		driver.findElement(By.name("email")).sendKeys("eeffgg@gmail.com");
	driver.findElement(By.name("password")).sendKeys("bbbCCC123");
	driver.findElement(By.name("password_confirmation")).sendKeys("bbbCCC123");
	driver.findElement(By.cssSelector("[title=\'Create an Account\']")).click();
	
	String poruka = driver.findElement(By.cssSelector("[data-bind=\'html: $parent.prepareMessageForHtml(message.text)\']")).getText();
	System.out.println(poruka);
	assertEquals(poruka, "Thank you for registering with Main Website Store.");
	
	//List<WebElement> lista = driver.findElements(By.cssSelector(".product-items.widget-product-grid .product-item"));
	//System.out.println(lista.size());
	//wait.until(ExpectedConditions.numberOfElementsToBe(By.cssSelector(".product-items.widget-product-grid .product-item"), 6));
	//for(WebElement element: lista) {
	//	WebElement slika = element.findElement(By.cssSelector(".product-image-photo"));
//		WebElement slika = element.findElement(By.cssSelector("img"));
	//	wait.until(ExpectedConditions.visibilityOf(slika));
				
	//	assertTrue(slika.isDisplayed());
		
	}
//	WebElement prvi=lista.getFirst();
//	String naziv=prvi.findElement(By.linkText("Radiant Tee")).getText();
	
  
	  
//	prvi.click();
//	wait.until(ExpectedConditions.textToBe(By.cssSelector(".base"), naziv));
	
	
   

	  
//  }
  
}