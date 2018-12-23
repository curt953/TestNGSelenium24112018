package dayEight;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.*;
import org.testng.annotations.*;

public class POMDemoWithPageFactory {
  
  WebDriver driver;
	
  public POMDemoWithPageFactory(WebDriver ldriver) {
	  this.driver = ldriver;
  }
  
  @FindBy(id="email")
  @CacheLookup
  WebElement email;
  
  @FindBy(id="pass")
  @CacheLookup
  WebElement password;
  
  @FindBy(id="u_0_2")
  @CacheLookup
  WebElement submit_button;
  
  @Test
  public void login_facebook(String uid, String pass) {
	  email.sendKeys(uid);
	  password.sendKeys(pass);
	  submit_button.click();
  }
}
