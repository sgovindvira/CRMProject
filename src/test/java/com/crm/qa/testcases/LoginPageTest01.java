package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.baseclass.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class LoginPageTest01 extends TestBase {
	LoginPage lp;
	HomePage homePage;
	public LoginPageTest01() {
		super();
		
	}
	@BeforeMethod
	public void setup() {
		initialization();
	lp = new LoginPage();
		
	}
	
	@Test(priority =1)
	public void loginPageGetTitle() {
	String title = lp.validateloginTitle();
	Assert.assertEquals(title, "Cogmento CRM");
		
	}
	
	
	@Test(priority =2)
	public void logintest() {
	homePage =	lp.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	
	@AfterMethod
	public void teardown() {
		driver.quit();
	}
	
}

