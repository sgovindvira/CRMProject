package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.baseclass.TestBase;

public class ContactsPage extends TestBase {
	
	@FindBy(xpath ="//th[contains(text(),'Email')]")
	WebElement verifyingOnContactPage;
	
	

	
	@FindBy(name ="first_name")
	WebElement firstName;
	
	@FindBy(name ="last_name")
	WebElement lastName;
	
	@FindBy(xpath="//div[@name='company']")
	WebElement company;
	
	@FindBy(xpath ="//div[@class='item']/button[2]")
	WebElement saveBttn;
	@FindBy(xpath ="//a[@href='/contacts/new']")
	WebElement createNewContactButton;
	

	
	public ContactsPage() {
		PageFactory.initElements(driver,this);
	}
	public boolean verifyContactsLable() {
		return verifyingOnContactPage.isDisplayed();
	}
	public void selectCheckBox() {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click()", driver.findElement(By.name("id")));
	}
	public void createNewContact(String fname, String lname) {
		firstName.sendKeys(fname);
		lastName.sendKeys(lname);
		//company.sendKeys(Comp);
		saveBttn.click();
		
		
	}
	public void createNewContactButton() {
		createNewContactButton.click();
	}
}

