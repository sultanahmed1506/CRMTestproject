package com.crm.qa.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.crm.qa.base.TestBase;

public class ContactsPage extends TestBase {

	@FindBy(xpath = "//*[text()='Contacts']//parent::div[1]")
	WebElement contactsPageLabel;

	@FindBy(xpath = "//td[text()='+name+']//parent::td//preceding-sibling::td//input[@type='checkbox']")
	WebElement contactChkBox;

	//@FindBy(xpath = "//button[text()='New']")
	@FindBy(xpath= "//a[contains(@href,'contacts/new')]")
	WebElement contactsNewBtn;

	@FindBy(name = "first_name")
	WebElement firstName;

	@FindBy(name = "last_name")
	WebElement lastName;

	@FindBy(xpath = "//div[@name='company']//input")
	WebElement companyName;

	@FindBy(xpath = "//div[@name='status']")
	WebElement statusSelect;

	@FindBy(xpath = "//button//i[@class='save icon']")
	WebElement saveBtn;

	public ContactsPage() {
		PageFactory.initElements(driver, this);
	}

	@SuppressWarnings("deprecation")
	WebDriverWait wait = new WebDriverWait(driver, 10);

	public boolean verifyContactLabel() {
		// contactsPageLabel.isDisplayed();
		return contactsPageLabel.isDisplayed();
	}

	public void selectContactByName(String name) throws Throwable {
		// contactChkBox.click();
		System.out.println("Name to click : " + name);

		/*
		 * WebElement element =
		 * wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
		 * "//td[text()='\" + name + \"']//parent::td//preceding-sibling::td//input[@class='hidden']//parent::div"
		 * )));
		 */

		/*
		 * driver.findElement(By.xpath( "//td[text()='" + name +
		 * "']//parent::td//preceding-sibling::td//input[@class='hidden']//parent::div")
		 * ) .click();
		 */
		
		boolean contactNamePresent = driver.findElement(By.xpath(
				"//td[text()='" + name + "']//parent::td//preceding-sibling::td//input[@class='hidden']//parent::div")).isDisplayed();
		
		if (contactNamePresent == true) {
			driver.findElement(By.xpath(
					"//td[text()='" + name + "']//parent::td//preceding-sibling::td//input[@class='hidden']//parent::div")).click();
			
		}else {
			driver.navigate().refresh();
			driver.findElement(By.xpath(
					"//td[text()='" + name + "']//parent::td//preceding-sibling::td//input[@class='hidden']//parent::div")).click();
		}
		Thread.sleep(4000);
	}

	public void clickOnNewContactLink(String ftname, String ltname, String status, String comp) throws InterruptedException{
		Thread.sleep(3000);
		driver.navigate().refresh();
		contactsNewBtn.click();
		
		//Thread.sleep(3000);
		//driver.navigate().refresh();
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("firstName")));
		firstName.sendKeys(ftname);
		lastName.sendKeys(ltname);
		companyName.sendKeys(comp);
		
		statusSelect.click();
		List<WebElement> listStatus = driver
				.findElements(By.xpath("//div[@class='visible menu transition']//div//span"));
		System.out.println("Size of Status List :  + listStatus");
		for (int i = 0; i < listStatus.size(); i++) {
			if (listStatus.get(i).getText().equals(status)) {
				listStatus.get(i).click();
				break;
			}
		}
		saveBtn.click();
		
		Thread.sleep(3000);
	}

}
