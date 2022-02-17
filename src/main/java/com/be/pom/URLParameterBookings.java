package com.be.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.admin.pom.AboutThePropertyPages;

import base.Helper;
import pages.AbstractBasePage;
import Utility.ExcelData;

public class URLParameterBookings extends AbstractBasePage{

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
	WebElement selectCountry ;
	
	@FindBy(xpath = "(//option[@label='India'])")
	WebElement selectCountryInd ;
	
	@FindBy(xpath = "(//input[@placeholder='Enter a location'])")
	WebElement enterLocation ;
	
	@FindBy(xpath = "(//input[@aria-label='Please enter city'])")
	WebElement enterCity ;
	
	@FindBy(xpath = "(//select[@aria-label='Please select a state'])")
	WebElement enterState ;
	
	@FindBy(xpath = "(//option[@label='Delhi'])")
	WebElement enterStateDelhi ;
	
	@FindBy(xpath = "(//input[@name='booking[zip_code]'])")
	WebElement zipCode ;
	
	@FindBy(xpath = "(//span[@class='h3ToggleText'])")
	WebElement otherOffers ;
	
	@FindBy(xpath = "(//span[@class='check-radio'])[2]")
	WebElement barRatePlan ;
	
	@FindBy(xpath = "(//span[@class='check-radio'])[2]")
	WebElement fixedSummerRate ;
	
	@FindBy(xpath = "(//span[@class='check-radio'])[3]")
	WebElement hotelTraderRatePlan ;
	
	
	
	
	
	@FindBy(xpath = "(//input[@name='booking[phone_number]'])")
	WebElement  phoneNumber;
	
	@FindBy(xpath = "(//input[@aria-label='I accept the Terms & Conditions'])")
	WebElement  acceptTerm;
	
	@FindBy(xpath ="//a[text()=\"Got it!\"]")
	WebElement gotIt;
	
	@FindBy(xpath = "(//input[@value='Complete reservation'])")
	WebElement completeReservation;
	
	@FindBy(xpath = "//*[contains(@class,'changeReservation')]")
	WebElement changeReservation;
	
	@FindBy(xpath = "//*[contains(@class,'cancelReservation')]")
	WebElement cancelReservation;
	
	@FindBy(xpath = "//*[contains(@class,'bookAnotherRoomLink ')]")
	WebElement bookAnotherRoom;
	
	@FindBy(xpath = "(//span[@class='translation_missing'])[1]")
	WebElement changeReservationFeeYes;
	
	@FindBy(xpath = "//*[@headers='summary_reservation_offer']")
	WebElement rateplanForModification;
	
	@FindBy(xpath = "//h2[text()='Thank you for your reservation']")
	WebElement bookingConfirmation;
	
	@FindBy(xpath = "//h3[text()='YOUR RESERVATION HAS BEEN CANCELED']")
	WebElement bookingCancellation;
	
	
	
	
	
	
	public URLParameterBookings(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	public String UrlTilte() {
		return driver.getTitle();
	}

	

	
	/*
	*Method to click on booknow
	*
	*/

	public URLParameterBookings clickBookNow()  {
		Helper.implict(3);
		bookNow.click();
		Helper.implict(3);
		return null;
	}
	
	/*
	*Method to click on confirmDetails
	*
	*/

	public URLParameterBookings clickConfirmDetails()  {
		Helper.implict(3);
		confirmDetails.click();
		Helper.implict(3);
		return null;
	}
	
	/*
	*Method to click on completeReservation
	*
	*/

	public URLParameterBookings clickcompleteReservation()  {
		Helper.implict(3);
		completeReservation.click();
		Helper.implict(3);
		return null;
	}
	
	
	/*
	*Method to click on changeReservation
	*
	*/

	public URLParameterBookings clickOnChangeReservation()  {
		Helper.implict(3);
		changeReservation.click();
		Helper.implict(3);
		changeReservationFeeYes.click();
		return null;
	}
	
	/*
	*Method to click on bookAnotherRoom
	*
	*/

	public URLParameterBookings clickOnbookAnotherRoom()  {
		Helper.implict(3);
		bookAnotherRoom.click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	/*
	*Method to click on cancelReservation
	*
	*/

	public URLParameterBookings clickOncancelReservation()  {
		Helper.implict(3);
		cancelReservation.click();
		Helper.implict(3);
		changeReservationFeeYes.click();
		return null;
	}
	
	
	
	
	/*
	* Method to make a reservation in URL Parameter booking
	* 
	*/

	public AboutThePropertyPages makeAReservationInURLParameterbooking()  {
		
		arrivalDate.sendKeys(ExcelData.getCellData("URLPB1", "ArrivalDate", 2));
		Helper.implict(8);
		departureDate.clear();
		departureDate.sendKeys(ExcelData.getCellData("URLPB1", "DepartureDate", 2));
		checkAvailability.click();
//		try {
//			Thread.sleep(3000);
//		} catch (InterruptedException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
//		checkAvailability.click();
		Helper.implict(6);
		bookNow.click();
		firstName.sendKeys(ExcelData.getCellData("URLPB1", "FirstName", 2));
		lastName.sendKeys(ExcelData.getCellData("URLPB1", "LastName", 2));
		email.sendKeys(ExcelData.getCellData("URLPB1", "email", 2));
		wantTransportRequired.click();
		cabPickUpYes.click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		confirmDetails.click();
		cardHolderName.sendKeys(ExcelData.getCellData("URLPB1", "CardHN", 2));
		cardNumber.sendKeys(ExcelData.getCellData("URLPB1", "CardN", 2));
		cardNumber.sendKeys(ExcelData.getCellData("URLPB1", "CardN", 2));
		cardNumber.sendKeys(ExcelData.getCellData("URLPB1", "CardN", 2));
		cardNumber.sendKeys(ExcelData.getCellData("URLPB1", "CardN", 2));
		Helper.implict(3);
		expiryMonth.click();
		expiryMonthJan.click();
		expiryMonthYear.click();
		expiryMonthYear2023.click();
		securityCode.sendKeys(ExcelData.getCellData("URLPB1", "SCode", 2));
		selectCountry.click();
		selectCountryInd.click();
		enterLocation.sendKeys(ExcelData.getCellData("URLPB1", "Location", 2));
		enterCity.sendKeys(ExcelData.getCellData("URLPB1", "City", 2));
		enterState.click();
		enterStateDelhi.click();
		zipCode.sendKeys(ExcelData.getCellData("URLPB1", "ZipCode", 2));
		phoneNumber.sendKeys(ExcelData.getCellData("URLPB1", "PhoneN", 2));
		gotIt.click();
		acceptTerm.click();
		completeReservation.click();
		
		
		return null;
	}
	
	
	/*
	* Method to verify Created Reservation
	*  returns boolean value
	* 
	*/
	public boolean verifyReservationSuccessful()  {

		if (bookingConfirmation.isDisplayed()) {
			System.out.println("Reservation Successful");
			return true;
		} else {
			System.out.println("Reservation Unsuccessful");
			return false;

		}
	}

	
public AboutThePropertyPages makeAReservationToModifyInURLParameterbooking()  {
		
		arrivalDate.sendKeys(ExcelData.getCellData("URLPB2", "ArrivalDate", 2));
		Helper.implict(8);
		departureDate.clear();
		departureDate.sendKeys(ExcelData.getCellData("URLPB2", "DepartureDate", 2));
		checkAvailability.click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		bookNow.click();
		firstName.sendKeys(ExcelData.getCellData("URLPB2", "FirstName", 2));
		lastName.sendKeys(ExcelData.getCellData("URLPB2", "LastName", 2));
		email.sendKeys(ExcelData.getCellData("URLPB2", "email", 2));
		otherOffers.click();
		hotelTraderRatePlan.click();
		wantTransportRequired.click();
		cabPickUpYes.click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		confirmDetails.click();
		cardHolderName.sendKeys(ExcelData.getCellData("URLPB2", "CardHN", 2));
		cardNumber.sendKeys(ExcelData.getCellData("URLPB2", "CardN", 2));
		cardNumber.sendKeys(ExcelData.getCellData("URLPB2", "CardN", 2));
		cardNumber.sendKeys(ExcelData.getCellData("URLPB2", "CardN", 2));
		cardNumber.sendKeys(ExcelData.getCellData("URLPB2", "CardN", 2));
		Helper.implict(3);
		expiryMonth.click();
		expiryMonthJan.click();
		expiryMonthYear.click();
		expiryMonthYear2023.click();
		securityCode.sendKeys(ExcelData.getCellData("URLPB2", "SCode", 2));
		selectCountry.click();
		selectCountryInd.click();
		enterLocation.sendKeys(ExcelData.getCellData("URLPB2", "Location", 2));
		enterCity.sendKeys(ExcelData.getCellData("URLPB2", "City", 2));
		enterState.click();
		enterStateDelhi.click();
		zipCode.sendKeys(ExcelData.getCellData("URLPB2", "ZipCode", 2));
		phoneNumber.sendKeys(ExcelData.getCellData("URLPB2", "PhoneN", 2));
		acceptTerm.click();
		completeReservation.click();
		
		
		return null;
	}
	

/*
* Method to verify  changed reservation
*  returns boolean value
* 
*/

public boolean verifyChangedReservation()  {
	String FirstRateplan = rateplanForModification.getText();
	System.out.println(FirstRateplan + " FirstRateplan");
	String expText = (ExcelData.getCellData("URLPB2", "RatePlan", 2));
	System.out.println(expText + " " + "ExpectedText");
	if (FirstRateplan.equalsIgnoreCase(expText)) {
		System.out.println(" rateplan not changed");
		return true;
	} else {
		System.out.println(" rateplan changed");
		return false;

	}
}
public AboutThePropertyPages changeAReservationToModifyInURLParameterbooking()  {
	
	bookNow.click();
	fixedSummerRate.click();
	wantTransportRequired.click();
	cabPickUpYes.click();
	try {
		Thread.sleep(3000);
	} catch (InterruptedException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
	confirmDetails.click();
	cardNumber.sendKeys(ExcelData.getCellData("URLPB2", "CardN", 2));
	cardNumber.sendKeys(ExcelData.getCellData("URLPB2", "CardN", 2));
	cardNumber.sendKeys(ExcelData.getCellData("URLPB2", "CardN", 2));
	cardNumber.sendKeys(ExcelData.getCellData("URLPB2", "CardN", 2));
	Helper.implict(3);
	expiryMonth.click();
	expiryMonthJan.click();
	expiryMonthYear.click();
	expiryMonthYear2023.click();
	securityCode.sendKeys(ExcelData.getCellData("URLPB2", "SCode", 2));
	acceptTerm.click();
	completeReservation.click();
	try {
		Thread.sleep(3000);
	} catch (InterruptedException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
	return null;
	
}
public AboutThePropertyPages makeAReservationToCancelInURLParameterbooking()  {
	
	arrivalDate.sendKeys(ExcelData.getCellData("URLPB3", "ArrivalDate", 2));
	Helper.implict(8);
	departureDate.clear();
	departureDate.sendKeys(ExcelData.getCellData("URLPB3", "DepartureDate", 2));
	checkAvailability.click();
	try {
		Thread.sleep(3000);
	} catch (InterruptedException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
	bookNow.click();
	firstName.sendKeys(ExcelData.getCellData("URLPB3", "FirstName", 2));
	lastName.sendKeys(ExcelData.getCellData("URLPB3", "LastName", 2));
	email.sendKeys(ExcelData.getCellData("URLPB3", "email", 2));
	wantTransportRequired.click();
	cabPickUpYes.click();
	try {
		Thread.sleep(3000);
	} catch (InterruptedException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
	confirmDetails.click();
	cardHolderName.sendKeys(ExcelData.getCellData("URLPB3", "CardHN", 2));
	cardNumber.sendKeys(ExcelData.getCellData("URLPB3", "CardN", 2));
	cardNumber.sendKeys(ExcelData.getCellData("URLPB3", "CardN", 2));
	cardNumber.sendKeys(ExcelData.getCellData("URLPB3", "CardN", 2));
	cardNumber.sendKeys(ExcelData.getCellData("URLPB3", "CardN", 2));
	Helper.implict(3);
	expiryMonth.click();
	expiryMonthJan.click();
	expiryMonthYear.click();
	expiryMonthYear2023.click();
	securityCode.sendKeys(ExcelData.getCellData("URLPB3", "SCode", 2));
	selectCountry.click();
	selectCountryInd.click();
	enterLocation.sendKeys(ExcelData.getCellData("URLPB3", "Location", 2));
	enterCity.sendKeys(ExcelData.getCellData("URLPB3", "City", 2));
	enterState.click();
	enterStateDelhi.click();
	zipCode.sendKeys(ExcelData.getCellData("URLPB3", "ZipCode", 2));
	phoneNumber.sendKeys(ExcelData.getCellData("URLPB3", "PhoneN", 2));
	acceptTerm.click();
	completeReservation.click();
	try {
		Thread.sleep(5000);
	} catch (InterruptedException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
	
	return null;
}
/*
* Method to verify cancel Reservation
*  returns boolean value
* 
*/
public boolean verifyReservationCancelationSuccessful()  {

	if (bookingCancellation.isDisplayed()) {
		System.out.println("Reservation Cancelation Successful");
		return true;
	} else {
		System.out.println("Reservation Cancelation Unsuccessful");
		return false;

	}
}

public AboutThePropertyPages makeAReservationToBookAnotherRoomInURLParameterbooking()  {
	
	arrivalDate.sendKeys(ExcelData.getCellData("URLPB4", "ArrivalDate", 2));
	Helper.implict(8);
	departureDate.clear();
	departureDate.sendKeys(ExcelData.getCellData("URLPB4", "DepartureDate", 2));
	checkAvailability.click();
	try {
		Thread.sleep(3000);
	} catch (InterruptedException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
	bookNow.click();
	firstName.sendKeys(ExcelData.getCellData("URLPB4", "FirstName", 2));
	lastName.sendKeys(ExcelData.getCellData("URLPB4", "LastName", 2));
	email.sendKeys(ExcelData.getCellData("URLPB4", "email", 2));
	wantTransportRequired.click();
	cabPickUpYes.click();
	try {
		Thread.sleep(3000);
	} catch (InterruptedException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
	confirmDetails.click();
	cardHolderName.sendKeys(ExcelData.getCellData("URLPB4", "CardHN", 2));
	cardNumber.sendKeys(ExcelData.getCellData("URLPB4", "CardN", 2));
	cardNumber.sendKeys(ExcelData.getCellData("URLPB4", "CardN", 2));
	cardNumber.sendKeys(ExcelData.getCellData("URLPB4", "CardN", 2));
	cardNumber.sendKeys(ExcelData.getCellData("URLPB4", "CardN", 2));
	Helper.implict(3);
	expiryMonth.click();
	expiryMonthJan.click();
	expiryMonthYear.click();
	expiryMonthYear2023.click();
	securityCode.sendKeys(ExcelData.getCellData("URLPB4", "SCode", 2));
	selectCountry.click();
	selectCountryInd.click();
	enterLocation.sendKeys(ExcelData.getCellData("URLPB4", "Location", 2));
	enterCity.sendKeys(ExcelData.getCellData("URLPB4", "City", 2));
	enterState.click();
	enterStateDelhi.click();
	zipCode.sendKeys(ExcelData.getCellData("URLPB4", "ZipCode", 2));
	phoneNumber.sendKeys(ExcelData.getCellData("URLPB4", "PhoneN", 2));
	acceptTerm.click();
	completeReservation.click();
	try {
		Thread.sleep(5000);
	} catch (InterruptedException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
	
	return null;
}
public AboutThePropertyPages BookAnotherRoomFromConfirmationPageInURLParameterbooking()  {
	
	
	bookNow.click();
	firstName.sendKeys(ExcelData.getCellData("URLPB4", "FirstName", 2));
	lastName.sendKeys(ExcelData.getCellData("URLPB4", "LastName", 2));
	email.sendKeys(ExcelData.getCellData("URLPB4", "email", 2));
	wantTransportRequired4.click();
	cabPickUpYes4.click();
	try {
		Thread.sleep(3000);
	} catch (InterruptedException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
	confirmDetails.click();
	cardHolderName.sendKeys(ExcelData.getCellData("URLPB4", "CardHN", 2));
	cardNumber.sendKeys(ExcelData.getCellData("URLPB4", "CardN", 2));
	cardNumber.sendKeys(ExcelData.getCellData("URLPB4", "CardN", 2));
	cardNumber.sendKeys(ExcelData.getCellData("URLPB4", "CardN", 2));
	cardNumber.sendKeys(ExcelData.getCellData("URLPB4", "CardN", 2));
	Helper.implict(3);
	expiryMonth.click();
	expiryMonthJan.click();
	expiryMonthYear.click();
	expiryMonthYear2023.click();
	securityCode.sendKeys(ExcelData.getCellData("URLPB4", "SCode", 2));
	selectCountry.click();
	selectCountryInd.click();
	enterLocation.sendKeys(ExcelData.getCellData("URLPB4", "Location", 2));
	enterCity.sendKeys(ExcelData.getCellData("URLPB4", "City", 2));
	enterState.click();
	enterStateDelhi.click();
	zipCode.sendKeys(ExcelData.getCellData("URLPB4", "ZipCode", 2));
	phoneNumber.sendKeys(ExcelData.getCellData("URLPB4", "PhoneN", 2));
	acceptTerm.click();
	completeReservation.click();
	try {
		Thread.sleep(5000);
	} catch (InterruptedException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
	
	return null;
}
public boolean verifyReservation1Successful()  {

	if (bookingConfirmation.isDisplayed()) {
		System.out.println("Reservation1 Successful");
		return true;
	} else {
		System.out.println("Reservation1 Unsuccessful");
		return false;

	}
}
	public boolean verifyReservation2Successful()  {

		if (bookingConfirmation.isDisplayed()) {
			System.out.println("Reservation2 Successful");
			return true;
		} else {
			System.out.println("Reservation2 Unsuccessful");
			return false;

		}
}

}
