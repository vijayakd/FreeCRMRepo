package pack.crm.testcases;

import org.testng.annotations.Test;

import pack.crm.base.TestBase;
import pack.crm.pages.HomePage;
import pack.crm.pages.LoginPage;

import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class LoginPageTest extends TestBase {
	LoginPage loginpage;
	HomePage homepage;
 
	public  LoginPageTest() {
	  super();
  }
  
  @Test(priority=1)
public void loginPageTitleTest() {
	  String title=loginpage.validateLoginPageTitle();
	  System.out.println("title=============="+title);
	  Assert.assertEquals(title, "CRMPRO - CRM software for customer relationship management, sales, and support.");
  }
  
  @Test(priority=2)
  public void crmImageTest() {
	boolean result=loginpage.validateCRMImage();
	Assert.assertTrue(result);
  }
  
  @Test(priority=3)
  public void loginTest() {
	  homepage= loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
  }
  @BeforeMethod
  public void setUp() throws InterruptedException {
	  initialization();
	  
	  loginpage=new LoginPage();
	 // Thread.sleep(3000);
	  WebDriverWait wait=new WebDriverWait(driver, 10);
	  driver.switchTo().frame("intercom-borderless-frame");
	  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class=\"intercom-reply-to-button\"]")));
	  driver.switchTo().defaultContent();
  }

  @AfterMethod
  public void afterMethod() {
	  driver.quit();
  }

}
