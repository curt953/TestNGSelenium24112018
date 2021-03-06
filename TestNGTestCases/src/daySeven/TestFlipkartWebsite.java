package daySeven;

import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class TestFlipkartWebsite {
 
  WebDriver driver;
	
  @BeforeSuite(groups="Invoke browser and go to url")
  public void invokeBrowser() {
	  System.setProperty("webdriver.chrome.driver", 
	  "D:\\Documents\\Software University\\QA\\Resources\\Webdriver\\chromedriver\\chromedriver.exe");
	  driver = new ChromeDriver();
	  
	  driver.manage().window().maximize();
	  driver.manage().deleteAllCookies();
	  driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
	  driver.manage().timeouts().setScriptTimeout(100, TimeUnit.SECONDS);
	  driver.get("https://www.flipkart.com");
	  driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
  }
  
  @Test(groups="Search for product", priority=0)
  public void searchAndFindSeleniumBook() {
	  driver.findElement(By.xpath("/html/body/div[2]/div/div/button")).click();
	  driver.findElement(By.xpath("/html/body/div[1]/div/header/div[1]/div/div[2]/form/div/div[1]/div/input")).clear();
	  driver.findElement(By.xpath("/html/body/div[1]/div/header/div[1]/div/div[2]/form/div/div[1]/div/input")).sendKeys("Selenium");
	  driver.findElement(By.xpath("/html/body/div[1]/div/header/div[1]/div/div[2]/form/div/div[2]/button")).click();
  }
  
  @Test(groups="Search for product and add to cart", priority=1)
  public void checkIfProductIsDeliveredAndAddToCart() {
	  String winHandleBefore = driver.getWindowHandle();
	  driver.findElement(By.linkText("Selenium WebDriver 1st  Edition")).click();
	  for(String winHandle : driver.getWindowHandles()) {
		  driver.switchTo().window(winHandle);
	  }
	  driver.findElement(By.id("pincodeInputId")).sendKeys("560034");
	  driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/div[2]/div/div[1]/div[2]/div[4]/div/div/div[1]/div[2]/div/div[2]/div[1]/span")).click();
	  String deliveryText = driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/div[2]/div/div[1]/div[2]/div[4]/div/div/div[2]/div[1]/ul/div/div")).getText();
	  System.out.println("The delivery duration is: " + deliveryText);
	  driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/div[2]/div/div[1]/div[1]/div[2]/div/ul/li[1]/button")).click();
	  driver.close();
	  driver.switchTo().window(winHandleBefore);
  }
  
  @Test(groups="Check out order and catch exception", priority=2)
  public void checkOutWithRandomUserAndCatchException() throws IOException {
	  try {
		String winHandleBefore = driver.getWindowHandle();
		  driver.findElement(By.xpath("/html/body/div[1]/div/header/div[1]/div/div[3]/a/div")).click();
		  for(String winHandle : driver.getWindowHandles()) {
			  driver.switchTo().window(winHandle);
		  }
		  driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/div/div[1]/div/div[3]/div/div/form/button")).click();
		  for(String winHandle : driver.getWindowHandles()) {
			  driver.switchTo().window(winHandle);
		  }
		  driver.findElement(By.xpath("/html/body/div/div/div[1]/div/div[1]/div[1]/div/div/div/div/div[1]/div/form/div[1]/input")).sendKeys("test@test.test");
		  File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		  FileUtils.copyFile(srcFile, "c:\\tmp\\screenshot.png");
		  driver.close();
		  driver.switchTo().window(winHandleBefore);
	} catch (IOException e) {
		e.getMessage();
	}
  }

  @AfterSuite(groups="Close browser")
  public void closeBrowser() {
	  driver.quit();
  }
  
}