package daySix;

import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.*;
import org.testng.annotations.*;

public class TestEdurekaProtal {
	
	WebDriver driver;
	
	@BeforeSuite
	public void launchBrowser() {
		System.setProperty("webdriver.chrome.driver", 
		"D:\\Documents\\Software University\\QA\\Resources\\Webdriver\\chromedriver\\chromedriver.exe");
		driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().timeouts().setScriptTimeout(100, TimeUnit.SECONDS);
		driver.get("https://www.edureka.co");
	}
	
	@Test(groups={"Login with owned account"}, priority=0)
	public void login() {
		driver.findElement(By.linkText("Log In")).click();
		driver.findElement(By.id("si_popup_email")).sendKeys("svilen.nikolov1@abv.bg");
		driver.findElement(By.id("si_popup_passwd")).sendKeys("Zapomni1");
		driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div/div[2]/div[3]/form/button")).click();
	}
	
	@Test(groups={"Login with owned account"}, priority=1)
	public void browseCourses() {
		driver.findElement(By.id("homeSearchBar")).sendKeys("Selenium");
		driver.navigate().back();
	}
	
	@Test(groups={"Login with owned account"}, priority=2)
	public void logout() {
		driver.findElement(By.xpath("/html/body/div[3]/header/section/nav/div/ul[2]/li[1]/a")).click();
		driver.findElement(By.linkText("Log Out")).click();
	}
	
	@Test(groups={"Exception handling"}, priority=3)
	public void registerWithExistingAccount() {
		driver.findElement(By.linkText("Sing Up")).click();
		driver.findElement(By.id("sg_popup_email")).sendKeys("svilen.nikolov1@abv.bg");
		driver.findElement(By.id("sg_popup_phone_no")).sendKeys("884424046");
		driver.findElement(By.id("tc_agree")).click();
		driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div/div[2]/div[1]/form/button")).click();
	}
	
}