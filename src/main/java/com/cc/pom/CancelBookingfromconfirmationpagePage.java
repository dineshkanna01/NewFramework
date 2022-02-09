package com.cc.pom;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.admin.pom.AdministratorHomePage;
import com.admin.pom.ReportsPage;

import Utility.ExcelData;
import base.TestBase;

/*
 * POM class for CancelBookingfromconfirmationpagePage
 * @author Rudraksh Aggarwal
 */

public class CancelBookingfromconfirmationpagePage extends TestBase {
	
	ExcelData e = new ExcelData();
	public static WebDriver driver;


	@FindBy(xpath = "//thead[@class=\"confirmation-table-head\"]/tr/td[last()]/dl/dd")
	WebElement confirmcode;

	@FindBy(xpath = "//div[text()='Cancel']")
	WebElement cancelButton;

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

	public CancelBookingfromconfirmationpagePage(WebDriver driver) {
		super();
		PageFactory.initElements(driver, this);
	}

	public String UrlTilte() {
		return driver.getTitle();
	}

	/*
	 * Method to verify Cancel Booking TC01
	 * 
	 */
	public boolean verifyCancelBookingTC01() {

		String code = confirmcode.getText();
		System.out.println(code + "&&&");

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		cancelButton.click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		yesButtonCancel.click();
		try {
			Thread.sleep(7000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String cancelhead = cancelCodeHead.getText();
		String code1 = cancelCode.getText();
		System.out.println(cancelhead + "and cancellation code is:" + code1);

		switchWindow(0);
		selectReports();

		selectSearchReservationReport();
		confirmationNo.sendKeys(code);
		quickSearchButton.click();
		TestBase.implict(3);

		if (noResFoundMsg.isDisplayed()) {
			String a = noResFoundMsg.getText();
			System.out.println(a);
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return true;
		} else {
			System.out.println("NA");
			return false;
		}

	}

	/*
	 * Method to verify Cancel Booking TC02
	 * 
	 */
	public boolean verifyCancelBookingTC02()  {

		String code = confirmcode.getText();
		System.out.println(code + "&&&");

		okButtonCancel.click();

		lookupButton.click();
		lookupEmail.sendKeys(e.CC_getCellData("NormalSingleRoomBookingData", "Email", 2));
		TestBase.implict(1);
		TestBase.implict(1);
		lookupCCcode.sendKeys(code);
		TestBase.implict(1);
		goButton.click();

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
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
	 * Method to verify Cancel Booking TC03
	 * 
	 */
	public boolean verifyCancelBookingTC03()  {

		String code = conNo.getText();
		System.out.println(code + "###");

		getDriver().navigate().refresh();

		lookupButton.click();
		lookupEmail.clear();
		lookupEmail.sendKeys(e.CC_getCellData("NormalSingleRoomBookingData", "EmailWrong", 2));
		TestBase.implict(1);
		TestBase.implict(1);
		lookupCCcode.clear();
		lookupCCcode.sendKeys(code);
		TestBase.implict(1);
		goButton.click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		if (announcementText.isDisplayed()) {

			String code2 = announcementText.getText();
			System.out.println("Error message for TC03: "+code2);
			return true;
		} else {
			System.out.println("NA");
			return false;
		}
	}

	/*
	 * Method to verify Cancel Booking TC04
	 * 
	 */
	public boolean verifyCancelBookingTC04() {

		try {
			Thread.sleep(600);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}

		String wrongCode = "ALH100002";
		lookupEmail.clear();
		lookupEmail.sendKeys(e.CC_getCellData("NormalSingleRoomBookingData", "Email", 2));
		TestBase.implict(1);
		TestBase.implict(1);
		lookupCCcode.clear();
		lookupCCcode.sendKeys(wrongCode);
		TestBase.implict(1);
		goButton.click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		if (announcementText.isDisplayed()) {

			String code2 = announcementText.getText();
			System.out.println("Error message for TC04: "+code2);
			return true;
		} else {
			System.out.println("NA");
			return false;
		}
	}
	
	/*
	 * Method to verify Cancel Booking TC05
	 * 
	 */
	public boolean verifyCancelBookingTC05() {

		try {
			Thread.sleep(600);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}

		String wrongCode = "ALH100002";
		lookupEmail.clear();
		lookupEmail.sendKeys(e.CC_getCellData("NormalSingleRoomBookingData", "EmailWrong", 2));
		TestBase.implict(1);
		lookupCCcode.clear();
		TestBase.implict(1);
		lookupCCcode.sendKeys(wrongCode);
		TestBase.implict(1);
		goButton.click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		if (announcementText.isDisplayed()) {

			String code2 = announcementText.getText();
			System.out.println("Error message for TC05: "+code2);
			return true;
		} else {
			System.out.println("NA");
			return false;
		}
	}


	/*
	 * Method to select Reports
	 */
	public AdministratorHomePage selectReports() {
		reports.click();
		TestBase.implict(3);
		return null;
	}

	public ReportsPage selectSearchReservationReport() {
		searchReservationReport.click();
		TestBase.implict(3);
		return null;
	}

	/*
	 * Method to click LookUp
	 * 
	 */
	public void clickLookUp() {

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		lookupButton.click();
	}

}
