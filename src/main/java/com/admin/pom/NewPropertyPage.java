package com.admin.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utility.ExcelData;
import base.TestBase;
import pages.AbstractBasePage;

public class NewPropertyPage extends AbstractBasePage{


	ExcelData e = new ExcelData();

	public NewPropertyPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//div[text()='Property Management']")
	WebElement propertyMangementTab;

	@FindBy(xpath = "//a[@id='add_new_property']")
	WebElement addNew;

	@FindBy(xpath = "//input[@name='propertyName']")
	WebElement propertyName;

	@FindBy(xpath = "//input[@name='propertyCode']")
	WebElement propertyCode;

	@FindBy(xpath = "//input[@name='propertySubdomain']")
	WebElement propertySubDomain;

	@FindBy(xpath = "//input[@name='address1']")
	WebElement address1;

	@FindBy(xpath = "//input[@name='city']")
	WebElement city;

	@FindBy(xpath = "//select[@name='country']")
	WebElement country;

	@FindBy(xpath = "//option[text()='India']")
	WebElement countrySelected;

	@FindBy(xpath = "//a[text()=' Find Lat/Long  ']")
	WebElement longitudeLatitude;

	@FindBy(xpath = "//input[@name='button1']")
	WebElement editSaveButton;

	@FindBy(xpath = "//select[@name = 'starRating']")
	WebElement starRating;

	@FindBy(xpath = "//option[@value = '3.5']")
	WebElement ratingValue;

	@FindBy(xpath = "//input[@name = 'adultAge']")
	WebElement adultAge;

	@FindBy(xpath = "//input[@name = 'Save']")
	WebElement verifyDefaultSaveButton;

	@FindBy(xpath = "//input[@name = 'phone1CountryCode']")
	WebElement countryCode;

	@FindBy(xpath = "//input[@name = 'phone1AreaCode']")
	WebElement areaCode;

	@FindBy(xpath = "//input[@name = 'phone1Number']")
	WebElement phone;

	@FindBy(xpath = "//input[@name = 'websiteURL']")
	WebElement website;

	@FindBy(xpath = "//input[@name = 'primaryEmail']")
	WebElement primaryEmail;

	@FindBy(xpath = "//input[@name = 'noOfRooms']")
	WebElement numberOfRooms;

	@FindBy(xpath = "//input[@name = 'noOfFloors']")
	WebElement numberOfFloors;

	@FindBy(xpath = "//input[@name = 'creditCardsAccepted']")
	WebElement visaCard;

	@FindBy(xpath = "//textarea[@name = 'shortDescription']")
	WebElement shortDescription;

	@FindBy(xpath = "//input[@name = 'Submit']")
	WebElement masterSaveButton;
	
	@FindBy(xpath = "//h1[text() = 'Administrator Home']")
	WebElement afterSaveVerifyText;
	
	@FindBy(xpath = "//li[text()='Duplicate property code.']")
	WebElement duplicateProperty;

	public NewPropertyPage newPropertyEditPage() throws Exception {
		propertyMangementTab.click();
		addNew.click();
		propertyName.sendKeys(e.getCellData("Property", "Name", 2));
		propertyCode.sendKeys(e.getCellData("Property", "Code", 2));
		propertySubDomain.sendKeys(e.getCellData("Property", "SubDomain", 2));
		address1.sendKeys(e.getCellData("Property", "Address1", 2));
		city.sendKeys(e.getCellData("Property", "City", 2));
		country.click();
		countrySelected.click();
		Thread.sleep(2000);
		longitudeLatitude.click();
		Thread.sleep(2000);
		return null;

	}

	public String verifyEditSaveButton() {
		String s = editSaveButton.getAttribute("value");
		System.out.println(s);
		return s;
	}

	public NewPropertyPage propertyEditPageSaveButton() throws Throwable {
		editSaveButton.click();
		return null;

	}

	public NewPropertyPage propertyDefaultPage() throws Throwable {
		starRating.click();
		ratingValue.click();
		Thread.sleep(2000);
		adultAge.sendKeys(e.getCellData("Property", "AdultAge", 2));
		Thread.sleep(2000);
		return null;

	}

	public String verifyDefaultSaveButton() {
		String s = verifyDefaultSaveButton.getAttribute("value");
		System.out.println(s);
		return s;

	}

	public NewPropertyPage propertyDefaultPageSaveButton() throws Throwable {
		verifyDefaultSaveButton.click();
		return null;

	}

	public NewPropertyPage propertyMasterPage() throws Throwable {
		Thread.sleep(2000);
		countryCode.sendKeys(e.getCellData("Property", "CountryCode", 2));
		Thread.sleep(2000);
		areaCode.sendKeys(e.getCellData("Property", "AreaCode", 2));
		Thread.sleep(2000);
		phone.sendKeys(e.getCellData("Property", "Phone", 2));
		website.sendKeys(e.getCellData("Property", "Website", 2));
		primaryEmail.sendKeys(e.getCellData("Property", "PrimaryEmail", 2));
		Thread.sleep(2000);
		numberOfRooms.sendKeys(e.getCellData("Property", "NumberOfRooms", 2));
		Thread.sleep(2000);
		numberOfFloors.sendKeys(e.getCellData("Property", "NumberOfFloors", 2));
		visaCard.click();
		shortDescription.sendKeys(e.getCellData("Property", "ShortDescription", 2));
		Thread.sleep(2000);
		return null;

	}
	
	public String verifyMasterSaveButton() {
		String s = masterSaveButton.getAttribute("value");
		System.out.println(s);
		return s;
	}
	
	public NewPropertyPage masterSaveButton() {
		TestBase.implict(3);
		masterSaveButton.click();
		return null;
	}
	
	public String verifyAdministratorTextAfterSave() {
		TestBase.implict(3);
		String s = afterSaveVerifyText.getText();
		System.out.println(s);
		return s;
	}
	
	public String verifyDuplicatePropert() {
		String s = duplicateProperty.getText();
		System.out.println(s);
		return s;
	}
	
	
}
