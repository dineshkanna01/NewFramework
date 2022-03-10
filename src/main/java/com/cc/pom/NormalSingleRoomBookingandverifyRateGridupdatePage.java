package com.cc.pom;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import Utility.ExcelData;
import base.Helper;
import base.TestBase;
/*
 * POM class for NormalSingleRoomBookingandverifyRateGridupdatePage
 * @author Rudraksh Aggarwal
 */
public class NormalSingleRoomBookingandverifyRateGridupdatePage extends TestBase {
	
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
	@FindBy(xpath = "(//a[text()='Select'])[1]")
	WebElement selectRoom;
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
	@FindBy(xpath = "(//input[@type='checkbox'])[last()]")
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
	@FindBy(xpath = "(//span[contains(@class,'circle')])[2]")
	WebElement minusButton;
	@FindBy(xpath = "(//a[text()='Select'])[2]")
	WebElement selectRoom2;
	
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
		Helper.explicit(ccNewRes, 60);
		ccNewRes.click();
		Helper.implict(5);
		return null;
	}
	
	/*
	 * Method to select Rate Plan Rate grid update
	 */
	public NormalSingleRoomBookingandverifyRateGridupdatePage selectRatePlanRateGrid() {
		Helper.sleep(2000);
		String a = (ExcelData.CC_getCellData("NormalSingleRoomBookingData", "RoomAvailable", 3));
		WebElement rp = getDriver().findElement(By.xpath("//a[text()='" + a + "']/following::input[2]"));
		rp.click();
		return null;
	}
	
	/*
	 * Method to click select ALL Room Type
	 */
	public NormalSingleRoomBookingandverifyRateGridupdatePage selectALLRoomType() {
		selectRoomTypedropdwn.click();
		Helper.implict(3);
		selectAllRoomType.click();
		Helper.implict(3);
		System.out.println("All Rooms selected");
		return null;
	}
	
	/*
	 * Method to click select Date Range TC01
	 */
	public NormalSingleRoomBookingandverifyRateGridupdatePage selectDateRangeTC01() {
		Helper.implict(3);
		// TO GET CURRENT DATE
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/YY");
		Date date = new Date();
		String currentDate = dateFormat.format(date);
		System.out.println("current day date for admin TC01 " + currentDate);
		startdate.sendKeys(currentDate);
		Helper.implict(3);
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
		Helper.implict(3);
		// TO GET CURRENT DATE
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/YY");
		Date date = new Date();
		String currentDate = dateFormat.format(date);
		System.out.println("current day date for admin TC02 " + currentDate);
		startdate.sendKeys(currentDate);
		Helper.implict(3);
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
		roomsAvailable.sendKeys(ExcelData.CC_getCellData("NormalSingleRoomBookingData", "RoomAvailable", 2));
	}
	
	/*
	 * Method to click Quick Entry Button
	 */
	public NormalSingleRoomBookingandverifyRateGridupdatePage clickQuickEntrybutton() {
		quickEntryBtn.click();
		Helper.implict(3);
		return null;
	}
	
	/*
	 * Method to click update Button
	 */
	public NormalSingleRoomBookingandverifyRateGridupdatePage clickUpdateButton() {
		updateButton.click();
		Helper.implict(3);
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
			e.printStackTrace();
		}
		return null;
	}
	
	/*
	 * Method to select open yield control
	 */
	public NormalSingleRoomBookingandverifyRateGridupdatePage openYieldControls() {
		openYieldControl.click();
		Helper.implict(3);
		return null;
	}
	
	/*
	 * Method to enter CC user
	 */
	public NormalSingleRoomBookingandverifyRateGridupdatePage enterCCuser() {
		ccUser.sendKeys(ExcelData.CC_getCellData("NormalSingleRoomBookingData", "CCUser", 2));
		okButton.click();
		Helper.implict(5);
		return null;
	}
	
	/*
	 * Method to click select Date Range cc TC01
	 */
	public NormalSingleRoomBookingandverifyRateGridupdatePage selectDateRangeCCTC01() {
		// TO GET CURRENT DATE
		DateFormat dateFormat = new SimpleDateFormat("YYYY-MM-dd");
		Date date = new Date();
		String currentDate = dateFormat.format(date);
		System.out.println("current day date for cc " + currentDate);
		// TO GET NEXT DAY DATE
		String nextDaydate = "";
		Date date2 = new Date();
		Calendar cal = Calendar.getInstance();
		cal.setTime(date2);
		cal.add(Calendar.DAY_OF_YEAR, +1);
		Date after = cal.getTime();
		SimpleDateFormat formatter = new SimpleDateFormat("YYYY-MM-dd");
		nextDaydate = formatter.format(after);
		System.out.println("next day date for cc " + nextDaydate);
		Helper.explicit(checkInDate, 10);
		checkInDate.sendKeys(currentDate);
		checkInDate.click();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		checkOutDate.click();
		checkOutDate.clear();
		checkOutDate.sendKeys(nextDaydate);
		return null;
	}
	
	/*
	 * Method to click select Date Range cc TC02
	 */
	public NormalSingleRoomBookingandverifyRateGridupdatePage selectDateRangeCCTC02() {
		// TO GET CURRENT DATE
		DateFormat dateFormat = new SimpleDateFormat("YYYY-MM-dd");
		Date date = new Date();
		String currentDate = dateFormat.format(date);
		System.out.println("current day date for cc " + currentDate);
		// TO GET DATE AFTER 7 DAYS
		String sevenDaydate = "";
		Date date2 = new Date();
		Calendar cal = Calendar.getInstance();
		cal.setTime(date2);
		cal.add(Calendar.DAY_OF_YEAR, +7);
		Date after = cal.getTime();
		SimpleDateFormat formatter = new SimpleDateFormat("YYYY-MM-dd");
		sevenDaydate = formatter.format(after);
		System.out.println("DATE AFTER 7 DAYS for cc " + sevenDaydate);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		checkInDate.sendKeys(currentDate);
		checkInDate.click();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
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
		Helper.implict(3);
		return null;
	}
	
	/*
	 * Method to verify Room Availibilty
	 */
	public boolean verifyRoomsAvailibilty() {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
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
	 * Method to select Room after modify
	 */
	public void selectRoomModify() {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		String a = (ExcelData.CC_getCellData("NormalSingleRoomBookingData", "RoomNameModify", 2));
		System.out.println(a);
		WebElement room = getDriver().findElement(By.xpath("(//*[text()='" + a + "'])[1]/preceding::input[1]"));
		room.click();
		Helper.implict(1);
		selectRoom.click();
	}
	
	/*
	 * Method to select Standard Room
	 */
	public void selectRoom() {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		String a = (ExcelData.CC_getCellData("NormalSingleRoomBookingData", "RoomName", 2));
		System.out.println(a);
		WebElement room = getDriver().findElement(By.xpath("(//*[text()='" + a + "'])[1]/preceding::input[1]"));
		room.click();
		Helper.implict(1);
		selectRoom.click();
	}
	
	/*
	 * Method to select Room for TC08 modify bookings from confirmation page
	 */
	public void selectRoomTC08mbcp() {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		String a = (ExcelData.CC_getCellData("NormalSingleRoomBookingData", "RoomNameModify", 2));
		System.out.println(a);
		String b = (ExcelData.CC_getCellData("NormalSingleRoomBookingData", "RoomName", 2));
		System.out.println(b);
		WebElement room = getDriver().findElement(By.xpath("(//*[text()='" + a + "'])[1]/preceding::input[1]"));
		WebElement room2 = getDriver().findElement(By.xpath("(//*[text()='" + b + "'])[1]/preceding::input[1]"));
		minusButton.click();
		room2.click();// for deselect standard room checkbox
		room.click(); // for classic room checkbox
		Helper.implict(1);
		selectRoom2.click();
	}
	
	/*
	 * Method to click payment Button
	 */
	public NormalSingleRoomBookingandverifyRateGridupdatePage clickpaymentButton() {
		paymentButton.click();
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e1) {
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
		fName.sendKeys(ExcelData.CC_getCellData("NormalSingleRoomBookingData", "FirstName", 2));
		Helper.implict(1);
		lName.clear();
		lName.sendKeys(ExcelData.CC_getCellData("NormalSingleRoomBookingData", "LastName", 2));
		Helper.implict(1);
		email.clear();
		email.sendKeys(ExcelData.CC_getCellData("NormalSingleRoomBookingData", "Email", 2));
		return null;
	}
	
	/*
	 * Method to input Card Details TC01
	 * 
	 */
	public NormalSingleRoomBookingandverifyRateGridupdatePage inputCardDetailsTC01() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		cardName.clear();
		cardName.sendKeys(ExcelData.CC_getCellData("NormalSingleRoomBookingData", "CardName", 2));
		cardNumber.sendKeys(ExcelData.CC_getCellData("NormalSingleRoomBookingData", "CardNumber1", 2));
		cardNumber.sendKeys(ExcelData.CC_getCellData("NormalSingleRoomBookingData", "CardNumber2", 2));
		cardNumber.sendKeys(ExcelData.CC_getCellData("NormalSingleRoomBookingData", "CardNumber3", 2));
		cardNumber.sendKeys(ExcelData.CC_getCellData("NormalSingleRoomBookingData", "CardNumber4", 2));
		Select d = new Select(expiryYearDropdown);
		d.selectByVisibleText(" 2028");
		Helper.implict(1);
		Select a = new Select(expiryMonthDropdown);
		a.selectByValue("12");
		Helper.implict(1);
		secCode.sendKeys(ExcelData.CC_getCellData("NormalSingleRoomBookingData", "SecurityCode", 2));
		Helper.implict(1);
		return null;
	}
	
	/*
	 * Method to input Billing Address
	 * 
	 */
	public NormalSingleRoomBookingandverifyRateGridupdatePage inputBillingAddress() {
		countryDropdown.click();
		country.click();
		Helper.implict(1);
		add1.clear();
		add1.sendKeys(ExcelData.CC_getCellData("NormalSingleRoomBookingData", "Addressline1", 2));
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		city.clear();
		city.sendKeys(ExcelData.CC_getCellData("NormalSingleRoomBookingData", "City", 2));
		Helper.implict(1);
		Select d = new Select(state);
		d.selectByVisibleText("Delhi");
		Helper.explicit(zipCode,2);
		zipCode.clear();
		zipCode.sendKeys(ExcelData.CC_getCellData("NormalSingleRoomBookingData", "Zipcode", 2));
		Helper.implict(1);
		phNum.clear();
		phNum.sendKeys(ExcelData.CC_getCellData("NormalSingleRoomBookingData", "PhoneNumber", 2));
		return null;
	}
	
	/*
	 * Method to select Terms And Conditon Checkbox
	 * 
	 */
	public NormalSingleRoomBookingandverifyRateGridupdatePage selectTermsAndConditonCheckbox() {
		termsandconditionCheckbox.click();
		Helper.implict(1);
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
			e.printStackTrace();
		}
		return null;
	}
	
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
			if (rga.equalsIgnoreCase(ExcelData.CC_getCellData("NormalSingleRoomBookingData", "ExpectedAvailTC01", 2))) {
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
							ExcelData.CC_getCellData("NormalSingleRoomBookingData", "ExpectedAvailTC01", 2))) {
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