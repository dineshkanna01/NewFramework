package com.cc.pom;

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
 * POM class for ModifyBookingfromconfirmationpagePage
 * @author Rudraksh Aggarwal
 */
public class ModifyBookingfromconfirmationpagePage extends TestBase {

	public static WebDriver driver;

	@FindBy(xpath = "//a[text()='Modify']")
	WebElement modifyButton;
	
	@FindBy(xpath = "//div[text()='Cancel']")
	WebElement cancelButton;
	
	@FindBy(xpath = "//button[text()='Yes']")
	WebElement yesButtonModify;
	
	@FindBy(xpath = "//*[@name='confirmationNumber']")
	WebElement confirmationNo;
	
	@FindBy(name = "quickSearchResults")
	WebElement quickSearchButton;
	
	@FindBy(xpath = "//thead[@class=\"confirmation-table-head\"]/tr/td[last()]/dl/dt")
	WebElement confirmcodeHeading;
	
	@FindBy(xpath = "//thead[@class=\"confirmation-table-head\"]/tr/td[last()]/dl/dd")
	WebElement confirmcode;
	
	@FindBy(xpath = "//a[text()='Edit search']")
	WebElement editSearchButton;
	
	@FindBy(xpath = "(//*[text()='Room'])[1]")
	WebElement confirmRoomHeading;
	
	@FindBy(xpath = "(//*[text()='Room'])[1]/following::dd[1]")
	WebElement confirmRoomType;
	
	@FindBy(xpath = "//a[contains(@href,'confirmationCode')]")
	WebElement reportCC;
	
	@FindBy(xpath = "//*[text()='Dates']/following::div[1]")
	WebElement cpDates;
	
	@FindBy(name = "start")
	WebElement checkInDate;
	
	@FindBy(name = "end")
	WebElement checkOutDate;
	
	@FindBy(xpath = "//*[text()='Adults']")
	WebElement adults;
	
	@FindBy(xpath = "//*[text()='Adults']/following::dd[1]")
	WebElement noOfAdults;
	
	@FindBy(xpath = "//*[text()='Adults']")
	WebElement children;
	
	@FindBy(xpath = "//*[text()='Children']/following::dd[1]")
	WebElement noOfChildren;
	
	@FindBy(xpath = "(//select[contains(@class,'rooms-adults')])[last()]")
	WebElement adultDropdown;
	
	@FindBy(xpath = "//button[@data-target=\"#rooms-modal\"][last()]")
	WebElement childDropdown1;
	
	@FindBy(xpath = "(//select[contains(@class,'rooms-children')])[1]")
	WebElement childDropdown2;
	
	@FindBy(xpath = "(//select[contains(@class,'rooms-children')])[2]")
	WebElement childDropdown3;
	
	@FindBy(xpath = "(//button[text()='Done'])[1]")
	WebElement doneButton;
	
	@FindBy(xpath = "(//*[text()='Guest Details'])[1]/following::dd[1]")
	WebElement guestDetails;
	
	@FindBy(id = "customer-confirm-first-name")
	WebElement fName;
	
	@FindBy(id = "customer-last-name")
	WebElement lName;
	
	@FindBy(id = "customer-confirm-email")
	WebElement email;
	
	@FindBy(xpath = "(//*[text()='Bed Type Preference'])[1]/following::dd[1]")
	WebElement bedType;
	
	@FindBy(xpath = "//input[@value=\"Recalculate\"]")
	WebElement recalculateButton;
	
	@FindBy(xpath = "//dt[text()='Other services']/following::dd[1]")
	WebElement otherServicesCharge;
	
	@FindBy(xpath = "//button[text()='Edit request']")
	WebElement editReqButton;
	
	@FindBy(xpath = "//button[text()='SAVE']")
	WebElement saveButton;

	public ModifyBookingfromconfirmationpagePage(WebDriver driver) {
		super();
		PageFactory.initElements(driver, this);
	}

	public String UrlTilte() {
		return driver.getTitle();
	}

	/*
	 * Method to modify Booking
	 */
	public ModifyBookingfromconfirmationpagePage modify() {
		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		modifyButton.click();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		yesButtonModify.click();
		try {
			Thread.sleep(7000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return null;
	}

	/*
	 * Method to search Reservation
	 */
	public boolean searchReservation() {
		confirmationNo.sendKeys(ExcelData.CC_getCellData("NormalSingleRoomBookingData", "ConfirmationCode", 2));
		quickSearchButton.click();
		Helper.implict(3);
		try {
			Thread.sleep(1500);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		if (reportCC.isDisplayed()) {
			String rcc = reportCC.getText();
			System.out.println("report cc " + rcc);
			if (rcc.equals(ExcelData.CC_getCellData("NormalSingleRoomBookingData", "ConfirmationCode", 2))) {
				System.out.println("reservation is found in report");
			}
			return true;
		} else {
			System.out.println("NA");
			return false;
		}
	}

	/*
	 * Method to verify Confirmation Code and store it in excel
	 * 
	 */
	public boolean verifyConfirmationCode() {
		Helper.waitVisibility(50,"//thead[@class=\"confirmation-table-head\"]/tr/td[last()]/dl/dt");
		if (confirmcodeHeading.isDisplayed()) {
			String codehead = confirmcodeHeading.getText();
			String code = confirmcode.getText();
			System.out.println(codehead + " is :" + code);
			ExcelData.write_CellData("NormalSingleRoomBookingData", 1, 19, code);
			return true;
		} else {
			System.out.println("NA");
			return false;
		}
	}

	/*
	 * Method to click edit search button
	 */
	public ModifyBookingfromconfirmationpagePage clickEditSearchButton() {
		editSearchButton.click();
		Helper.implict(5);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return null;
	}

	/*
	 * Method to verify Room Type before
	 * 
	 */
	public void verifyRoomTypebefore() {
		String roombe = confirmRoomType.getText();
		System.out.println("room before modification: " + roombe);
		ExcelData.write_CellData("NormalSingleRoomBookingData", 1, 20, roombe);
	}

	/*
	 * Method to verify Room Type after
	 * 
	 */
	public void verifyRoomTypeafter() {
		String roomaf = confirmRoomType.getText();
		System.out.println("room after modification: " + roomaf);
		ExcelData.write_CellData("NormalSingleRoomBookingData", 1, 21, roomaf);
	}

	/*
	 * Method to get Dates before modify
	 */
	public void getDatesBefore() {
		String datesbe = cpDates.getText();
		datesbe =datesbe.toLowerCase();
		System.out.println("Dates before " + datesbe);
		ExcelData.write_CellData("NormalSingleRoomBookingData", 1, 22, datesbe);
	}

	/*
	 * Method to get Dates after modify
	 */
	public void getDatesAfter() {
		String datesaf = cpDates.getText();
		datesaf =datesaf.toLowerCase();
		System.out.println("Dates after " + datesaf);
		ExcelData.write_CellData("NormalSingleRoomBookingData", 1, 23, datesaf);
	}

	/*
	 * Method to verify if dates are modified or not
	 */
	public boolean verifyDatesModify() {
		String b = ExcelData.CC_getCellData("NormalSingleRoomBookingData", "DatesBefore", 2);
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
	 * Method to get no. of adults and children before
	 */
	public void getNumOfAdultsAndChildrenbefore() {
		String nad = noOfAdults.getText();
		String nch = noOfChildren.getText();
		System.out.println("Number of adults and children before modify respectively are: " + nad + " & " + nch);
		ExcelData.write_CellData("NormalSingleRoomBookingData", 1, 24, nad);
		ExcelData.write_CellData("NormalSingleRoomBookingData", 2, 24, nch);
	}

	/*
	 * Method to get no. of adults and children after
	 */
	public void getNumOfAdultsAndChildrenafter() {
		String nad = noOfAdults.getText();
		String nch = noOfChildren.getText();
		System.out.println("Number of adults and children after modify respectively are: " + nad + " & " + nch);
		ExcelData.write_CellData("NormalSingleRoomBookingData", 1, 25, nad);
		ExcelData.write_CellData("NormalSingleRoomBookingData", 2, 25, nch);
	}

	/*
	 * Method to get Guest Details before
	 */
	public void getGuestDetailsbefore() {
		String gd = guestDetails.getText();
		System.out.println("Guest Details before are : " + gd);
		ExcelData.write_CellData("NormalSingleRoomBookingData", 1, 26, gd);
	}

	/*
	 * Method to get Guest Details after
	 */
	public void getGuestDetailsafter() {
		String gd = guestDetails.getText();
		System.out.println("Guest Details after are : " + gd);
		ExcelData.write_CellData("NormalSingleRoomBookingData", 1, 27, gd);
	}

	/*
	 * Method to input Guest Details TC04
	 * 
	 */
	public ModifyBookingfromconfirmationpagePage inputGuestDetailsTC04() {
		fName.clear();
		fName.sendKeys(ExcelData.CC_getCellData("ModifyBookingConfirmationPage", "FirstName", 2));
		Helper.implict(1);
		lName.clear();
		lName.sendKeys(ExcelData.CC_getCellData("ModifyBookingConfirmationPage", "LastName", 2));
		Helper.implict(1);
		email.clear();
		email.sendKeys(ExcelData.CC_getCellData("NormalSingleRoomBookingData", "Email", 2));
		return null;
	}

	/*
	 * Method to verify if Adults and Children are modified or not
	 */
	public boolean verifyAdultsandChildrenModify() {
		String a = ExcelData.CC_getCellData("NormalSingleRoomBookingData", "NoOfAdultAndChildBefore", 2); // adults be
		String b = ExcelData.CC_getCellData("NormalSingleRoomBookingData", "NoOfAdultAndChildBefore", 3);// child be
		String c = a + b;
		System.out.println(c);
		String x = ExcelData.CC_getCellData("NormalSingleRoomBookingData", "NoOfAdultAndChildAfter", 2); // adults be
		String y = ExcelData.CC_getCellData("NormalSingleRoomBookingData", "NoOfAdultAndChildAfter", 3);// child be
		String z = x + y;
		System.out.println(z);
		if (c.equalsIgnoreCase(z)) {
			System.out.println("Num of Adults and Children are not modified");
			return false;
		} else {
			System.out.println("Num of Adults and Children are modified");
			return true;
		}
	}

	/*
	 * Method to verify if Guest Details are modified or not
	 */
	public boolean verifyGuestDetailsModify() {
		String a = ExcelData.CC_getCellData("NormalSingleRoomBookingData", "GuestDetailsBefore", 2);
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
	 * Method to modfiy no. of adults and children
	 */
	public void modifyNumOfAdultsAndChildren() {
		Select ad = new Select(adultDropdown);
		ad.selectByVisibleText(ExcelData.CC_getCellData("ModifyBookingConfirmationPage", "Adults", 2));
		Helper.implict(1);
		childDropdown1.click();
		try {
			Thread.sleep(1500);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		Select cd1 = new Select(childDropdown2);
		cd1.selectByVisibleText(ExcelData.CC_getCellData("ModifyBookingConfirmationPage", "Children", 2));
		Helper.implict(3);
		Select cd2 = new Select(childDropdown3);
		cd2.selectByVisibleText(ExcelData.CC_getCellData("ModifyBookingConfirmationPage", "Child", 2));
		Helper.implict(1);
		doneButton.click();
	}

	/*
	 * Method to verify if rooms are modified or not
	 */
	public boolean verifyRoomModify() {
		String b = ExcelData.CC_getCellData("NormalSingleRoomBookingData", "RoomBefore", 2);
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
	 * Method to click select Date Range TC03
	 */
	public ModifyBookingfromconfirmationpagePage selectDateRangeCCTC03() {
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
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
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
	public ModifyBookingfromconfirmationpagePage selectDateRangeCCTC02() {
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
		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		checkOutDate.click();
		checkOutDate.clear();
		checkOutDate.sendKeys(nexttonextDaydate);
		return null;
	}

	/*
	 * Method to select King Bed Type
	 */
	public void selectKingBedType() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		List<WebElement> kbt = getDriver().findElements(By.xpath("//*[@type='radio']"));
		for (int i = 0; i < kbt.size(); i++) {
			String value = kbt.get(i).getAttribute("value");
			if (value.equalsIgnoreCase("KBT"))
				kbt.get(i).click();
			Helper.implict(3);
		}
	}

	/*
	 * Method to select Queen Bed Type
	 */
	public void selectQueenBedType() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		List<WebElement> kbt = getDriver().findElements(By.xpath("//*[@type='radio']"));
		for (int i = 0; i < kbt.size(); i++) {
			String value = kbt.get(i).getAttribute("value");
			if (value.equalsIgnoreCase("QBT"))
				kbt.get(i).click();
			Helper.implict(3);
		}
	}

	/*
	 * Method to select Classic Bed Type
	 */
	public void selectClassicBedType() {
		List<WebElement> cbt = getDriver().findElements(By.xpath("//*[@type='radio']"));
		for (int i = 0; i < cbt.size(); i++) {
			String value = cbt.get(i).getAttribute("value");
			if (value.equalsIgnoreCase("CBT"))
				cbt.get(i).click();
			Helper.implict(3);
		}
	}

	/*
	 * Method to get Bed Type before
	 */
	public void getBedTypebefore() {
		try {
			Thread.sleep(300);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		String bt = bedType.getText();
		System.out.println("Bed Type before : " + bt);
		ExcelData.write_CellData("NormalSingleRoomBookingData", 1, 28, bt);
	}

	/*
	 * Method to get Bed Type after
	 */
	public void getBedTypeafter() {
		String bt = bedType.getText();
		System.out.println("Bed Type after : " + bt);
		ExcelData.write_CellData("NormalSingleRoomBookingData", 1, 29, bt);
	}

	/*
	 * Method to click Edit Request Button
	 */
	public void clickEditRequestButton() {
		editReqButton.click();
	}

	/*
	 * Method to click Save Button
	 */
	public void clickSaveButton() {
		saveButton.click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	/*
	 * Method to verify if Bed Type is modified or not
	 */
	public boolean verifyBedTypeModify() {
		String a = ExcelData.CC_getCellData("NormalSingleRoomBookingData", "BedTypeBefore", 2);
		String b = ExcelData.CC_getCellData("NormalSingleRoomBookingData", "BedTypeAfter", 2);
		if (a.equalsIgnoreCase(b)) {
			System.out.println("Bed Type is not modified");
			return false;
		} else {
			System.out.println("Bed Type is modified");
			return true;
		}
	}

	/*
	 * Method to select AddOn
	 */
	public void selectAddOn() {
		Helper.implict(3);
		WebElement ao = getDriver().findElement(By.name("addOns_PKG_0"));
		ao.click();
		Helper.implict(1);
		recalculateButton.click();
		Helper.implict(3);
	}

	/*
	 * Method to get Other Services Before
	 */
	public void getOtherServicesBefore() {
		String oscb = otherServicesCharge.getText();
		System.out.println("otherServicesCharge before : " + oscb);
		ExcelData.write_CellData("NormalSingleRoomBookingData", 1, 30, oscb);
	}

	/*
	 * Method to get Other Services after
	 */
	public void getOtherServicesafter() {
		String osca = otherServicesCharge.getText();
		System.out.println("otherServicesCharge after : " + osca);
		ExcelData.write_CellData("NormalSingleRoomBookingData", 1, 31, osca);
	}

	/*
	 * Method to verify if Other services is modified or not
	 */
	public boolean verifyOtherServicesModify() {
		String a = ExcelData.CC_getCellData("NormalSingleRoomBookingData", "OtherServicesBefore", 2);
		String b = ExcelData.CC_getCellData("NormalSingleRoomBookingData", "OtherServicesAfter", 2);
		if (a.equalsIgnoreCase(b)) {
			System.out.println("OtherServices is not modified");
			return false;
		} else {
			System.out.println("OtherServices is modified");
			return true;
		}
	}
}
