package pack.crm.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import junit.framework.Assert;
import pack.crm.base.TestBase;
import pack.crm.pages.ContactsPage;
import pack.crm.pages.HomePage;
import pack.crm.pages.LoginPage;
import pack.crm.utils.TestUtil;

public class ContactsPageTest extends TestBase {
	
	LoginPage loginpage;
	HomePage homepage;
	ContactsPage contactspage;
	TestUtil testutil;
	//String sheetname="contacts";
	
	@Test(priority=1)
	public void verifyContactsPageLabelTest() {
		Assert.assertTrue(contactspage.verifyContactsLabel());
	}
	
	@Test(priority=2)
	public void selectContactsByNametest() {
		contactspage.selectContactsByName("test2 test2");
		//testutil.takeScreenShot();
	}
	@DataProvider
	public Object[][] getCRMData() {		
		Object[][] data=TestUtil.getTestdata("contacts");

	return data;
	
		
	}
	
	@Test (priority=3,dataProvider="getCRMData")
	public void validateCreateNewContact(String title,String firstname,String lastname) {
		homepage.clickOnNewContactsLink();
		contactspage.createNewContact(title,firstname,lastname);
		
	}
	
	
	  @BeforeMethod
	  public void setup() throws InterruptedException {
		  initialization();
		  
		  loginpage=new LoginPage();
		  testutil=new TestUtil();
		  contactspage= new ContactsPage();
		 // Thread.sleep(3000);
		 
		  WebDriverWait wait=new WebDriverWait(driver, 20);
		  driver.switchTo().frame("intercom-borderless-frame");
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class=\"intercom-reply-to-button\"]")));
		  driver.switchTo().defaultContent();
		 
		 homepage= loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		 testutil.switchtoFrame();
		contactspage= homepage.clickOnContactsLink();
		  //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),\"Contacts\")]")));
		  Thread.sleep(3000);
	 

			
	  
	  }

	  @AfterMethod
	  public void tearDown() {
		  driver.quit();
	  }


}
