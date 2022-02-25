package com.be.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.admin.pom.PaymentGatewayPage;

import Utility.ExcelData;
import base.Helper;
import base.TestBase;

/*
 * POM class for Shift4 Payment Gateway Booking
 * @Author Uzair Asar
 */

public class Shift4BookingsPage extends TestBase {

	@FindBy(xpath = "//input[@name='orderValidDuration']")
	WebElement orderTime;

	@FindBy(xpath = "//input[@name='enabled']")
	WebElement enableButton;

	@FindBy(id = "card_holder_name")
	WebElement cardName;

	@FindBy(id = "card_number")
	WebElement cardNumber;

	@FindBy(id = "expiration_date_month")
	WebElement expiryMonthDropdown;

	@FindBy(id = "expiration_date_year")
	WebElement expiryYearDropdown;

	@FindBy(id = "security_code")
	WebElement secCode;

	@FindBy(id = "summary_reservation_confirmation_code")
	WebElement confirmCodes;

	@FindBy(xpath = "//input[@name='secureHashSecret']")
	WebElement secureHashSecret;

	public Shift4BookingsPage(WebDriver driver) {
		super();
		PageFactory.initElements(driver, this);
	}

	public String UrlTilte() {
		return driver.getTitle();
	}

	/*
	 * Method for enter order time
	 */
	public Shift4BookingsPage clearOrderTime() {
		orderTime.clear();
		return null;
	}

	/*
	 * Method to verify Shift4 Auto Populate
	 */

	public boolean verifyShift4AutoPopulate() {
		Helper.implict(3);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (enableButton.isSelected()) {
			System.out.println("Values are autopopulated");
			return true;
		} else {
			System.out.println("Values are not autopopulated");
			return false;
		}

	}

	/*
	 * Method to input Card Details TC01
	 * 
	 */
	public Shift4BookingsPage inputCardDetailsTC01() {

		cardName.sendKeys(ExcelData.getCellData("Shift4", "CardName", 2));
		cardNumber.sendKeys(ExcelData.getCellData("Shift4", "CardNumber1", 2));
		cardNumber.sendKeys(ExcelData.getCellData("Shift4", "CardNumber2", 2));
		cardNumber.sendKeys(ExcelData.getCellData("Shift4", "CardNumber3", 2));
		cardNumber.sendKeys(ExcelData.getCellData("Shift4", "CardNumber4", 2));

		Select dropdown = new Select(expiryMonthDropdown);
		dropdown.selectByVisibleText("12");
		Helper.implict(1);

		Select d = new Select(expiryYearDropdown);
		d.selectByVisibleText("2028");
		Helper.implict(1);

		secCode.sendKeys(ExcelData.getCellData("Shift4", "SecurityCode", 2));
		Helper.implict(1);
		return null;
	}

	/*
	 * Method to input Card Details TC01
	 * 
	 */
	public Shift4BookingsPage inputCardDetailsTC02() {

		cardName.sendKeys(ExcelData.getCellData("Shift4", "CardName", 2));
		cardNumber.sendKeys(ExcelData.getCellData("Shift4", "CardNumber1", 3));
		cardNumber.sendKeys(ExcelData.getCellData("Shift4", "CardNumber2", 3));
		cardNumber.sendKeys(ExcelData.getCellData("Shift4", "CardNumber3", 3));
		cardNumber.sendKeys(ExcelData.getCellData("Shift4", "CardNumber4", 3));

		Select dropdown = new Select(expiryMonthDropdown);
		dropdown.selectByVisibleText("12");
		Helper.implict(1);

		Select d = new Select(expiryYearDropdown);
		d.selectByVisibleText("2028");
		Helper.implict(1);

		secCode.sendKeys(ExcelData.getCellData("Shift4", "SecurityCode", 2));
		Helper.implict(1);
		return null;
	}

	/*
	 * Method for verificationTC03
	 * 
	 */
	public boolean verificationTC03() {
		if (confirmCodes.isDisplayed()) {

			String ConfirmationCode = confirmCodes.getText();
			System.out.println("Booking is completed, Confirmation code and Transaction id are: " + ConfirmationCode);
			return true;
		}

		else {
			System.out.println("Booking is not done");
			return false;
		}

	}

	/*
	 * Method for verificationTC04
	 * 
	 */
	// public boolean verificationTC04() {
	// if (errorMessageJCC.isDisplayed()) {
	//
	// String error = errorMessageJCC.getText();
	// System.out.println(error);
	//
	//
	// return true;
	// }
	//
	// else {
	// System.out.println("Booking is Done");
	//
	// return false;
	// }
	//
	// }

	/*
	 * Method for verificationTC05
	 * 
	 */
	public boolean verificationTC05() {
		if (confirmCodes.isDisplayed()) {

			String ConfirmationCode = confirmCodes.getText();
			System.out.println(
					"Booking is completed but Transaction id is not generated, Only Confirmation code is displayed which is: "
							+ ConfirmationCode);
		}
		return false;
	}

	// /*
	// * Method for verificationTC05
	// *
	// */
	// public boolean verificationTC06() {
	// if (errorMessageJCC.isDisplayed()) {
	//
	// String error = errorMessageJCC.getText();
	// System.out.println(error);
	// return true;
	// }
	//
	// else {
	// System.out.println("Booking is Done");
	//
	// return false;
	// }
	//
	// }

	/*
	 * Method for enter shift4 secure hash secret
	 */
	public PaymentGatewayPage invalidSecureHashSecret_SHIFT4() {
		secureHashSecret.sendKeys(ExcelData.getCellData("Shift4", "SecureHashSecret", 5));
		return null;
	}

}