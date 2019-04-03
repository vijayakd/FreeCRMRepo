package pack.crm.testcases;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;

public class parcticeLog4j {
	
	 WebDriver driver;	
	 Logger log = Logger.getLogger("parcticeLog4j");

  @Test
  public void test1() {
	  log.info("*************************LOG  STARTING  TEST1************************");
	  System.out.println("IN TEST1");
	  log.info("*************************LOG  ENDING  TEST1************************");

	  
  }
  @BeforeMethod
  public void setup() {
	  log.info("*************************LOG LAUNCHING BROWSER************************");

		// WebDriver driver;	
		 System.setProperty("webdriver.chrome.driver","C:\\Users\\vijay\\Downloads\\chromedriver_win32\\chromedriver.exe");
			driver=new ChromeDriver();
			
			driver.manage().window().maximize();
			driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			driver.get("https://classic.crmpro.com/index.html");
			  log.info("*************************LOG  ENDING  SETUP************************");

  }

  @AfterMethod
  public void teardown() {
	  log.info("*************************LOG  STARTING  TEARDOWN************************");

	  driver.quit();
	  log.info("*************************LOG  BROWSER CLOSED************************");

  }

}
