package com.be.pom;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import Utility.ExcelData;
import base.Helper;
import base.TestBase;
import base.Helper;
import pages.AbstractBasePage;
/*
 * Test class for Calendar View Bookings
 * @author Sudhakar Mourya
 */
public class CalendarViewBookingsPage extends TestBase{

	@FindBy(xpath = "//*[@name='endDate']")
	WebElement enddate;

	@FindBy(xpath = "//*[@name='startDate']")
	WebElement startdate;

	@FindBy(id ="user_login")
	WebElement username;

	@FindBy(id ="user_password")
	WebElement password;

	@FindBy(xpath = "//input[@value='Sign In']")
	WebElement signIn;

	@FindBy(xpath = "//a[text()='Portal settings']")
	WebElement portalSetting;

	@FindBy(xpath = "//input[@placeholder='Filter']")
	WebElement filter;

	@FindBy(xpath = "//*[text()=' Search']")
	WebElement search;

	@FindBy(xpath = "(//a[text()='edit'])[2]")
	WebElement themeEdit;

	@FindBy(xpath = "(//label[@role='button'])[3]")
	WebElement startingPage;

	@FindBy(xpath = "//*[@name='_save']")
	WebElement save;

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

	@FindBy(id = "select-calendar-room")
	WebElement selectRoom;

	@FindBy(xpath = "//button[text()='Reset dates']")
	WebElement resetDate;

	@FindBy(xpath = "//div[contains(@class,'alert ')]")
	WebElement subdomainSuccessfullyUpdated;

	@FindBy(xpath = "//i[@class='icon-pencil']")
	WebElement pencilIcon;

	@FindBy(xpath = "//label[@data-toggle='dropdown']")
	WebElement flow;

	@FindBy(xpath = "//button[@class=\"btn btn-primary\"]/i")
	WebElement saveButtonStandardFlow;

	@FindBy(xpath = "//a[text()='Change reservation']")
	WebElement changeReservation;

	@FindBy(xpath = "//span[text()='Yes']")
	WebElement ClickOnYesChangeReservation;

	@FindBy(xpath = "(//li[@class='ui-menu-item']//a)[2]")
	WebElement yankee;

	@FindBy(xpath = "(//li[@class='ui-menu-item']//a)[1]")
	WebElement standard;



	public CalendarViewBookingsPage(WebDriver driver) {
		super();
		PageFactory.initElements(driver, this);
	}

	public String UrlTilte() {
		return driver.getTitle();
	}

	/*
	 * Method for input field TC_01
	 */
	public CalendarViewBookingsPage inputFieldTc_01() throws InterruptedException {
		username.clear();
		username.sendKeys(ExcelData.getCellData("CalendarViewBooking","username",2));
		password.clear();
		password.sendKeys(ExcelData.getCellData("CalendarViewBooking","password",2));
		signIn.click();
		portalSetting.click();
		filter.sendKeys(ExcelData.getCellData("CalendarViewBooking","subdomain",2));
		search.click();
		themeEdit.click();
		Actions act=new Actions(getDriver());
		act.click(startingPage).perform();
		act.sendKeys(Keys.ARROW_DOWN).perform();	
		act.sendKeys(Keys.ENTER).perform();
		save.click();
		Thread.sleep(3000);
		return null;
	}

	/*
	 * Method for signIn in IBE-config
	 */
	public CalendarViewBookingsPage login_IBE_Config() {
		username.clear();
		username.sendKeys(ExcelData.getCellData("CalendarViewBooking","username",2));
		password.clear();
		password.sendKeys(ExcelData.getCellData("CalendarViewBooking","password",2));
		signIn.click();
		return null;
	}

	/*
	 * Method for click on portal setting
	 */
	public CalendarViewBookingsPage clickOnPortalsetting() {
		portalSetting.click();
		return null;
	}

	/*
	 * Method for enter subdomain and click
	 */
	public CalendarViewBookingsPage enterSubdomain() {
		filter.sendKeys(ExcelData.getCellData("CalendarViewBooking","subdomain",2));
		search.click();
		return null;
	}

	/*
	 * Method for click on pencil icon
	 */
	public CalendarViewBookingsPage clickOnPencilIcon() {
		pencilIcon.click();
		return null;
	}

	/*
	 * Method for select standard flow from dropdown
	 */
	public CalendarViewBookingsPage selectStandardFlow() {
		flow.click();
		Helper.sleep(2000);
		standard.click();
		return null;
	}

	/*
	 * Method for select Yankee flow from dropdown
	 */
	public CalendarViewBookingsPage selectYankeeFlow() throws InterruptedException {
		flow.click();
		Helper.sleep(2000);
		yankee.click();
		return null;
	}

	/*
	 * Method for click on save
	 */
	public CalendarViewBookingsPage clickOnSave() {
		saveButtonStandardFlow.click();
		Helper.implict(4);
		return null;
	}

	/*
	 * Method to select dates booking engine
	 */
	public CalendarViewBookingsPage selectDate() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		calender.click();
		Helper.implict(2);
		checkInDate.click();
		return null;
	}

	/*
	 * Method to click Availibility Button
	 */
	public CalendarViewBookingsPage clickAvailibilityButton() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		avalilibiltyButton.click();
		Helper.implict(2);
		return null;
	}

	/*
	 * Method to click Book Now Button
	 */
	public CalendarViewBookingsPage clickBookNowButton() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}try {
			bookNow.click();
		}catch(Exception e) {
			System.out.println("Na");
		}
		Helper.implict(4);
		return null;
	}

	/*
	 * Method to input Guest Details
	 */
	public CalendarViewBookingsPage inputGuestDetails() {
		firstName.sendKeys(ExcelData.getCellData("CalendarViewBooking", "FirstName", 2));
		Helper.implict(1);
		lastName.sendKeys(ExcelData.getCellData("CalendarViewBooking", "LastName", 2));
		Helper.implict(1);
		email.sendKeys(ExcelData.getCellData("CalendarViewBooking", "Email", 2));
		Helper.implict(1);
		return null;
	}

	/*
	 * Method to select BAR Rate Plan
	 */
	public CalendarViewBookingsPage selectRatePlanBar() {
		ratePLanBar.click();
		Helper.implict(1);
		return null;
	}

	/*
	 * Method to click confirm Details
	 */
	public CalendarViewBookingsPage clickconfirmDetails() {
		confirmDetails.click();
		Helper.implict(4);
		return null;
	}

	/*
	 * Method to input Card Details TC01
	 * 
	 */
	public CalendarViewBookingsPage inputCardDetails() {
		cardName.sendKeys(ExcelData.getCellData("CalendarViewBooking", "CardName", 2));
		cardNumber.sendKeys(ExcelData.getCellData("CalendarViewBooking", "CardNumber1", 2));
		cardNumber.sendKeys(ExcelData.getCellData("CalendarViewBooking", "CardNumber2", 2));
		cardNumber.sendKeys(ExcelData.getCellData("CalendarViewBooking", "CardNumber3", 2));
		cardNumber.sendKeys(ExcelData.getCellData("CalendarViewBooking", "CardNumber4", 2));
		Select dropdown = new Select(expiryMonthDropdown);
		dropdown.selectByVisibleText("12");
		Helper.implict(1);
		Select d = new Select(expiryYearDropdown);
		d.selectByVisibleText("2028");
		Helper.implict(1);
		secCode.sendKeys(ExcelData.getCellData("CalendarViewBooking", "SecurityCode", 2));
		Helper.implict(1);
		return null;
	}

	/*
	 * Method to input Billing Address
	 * 
	 */
	public CalendarViewBookingsPage inputBillingAddress() {
		Select dropdown = new Select(country);
		dropdown.selectByVisibleText("India");
		Helper.implict(1);
		add1.sendKeys(ExcelData.getCellData("CalendarViewBooking", "Addressline1", 2));
		Helper.implict(1);
		city.sendKeys(ExcelData.getCellData("CalendarViewBooking", "City", 2));
		Helper.implict(1);
		Select d = new Select(state);
		d.selectByVisibleText("Delhi");
		Helper.implict(1);
		zipCode.sendKeys(ExcelData.getCellData("CalendarViewBooking", "Zipcode", 2));
		Helper.implict(1);
		return null;
	}

	/*
	 * Method to input additional ContactInfo
	 * 
	 */
	public CalendarViewBookingsPage inputadditionalContactInfo() {
		phNum.sendKeys(ExcelData.getCellData("CalendarViewBooking", "PhoneNumber", 2));
		Helper.implict(1);
		return null;
	}

	/*
	 * Method to select Terms And Conditon Checkbox
	 * 
	 */
	public CalendarViewBookingsPage selectTermsAndConditonCheckbox() {
		termsConditions.click();
		Helper.implict(1);
		return null;
	}

	/*
	 * Method to click Complete Reservation
	 */
	public CalendarViewBookingsPage clickCompleteReservation() {
		completeReservation.click();
		Helper.implict(5);
		return null;
	}

	/*
	 * Method to click on select room
	 */
	public CalendarViewBookingsPage clickOnSelectRoom() {
		try {
			selectRoom.click();
		}catch(Exception e){
			System.out.println("Na");	
		}
		Helper.implict(5);
		return null;
	}

	/*
	 * Method to click on reset room
	 */
	public CalendarViewBookingsPage clickOnResetDate() {
		resetDate.click();
		Helper.implict(5);
		return null;
	}

	/*
	 * Method to click on change Reservaion
	 */
	public CalendarViewBookingsPage clickOnChangeReservation() {
		changeReservation.click();
		Helper.implict(3);
		return null;
	}

	/*
	 * Method to click on Yes for Cancel Reservaion
	 */
	public CalendarViewBookingsPage clickOnYesForChangeReservation() {
		ClickOnYesChangeReservation.click();
		Helper.implict(3);
		return null;
	}

	/*
	 * Method to verify Theme Updated
	 */
	public boolean verifySubdomainUpdated() {
		if(subdomainSuccessfullyUpdated.isDisplayed()) {
			System.out.println("Subdomain Successfully updated");
			return true;
		}
		else {
			System.out.println("Subdomain not updated");
			return false;
		}
	}

	/*
	 * Method for verification for booking
	 * 
	 */
	public boolean verificationBooking() {
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
	 * Method for verify_TC_01
	 */
	public boolean verification_TC_01(){
		if (confirmCodes.isDisplayed()) {
			String ConfirmationCode = confirmCodes.getText();
			System.out.println("Booking is completed, Confirmation code and Transaction id are: " + ConfirmationCode);
			return true;
		}
		else {
			System.out.println("");
			return false;
		}
	}

	/*
	 * Method for select date range
	 */
	public CalendarViewBookingsPage selectDateRange() throws InterruptedException{
		Helper.implict(5);
		//	
		//		// TO GET CURRENT DATE
		//		DateFormat dateFormat = new SimpleDateFormat("dd");
		//		Date date = new Date();
		//		String currentDate = dateFormat.format(date);
		//		System.out.println("current day date " + currentDate);
		//		Thread.sleep(3000);
		//		
		//		WebElement a= getDriver().findElement(By.xpath("(//*[text()='"+ currentDate+ "'])[1]"));
		//		WebDriverWait wait = new WebDriverWait(getDriver(),10);
		//		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//*[text()='"+ currentDate+ "'])[1]")));
		//		try {
		//		a.click();
		//		}
		//		catch(Exception e)
		//		{
		//			System.out.println("NA");
		//		}
		// TO GET NEXT DAY DATE
		String nextDaydate = "";
		Date date2 = new Date();
		Calendar cal = Calendar.getInstance();
		cal.setTime(date2);
		cal.add(Calendar.DAY_OF_YEAR, +1);
		Date after = cal.getTime();
		SimpleDateFormat formatter = new SimpleDateFormat("dd");
		nextDaydate = formatter.format(after);
		System.out.println("next day date " + nextDaydate);
		WebElement b= getDriver().findElement(By.xpath("(//*[text()='"+ nextDaydate+ "'])[1]"));
		try {
			b.click();
		}
		catch(Exception e)
		{
			System.out.println("NA");
		}

		String nextDaydate1 = "";
		Date date21 = new Date();
		Calendar cal1 = Calendar.getInstance();
		cal1.setTime(date21);
		cal1.add(Calendar.DAY_OF_YEAR, +3);
		Date after1 = cal1.getTime();
		SimpleDateFormat formatter1 = new SimpleDateFormat("dd");
		nextDaydate1 = formatter1.format(after1);
		System.out.println("next day date " + nextDaydate1);
		WebElement b1= getDriver().findElement(By.xpath("(//*[text()='"+ nextDaydate1+ "'])[1]"));
		try {
			b1.click();
		}
		catch(Exception e)
		{
			System.out.println("NA");
		}
		return null;
	}

	/*
	 * Method for select date range
	 */
	public CalendarViewBookingsPage selectDateRangeTC_03() throws InterruptedException{
		// TO GET CURRENT DATE
		Helper.implict(5);
		String nextDaydate = "";
		Date date2 = new Date();
		Calendar cal = Calendar.getInstance();
		cal.setTime(date2);
		cal.add(Calendar.DAY_OF_YEAR, +1);
		Date after = cal.getTime();
		SimpleDateFormat formatter = new SimpleDateFormat("dd");
		nextDaydate = formatter.format(after);
		System.out.println("next day date " + nextDaydate);
		WebElement b= getDriver().findElement(By.xpath("(//*[text()='"+ nextDaydate+ "'])[1]"));
		try {
			b.click();
		}
		catch(Exception e)
		{
			System.out.println("NA");
		}

		String nextDaydate1 = "";
		Date date21 = new Date();
		Calendar cal1 = Calendar.getInstance();
		cal1.setTime(date21);
		cal1.add(Calendar.DAY_OF_YEAR, +4);
		Date after1 = cal1.getTime();
		SimpleDateFormat formatter1 = new SimpleDateFormat("dd");
		nextDaydate1 = formatter1.format(after1);
		System.out.println("next day date " + nextDaydate1);
		Thread.sleep(3000);
		WebElement b1= getDriver().findElement(By.xpath("(//*[text()='"+ nextDaydate1+ "'])[1]"));
		try {
			b1.click();
		}
		catch(Exception e)
		{
			System.out.println("NA");
		}
		return null;
	}
}
