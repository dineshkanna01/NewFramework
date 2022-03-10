package com.mb.pom;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.admin.pom.AboutThePropertyPages;

import Utility.ExcelData;
import base.Helper;
import base.TestBase;

public class CancelWebBookingFromMobilePages extends TestBase {
	public WebDriver driver;

	public CancelWebBookingFromMobilePages(WebDriver driver) {
		super();
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "(//input[@id='search_arrival_date'])")
	WebElement arrivalDate;

	@FindBy(xpath = "(//input[@id='search_departure_date'])")
	WebElement departureDate;

	@FindBy(xpath = "(//span[@class='input-text ng-binding'])[1]")
	WebElement rooms;

	@FindBy(xpath = "(//span[@class='input-text ng-binding'])[2]")
	WebElement guest;

	@FindBy(xpath = "(//div[@class='search-form-item search-form-submit'])")
	WebElement checkAvailability;

	@FindBy(xpath = "(//button[@class='room-book-now-button'])")
	WebElement bookNow;

	@FindBy(xpath = "//input[@name='booking[first_name]']")
	WebElement firstName;

	@FindBy(xpath = "//input[@name='booking[last_name]']")
	WebElement lastName;

	@FindBy(xpath = "//input[@name='booking[email]']")
	WebElement email;

	@FindBy(xpath = "(//input[@type='radio'])[6]")
	WebElement wantTransportRequired;

	@FindBy(xpath = "(//input[@type='radio'])[4]")
	WebElement wantTransportRequired4;

	@FindBy(xpath = "(//input[@type='radio'])[6]")
	WebElement cabPickUpYes4;

	@FindBy(xpath = "(//input[@type='radio'])[7]")
	WebElement wantTransportNotRequired;

	@FindBy(xpath = "(//input[@type='radio'])[8]")
	WebElement cabPickUpYes;

	@FindBy(xpath = "(//input[@type='radio'])[9]")
	WebElement cabPickUpNo;

	@FindBy(xpath = "(//button[@aria-label='confirm reservation'])")
	WebElement confirmDetails;

	@FindBy(xpath = "(//input[@id='card_holder_name'])")
	WebElement cardHolderName;

	@FindBy(xpath = "(//input[@id='card_number'])")
	WebElement cardNumber;

	@FindBy(xpath = "(//select[@id='expiration_date_month'])")
	WebElement expiryMonth;

	@FindBy(xpath = "(//option[@value='01'])")
	WebElement expiryMonthJan;

	@FindBy(xpath = "(//option[@value='12'])")
	WebElement expiryMonthDec;

	@FindBy(xpath = "(//select[@id='expiration_date_year'])")
	WebElement expiryMonthYear;

	@FindBy(xpath = "(//option[@value='2023'])")
	WebElement expiryMonthYear2023;

	@FindBy(xpath = "(//input[@id='security_code'])")
	WebElement securityCode;

	@FindBy(xpath = "(//select[@id='booking_country'])")
	WebElement selectCountry;

	@FindBy(xpath = "(//option[@label='India'])")
	WebElement selectCountryInd;

	@FindBy(xpath = "(//input[@placeholder='Enter a location'])")
	WebElement enterLocation;

	@FindBy(xpath = "(//input[@aria-label='Please enter city'])")
	WebElement enterCity;

	@FindBy(xpath = "(//select[@aria-label='Please select a state'])")
	WebElement enterState;

	@FindBy(xpath = "(//option[@label='Delhi'])")
	WebElement enterStateDelhi;

	@FindBy(xpath = "(//input[@name='booking[zip_code]'])")
	WebElement zipCode;

	@FindBy(xpath = "(//span[@class='h3ToggleText'])")
	WebElement otherOffers;

	@FindBy(xpath = "(//span[@class='check-radio'])[2]")
	WebElement barRatePlan;

	@FindBy(xpath = "(//span[@class='check-radio'])[2]")
	WebElement fixedSummerRate;

	@FindBy(xpath = "(//span[@class='check-radio'])[3]")
	WebElement hotelTraderRatePlan;

	@FindBy(xpath = "(//input[@name='booking[phone_number]'])")
	WebElement phoneNumber;

	@FindBy(xpath = "(//input[@aria-label='I accept the Terms & Conditions'])")
	WebElement acceptTerm;

	@FindBy(xpath = "//a[text()=\"Got it!\"]")
	WebElement gotIt;

	@FindBy(xpath = "(//input[@value='Complete reservation'])")
	WebElement completeReservation;

	@FindBy(xpath = "//th[@id=\"summary_reservation_confirmation_code\"]/strong")
	WebElement confirmcode;

	@FindBy(xpath = "//*[@id=\"wrapper\"]/section/div[2]/div[3]/table/tbody/tr[1]/td[1]/text()[2]")
	WebElement confirmMailId;

	@FindBy(id = "search_arrival_date")
	WebElement calender;

	@FindBy(xpath = "//td[@class='active day']")
	WebElement checkInDate;

	public String UrlTilte() {
		return driver.getTitle();

	}

	/*
	 * Method to select dates booking engine
	 *
	 */
	public CancelWebBookingFromMobilePages selectDate() {
		Helper.explicit(calender, 30);
		calender.click();
		Helper.implict(2);
		checkInDate.click();
		return null;
	}/*
		 * Method to do a reservation in web BE
		 *
		 */

	public CancelWebBookingFromMobilePages webBEReservation() {
		checkAvailability.click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		bookNow.click();
		firstName.sendKeys(ExcelData.getCellData("MBTC7", "FirstName", 2));
		lastName.sendKeys(ExcelData.getCellData("MBTC7", "LastName", 2));
		email.sendKeys(ExcelData.getCellData("MBTC7", "email", 2));
		confirmDetails.click();
		cardHolderName.sendKeys(ExcelData.getCellData("MBTC7", "CardHN", 2));
		cardNumber.sendKeys(ExcelData.getCellData("MBTC7", "CardN", 2));
		cardNumber.sendKeys(ExcelData.getCellData("MBTC7", "CardN", 2));
		cardNumber.sendKeys(ExcelData.getCellData("MBTC7", "CardN", 2));
		cardNumber.sendKeys(ExcelData.getCellData("MBTC7", "CardN", 2));
		Helper.implict(3);
		expiryMonth.click();
		expiryMonthJan.click();
		expiryMonthYear.click();
		expiryMonthYear2023.click();
		securityCode.sendKeys(ExcelData.getCellData("MBTC7", "SCode", 2));
		selectCountry.click();
		selectCountryInd.click();
		enterLocation.sendKeys(ExcelData.getCellData("MBTC7", "Location", 2));
		enterCity.sendKeys(ExcelData.getCellData("MBTC7", "City", 2));
		enterState.click();
		enterStateDelhi.click();
		zipCode.sendKeys(ExcelData.getCellData("MBTC7", "ZipCode", 2));
		phoneNumber.sendKeys(ExcelData.getCellData("MBTC7", "PhoneN", 2));
		acceptTerm.click();
		completeReservation.click();
		return null;
	}

	/*
	 * Method to input details in mob lookup
	 */
	public CancelWebBookingFromMobilePages cancelinMobWebBEReservation() {
		Helper.clickEle("//em[@class='header_toggle_lines']");
		Helper.clickEle("//a[text()='My reservations']");
		Helper.sleep(5000);
		// Helper.eleXpath("//input[@id='confirmation_code']",
		// ExcelData.getCellData("LoginPageData", "WebConfirmCode", 2));
		Helper.eleXpath("//input[@id='email']", ExcelData.getCellData("LoginPageData", "WebConfirmMailId", 2));
		Helper.eleXpath("//input[@id='confirmation_code']",
				ExcelData.getCellData("LoginPageData", "WebConfirmCode", 2));
		Helper.clickEle("//button[text()='Lookup']");
		return null;
	}

	/*
	 * Method to cancel reservation
	 */
	public CancelWebBookingFromMobilePages clickOnCancelinMobWebBEReservation() {
		Helper.sleep(5000);
		Helper.clickEle("//a[contains(text(),'Got it!')]");
		Helper.clickEle("//button[text()='Cancel reservation']");
		Helper.clickEle("//span[text()='Yes']");
		return null;
	}

	/*
	 * Method to get cancellation code
	 */
	public boolean verifyMobileCancellationCode() {
		WebElement cancellation = Helper.abcd("(//div[@class='content']/p)[2]");
		if (cancellation.isDisplayed()) {
			String code = cancellation.getText();
			System.out.println("Cancellation code is: " + code);
			return true;
		} else {
			System.out.println("NA");
			return false;
		}
	}

	/*
	 * Method to scroll down
	 * 
	 */
	public CancelWebBookingFromMobilePages scrollDownTen() {
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		js.executeScript("window.scrollBy(0,1000)");
		return null;
	}

/*
	 * Method to get Confirmation code
	 */
	public AboutThePropertyPages getConfirmationNo() {
		String b = confirmcode.getText();
		System.out.println("Confirmation code" + b);
		ExcelData.write_CellData("LoginPageData", 1, 9, b);
		return null;
	}

	/*
	 * Method to get Confirmation mail id
	 */
	public AboutThePropertyPages getConfirmationMailId() {
		String b = confirmMailId.getText();
		System.out.println("confirmMailId" + b);
		ExcelData.write_CellData("LoginPageData", 1, 8, b);
		return null;
	}
}
