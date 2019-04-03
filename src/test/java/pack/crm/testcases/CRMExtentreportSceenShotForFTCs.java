package pack.crm.testcases;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class CRMExtentreportSceenShotForFTCs {
	
	public WebDriver driver;
	public ExtentReports extent;
	public ExtentTest extenttest;
	
	  public static String getScreenShot(WebDriver driver,String screenshotname) throws IOException {
		  String dateName=new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		  File src= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		  String destination =System.getProperty("user.dir")+"/failedtcscreenshots/"+screenshotname+dateName+".png";
		  File finaldestination= new File(destination);
		  FileUtils.copyFile(src, finaldestination);
		  return destination;
	  }
@Test
public void test1() {
	  extenttest=extent.startTest("test1");

	Assert.assertEquals(true, false);
}
	
  @Test
  public void freeCRMTitleTest() {
	  extenttest=extent.startTest("freeCRMTitleTest");
	  String title=driver.getTitle();
	  System.out.println("title==="+title);
	  Assert.assertEquals(title, "CRMPRO  - CRM software for customer relationship management, sales, and support.");
	  
  }
  
  
  @BeforeMethod
  public void setup() {
	  System.setProperty("webdriver.chrome.driver","C:\\Users\\vijay\\Downloads\\chromedriver_win32\\chromedriver.exe");
		driver=new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://classic.crmpro.com/index.html");
  }

  @AfterMethod
  public void teardown(ITestResult result) throws IOException {
	  if(result.getStatus()==ITestResult.FAILURE) {
		  extenttest.log(LogStatus.FAIL, "TestCase Failed Is===="+result.getName());
		  extenttest.log(LogStatus.FAIL, "Exception Encountered is==="+result.getThrowable());
		  String screenshotpath=CRMExtentreportSceenShotForFTCs.getScreenShot(driver, result.getName());
		  extenttest.log(LogStatus.FAIL, extenttest.addScreenCapture(screenshotpath));
	  }else
		  if(result.getStatus()==ITestResult.SKIP) {
			  extenttest.log(LogStatus.SKIP, "TestCase skipped Is===="+result.getName());
		  
		  }else
			  if(result.getStatus()==ITestResult.SUCCESS) {
				  extenttest.log(LogStatus.PASS, "TestCase Passed Is===="+result.getName());
			  }
		extent.endTest(extenttest);
		   driver.quit();
  }

  @BeforeTest
  public void setExtent() {
	  extent=new ExtentReports("C:\\Users\\vijay\\eclipse-workspace\\FreeCRMTest\\test-output\\Extent.html")																																																		;
      /* extent.addSystemInfo("UserName", "Vijaya") ;
       extent.addSystemInfo("HostName", "VijayaOS") ;
       extent.addSystemInfo("Environment", "QA") ;
*/
  }

  @AfterTest
  public void endReport() {
	  extent.flush();
extent.close();
	  
	  
	  
  }

}
