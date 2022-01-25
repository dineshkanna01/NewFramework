package com.admin.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import Utility.ExcelData;
import base.TestBase;
import pages.AbstractBasePage;

public class TaxesAndFeesPage extends AbstractBasePage {
	ExcelData e = new ExcelData();
	public WebDriver driver;

	@FindBy(xpath = "//*[contains(@href,'TaxList')]")
	WebElement taxesAndFees;

	@FindBy(xpath = "//*[contains(@href,'AddTax')]")
	WebElement addNewTaxtoProperty;

	@FindBy(xpath = "//a[text()=' Add a Room  ']")
	WebElement addaRoom;

	@FindBy(xpath = "//input[@name='taxName']")
	WebElement addTaxName;

	@FindBy(xpath = "//input[@name='code']")
	WebElement code;

	@FindBy(xpath = "(//input[@name='chargeAmount'])[2]")
	WebElement chargeAmount;

	@FindBy(xpath = "(//input[@name='dowCheckAll'])")
	WebElement dayOfweekApplicableAll;

	@FindBy(xpath = "(//input[@name='dowMonday'])")
	WebElement dayOfweekApplicableMonday;

	@FindBy(xpath = "(//input[@name='dowWednesday'])")
	WebElement dayOfweekApplicableWednesday;

	@FindBy(xpath = "(//input[@name='dowSaturday'])")
	WebElement dayOfweekApplicableSaturday;

	@FindBy(xpath = "(//input[@type='radio'])[1]")
	WebElement taxRadioButton;

	@FindBy(xpath = "(//input[@type='radio'])[2]")
	WebElement feeRadioButton;

	@FindBy(xpath = "(//input[@type='radio'])[5]")
	WebElement stayChargeFrequencyRadioButton;

	@FindBy(xpath = "(//input[@type='radio'])[6]")
	WebElement dayChargeFrequencyRadioButton;

	@FindBy(xpath = "(//input[@type='radio'])[7]")
	WebElement roomChargeBasisRadioButton;

	@FindBy(xpath = "(//input[@type='radio'])[8]")
	WebElement personChargeBasisRadioButton;

	@FindBy(xpath = "(//input[@type='radio'])[9]")
	WebElement percentChargeTypeRadioButton;

	@FindBy(xpath = "(//input[@type='radio'])[10]")
	WebElement flatFeeChargeTypeRadioButton;

	@FindBy(xpath = "((//input[@name='taxIdsToDelete'])[last()]/following::td/a)[1]")
	WebElement editTax;

	@FindBy(xpath = "(//input[@name='taxIdsToDelete'])[last()]")
	WebElement taxDeleteCode;

	@FindBy(xpath = "(//input[@value='Delete'])")
	WebElement taxDeletButton;

	@FindBy(xpath = "//table[@width='100%']//tr[3]/td[5]")
	WebElement taxAmount;


	@FindBy(id="btnSubmit")
	WebElement save;

	public TaxesAndFeesPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	public String UrlTilte() {
		return driver.getTitle();
	}

	public TaxesAndFeesPage clickTaxesAndFees() throws InterruptedException {
		taxesAndFees.click();
		TestBase.implict(3);
		return null;
	}


	public TaxesAndFeesPage clickaddNewTaxtoProperty() throws InterruptedException {
		addNewTaxtoProperty.click();
		TestBase.implict(3);	
		return null;
	}



	public TaxesAndFeesPage clickSave() throws InterruptedException {
		save.click();
		TestBase.implict(3);
		return null;
	}


	public AboutThePropertyPages clickDeleteTax() throws InterruptedException {
		taxDeleteCode.click();
		taxDeletButton.click();
		TestBase.implict(3);
		return null;
	}

	public boolean verifyDeletedTax() throws Exception {
		String ActText = editTax.getText();
		System.out.println(ActText+" Actual Text");

		if (editTax.isDisplayed()) {
			System.out.println(" room not deleted");
			return true;
		} else {
			System.out.println(" room deleted");
			return false;

		}
	}

	public TaxesAndFeesPage addtax() throws Exception {

		addTaxName.sendKeys(e.getCellData("Taxes", "TaxName", 2));
		code.sendKeys(e.getCellData("Taxes", "TaxCode", 2));
		feeRadioButton.click();
		stayChargeFrequencyRadioButton.click();
		personChargeBasisRadioButton.click();
		chargeAmount.sendKeys(e.getCellData("Taxes", "ChargeAmount", 2));
		flatFeeChargeTypeRadioButton.click();
		dayOfweekApplicableWednesday.click();
		dayOfweekApplicableSaturday.click();
		return null;


	}

	public boolean verifyTaxCreated() throws Exception {

		if (editTax.isDisplayed()) {
			System.out.println("Tax created");
			return true;
		} else {
			System.out.println("Tax not Created");
			return false;

		}
	}



	public TaxesAndFeesPage updateTheTaxName() throws Exception {

		addTaxName.sendKeys(e.getCellData("Taxes", "TaxName2", 2));
		code.sendKeys(e.getCellData("Taxes", "TaxCode2", 2));
		feeRadioButton.click();
		dayChargeFrequencyRadioButton.click();
		roomChargeBasisRadioButton.click();
		chargeAmount.sendKeys(e.getCellData("Taxes", "ChargeAmount2", 2));
		flatFeeChargeTypeRadioButton.click();
		dayOfweekApplicableAll.click();
		return null;


	}
	public boolean verifyCreatedTaxForEdit() throws Exception {
		String ActText = editTax.getText();
		System.out.println(ActText+" Actual Text");
		String expText=(e.getCellData("Taxes", "TaxName2", 2));
		System.out.println(expText+" "+"ExpectedText");
		if (ActText.equals(expText)) {
			System.out.println(" Tax  created");
			return true;
		} else {
			System.out.println(" Tax deleted");
			return false;

		}
	}

	public boolean verifyTaxEdited() throws Exception {
		String ActText = editTax.getText();
		ActText = ActText.replaceAll("\\s+", "");
		System.out.println(ActText+" Actual Text");
		String expText=(e.getCellData("Taxes", "TaxName2", 2));
		System.out.println(expText+" "+"ExpectedText");

		//String expText = e.getCellDataAnk("Dining2", "VerifyDistance6", 2);
		//expText = expText.replaceAll("\\s+", "");

		if (ActText.equalsIgnoreCase(expText)) {
			System.out.println(" Tax  not edited");
			return true;
		} else {
			System.out.println(" Tax   edited");
			return false;

		}
	}

	public AboutThePropertyPages editTheCreatedTax() throws Exception {
		editTax.click();
		TestBase.implict(3);
		addTaxName.clear();
		addTaxName.sendKeys(e.getCellData("Taxes", "TaxName3", 2));

		return null;

	}



	public TaxesAndFeesPage updateTaxAmount() throws Exception {

		editTax.click();
		chargeAmount.clear();
		chargeAmount.sendKeys(e.getCellData("Taxes", "ChargeAmount", 2));

		return null;


	}
	public boolean verifyExistedTaxAmountEdited() throws Exception {
		String ActText = taxAmount.getText();
		ActText = ActText.replaceAll("\\s+", "");
		System.out.println(ActText+" Actual Text");
		//	String expText=(e.getCellDataAnk("Dining2", "DistanceAway6", 2));
		//	System.out.println(expText+" "+"ExpectedText");

		String expText = e.getCellData("Taxes", "ChargeAmount", 2);          
		expText = expText.replaceAll("\\s+", "");

		if (ActText.equalsIgnoreCase(expText)) {
			System.out.println(" Meeting Room editied");
			return true;
		} else {
			System.out.println(" MeetingRoom not edited");
			return false;

		}
	}


	public TaxesAndFeesPage addTaxForSpecificDaysOfWeek() throws Exception {

		addTaxName.sendKeys(e.getCellData("Taxes", "TaxName3", 2));
		code.sendKeys(e.getCellData("Taxes", "TaxCode3", 2));
		feeRadioButton.click();
		stayChargeFrequencyRadioButton.click();
		personChargeBasisRadioButton.click();
		chargeAmount.sendKeys(e.getCellData("Taxes", "ChargeAmount3", 2));
		flatFeeChargeTypeRadioButton.click();
		dayOfweekApplicableWednesday.click();
		dayOfweekApplicableSaturday.click();
		return null;


	}
}
