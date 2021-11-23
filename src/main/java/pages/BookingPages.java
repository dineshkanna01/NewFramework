package pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;

public class BookingPages extends TestBase{

	public BookingPages() {
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
	
	
	
	public BookingPages firstPage(String dateIn) throws Exception {
//		List<Map<String, String>> testDataMap = ExcelUtility.getTestData();
//		arrivalDate.sendKeys(testDataMap.get(1).get("dateIn"));
		arrivalDate.sendKeys(dateIn);
		Thread.sleep(1000);
//		departureDate.sendKeys(dateOut);
		availability.click();
		Thread.sleep(3000);
		gotIt.click();
		booknow.click();
		screenShot("FirstPage");
		return null;
	}
	
	public BookingPages secondpage(String fname, String lname, String email, String comment) throws Exception {
		firstname.sendKeys(fname);
		lastname.sendKeys(lname);
		bookingEmail.sendKeys(email);
		feedBack.sendKeys(comment);
		confirmDetails.click();
		return null;
	}
	
	public BookingPages thirdPage(String name, String address, String cityAdd, String stateAdd, String code, String number) throws Exception {
		country.sendKeys(name);
		streetAdd.sendKeys(address);
		city.sendKeys(cityAdd);
		state.sendKeys(stateAdd);
		zipCode.sendKeys(code);
		phNo.sendKeys(number);
		accept.click();
		subBook.click();
		return null;
	}
	
	
	
}
