package dayEight;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class VerifyFacebookLogin {

  @Test
  public void checkValidUser() {
	  System.setProperty("webdriver.gecko.driver", 
	  "D:\\Documents\\Software University\\QA\\Resources\\Webdriver\\geckodriver\\geckodriver.exe");
	  WebDriver driver = new FirefoxDriver();
	  driver.get("https://www.facebook.com");
	  driver.manage().window().maximize();
	  POMDemoWithPageFactory login_page = PageFactory.initElements(driver, POMDemoWithPageFactory.class);
	  login_page.login_facebook("dragonage_origins@abv.bg", "zapomnime");
  }

}