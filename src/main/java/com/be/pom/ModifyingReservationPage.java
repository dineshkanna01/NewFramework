package com.be.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import Utility.ExcelData;
import base.Helper;
import base.TestBase;

/*
 * Pom class for Modifying Reservation Page
 * @author Sudhakar Mourya
 */
public class ModifyingReservationPage extends TestBase {

	@FindBy(xpath = "//th[@id=\"summary_reservation_confirmation_code\"]/strong")
	WebElement confirmCodes;

	@FindBy(xpath = "//td[@headers='summary_reservation_guest_details']")
	WebElement guestDetails;

	@FindBy(name = "booking[first_name]")
	WebElement firstName;

	@FindBy(name = "booking[last_name]")
	WebElement lastName;

	@FindBy(id = "booking_email")
	WebElement email;

	@FindBy(id = "card_number")
	WebElement cardNumber;

	@FindBy(id = "expiration_date_month")
	WebElement expiryMonthDropdown;

	@FindBy(id = "expiration_date_year")
	WebElement expiryYearDropdown;

	@FindBy(id = "security_code")
	WebElement secCode;

	@FindBy(xpath = "//a[text()='My bookings']")
	WebElement myBookings;

	@FindBy(xpath = "//input[@name='confirmation_code']")
	WebElement ccField;

	@FindBy(xpath = "(//input[@name='email'])[1]")
	WebElement Email;

	@FindBy(xpath = "(//*[@type='submit'])[1]")
	WebElement lookUp;

	@FindBy(xpath = "//div[@class='summary-title']/h2")
	WebElement summaryTittle;

	@FindBy(xpath = "//div[text()='No reservations found matching this confirmation code or email.']")
	WebElement errorMsg;

	@FindBy(xpath = "//div[text()='Please enter both Confirmation Code and  Email.']")
	WebElement onlyEmailIdErrorText;
	
	public ModifyingReservationPage(WebDriver driver) {
		super();
		PageFactory.initElements(driver, this);
	}

	public String UrlTilte() {
		return driver.getTitle();
	}

	/*
	 * Method to get Confirmation code
	 */
	public ModifyingReservationPage getConfirmationNo() {
		String b=confirmCodes.getText();
		System.out.println("Confirmation code"+b);
		ExcelData.write_CellData("LoginPageData",1,14,b);
		return null;
	}

	/*
	 * Method to get guest details before
	 */
	public ModifyingReservationPage guestDetailBefore() {
		String c=guestDetails.getText();
		System.out.println("Guest Detail : "+c);
		ExcelData.write_CellData("LoginPageData",1,15,c);
		return null;
	}

	/*
	 * Method to get guest details after modify
	 */
	public ModifyingReservationPage guestDetailAfter() {
		String b=guestDetails.getText();
		System.out.println("Guest Detail : "+b);
		ExcelData.write_CellData("LoginPageData",1,16,b);
		return null;
	}

	/*
	 * Method to verify Booking Modify
	 */
	public boolean verifyBookingModify() {
		String a= ExcelData.getCellData("LoginPageData","GuestDetailBefore",2);
		String b= ExcelData.getCellData("LoginPageData","GuestDetailAfter",2);
		if(a.equalsIgnoreCase(b)) {
			System.out.println("Booking is not modified");
			return false;
		}else {
			System.out.println("Booking is modified");
			return true;
		}
	}

	/*
	 * Method to input  modify Guest Details
	 */
	public CalendarViewBookingsPage inputGuestDetailsModify() {
		firstName.clear();
		firstName.sendKeys(ExcelData.getCellData("ModifyingReservation", "FirstName", 2));
		Helper.implict(1);
		lastName.clear();
		lastName.sendKeys(ExcelData.getCellData("ModifyingReservation", "LastName", 2));
		Helper.implict(1);
		email.clear();
		email.sendKeys(ExcelData.getCellData("ModifyingReservation", "Email", 2));
		Helper.implict(1);
		return null;
	}

	/*
	 * Method to input modify Card Details 
	 * 
	 */
	public CalendarViewBookingsPage inputCardDetails() {
		cardNumber.sendKeys(ExcelData.getCellData("ModifyingReservation", "CardNumber1", 2));
		cardNumber.sendKeys(ExcelData.getCellData("ModifyingReservation", "CardNumber2", 2));
		cardNumber.sendKeys(ExcelData.getCellData("ModifyingReservation", "CardNumber3", 2));
		cardNumber.sendKeys(ExcelData.getCellData("ModifyingReservation", "CardNumber4", 2));
		Select dropdown = new Select(expiryMonthDropdown);
		dropdown.selectByVisibleText("12");
		Helper.implict(1);
		Select d = new Select(expiryYearDropdown);
		d.selectByVisibleText("2028");
		Helper.implict(1);
		secCode.sendKeys(ExcelData.getCellData("ModifyingReservation", "SecurityCode", 2));
		Helper.implict(1);
		return null;
	}


	/*
	 * Method to input TC-02
	 */
	public ModifyingReservationPage inputTc_02() {
		Helper.explicit(myBookings, 50);
		myBookings.click();
		Email.clear();
		Email.sendKeys(ExcelData.getCellData("ModifyingReservation", "Email", 2));
		Helper.implict(1);
		ccField.clear();
		ccField.sendKeys(ExcelData.getCellData("LoginPageData", "ConfirmCode", 2));
		Helper.sleep(6000);
		Helper.implict(1);
		lookUp.click();
		Helper.sleep(7000);
		return null;
	}

	/*
	 * Method to verify TC-02
	 */
	public boolean verifyTc_02 () {
		if(summaryTittle.isDisplayed()) {
			String e=summaryTittle.getText();
			System.out.println("Booking is modified, success msg is :"+e);
			return true;
		}
		else {
			System.out.println("Booking is not modified");
			return false;
		}
	}

	/*
	 * Method to input TC-03
	 */
	public ModifyingReservationPage inputTc_03() {
		String WrongCode="CPI00000099";
		Helper.explicit(myBookings, 50);
		myBookings.click();
		Email.clear();
		Email.sendKeys(ExcelData.getCellData("ModifyingReservation", "Email", 2));
		Helper.implict(1);
		ccField.clear();
		ccField.sendKeys(WrongCode);
		Helper.implict(1);
		lookUp.click();
		Helper.sleep(7000);
		return null;
	}

	/*
	 * Method to verify TC-03
	 */
	public boolean verifyTc_03 () {
		if(errorMsg.isDisplayed()) {
			String e=errorMsg.getText();
			System.out.println("Receive error msg :"+e);
			return true;
		}
		else {
			System.out.println("Test case is failed");
			return false;
		}
	}

	/*
	 * Method to input TC-03
	 */
	public ModifyingReservationPage inputTc_04() {
		Helper.explicit(myBookings, 50);
		myBookings.click();
		Email.clear();
		Email.sendKeys(ExcelData.getCellData("ModifyingReservation", "Email", 2));
		Helper.implict(1);
		ccField.clear();
		Helper.implict(1);
		lookUp.click();
		Helper.sleep(7000);
		return null;
	}

	/*
	 * Method to verify TC-04
	 */
	public boolean verifyTc_04 () {
		if(onlyEmailIdErrorText.isDisplayed()) {
			String e=onlyEmailIdErrorText.getText();
			System.out.println("Receive error msg :"+e);
			return true;
		}
		else {
			System.out.println("Test case is failed");
			return false;
		}
	}
}
