package com.cc.pom;

import base.Helper;
import base.TestBase;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import Utility.ExcelData;

/*
 * POM class for ModifybookingusingLookupPage
 * @author Rudraksh Aggarwal
 */
public class ModifybookingusingLookupPage extends TestBase {

	public static WebDriver driver;

	@FindBy(xpath = "//thead[@class=\"confirmation-table-head\"]/tr/td[last()]/dl/dd")
	WebElement confirmcode;
	@FindBy(xpath = "//div[text()='Cancel']")
	WebElement cancelButton;
	@FindBy(xpath = "//div[contains(@ng-click,'summaryCtrl.initiateCancel')]")
	WebElement cancelButton1;
	@FindBy(xpath = "//div[text()='Modify']")
	WebElement modifyButton;
	@FindBy(xpath = "//button[text()='Yes']")
	WebElement yesButtonModify;
	@FindBy(xpath = "//button[contains(@class,'btn-success')]")
	WebElement yesButtonCancel;
	@FindBy(xpath = "//*[@name='confirmationNumber']")
	WebElement confirmationNo;
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
	@FindBy(id = "lookup-field-lastName")
	WebElement lookupLName;
	@FindBy(id = "lookup-field-arrival-date")
	WebElement lookupDate;
	@FindBy(id = "lookup-field-creditcard")
	WebElement ccDig;
	@FindBy(xpath = "(//button[text()='Go'])[1]")
	WebElement goButton;
	@FindBy(xpath = "//div[text()='Reservation Cancelled']")
	WebElement reservationCancelMsg;
	@FindBy(xpath = "//a[text()='Edit search']")
	WebElement editSearchButton;
	@FindBy(xpath = "//*[@id='13' and text()='Reports']")
	WebElement reports;
	@FindBy(xpath = "//*[contains(@href,'quickSearch')]")
	WebElement searchReservationReport;
	@FindBy(name = "quickSearchResults")
	WebElement quickSearchButton;
	@FindBy(xpath = "//span[text()='Sorry, there are no reservations matching your search criteria']")
	WebElement noResFoundMsg;
	@FindBy(xpath = "//div[contains(@class,'confirmation-number')]")
	WebElement conNo;
	@FindBy(xpath = "(//span[@class='announcement-text'])[last()]")
	WebElement announcementText;
	@FindBy(xpath = "//button[text()='View']")
	WebElement viewButton;
	@FindBy(xpath = "(//*[text()='Guest Details'])[1]/following::dd[1]")
	WebElement guestDetails;
	@FindBy(id = "customer-confirm-first-name")
	WebElement fName;
	@FindBy(id = "customer-last-name")
	WebElement lName;
	@FindBy(id = "customer-confirm-email")
	WebElement email;
	@FindBy(xpath = "//button[text()='Edit']")
	WebElement editButton;
	@FindBy(id = "edit-fName")
	WebElement editFname;
	@FindBy(id = "edit-lName")
	WebElement editLname;
	@FindBy(xpath = "//button[text()='Save']")
	WebElement savebutton;
	@FindBy(xpath = "//button[text()='New Reservation']")
	WebElement ccNewRes;
	@FindBy(xpath = "(//span[contains(@class,'circle')])[2]")
	WebElement minusButton;
	@FindBy(xpath = "(//a[text()='Select'])[2]")
	WebElement selectRoom2;

	public ModifybookingusingLookupPage(WebDriver driver) {
		super();
		PageFactory.initElements(driver, this);
	}

	public String UrlTilte() {
		return driver.getTitle();
	}

	/*
	 * Method to edit guest details lookup
	 * 
	 */
	public void editGuestDetailslookup() {
		editButton.click();
		Helper.implict(3);
//		editFname.clear();
//		editFname.sendKeys(ExcelData.CC_getCellData("ModifyBookingConfirmationPage", "FirstName", 2));
//		Helper.implict(1);
//		editLname.click();
//		editLname.sendKeys(ExcelData.CC_getCellData("ModifyBookingConfirmationPage", "LastName", 2));
		savebutton.click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e1) {
			System.out.println("NA");
		}
	}

	/*
	 * Method to modify Booking TC01
	 * 
	 */
	public void ModifyBookingLookupTC01() {
		lookupButton.click();
		lookupEmail.clear();
		lookupEmail.sendKeys(ExcelData.CC_getCellData("NormalSingleRoomBookingData", "Email", 2));
		Helper.implict(1);
		lookupCCcode.clear();
		lookupCCcode.sendKeys(ExcelData.CC_getCellData("NormalSingleRoomBookingData", "ConfirmationCode", 2));
		Helper.implict(1);
		goButton.click();
		Helper.clickviewButton();
		Helper.explicit(modifyButton, 7);
		modifyButton.click();
		Helper.explicit(yesButtonModify, 2);
		yesButtonModify.click();
		try {
			Thread.sleep(7000);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
	}

	/*
	 * Method to modify Booking TC02
	 * 
	 */
	public void ModifyBookingLookupTC02() {
		lookupButton.click();
		lookupEmail.clear();
		lookupEmail.sendKeys(ExcelData.CC_getCellData("NormalSingleRoomBookingData", "Email", 2));
		Helper.implict(1);
		lookupLName.clear();
		lookupLName.sendKeys(ExcelData.CC_getCellData("NormalSingleRoomBookingData", "LookUpLName", 2));
		Helper.implict(1);
		goButton.click();
		Helper.clickviewButton();
		Helper.explicit(modifyButton, 7);
		modifyButton.click();
		Helper.explicit(yesButtonModify, 2);
		yesButtonModify.click();
		try {
			Thread.sleep(7000);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
	}

	/*
	 * Method to modify Booking TC03
	 * 
	 */
	public void ModifyBookingLookupTC03() {

		// TO GET CURRENT DATE
		DateFormat dateFormat = new SimpleDateFormat("YYYY-MM-dd");
		Date date = new Date();
		String CheckInDate = dateFormat.format(date);
		System.out.println("current day date for cc Lookup " + CheckInDate);

		lookupButton.click();
		lookupEmail.clear();
		lookupEmail.sendKeys(ExcelData.CC_getCellData("NormalSingleRoomBookingData", "Email", 2));
		Helper.implict(1);
		lookupDate.clear();
		lookupDate.sendKeys(CheckInDate);
		Helper.implict(1);
		goButton.click();
		Helper.clickviewButton();
		Helper.explicit(modifyButton, 7);
		modifyButton.click();
		Helper.explicit(yesButtonModify, 2);
		yesButtonModify.click();
		try {
			Thread.sleep(7000);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
	}

	/*
	 * Method to modify Booking TC04
	 * 
	 */
	public void ModifyBookingLookupTC04() {

		lookupButton.click();
		lookupEmail.clear();
		lookupEmail.sendKeys(ExcelData.CC_getCellData("NormalSingleRoomBookingData", "Email", 2));
		Helper.implict(1);
		ccDig.clear();
		ccDig.sendKeys(ExcelData.CC_getCellData("NormalSingleRoomBookingData", "CardNumber4", 2));
		Helper.implict(1);
		goButton.click();
		Helper.clickviewButton();
		Helper.explicit(modifyButton, 7);
		modifyButton.click();
		Helper.explicit(yesButtonModify, 2);
		yesButtonModify.click();
		try {
			Thread.sleep(7000);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
	}

	/*
	 * Method to modify Booking TC08
	 * 
	 */
	public void ModifyBookingLookupTC08() {

		lookupButton.click();
		lookupLName.clear();
		lookupLName.sendKeys(ExcelData.CC_getCellData("NormalSingleRoomBookingData", "LookUpLName", 2));
		Helper.implict(1);
		ccDig.clear();
		ccDig.sendKeys(ExcelData.CC_getCellData("NormalSingleRoomBookingData", "CardNumber4", 2));
		Helper.implict(1);
		goButton.click();
		Helper.clickviewButton();
		Helper.explicit(modifyButton, 7);
		modifyButton.click();
		Helper.explicit(yesButtonModify, 2);
		yesButtonModify.click();
		try {
			Thread.sleep(7000);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
	}

	/*
	 * Method to click New Reservation
	 */
	public NormalSingleRoomBookingandverifyRateGridupdatePage clickNewReservation() {
		ccNewRes.click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return null;
	}

	/*
	 * Method to input Guest Details TC01
	 * 
	 */
	public ModifyBookingfromconfirmationpagePage inputGuestDetailsTC01() {
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
	 * Method to input Guest Details TC02
	 * 
	 */
	public ModifyBookingfromconfirmationpagePage inputGuestDetailsTC02() {
		fName.clear();
		fName.sendKeys(ExcelData.CC_getCellData("ModifyBookingLookup", "FirstNameTC02", 2));
		Helper.implict(1);
		lName.clear();
		lName.sendKeys(ExcelData.CC_getCellData("ModifyBookingLookup", "LastNameTC02", 2));
		Helper.implict(1);
		email.clear();
		email.sendKeys(ExcelData.CC_getCellData("NormalSingleRoomBookingData", "Email", 2));
		return null;
	}

	/*
	 * Method to input Guest Details TC03
	 * 
	 */
	public ModifyBookingfromconfirmationpagePage inputGuestDetailsTC03() {
		fName.clear();
		fName.sendKeys(ExcelData.CC_getCellData("ModifyBookingLookup", "FirstNameTC03", 2));
		Helper.implict(1);
		lName.clear();
		lName.sendKeys(ExcelData.CC_getCellData("ModifyBookingLookup", "LastNameTC03", 2));
		Helper.implict(1);
		email.clear();
		email.sendKeys(ExcelData.CC_getCellData("NormalSingleRoomBookingData", "Email", 2));
		return null;
	}

	/*
	 * Method to input Guest Details TC04
	 * 
	 */
	public ModifyBookingfromconfirmationpagePage inputGuestDetailsTC04() {
		fName.clear();
		fName.sendKeys(ExcelData.CC_getCellData("ModifyBookingLookup", "FirstNameTC04", 2));
		Helper.implict(1);
		lName.clear();
		lName.sendKeys(ExcelData.CC_getCellData("ModifyBookingLookup", "LastNameTC04", 2));
		Helper.implict(1);
		email.clear();
		email.sendKeys(ExcelData.CC_getCellData("NormalSingleRoomBookingData", "Email", 2));
		return null;
	}

	/*
	 * Method to select Reports
	 */
	public CancelBookingfromconfirmationpagePage selectReports() {
		reports.click();
		Helper.implict(3);
		return null;
	}

	/*
	 * Method to select Search ReservationReport
	 */
	public CancelBookingfromconfirmationpagePage selectSearchReservationReport() {
		searchReservationReport.click();
		Helper.implict(3);
		return null;
	}

	/*
	 * Method to get Guest Details Last Name
	 */
	public void getGuestDetailsLName() {
		String gd = guestDetails.getText();
		String parts[] = gd.split(" ", 2);
		System.out.println(String.format("Fname: %s, Lname: %s", parts[0], parts[1]));
		System.out.println("Guest Details Last Name is: " + parts[1]);
		ExcelData.write_CellData("NormalSingleRoomBookingData", 1, 32, parts[1]);
	}

	/*
	 * Method to click LookUp
	 * 
	 */
	public void clickLookUp() {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		lookupButton.click();
	}

	/*
	 * Method to select Room for TC06 modify bookings from confirmation page
	 */
	public void selectRoomTC06mblp() {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		String a = (ExcelData.CC_getCellData("NormalSingleRoomBookingData", "RoomName", 2));
		System.out.println(a);
		String b = (ExcelData.CC_getCellData("NormalSingleRoomBookingData", "RoomNameModify", 2));
		System.out.println(b);
		WebElement room = getDriver().findElement(By.xpath("(//*[text()='" + a + "'])[1]/preceding::input[1]"));
		WebElement room2 = getDriver().findElement(By.xpath("(//*[text()='" + b + "'])[1]/preceding::input[1]"));
		minusButton.click();
		room2.click();// for deselect classic room checkbox
		room.click(); // for Standard room checkbox
		Helper.implict(1);
		selectRoom2.click();
	}

	/*
	 * Method to verify Booking TC09
	 * 
	 */
	public boolean verifyBookingTC09() {
		lookupButton.click();
		lookupEmail.clear();
		lookupEmail.sendKeys(ExcelData.CC_getCellData("NormalSingleRoomBookingData", "Email", 2));
		Helper.implict(1);
		ccDig.clear();
		ccDig.sendKeys("4141");
		Helper.implict(1);
		goButton.click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		if (announcementText.isDisplayed()) {
			String code2 = announcementText.getText();
			System.out.println("Error message for TC09: " + code2);
			return true;
		} else {
			System.out.println("NA");
			return false;
		}
	}
}
