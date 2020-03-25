package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase {

	// Page Factory : Object Repository for Login Page
	@FindBy(name = "email")
	WebElement email;

	@FindBy(name = "password")
	WebElement password;

	// @FindBy(xpath = "//input[@type='Login']")
	@FindBy(xpath = "//div[@id='ui']//*[text()='Login']")
	WebElement loginBtn;

	@FindBy(xpath = "//a[contains(text(),'Sign Up')]")
	WebElement signUpLink;

	@FindBy(xpath = "//*[@id='top-header-menu']/div[1]")
	WebElement crmLogo;

	// Initializing the Page Objects
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}

	public String validateLoginPageTitle() {
		return driver.getTitle();
	}

	public boolean validateLogoHomePage() {
		return crmLogo.isDisplayed();
	}

	public HomePage doLogin(String uname, String pwd) {

		email.sendKeys(uname);
		password.sendKeys(pwd);
		loginBtn.click();

		// Once logged in, it will return Home Page objects
		return new HomePage();
	}
}
