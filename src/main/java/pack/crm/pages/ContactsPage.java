package pack.crm.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import pack.crm.base.TestBase;

public class ContactsPage extends TestBase{
	
	@FindBy(xpath="//td[contains(text(),\"Contacts\")]")
	WebElement contactsLabel;
	
	@FindBy(id="first_name")
	WebElement firstname;
	
	@FindBy(id="surname")
	WebElement lastname;
	
	@FindBy(name="client_lookup")
	WebElement company;
	
	@FindBy(xpath="//form[@id=\"contactForm\"]//input[@class=\"button\" and @value=\"Save\"]")
	WebElement savebtn;
	
	public ContactsPage() {
PageFactory.initElements(driver, this);
}
	
	public boolean verifyContactsLabel() {
		return contactsLabel.isDisplayed();
	}
	
	
	public void selectContactsByName(String name) {
		driver.findElement(By.xpath("//a[contains(text(),\"test2 test2\")]//parent::td[@class=\"datalistrow\"]//preceding-sibling::td[@class=\"datalistrow\"]//input[@type=\"checkbox\"]")).click();
	}	
	
	public void createNewContact(String title,String fname,String lname) {
		
		Select select= new Select(driver.findElement(By.name("title")));
		
		select.selectByVisibleText(title);;
		firstname.sendKeys(fname);
		lastname.sendKeys(lname);
		//company.sendkeys(company);
		savebtn.click();
		
		
	
	
	
	
	
	
	
	
	
	
	
	
	}

	
}
