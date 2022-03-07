package com.be.pom;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import Utility.ExcelData;
import base.Helper;
import pages.AbstractBasePage;
/*
 * Pom class for JCC Bookings
 * @author Rudraksh Aggarwal
 */
public class JCCBookingsPage extends AbstractBasePage {
	
	public static WebDriver driver;
	
	@FindBy(id = "search_arrival_date")
	WebElement calender;
	@FindBy(xpath = "//td[@class='active day']")
	WebElement checkInDate;
	@FindBy(id = "check-availability-btn")
	WebElement avalilibiltyButton;
	@FindBy(xpath = "(//button[@type='submit'])[last()]")
	WebElement bookNow;
	@FindBy(name = "booking[first_name]")
	WebElement firstName;
	@FindBy(name = "booking[last_name]")
	WebElement lastName;
	@FindBy(id = "booking_email")
	WebElement email;
	@FindBy(xpath = "//button[@aria-label='confirm reservation']")
	WebElement confirmDetails;
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
	@FindBy(id = "booking_country")
	WebElement country;
	@FindBy(id = "booking_street_address1")
	WebElement add1;
	@FindBy(name = "booking[city]")
	WebElement city;
	@FindBy(name = "state")
	WebElement state;
	@FindBy(name = "booking[zip_code]")
	WebElement zipCode;
	@FindBy(id = "booking_phone_number")
	WebElement phNum;
	@FindBy(xpath = "//input[@ng-model='booking.accepted']")
	WebElement termsConditions;
	@FindBy(xpath = "//input[@name='commit']")
	WebElement completeReservation;
	@FindBy(id = "summary_reservation_confirmation_code")
	WebElement confirmCodes;
	@FindBy(xpath = "(//strong[text()='BAR'])[1]")
	WebElement ratePLanBar;
	@FindBy(xpath = "//div[@class='error-message']")
	WebElement errorMessageJCC;
	
	public JCCBookingsPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	public String UrlTilte() {
		return driver.getTitle();
	}
	
	/*
	 * Method to select dates booking engine
	 * 
	 */
	public JCCBookingsPage selectDate() {
		Helper.explicit(calender, 30);
		calender.click();
		Helper.implict(2);
		checkInDate.click();
		return null;
	}
	/*
	 * Method to click Availibility Button
	 * 
	 */
	public JCCBookingsPage clickAvailibilityButton() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		avalilibiltyButton.click();
		Helper.implict(2);
		return null;
	}
	/*
	 * Method to click Book Now Button
	 * 
	 */
	public JCCBookingsPage clickBookNowButton() {
		Helper.explicit(bookNow, 50);
		bookNow.click();
		Helper.implict(4);
		return null;
	}
	/*
	 * Method to input Guest Details
	 * 
	 */
	public JCCBookingsPage inputGuestDetails() {
		firstName.clear();
		firstName.sendKeys(ExcelData.getCellData("JCCBookings", "FirstName", 2));
		Helper.implict(1);
		lastName.clear();
		lastName.sendKeys(ExcelData.getCellData("JCCBookings", "LastName", 2));
		Helper.implict(1);
		email.clear();
		email.sendKeys(ExcelData.getCellData("JCCBookings", "Email", 2));
		Helper.implict(1);
		return null;
	}
	/*
	 * Method to select BAR Rate Plan
	 * 
	 */
	public JCCBookingsPage selectRatePlanBar() {
		ratePLanBar.click();
		Helper.implict(1);
		return null;
	}
	/*
	 * Method to click confirm Details
	 * 
	 */
	public JCCBookingsPage clickconfirmDetails() {
		confirmDetails.click();
		Helper.implict(4);
		return null;
	}
	/*
	 * Method to input Card Details TC01
	 * 
	 */
	public JCCBookingsPage inputCardDetailsTC01() {
		cardName.clear();
		cardName.sendKeys(ExcelData.getCellData("JCCBookings", "CardName", 2));
		cardNumber.sendKeys(ExcelData.getCellData("JCCBookings", "CardNumber1", 2));
		cardNumber.sendKeys(ExcelData.getCellData("JCCBookings", "CardNumber2", 2));
		cardNumber.sendKeys(ExcelData.getCellData("JCCBookings", "CardNumber3", 2));
		cardNumber.sendKeys(ExcelData.getCellData("JCCBookings", "CardNumber4", 2));
		Select dropdown = new Select(expiryMonthDropdown);
		dropdown.selectByVisibleText("12");
		Helper.implict(1);
		Select d = new Select(expiryYearDropdown);
		d.selectByVisibleText("2028");
		Helper.implict(1);
		secCode.sendKeys(ExcelData.getCellData("JCCBookings", "SecurityCode", 2));
		Helper.implict(1);
		return null;
	}
	/*
	 * Method to input Card Details TC02
	 * 
	 */
	public JCCBookingsPage inputCardDetailsTC02() {
		cardName.sendKeys(ExcelData.getCellData("JCCBookings", "CardName", 2));
		cardNumber.sendKeys(ExcelData.getCellData("JCCBookings", "CardNumber1", 3));
		cardNumber.sendKeys(ExcelData.getCellData("JCCBookings", "CardNumber2", 3));
		cardNumber.sendKeys(ExcelData.getCellData("JCCBookings", "CardNumber3", 3));
		cardNumber.sendKeys(ExcelData.getCellData("JCCBookings", "CardNumber4", 3));
		Select dropdown = new Select(expiryMonthDropdown);
		dropdown.selectByVisibleText("12");
		Helper.implict(1);
		Select d = new Select(expiryYearDropdown);
		d.selectByVisibleText("2028");
		Helper.implict(1);
		secCode.sendKeys(ExcelData.getCellData("JCCBookings", "SecurityCode", 2));
		Helper.implict(1);
		return null;
	}
	/*
	 * Method to input Billing Address
	 * 
	 */
	public JCCBookingsPage inputBillingAddress() {
		Select dropdown = new Select(country);
		dropdown.selectByVisibleText("India");
		Helper.implict(1);
		add1.sendKeys(ExcelData.getCellData("JCCBookings", "Addressline1", 2));
		Helper.implict(1);
		city.sendKeys(ExcelData.getCellData("JCCBookings", "City", 2));
		Helper.implict(1);
		Select d = new Select(state);
		d.selectByVisibleText("Delhi");
		Helper.implict(1);
		zipCode.clear();
		zipCode.sendKeys(ExcelData.getCellData("JCCBookings", "Zipcode", 2));
		Helper.implict(1);
		return null;
	}
	/*
	 * Method to input additional ContactInfo
	 * 
	 */
	public JCCBookingsPage inputadditionalContactInfo() {
		phNum.clear();
		phNum.sendKeys(ExcelData.getCellData("JCCBookings", "PhoneNumber", 2));
		Helper.implict(1);
		return null;
	}
	/*
	 * Method to select Terms And Conditon Checkbox
	 * 
	 */
	public JCCBookingsPage selectTermsAndConditonCheckbox() {
		termsConditions.click();
		Helper.implict(1);
		return null;
	}
	/*
	 * Method to click Complete Reservation
	 * 
	 */
	public JCCBookingsPage clickCompleteReservation() {
		completeReservation.click();
		Helper.implict(5);
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
	public boolean verificationTC04() {
		if (errorMessageJCC.isDisplayed()) {
			String error = errorMessageJCC.getText();
			System.out.println(error);
			return true;
		}
		else {
			System.out.println("Booking is Done");
			return false;
		}
	}
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
	/*
	 * Method for verificationTC05
	 * 
	 */
	public boolean verificationTC06() {
		if (errorMessageJCC.isDisplayed()) {
			String error = errorMessageJCC.getText();
			System.out.println(error);
			return true;
		}
		else {
			System.out.println("Booking is Done");
			return false;
		}
	}
}
