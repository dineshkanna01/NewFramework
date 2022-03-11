package com.cc.pom;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utility.ExcelData;
import base.Helper;
import base.TestBase;

/*
 * Pom class for CancelbookingusingLookup
 * @author Rudraksh Aggarwal
 */
public class CancelbookingusingLookupPage extends TestBase {

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
	
	@FindBy(xpath = "//div[text()='Cancel']")
	WebElement cancelButton;
	
	@FindBy(xpath = "//div[contains(@ng-click,'summaryCtrl.initiateCancel')]")
	WebElement cancelButton1;
	
	@FindBy(xpath = "//button[contains(@class,'btn-success')]")
	WebElement yesButtonCancel;
	
	@FindBy(xpath = "//*[@name='confirmationNumber']")
	WebElement confirmationNo;
	
	@FindBy(name = "quickSearchResults")
	WebElement quickSearchButton;
	
	@FindBy(xpath = "//span[text()='Sorry, there are no reservations matching your search criteria']")
	WebElement noResFoundMsg;
	
	@FindBy(xpath = "(//span[@class='announcement-text'])[last()]")
	WebElement announcementText;

	public CancelbookingusingLookupPage(WebDriver driver) {
		super();
		PageFactory.initElements(driver, this);
	}

	public String UrlTilte() {
		return driver.getTitle();
	}

	/*
	 * Method to cancel Booking lookup TC01
	 * 
	 */
	public void cancelBookingLookupTC01() {
		lookupButton.click();
		lookupEmail.clear();
		lookupEmail.sendKeys(ExcelData.CC_getCellData("NormalSingleRoomBookingData", "Email", 2));
		Helper.implict(1);
		lookupCCcode.clear();
		lookupCCcode.sendKeys(ExcelData.CC_getCellData("NormalSingleRoomBookingData", "ConfirmationCode", 2));
		Helper.implict(1);
		goButton.click();
		Helper.clickviewButton();
		Helper.explicit(cancelButton, 7);
		cancelButton.click();
		Helper.explicit(yesButtonCancel, 2);
		yesButtonCancel.click();
		Helper.explicit(okButtonCancel, 5);
		okButtonCancel.click();
	}

	/*
	 * Method to cancel Booking lookup TC02
	 * 
	 */
	public void cancelBookingLookupTC02() {
		lookupButton.click();
		lookupEmail.clear();
		lookupEmail.sendKeys(ExcelData.CC_getCellData("NormalSingleRoomBookingData", "Email", 2));
		Helper.implict(1);
		lookupLName.clear();
		lookupLName.sendKeys(ExcelData.CC_getCellData("NormalSingleRoomBookingData", "LookUpLName", 2));
		Helper.implict(1);
		goButton.click();
		Helper.clickviewButton();
		Helper.explicit(cancelButton, 7);
		cancelButton.click();
		Helper.explicit(yesButtonCancel, 2);
		yesButtonCancel.click();
		Helper.explicit(okButtonCancel, 5);
		okButtonCancel.click();
	}

	/*
	 * Method to cancel Booking lookup TC03
	 * 
	 */
	public void cancelBookingLookupTC03() {
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
		Helper.explicit(cancelButton, 7);
		cancelButton.click();
		Helper.explicit(yesButtonCancel, 2);
		yesButtonCancel.click();
		Helper.explicit(okButtonCancel, 5);
		okButtonCancel.click();
	}
	
	/*
	 * Method to cancel Booking lookup TC04
	 * 
	 */
	public void cancelBookingLookupTC04() {
		lookupButton.click();
		lookupEmail.clear();
		lookupEmail.sendKeys(ExcelData.CC_getCellData("NormalSingleRoomBookingData", "Email", 2));
		Helper.implict(1);
		ccDig.clear();
		ccDig.sendKeys(ExcelData.CC_getCellData("NormalSingleRoomBookingData", "CardNumber4", 2));
		Helper.implict(1);
		goButton.click();
		Helper.clickviewButton();
		Helper.explicit(cancelButton, 7);
		cancelButton.click();
		Helper.explicit(yesButtonCancel, 2);
		yesButtonCancel.click();
		Helper.explicit(okButtonCancel, 5);
		okButtonCancel.click();
	}
	
	/*
	 * Method to cancel Booking lookup TC05
	 * 
	 */
	public boolean cancelBookingLookupTC05() {
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
			System.out.println("Error message for TC04: " + code2);
			return true;
		} else {
			System.out.println("NA");
			return false;
		}
	
	}


	/*
	 * Method to verify Cancel Booking lookup
	 * 
	 */
	public boolean verifyCancelBookinglookup() {
		lookupButton.click();
		lookupEmail.sendKeys(ExcelData.CC_getCellData("NormalSingleRoomBookingData", "Email", 2));
		Helper.implict(1);
		lookupCCcode.clear();
		lookupCCcode.sendKeys(ExcelData.CC_getCellData("NormalSingleRoomBookingData", "ConfirmationCode", 2));
		Helper.implict(1);
		goButton.click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		if (reservationCancelMsg.isDisplayed()) {
			String cancelmsg = reservationCancelMsg.getText();
			System.out.println(cancelmsg);
			return true;
		} else {
			System.out.println("NA");
			return false;
		}
	}

	/*
	 * Method to verify Cancel Booking TC01 reports
	 * 
	 */
	public boolean verifyCancelBookingTC01reports() {

		confirmationNo.sendKeys(ExcelData.CC_getCellData("NormalSingleRoomBookingData", "ConfirmationCode", 2));
		quickSearchButton.click();
		Helper.implict(3);
		try {
			Thread.sleep(1500);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		if (noResFoundMsg.isDisplayed()) {
			String a = noResFoundMsg.getText();
			System.out.println(a);
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			return true;
		} else {
			System.out.println("NA");
			return false;
		}
	}

}
