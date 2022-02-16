package com.admin.pom;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import Utility.ExcelData;
import base.Helper;
import pages.AbstractBasePage;

public class ReportsPage extends AbstractBasePage {

	public ReportsPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	public String UrlTilte() {
		return driver.getTitle();
	}

	@FindBy(xpath = "//*[contains(@href,'ProductionDetails')]")
	WebElement productionReport;
	@FindBy(xpath = "//*[contains(@href,'quickSearch')]")
	WebElement searchReservationReport;
	@FindBy(xpath = "//*[contains(@href,'BookingDetails')]")
	WebElement bookingReport;
	@FindBy(xpath = "//*[@name='fromDate']")
	WebElement fromDate;
	@FindBy(xpath = "//*[@name='toDate']")
	WebElement toDate;
	@FindBy(xpath = "//input[@name='arrivalFromDate']")
	WebElement arrivalFromDate;
	@FindBy(xpath = "//input[@name='arrivalToDate']")
	WebElement arrivalToDate;
	@FindBy(xpath = "//*[@name='checkOutFromDate']")
	WebElement checkoutFromDate;
	@FindBy(xpath = "//*[@name='checkOutToDate']")
	WebElement checkoutToDate;
	@FindBy(xpath = "//*[@name='bookingFromDate']")
	WebElement bookingFromDate;
	@FindBy(xpath = "//*[@name='bookingToDate']")
	WebElement bookingToDate;
	@FindBy(xpath = "//*[@value='roomType']")
	WebElement roomType;
	@FindBy(xpath = "//*[@value='View Report']")
	WebElement viewReport;
	@FindBy(xpath = "//*[@value='Quick Search']")
	WebElement quickSearch;
	@FindBy(xpath = "(//*[contains(text(),'compiled on')])[2]")
	WebElement compileText;
	@FindBy(xpath = "(//*[text()='Search Reservation Report'])[last()]")
	WebElement verifySearchResReport;
	@FindBy(xpath = "//*[@value='rateType']")
	WebElement rateType;
	@FindBy(xpath = "//*[@value='rateClassification']")
	WebElement rateClassification;
	@FindBy(xpath = "//*[@name='confirmationNumber']")
	WebElement confirmationNo;
	@FindBy(xpath = "//*[@value='booking']")
	WebElement bookings;
	@FindBy(xpath = "//*[@value='cancellation']")
	WebElement cancellations;
	@FindBy(xpath = "//*[@value='Detailed Report']")
	WebElement detailed;
	@FindBy(xpath = "//*[@value='Statistical Report']")
	WebElement statistical;
	@FindBy(xpath = "//*[@value='arrival']")
	WebElement arrival_BR;
	@FindBy(xpath = "//*[@value='stayThrough']")
	WebElement stayThrough_BR;
	@FindBy(xpath = "//span[text()='PDF']")
	WebElement pdfBTN;
	@FindBy(xpath = "//span[text()='Excel']")
	WebElement excelBTN;
	@FindBy(xpath = "//input[@value='Submit']")
	WebElement submitBTN;
	@FindBy(xpath = "//select[@name='reportFormat']")
	WebElement pdfXcelDrpDwn;
	@FindBy(xpath = "//option[text()='PDF']")
	WebElement pdfBookingRep;
	@FindBy(xpath = "//option[text()='EXCEL']")
	WebElement excelBookingRep;

	/*
	 * Method to selectProductionReport
	 */
	public ReportsPage selectProductionReport() {
		productionReport.click();
		Helper.implict(3);
		return null;
	}

	/*
	 * Method to selectProductionReport
	 */
	public ReportsPage selectSearchReservationReport() {
		searchReservationReport.click();
		Helper.implict(3);
		return null;
	}

	/*
	 * Method to selectBookingReport
	 */
	public ReportsPage selectBookingReport() {
		Helper.implict(3);
		bookingReport.click();
		Helper.implict(3);
		return null;
	}

	/*
	 * Method to selectDateRange
	 */
	public ReportsPage selectDateRange() throws Exception {
		fromDate.sendKeys(ExcelData.getCellData("Reports", "From", 2));
		Helper.implict(3);
		toDate.sendKeys(ExcelData.getCellData("Reports", "To", 2));
		Helper.implict(3);
		return null;
	}

	/*
	 * Method to selectArrivalDateRange
	 */
	public ReportsPage selectArrivalDateRange() throws Exception {
		arrivalFromDate.sendKeys(ExcelData.getCellData("Reports", "From", 2));
		Helper.implict(3);
		arrivalToDate.sendKeys(ExcelData.getCellData("Reports", "To", 2));
		Helper.implict(3);
		return null;
	}

	/*
	 * Method to selectCheckOutDateRange
	 */
	public ReportsPage selectCheckOutDateRange() throws Exception {
		checkoutFromDate.sendKeys(ExcelData.getCellData("Reports", "From", 2));
		Helper.implict(3);
		checkoutToDate.sendKeys(ExcelData.getCellData("Reports", "To", 2));
		Helper.implict(3);
		return null;
	}

	/*
	 * Method to selectBookingDateRange
	 */
	public ReportsPage selectBookingDateRange() throws Exception {
		bookingFromDate.sendKeys(ExcelData.getCellData("Reports", "From", 2));
		Helper.implict(3);
		bookingToDate.sendKeys(ExcelData.getCellData("Reports", "To", 2));
		Helper.implict(3);
		return null;
	}

	/*
	 * Method to selectBookingFromDateRange
	 */
	public ReportsPage selectBookingFromDateRange() throws Exception {
		checkoutFromDate.sendKeys(ExcelData.getCellData("Reports", "From", 2));
		Helper.implict(3);
		return null;
	}

	/*
	 * Method to selectBookingsRadioBtn
	 */
	public ReportsPage selectBookingsRadioBtn() throws Exception {
		bookings.click();
		Helper.implict(3);
		return null;
	}

	/*
	 * Method to selectCancellationsRadioBtn
	 */
	public ReportsPage selectCancellationsRadioBtn() throws Exception {
		cancellations.click();
		Helper.implict(3);
		return null;
	}

	/*
	 * Method to selectRoomtype
	 */
	public ReportsPage selectRoomtype() {
		roomType.click();
		Helper.implict(3);
		return null;
	}

	/*
	 * Method to viewReport
	 */
	public ReportsPage viewReport() {
		viewReport.click();
		Helper.implict(3);
		return null;
	}

	/*
	 * Method to quicksearch
	 */
	public ReportsPage quicksearch() {
		quickSearch.click();
		Helper.implict(3);
		return null;
	}

	/*
	 * Method to detailedReport
	 */
	public ReportsPage detailedReport() {
		detailed.click();
		Helper.implict(3);
		return null;
	}

	/*
	 * Method to DownloadReportPdf
	 */
	public ReportsPage DownloadReportPdf() {
		pdfXcelDrpDwn.click();
		pdfBookingRep.click();
		submitBTN.click();
		Helper.implict(3);
		return null;
	}

	/*
	 * Method to statisticalReport
	 */
	public ReportsPage statisticalReport() {
		statistical.click();
		Helper.implict(3);
		return null;
	}

	/*
	 * Method to DownloadReportExcel
	 */
	public ReportsPage DownloadReportExcel() {
		pdfXcelDrpDwn.click();
		excelBookingRep.click();
		submitBTN.click();
		Helper.implict(3);
		return null;
	}

	/*
	 * Method to selectArrivalradioBtn
	 */
	public ReportsPage selectArrivalradioBtn() {
		arrival_BR.click();
		Helper.implict(3);
		return null;
	}

	/*
	 * Method to selectStayThroughradioBtn
	 */
	public ReportsPage selectStayThroughradioBtn() {
		stayThrough_BR.click();
		Helper.implict(3);
		return null;
	}

	/*
	 * Method to verifyReportisvisible
	 */
	public boolean verifyReportisvisible() throws Exception {
		String Compiletext = compileText.getText();
		Helper.implict(3);
		if (Compiletext != null) {
			System.out.println(Compiletext + ".......Report is there");
			return true;
		} else
			return false;
	}

	/*
	 * Method to verifySearchResReportisvisible
	 */
	public boolean verifySearchResReportisvisible() throws Exception {
		String Compiletext = verifySearchResReport.getText();
		System.out.println(Compiletext + ".......Report is there");
		Helper.implict(3);
		if (Compiletext != null) {
			System.out.println(Compiletext + ".......Report is there");
			return true;
		} else {
			System.out.println("No report");
			return false;
		}
	}

	/*
	 * Method to verifySearchResReportErrormsg
	 */
	public boolean verifySearchResReportErrormsg() throws Exception {
		String error = driver.findElement(By.xpath("//*[contains(text(),'Either')]")).getText();
		System.out.println(error + ".......Report is there");
		Helper.implict(3);
		if (error != null) {
			System.out.println(error + ".......Report is there");
			return true;
		} else {
			System.out.println("No report");
			return false;
		}
	}

	/*
	 * Method to selectRatetype
	 */
	public ReportsPage selectRatetype() {
		rateType.click();
		Helper.implict(3);
		return null;
	}

	/*
	 * Method to selectRateClassification
	 */
	public ReportsPage selectRateClassification() {
		rateClassification.click();
		Helper.implict(3);
		return null;
	}

	/*
	 * Method to verifyRateType
	 */
	public boolean verifyRateType() throws Exception {
		Helper.implict(3);
		String rate = driver.findElement(By.xpath("(//*[@id='nameHeader']/td[1])[1]")).getText();
		System.out.println("rate is ......" + rate);
		String rateplan = "BAR";
		Helper.implict(3);
		if (rate.equalsIgnoreCase(rateplan)) {
			System.out.println(".......Report for" + rate + " Rate Plan");
			return true;
		} else
			return false;
	}

	/*
	 * Method to verifyRoomType
	 */
	public boolean verifyRoomType() throws Exception {
		Helper.implict(3);
		String room = driver.findElement(By.xpath("(//*[@id='nameHeader']/td[1])[1]")).getText();
		System.out.println("room type is ......" + room);
		String roomtype = "room";
		Helper.implict(3);
		if (room.contains(roomtype)) {
			System.out.println(".......Report for" + room);
			return true;
		} else
			return false;
	}

	/*
	 * Method to verifyRateClassification
	 */
	public boolean verifyRateClassification() throws Exception {
		Helper.implict(3);
		String rate = driver.findElement(By.xpath("(//*[@id='nameHeader'])[last()]/td[1]")).getText();
		System.out.println("rate is ......" + rate);
		String rateplan = "BAR";
		Helper.implict(3);
		if (rate.equalsIgnoreCase(rateplan)) {
			System.out.println(".......Report for" + rate + "Rate Classication and others");
			return true;
		} else
			return false;
	}

	/*
	 * Method to enterConfirmationNo
	 */
	public ReportsPage enterConfirmationNo() throws Exception {
		confirmationNo.sendKeys(ExcelData.getCellData("Reports", "ConfirmationNo", 2));
		Helper.implict(3);
		return null;
	}

	/*
	 * Method to click pdfButton
	 */
	public ReportsPage pdfButton() throws Exception {
		pdfBTN.click();
		Helper.implict(3);
		return null;
	}

	/*
	 * Method to click excelButton
	 */
	public ReportsPage excelButton() throws Exception {
		excelBTN.click();
		Helper.implict(3);
		return null;
	}

	/*
	 * Method to verifyConfirmationNo
	 */
	public boolean verifyConfirmationNo() throws Exception {
		String ConfirmationNoExcl = ExcelData.getCellData("Reports", "ConfirmationNo", 2);
		Helper.implict(3);
		String Cnumber = driver.findElement(By.xpath("//*[contains(text(),'ALH')]")).getText();
		System.out.println("confirmation No. is ......" + Cnumber);
		if (Cnumber.equalsIgnoreCase(ConfirmationNoExcl)) {
			System.out.println("......Confirmation No. is : " + Cnumber);
			return true;
		} else
			return false;
	}

	/*
	 * Method to verifyBookingReport
	 */
	public boolean verifyBookingReport() throws Exception {
		Helper.implict(3);
		String booking = driver.findElement(By.xpath("//*[text()='Booking']")).getText();
		System.out.println("Report type is ......" + booking);
		String Booking = "Booking";
		Helper.implict(3);
		if (booking.contains(Booking)) {
			System.out.println(".......Report for" + Booking);
			return true;
		} else
			return false;
	}

	/*
	 * Method to verifyCancellationsReport
	 */
	public boolean verifyCancellationsReport() throws Exception {
		Helper.implict(3);
		String cancel = driver.findElement(By.xpath("//*[text()='Cancellation']")).getText();
		System.out.println("Report type is ......" + cancel);
		String Cancellation = "Cancellation";
		Helper.implict(3);
		if (cancel.contains(Cancellation)) {
			System.out.println(".......Report for" + Cancellation);
			return true;
		} else
			return false;
	}

	/*
	 * Method to verifyArrivalsReport
	 */
	public boolean verifyArrivalsReport() throws Exception {
		Helper.implict(3);
		String arrival = driver.findElement(By.xpath("//*[text()='Arrivals']")).getText();
		System.out.println("Report type is ......" + arrival);
		String arrivals = "Arrivals";
		Helper.implict(3);
		if (arrival.contains(arrivals)) {
			System.out.println(".......Report for" + arrivals);
			return true;
		} else
			return false;
	}

	/*
	 * Method to verifyStayThroughReport
	 */
	public boolean verifyStayThroughReport() throws Exception {
		Helper.implict(3);
		String stayThrough = driver.findElement(By.xpath("//span[text()='Stay-Through']")).getText();
		System.out.println("Report type is ......" + stayThrough);
		String StayThrough = "Stay-Through";
		Helper.implict(3);
		if (stayThrough.contains(StayThrough)) {
			System.out.println(".......Report for" + StayThrough);
			return true;
		} else
			return false;
	}

	/*
	 * Method to downloadProductionReports
	 */
	public boolean downloadProductionReports() {
		Helper.implict(6);
		String files = System.getProperty("user.dir");
		File prodFiles = new File(files + "\\target\\CrsReports");
		// List the files on that folder
		File[] listOfFiles = prodFiles.listFiles();
		System.out.println(listOfFiles + "#############");
		boolean found = false;
		File f = null;
		// Look for the file in the files
		// You should write smart REGEX according to the filename
		for (File listOfFile : listOfFiles) {
			if (listOfFile.isFile()) {
				String fileName = listOfFile.getName();
				System.out.println("File   " + listOfFile.getName());
				if (fileName.matches("Production Report.pdf")) {
					f = new File(fileName);
					found = true;
				} else if (fileName.matches("Production Report.xlsx")) {
					f = new File(fileName);
					found = true;
				}
			}
		}
		String storePath = System.getProperty("user.dir");
		try {
			FileUtils.deleteDirectory(new File(storePath + "\\target\\CrsReports"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		f.deleteOnExit();
		return found;
	}

	/*
	 * Method to downloadDetailedBookingReports
	 */
	public boolean downloadDetailedBookingReports() {
		Helper.implict(6);
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy ");
		Date date = new Date();
		String stDate = dateFormat.format(date);
		String Date[] = stDate.split("/");
		String day = Date[1];
		String month = Date[0];
		String pdf_name = "detailed_report_2022_" + month + "_" + day + ".pdf";
		String xls_name = "detailed_report_2022_" + month + "_" + day + ".xlsx";
		System.out.println(pdf_name + "-----PDF name");
		System.out.println(xls_name + "-----EXCEL name");
		String files = System.getProperty("user.dir");
		File prodFiles = new File(files + "\\target\\CrsReports");
		// List the files on that folder
		File[] listOfFiles = prodFiles.listFiles();
		System.out.println(listOfFiles + "#############");
		boolean found = false;
		File f = null;
		// Look for the file in the files
		// You should write smart REGEX according to the filename
		for (File listOfFile : listOfFiles) {
			if (listOfFile.isFile()) {
				String fileName = listOfFile.getName();
				System.out.println("File   " + listOfFile.getName());
				if (fileName.matches(pdf_name)) {
					f = new File(fileName);
					found = true;
				} else if (fileName.matches(xls_name)) {
					f = new File(fileName);
					found = true;
				}
			}
		}
		Assert.assertTrue(found, "Downloaded document is not found");
		String storePath = System.getProperty("user.dir");
		try {
			FileUtils.deleteDirectory(new File(storePath + "\\target\\CrsReports"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		f.deleteOnExit();
		return found;
	}

	/*
	 * Method to downloadStatisticalBookingReports
	 */
	public boolean downloadStatisticalBookingReports() {
		Helper.implict(6);
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy ");
		Date date = new Date();
		String stDate = dateFormat.format(date);
		String Date[] = stDate.split("/");
		String day = Date[1];
		String month = Date[0];
		String pdf_name = "statistical_report_2022_" + month + "_" + day + ".pdf";
		String xls_name = "statistical_report_2022_" + month + "_" + day + ".xlsx";
		System.out.println(pdf_name + "-----PDF name");
		System.out.println(pdf_name + "-----EXCEL name");
		String files = System.getProperty("user.dir");
		File prodFiles = new File(files + "\\target\\CrsReports");
		// List the files on that folder
		File[] listOfFiles = prodFiles.listFiles();
		System.out.println(listOfFiles + "#############");
		boolean found = false;
		File f = null;
		// Look for the file in the files
		// You should write smart REGEX according to the filename
		for (File listOfFile : listOfFiles) {
			if (listOfFile.isFile()) {
				String fileName = listOfFile.getName();
				System.out.println("File   " + listOfFile.getName());
				if (fileName.matches(pdf_name)) {
					f = new File(fileName);
					found = true;
				} else if (fileName.matches(xls_name)) {
					f = new File(fileName);
					found = true;
				}
			}
		}
		String storePath = System.getProperty("user.dir");
		try {
			FileUtils.deleteDirectory(new File(storePath + "\\target\\CrsReports"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		f.deleteOnExit();
		return found;
	}

	/*
	 * Method to downloadSearchResReports
	 */
	public boolean downloadSearchResReports() {
		Helper.implict(6);
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy ");
		Date date = new Date();
		String stDate = dateFormat.format(date);
		String Date[] = stDate.split("/");
		String day = Date[1];
		String month = Date[0];
		String pdf_name = "searchReservation_report_2022_" + month + "_" + day + ".pdf";
		String xls_name = "searchReservation_report_2022_" + month + "_" + day + ".xlsx";
		System.out.println(pdf_name + "-----PDF name");
		System.out.println(pdf_name + "-----EXCEL name");
		String files = System.getProperty("user.dir");
		File prodFiles = new File(files + "\\target\\CrsReports");
		// List the files on that folder
		File[] listOfFiles = prodFiles.listFiles();
		System.out.println(listOfFiles + "#############");
		boolean found = false;
		File f = null;
		// Look for the file in the files
		// You should write smart REGEX according to the filename
		for (File listOfFile : listOfFiles) {
			if (listOfFile.isFile()) {
				String fileName = listOfFile.getName();
				System.out.println("File   " + listOfFile.getName());
				if (fileName.matches(pdf_name)) {
					f = new File(fileName);
					found = true;
				} else if (fileName.matches(xls_name)) {
					f = new File(fileName);
					found = true;
				}
			}
		}
		String storePath = System.getProperty("user.dir");
		try {
			FileUtils.deleteDirectory(new File(storePath + "\\target\\CrsReports"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		f.deleteOnExit();
		return found;
	}
}
