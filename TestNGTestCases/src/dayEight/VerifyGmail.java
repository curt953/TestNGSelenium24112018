package dayEight;

import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;

public class VerifyGmail {
  
  @Test
  public void verifyGmail() {
	  System.setProperty("webdriver.gecko.driver", 
	  "D:\\Documents\\Software University\\QA\\Resources\\Webdriver\\geckodriver\\geckodriver.exe");
	  WebDriver driver = new FirefoxDriver();
	  
	  driver.manage().window().maximize();
	  driver.manage().deleteAllCookies();
	  driver.get("https://www.gmail.com");
	  
	  GmailWithPageFactory gmail_account = PageFactory.initElements(driver, GmailWithPageFactory.class);
	  gmail_account.login_gmail("svilen.nikolov953@gmail.com", "Zapomnime1!");
	  gmail_account.send_email("svilen.nikolov1@abv.bg", "Test", "Test");
	  gmail_account.logout_gmail();
  }
  
}