package com.be.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utility.ExcelData;
import base.Helper;
import base.TestBase;

/*
 * POM class to Apply Compound Access Code
 * @Author Uzair Asar
 */

public class CompoundAccessCodePage extends TestBase {

	@FindBy(xpath = "(//input[@name='isCompoundAccessCodeEnabled'])[1]")
	WebElement compoundAccessCodeEnable;

	@FindBy(xpath = "(//input[@name='isCompoundAccessCodeEnabled'])[2]")
	WebElement compoundAccessCodeDisable;

	@FindBy(xpath = "//*[contains(@href,'/admin/action/cac')]")
	WebElement adminCompoundAccessCode;

	@FindBy(xpath = "//a[text()='Add new compound access code']")
	WebElement addCompoundAccessCode;

	@FindBy(id = "code")
	WebElement inputCode;

	@FindBy(xpath = "(//input[@name='selectedRatePlanIds'])[1]")
	WebElement selectRatePlan;

	@FindBy(xpath = "(//input[@name='selectedRatePlanIds'])[3]")
	WebElement selectRatePlan2;

	@FindBy(xpath = "//input[@value='Save']")
	WebElement saveButton;

	@FindBy(id = "search_offer_code")
	WebElement beApplyCompoundAccessCode;

	@FindBy(xpath = "//*[@id=\"dataTable\"]//tr[last()]/td[2]")
	WebElement verifyCompoundAccessCodeAdded;

	@FindBy(id = "check-availability-btn")
	WebElement checkAvailability;

	@FindBy(xpath = "(//input[@name='selectedItemsToDelete'])[last()]")
	WebElement deleteCompoundAccessCode;

	@FindBy(xpath = "//input[@value='Delete']")
	WebElement deleteButton;

	@FindBy(xpath = "//span[text()='OK']")
	WebElement confirmDeleteButton;

	@FindBy(xpath = "//*[@id='dataTable']//tr[last()]//td[3]//li")
	WebElement ratePlanAssociated1;

	@FindBy(xpath = "(//label[@class='row']//span//strong)[1]")
	WebElement ratePlanAssociatedBE;

	@FindBy(xpath = "//*[@id='dataTable']//tr[last()]//td[4]//a")
	WebElement editCompoundAccessPlan;

	@FindBy(xpath = "//*[@id='dataTable']//tr[last()]//td[5]//a[1]")
	WebElement compoundAccessCodeBookingLink;

	@FindBy(xpath = "(//table[@role='presentation']//td)[2]")
	WebElement roomCharges;

	@FindBy(id = "search_arrival_date")
	WebElement checkInCalander;

	@FindBy(xpath = "//td[@class='active day']")
	WebElement checkInDate;

	@FindBy(xpath = "//button[text()='Check availability']")
	WebElement checkAvailability2;

	public CompoundAccessCodePage(WebDriver driver) {
		super();
		PageFactory.initElements(driver, this);
	}

	public String UrlTilte() {
		return driver.getTitle();
	}

	/*
	 * Method to enable Compound Access Code
	 */

	public CompoundAccessCodePage compoundAccessCodeEnable() {
		compoundAccessCodeEnable.click();
		return null;
	}

	/*
	 * Method to disable Compound Access Code
	 */

	public CompoundAccessCodePage compoundAccessCodeDisable() {
		compoundAccessCodeDisable.click();
		return null;
	}

	/*
	 * Method to verify Compound Access Code enabled return boolean value return
	 * boolean value
	 */

	public boolean verifyAdminCompoundAccessCode() {
		Helper.implict(3);
		if (adminCompoundAccessCode.isDisplayed()) {
			System.out.println("Compound Access Code Enabled");

			return true;
		} else
			return false;
	}

	/*
	 * Method to click on Compound Access Code
	 */

	public CompoundAccessCodePage adminCompoundAccessCode() {
		adminCompoundAccessCode.click();
		return null;
	}

	/*
	 * Method to add compound access code
	 */

	public CompoundAccessCodePage addingCompoundAccessCode() {
		addCompoundAccessCode.click();
		inputCode.sendKeys(ExcelData.getCellData("CompoundAccessCode", "Code", 2));
		selectRatePlan.click();
		return null;
	}

	/*
	 * Method to save compound access code
	 */

	public CompoundAccessCodePage saveCompoundAccessCode() {
		saveButton.click();
		return null;
	}

	/*
	 * Method to provide compound access code in BE
	 */

	public CompoundAccessCodePage beApplyCompoundAccessCode() {
		beApplyCompoundAccessCode.sendKeys(ExcelData.getCellData("CompoundAccessCode", "Code", 2));
		return null;
	}

	/*
	 * Method to delete compound Access code
	 */

	public CompoundAccessCodePage deleteCompoundAccessCode() {
		deleteCompoundAccessCode.click();
		deleteButton.click();
		confirmDeleteButton.click();
		Helper.sleep(2000);
		return null;
	}

	/*
	 * Method to click on check availability button in BE
	 */

	public CompoundAccessCodePage checkAvailabilityButton() {
		checkAvailability.click();
		return null;
	}

	/*
	 * Method to verify compound access code added return boolean value
	 */

	public boolean verifyCompoundAccessCodeAdded() {
		String s = verifyCompoundAccessCodeAdded.getText();
		System.out.println(s);
		String s1 = ExcelData.getCellData("CompoundAccessCode", "Code", 2);

		if (s.equals(s1)) {
			System.out.println("Compound Access Code successfully Added");
			return true;
		}

		else {
			return false;
		}
	}

	/*
	 * Method to verify rate plan associated with Compound Access code return string
	 * value
	 */

	public String ratePlanAssociated() {
		String s = ratePlanAssociated1.getText();
		System.out.println("Rate plan Admin Associated " + s);
		return s;
	}

	/*
	 * Method to verify rate plan associated with Compound Access code in BE return
	 * string value
	 */

	public String ratePlanAssociatedBE() {
		String s = ratePlanAssociatedBE.getText();
		System.out.println("Rate plan BE Associated " + s);
		return s;
	}

	/*
	 * Method to edit Compound Access Code
	 */

	public CompoundAccessCodePage editCompoundAccessCode() {
		editCompoundAccessPlan.click();
		selectRatePlan.click();
		selectRatePlan2.click();
		return null;
	}

	/*
	 * Method to click on compound access code link
	 */

	public CompoundAccessCodePage compoundAccessCodeBookingLink() {
		compoundAccessCodeBookingLink.click();
		return null;
	}

	/*
	 * Method to verify room charge after deleting compound access code return
	 * boolean value
	 */

	public boolean verifyRoomCharge() {
		String s = roomCharges.getText();
		String subS = s.substring(4);
		System.out.println("Amount = " + subS);
		if (subS.equals("0.00")) {
			System.out.println("No Rate Plan Available");
			return true;
		} else {
			return false;
		}
	}

	/*
	 * Method to check availability in BE
	 */

	public CompoundAccessCodePage availabilityCheck() {
		Helper.implict(3);
		checkInCalander.click();
		Helper.implict(3);
		checkInDate.click();
		Helper.implict(3);
		checkAvailability2.click();
		Helper.implict(3);
		return null;
	}

}