package com.be.pom;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utility.ExcelData;
import base.Helper;
import base.TestBase;

/*
 * POM class for Formula Base Pricing Strike Through
 * @Author Uzair Asar
 */

public class FBPStrikeThroughPricingPage extends TestBase {

	@FindBy(xpath = "//*[contains(@href,'/admin/action/displayPropertyDe')]")
	WebElement propertyDefaults;

	@FindBy(xpath = "//strong[text()='BAR']")
	WebElement barRatePlan;

	@FindBy(xpath = "(//input[@name='isFormulaBasedPricingEnabled'])[1]")
	WebElement fbpEnabled;

	@FindBy(xpath = "(//input[@name='isFormulaBasedPricingEnabled'])[2]")
	WebElement fbpDisabled;

	@FindBy(xpath = "//button[text()='Yes']")
	WebElement fbpYesButton;

	@FindBy(xpath = "//input[@id='slashThroughPricingEnable']")
	WebElement fbpSlashThroughEnabled;

	@FindBy(xpath = "//input[@id='slashThroughPricingDisable']")
	WebElement fbpSlashThroughDisabled;

	@FindBy(xpath = "//input[@name='Save']")
	WebElement propertyDefaultSaveButton;

	@FindBy(xpath = "//*[contains(@href,'ageRoom')]")
	WebElement manageFBPOption;

	@FindBy(xpath = "//a[@title='Show All Items']")
	WebElement selectRatePlan;

	@FindBy(xpath = "(//li[@class='ui-menu-item']//a)[1]")
	WebElement ratePlanSelected;

	@FindBy(xpath = "//input[@name='Load Rateplan']")
	WebElement ratePlanGoButton;

	@FindBy(xpath = "//a[text()='Add']")
	WebElement ratePlanAddFBPButton;

	@FindBy(id = "dateFrom")
	WebElement fromDateFBP;

	@FindBy(id = "dateTo")
	WebElement toDateFBP;

	@FindBy(xpath = "(//input[@id='selectAll'])[1]")
	WebElement allDaysOfWeek;

	@FindBy(xpath = "(//input[@name='floatsByPercent'])[1]")
	WebElement selectFlatAmount;

	@FindBy(xpath = "(//input[@name='floatsByPercent'])[2]")
	WebElement selectPercentageAmount;

	@FindBy(xpath = "//input[@id='rate_difference_0']")
	WebElement inputAmount;

	@FindBy(xpath = "//strong[text()='Summer Special']/following::strong[3]")
	WebElement verifyAmountBE;

	@FindBy(xpath = "//a[text()='View Rate Plan']")
	WebElement viewRatePlan;

	@FindBy(xpath = "//input[@name='name']")
	WebElement ratePlanNameFromAdmin;

	@FindBy(xpath = "((//td[text()='Floating'])[1]/following::td//a[1])[1]")
	WebElement editFloatingRatePlanNameForFBP;

	@FindBy(xpath = "//td[text()='List of Rate Plans']")
	WebElement verifyFBPSavedText;

	@FindBy(id = "summary_reservation_confirmation_code")
	WebElement confirmCode;

	public FBPStrikeThroughPricingPage(WebDriver driver) {
		super();
		PageFactory.initElements(driver, this);
	}

	public String UrlTilte() {
		return driver.getTitle();
	}

	/*
	 * Method to check BAR rate plan in BE
	 * return string value
	 */

	public String verifyOnyBARIsThere() {
		String s = barRatePlan.getText();
		System.out.println("BAR rate Plan is there: " + s);
		return s;
	}

	/*
	 * Method to click on Property Default Option
	 */

	public FBPStrikeThroughPricingPage propertyDefaults() {
		Helper.implict(3);
		propertyDefaults.click();
		return null;
	}

	/*
	 * Method to enable FBP
	 */

	public FBPStrikeThroughPricingPage enableFBP() {
		Helper.implict(3);
		fbpEnabled.click();
		Helper.implict(3);
		fbpYesButton.click();
		fbpSlashThroughEnabled.click();
		return null;
	}

	/*
	 * Method to disable FBP
	 */

	public FBPStrikeThroughPricingPage disableFBP() {
		Helper.implict(3);
		fbpDisabled.click();
		return null;
	}

	/*
	 * Method to disable FBP strike through
	 */

	public FBPStrikeThroughPricingPage disableFBPStrikeThrough() {
		Helper.implict(3);
		fbpSlashThroughDisabled.click();
		return null;
	}

	/*
	 * Method to click on Property Default Save button
	 */

	public FBPStrikeThroughPricingPage propertyDefaultsSaveButton() {
		propertyDefaultSaveButton.click();
		return null;
	}

	/*
	 * Method to verify FBP enabled
	 * return boolean value
	 */

	public boolean verifyManageFBP() {
		if (manageFBPOption.isDisplayed()) {
			return true;
		} else {
			return false;
		}
	}

	/*
	 * Method to click on manage FBP option
	 */

	public FBPStrikeThroughPricingPage manageFBPOption() {
		Helper.implict(3);
		manageFBPOption.click();
		return null;
	}

	/*
	 * Method to select rate plan for FBP
	 */

	public FBPStrikeThroughPricingPage selectRateplanInFBP() {
		Helper.implict(3);
		selectRatePlan.click();
		ratePlanSelected.click();
		ratePlanGoButton.click();
		return null;
	}

	/*
	 * Method to click on add new FBP button
	 */

	public FBPStrikeThroughPricingPage addFBP() {
		Helper.implict(3);
		ratePlanAddFBPButton.click();
		return null;
	}

	/*
	 * Method to select date range for FBP
	 */

	public FBPStrikeThroughPricingPage addingDateRangeAndWeekFBP() {
		Helper.implict(3);
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yy");
		Calendar c = Calendar.getInstance();
		c.add(Calendar.DAY_OF_MONTH, 1);
		String newDate = sdf.format(c.getTime());
		fromDateFBP.sendKeys(newDate);
		toDateFBP.sendKeys(newDate);
		Helper.implict(3);
		allDaysOfWeek.click();
		Helper.implict(3);
		return null;
	}

	/*
	 * Method to select flat amount
	 */

	public FBPStrikeThroughPricingPage selectFlatAmountOption() {
		Helper.implict(3);
		selectFlatAmount.click();
		return null;
	}

	/*
	 * Method to select percentage amount
	 */

	public FBPStrikeThroughPricingPage selectPercentageAmountOption() {
		Helper.implict(3);
		selectPercentageAmount.click();
		return null;
	}

	/*
	 * Method to add amount amount
	 */

	public FBPStrikeThroughPricingPage inputAmount() {
		Helper.implict(3);
		inputAmount.clear();
		Helper.implict(3);
		inputAmount.sendKeys(ExcelData.getCellData("FBPStrikeThrough", "PositiveAmount", 2));
		return null;
	}

	/*
	 * Method to modify amount
	 */

	public FBPStrikeThroughPricingPage inputMofifyAmount() {
		Helper.implict(3);
		inputAmount.clear();
		Helper.implict(3);
		inputAmount.sendKeys(ExcelData.getCellData("FBPStrikeThrough", "ModifyAmount", 2));
		return null;
	}

	/*
	 * Method to pass null amount
	 */

	public FBPStrikeThroughPricingPage inputNullAmount() {
		Helper.implict(3);
		inputAmount.clear();
		Helper.implict(3);
		inputAmount.sendKeys(ExcelData.getCellData("FBPStrikeThrough", "NullAmount", 2));
		return null;
	}

	/*
	 * Method to view rate plan
	 */

	public FBPStrikeThroughPricingPage clickOnViewRatePlan() {
		Helper.implict(3);
		viewRatePlan.click();
		return null;
	}

	/*
	 * Method to take amount from BE
	 * return string value
	 */

	public String pickAmountFromRatePlanBE() {
		Helper.implict(3);
		String s = ratePlanNameFromAdmin.getAttribute("value");
		System.out.println("Rate plan in admin: " + s);
		Helper.switchWindow(1);
		getDriver().navigate().refresh();
		Helper.sleep(2000);
		// WebElement amountInBEw =
		// getDriver().findElement(By.xpath("//strong[text()='"+s+"']/following::strong[3]"));

		// TestBase.explicit(amountInBEw,3);
		String amountInBE = getDriver().findElement(By.xpath("//strong[text()='" + s + "']/following::strong[3]"))
				.getText();
		String subS = amountInBE.substring(4);
		System.out.println("Smart Rate Amount: " + subS);
		Helper.implict(3);
		return subS;

	}

	/*
	 * Method to select edit floating rate plan
	 */

	public FBPStrikeThroughPricingPage editFloatingRatePlanNameForFBP() {
		Helper.explicit(editFloatingRatePlanNameForFBP, 3);
		editFloatingRatePlanNameForFBP.click();
		return null;
	}

	/*
	 * Method to verify text after saving
	 * return string value
	 */

	public String verifyFBPSavedText() {
		Helper.implict(3);
		String s = verifyFBPSavedText.getText();
		return s;
	}

	/*
	 * Method to verify reservation completed
	 * return boolean value
	 */

	public boolean verifyReservationCompleted() {
		Helper.implict(5);
		Helper.sleep(1000);
		if (confirmCode.isDisplayed()) {
			System.out.println("Booking is completed");
			return true;
		} else {
			return false;
		}
	}
}