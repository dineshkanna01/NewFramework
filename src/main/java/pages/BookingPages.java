package pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utility.ExcelData;
import base.TestBase;

public class BookingPages extends AbstractBasePage {

	ExcelData e = new ExcelData();
	
	public BookingPages(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	public String UrlTilte() {
		return driver.getTitle();
	}
	
	@FindBy(id="search_arrival_date")
	WebElement arrivalDate;
	
	@FindBy(id="search_departure_date")
	WebElement departureDate;
	
	@FindBy(id="check-availability-btn")
	WebElement availability;
	
	@FindBy(xpath="//button[contains(text(),\"Book now\")]")
	WebElement booknow;
	
	@FindBy(id="booking_first_name")
	WebElement firstname;
	
	@FindBy(id="booking_last_name")
	WebElement lastname;
	
	@FindBy(id="booking_email")
	WebElement bookingEmail;
	
	@FindBy(xpath ="//a[text()=\"Got it!\"]")
	WebElement gotIt;
	
	@FindBy(id="19")
	WebElement feedBack;
	
	@FindBy(xpath="//button[contains(text(),\"Confirm details\")]")
	WebElement confirmDetails;
	
	@FindBy(id="booking_country")
	WebElement country;
	
	@FindBy(id="booking_street_address1")
	WebElement streetAdd;
	
	@FindBy(id="booking_city")
	WebElement city;
	
	@FindBy(id="booking_state")
	WebElement state;
	
	@FindBy(id="booking_zip_code")
	WebElement zipCode;
	
	@FindBy(id="booking_phone_number")
	WebElement phNo;
	
	@FindBy(id="accept")
	WebElement accept;
	
	@FindBy(id="submit-booking")
	WebElement subBook;
	
	@FindBy(id="card_holder_name")
	WebElement cardHolder;
	
	@FindBy(id="card_number")
	WebElement cardNo;
	
	@FindBy(id="expiration_date_month")
	WebElement expireMonth;
	
	@FindBy(id="expiration_date_year")
	WebElement expireYear;
	
	@FindBy(id="security_code")
	WebElement SecCode;
	
	@FindBy(id="summary_reservation_confirmation_code")
	WebElement conCode;
	
	@FindBy(xpath="//strong[contains(text(),'qtest')]")
	WebElement qtestCode;
	
	public BookingPages firstPage() throws Exception {
		arrivalDate.sendKeys(e.getCellData("FirstPage", "dateIn", 2));
		TestBase.implict(8);
		departureDate.clear();
		departureDate.sendKeys(e.getCellData("FirstPage", "dateOut", 2));
		availability.click();
		Thread.sleep(4000);
		gotIt.click();
		Thread.sleep(4000);
		booknow.click();
		TestBase.screenShot("FirstPage");
		return null;
	}
	
	public BookingPages secondpage() throws Exception {
		firstname.sendKeys(e.getCellData("SecondPage", "firstName", 2));
		lastname.sendKeys(e.getCellData("SecondPage", "lname", 2));
		bookingEmail.sendKeys(e.getCellData("SecondPage", "email", 2));
		feedBack.sendKeys(e.getCellData("SecondPage", "feedBack", 2));
		confirmDetails.click();
		TestBase.screenShot("SecondPage");
		return null;
	}
	
	public BookingPages thirdPage(String cardNum) throws Exception {
		cardHolder.sendKeys(e.getCellData("ThirdPage", "cardHolder", 2));
		TestBase.implict(8);
		cardNo.sendKeys(cardNum);
		cardNo.sendKeys(cardNum);
		cardNo.sendKeys(cardNum);
		cardNo.sendKeys(cardNum);
		expireMonth.sendKeys(e.getCellData("ThirdPage", "expireMonth", 2));
		expireYear.sendKeys(e.getCellData("ThirdPage", "expireYear", 2));
		SecCode.sendKeys(e.getCellData("ThirdPage", "SecCode", 2));
		country.sendKeys(e.getCellData("ThirdPage", "country", 2));
		streetAdd.sendKeys(e.getCellData("ThirdPage", "streetAdd", 2));
		city.sendKeys(e.getCellData("ThirdPage", "city", 2));
		state.sendKeys(e.getCellData("ThirdPage", "state", 2));
		zipCode.sendKeys(e.getCellData("ThirdPage", "zipCode", 2));
		phNo.sendKeys(e.getCellData("ThirdPage", "phNo", 2));
		accept.click();
		subBook.click();
		TestBase.screenShot("ThirdPage");
		return null;
	}
	
	public BookingPages confirmPage() throws Exception {
		String txtCode = qtestCode.getText();
		System.out.println("Confirmation Code: "+txtCode);
		TestBase.screenShot("ConfirmationID");
		return null;
	}
	
}
