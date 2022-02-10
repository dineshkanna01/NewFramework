package com.be.pom;


import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.admin.pom.AboutThePropertyPages;

import Utility.ExcelData;
import base.TestBase;
import pages.AbstractBasePage;

public class AccessCodeBookingPage extends TestBase {

	ExcelData e = new ExcelData();
	public WebDriver driver;


	@FindBy(xpath = "//div[text()='Rate Plans']")
	WebElement ratePlan;

	@FindBy(xpath = "(//*[contains(@href,'manageRatePlan')])[1]")
	WebElement accessCode;

	@FindBy(xpath = "//input[@name='selectedRatePlanName']")
	WebElement selectRatePlan;

	@FindBy(xpath = "//a[@tabindex='-1']")
	WebElement SummerSpecialSS;                                    //span[text()='1569']

	@FindBy(xpath = "//input[@name='go']")
	WebElement GO;

	@FindBy(xpath = "(//*[contains(@href,'#')])[1]")
	WebElement addAccessCode;

	@FindBy(xpath = "//input[@name='accessCode']")
	WebElement addAccessCodeText;

	@FindBy(xpath = "//input[@name='save']")
	WebElement save;

	@FindBy(xpath = "//input[@id='search_arrival_date']")
	WebElement inputArrivalDate;

	@FindBy(xpath = "//input[@id='search_departure_date']")
	WebElement inputDepartureDate;

	@FindBy(xpath = "//input[@id='search_offer_code']")
	WebElement searchOfferCode;

	@FindBy(xpath = "//button[@id='check-availability-btn']")
	WebElement checkAvailability;

	@FindBy(xpath = "//*[contains(@href,'AC1')]")
	WebElement accessCodeLink;

	@FindBy(xpath = "//*[contains(@class,'button loyalty')]")
	WebElement checkAvailabilityInAccessCodeURL;

	@FindBy(xpath = "//button[@class='room-book-now-button']")
	WebElement bookNow;

	@FindBy(xpath = "//input[@name='booking[first_name]']")
	WebElement firstName;

	@FindBy(xpath = "//input[@name='booking[last_name]']")
	WebElement lastName;

	@FindBy(xpath = "//input[@name='booking[email]']")
	WebElement email;

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


	@FindBy(xpath = "(//input[@name='booking[phone_number]'])")
	WebElement  phoneNumber;

	@FindBy(xpath = "(//input[@aria-label='I accept the Terms & Conditions'])")
	WebElement  acceptTerm;

	@FindBy(xpath = "(//input[@value='Complete reservation'])")
	WebElement completeReservation;

	@FindBy(xpath = "//h2[text()='Thank you for your reservation']")
	WebElement bookingConfirmation;

	@FindBy(xpath = "(//a[text()='Edit'])[2]")
	WebElement editAccessCode;

	@FindBy(xpath = "//a[text()='Delete']")
	WebElement deleteAccessCode;

	@FindBy(xpath = "//span[text()='OK']")
	WebElement deleteAccessCodeOK;

	@FindBy(xpath = "//strong[text()='Summer Special -SS']")
	WebElement accessCodeRatePlanBE;

	@FindBy(xpath = "(//td[@width='300'])[last()]")
	WebElement accessCodeName;

	@FindBy(xpath = "//font[text()='There are no rate plan access codes to display.']")
	WebElement accessCodeDeletedWarning;

	@FindBy(xpath = "//button[text()='OK']")
	WebElement accessCodeEditOKBE;
	
	@FindBy(xpath ="//a[text()=\"Got it!\"]")
	WebElement gotIt;















	public AccessCodeBookingPage(WebDriver driver) {
		super();
		PageFactory.initElements(driver, this);
	}

	public String UrlTilte() {
		return driver.getTitle();

	}	

	/*
	 * Method to scroll down
	 * 
	 */


	public AccessCodeBookingPage scrollDownTen()  {
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		js.executeScript("window.scrollBy(0,1000)");
		return null;
	}

	/*
	 * Method to scroll down
	 * 
	 */


	public AccessCodeBookingPage scrollDownFive()  {
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		js.executeScript("window.scrollBy(0,500)");
		return null;
	}


	/*
	 * Method to click on check availability
	 * 
	 */


	public AccessCodeBookingPage clickonCheckAvailability()  {
		checkAvailability.click();
		TestBase.implict(3);
		return null;
	}





	/*
	 * Method to verify access code rate plan before config
	 * 
	 */
	public AccessCodeBookingPage AccessCodeRatePlanInBE()  {

		inputArrivalDate.sendKeys(e.getCellData("Booking", "ArrivalD", 2));
		inputDepartureDate.clear();
		inputDepartureDate.sendKeys(e.getCellData("Booking", "DepartureD", 2));
		searchOfferCode.sendKeys(e.getCellData("Booking", "AccessCode", 2));
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		checkAvailability.click();
		TestBase.implict(10);
//		try {
//			Thread.sleep(3000);
//		} catch (InterruptedException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
//
		checkAvailability.click();
//		try {
//			Thread.sleep(3000);
//		} catch (InterruptedException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
		TestBase.implict(6);
//		gotIt.click();
		bookNow.click();	

		return null;	

	}


	/*
	 * Method to  config access code
	 * 
	 */
	public AccessCodeBookingPage createAccessCode()  {
		ratePlan.click();
		accessCode.click();
		selectRatePlan.sendKeys(e.getCellData("Booking", "RatePlan", 2));
		SummerSpecialSS.click();
		GO.click();
		addAccessCode.click();
		addAccessCodeText.sendKeys(e.getCellData("Booking", "AccessCode", 2));
		save.click();

		return null;


	}

	/*
	 * Method to verify  access code rate plan
	 *  returns boolean value
	 * 
	 */
	public boolean verifyAccessCodeRatePlan()  {
		String ActText =(e.getCellData("Booking", "RatePlan", 2));
		System.out.println(ActText + " Actual Text");
		String expText =accessCodeRatePlanBE.getText();
		System.out.println(expText + " " + "ExpectedText");
		if (ActText.equalsIgnoreCase(expText)) {
			System.out.println(" access code rate plan displayed");
			return true;
		} else {
			System.out.println("access code rate plan not displayed");
			return false;

		}
	}
	/*
	 * Method to  click on access code URL for booking
	 * 
	 */
	public AccessCodeBookingPage clickOnCreatedAccessCodeURL()  {
		//	ratePlan.click();
		//	accessCode.click();
		//	selectRatePlan.sendKeys(e.getCellData("ACB1", "RatePlan", 2));
		//	SummerSpecialSS.click();
		//	GO.click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		accessCodeLink.click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return null;
	}

	public AccessCodeBookingPage goToCreatedAccessCodeURL()  {

		inputArrivalDate.sendKeys(e.getCellData("Booking", "ArrivalD", 2));
		inputDepartureDate.sendKeys(e.getCellData("Booking", "DepartureD", 2));
		checkAvailabilityInAccessCodeURL.click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		checkAvailability.click();
		bookNow.click();
		firstName.sendKeys(e.getCellData("URLPB2", "FirstName", 2));
		lastName.sendKeys(e.getCellData("URLPB2", "LastName", 2));
		email.sendKeys(e.getCellData("URLPB2", "email", 2));

		confirmDetails.click();
		cardHolderName.sendKeys(e.getCellData("URLPB2", "CardHN", 2));
		cardNumber.sendKeys(e.getCellData("URLPB2", "CardN", 2));
		cardNumber.sendKeys(e.getCellData("URLPB2", "CardN", 2));
		cardNumber.sendKeys(e.getCellData("URLPB2", "CardN", 2));
		cardNumber.sendKeys(e.getCellData("URLPB2", "CardN", 2));
		TestBase.implict(3);
		expiryMonth.click();
		expiryMonthJan.click();
		expiryMonthYear.click();
		expiryMonthYear2023.click();
		securityCode.sendKeys(e.getCellData("URLPB2", "SCode", 2));
		selectCountry.click();
		selectCountryInd.click();
		enterLocation.sendKeys(e.getCellData("URLPB2", "Location", 2));
		enterCity.sendKeys(e.getCellData("URLPB2", "City", 2));
		enterState.click();
		enterStateDelhi.click();
		zipCode.sendKeys(e.getCellData("URLPB2", "ZipCode", 2));
		phoneNumber.sendKeys(e.getCellData("URLPB2", "PhoneN", 2));
		acceptTerm.click();
		completeReservation.click();




		return null;

	}

	public boolean verifyReservationSuccessful()  {

		if (bookingConfirmation.isDisplayed()) {
			System.out.println("Reservation Successful");
			return true;
		} else {
			System.out.println("Reservation Unsuccessful");
			return false;

		}
	}
	public AccessCodeBookingPage editCreatedAccessCode()  {
		ratePlan.click();
		accessCode.click();
		selectRatePlan.sendKeys(e.getCellData("Booking", "RatePlan", 2));
		SummerSpecialSS.click();
		GO.click();
		editAccessCode.click();
		addAccessCodeText.clear();
		addAccessCodeText.sendKeys(e.getCellData("Booking", "AccessCode2", 2));
		save.click();

		return null;

	}

	/*
	 * Method to verify  access code edited
	 *  returns boolean value
	 * 
	 */
	public boolean verifyAccessCodeEdited()  {
		String ActText =(e.getCellData("Booking", "AccessCode2", 2));
		System.out.println(ActText + " Actual Text");
		String expText =accessCodeName.getText();
		System.out.println(expText + " " + "ExpectedText");
		if (ActText.equalsIgnoreCase(expText)) {
			System.out.println(" access code rate plan edited");
			return true;
		} else {
			System.out.println("access code rate plan not editeds");
			return false;

		}
	}
	public AccessCodeBookingPage EditedAccessCodeRatePlanInBE()  {
		accessCodeEditOKBE.click();
		inputArrivalDate.sendKeys(e.getCellData("Booking", "ArrivalD", 2));
		inputDepartureDate.clear();
		inputDepartureDate.sendKeys(e.getCellData("Booking", "DepartureD", 2));
		searchOfferCode.sendKeys(e.getCellData("Booking", "AccessCode2", 2));
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		checkAvailability.click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		checkAvailability.click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		bookNow.click();	

		return null;	

	}
	public AccessCodeBookingPage deleteCreatedAccessCodeURL()  {
		//	ratePlan.click();
		//	accessCode.click();
		//	selectRatePlan.sendKeys(e.getCellData("ACB1", "RatePlan", 2));
		//	SummerSpecialSS.click();
		//	GO.click();
		deleteAccessCode.click();
		deleteAccessCodeOK.click();
		return null;	
	}

	/*
	 * Method to verify Access Code deleted
	 * 
	 */
	public boolean verifyAccessCodeDeleted()  {
		if (accessCodeDeletedWarning.isDisplayed()) {
			System.out.println("Access Code deleted");
			return true;
		} else {
			System.out.println("Access Code not deleted");
			return false;

		}
	}
}
