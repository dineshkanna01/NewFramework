package com.admin.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;
import pages.AbstractBasePage;

public class AdministratorHomePage extends AbstractBasePage {

	public WebDriver driver;

	public AdministratorHomePage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	public String UrlTilte() {
		return driver.getTitle();
	}

	@FindBy(xpath = "//*[text()='Brands']")
	WebElement brands;

	@FindBy(xpath = "//*[text()='RTest']")
	WebElement brandName;
	@FindBy(xpath = "//*[@value='102']")
	WebElement property;

	@FindBy(xpath = "//*[@value='Select Property']")
	WebElement propertySelectButton;

	@FindBy(xpath = "//*[text()='Guest Preference Questions']")
	WebElement guestPreferenceQuestionsTab;

	@FindBy(xpath = "//*[text()='Smart Policies']")
	WebElement smartPoliciesTab;

	@FindBy(xpath = "//*[text()='Policies']")
	WebElement policiesTab;

	@FindBy(xpath = "//*[text()='Rate Plans']")
	WebElement ratePlansTab;

	@FindBy(id = "add_new_rate")
	WebElement addNewRatePlansTab;

	@FindBy(xpath = "//*[text()='Add-Ons']")
	WebElement addOnsTab;

	@FindBy(xpath = "//*[@id='add_new_add_on']")
	WebElement addNewAddOnTab;

	@FindBy(xpath = "//*[@id='add_new_policy']")
	WebElement addNewPolicy;

	@FindBy(xpath = "//ul[@id='22']/li[2]/a")
	WebElement addNewGuestPreference;

	@FindBy(xpath = "//*[@id='add_new_smart_policy']")
	WebElement addNewSmartPolicies;

	@FindBy(xpath = "//ul[@id='22']/li[1]/a")
	WebElement listAllGuestPreference;

	@FindBy(xpath = "//*[contains(@href,'/admin/action/displayRatePlanCategories.do')]")
	WebElement ratePlanCategories;

	@FindBy(xpath = "//*[@id='7']/li[1]/a")
	WebElement listAllAddOns;

	@FindBy(xpath = "//*[@value='93']")
	WebElement propertyradiobutton;

	@FindBy(xpath = "//*[@value='Select Property']")
	WebElement propertyselectbutton;

	@FindBy(xpath = "//*[@id='10' and text()='Rates and Inventory']")
	WebElement ratesandInventory;

	@FindBy(xpath = "//*[@id='13' and text()='Reports']")
	WebElement reports;

	@FindBy(xpath="//a[text()='Brands']")
	WebElement brand;

	@FindBy(xpath="(//input[@type='radio'])[5]")
	WebElement radioButton;

	@FindBy(xpath="//input[@value='Select Property']")
	WebElement selectProperty;

	@FindBy(xpath="//div[text()='Property Management']")
	WebElement propertyManagement;

	@FindBy(xpath="//a[contains(@href,'/admin/action/getRT3')]")
	WebElement alternateProperties;

	@FindBy(xpath="//a[contains(@href,'/admin/action/displayN')]")
	WebElement nearByAttraction;

	@FindBy(xpath="//a[text()='Payment Gateway']")
	WebElement paymentGateway;

	@FindBy(xpath="//div[text()='Rooms']")
	WebElement room;

	@FindBy(xpath="//a[contains(@href,'/admin/action/displayRoomH')]")
	WebElement roomHierarchy;

	@FindBy(xpath="//a[contains(@href,'/admin/action/displayCallCenter')]") 
	WebElement callCentersetting;

	@FindBy(id="add_new_room")
	WebElement addNew;

	@FindBy(xpath="//a[contains(@href,'TypesList')]")
	WebElement listAllRoom;

	@FindBy(xpath="//a[text()='Amenities']")
	WebElement amenities;



	/*
	 * Method to select brand
	 */
	public AdministratorHomePage selectBrand() {
		brands.click();
		TestBase.implict(3);
		brandName.click();
		TestBase.implict(3);
		return null;

	}

	/*
	 * Method to select property
	 */
	public AdministratorHomePage selectProperty() {
		property.click();
		TestBase.implict(3);
		propertySelectButton.click();
		TestBase.implict(3);
		return null;
	}

	/*
	 * Method to click Guest Preference Questions Tab
	 */
	public AdministratorHomePage clickGuestPreferenceQuestionsTab() {
		guestPreferenceQuestionsTab.click();
		TestBase.implict(3);
		return null;
	}

	/*
	 * Method to click Add Ons Tab
	 */
	public AdministratorHomePage clickAddOnsTab() {
		addOnsTab.click();
		TestBase.implict(3);
		return null;
	}

	/*
	 * Method to click Add New Guest Preference
	 */
	public AdministratorHomePage clickAddNewGuestPreference() {
		addNewGuestPreference.click();
		TestBase.implict(5);
		return null;
	}

	/*
	 * Method to click List All AddOn
	 */
	public AdministratorHomePage clickListAllAddOn() {
		listAllAddOns.click();
		TestBase.implict(3);
		return null;

	}

	/*
	 * Method to click List All Guest Preference
	 */
	public AdministratorHomePage clickListAllGuestPreference() {
		listAllGuestPreference.click();
		TestBase.implict(5);
		return null;

	}

	/*
	 * Method to click Add New Rate Plans Tab
	 */
	public AdministratorHomePage clickAddNewRatePlansTab() {
		addNewRatePlansTab.click();
		TestBase.implict(5);
		return null;
	}

	/*
	 * Method to click Rate Plans Tab
	 */
	public AdministratorHomePage clickRatePlansTab() {
		ratePlansTab.click();
		TestBase.implict(5);
		return null;
	}

	/*
	 * Method to click Add new add ons tab
	 */
	public AdministratorHomePage clickAddNewAddOnsTab() {
		addNewAddOnTab.click();
		TestBase.implict(5);
		return null;
	}

	/*
	 * Method to click Rate Plan Categories
	 */
	public AdministratorHomePage clickRatePlanCategories() {
		ratePlanCategories.click();
		TestBase.implict(3);
		return null;
	}

	/*
	 * Method to click Smart Policies Tab
	 */
	public AdministratorHomePage clickSmartPoliciesTab() {
		smartPoliciesTab.click();
		TestBase.implict(3);
		return null;
	}

	/*
	 * Method to click Add New Smart Policies
	 */
	public AdministratorHomePage clickAddNewSmartPolicies() {
		addNewSmartPolicies.click();
		TestBase.implict(5);
		return null;
	}

	/*
	 * Method to click Policies Tab
	 */
	public AdministratorHomePage clickPoliciesTab() {
		policiesTab.click();
		TestBase.implict(2);
		return null;
	}

	/*
	 * Method to click Add New Policy
	 */
	public AdministratorHomePage clickAddNewPolicy() {
		addNewPolicy.click();
		TestBase.implict(3);
		return null;
	}

	public AdministratorHomePage selectRatesandInventory() {
		ratesandInventory.click();
		TestBase.implict(3);
		return null;
	}

	public AdministratorHomePage selectReports() {
		reports.click();
		TestBase.implict(3);
		return null;
	}

	/*
	 * Method for click property management 
	 */
	public AdministratorHomePage clickPropertyManagementTab(){
		propertyManagement.click();
		return null;
	}

	/*
	 * Method for click alternate property
	 */
	public AdministratorHomePage clickAlternatePropertyTab() {
		alternateProperties.click();
		return null;
	}

	/*
	 * Method for click nearby attraction tab
	 */  
	public AdministratorHomePage clickNearbyAttractionTab() {
		nearByAttraction.click();
		return null;
	}

	/*
	 * Method for click payment gateway tab
	 */ 
	public AdministratorHomePage clickPaymentGatewayTab() {
		paymentGateway.click();
		return null;
	}

	/*
	 * Method for click on room tab
	 */
	public AdministratorHomePage clickOnRoomTab() {
		room.click();
		return null;
	}	

	/*
	 * Method for click on room hierarchy
	 */
	public AdministratorHomePage clickOnRoomHierarchy() {
		roomHierarchy.click();
		return null;
	}

	/*
	 * Method for click on call center settings 
	 */
	public AdministratorHomePage callCenterSettings() {
		callCentersetting.click();
		return null;
	}

	/*
	 * Method for click on add new
	 */
	public AdministratorHomePage clickOnAddNew() {
		addNew.click();
		return null;
	}
	/*
	 * Method for click on list all room
	 */
	public AdministratorHomePage clickOnListAllRoom() {
		listAllRoom.click();
		return null;
	}
	/*
	 * Method for click on amenities
	 */
	public AdministratorHomePage clickOnAmenities() {
		amenities.click();
		return null;
	}

}
