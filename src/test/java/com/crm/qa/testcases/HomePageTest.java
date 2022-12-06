package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.baseclass.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class HomePageTest extends TestBase {

	LoginPage lp;
	HomePage homePage;
	ContactsPage contactPage;
	

	public HomePageTest() {

		super();
	}


	@BeforeMethod
	public void setup() {
		initialization();
		lp = new LoginPage();
		contactPage = new ContactsPage();

		homePage =lp.login(prop.getProperty("username"), prop.getProperty("password"));
	}


	@Test(priority =1)
	public void verifyHomePageTitleTest() {
		String homePageTitle =	homePage.verifyHomePageTitle();
		Assert.assertEquals(homePageTitle, "Cogmento CRM","HomePage title not matched");
	}

	@Test(priority =2)
	public void verifyUsernameTest() {
		Assert.assertTrue(homePage.verifyUsername());
		System.out.println(homePage.verifyUsername());
	}


	@Test(priority =3)
	public void verifyContactsLinkTest() {
		contactPage =homePage.clickOnContactLink();
	}
	
	
	@AfterMethod
	public void teardown() {
		driver.quit();
	}


}
