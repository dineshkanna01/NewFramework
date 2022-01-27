package com.admin.pom;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import Utility.ExcelData;
import base.TestBase;
import pages.AbstractBasePage;

/*
 * Pom class for Rate plan
 * @author Rudraksh Aggarwal
 */
public class RatePlanPage extends AbstractBasePage {
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

	@FindBy(name = "AttachAddons")
	WebElement addOnAttach;

	@FindBy(xpath = "(//input[@name='selectedItems'])[last()]")
	WebElement selectAddOn;

	@FindBy(xpath = "//input[@value='Add']")
	WebElement addButton;

	@FindBy(xpath = "//select[@name='classification']")
	WebElement classifications;

	@FindBy(name = "selectedCategoryId")
	WebElement category;

	@FindBy(xpath = "//select[@name='classification']/option")
	List<WebElement> classificationsList;

	@FindBy(xpath = "//tr[@class='ratePlanHeader'][last()]")
	WebElement categoryName;

	@FindBy(xpath = "//div[@class='banner_right_col']/a[1]")
	WebElement crossProperty;

	@FindBy(xpath = "//*[@value='Select Property']")
	WebElement propertySelectButton;

	@FindBy(xpath = "//*[@value='118']")
	WebElement property;

	@FindBy(xpath = "//h1[text()='Application Error']")
	WebElement errorMessage;

	@FindBy(xpath = "//*[text()='Duplicate Code']")
	WebElement duplicate;

	@FindBy(xpath = "//*[@value='Cancel']")
	WebElement cancelButton;

	ExcelData e = new ExcelData();

	public RatePlanPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	public String UrlTilte() {
		return driver.getTitle();
	}

	/*
	 * Method to input field for TC01
	 */
	public RatePlanPage inputFields_tc01() {

		name.sendKeys(e.getCellData("RatePlanPageData", "Name_TC01", 2));
		TestBase.implict(1);
		ratePlanCode.sendKeys(e.getCellData("RatePlanPageData", "RateTypeCode_TC01", 2));
		TestBase.implict(1);
		shortDescription.sendKeys(e.getCellData("RatePlanPageData", "ShortDescription_TC01", 2));
		TestBase.implict(1);

		DateFormat dateFormat = new SimpleDateFormat("MM/DD/YY");
		Date date = new Date();
		String strDate = dateFormat.format(date);

		startDate.sendKeys(strDate);
		// startDate.sendKeys(e.getCellData("RatePlanPageData", "BookingStartDate_TC01",
		// 2));
		TestBase.implict(1);
		firstCheckInDate.sendKeys(strDate);

		// firstCheckInDate.sendKeys(e.getCellData("RatePlanPageData",
		// "FirstCheckinDate_TC01", 2));

		return null;

	}

	/*
	 * Method to input field for TC02
	 */
	public RatePlanPage inputFields_tc02() {

		name.sendKeys(e.getCellData("RatePlanPageData", "Name_TC01", 2));
		TestBase.implict(1);
		ratePlanCode.sendKeys(e.getCellData("RatePlanPageData", "RateTypeCode_TC01", 2));
		TestBase.implict(1);

		shortDescription.sendKeys(e.getCellData("RatePlanPageData", "ShortDescription_TC01", 2));
		TestBase.implict(1);
		
		DateFormat dateFormat = new SimpleDateFormat("MM/DD/YY");
		Date date = new Date();
		String strDate = dateFormat.format(date);
		
		startDate.sendKeys(strDate);
		TestBase.implict(1);

		firstCheckInDate.sendKeys(strDate);
		TestBase.implict(1);
		
		roomTextBox.sendKeys(e.getCellData("RatePlanPageData", "RoomNameTextbox", 2));

		return null;

	}

	/*
	 * Method to input field for TC05
	 */
	public RatePlanPage inputFields_tc05() {

		name.sendKeys(e.getCellData("RatePlanPageData", "Name_TC01", 2));
		TestBase.implict(1);
		ratePlanCode.sendKeys(e.getCellData("RatePlanPageData", "RateTypeCode_TC01", 2));
		TestBase.implict(1);

		Select dropdown = new Select(category);
		dropdown.selectByVisibleText(e.getCellData("RatePlanCategoriesData", "CategoryName", 2));

		shortDescription.sendKeys(e.getCellData("RatePlanPageData", "ShortDescription_TC01", 2));
		TestBase.implict(1);

		DateFormat dateFormat = new SimpleDateFormat("MM/DD/YY");
		Date date = new Date();
		String strDate = dateFormat.format(date);

		startDate.sendKeys(strDate);
		TestBase.implict(1);
		firstCheckInDate.sendKeys(strDate);
		return null;

	}

	/*
	 * Method to attach add on to rate plan
	 */
	public RatePlanPage attachAddOns() {
		addOnAttach.click();
		TestBase.implict(1);
		selectAddOn.click();
		addButton.click();
		TestBase.implict(3);

		return null;
	}

	/*
	 * Method to select room type
	 */
	public RatePlanPage selectRoomType() {
		roomAllCheckbox.click();
		return null;
	}

	/*
	 * Method to select radio button for derive rates
	 */
	public RatePlanPage deriveRatesNo() {
		deriveRatesNoButton.click();
		return null;
	}

	/*
	 * Method to click save button
	 */
	public RatePlanPage clickSaveButton() {
		saveButton.click();
		TestBase.implict(3);
		return null;
	}

	/*
	 * Method to delete rate plan
	 */
	public RatePlanPage deleteRatePlan() {
		ratePlanCheckbox.click();
		deleteButton.click();
		TestBase.implict(3);
		yesButton.click();
		TestBase.implict(4);
		return null;
	}

	/*
	 * Method to verify created rate plan name
	 * 
	 * @return boolean value
	 */
	public boolean verifyRateName() {
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

	/*
	 * Method to verify created rate plan association
	 * 
	 * @return boolean value
	 */
	public boolean verifyRateAssociation() {
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

	/*
	 * Method to verify add on button for diff rate classifications
	 */
	public void verifyAddOnbuttonforDiffClassifications() {
		List<WebElement> li = classificationsList;
		int a = li.size();
		System.out.println("number of classifications: " + a);

		Select dropdown = new Select(classifications);
		dropdown.selectByIndex(0);
		System.out.println(dropdown.getFirstSelectedOption().getText());
		Assert.assertFalse(verifytc04());
		TestBase.implict(2);

		for (int i = 1; i < a; i++) {
			dropdown.selectByIndex(i);
			System.out.println(dropdown.getFirstSelectedOption().getText());
			Assert.assertTrue(verifytc04());
			TestBase.implict(2);
		}

	}

	/*
	 * Method to verify attach add ons buttton for TC04
	 * 
	 * @return boolean value
	 */
	public boolean verifytc04() {
		if (addOnAttach.isDisplayed()) {
			System.out.println("Attach Add ons button is visible");
			return true;
		} else
			System.out.println("Atatch add ons button is not visible");
		return false;
	}

	/*
	 * Method to select cross button
	 */
	public RatePlanCategoriesPage clickOnCross() {
		crossProperty.click();
		return null;
	}

	/*
	 * Method to select property without any room
	 */
	public RatePlanPage propertyNoRoom() {
		crossProperty.click();
		property.click();
		TestBase.implict(3);
		propertySelectButton.click();
		TestBase.implict(3);

		return null;
	}

	/*
	 * Method to verify rate plan name for TC05
	 * 
	 * @return string rate plan name
	 */
	public String verifyTc05() {

		categoryName.click();
		TestBase.implict(2);

		String rName = verifyRatePlanName.getText();
		System.out.println(rName + "&&&");

		return rName;
	}

	/*
	 * Method to verify application error message
	 * 
	 * @return boolean value
	 */
	public boolean verifyApplicationError() {
		String error = errorMessage.getText();
		error = error.replaceAll("\\s+", "");
		System.out.println(error + "####");

		String errorExp = "Application Error";
		errorExp = errorExp.replaceAll("\\s+", "");

		System.out.println(errorExp + "$$$");

		if (error.equals(errorExp)) {
			System.out.println("Application error is coming");
			return true;
		} else {
			System.out.println("Application error is not coming");
			return false;

		}

	}

	/*
	 * Method to verify duplicate error message
	 * 
	 * @return boolean value
	 */
	public boolean verifyDuplicateError() {
		String error = duplicate.getText();
		error = error.replaceAll("\\s+", "");
		System.out.println(error + "####");

		String errorExp = "Duplicate Code";
		error = error.replaceAll("\\s+", "");

		System.out.println(errorExp + "$$$");

		if (error.equals(errorExp)) {
			System.out.println("error- Duplicate Code");
		}
		return true;

	}

	/*
	 * Method to click cancel
	 */
	public PoliciesPage clickOnCancel() {
		cancelButton.click();
		TestBase.implict(3);

		return null;
	}
}
