package com.admin.pom;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utility.ExcelData;
import base.TestBase;
import pages.AbstractBasePage;

public class NewPropertyPage extends AbstractBasePage{
	
	ExcelData e = new ExcelData();

	@FindBy(xpath = "//div[text()='Property Management']")
	WebElement propertyMangementTab;

	@FindBy(xpath = "//a[@id='add_new_property']")
	WebElement addNew;

	@FindBy(xpath = "//*[contains(@href,'EditProperty')]")
	WebElement propertyEditOption;
	
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

	public NewPropertyPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	public String UrlTilte() {
		return driver.getTitle();
	}

	/*
	 * Method to create edit page of property
	 */
	
	public NewPropertyPage newPropertyEditPage() {
		propertyMangementTab.click();
		addNew.click();
		DateFormat dateFormat = new SimpleDateFormat("mmss");
		Date date = new Date();
		String strDate = dateFormat.format(date);
		String f1 ="Uz"+strDate;
		System.out.println(f1);
		propertyName.sendKeys(f1);
		propertyCode.sendKeys(f1);
		propertySubDomain.sendKeys(f1);
		address1.sendKeys(e.getCellData("Property", "Address1", 2));
		city.sendKeys(e.getCellData("Property", "City", 2));
		country.click();
		countrySelected.click();
		TestBase.implict(3);
		
		Actions action = new Actions(driver);
		
		action.moveToElement(longitudeLatitude).click().pause(java.time.Duration.ofSeconds(2)).build().perform();		
		//longitudeLatitude.click();
		return null;

	}
	
	/*
	 * Method to create duplicate property edit page of property
	 */
	
	public NewPropertyPage dupPropertyEditPage() {
		propertyMangementTab.click();
		propertyEditOption.click();
		String s = propertyName.getAttribute("value");
		String c = propertyCode.getAttribute("value");
		System.out.println(s);
		System.out.println(c);
		addNew.click();
		DateFormat dateFormat = new SimpleDateFormat("mmss");
		Date date = new Date();
		String strDate = dateFormat.format(date);
		String f1 ="Uz"+strDate;
		System.out.println(f1);
		propertyName.sendKeys(s);
		propertyCode.sendKeys(c);
		propertySubDomain.sendKeys(f1);
		address1.sendKeys(e.getCellData("Property", "Address1", 2));
		city.sendKeys(e.getCellData("Property", "City", 2));
		country.click();
		countrySelected.click();
		TestBase.implict(3);
		
		Actions action = new Actions(driver);
		
		action.moveToElement(longitudeLatitude).click().pause(java.time.Duration.ofSeconds(2)).build().perform();		
		//longitudeLatitude.click();
		return null;

	}

	/*
	 * Method to verify save button on edit page
	 * returns string s
	 */

	public String verifyEditSaveButton() {
		String s = editSaveButton.getAttribute("value");
		System.out.println(s);
		return s;
	}

	/*
	 * Method to click on save button on edit page
	 */

	public NewPropertyPage propertyEditPageSaveButton() {
//		TestBase.implict(2);
		editSaveButton.click();
		return null;

	}

	/*
	 * Method to create default page of property
	 */

	public NewPropertyPage propertyDefaultPage() {
		starRating.click();
		ratingValue.click();
		TestBase.implict(3);
//		adultAge.sendKeys("17");
//		WebElement wb = driver.findElement(By.name("adultAge"));
//		JavascriptExecutor js = (JavascriptExecutor)driver;
//		Object searchTextbar = js.executeScript("return document.getElementById('lst-ib')");
//		((WebElement) adultAge).sendKeys(e.getCellData("Property", "AdultAge", 2));
//		js.executeScript(e.getCellData("Property", "AdultAge", 2), wb);
		adultAge.sendKeys(e.getCellData("Property", "AdultAge", 2));
//		Thread.sleep(10000);
		TestBase.implict(3);
		return null;

	}

	/*
	 * Method to verify save button on default page
	 * returns string s
	 */

	public String verifyDefaultSaveButton() {
		String s = verifyDefaultSaveButton.getAttribute("value");
		System.out.println(s);
		return s;

	}

	/*
	 * Method to click on save button on default page
	 */

	public NewPropertyPage propertyDefaultPageSaveButton() {
		verifyDefaultSaveButton.click();
		return null;

	}

	/*
	 * Method to create Master page of property
	 */

	public NewPropertyPage propertyMasterPage() throws InterruptedException{
		TestBase.implict(3);
		countryCode.sendKeys(e.getCellData("Property", "CountryCode", 2));
		TestBase.implict(3);
		areaCode.sendKeys(e.getCellData("Property", "AreaCode", 2));
		TestBase.implict(3);
		phone.sendKeys(e.getCellData("Property", "Phone", 2));
		website.sendKeys(e.getCellData("Property", "Website", 2));
		primaryEmail.sendKeys(e.getCellData("Property", "PrimaryEmail", 2));
		TestBase.implict(3);
		numberOfRooms.sendKeys(e.getCellData("Property", "NumberOfRooms", 2));
		TestBase.implict(3);
		numberOfFloors.sendKeys(e.getCellData("Property", "NumberOfFloors", 2));
//		Thread.sleep(5000);
		visaCard.click();
		shortDescription.sendKeys(e.getCellData("Property", "ShortDescription", 2));
		TestBase.implict(3);
		return null;

	}

	/*
	 * Method to verify save button on master page
	 * returns string s
	 */

	public String verifyMasterSaveButton() {
		String s = masterSaveButton.getAttribute("value");
		System.out.println(s);
		return s;
	}

	/*
	 * Method to click on save button on master page
	 */

	public NewPropertyPage masterSaveButton() {
		TestBase.implict(3);
		masterSaveButton.click();
		return null;
	}

	/*
	 * Method to verify text after property creation
	 * returns string s
	 */

	public String verifyAdministratorTextAfterSave()  {
		TestBase.implict(3);
		String s = afterSaveVerifyText.getText();
		System.out.println(s);
		return s;
	}

	/*
	 * Method to verify duplicate property error message
	 * returns string s
	 */

	public String verifyDuplicatePropert() {
		String s = duplicateProperty.getText();
		System.out.println(s);
		return s;
	}
}
