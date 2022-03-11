package com.cc.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import Utility.ExcelData;
import base.Helper;
import base.TestBase;

/*
 * POM class for AlternateCurrencybookingsPage
 * @author Rudraksh Aggarwal
 */
public class AlternateCurrencybookingsPage extends TestBase {

	@FindBy(name = "defaultCurrencyId")
	WebElement defaultCurrencyDropdown;

	@FindBy(id = "set_currency")
	WebElement currencyDropdownCC;

	@FindBy(xpath = "//div[contains(@class,'ms-has-selections')]/button")
	WebElement alternateCurrencyDropdown;

	@FindBy(name = "Save")
	WebElement saveButton;

	@FindBy(xpath = "(//div[contains(@class,'room-charge-per-unit')])[1]")
	WebElement chargeFirstPageCC;

	@FindBy(xpath = "(//div[contains(@class,'total-rate')])[2]")
	WebElement chargePaymentPageCC;

	@FindBy(xpath = "//dt[text()='Grand total']/following::dd[1]")
	WebElement grandTotalCC;

	public AlternateCurrencybookingsPage(WebDriver driver) {
		super();
		PageFactory.initElements(driver, this);
	}

	public String UrlTilte() {
		return driver.getTitle();
	}

	/*
	 * Method to select Default Currency Admin
	 * 
	 */
	public AlternateCurrencybookingsPage selectDefaultCurrencyAdmin() {
		Select dropdown = new Select(defaultCurrencyDropdown);
		dropdown.selectByVisibleText(ExcelData.CC_getCellData("AlternateCurrencyBookings", "DefaultCurrencyAdmin", 2));
		String defaultCurrencyAdmin = dropdown.getFirstSelectedOption().getText();
		ExcelData.write_CellData("NormalSingleRoomBookingData", 1, 56, defaultCurrencyAdmin);
		return null;
	}

	/*
	 * Method to select Default Currency CC
	 * 
	 */
	public AlternateCurrencybookingsPage selectDefaultCurrencyCC() {
		Select dropdown = new Select(currencyDropdownCC);
		String currencyCC = dropdown.getFirstSelectedOption().getText();
		ExcelData.write_CellData("NormalSingleRoomBookingData", 1, 57, currencyCC);
		return null;
	}

	/*
	 * Method to verify Currency TC01
	 * 
	 */
	public boolean verifyCurrencyTC01() {
		String defaultCurrencyAdminExcel = ExcelData.CC_getCellData("AlternateCurrencyBookings", "DefaultCurrencyAdmin",
				2);
		String a = ExcelData.CC_getCellData("NormalSingleRoomBookingData", "DefaultCurrencyAdmin", 2);
		String b = ExcelData.CC_getCellData("NormalSingleRoomBookingData", "DefaultCurrencyCC", 2);
		if (a.equalsIgnoreCase(defaultCurrencyAdminExcel)) {
			// change currency from admin to its abbreviation as in cc its in abbreviated
			// form
			a = ExcelData.CC_getCellData("AlternateCurrencyBookings", "DefaultCurrencyAdmin", 3);
			System.out.println(a);
			if (b.equalsIgnoreCase(a)) {
				System.out.println("Default currency in admin: " + a + " and in cc: " + b);
			}
			return true;
		} else {
			System.out.println("NA");
			return false;
		}
	}

	/*
	 * Method to click Save Button
	 * 
	 */
	public AlternateCurrencybookingsPage clickSaveButton() {
		saveButton.click();
		Helper.sleep(3000);
		return null;
	}

	/*
	 * Method to selectAlternateCurrencyAdmin
	 * 
	 */
	public AlternateCurrencybookingsPage selectAlternateCurrencyAdmin() {
		Helper.waitVisibility(60, "//div[contains(@class,'ms-has-selections')]/button");
		alternateCurrencyDropdown.click();
		Helper.implict(10);
		String a = ExcelData.CC_getCellData("AlternateCurrencyBookings", "AlternateCurrencyAdmin", 2);
		WebElement e = getDriver().findElement(By.xpath("//label[text()='" + a + "']/input"));
		WebElement e1 = getDriver().findElement(By.xpath("//label[text()='" + a + "']"));
		String b = e1.getText();
		ExcelData.write_CellData("NormalSingleRoomBookingData", 1, 58, b);

		if (e.isSelected()) {
			System.out.println("selected already");
		} else {
			e.click();
			System.out.println("selected now");
		}

		return null;
	}

	/*
	 * Method to select Alternate Currency CC
	 * 
	 */
	public AlternateCurrencybookingsPage selectAlternateCurrencyCC() {
		Select dropdown = new Select(currencyDropdownCC);
		dropdown.selectByVisibleText(ExcelData.CC_getCellData("AlternateCurrencyBookings", "AlternateCurrencyCC", 2));
		String alternatecurrencyCC = dropdown.getFirstSelectedOption().getText();
		ExcelData.write_CellData("NormalSingleRoomBookingData", 1, 59, alternatecurrencyCC);
		return null;
	}

	/*
	 * Method to verify Alternate Currency TC01
	 */
	public boolean verifyAlternateCurrencyTC01() {
		String alternateCurrencyAdminExcel = ExcelData.CC_getCellData("AlternateCurrencyBookings",
				"AlternateCurrencyAdmin", 2);
		String a = ExcelData.CC_getCellData("NormalSingleRoomBookingData", "AlternateCurrencyAdmin", 2);
		String b = ExcelData.CC_getCellData("NormalSingleRoomBookingData", "AlternateCurrencyCC", 2);
		if (a.equalsIgnoreCase(alternateCurrencyAdminExcel)) {
			// change currency from admin to its abbreviation as in cc its in abbreviated
			// form
			a = ExcelData.CC_getCellData("AlternateCurrencyBookings", "AlternateCurrencyAdmin", 3);
			System.out.println(a);
			if (b.equalsIgnoreCase(a)) {
				System.out.println("Alternate currency in admin: " + a + " and in cc: " + b);
			}
			return true;
		} else {
			System.out.println("NA");
			return false;
		}
	}

	/*
	 * Method to select Currency CC TC02_1
	 */
	public AlternateCurrencybookingsPage selectCurrencyCCTC02_1() {
		Select dropdown = new Select(currencyDropdownCC);
		dropdown.selectByVisibleText(ExcelData.CC_getCellData("AlternateCurrencyBookings", "CurrencyCC", 2));
		String currencyCC = dropdown.getFirstSelectedOption().getText();
		System.out.println(currencyCC);
		return null;
	}

	/*
	 * Method to getChargeFirstPageTC02_1
	 */
	public AlternateCurrencybookingsPage getChargeFirstPageTC02_1() {
		Helper.waitVisibility(60, "(//div[contains(@class,'room-charge-per-unit')])[1]");
		String a = chargeFirstPageCC.getText();
		ExcelData.write_CellData("NormalSingleRoomBookingData", 1, 60, a);
		return null;
	}

	/*
	 * Method to getChargeFirstPageTC02_1
	 */
	public AlternateCurrencybookingsPage selectCurrencyCCTC02_2() {
		Select dropdown = new Select(currencyDropdownCC);
		dropdown.selectByVisibleText(ExcelData.CC_getCellData("AlternateCurrencyBookings", "AlternateCurrencyCC", 2));
		String currencyCC = dropdown.getFirstSelectedOption().getText();
		System.out.println(currencyCC);
		Helper.sleep(3000);
		return null;
	}

	/*
	 * Method to getChargeFirstPageTC02_2
	 */
	public AlternateCurrencybookingsPage getChargeFirstPageTC02_2() {
		Helper.waitVisibility(60, "(//div[contains(@class,'room-charge-per-unit')])[1]");
		Helper.sleep(1000);
		String a = chargeFirstPageCC.getText();
		ExcelData.write_CellData("NormalSingleRoomBookingData", 1, 61, a);
		return null;
	}

	/*
	 * Method to getChargePaymentPageTC03_1
	 */
	public AlternateCurrencybookingsPage getChargePaymentPageTC03_1() {
		Helper.waitVisibility(60, "(//div[contains(@class,'total-rate')])[2]");
		String a = chargePaymentPageCC.getText();
		ExcelData.write_CellData("NormalSingleRoomBookingData", 1, 62, a);
		return null;
	}

	/*
	 * Method to getChargePaymentPageTC03_2
	 */
	public AlternateCurrencybookingsPage getChargePaymentPageTC03_2() {
		Helper.waitVisibility(60, "(//div[contains(@class,'total-rate')])[2]");
		String a = chargePaymentPageCC.getText();
		ExcelData.write_CellData("NormalSingleRoomBookingData", 1, 63, a);
		return null;
	}

	/*
	 * Method to getChargePaymentPageTC04_1
	 */
	public AlternateCurrencybookingsPage getChargePaymentPageTC04_1() {
		Helper.waitVisibility(60, "(//div[contains(@class,'total-rate')])[2]");
		String a = chargePaymentPageCC.getText();
		ExcelData.write_CellData("NormalSingleRoomBookingData", 1, 64, a);
		return null;
	}

	/*
	 * Method to getChargePaymentPageTC04_2
	 */
	public AlternateCurrencybookingsPage getChargePaymentPageTC04_2() {
		Helper.waitVisibility(60, "(//div[contains(@class,'total-rate')])[2]");
		String a = chargePaymentPageCC.getText();
		ExcelData.write_CellData("NormalSingleRoomBookingData", 1, 65, a);
		return null;
	}

	/*
	 * Method to get Grand Total CC TC05_1
	 */
	public void getGrandTotalCCTC05_1() {
		Helper.sleep(1000);
		try {
			Helper.waitVisibility(30, "//dt[text()='Grand total']/following::dd[1]");
			String gtb = grandTotalCC.getText();
			ExcelData.write_CellData("NormalSingleRoomBookingData", 1, 66, gtb);
		} catch (Exception e) {
			System.out.println("NA");
		}
	}

	/*
	 * Method to get Grand Total CC TC05_2
	 */
	public void getGrandTotalCCTC05_2() {
		Helper.sleep(1000);
		try {
			Helper.waitVisibility(30, "//dt[text()='Grand total']/following::dd[1]");
			String gtb = grandTotalCC.getText();
			ExcelData.write_CellData("NormalSingleRoomBookingData", 1, 67, gtb);
		} catch (Exception e) {
			System.out.println("NA");
		}
	}

	/*
	 * Method to verifyChargeTC02
	 */
	public boolean verifyChargeTC02() {
		String a = ExcelData.CC_getCellData("NormalSingleRoomBookingData", "ChargeTC02_1", 2);
		String b = ExcelData.CC_getCellData("NormalSingleRoomBookingData", "ChargeTC02_2", 2);
		if (a.equalsIgnoreCase(b)) {
			System.out.println("charges are same");
			return false;
		} else {
			System.out.println("TC02 charge before: " + a + " charge after: " + b);
			return true;
		}
	}

	/*
	 * Method to verifyChargeTC03
	 */
	public boolean verifyChargeTC03() {
		String a = ExcelData.CC_getCellData("NormalSingleRoomBookingData", "ChargeTC03_1", 2);
		String b = ExcelData.CC_getCellData("NormalSingleRoomBookingData", "ChargeTC03_2", 2);
		if (a.equalsIgnoreCase(b)) {
			System.out.println("charges are same");
			return false;
		} else {
			System.out.println("TC03 charge before: " + a + " charge after: " + b);
			return true;
		}
	}

	/*
	 * Method to verifyChargeTC04
	 */
	public boolean verifyChargeTC04() {
		String a = ExcelData.CC_getCellData("NormalSingleRoomBookingData", "ChargeTC04_1", 2);
		String b = ExcelData.CC_getCellData("NormalSingleRoomBookingData", "ChargeTC04_2", 2);
		if (a.equalsIgnoreCase(b)) {
			System.out.println("charges are same");
			return false;
		} else {
			System.out.println("TC04 charge before: " + a + " charge after: " + b);
			return true;
		}
	}

	/*
	 * Method to verifyChargeTC05
	 */
	public boolean verifyChargeTC05() {
		String a = ExcelData.CC_getCellData("NormalSingleRoomBookingData", "ChargeTC05_1", 2);
		String b = ExcelData.CC_getCellData("NormalSingleRoomBookingData", "ChargeTC05_2", 2);
		if (a.equalsIgnoreCase(b)) {
			System.out.println("charges are same");
			return false;
		} else {
			System.out.println("TC05 charge before: " + a + " charge after: " + b);
			return true;
		}
	}

}
