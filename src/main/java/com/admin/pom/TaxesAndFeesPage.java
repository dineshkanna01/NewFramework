package com.admin.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import Utility.ExcelData;
import base.TestBase;
import pages.AbstractBasePage;

/*
 * POM class to Tax Scenario
 * @Author Ankita Mohamanasingh
 */
public class TaxesAndFeesPage extends AbstractBasePage {
	
	ExcelData e = new ExcelData();
	public WebDriver driver;

	public TaxesAndFeesPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	public String UrlTilte() {
		return driver.getTitle();
	}


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
	
	@FindBy(xpath = "(//input[@name='taxIdsToDelete'])[1]")
	WebElement taxDelete1;
	
	@FindBy(xpath = "(//input[@name='taxIdsToDelete'])[2]")
	WebElement taxDelete2;

	@FindBy(xpath = "(//input[@value='Delete'])")
	WebElement taxDeletButton;

	@FindBy(xpath = "//table[@width='100%']//tr[last()]/td[5]")
	WebElement taxAmount;

	@FindBy(xpath = "//table[@width='100%']//tr[last()]/td[6]")
	WebElement taxFrequency;

	@FindBy(xpath = "//table[@width='100%']//tr[last()]/td[7]")
	WebElement taxBasis;

	@FindBy(xpath = "//*[contains(@class,' ui-button-text')][1]")
	WebElement deleteOK;

	@FindBy(id="btnSubmit")
	WebElement save;
	/*
	 * Method to click on delete ok
	 * 
	 */
	public TaxesAndFeesPage clickOnOKDelete()  {
		deleteOK.click();
		TestBase.implict(3);
		return null;
	}

	/*
	 * Method to click on Taxes and Fees
	 * 
	 */
	public TaxesAndFeesPage clickTaxesAndFees()  {
		taxesAndFees.click();
		TestBase.implict(3);
		return null;
	}

	/*
	 * Method to click on add New Tax to Property
	 * 
	 */
	public TaxesAndFeesPage clickaddNewTaxtoProperty()  {
		addNewTaxtoProperty.click();
		TestBase.implict(3);	
		return null;
	}

	/*
	 * Method to click on Save
	 */

	public TaxesAndFeesPage clickSave()  {
		save.click();
		TestBase.implict(3);
		return null;
	}

	/*
	 * Method to click on delete
	 * 
	 */
	public AboutThePropertyPages clickDeleteTax()  {
		taxDeleteCode.click();
		taxDeletButton.click();
		TestBase.implict(3);
		return null;
	}
	/*
	 * Method to verify deleted Tax returns boolean value
	 */

	public boolean verifyDeletedTax()  {
		String ActText = editTax.getText();
		System.out.println(ActText+" Actual Text");

		if (editTax.isDisplayed()) {
			System.out.println(" Tax not deleted");
			return true;
		} else {
			System.out.println(" room deleted");
			return false;

		}
	}
	/*
	 * Method to Add Tax
	 * 
	 */

	public TaxesAndFeesPage addtax()  {

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
	/*
	 * Method to verify created Tax returns boolean value
	 * 
	 */
	public boolean verifyTaxCreated()  {

		if (editTax.isDisplayed()) {
			System.out.println("Tax created");
			return true;
		} else {
			System.out.println("Tax not Created");
			return false;

		}
	}

	/*
	 * Method to update Tax name to Property
	 * 
	 */

	public TaxesAndFeesPage updateTheTaxName()  {

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

	/*
	 * Method to verify created Tax for edit returns boolean value
	 * 
	 */
	public boolean verifyCreatedTaxForEdit()  {
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
	/*
	 * Method to verify edited Tax returns boolean value
	 * 
	 */
	public boolean verifyTaxEdited()  {
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
	/*
	 * Method to edit Tax
	 * 
	 */
	public AboutThePropertyPages editTheCreatedTax()  {
		editTax.click();
		TestBase.implict(3);
		addTaxName.clear();
		addTaxName.sendKeys(e.getCellData("Taxes", "TaxName3", 2));

		return null;

	}


	/*
	 * Method to  edit Tax Amount
	 * 
	 */
	public TaxesAndFeesPage updateTaxAmount()  {

		editTax.click();
		chargeAmount.clear();
		chargeAmount.sendKeys(e.getCellData("Taxes", "ChargeAmount", 2));

		return null;


	}
	/*
	 * Method to verify edited Tax
	 *  returns boolean value
	 * 
	 */

	public boolean verifyExistedTaxAmountEdited() {
		String ActText = taxAmount.getText();
		ActText = ActText.replaceAll("\\s+", "");
		System.out.println(ActText+" Actual Text");


		String expText = e.getCellData("Taxes", "ChargeAmount", 2);          
		expText = expText.replaceAll("\\s+", "");

		if (ActText.equalsIgnoreCase(expText)) {
			System.out.println(" Tax editied");
			return true;
		} else {
			System.out.println(" Tax not edited");
			return false;

		}
	}
	/*
	 * Method to create tax  for charge frequency edit in Tax scenario

	 */
	public TaxesAndFeesPage addTaxToEditChargeFrequency()  {

		addTaxName.sendKeys(e.getCellData("Taxes", "TaxName4", 2));
		code.sendKeys(e.getCellData("Taxes", "TaxCode4", 2));
		feeRadioButton.click();
		stayChargeFrequencyRadioButton.click();
		personChargeBasisRadioButton.click();
		chargeAmount.sendKeys(e.getCellData("Taxes", "ChargeAmount4", 2));
		flatFeeChargeTypeRadioButton.click();
		dayOfweekApplicableWednesday.click();
		dayOfweekApplicableSaturday.click();
		return null;


	}
	/*
	 * Method to verify tax created for frequency edit in Tax scenario
	 * returns boolean value
	 * 
	 */
	public boolean verifyCreatedTaxForEditChargeFreqency()  {
		String ActText = editTax.getText();
		System.out.println(ActText+" Actual Text");
		String expText=(e.getCellData("Taxes", "TaxName4", 2));
		System.out.println(expText+" "+"ExpectedText");
		if (ActText.equals(expText)) {
			System.out.println(" Tax  created");
			return true;
		} else {
			System.out.println(" Tax deleted");
			return false;

		}
	}
	/*
	 * Method to edit tax frequency edit in Tax Scenario
	 *
	 */


	public TaxesAndFeesPage changeChargeFreqency()  {

		editTax.click();
		dayChargeFrequencyRadioButton.click();


		return null;


	}
	/*
	 * Method to verify tax frequency edit in Tax scenario
	 * returns boolean value
	 * 
	 */

	public boolean verifyTaxFrquencyEdited()  {
		String ActText = taxFrequency.getText();
		ActText = ActText.replaceAll("\\s+", "");
		System.out.println(ActText+" Actual Text");
		String expText=(e.getCellData("Taxes", "TaxFrequency4", 2));
		System.out.println(expText+" "+"ExpectedText");


		if (ActText.equalsIgnoreCase(expText)) {
			System.out.println(" Tax  not edited");
			return true;
		} else {
			System.out.println(" Tax   edited");
			return false;

		}
	}
	/*
	 * Method to edit  Charge basis of existed tax in tax scenario
	 * 
	 */

	public TaxesAndFeesPage changeChargeBasis()  {
		editTax.click();
		roomChargeBasisRadioButton.click();
		return null;


	}
	/*
	 * Method to verify  charge basis edit in Tax Scenario 
	 * returns boolean value
	 * 
	 */

	public boolean verifyTaxBasisEdited()  {
		String ActText = taxBasis.getText();
		ActText = ActText.replaceAll("\\s+", " ");
		System.out.println(ActText+" Actual Text");
		String expText=(e.getCellData("Taxes", "TaxBasis4", 2));
		System.out.println(expText+" "+"ExpectedText");

		if (ActText.equalsIgnoreCase(expText)) {
			System.out.println(" Tax  not edited");
			return true;
		} else {
			System.out.println(" Tax   edited");
			return false;

		}
	}
	/*
	 * Method to edit  Charge basis of existed tax in tax scenario
	 * 
	 */

	public TaxesAndFeesPage deleteAllTax() throws InterruptedException  {
		taxDelete1.click();
		taxDelete2.click();
		taxDeletButton.click();
		deleteOK.click();
		Thread.sleep(2000);
		return null;


	}

}
