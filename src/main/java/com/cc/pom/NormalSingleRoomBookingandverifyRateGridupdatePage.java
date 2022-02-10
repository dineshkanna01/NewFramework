package com.cc.pom;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import com.admin.pom.RatesandInventoryPage;
import com.be.pom.HouseControlRestrictionsPage;

import Utility.ExcelData;
import base.TestBase;
import pages.AbstractBasePage;

/*
 * POM class for NormalSingleRoomBookingandverifyRateGridupdatePage
 * @author Rudraksh Aggarwal
 */

public class NormalSingleRoomBookingandverifyRateGridupdatePage extends TestBase {
	
	ExcelData e = new ExcelData();
	public static WebDriver driver;

	@FindBy(xpath = "//*[@name='startDate']")
	WebElement startdate;

	@FindBy(xpath = "//*[@name='endDate']")
	WebElement enddate;

	@FindBy(xpath = "//*[@name='C1361']")
	WebElement selectRatePlan;

	@FindBy(xpath = "//button[@type='button']")
	WebElement selectRoomTypedropdwn;

	@FindBy(xpath = "//*[@class='ms-selectall global']")
	WebElement selectAllRoomType;

	@FindBy(xpath = "(//input[contains(@id,'rooms_available_')])[1]")
	WebElement roomsAvailable;

	@FindBy(xpath = "//*[@id='maxLOS']")
	WebElement maxLos;

	@FindBy(xpath = "//*[@value='Quick Entry']")
	WebElement quickEntryBtn;

	@FindBy(name = "bt2")
	WebElement updateButton;

	@FindBy(xpath = "//input[@value='Confirm']")
	WebElement confirmButton;

	@FindBy(xpath = "(//input[@value='O'])[1]")
	WebElement openYieldControl;

	@FindBy(name = "ccid")
	WebElement ccUser;

	@FindBy(name = "commit")
	WebElement okButton;

	@FindBy(name = "start")
	WebElement checkInDate;

	@FindBy(name = "end")
	WebElement checkOutDate;

	@FindBy(xpath = "//button[text()='Check availability']")
	WebElement checkAvailability;

	@FindBy(xpath = "(//span[@ng-show='rate.available_rooms_number'])[1]")
	WebElement roomAvail;

	@FindBy(xpath = "//span[@ng-show='rate.available_rooms_number']")
	List<WebElement> verifyRoomAvailibilty;

	@FindBy(xpath = "//a[contains(@class,'hotel-room-name ng')]")
	List<WebElement> roomNames;

	@FindBy(xpath = "(//*[text()='Select'])[2]")
	WebElement selectButtonCR;

	@FindBy(xpath = "(//*[text()='Select'])[1]")
	WebElement selectButtonSR;

	@FindBy(xpath = "//*[text()='Payment']")
	WebElement paymentButton;

	@FindBy(id = "customer-confirm-first-name")
	WebElement fName;

	@FindBy(id = "customer-last-name")
	WebElement lName;

	@FindBy(id = "customer-confirm-email")
	WebElement email;

	@FindBy(id = "card-holder-name")
	WebElement cardName;

	@FindBy(id = "card-number")
	WebElement cardNumber;

	@FindBy(id = "expiry-month")
	WebElement expiryMonthDropdown;

	@FindBy(id = "expiry-year")
	WebElement expiryYearDropdown;

	@FindBy(id = "cvv")
	WebElement secCode;

	@FindBy(id = "select2-country-container")
	WebElement countryDropdown;

	@FindBy(xpath = "//*[text()='India']")
	WebElement country;

	@FindBy(id = "street_address1")
	WebElement add1;

	@FindBy(name = "booking[city]")
	WebElement city;

	@FindBy(id = "state")
	WebElement state;

	@FindBy(name = "booking[zip_code]")
	WebElement zipCode;

	@FindBy(name = "booking[phone_number]")
	WebElement phNum;

	@FindBy(xpath = "//input[@type='checkbox']")
	WebElement termsandconditionCheckbox;

	@FindBy(xpath = "//input[@name='commit']")
	WebElement completeReservation;

	@FindBy(xpath = "//thead[@class=\"confirmation-table-head\"]/tr/td[last()]/dl/dt")
	WebElement confirmcodeHeading;

	@FindBy(xpath = "//thead[@class=\"confirmation-table-head\"]/tr/td[last()]/dl/dd")
	WebElement confirmcode;

	@FindBy(xpath = "(//*[contains(@id,'_623')][1])/td[2]")
	WebElement rategridDate;

	@FindBy(xpath = "(//*[contains(@id,'_623')])/td[2]")
	List<WebElement> rategridAllDate;

	@FindBy(xpath = "//*[contains(@id,'_623')][1]/td[10]")
	WebElement rategridAvailibilty;

	@FindBy(xpath = "(//*[contains(@id,'_623')])/td[10]")
	List<WebElement> rategridAllAvailibilty;

	@FindBy(xpath = "//*[text()='Missing Credit Information']")
	WebElement retryError;

	@FindBy(xpath = "//*[text()='Rate Grid ']")
	WebElement rateGridTitle;

	@FindBy(xpath = "//button[text()='New Reservation']")
	WebElement ccNewRes;

	@FindBy(xpath = "(//*[text()='Room'])[1]")
	WebElement confirmRoomHeading;

	@FindBy(xpath = "(//*[text()='Room'])[1]/following::dd[1]")
	WebElement confirmRoomType;

	@FindBy(xpath = "//a[text()='Modify']")
	WebElement modifyButton;

	@FindBy(xpath = "//div[text()='Cancel']")
	WebElement cancelButton;

	@FindBy(xpath = "//button[text()='Yes']")
	WebElement yesButtonModify;

	@FindBy(xpath = "//button[contains(@class,'btn-success')]")
	WebElement yesButtonCancel;

	@FindBy(xpath = "//*[text()='Your reservation has been cancelled']")
	WebElement cancelCodeHead;

	@FindBy(xpath = "//div[@class='bootbox-body']/strong")
	WebElement cancelCode;

	@FindBy(xpath = "//button[text()='OK']")
	WebElement okButtonCancel;

	@FindBy(xpath = "//div[@data-search='lookup']")
	WebElement lookupButton;

	@FindBy(xpath = "(//input[@type='email'])[1]")
	WebElement lookupEmail;

	@FindBy(xpath = "//input[@id='lookup-field-confirmationNo']")
	WebElement lookupCCcode;

	@FindBy(xpath = "(//button[text()='Go'])[1]")
	WebElement goButton;

	@FindBy(xpath = "//div[text()='Reservation Cancelled']")
	WebElement reservationCancelMsg;

	@FindBy(xpath = "//a[text()='Edit search']")
	WebElement editSearchButton;

	public NormalSingleRoomBookingandverifyRateGridupdatePage(WebDriver driver) {
		super();
		PageFactory.initElements(driver, this);
	}

	public String UrlTilte() {
		return driver.getTitle();
	}

	/*
	 * Method to click New Reservation
	 */
	public NormalSingleRoomBookingandverifyRateGridupdatePage clickNewReservation() {
		ccNewRes.click();
		TestBase.implict(5);
		return null;
	}

	/*
	 * Method to select Rate Plan
	 */
	public NormalSingleRoomBookingandverifyRateGridupdatePage selectRatePlan() {
		selectRatePlan.click();
		TestBase.implict(3);
		return null;
	}

	/*
	 * Method to click select ALL Room Type
	 */
	public NormalSingleRoomBookingandverifyRateGridupdatePage selectALLRoomType() {
		selectRoomTypedropdwn.click();
		TestBase.implict(3);
		selectAllRoomType.click();
		TestBase.implict(3);
		System.out.println("All Rooms selected");

		return null;
	}

	/*
	 * Method to click select Date Range TC01
	 */
	public NormalSingleRoomBookingandverifyRateGridupdatePage selectDateRangeTC01() {
		TestBase.implict(3);
		// TO GET CURRENT DATE
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/YY");
		Date date = new Date();
		String currentDate = dateFormat.format(date);
		System.out.println("current day date for admin TC01 " + currentDate);
		startdate.sendKeys(currentDate);

		TestBase.implict(3);

		// TO GET NEXT DAY DATE
		String nextDaydate = "";
		Date date2 = new Date();
		Calendar cal = Calendar.getInstance();
		cal.setTime(date2);

		cal.add(Calendar.DAY_OF_YEAR, +1);
		Date after = cal.getTime();
		SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/YY");
		nextDaydate = formatter.format(after);
		System.out.println("next day date for admin TC01  " + nextDaydate);

		enddate.sendKeys(nextDaydate);
		return null;
	}

	/*
	 * Method to click select Date Range TC02
	 */
	public NormalSingleRoomBookingandverifyRateGridupdatePage selectDateRangeTC02() {
		TestBase.implict(3);
		// TO GET CURRENT DATE
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/YY");
		Date date = new Date();
		String currentDate = dateFormat.format(date);
		System.out.println("current day date for admin TC02 " + currentDate);
		startdate.sendKeys(currentDate);

		TestBase.implict(3);

		// TO GET DATE AFTER 7 DAYS
		String SevenDaydate = "";
		Date date2 = new Date();
		Calendar cal = Calendar.getInstance();
		cal.setTime(date2);

		cal.add(Calendar.DAY_OF_YEAR, +7);
		Date after = cal.getTime();
		SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/YY");
		SevenDaydate = formatter.format(after);
		System.out.println("DATE AFTER 7 DAYS for admin TC02 " + SevenDaydate);

		enddate.sendKeys(SevenDaydate);
		return null;
	}

	/*
	 * Method to input Field Room Available
	 */
	public void inputFieldRoomAvailable() {
		roomsAvailable.clear();
		roomsAvailable.sendKeys(e.CC_getCellData("NormalSingleRoomBookingData", "RoomAvailable", 2));

	}

	/*
	 * Method to click Quick Entry Button
	 */
	public NormalSingleRoomBookingandverifyRateGridupdatePage clickQuickEntrybutton() {
		quickEntryBtn.click();
		TestBase.implict(3);
		return null;
	}

	/*
	 * Method to click update Button
	 */
	public NormalSingleRoomBookingandverifyRateGridupdatePage clickUpdateButton() {
		updateButton.click();
		TestBase.implict(3);
		return null;
	}

	/*
	 * Method to click confirm Button
	 */
	public NormalSingleRoomBookingandverifyRateGridupdatePage clickConfirmButton() {
		confirmButton.click();
		try {
			Thread.sleep(2500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	/*
	 * Method to select open yield control
	 */
	public NormalSingleRoomBookingandverifyRateGridupdatePage openYieldControls() {
		openYieldControl.click();

		TestBase.implict(3);
		return null;
	}

	/*
	 * Method to enter CC user
	 */
	public NormalSingleRoomBookingandverifyRateGridupdatePage enterCCuser() {
		ccUser.sendKeys(e.CC_getCellData("NormalSingleRoomBookingData", "CCUser", 2));
		okButton.click();
		TestBase.implict(5);
		return null;
	}

	/*
	 * Method to click select Date Range TC01
	 */
	public NormalSingleRoomBookingandverifyRateGridupdatePage selectDateRangeCCTC01() {
		// TO GET CURRENT DATE
		DateFormat dateFormat = new SimpleDateFormat("YYYY-MM-dd");
		Date date = new Date();
		String currentDate = dateFormat.format(date);
		System.out.println("current day date for cc TC01" + currentDate);

		// TO GET NEXT DAY DATE
		String nextDaydate = "";
		Date date2 = new Date();
		Calendar cal = Calendar.getInstance();
		cal.setTime(date2);

		cal.add(Calendar.DAY_OF_YEAR, +1);
		Date after = cal.getTime();
		SimpleDateFormat formatter = new SimpleDateFormat("YYYY-MM-dd");
		nextDaydate = formatter.format(after);
		System.out.println("next day date for cc TC01 " + nextDaydate);

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		checkInDate.sendKeys(currentDate);
		checkInDate.click();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		checkOutDate.click();
		checkOutDate.clear();
		checkOutDate.sendKeys(nextDaydate);

		return null;
	}

	/*
	 * Method to click select Date Range TC02
	 */
	public NormalSingleRoomBookingandverifyRateGridupdatePage selectDateRangeCCTC02() {
		// TO GET CURRENT DATE
		DateFormat dateFormat = new SimpleDateFormat("YYYY-MM-dd");
		Date date = new Date();
		String currentDate = dateFormat.format(date);
		System.out.println("current day date for cc TC02" + currentDate);

		// TO GET DATE AFTER 7 DAYS
		String sevenDaydate = "";
		Date date2 = new Date();
		Calendar cal = Calendar.getInstance();
		cal.setTime(date2);

		cal.add(Calendar.DAY_OF_YEAR, +7);
		Date after = cal.getTime();
		SimpleDateFormat formatter = new SimpleDateFormat("YYYY-MM-dd");
		sevenDaydate = formatter.format(after);
		System.out.println("DATE AFTER 7 DAYS for cc TC02 " + sevenDaydate);

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		checkInDate.sendKeys(currentDate);
		checkInDate.click();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		checkOutDate.click();
		checkOutDate.clear();
		checkOutDate.sendKeys(sevenDaydate);

		return null;
	}

	/*
	 * Method to click Availibility Button
	 */
	public NormalSingleRoomBookingandverifyRateGridupdatePage clickAvailibilityButton() {

		checkAvailability.click();

		return null;
	}

	/*
	 * Method to verify Room Availibilty
	 */
	public boolean verifyRoomsAvailibilty() {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (roomAvail.isDisplayed()) {
			List<WebElement> li = verifyRoomAvailibilty;
			List<WebElement> rn = roomNames;

			for (WebElement i : li) {
				String ra = i.getText();
				for (WebElement y : rn) {
					String roomname = y.getText();
					System.out.println("no. of rooms available for " + roomname + ":" + ra);

				}
				break;
			}

			return true;
		}

		else {

			System.out.println("NA");
			return false;
		}
	}

	/*
	 * Method to select Classic Room
	 */
	public NormalSingleRoomBookingandverifyRateGridupdatePage selectClassicRoom() {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		String roomname = e.CC_getCellData("NormalSingleRoomBookingData", "RoomName", 2);
		selectButtonCR.click();
		System.out.println(roomname + " is selected");
		return null;

	}

	/*
	 * Method to select Standard Room
	 */
	public NormalSingleRoomBookingandverifyRateGridupdatePage selectStandardRoom() {
		String roomname = e.CC_getCellData("NormalSingleRoomBookingData", "RoomNameModify", 2);
		selectButtonSR.click();
		System.out.println(roomname + " is selected");
		return null;

	}

	/*
	 * Method to click payment Button
	 */
	public NormalSingleRoomBookingandverifyRateGridupdatePage clickpaymentButton() {
		paymentButton.click();
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		return null;
	}

	/*
	 * Method to input Guest Details
	 * 
	 */
	public NormalSingleRoomBookingandverifyRateGridupdatePage inputGuestDetails() {
		fName.clear();
		fName.sendKeys(e.CC_getCellData("NormalSingleRoomBookingData", "FirstName", 2));
		TestBase.implict(1);
		lName.clear();
		lName.sendKeys(e.CC_getCellData("NormalSingleRoomBookingData", "LastName", 2));
		TestBase.implict(1);
		email.clear();
		email.sendKeys(e.CC_getCellData("NormalSingleRoomBookingData", "Email", 2));

		return null;
	}

//	public NormalSingleRoomBookingandverifyRateGridupdatePage inputGuestDetailsRetry() {
//		try {
//			Thread.sleep(1500);
//		} catch (InterruptedException e1) {
//			e1.printStackTrace();
//		}
//
//		getDriver().navigate().refresh();
//		fName.clear();
//		fName.sendKeys(e.RudCC_getCellData("NormalSingleRoomBookingData", "FirstName", 2));
//		TestBase.implict(1);
//		lName.clear();
//		lName.sendKeys(e.RudCC_getCellData("NormalSingleRoomBookingData", "LastName", 2));
//		TestBase.implict(1);
//		email.clear();
//		email.sendKeys(e.RudCC_getCellData("NormalSingleRoomBookingData", "Email", 2));
//
//		return null;
//	}

	/*
	 * Method to input Card Details TC01
	 * 
	 */
	public NormalSingleRoomBookingandverifyRateGridupdatePage inputCardDetailsTC01() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		cardName.clear();
		cardName.sendKeys(e.CC_getCellData("NormalSingleRoomBookingData", "CardName", 2));
		cardNumber.sendKeys(e.CC_getCellData("NormalSingleRoomBookingData", "CardNumber1", 2));
		cardNumber.sendKeys(e.CC_getCellData("NormalSingleRoomBookingData", "CardNumber2", 2));
		cardNumber.sendKeys(e.CC_getCellData("NormalSingleRoomBookingData", "CardNumber3", 2));
		cardNumber.sendKeys(e.CC_getCellData("NormalSingleRoomBookingData", "CardNumber4", 2));

		Select d = new Select(expiryYearDropdown);
		d.selectByVisibleText(" 2028");
		TestBase.implict(1);

		Select a = new Select(expiryMonthDropdown);
		a.selectByValue("12");
		TestBase.implict(1);

		secCode.sendKeys(e.CC_getCellData("NormalSingleRoomBookingData", "SecurityCode", 2));
		TestBase.implict(1);
		return null;
	}

	/*
	 * Method to input Billing Address
	 * 
	 */
	public NormalSingleRoomBookingandverifyRateGridupdatePage inputBillingAddress() {

		countryDropdown.click();
		country.click();

		TestBase.implict(1);
		add1.clear();
		add1.sendKeys(e.CC_getCellData("NormalSingleRoomBookingData", "Addressline1", 2));
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		city.clear();
		city.sendKeys(e.CC_getCellData("NormalSingleRoomBookingData", "City", 2));
		TestBase.implict(1);

		Select d = new Select(state);
		d.selectByVisibleText("Delhi");
		TestBase.implict(1);

		zipCode.clear();
		zipCode.sendKeys(e.CC_getCellData("NormalSingleRoomBookingData", "Zipcode", 2));
		TestBase.implict(1);

		phNum.clear();
		phNum.sendKeys(e.CC_getCellData("NormalSingleRoomBookingData", "PhoneNumber", 2));

		return null;
	}

	/*
	 * Method to select Terms And Conditon Checkbox
	 * 
	 */
	public NormalSingleRoomBookingandverifyRateGridupdatePage selectTermsAndConditonCheckbox() {
		termsandconditionCheckbox.click();
		TestBase.implict(1);
		return null;

	}

	/*
	 * Method to click Complete Reservation
	 * 
	 */
	public NormalSingleRoomBookingandverifyRateGridupdatePage clickCompleteReservation() {
		completeReservation.click();
		try {
			Thread.sleep(7000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}

//	public void retry() {
//		try {
//			Thread.sleep(1500);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//
//		try {
//			if (retryError.isDisplayed()) {
//				String re = retryError.getText();
//				System.out.println(re);
//
//				getDriver().navigate().refresh();
//
//				inputGuestDetailsRetry();
//				inputCardDetailsTC01();
//				inputBillingAddress();
//				selectTermsAndConditonCheckbox();
//				clickCompleteReservation();
//
//			}
//		} catch (Exception e) {
//			System.out.println("NA");
//		}
//
//	}

	/*
	 * Method to verify Confirmation Code
	 * 
	 */
	public boolean verifyConfirmationCode() {
		if (confirmcodeHeading.isDisplayed()) {
			String codehead = confirmcodeHeading.getText();
			String code = confirmcode.getText();
			System.out.println(codehead + " is :" + code);
			return true;
		} else {
			System.out.println("NA");
			return false;
		}

	}

	/*
	 * Method to verify rate grid Update TC01
	 * 
	 */
	public boolean verifyRateGridUpdateTC01() {

		String rgd = rategridDate.getText();
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/YY");
		Date date = new Date();
		String currentDate = dateFormat.format(date);
		System.out.println("current day date " + currentDate);

		if (rgd.equalsIgnoreCase(currentDate)) {
			String rga = rategridAvailibilty.getText();
			if (rga.equalsIgnoreCase(e.CC_getCellData("NormalSingleRoomBookingData", "ExpectedAvailTC01", 2))) {
				System.out.println("rate grid updated and new availability is :" + rga);
			}
			return true;
		} else {
			System.out.println("NA");
			return false;
		}

	}

	/*
	 * Method to verify rate grid Update TC02
	 * 
	 */
	public boolean verifyRateGridUpdateTC02() {
		if (rateGridTitle.isDisplayed()) {

			int n = rategridAllAvailibilty.size();
			for (int i = 0; i < n; i++) {
				String SevenDaydates = "";
				Date date2 = new Date();
				Calendar cal = Calendar.getInstance();
				cal.setTime(date2);

				cal.add(Calendar.DAY_OF_YEAR, +i);
				Date after = cal.getTime();
				SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/YY");
				SevenDaydates = formatter.format(after);

				List<WebElement> li = rategridAllAvailibilty;
				for (WebElement y : li) {
					String rgaa = y.getText();
					if (rgaa.equalsIgnoreCase(
							e.CC_getCellData("NormalSingleRoomBookingData", "ExpectedAvailTC01", 2))) {
						System.out.println(
								"rate grid updated and new availability for " + SevenDaydates + " is: " + rgaa);
						break;

					}

				}
			}

			return true;
		} else {
			System.out.println("failed to update rate grid");
			return false;
		}
	}

	/*
	 * Method to verify Availibilty Before CC booingTC01
	 */
	public void verifyAvailibiltyBeforeCCbooingTC01() {
		String rga = rategridAvailibilty.getText();
		System.out.println("rate grid availability before cc booking: " + rga);

	}

	/*
	 * Method to verify Availibilty Before CC booingTC02
	 */
	public void verifyAvailibiltyBeforeCCbookingTC02() {

		int n = rategridAllAvailibilty.size();
		for (int i = 0; i < n; i++) {
			String SevenDaydates = "";
			Date date2 = new Date();
			Calendar cal = Calendar.getInstance();
			cal.setTime(date2);

			cal.add(Calendar.DAY_OF_YEAR, +i);
			Date after = cal.getTime();
			SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/YY");
			SevenDaydates = formatter.format(after);

			List<WebElement> li = rategridAllAvailibilty;
			for (WebElement y : li) {
				String rgaa = y.getText();
				System.out.println("rate grid availability before booking for " + SevenDaydates + " is: " + rgaa);
				break;

			}

		}
	}
}