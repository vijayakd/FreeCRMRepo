package pack.crm.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import pack.crm.utils.TestUtil;
import pack.crm.utils.WebEventlistener;

public class TestBase {
	public static WebDriver driver;
	public static Properties prop;
	static FileInputStream fis;
/*
	public static EventFiringWebDriver e_driver;
	public static WebEventlistener eventlistenet;
	
*/	
	public TestBase()  {
		 prop = new Properties();
		//FileInputStream fis;
		try {
			fis = new FileInputStream("C:\\Users\\vijay\\eclipse-workspace\\FreeCRMTest\\src\\main\\java\\pack\\crm\\config\\config.properties");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			prop.load(fis);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void initialization() {
	String browserName = prop.getProperty("browser");
	if(browserName.equalsIgnoreCase("chrome")) {
		
				System.setProperty("webdriver.chrome.driver","C:\\Users\\vijay\\Downloads\\chromedriver_win32\\chromedriver.exe");
				 driver = new ChromeDriver();
	}else
		if(browserName.equalsIgnoreCase("ff")) {
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\vijay\\Downloads\\geckodriver-v0.24.0-win64\\geckodriver.exe");
			    driver = new FirefoxDriver();
		}	
	/*
	e_driver = new EventFiringWebDriver(driver)	;
	eventlistenet =new WebEventlistener();
	e_driver.register(eventlistenet);
	driver=e_driver;
	*/
	
	driver.manage().window().maximize();
	driver.manage().deleteAllCookies();
	driver.manage().timeouts().pageLoadTimeout(TestUtil.page_load_timeout, TimeUnit.SECONDS);
	driver.manage().timeouts().implicitlyWait(TestUtil.implicit_wait, TimeUnit.SECONDS);
	driver.get(prop.getProperty("url"));
	}
	

}
