package firsttestngpackage;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Sale {
	
	public String baseUrl = "https://practice.automationtesting.in/shop/";
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
  public void onSale() {
	  
	  List<WebElement> products = driver.findElements(By.cssSelector(".woocommerce-LoopProduct-link"));
	  for(WebElement product: products) {
		  List<WebElement> prices = product.findElements(By.cssSelector(".woocommerce-Price-amount.amount"));
		  if(prices.size() == 2) {
			  System.out.println("Proizvod je na snizenju");
			  //assertEquals(product.findElement(By.cssSelector(".onsale")).getText(), "SALE!");
			  assertTrue(product.getText().contains("SALE!"));
		  }
		  else {
			  assertFalse(product.getText().contains("SALE!"));
		  }
	  }
  }
}
