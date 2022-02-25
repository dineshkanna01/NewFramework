package com.cc.pom;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import Utility.ExcelData;
import base.Helper;
import base.TestBase;

/*
 *POM class for VerifyingCCSettingsAnnouncementfromAdmintoBookingUIPage
 * @author Rudraksh Aggarwal
 */
public class VerifyingCCSettingsAnnouncementfromAdmintoBookingUIPage extends TestBase {

	@FindBy(name = "announcement")
	WebElement announcementText;
	@FindBy(name = "save")
	WebElement saveButton;
	@FindBy(xpath = "//span[contains(@class,'announcement-text ng-binding')]")
	WebElement announcementVerify;
	@FindBy(id = "user_login")
	WebElement username;
	@FindBy(id = "user_password")
	WebElement password;
	@FindBy(xpath = "//input[@value='Sign In']")
	WebElement signIn;
	@FindBy(xpath = "//a[text()='Portal settings']")
	WebElement portalSetting;
	@FindBy(xpath = "//input[@placeholder='Filter']")
	WebElement filter;
	@FindBy(xpath = "//*[text()=' Search']")
	WebElement search;
	@FindBy(xpath = "//li[contains(@class,'edit_member_link')]")
	WebElement pencilEdit;
	@FindBy(xpath = "//i[contains(@class,'icon-question-sign')]")
	WebElement resetCacheTab;
	@FindBy(xpath = "//button[contains(@class,'btn-danger')]")
	WebElement sureButton;
	@FindBy(xpath = "//*[@name='_save']")
	WebElement save;
	@FindBy(xpath = "//div[contains(@class,'alert ')]")
	WebElement subdomainSuccessfullyUpdated;
	@FindBy(xpath = "//span[text()='Log out']")
	WebElement logoutSubDomain;

	public VerifyingCCSettingsAnnouncementfromAdmintoBookingUIPage(WebDriver driver) {
		super();
		PageFactory.initElements(driver, this);
	}

	public String UrlTilte() {
		return driver.getTitle();
	}

	/*
	 * Method to input Details TC01
	 * 
	 */
	public VerifyingCCSettingsAnnouncementfromAdmintoBookingUIPage inputDetailsTC01() {
		announcementText.clear();
		announcementText.sendKeys(ExcelData.CC_getCellData("CCAnnouncementData", "AnncText", 2));
		Helper.implict(3);
		List<WebElement> radbut = getDriver().findElements(By.xpath("//*[@type='radio']"));
		for (int i = 0; i < radbut.size(); i++) {
			String value = radbut.get(i).getAttribute("value");
			if (value.equalsIgnoreCase("true"))
				radbut.get(i).click();
			Helper.implict(3);
		}
		return null;
	}

	/*
	 * Method to input Details TC02
	 * 
	 */
	public VerifyingCCSettingsAnnouncementfromAdmintoBookingUIPage inputDetailsTC02() {
		announcementText.clear();
		announcementText.sendKeys(ExcelData.CC_getCellData("CCAnnouncementData", "AnncText", 2));
		Helper.implict(3);
		List<WebElement> radbut = getDriver().findElements(By.xpath("//*[@type='radio']"));
		for (int i = 0; i < radbut.size(); i++) {
			String value = radbut.get(i).getAttribute("value");
			if (value.equalsIgnoreCase("false"))
				radbut.get(i).click();
			Helper.implict(3);
		}
		return null;
	}

	/*
	 * Method to input Details TC03
	 * 
	 */
	public VerifyingCCSettingsAnnouncementfromAdmintoBookingUIPage inputDetailsTC03() {
		announcementText.clear();
		Helper.implict(3);
		List<WebElement> radbut = getDriver().findElements(By.xpath("//*[@type='radio']"));
		for (int i = 0; i < radbut.size(); i++) {
			String value = radbut.get(i).getAttribute("value");
			if (value.equalsIgnoreCase("false"))
				radbut.get(i).click();
			Helper.implict(3);
		}
		return null;
	}

	/*
	 * Method to clickSaveButton
	 * 
	 */
	public VerifyingCCSettingsAnnouncementfromAdmintoBookingUIPage clickSaveButton() {
		saveButton.click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return null;
	}

	/*
	 * Method to verifyAnnouncement
	 * 
	 */
	public boolean verifyAnnouncementCC() {
		try {
			Thread.sleep(2500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		if (announcementVerify.isDisplayed()) {
			String a = announcementVerify.getText();
			System.out.println("announcement in cc is: " + a);
			return true;
		} else {
			System.out.println("announcement in cc is not present");
			return false;
		}
	}

	/*
	 * Method to input fields and clear cache in ibe config
	 */
	public boolean clearCacheIBE() {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		username.clear();
		username.sendKeys(ExcelData.CC_getCellData("CCAnnouncementData", "username", 2));
		password.clear();
		password.sendKeys(ExcelData.CC_getCellData("CCAnnouncementData", "password", 2));
		signIn.click();
		Helper.explicit(portalSetting, 10);
		portalSetting.click();
		filter.sendKeys(ExcelData.CC_getCellData("CCAnnouncementData", "subdomain", 2));
		search.click();
		pencilEdit.click();
		Helper.explicit(resetCacheTab, 5);
		resetCacheTab.click();
		sureButton.click();
		save.click();
		Helper.implict(5);
		if (subdomainSuccessfullyUpdated.isDisplayed()) {
			System.out.println("Subdomain Successfully updated");
			return true;
		} else {
			System.out.println("Subdomain not updated");
			return false;
		}
	}

	public VerifyingCCSettingsAnnouncementfromAdmintoBookingUIPage logoutIBE() {
		logoutSubDomain.click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return null;
	}

}