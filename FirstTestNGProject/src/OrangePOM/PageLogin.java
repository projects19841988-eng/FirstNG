package OrangePOM;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class PageLogin {
	
//	public String baseUrl = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
//    public String driverPath = "C:\\chromedriver\\chromedriver-win64\\chromedriver.exe";
     WebDriver driver ; 
    WebDriverWait wait; 
	
//	@FindBy(name = "username")
	@FindBy(xpath = "//*[@name=\'username\']")
	//*[@id="app"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[1]/div/div[2]/input
	WebElement uname;
	
	@FindBy(name = "password")
	WebElement password;
	
	@FindBy(css = ".oxd-button.oxd-button--medium.oxd-button--main.orangehrm-login-button")
	WebElement buttonLogin;
	

	
	public PageLogin(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		
		}
	
	public void enterUsername(String un) {
		wait.until(ExpectedConditions.visibilityOf(uname));
		uname.sendKeys(un);
	}

	public void enterPassword(String pw) {
		password.sendKeys(pw);
	}
	
	public void clickLogin() {
		buttonLogin.click();
	}
}

