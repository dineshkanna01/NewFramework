package com.admin.pom;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utility.ExcelData;
import pages.AbstractBasePage;

public class PropertyBrandingPage extends AbstractBasePage {


	ExcelData e = new ExcelData();

	public PropertyBrandingPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@value='50']")
	WebElement selectingProperty;

	@FindBy(xpath = "//input[@value='Select Property']")
	WebElement selectPropertyButton;

	@FindBy(xpath = "//div[text()='Property Management']")
	WebElement propertyManagementTab;

	@FindBy(xpath = "//*[contains(@href,'g.do?mode=edit&brand_id=20&prop_id=50')]")
	WebElement propertyBranding;

	@FindBy(xpath = "//input[@value='Save']")
	WebElement saveButton;

	public PropertyBrandingPage selectProperty() throws InterruptedException {
		selectingProperty.click();
		Thread.sleep(1000);
		selectPropertyButton.click();
		return null;
	}

	public PropertyBrandingPage propertyBrandConfig() throws InterruptedException {
		propertyManagementTab.click();
		Thread.sleep(1000);
		propertyBranding.click();
		return null;
	}

	public String verifySaveButton() {
		String s = saveButton.getAttribute("value");
		System.out.println(s);
		return s;
	}

	public PropertyBrandingPage saveButton() throws InterruptedException {
		Thread.sleep(1000);
		saveButton.click();
		Thread.sleep(1000);
		return null;
	}
}
