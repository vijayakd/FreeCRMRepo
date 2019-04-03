package pack.crm.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import pack.crm.base.TestBase;

public class LoginPage extends TestBase{
	
	// In this class we r storing objects in login page
	//we have to define pagefactory or object Repository . In page factory we use @FindBy to locate elements

	
	//  Page Factory   or  OR
@FindBy(name="username")
WebElement username;

@FindBy(name="password")
WebElement password;

@FindBy(xpath="//div[@class=\"input-group-btn\"]//input[@type=\"submit\"]")
WebElement loginbtn;

@FindBy(xpath="//a[@class=\"navbar-brand\"]//img[contains(@class,\"img-responsive\")]")
WebElement crmlogoimg;


// Now initializing these webelements
public LoginPage() {
	PageFactory.initElements(driver, this);
}


//Now we perform some actions on this login page

public String validateLoginPageTitle() {
	return driver.getTitle();
}

public boolean validateCRMImage() {
	
	boolean result=crmlogoimg.isDisplayed();
	return result;
}

public HomePage login(String un,String pwd) {
	username.sendKeys(un);
	password.sendKeys(pwd);
	loginbtn.click();
	
	return new HomePage();
}





















}
