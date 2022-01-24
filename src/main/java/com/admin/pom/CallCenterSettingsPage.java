package com.admin.pom;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utility.ExcelData;
import base.TestBase;
import pages.AbstractBasePage;

public class CallCenterSettingsPage extends AbstractBasePage {

	ExcelData e = new ExcelData();

	public CallCenterSettingsPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//textarea[@class='input']") 
	WebElement announcementMsg;

	@FindBy(xpath="//input[@value='true']") 
	WebElement activateAnnouncement;

	@FindBy(xpath="//input[@value='false']") 
	WebElement deactivateAnnouncement;

	@FindBy(xpath="//input[@name='save']") 
	WebElement saveButton;	

	@FindBy(xpath="//h1[text()='Administrator Home']")
	WebElement administratorName;

	public CallCenterSettingsPage enterAnnouncementMsg() throws Exception {
		announcementMsg.sendKeys(e.getCellData("Sheet1","announcementMsg",2));
		TestBase.implict(5);
		return null;
	}

	public CallCenterSettingsPage clickOnActivateAnnouncement() {
		activateAnnouncement.click();
		return null;
	}

	public CallCenterSettingsPage clickOnSave() {
		saveButton.click();
		return null;
	} 

	public CallCenterSettingsPage clearAnnouncementMsg() {
		announcementMsg.clear();
		return null;
	} 	 

	public CallCenterSettingsPage clickOnDeactivateAnnouncement() {
		deactivateAnnouncement.click();
		return null;
	}

	public String administratorName() {
		return administratorName.getText();
	}

}
