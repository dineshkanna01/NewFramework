package com.cc.pom;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.be.pom.JCCBookingsPage;

import Utility.ExcelData;
import base.Helper;
import base.TestBase;

/*
 * POM class for ModifyRT3BookingfromCCsiteandviceversaPage
 * @author Rudraksh Aggarwal
 */
public class ModifyRT3BookingfromCCsiteandviceversaPage extends TestBase {

	@FindBy(xpath = "//a[text()='My bookings']")
	WebElement myBookings;
	@FindBy(name = "confirmation_code")
	WebElement ccField;
	@FindBy(name = "email")
	WebElement Email;
	@FindBy(xpath = "(//*[@type='submit'])[1]")
	WebElement lookUp;
	@FindBy(xpath = "//th[@id=\"summary_reservation_confirmation_code\"]/strong")
	WebElement ccBE;
	@FindBy(xpath = "//a[text()='Change reservation']")
	WebElement changeReservation;
	@FindBy(xpath = "//span[text()='Yes']")
	WebElement yesButton;
	@FindBy(xpath = "//td[@headers='summary_reservation_title']")
	WebElement confirmRoomType;
	@FindBy(id = "search_arrival_date")
	WebElement calender;
	@FindBy(xpath = "//strong[contains(@aria-label,'-')]")
	WebElement cpDateBE;
	@FindBy(name = "booking[first_name]")
	WebElement firstName;
	@FindBy(name = "booking[last_name]")
	WebElement lastName;
	@FindBy(id = "booking_email")
	WebElement email;
	@FindBy(xpath = "//td[@headers=\"summary_reservation_guest_details\"]")
	WebElement guestDetailsBE;
	@FindBy(xpath = "//input[@value='PKG']")
	WebElement addOnParking;
	@FindBy(xpath = "//span[text()='Other Services']/following::strong[1]")
	WebElement otherServicesChargeBE;
	@FindBy(xpath = "//dt[text()='Other services']/following::dd[1]")
	WebElement otherServicesChargeCC;
	@FindBy(xpath = "//dt[text()='Grand total']/following::dd[1]")
	WebElement grandTotalCC;
	@FindBy(xpath = "//span[text()='Grand total']/following::strong[1]")
	WebElement grandTotalBE;
	@FindBy(xpath = "//div[@data-search='lookup']")
	WebElement lookupButton;
	@FindBy(xpath = "(//input[@type='email'])[1]")
	WebElement lookupEmail;
	@FindBy(xpath = "//input[@id='lookup-field-confirmationNo']")
	WebElement lookupCCcode;
	@FindBy(xpath = "(//button[text()='Go'])[1]")
	WebElement goButton;
	@FindBy(xpath = "//dt[text()='Reztrip conf code']/following::dd[1]")
	WebElement ccCodeCClookup;
	@FindBy(xpath = "//div[text()='Modify']")
	WebElement modifyButton;
	@FindBy(xpath = "//button[text()='Yes']")
	WebElement yesButtonModify;
	@FindBy(name = "start")
	WebElement checkInDate;
	@FindBy(name = "end")
	WebElement checkOutDate;
	@FindBy(xpath = "//dt[text()='Rate']/following::dd[1]")
	WebElement getRateCCconfirmPage;
	@FindBy(xpath = "//th[text()='Offer']/following::td[1]")
	WebElement getRateBEconfirmPage;

	public ModifyRT3BookingfromCCsiteandviceversaPage(WebDriver driver) {
		super();
		PageFactory.initElements(driver, this);
	}

	public String UrlTilte() {
		return driver.getTitle();
	}

	/*
	 * Method to modify Lookup BE TC01
	 */
	public ModifyRT3BookingfromCCsiteandviceversaPage LookupBE() {
		Helper.explicit(myBookings, 50);
		myBookings.click();
		Email.clear();
		Email.sendKeys(ExcelData.CC_getCellData("NormalSingleRoomBookingData", "Email", 2));
		Helper.implict(1);
		ccField.clear();
		ccField.sendKeys(ExcelData.CC_getCellData("NormalSingleRoomBookingData", "ConfirmationCode", 2));
		Helper.implict(1);
		lookUp.click();
		Helper.sleep(7000);
		return null;
	}

	/*
	 * Method to modify Reservation BE TC01
	 * 
	 */
	public void modifyReservationBE() {
		Helper.explicit(changeReservation, 20);
		changeReservation.click();
		Helper.explicit(yesButton, 20);
		yesButton.click();
	}

	/*
	 * Method to verify Confirmation Code BE and store it in excel
	 * 
	 */
	public boolean verifyConfirmationCodeBE() {
		if (ccBE.isDisplayed()) {
			String code = ccBE.getText();
			System.out.println(code + " :BE");
			ExcelData.write_CellData("NormalSingleRoomBookingData", 1, 37, code);
			return true;
		} else {
			System.out.println("NA");
			return false;
		}
	}

	/*
	 * Method to select room BE
	 * 
	 */
	public void selectroomBE() {
		Helper.sleep(2500);
		String b = (ExcelData.CC_getCellData("NormalSingleRoomBookingData", "RoomName", 2));
		WebElement room = getDriver().findElement(By.xpath("(//*[text()='" + b + "'])[1]"));
		room.click();
	}

	/*
	 * Method to select modified room BE
	 * 
	 */
	public void selectmodifiedroomBE() {
		Helper.sleep(2500);
		String b = (ExcelData.CC_getCellData("NormalSingleRoomBookingData", "RoomNameModify", 2));
		WebElement room = getDriver().findElement(By.xpath("(//*[text()='" + b + "'])[1]"));
		room.click();
	}

	/*
	 * Method to verify Room Type after BE TC01
	 * 
	 */
	public void verifyRoomTypeafterTC01() {
		Helper.sleep(1000);
		try {
			Helper.waitVisibility(30, "//td[@headers='summary_reservation_title']");
			;
			String roomaf = confirmRoomType.getText();
			System.out.println("room after modification: " + roomaf);
			ExcelData.write_CellData("NormalSingleRoomBookingData", 1, 40, roomaf);
		} catch (Exception e) {
			System.out.println("NA");
		}
	}

	/*
	 * Method to get Room Type Before BE
	 * 
	 */
	public void getRoomTypeBeforeBETC06() {
		Helper.sleep(1000);
		try {
			Helper.waitVisibility(30, "//td[@headers='summary_reservation_title']");
			String roombe = confirmRoomType.getText();
			System.out.println("Room Type Before BE: " + roombe);
			ExcelData.write_CellData("NormalSingleRoomBookingData", 1, 39, roombe);
		} catch (Exception e) {
			System.out.println("NA");
		}
	}

	/*
	 * Method to selectDateTC02 booking engine
	 * 
	 */
	public JCCBookingsPage selectDateTC02() {
		Helper.sleep(1000);
		String nextDaydate = "";
		Date date2 = new Date();
		Calendar cal2 = Calendar.getInstance();
		cal2.setTime(date2);
		cal2.add(Calendar.DAY_OF_YEAR, +1);
		Date after2 = cal2.getTime();
		SimpleDateFormat formatter2 = new SimpleDateFormat("MM/dd/YYYY");
		nextDaydate = formatter2.format(after2);
		System.out.println("next Day date BE " + nextDaydate);
		calender.clear();
		calender.sendKeys(nextDaydate);
		Helper.implict(2);
		return null;
	}

	/*
	 * Method to get Dates Before modify BE TC07
	 */
	public void getDatesBeforeBETC07() {
		Helper.sleep(1000);
		try {
			Helper.waitVisibility(30, "//strong[contains(@aria-label,'-')]");
			String datesbe = cpDateBE.getText();
			datesbe = datesbe.toLowerCase();
			System.out.println("Dates Before BE " + datesbe);
			ExcelData.write_CellData("NormalSingleRoomBookingData", 1, 41, datesbe);
		} catch (Exception e) {
			System.out.println("NA");
		}
	}

	/*
	 * Method to get Dates after modify BE TC02
	 */
	public void getDatesAfterBETC02() {
		Helper.sleep(1000);
		Helper.waitVisibility(30, "//strong[contains(@aria-label,'-')]");
		try {
			String datesaf = cpDateBE.getText();
			datesaf = datesaf.toLowerCase();
			System.out.println("Dates after BE " + datesaf);
			ExcelData.write_CellData("NormalSingleRoomBookingData", 1, 42, datesaf);
		} catch (Exception e) {
			System.out.println("NA");
		}
	}

	/*
	 * Method to input Guest Details
	 * 
	 */
	public JCCBookingsPage inputGuestDetailsTC03() {
		firstName.clear();
		firstName.sendKeys(ExcelData.CC_getCellData("ModifyBookingConfirmationPage", "FirstName", 2));
		Helper.implict(1);
		lastName.clear();
		lastName.sendKeys(ExcelData.CC_getCellData("ModifyBookingConfirmationPage", "LastName", 2));
		Helper.implict(1);
		email.clear();
		email.sendKeys(ExcelData.getCellData("JCCBookings", "Email", 2));
		Helper.implict(1);
		return null;
	}

	/*
	 * Method to get Guest Details after BE TC03
	 */
	public void getGuestDetailsafterBETC03() {
		Helper.sleep(1000);
		try {
			Helper.waitVisibility(30, "//td[@headers='summary_reservation_guest_details']");
			String gd = guestDetailsBE.getText();
			String s = gd;
			String[] split = s.split(ExcelData.getCellData("JCCBookings", "Email", 2));
			String stringbeforeEmail = split[0];
			stringbeforeEmail = stringbeforeEmail.replaceAll("\\s+", "");
			System.out.println("Guest Details after BE are : " + stringbeforeEmail);
			ExcelData.write_CellData("NormalSingleRoomBookingData", 1, 44, stringbeforeEmail);
		} catch (Exception e) {
			System.out.println("NA");
		}
	}

	/*
	 * Method to get Guest Details before BE TC08
	 */
	public void getGuestDetailsbeforeBETC08() {
		Helper.sleep(1000);
		try {
			Helper.waitVisibility(30, "//td[@headers='summary_reservation_guest_details']");
			String gd = guestDetailsBE.getText();
			String s = gd;
			String[] split = s.split(ExcelData.getCellData("JCCBookings", "Email", 2));
			String stringbeforeEmail = split[0];
			stringbeforeEmail = stringbeforeEmail.replaceAll("\\s+", "");
			System.out.println("Guest Details before BE are : " + stringbeforeEmail);
			ExcelData.write_CellData("NormalSingleRoomBookingData", 1, 43, stringbeforeEmail);
		} catch (Exception e) {
			System.out.println("NA");
		}
	}

	/*
	 * Method to select AddOn
	 */
	public void selectAddOn() {
		Helper.sleep(2000);
		addOnParking.click();
		Helper.implict(1);
	}

	/*
	 * Method to get Other Services Before TC05
	 */
	public void getOtherServicesBeforeTC05() {
		String oscb = otherServicesChargeCC.getText();
		oscb = oscb.substring(1, oscb.length());
		System.out.println("otherServicesCharge before : " + oscb);
		ExcelData.write_CellData("NormalSingleRoomBookingData", 1, 30, oscb);
	}

	/*
	 * Method to get Other Services after BE TC05
	 */
	public void getOtherServicesafterBETC05() {
		Helper.sleep(1000);
		try {
			Helper.waitVisibility(30, "//span[text()='Other Services']/following::strong[1]");
			String osca = otherServicesChargeBE.getText();
			String s = osca;
			String[] split = s.split(ExcelData.CC_getCellData("rt3bookingcctobeviceversa", "currency", 2), 2);
			String stringafterCurrency = split[1];
			stringafterCurrency = stringafterCurrency.replaceAll("\\s+", "");
			System.out.println("otherServicesCharge after : " + stringafterCurrency);
			ExcelData.write_CellData("NormalSingleRoomBookingData", 1, 31, stringafterCurrency);
		} catch (Exception e) {
			System.out.println("NA");
		}
	}

	/*
	 * Method to get Grand Total Before CC TC04
	 */
	public void getGrandTotalBeforeCCTC04() {
		Helper.sleep(1000);
		try {
			Helper.waitVisibility(30, "//dt[text()='Grand total']/following::dd[1]");
			String gtb = grandTotalCC.getText();
			gtb = gtb.substring(1, gtb.length());
			System.out.println("Grand Total Before : " + gtb);
			ExcelData.write_CellData("NormalSingleRoomBookingData", 1, 45, gtb);
		} catch (Exception e) {
			System.out.println("NA");
		}
	}

	/*
	 * Method to get Grand Total after BE TC04
	 */
	public void getGrandTotalAfterBETC04() {
		Helper.sleep(2000);
		try {
			Helper.waitVisibility(30, "//span[text()='Grand total']/following::strong[1]");
			String gta = grandTotalBE.getText();
			String s = gta;
			String[] split = s.split(ExcelData.CC_getCellData("rt3bookingcctobeviceversa", "currency", 2), 2);
			String stringafterCurrency = split[1];
			stringafterCurrency = stringafterCurrency.replaceAll("\\s+", "");
			System.out.println("Grand Total after : " + stringafterCurrency);
			ExcelData.write_CellData("NormalSingleRoomBookingData", 1, 46, stringafterCurrency);
		} catch (Exception e) {
			System.out.println("NA");
		}
	}

	/*
	 * Method to get Grand Total before BE TC09
	 */
	public void getGrandTotalBeforeBETC09() {
		Helper.sleep(2000);
		try {
			Helper.waitVisibility(30, "//span[text()='Grand total']/following::strong[1]");
			String gtb = grandTotalBE.getText();
			String s = gtb;
			String[] split = s.split(ExcelData.CC_getCellData("rt3bookingcctobeviceversa", "currency", 2), 2);
			String stringafterCurrency = split[1];
			stringafterCurrency = stringafterCurrency.replaceAll("\\s+", "");
			System.out.println("Grand Total before : " + stringafterCurrency);
			ExcelData.write_CellData("NormalSingleRoomBookingData", 1, 47, stringafterCurrency);
		} catch (Exception e) {
			System.out.println("NA");
		}
	}

	/*
	 * Method to get Grand Total After CC TC09
	 */
	public void getGrandTotalAfterCCTC09() {
		String gta = grandTotalCC.getText();
		gta = gta.substring(1, gta.length());
		System.out.println("Grand Total After : " + gta);
		ExcelData.write_CellData("NormalSingleRoomBookingData", 1, 48, gta);
	}

	/*
	 * Method to Booking lookup cc
	 * 
	 */
	public void LookupCC() {
		lookupButton.click();
		lookupEmail.clear();
		lookupEmail.sendKeys(ExcelData.CC_getCellData("NormalSingleRoomBookingData", "Email", 2));
		Helper.implict(1);
		lookupCCcode.clear();
		lookupCCcode.sendKeys(ExcelData.CC_getCellData("NormalSingleRoomBookingData", "CCcodeBE", 2));
		Helper.implict(1);
		goButton.click();
		Helper.clickviewButtonRt3ViceVersa();
		Helper.sleep(7000);
	}

	/*
	 * Method to verify Confirmation Code CCLookup
	 * 
	 */
	public boolean verifyConfirmationCodeCCLookup() {
		if (ccCodeCClookup.isDisplayed()) {
			String code = ccCodeCClookup.getText();
			ExcelData.write_CellData("NormalSingleRoomBookingData", 1, 38, code);
			return true;
		} else {
			System.out.println("NA");
			return false;
		}
	}

	/*
	 * Method to modifyLookupCC
	 * 
	 */
	public void modifyLookupCC() {
		Helper.explicit(modifyButton, 7);
		modifyButton.click();
		Helper.explicit(yesButtonModify, 2);
		yesButtonModify.click();
		Helper.sleep(7000);
	}

	/*
	 * Method to click select Date Range TC02
	 */
	public ModifyBookingfromconfirmationpagePage selectDateRangeCCTC07() {
		// TO GET NEXT TO NEXT DAY DATE
		String nexttonextDaydate = "";
		Date date2 = new Date();
		Calendar cal2 = Calendar.getInstance();
		cal2.setTime(date2);
		cal2.add(Calendar.DAY_OF_YEAR, +2);
		Date after2 = cal2.getTime();
		SimpleDateFormat formatter2 = new SimpleDateFormat("YYYY-MM-dd");
		nexttonextDaydate = formatter2.format(after2);
		System.out.println("next to next Day date " + nexttonextDaydate);
		Helper.explicit(checkOutDate, 30);
		checkOutDate.click();
		checkOutDate.clear();
		checkOutDate.sendKeys(nexttonextDaydate);
		checkOutDate.sendKeys(Keys.ENTER);
		// TO GET NEXT DAY DATE
		String nextDaydate = "";
		Date date = new Date();
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.DAY_OF_YEAR, +1);
		Date after = cal.getTime();
		SimpleDateFormat formatter = new SimpleDateFormat("YYYY-MM-dd");
		nextDaydate = formatter.format(after);
		System.out.println("next day date for cc " + nextDaydate);
		Helper.explicit(checkInDate, 30);
		checkInDate.click();
		checkInDate.clear();
		checkInDate.sendKeys(nextDaydate);
		checkInDate.sendKeys(Keys.ENTER);
		return null;
	}

	/*
	 * Method to verify if rooms are modified or not TC06
	 */
	public boolean verifyRoomModifyTC06() {
		String b = ExcelData.CC_getCellData("NormalSingleRoomBookingData", "RoomBeforeBE", 2);
		String a = ExcelData.CC_getCellData("NormalSingleRoomBookingData", "RoomAfter", 2);
		if (a.equalsIgnoreCase(b)) {
			System.out.println("rooms are not modified");
			return false;
		} else {
			System.out.println("rooms are modified");
			return true;
		}
	}

	/*
	 * Method to verify if rooms are modified or not
	 */
	public boolean verifyRoomModify() {
		String b = ExcelData.CC_getCellData("NormalSingleRoomBookingData", "RoomBefore", 2);
		String a = ExcelData.CC_getCellData("NormalSingleRoomBookingData", "RoomAfterBE", 2);
		if (a.equalsIgnoreCase(b)) {
			System.out.println("rooms are not modified");
			return false;
		} else {
			System.out.println("rooms are modified");
			return true;
		}
	}

	/*
	 * Method to verify if dates are modified or not TC07
	 */
	public boolean verifyDatesModifyTC07() {
		String b = ExcelData.CC_getCellData("NormalSingleRoomBookingData", "DatesBeforeBE", 2);
		String a = ExcelData.CC_getCellData("NormalSingleRoomBookingData", "DatesAfter", 2);
		if (a.equalsIgnoreCase(b)) {
			System.out.println("Dates are not modified");
			return false;
		} else {
			System.out.println("Dates are modified");
			return true;
		}
	}

	/*
	 * Method to verify if dates are modified or not TC02
	 */
	public boolean verifyDatesModifyTC02() {
		String b = ExcelData.CC_getCellData("NormalSingleRoomBookingData", "DatesBefore", 2);
		String a = ExcelData.CC_getCellData("NormalSingleRoomBookingData", "DatesAfterBE", 2);
		if (a.equalsIgnoreCase(b)) {
			System.out.println("Dates are not modified");
			return false;
		} else {
			System.out.println("Dates are modified");
			return true;
		}
	}

	/*
	 * Method to verify if Guest Details are modified or not TC03
	 */
	public boolean verifyGuestDetailsModifyTC03() {
		String a = ExcelData.CC_getCellData("NormalSingleRoomBookingData", "GuestDetailsBefore", 2);
		String b = ExcelData.CC_getCellData("NormalSingleRoomBookingData", "GuestDetailsAfterBE", 2);
		if (a.equalsIgnoreCase(b)) {
			System.out.println("Guest Details are not modified");
			return false;
		} else {
			System.out.println("Guest Details are modified");
			return true;
		}
	}

	/*
	 * Method to verify if Other services is modified or not TC04
	 */
	public boolean verifyOtherServicesModifyTC04() {
		String a = ExcelData.CC_getCellData("NormalSingleRoomBookingData", "GrandTotalBeforeCC", 2);
		String b = ExcelData.CC_getCellData("NormalSingleRoomBookingData", "GrandTotalAfterBE", 2);
		if (a.equalsIgnoreCase(b)) {
			System.out.println("OtherServices is not modified");
			return false;
		} else {
			System.out.println("OtherServices is modified");
			return true;
		}
	}

	/*
	 * Method to verify if Other services is modified or not TC09
	 */
	public boolean verifyOtherServicesModifyTC09() {
		String a = ExcelData.CC_getCellData("NormalSingleRoomBookingData", "GrandTotalBeforeBE", 2);
		String b = ExcelData.CC_getCellData("NormalSingleRoomBookingData", "GrandTotalAfterCC", 2);
		if (a.equalsIgnoreCase(b)) {
			System.out.println("OtherServices is not modified");
			return false;
		} else {
			System.out.println("OtherServices is modified");
			return true;
		}
	}

	/*
	 * Method to verify if Guest Details are modified or not TC08
	 */
	public boolean verifyGuestDetailsModifyTC08() {
		String a = ExcelData.CC_getCellData("NormalSingleRoomBookingData", "GuestDetailsBeforeBE", 2);
		String b = ExcelData.CC_getCellData("NormalSingleRoomBookingData", "GuestDetailsAfter", 2);
		if (a.equalsIgnoreCase(b)) {
			System.out.println("Guest Details are not modified");
			return false;
		} else {
			System.out.println("Guest Details are modified");
			return true;
		}
	}

	/*
	 * Method to select Rate Plan BE
	 * 
	 */
	public JCCBookingsPage selectRatePlanBE() {
		String b = (ExcelData.CC_getCellData("rt3bookingcctobeviceversa", "RatePlanName", 2));
		WebElement rateplan = getDriver().findElement(By.xpath("//strong[text()='" + b + "']"));
		rateplan.click();
		Helper.implict(1);
		return null;
	}

	/*
	 * Method to get Rate Plan Before CC TC11
	 */
	public void getRatePlanBeforeCCTC11() {
		String rpb = getRateCCconfirmPage.getText();
		System.out.println("Rate Plan Before CC : " + rpb);
		ExcelData.write_CellData("NormalSingleRoomBookingData", 1, 49, rpb);
	}

	/*
	 * Method to get Rate Plan After BE TC11
	 */
	public void getRatePlanAfterBETC11() {
		Helper.sleep(2000);
		try {
			Helper.waitVisibility(30, "//th[text()='Offer']/following::td[1]");
			String rpb = getRateBEconfirmPage.getText();
			System.out.println("Rate Plan after BE : " + rpb);
			ExcelData.write_CellData("NormalSingleRoomBookingData", 1, 50, rpb);
		} catch (Exception e) {
			System.out.println("NA");
		}
	}

	/*
	 * Method to verify if Rate Plan is modified or not TC11
	 */
	public boolean verifyRatePlanModifyTC11() {
		String a = ExcelData.CC_getCellData("NormalSingleRoomBookingData", "RatePlanBeforeCC", 2);
		String b = ExcelData.CC_getCellData("NormalSingleRoomBookingData", "RatePlanAfterBE", 2);
		if (a.equalsIgnoreCase(b)) {
			System.out.println("Rate Plan is not modified");
			return false;
		} else {
			System.out.println("Rate Plan is modified");
			return true;
		}
	}
}
