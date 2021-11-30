package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;

public class BookingDiffAdults extends TestBase{

	public BookingDiffAdults() {
		PageFactory.initElements(driver, this);
	}
	
	
	
	public String UrlTilte() {
		return driver.getTitle();
	}
	
	@FindBy(id="search_arrival_date")
	WebElement arrivalDate;
	
	@FindBy(id="search_departure_date")
	WebElement departureDate;
	
	@FindBy(xpath="(//span[contains(@role,'presentation')])[1]")
	WebElement dDnRoom;
			
	@FindBy(id="adults-in-room-1")
	WebElement adultRoom;
	
	@FindBy(id="children-in-room-1")
	WebElement childRoom;
	
	@FindBy(id="guests_rooms_done")
	WebElement done;
	
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
	
	public BookingDiffAdults firstPage(String dateIn, String adultNo, String childNo) throws Exception {
		arrivalDate.sendKeys(dateIn);
		Thread.sleep(1000);
		dDnRoom.click();
		adultRoom.sendKeys(adultNo);
		childRoom.sendKeys(childNo);
		done.click();
		Thread.sleep(1000);
		availability.click();
		Thread.sleep(3000);
		gotIt.click();
		booknow.click();
		screenShot("FirstPage");
		return null;
	}
	
	public BookingDiffAdults secondpage(String fname, String lname, String email, String comment) throws Exception {
		firstname.sendKeys(fname);
		lastname.sendKeys(lname);
		bookingEmail.sendKeys(email);
		feedBack.sendKeys(comment);
		confirmDetails.click();
		screenShot("SecondPage");
		return null;
	}
	
	public BookingDiffAdults thirdPage(String name, String address, String cityAdd, String stateAdd, String code, String number) throws Exception {
		country.sendKeys(name);
		streetAdd.sendKeys(address);
		city.sendKeys(cityAdd);
		state.sendKeys(stateAdd);
		zipCode.sendKeys(code);
		phNo.sendKeys(number);
		accept.click();
		subBook.click();
		screenShot("ThirdPage");
		return null;
	}
	
	public BookingDiffAdults confirmPage() throws Exception {
		String txtCode = qtestCode.getText();
		System.out.println("Confirmation Code: "+txtCode);
		screenShot("ConfirmationID");
		return null;
	}
}
