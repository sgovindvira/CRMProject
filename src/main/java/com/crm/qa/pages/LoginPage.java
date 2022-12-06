package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.baseclass.TestBase;

public class LoginPage extends TestBase {
	
	//PageFactory
	@FindBy(name ="email")
	WebElement email;
	
	@FindBy(name="password")
	WebElement password;
	@FindBy(xpath= "//div[@class='ui fluid large blue submit button']")
	WebElement loginBtn;
	
	@FindBy(xpath ="//div[@class ='ui message'][2]/a")
	WebElement signUpBtn;

	//Intializing page object
		public LoginPage(){
			PageFactory.initElements(driver, this);
			
		}
	
		
		//Actions	
		public String validateloginTitle() {
			return driver.getTitle();
			
			
		}
		public HomePage login(String un, String pwd) {
			email.sendKeys(un);
			password.sendKeys(pwd);
			loginBtn.click();
			
			return new HomePage();
		}
}
