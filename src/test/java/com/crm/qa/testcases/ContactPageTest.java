package com.crm.qa.testcases;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.baseclass.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.utilities.TestUtil;



public class ContactPageTest extends TestBase {


	LoginPage lp;
	HomePage homePage;
	ContactsPage contactPage;
	String sheetname = "Sheet1";


	public ContactPageTest() {
		super();
	}
	@BeforeMethod
	public void setup() {
		initialization();
		lp = new LoginPage();
		contactPage = new ContactsPage();

		homePage =lp.login(prop.getProperty("username"), prop.getProperty("password"));
		contactPage=	homePage.clickOnContactLink();

	}



	@Test(priority =1)
	public void verifyContactsPageLable() {
		contactPage.verifyContactsLable();
		Assert.assertTrue(contactPage.verifyContactsLable(),"ContactLable is Missing");
	}


	@Test(priority=2)
	public void selectCheckbox() {
		contactPage.selectCheckBox();

	}


	@Test(priority =3, dataProvider ="getTestCRMtData")
	public void CreateNewContactTestFromExcel(String FirstName,String LastName) throws InterruptedException {

		homePage.clickOnContactLink();
		contactPage.createNewContactButton();
		Thread.sleep(1000);
		contactPage.createNewContact(FirstName, LastName);
		Thread.sleep(1000);


	}

	@DataProvider
	public Object[] []getTestCRMtData() {
		Object data[][] = TestUtil.getTestData(sheetname);
		return data;


	}


	@AfterMethod
	public void teardown() {
		driver.quit();
	}


}

