package pack.crm.testcases;

import org.testng.annotations.Test;

import pack.crm.utils.TestUtil;

import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;

public class PhantomJSTest {
	
	public WebDriver driver;
  @Test
  public void sampleTest() throws InterruptedException {
	  
	  
	  WebDriverWait wait=new WebDriverWait(driver, 20);
	  driver.switchTo().frame("intercom-borderless-frame");
	  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class=\"intercom-reply-to-button\"]")));
	  driver.switchTo().defaultContent();
	  

	  driver.findElement(By.name("username")).sendKeys("vijaya1979");
	  driver.findElement(By.name("password")).sendKeys("password");
	  
	  WebElement loginbtn=driver.findElement(By.className("btn btn-small"));
	  JavascriptExecutor js= (JavascriptExecutor)driver;
	  js.executeScript("arguments[0].click()", loginbtn);
	 
	  Thread.sleep(3000);
	  
  }
  @BeforeMethod
  public void setup() {
	  System.setProperty("PhantomJS.binary.path", "C:\\Users\\vijay\\Downloads\\phantomjs-2.1.1-windows\\phantomjs-2.1.1-windows\\bin\\phantomjs.exe");
	  driver=new PhantomJSDriver();
	  driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.page_load_timeout, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.implicit_wait, TimeUnit.SECONDS);
		driver.get("https://classic.crmpro.com/index.html");
	  System.out.println("Title before login  "+driver.getTitle());
	  
  }

  @AfterMethod
  public void teardown() {
	  driver.quit();
  }

}
