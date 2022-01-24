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
	
	

	public AdministratorHomePage selectBrand() throws Exception {
		brands.click();
		TestBase.implict(3);
		brandName.click();
		TestBase.implict(3);
		return null;

	}

	public AdministratorHomePage selectProperty() throws Exception {
		property.click();
		TestBase.implict(3);
		propertySelectButton.click();
		TestBase.implict(3);
		return null;
	}

	public AdministratorHomePage clickGuestPreferenceQuestionsTab() throws InterruptedException {
		guestPreferenceQuestionsTab.click();
		TestBase.implict(3);
		return null;
	}

	public AdministratorHomePage clickAddOnsTab() throws InterruptedException {
		addOnsTab.click();
		TestBase.implict(3);
		return null;
	}

	public AdministratorHomePage clickAddNewGuestPreference() throws InterruptedException {
		addNewGuestPreference.click();
		TestBase.implict(5);
		return null;
	}

	public AdministratorHomePage clickListAllAddOn() throws InterruptedException {
		listAllAddOns.click();
		TestBase.implict(3);
		return null;

	}

	public AdministratorHomePage clickListAllGuestPreference() throws InterruptedException {
		listAllGuestPreference.click();
		TestBase.implict(5);
		return null;

	}

	public AdministratorHomePage clickAddNewRatePlansTab() throws InterruptedException {
		addNewRatePlansTab.click();
		TestBase.implict(5);
		return null;
	}

	public AdministratorHomePage clickRatePlansTab() throws InterruptedException {
		ratePlansTab.click();
		TestBase.implict(5);
		return null;
	}

	public AdministratorHomePage clickAddNewAddOnsTab() throws InterruptedException {
		addNewAddOnTab.click();
		TestBase.implict(5);
		return null;
	}

	public AdministratorHomePage clickRatePlanCategories() throws InterruptedException {
		ratePlanCategories.click();
		TestBase.implict(3);
		return null;
	}

	public AdministratorHomePage clickSmartPoliciesTab() throws InterruptedException {
		smartPoliciesTab.click();
		TestBase.implict(3);
		return null;
	}

	public AdministratorHomePage clickAddNewSmartPolicies() throws InterruptedException {
		addNewSmartPolicies.click();
		TestBase.implict(5);
		return null;
	}

	public AdministratorHomePage clickPoliciesTab() throws InterruptedException {
		policiesTab.click();
		TestBase.implict(2);
		return null;
	}

	public AdministratorHomePage clickAddNewPolicy() throws InterruptedException {
		addNewPolicy.click();
		TestBase.implict(3);
		return null;
	}


	public AdministratorHomePage selectRatesandInventory() throws InterruptedException {
		ratesandInventory.click();
		TestBase.implict(3);
		return null;
	}

	public AdministratorHomePage selectReports() throws InterruptedException {
		reports.click();
		TestBase.implict(3);
		return null;
	}
	
	public AdministratorHomePage clickPropertyManagementTab() throws InterruptedException {
	   propertyManagement.click();
	   return null;
	}
	
	public AdministratorHomePage clickAlternatePropertyTab() {
		 alternateProperties.click();
	     return null;
	}
	     
	 public AdministratorHomePage clickNearbyAttractionTab() {
		 nearByAttraction.click();
		 return null;
	}
	
     
    public AdministratorHomePage clickPaymentGatewayTab() {
	    paymentGateway.click();
	    return null;
    }

    public AdministratorHomePage clickOnRoomTab() {
	   room.click();
	   return null;
    }	
	
     public AdministratorHomePage clickOnRoomHierarchy() {
  	 roomHierarchy.click();
  	    return null;
      }
     
     public AdministratorHomePage callCenterSettings() {
      callCentersetting.click();
      return null;
          }
     
     public AdministratorHomePage clickOnAddNew() {
      addNew.click();
      return null;
          }
     
     public AdministratorHomePage clickOnListAllRoom() {
         listAllRoom.click();
         return null;
             }
     
     public AdministratorHomePage clickOnAmenities() {
         amenities.click();
         return null;
             }

}
