package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class ContactsPageTest extends TestBase {

	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;
	ContactsPage contactsPage;
	String sheetName = "contacts";

	public ContactsPageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		// Creating LoginPage objects
		initialization();
		contactsPage = new ContactsPage();
		loginPage = new LoginPage();
		homePage = loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
		contactsPage = homePage.clickOnContactsLink();

		// driver.navigate().refresh();

	}

	@Test(priority = 1)
	public void verifyContactPageLabel() {
		boolean label = contactsPage.verifyContactLabel();
		// System.out.println("contactsPageLabel>>>" + label);
		Assert.assertTrue(label, "Contact label not found");
	}

	@Test(priority = 2)
	public void selectContactsTest() throws Throwable {
		contactsPage.selectContactByName("Ambreen Ahmed");
		Thread.sleep(3000);

	}

	@DataProvider
	public Object[][] getCRMTestData() {
		Object data[][] = testUtil.getTestData(sheetName);
		return data;
	}

	@Test(priority = 3, dataProvider = "getCRMTestData")
	public void validateCreateNewContact(String firstName, String lastName, String status, String company)
			throws InterruptedException {
		homePage.clickOnContactsLink();
		contactsPage.clickOnNewContactLink(firstName, lastName, status, company);
	}

	@AfterMethod
	public void tearDown() {

		driver.quit();
	}

}
