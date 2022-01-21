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

import Utility.ExcelData;
import base.TestBase;
import pages.AbstractBasePage;

public class ReportsPage extends AbstractBasePage {

	ExcelData e = new ExcelData();

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

	public ReportsPage selectProductionReport() throws InterruptedException {
		productionReport.click();
		TestBase.implict(3);
		return null;
	}

	public ReportsPage selectSearchReservationReport() throws InterruptedException {
		searchReservationReport.click();
		TestBase.implict(3);
		return null;
	}

	public ReportsPage selectBookingReport() throws InterruptedException {
		bookingReport.click();
		TestBase.implict(3);
		return null;
	}

	public ReportsPage selectDateRange() throws Exception {
		fromDate.sendKeys(e.getCellData("Reports", "From", 2));
		TestBase.implict(3);
		toDate.sendKeys(e.getCellData("Reports", "To", 2));
		TestBase.implict(3);
		return null;
	}

	public ReportsPage selectArrivalDateRange() throws Exception {
		arrivalFromDate.sendKeys(e.getCellData("Reports", "From", 2));
		TestBase.implict(3);
		arrivalToDate.sendKeys(e.getCellData("Reports", "To", 2));
		TestBase.implict(3);
		return null;
	}

	public ReportsPage selectCheckOutDateRange() throws Exception {
		checkoutFromDate.sendKeys(e.getCellData("Reports", "From", 2));
		TestBase.implict(3);
		checkoutToDate.sendKeys(e.getCellData("Reports", "To", 2));
		TestBase.implict(3);
		return null;
	}

	public ReportsPage selectBookingDateRange() throws Exception {
		bookingFromDate.sendKeys(e.getCellData("Reports", "From", 2));
		TestBase.implict(3);
		bookingToDate.sendKeys(e.getCellData("Reports", "To", 2));
		TestBase.implict(3);
		return null;
	}

	public ReportsPage selectBookingFromDateRange() throws Exception {
		checkoutFromDate.sendKeys(e.getCellData("Reports", "From", 2));
		TestBase.implict(3);

		return null;
	}

	public ReportsPage selectBookingsRadioBtn() throws Exception {
		bookings.click();
		TestBase.implict(3);

		return null;
	}

	public ReportsPage selectCancellationsRadioBtn() throws Exception {
		cancellations.click();
		TestBase.implict(3);

		return null;
	}

	public ReportsPage selectRoomtype() throws InterruptedException {
		roomType.click();
		TestBase.implict(3);
		return null;
	}

	public ReportsPage viewReport() throws InterruptedException {
		viewReport.click();
		TestBase.implict(3);
		return null;
	}

	public ReportsPage quicksearch() throws InterruptedException {
		quickSearch.click();
		TestBase.implict(3);
		return null;
	}

	public ReportsPage detailedReport() throws InterruptedException {
		detailed.click();
		TestBase.implict(3);
		return null;
	}

	public ReportsPage DownloadReportPdf() throws InterruptedException {
		pdfXcelDrpDwn.click();
		pdfBookingRep.click();
		submitBTN.click();
		TestBase.implict(3);
		return null;
	}

	public ReportsPage statisticalReport() throws InterruptedException {
		statistical.click();
		TestBase.implict(3);
		return null;
	}

	public ReportsPage DownloadReportExcel() throws InterruptedException {
		pdfXcelDrpDwn.click();
		excelBookingRep.click();
		submitBTN.click();
		TestBase.implict(3);
		return null;
	}

	public ReportsPage selectArrivalradioBtn() throws InterruptedException {
		arrival_BR.click();
		TestBase.implict(3);
		return null;
	}

	public ReportsPage selectStayThroughradioBtn() throws InterruptedException {
		stayThrough_BR.click();
		TestBase.implict(3);
		return null;
	}

	public boolean verifyReportisvisible() throws Exception {
		String Compiletext = compileText.getText();

		TestBase.implict(3);
		if (Compiletext != null) {
			System.out.println(Compiletext + ".......Report is there");
			return true;
		} else
			return false;

	}

	public boolean verifySearchResReportisvisible() throws Exception {

		String Compiletext = verifySearchResReport.getText();

		System.out.println(Compiletext + ".......Report is there");

		TestBase.implict(3);
		if (Compiletext != null) {
			System.out.println(Compiletext + ".......Report is there");
			return true;
		} else {
			System.out.println("No report");
			return false;
		}
	}

	public boolean verifySearchResReportErrormsg() throws Exception {

		String error = driver.findElement(By.xpath("//*[contains(text(),'Either')]")).getText();

		System.out.println(error + ".......Report is there");

		TestBase.implict(3);
		if (error != null) {
			System.out.println(error + ".......Report is there");
			return true;
		} else {
			System.out.println("No report");
			return false;
		}

	}

	public ReportsPage selectRatetype() throws InterruptedException {
		rateType.click();
		TestBase.implict(3);
		return null;
	}

	public ReportsPage selectRateClassification() throws InterruptedException {
		rateClassification.click();
		TestBase.implict(3);
		return null;
	}

	public boolean verifyRateType() throws Exception {
		TestBase.implict(3);
		String rate = driver.findElement(By.xpath("(//*[@id='nameHeader']/td[1])[1]")).getText();
		System.out.println("rate is ......" + rate);
		String rateplan = "BAR";
		TestBase.implict(3);
		if (rate.equalsIgnoreCase(rateplan)) {
			System.out.println(".......Report for" + rate + " Rate Plan");
			return true;
		} else
			return false;

	}

	public boolean verifyRoomType() throws Exception {
		TestBase.implict(3);
		String room = driver.findElement(By.xpath("(//*[@id='nameHeader']/td[1])[1]")).getText();
		System.out.println("room type is ......" + room);
		String roomtype = "room";
		TestBase.implict(3);
		if (room.contains(roomtype)) {
			System.out.println(".......Report for" + room);
			return true;
		} else
			return false;

	}

	public boolean verifyRateClassification() throws Exception {
		TestBase.implict(3);
		String rate = driver.findElement(By.xpath("(//*[@id='nameHeader'])[last()]/td[1]")).getText();
		System.out.println("rate is ......" + rate);

		String rateplan = "BAR";

		TestBase.implict(3);

		if (rate.equalsIgnoreCase(rateplan)) {
			System.out.println(".......Report for" + rate + "Rate Classication and others");
			return true;
		} else
			return false;

	}

	public ReportsPage enterConfirmationNo() throws Exception {
		confirmationNo.sendKeys(e.getCellData("Reports", "ConfirmationNo", 2));
		TestBase.implict(3);
		return null;
	}

	public ReportsPage pdfButton() throws Exception {
		pdfBTN.click();
		TestBase.implict(3);
		return null;
	}

	public ReportsPage excelButton() throws Exception {
		excelBTN.click();
		TestBase.implict(3);
		return null;
	}

	public boolean verifyConfirmationNo() throws Exception {
		String ConfirmationNoExcl = e.getCellData("Reports", "ConfirmationNo", 2);

		TestBase.implict(3);
		String Cnumber = driver.findElement(By.xpath("//*[contains(text(),'ALH')]")).getText();
		System.out.println("confirmation No. is ......" + Cnumber);

		if (Cnumber.equalsIgnoreCase(ConfirmationNoExcl)) {
			System.out.println("......Confirmation No. is : " + Cnumber);
			return true;
		} else
			return false;

	}

	public boolean verifyBookingReport() throws Exception {
		TestBase.implict(3);
		String booking = driver.findElement(By.xpath("//*[text()='Booking']")).getText();
		System.out.println("Report type is ......" + booking);
		String Booking = "Booking";
		TestBase.implict(3);
		if (booking.contains(Booking)) {
			System.out.println(".......Report for" + Booking);
			return true;
		} else
			return false;

	}

	public boolean verifyCancellationsReport() throws Exception {
		TestBase.implict(3);
		String cancel = driver.findElement(By.xpath("//*[text()='Cancellation']")).getText();
		System.out.println("Report type is ......" + cancel);
		String Cancellation = "Cancellation";
		TestBase.implict(3);
		if (cancel.contains(Cancellation)) {
			System.out.println(".......Report for" + Cancellation);
			return true;
		} else
			return false;

	}

	public boolean verifyArrivalsReport() throws Exception {
		TestBase.implict(3);
		String arrival = driver.findElement(By.xpath("//*[text()='Arrivals']")).getText();
		System.out.println("Report type is ......" + arrival);
		String arrivals = "Arrivals";
		TestBase.implict(3);
		if (arrival.contains(arrivals)) {
			System.out.println(".......Report for" + arrivals);
			return true;
		} else
			return false;

	}

	public boolean verifyStayThroughReport() throws Exception {
		TestBase.implict(3);
		String stayThrough = driver.findElement(By.xpath("//span[text()='Stay-Through']")).getText();
		System.out.println("Report type is ......" + stayThrough);
		String StayThrough = "Stay-Through";
		TestBase.implict(3);
		if (stayThrough.contains(StayThrough)) {
			System.out.println(".......Report for" + StayThrough);
			return true;
		} else
			return false;

	}

	public boolean downloadProductionReports() throws InterruptedException, IOException {
		Thread.sleep(3000);


		File prodFiles = new File("C:\\Users\\Sanskriti.Gangwar\\Desktop\\NewFramework\\target\\CrsReports");

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
		// Assert.assertTrue(found, "Downloaded document is not found");
		//		new File("C:\\Users\\Sanskriti.Gangwar\\Desktop\\NewFramework\\target\\CrsReports\\Production Report.xlsx").delete();
		//		prodFiles.delete();
		FileUtils.deleteDirectory(new File("C:\\Users\\Sanskriti.Gangwar\\Desktop\\NewFramework\\target\\CrsReports"));
		f.deleteOnExit();
		return found;

	}



	public boolean downloadDetailedBookingReports() throws InterruptedException, IOException {
		Thread.sleep(3000);

		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy ");
		Date date = new Date();
		String stDate= dateFormat.format(date);

		String Date[] = stDate.split("/");
		String day = Date[1];
		String month = Date[0];
		String pdf_name = "detailed_report_2022_"+month+"_"+day+".pdf";
		String xls_name = "detailed_report_2022_"+month+"_"+day+".xlsx";

		System.out.println(pdf_name+"-----PDF name");
		System.out.println(xls_name+"-----EXCEL name");

		File prodFiles = new File("C:\\Users\\Sanskriti.Gangwar\\Desktop\\NewFramework\\target\\CrsReports");

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
		// Assert.assertTrue(found, "Downloaded document is not found");

		FileUtils.deleteDirectory(new File("C:\\Users\\Sanskriti.Gangwar\\Desktop\\NewFramework\\target\\CrsReports"));
		f.deleteOnExit();
		return found;

	}

	public boolean downloadStatisticalBookingReports() throws InterruptedException, IOException {
		Thread.sleep(3000);

		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy ");
		Date date = new Date();
		String stDate= dateFormat.format(date);

		String Date[] = stDate.split("/");
		String day = Date[1];
		String month = Date[0];

		String pdf_name = "statistical_report_2022_"+month+"_"+day+".pdf";
		String xls_name = "statistical_report_2022_"+month+"_"+day+".xlsx";

		System.out.println(pdf_name+"-----PDF name");
		System.out.println(pdf_name+"-----EXCEL name");

		File prodFiles = new File("C:\\Users\\Sanskriti.Gangwar\\Desktop\\NewFramework\\target\\CrsReports");

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
		// Assert.assertTrue(found, "Downloaded document is not found");

		FileUtils.deleteDirectory(new File("C:\\Users\\Sanskriti.Gangwar\\Desktop\\NewFramework\\target\\CrsReports"));
		f.deleteOnExit();
		return found;

	}

	public boolean downloadSearchResReports() throws InterruptedException, IOException {
		Thread.sleep(3000);
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy ");
		Date date = new Date();
		String stDate= dateFormat.format(date);

		String Date[] = stDate.split("/");
		String day = Date[1];
		String month = Date[0];

		String pdf_name = "searchReservation_report_2022_"+month+"_"+day+".pdf";
		String xls_name = "searchReservation_report_2022_"+month+"_"+day+".xls";

		System.out.println(pdf_name+"-----PDF name");
		System.out.println(pdf_name+"-----EXCEL name");

		File prodFiles = new File("C:\\Users\\Sanskriti.Gangwar\\Desktop\\NewFramework\\target\\CrsReports");

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
		// Assert.assertTrue(found, "Downloaded document is not found");

		FileUtils.deleteDirectory(new File("C:\\Users\\Sanskriti.Gangwar\\Desktop\\NewFramework\\target\\CrsReports"));
		f.deleteOnExit();
		return found;

	}

}
