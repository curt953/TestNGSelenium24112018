package dayEight;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeSuite;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;

public class GmailWithNoPageFactory {
  WebDriver driver;
  String emailInputId = "identifierId";
  String emailNextButtonId = "identifierNext";
  String passwordInputXpath = "//div[@class='Xb9hP']/input[@class='whsOnd zHQkBf']";
  String passwordNextButtonXpath = "//div[@id='passwordNext']/content[@class='CwaK9']";
  String writeNewEmailButtonXpath = "//div[@id=':44']/div[@class='z0']/div[@class='T-I J-J5-Ji T-I-KE L3']";
  String emailToSendInputId = ":9i";
  String emailSubjectInputId = ":90";
  String emailContentInputId = ":a5";
  String emailSendButtonId = ":8q";
  String emailAccountButtonXpath = "//a[@class='gb_b gb_hb gb_R']";
  String emailAccountSignOutButtonId = "gb_71";
  
  @BeforeSuite
  public void beforeSuite() {
	  System.setProperty("webdriver.gecko.driver", 
	  "D:\\Documents\\Software University\\QA\\Resources\\Webdriver\\geckodriver\\geckodriver.exe");
	  driver = new FirefoxDriver();
	    
	  driver.manage().window().maximize();
	  driver.manage().deleteAllCookies();
	  driver.get("https://www.gmail.com");
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
  }
	
  @Test(priority=0)
  public void loginToGmail() {
	  driver.findElement(By.id(emailInputId)).sendKeys("svilen.nikolov953@gmail.com");
	  driver.findElement(By.id(emailNextButtonId)).click();
	  
	  for(String winHandle : driver.getWindowHandles()) {
		  driver.switchTo().window(winHandle);
	  }
	  
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  driver.findElement(By.xpath(passwordInputXpath)).sendKeys("Zapomnime1!");
	  driver.findElement(By.xpath(passwordNextButtonXpath)).click();
	  
	  for(String winHandle : driver.getWindowHandles()) {
		  driver.switchTo().window(winHandle);
	  }
  }
  
  @Test(priority=1)
  public void sendEmail() {
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  driver.findElement(By.xpath(writeNewEmailButtonXpath)).click();
	  driver.findElement(By.id(emailToSendInputId)).sendKeys("svilen.nikolov1@abv.bg");
	  driver.findElement(By.id(emailSubjectInputId)).sendKeys("Test");
	  driver.findElement(By.id(emailContentInputId)).sendKeys("Test");
	  driver.findElement(By.id(emailSendButtonId)).click();
  }
  
  @Test(priority=2)
  public void logoutFromGmail() {
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  driver.findElement(By.xpath(emailAccountButtonXpath)).click();
	  driver.findElement(By.id(emailAccountSignOutButtonId)).click();
  }
 
}