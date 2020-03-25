package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class LoginPageTest extends TestBase {

	LoginPage loginpage;
	HomePage homepage;

	// Calling the TestBase class constructor
	public LoginPageTest() {
		super();

	}

	@BeforeMethod
	public void setUp() {
		// Creating LoginPage objects
		initialization();
		loginpage = new LoginPage();

	}

	@Test(priority = 1)
	public void loginPageTitleTest() {
		String actualTitle = loginpage.validateLoginPageTitle();
		Assert.assertEquals(actualTitle, "Cogmento CRM", "Login Page title not match");
	}

	@Test(priority = 2)
	public void loginTest() {
		homepage = loginpage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
		boolean flag = loginpage.validateLogoHomePage();
		Assert.assertTrue(flag);
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
