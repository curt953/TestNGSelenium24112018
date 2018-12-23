package dayEight;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.*;
import org.testng.annotations.*;

public class GmailWithPageFactory {
  
  WebDriver driver;
  
  public GmailWithPageFactory(WebDriver ldriver) {
	  this.driver = ldriver;
  }
	
  @FindBy(id="identifierId")
  @CacheLookup
  WebElement emailInputId;
  
  @FindBy(id="identifierNext")
  @CacheLookup
  WebElement emailNextButtonId;
  
  @FindBy(xpath="//div[@class='Xb9hP']/input[@class='whsOnd zHQkBf']")
  @CacheLookup
  WebElement passwordInputXpath;
  
  @FindBy(xpath="//div[@id='passwordNext']/content[@class='CwaK9']")
  @CacheLookup
  WebElement passwordNextButtonXpath;
  
  @FindBy(xpath="//div[@id=':44']/div[@class='z0']/div[@class='T-I J-J5-Ji T-I-KE L3']")
  @CacheLookup
  WebElement writeNewEmailButtonXpath;
  
  @FindBy(id=":9i")
  @CacheLookup
  WebElement emailToSendInputId;
  
  @FindBy(id=":90")
  @CacheLookup
  WebElement emailSubjectInputId;
  
  @FindBy(id=":a5")
  @CacheLookup
  WebElement emailContentInputId;
  
  @FindBy(id=":8q")
  @CacheLookup
  WebElement emailSendButtonId;
  
  @FindBy(xpath="//a[@class='gb_b gb_hb gb_R']")
  @CacheLookup
  WebElement emailAccountButtonXpath;
  
  @FindBy(id="gb_71")
  @CacheLookup
  WebElement emailAccountSignOutButtonId;
  
  @Test
  public void login_gmail(String uid, String pass) {
	  emailInputId.sendKeys(uid);
	  emailNextButtonId.click();
	  passwordInputXpath.sendKeys(pass);
	  passwordNextButtonXpath.click();
  }
  
  @Test
  public void send_email(String receiver, String subject, String content) {
	  writeNewEmailButtonXpath.click();
	  emailToSendInputId.sendKeys(receiver);
	  emailSubjectInputId.sendKeys(subject);
	  emailContentInputId.sendKeys(content);
	  emailSendButtonId.click();
  }
  
  public void logout_gmail() {
	  emailAccountButtonXpath.click();
	  emailAccountSignOutButtonId.click();
  }
  
}