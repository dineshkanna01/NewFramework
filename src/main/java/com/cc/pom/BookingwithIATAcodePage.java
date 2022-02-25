package com.cc.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utility.ExcelData;
import base.Helper;
import base.TestBase;

/*
 *POM class for BookingwithIATAcodePage
 * @author Rudraksh Aggarwal
 */
public class BookingwithIATAcodePage extends TestBase {

	@FindBy(id = "iata-code-input")
	WebElement iataCodeField;
	@FindBy(xpath = "//div[@data-search='lookup']")
	WebElement lookupButton;
	@FindBy(xpath = "(//input[@type='email'])[1]")
	WebElement lookupEmail;
	@FindBy(xpath = "//input[@id='lookup-field-confirmationNo']")
	WebElement lookupCCcode;
	@FindBy(xpath = "(//button[text()='Go'])[1]")
	WebElement goButton;
	@FindBy(xpath = "//dt[text()='Reztrip conf code']/following::dd[1]")
	WebElement ccCodeIATA;
	@FindBy(xpath = "//div[text()='Cancel']")
	WebElement cancelButton;
	@FindBy(xpath = "//button[contains(@class,'btn-success')]")
	WebElement yesButtonCancel;
	@FindBy(xpath = "//span[text()='Sorry, there are no reservations matching your search criteria']")
	WebElement noResFoundMsg;
	@FindBy(xpath = "//*[@name='confirmationNumber']")
	WebElement confirmationNo;
	@FindBy(name = "quickSearchResults")
	WebElement quickSearchButton;
	@FindBy(xpath = "//*[text()='Your reservation has been cancelled']")
	WebElement cancelCodeHead;
	@FindBy(xpath = "//div[@class='bootbox-body']/strong")
	WebElement cancelCode;

	public BookingwithIATAcodePage(WebDriver driver) {
		super();
		PageFactory.initElements(driver, this);
	}

	public String UrlTilte() {
		return driver.getTitle();
	}

	/*
	 * Method to input IATA CODE
	 * 
	 */
	public VerifyingCCSettingsAnnouncementfromAdmintoBookingUIPage inputIATACODE() {
		iataCodeField.sendKeys(ExcelData.CC_getCellData("BookingWithIATACode", "IATACODE", 2));
		Helper.implict(3);
		return null;
	}

	/*
	 * Method to check Booking lookup IATA TC01
	 * 
	 */
	public void bookinglookupIATATC01() {
		lookupButton.click();
		lookupEmail.clear();
		lookupEmail.sendKeys(ExcelData.CC_getCellData("NormalSingleRoomBookingData", "Email", 2));
		Helper.implict(1);
		lookupCCcode.clear();
		lookupCCcode.sendKeys(ExcelData.CC_getCellData("NormalSingleRoomBookingData", "ConfirmationCode", 2));
		Helper.implict(1);
		goButton.click();
		Helper.clickviewButton();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	/*
	 * Method to getCCcodeIATA
	 * 
	 */
	public boolean getCCcodeIATA() {
		if (ccCodeIATA.isDisplayed()) {
			String code = ccCodeIATA.getText();
			ExcelData.write_CellData("NormalSingleRoomBookingData", 1, 35, code);
			return true;
		} else {
			System.out.println("NA");
			return false;
		}
	}

	/*
	 * Method to verifyCCcodeIATA
	 * 
	 */
	public boolean verifyCCcodeIATA() {
		String a = ExcelData.CC_getCellData("NormalSingleRoomBookingData", "CCcodeIATA", 2);
		String b = ExcelData.CC_getCellData("NormalSingleRoomBookingData", "ConfirmationCode", 2);
		if (a.equalsIgnoreCase(b)) {
			System.out.println("successful");
			return true;
		} else {
			System.out.println("unsucessful");
			return false;
		}
	}

	/*
	 * Method to Cancel Booking
	 * 
	 */
	public boolean CancelBooking() {
		Helper.explicit(cancelButton, 10);
		cancelButton.click();
		Helper.explicit(yesButtonCancel, 10);
		yesButtonCancel.click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		if (cancelCodeHead.isDisplayed()) {
			String cancelhead = cancelCodeHead.getText();
			String code1 = cancelCode.getText();
			System.out.println(cancelhead + " and cancellation code is:" + code1);
			return true;
		} else {
			System.out.println("NA");
			return false;
		}
	}
}
