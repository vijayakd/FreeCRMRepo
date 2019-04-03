package pack.crm.testcases;

import org.testng.annotations.Test;

import pack.crm.testdata.HashMapTestData;
//import pack.crm.testdata.HashMapTestData;
import pack.crm.utils.WebEventlistener;

import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;

public class FreeCRMHashMapTest {
	
	  public WebDriver driver;

		public static EventFiringWebDriver e_driver;
		public static WebEventlistener eventlistenet;
  @Test
  public void loginwithUser1Credentials() {

	  String user1cred=HashMapTestData.getUserLoginInfo().get("user1");
	  String user1Arr[]=user1cred.split("-");
  
	  driver.findElement(By.name("username")).sendKeys(user1Arr[0]);
	  driver.findElement(By.name("password")).sendKeys(user1Arr[1]);
	  
	  WebElement loginbtn=driver.findElement(By.className("btn btn-small"));
	  JavascriptExecutor js= (JavascriptExecutor)driver;
	  js.executeScript("arguments[0].click()", loginbtn);
	  driver.switchTo().frame("mainpanel");

	  WebElement month_dd=driver.findElement(By.xpath("//select[@name=\"slctMonth\"]"));
	  WebElement year_dd=driver.findElement(By.xpath("//select[@name=\"slctYear\"]"));
	  Select select_mon=new Select(month_dd);
	  select_mon.selectByVisibleText(HashMapTestData.monthMap().get(12));
	  Select select_yr=new Select(year_dd);
	  

  }
  @BeforeMethod
  public void setup() throws InterruptedException {
		 System.setProperty("webdriver.chrome.driver","C:\\Users\\vijay\\Downloads\\chromedriver_win32\\chromedriver.exe");
	        driver = new ChromeDriver();
	        
	        e_driver = new EventFiringWebDriver(driver)	;
	    	eventlistenet =new WebEventlistener();
	    	e_driver.register(eventlistenet);
	    	driver=e_driver;
	    	
	        driver.manage().window().maximize();
       driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
       driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
       driver.get("https://classic.crmpro.com/index.html");
       WebDriverWait wait=new WebDriverWait(driver, 10);
 	  driver.switchTo().frame("intercom-borderless-frame");
 	  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class=\"intercom-reply-to-button\"]")));
 	  driver.switchTo().defaultContent();        
  }

  @AfterMethod
  public void tearddown() {
	  driver.quit();
  }

}
