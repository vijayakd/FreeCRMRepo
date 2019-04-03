package pack.crm.testcases;

import org.testng.annotations.Test;

import junit.framework.Assert;
import pack.crm.base.TestBase;
import pack.crm.pages.ContactsPage;
import pack.crm.pages.HomePage;
import pack.crm.pages.LoginPage;
import pack.crm.utils.TestUtil;

import org.testng.annotations.BeforeMethod;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;

public class HomePageTest extends TestBase {
//WebDriver driver;
	LoginPage loginpage;
	HomePage homepage;
	ContactsPage contactspage;
	TestUtil testutil;
	
	public  HomePageTest() {
	  super();
  }
	
	@Test(priority=1)
	public void verifyHomePageTitleTest() throws IOException {
		driver.switchTo().frame("mainpanel");
		String homepagetitle=homepage.verifyHomePageTitle();
	Assert.assertEquals(homepagetitle, "CRMPRO");
	TestUtil.takeScreenShot();
	
	}
	
	
	@Test(priority=2)
	public void verifyuserNameTest() throws IOException {
	           testutil.switchtoFrame();
		boolean result=homepage.verifyCorrectUserName();
	Assert.assertTrue(result);	
	TestUtil.takeScreenShot();

	}
	
	@Test(priority=3)
	public void verrifyContactsLinkTest() {
contactspage=homepage.clickOnContactsLink();	
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
  @BeforeMethod
  public void setup() throws InterruptedException {
	  initialization();
	  loginpage=new LoginPage();
	  testutil=new TestUtil();
	 // Thread.sleep(3000);
	 
	  WebDriverWait wait=new WebDriverWait(driver, 20);
	  driver.switchTo().frame("intercom-borderless-frame");
	  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class=\"intercom-reply-to-button\"]")));
	  driver.switchTo().defaultContent();
	 
	  loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
	  //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),\"Contacts\")]")));
	  Thread.sleep(3000);
 

		
  
  }

  @AfterMethod
  public void tearDown() {
	  driver.quit();
  }

}
