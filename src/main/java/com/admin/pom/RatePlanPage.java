package com.admin.pom;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utility.ExcelData;
import base.TestBase;
import pages.AbstractBasePage;

public class RatePlanPage extends AbstractBasePage {
	
	public WebDriver driver;
	ExcelData e = new ExcelData();

	public RatePlanPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	public String UrlTilte() {
		return driver.getTitle();
	}

	@FindBy(name = "name")
	WebElement name;

	@FindBy(name = "rateCode")
	WebElement ratePlanCode;

	@FindBy(name = "shortDescription")
	WebElement shortDescription;

	@FindBy(name = "bookingSDate")
	WebElement startDate;

	@FindBy(name = "checkInSDate")
	WebElement firstCheckInDate;

	@FindBy(name = "All")
	WebElement roomAllCheckbox;

	@FindBy(name = "save")
	WebElement saveButton;

	@FindBy(name = "button2")
	WebElement deleteButton;

	@FindBy(xpath = "//input[@value='Yes']")
	WebElement yesButton;

	@FindBy(xpath = "//input[@name='floatingRate' and @value='N']")
	WebElement deriveRatesNoButton;

	@FindBy(xpath = "//input[@name='floatingRate' and @value='Y']")
	WebElement deriveRatesYesButton;

	@FindBy(xpath = "(//td[@tf_colkey='name'])[last()]")
	WebElement verifyRatePlanName;

	@FindBy(xpath = "(//td[@tf_colkey='isFloatingRate'])[last()]")
	WebElement verifyRateTypeAssociation;

	@FindBy(xpath = "(//*[@name='rateIdCheckbox'])[last()]")
	WebElement ratePlanCheckbox;

	@FindBy(id = "rate_difference_0")
	WebElement roomTextBox;
	
	@FindBy(name="AttachAddons")
	WebElement addOnAttach;
	
	@FindBy(xpath="(//input[@name='selectedItems'])[last()]")
	WebElement selectAddOn;
	
	@FindBy(xpath="//input[@value='Add']")
	WebElement addButton;

	public RatePlanCategoriesPage inputfields_tc01() throws Exception {
		name.sendKeys(e.getCellData("RatePlanPageData", "Name_TC01", 2));
		TestBase.implict(1);
		ratePlanCode.sendKeys(e.getCellData("RatePlanPageData", "RateTypeCode_TC01", 2));
		TestBase.implict(1);
		shortDescription.sendKeys(e.getCellData("RatePlanPageData", "ShortDescription_TC01", 2));
		TestBase.implict(1);
		startDate.sendKeys(e.getCellData("RatePlanPageData", "BookingStartDate_TC01", 2));
		TestBase.implict(1);
		firstCheckInDate.sendKeys(e.getCellData("RatePlanPageData", "FirstCheckinDate_TC01", 2));

		return null;

	}

	public RatePlanCategoriesPage inputfields_tc02() throws Exception {
	
		name.sendKeys(e.getCellData("RatePlanPageData", "Name_TC01", 2));
		TestBase.implict(1);
		ratePlanCode.sendKeys(e.getCellData("RatePlanPageData", "RateTypeCode_TC01", 2));
		TestBase.implict(1);
		shortDescription.sendKeys(e.getCellData("RatePlanPageData", "ShortDescription_TC01", 2));
		TestBase.implict(1);
		startDate.sendKeys(e.getCellData("RatePlanPageData", "BookingStartDate_TC01", 2));
		TestBase.implict(1);
		firstCheckInDate.sendKeys(e.getCellData("RatePlanPageData", "FirstCheckinDate_TC01", 2));
		TestBase.implict(1);
		roomTextBox.sendKeys(e.getCellData("RatePlanPageData", "RoomNameTextBox", 2));
	
		return null;

	}
	
	public RatePlanCategoriesPage attachAddOns() throws Exception {
		addOnAttach.click();
		TestBase.implict(1);
		selectAddOn.click();
		addButton.click();
		TestBase.implict(3);
		
		return null;
	}


	public RatePlanCategoriesPage selectRoomType() throws Exception {
		roomAllCheckbox.click();
		return null;
	}

	public RatePlanCategoriesPage deriveRatesNo() throws InterruptedException {
		deriveRatesNoButton.click();
		return null;
	}


	public RatePlanCategoriesPage clickSaveButton() throws Exception {
		saveButton.click();
		TestBase.implict(3);
		return null;
	}

	public RatePlanCategoriesPage deleteRatePlan() throws Exception {
		ratePlanCheckbox.click();
		deleteButton.click();
		TestBase.implict(3);
		yesButton.click();
		TestBase.implict(4);
		return null;
	}

	public boolean verifyRateName() throws Exception {
		String rName = verifyRatePlanName.getText();
		rName = rName.replaceAll("\\s+", "");
		System.out.println(rName + "####");

		String ExcelrateName = e.getCellData("RatePlanPageData", "Name_TC01", 2);
		ExcelrateName = ExcelrateName.replaceAll("\\s+", "");

		System.out.println(ExcelrateName + "$$$");

		if (rName.equals(ExcelrateName)) {
			System.out.println("rate plan created");
			return true;
		} else {
			System.out.println("rate plan Deleted");
			return false;

		}
	}

	public boolean verifyRateAssociation() throws Exception {
		String rateAssoc = verifyRateTypeAssociation.getText();
		rateAssoc = rateAssoc.replaceAll("\\s+", "");
		System.out.println(rateAssoc + "####");

		String rAssoc = "Fixed";
		rAssoc = rAssoc.replaceAll("\\s+", "");

		System.out.println(rAssoc + "$$$");

		if (rateAssoc.equals(rAssoc)) {
			System.out.println("rate type is Fixed");
			return true;
		} else {
			System.out.println("rate type is Floating");
			return false;

		}
	}
	
}
