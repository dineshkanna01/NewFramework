package com.be.pom;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utility.ExcelData;
import base.Helper;
import base.TestBase;

/*
 * POM class for Reservation Upload Booking
 * @Author Uzair Asar
 */

public class ReservationUploadBookingPage extends TestBase {

	@FindBy(xpath = "//div[text()='Reservations Management']")
	WebElement reservationsManagement;

	@FindBy(xpath = "//*[contains(@href,'layRoomin')]")
	WebElement reservationUploadOption;

	@FindBy(xpath = "//*[contains(@href,'./downl')]")
	WebElement reservationDownloadLink;

	@FindBy(xpath = "//input[@name='file']")
	WebElement uploadFile;

	@FindBy(name = "fileDescription")
	WebElement fileDescription;

	@FindBy(id = "uploadButton")
	WebElement uploadButton;

	@FindBy(name = "createReservationButton")
	WebElement createReservationButton;

	@FindBy(xpath = "(//tbody)[last()]//tr[2]//td[4]")
	WebElement status;

	@FindBy(xpath = "(//tbody)[last()]//tr[2]//td[3]//a")
	WebElement outputFile;

	@FindBy(xpath = "//a[text()='Delete Uploaded File']")
	WebElement deleteFile;

	public ReservationUploadBookingPage(WebDriver driver) {
		super();
		PageFactory.initElements(driver, this);
	}

	public String UrlTilte() {
		return driver.getTitle();
	}

	/*
	 * Method for enter order time
	 */
	public ReservationUploadBookingPage reservationManagementTab() {
		reservationsManagement.click();
		reservationUploadOption.click();
		return null;
	}

	/*
	 * Method for enter order time
	 */

	public ReservationUploadBookingPage downloadLinkReservationTemplate() {
		reservationDownloadLink.click();
		Helper.sleep(5000);
		return null;
	}

	/*
	 * Method for enter order time
	 */

	public ReservationUploadBookingPage fillingReservationData() {

		String resType = ExcelData.getCellData("ReservationUpload", "ReservationType", 2);
		System.out.println(resType);
		ExcelData.write_CellDataBU("Rooming List Upload", 2, 0, resType);

		String check_In = ExcelData.getCellData("ReservationUpload", "Check-In", 2);
		System.out.println(check_In);
		ExcelData.write_CellDataBU("Rooming List Upload", 2, 2, check_In);

		String check_Out = ExcelData.getCellData("ReservationUpload", "Check-Out", 2);
		ExcelData.write_CellDataBU("Rooming List Upload", 2, 3, check_Out);

		String rateCode = ExcelData.getCellData("ReservationUpload", "RateCode", 2);
		ExcelData.write_CellDataBU("Rooming List Upload", 2, 4, rateCode);

		String roomCode = ExcelData.getCellData("ReservationUpload", "RoomCode", 2);
		ExcelData.write_CellDataBU("Rooming List Upload", 2, 5, roomCode);

		String lasteName = ExcelData.getCellData("ReservationUpload", "LastName", 2);
		ExcelData.write_CellDataBU("Rooming List Upload", 2, 6, lasteName);

		String firstName = ExcelData.getCellData("ReservationUpload", "FirstName", 2);
		ExcelData.write_CellDataBU("Rooming List Upload", 2, 7, firstName);
		return null;
	}

	public ReservationUploadBookingPage uploadFile() {

		Helper.sleep(1000);
		uploadFile.sendKeys(
				System.getProperty("user.dir") + "\\target\\BookingTemplate\\ResUpload" + " " + "Template.xls");
		fileDescription.sendKeys(ExcelData.getCellData("ReservationUpload", "Description", 2));
		uploadButton.click();
		return null;
	}

	public ReservationUploadBookingPage createReservation() {

		Helper.sleep(1000);
		createReservationButton.click();
		return null;
	}

	public ReservationUploadBookingPage outputFile() {

		Helper.sleep(1000);

		while (!outputFile.isDisplayed()) {
			Helper.sleep(2000);
			getDriver().navigate().refresh();
		}
		outputFile.click();
		Helper.sleep(3000);
		return null;
	}

	public String statusOfBooking() {
		Helper.sleep(2000);

		String status = ExcelData.getCellDataResUpload("Sheet0", 1, 2);
		System.out.println(status);
		return status;
	}

	public ReservationUploadBookingPage modification() {
		Helper.sleep(1000);
		String confirmationNumber = ExcelData.getCellDataResUpload("Sheet0", 0, 2);
		System.out.println(confirmationNumber);
		ExcelData.write_CellDataBU("Rooming List Upload", 2, 1, confirmationNumber);
		ExcelData.write_CellDataBU("Rooming List Upload", 2, 0, "Modification");
		ExcelData.write_CellDataBU("Rooming List Upload", 2, 7, "Demo");
		return null;
	}

	public ReservationUploadBookingPage cancellation() {
		Helper.sleep(1000);
		ExcelData.write_CellDataBU("Rooming List Upload", 2, 0, "Cancellation");
		return null;
	}

	public ReservationUploadBookingPage deleteFile() {
		Helper.sleep(1000);
		deleteFile.click();
		return null;
	}
	
	/*
	 * Method to click ok on pop up
	 */

	public void alertPopUp() {
		Helper.implict(3);
		Alert alert = getDriver().switchTo().alert();
		Helper.sleep(1000);
		alert.accept();
	}

	public boolean verifyDeletion() {

		Helper.sleep(1000);

		if (outputFile.isDisplayed()) {
			return true;
		} else
			return false;
	}

}