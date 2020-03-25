package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase {

	// Page Factory : Object Repository for Home Page
	@FindBy(xpath = "//*[@id='top-header-menu']//*[text()='Sultan Ahmed']")
	WebElement nameNameLabel;

	@FindBy(xpath = "//span[contains(text(),'Contacts')]")
	WebElement contactsLink;

	@FindBy(xpath = "//span[contains(text(),'Deals')]")
	WebElement dealsLink;

	@FindBy(xpath = "//span[contains(text(),'Task')]")
	WebElement TaskLink;

	// Initializing the Page Objects
	public HomePage() {
		PageFactory.initElements(driver, this);
	}

	// Actions: Feature in Login Page
	public boolean NameLabelDisplayed() {
		return nameNameLabel.isDisplayed();
	}

	public ContactsPage clickOnContactsLink() {
		contactsLink.click();
		return new ContactsPage();
	}

	public TasksPage clickOnCTaskLink() {
		TaskLink.click();
		return new TasksPage();
	}

	public DealsPage clickOnDealsLink() {
		contactsLink.click();
		return new DealsPage();
	}

}
