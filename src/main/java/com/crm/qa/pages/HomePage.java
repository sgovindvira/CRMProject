package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.baseclass.TestBase;

public class HomePage extends TestBase {
	
	//PageFactory
	
	@FindBy(xpath="//span[contains(text(),'Sam Gov')]")
	WebElement userNameDisplayed;
	
	@FindBy(xpath ="//div[@id='main-nav']/div[3]/a")
	WebElement contactsLink;
	
	@FindBy(xpath="//div[@id='main-nav']/div[5]/a")
	WebElement dealsLink;
	
	@FindBy(xpath ="//div[@id='main-nav']/div[6]/a")
	WebElement taskLink;
	@FindBy(xpath = "//div[@class='item']/a")
	WebElement clickOnNewContactBttn;
	
	
	//Intializing HomePage object by creating constructor
	
	public HomePage() {
		PageFactory.initElements(driver,this);
	}
	
	
	public String verifyHomePageTitle() {
		return driver.getTitle();
	}
	
	public boolean verifyUsername() {
		return userNameDisplayed.isDisplayed();
		
	}
	
	 public ContactsPage clickOnContactLink() {
		 contactsLink.click();
		 return new ContactsPage();
	 }
	 
	 public DealsPage clickOnDealsPage() {
		 dealsLink.click();
		 return new DealsPage();
	 }
	 
	 public TaskPage clickOnTaskPage() {
		 taskLink.click();
		 return new TaskPage();
	 }
	 public void clickOnNewContactLink() {
		 JavascriptExecutor js = (JavascriptExecutor)driver;
			js.executeScript("arguments[0].click()", driver.findElement(By.xpath("//a[@href='/contacts']")) );
		 
	 }
	 

}
