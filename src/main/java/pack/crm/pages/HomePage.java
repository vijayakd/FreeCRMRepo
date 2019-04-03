package pack.crm.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import pack.crm.base.TestBase;

public class HomePage extends TestBase{
	
	//Page Factory   ---Object Repository
	
	@FindBy(xpath="//td[contains(text(),\"User: vk d \")]")
	WebElement userNameLabel;
	
	@FindBy(xpath="//a[contains(text(),\"Contacts\")]")	
	WebElement contactsLink;
	
	@FindBy(xpath="//a[contains(text(),\"New Contact\")]")
    WebElement newContactsLink;
	
	@FindBy(xpath="//a[contains(text(),\"Deals\")]")
    WebElement dealsLink;
	
	@FindBy(xpath="//a[contains(text(),\"Tasks\")]")
	WebElement tasksLink;
	
	
	//Iinitialize the above webelements
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	//  create some actions in this page
	
	public String verifyHomePageTitle() {
       // driver.switchTo().frame("mainpanel");

	String title= driver.getTitle();	
	return title;
	}
	
	public boolean verifyCorrectUserName() {
		return userNameLabel.isDisplayed();
	}
	
	public ContactsPage clickOnContactsLink() {
		contactsLink.click();
	return new ContactsPage();
	
	}
	
	public DealsPage clickOnDealsLink() {
		dealsLink.click();
		return new DealsPage();
	}
	
	
	public TasksPage clickOnTasksLink() {
		tasksLink.click();
		return new TasksPage();
	}
	
	public void clickOnNewContactsLink() {
		Actions action = new Actions(driver);
		action.moveToElement(contactsLink).build().perform();
		newContactsLink.click();
	}
	
}
