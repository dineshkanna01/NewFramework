package com.admin.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.Helper;
import pages.AbstractBasePage;


/*
* POM class to configure property branding
* @Author Uzair Asar
*/

public class PropertyBrandingPage extends AbstractBasePage {
	
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

	public PropertyBrandingPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	public String UrlTilte() {
		return driver.getTitle();
	}

	/*
	 * Method to select a property
	 */	

	public PropertyBrandingPage selectProperty(){
		selectingProperty.click();
		Helper.implict(3);
		selectPropertyButton.click();
		return null;
	}

	/*
	 * Method to configure property branding
	 */

	public PropertyBrandingPage propertyBrandConfig(){
		propertyManagementTab.click();
		Helper.implict(3);
		propertyBranding.click();
		return null;
	}

	/*
	 * Method to verify save button
	 * returns string s
	 */

	public String verifySaveButton() {
		String s = saveButton.getAttribute("value");
		System.out.println(s);
		return s;
	}

	/*
	 * Method to save property branding
	 */

	public PropertyBrandingPage saveButton(){
		Helper.implict(3);
		saveButton.click();
		Helper.implict(3);
		return null;
	}
}
