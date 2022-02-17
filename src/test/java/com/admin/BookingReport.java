package com.admin;

import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.admin.pom.AdministratorHomePage;
import com.admin.pom.LoginPage;
import com.admin.pom.ReportsPage;

import Utility.ExcelData;
import base.TestBase;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import io.qameta.allure.Story;
import logfile.Utilitylog;

public class BookingReport extends TestBase{
	

	ExcelData e = new ExcelData();
	public static Utilitylog logger;

	public BookingReport() {
		super();
		logger = new Utilitylog(BookingReport.class.getName());
	}

	LoginPage lp;
	AdministratorHomePage ahp;
	ReportsPage rep;

	@BeforeMethod
	public void setup() {
		
		lp = new LoginPage(getDriver());
		ahp = new AdministratorHomePage(getDriver());
		rep = new ReportsPage(getDriver());
	}

	@Test(priority = 1)
	@Description(" Verify that the user is able to view and download Detailed and statistical Booking Report for bookings.")
	@Severity(SeverityLevel.CRITICAL)
	@Epic("EP01")
	@Feature("Feature1: BookingReport Report")
	@Story("Story: BookingReport Report Page")
	@Step("Verify BookingReport Report Presence")
	public void bookingReport_TC_01() throws Exception {

		extentTest = extent.startTest("bookingReport_TC_01");
		logger.info("Test Case Started");
		lp.login();
		allureScreenshot("Login");

		// Administrator Page

		ahp.selectBrand();// Select the brand

		ahp.selectProperty();// Select the property
		allureScreenshot("Property");

		ahp.selectReports();
		
		rep.selectBookingReport();

		rep.selectBookingsRadioBtn();
		rep.selectBookingDateRange();

		allureScreenshot("Bookings");

		rep.detailedReport();

		Assert.assertTrue(rep.verifyBookingReport());
		allureScreenshot("DetailedBookingsReport");
		
		rep.DownloadReportPdf();
//		Assert.assertTrue(rep.downloadDetailedBookingReports());
		
		rep.DownloadReportExcel();
//		Assert.assertTrue(rep.downloadDetailedBookingReports());

		rep.selectBookingReport();

		rep.selectBookingsRadioBtn();
		rep.selectBookingDateRange();

		allureScreenshot("Bookings");

		rep.statisticalReport();

		Assert.assertTrue(rep.verifyBookingReport());
		allureScreenshot("StatisticalBookingsReport");
		
		rep.DownloadReportPdf();
//		Assert.assertTrue(rep.downloadStatisticalBookingReports());
		
		rep.DownloadReportExcel();
//		Assert.assertTrue(rep.downloadStatisticalBookingReports());
		
		
		logger.info("Test Case Ended");

	}

	@Test(priority = 2)
	@Description(" Verify that the user is able to view Detailed and statistical Booking Report for Cancellations.")
	@Severity(SeverityLevel.CRITICAL)
	@Epic("EP01")
	@Feature("Feature1: BookingReport Report")
	@Story("Story: BookingReport Report Page")
	@Step("Verify BookingReport Report Presence")
	public void bookingReport_TC_02() throws Exception {

		extentTest = extent.startTest("BookingReport_TC_02");
		logger.info("Test Case Started");
		
//		lp.login();
//		allureScreenshot("Login");
//
//		// Administrator Page
//
//		ahp.selectBrand();// Select the brand
//
//		ahp.selectProperty();// Select the property
//		allureScreenshot("Property");
//
//		ahp.selectReports();
		
		rep.selectBookingReport();

		rep.selectCancellationsRadioBtn();
		rep.selectBookingDateRange();

		allureScreenshot("Bookings");

		rep.detailedReport();

		Assert.assertTrue(rep.verifyCancellationsReport());
		allureScreenshot("DetailedBookingsReport");
		
		rep.DownloadReportPdf();
		Assert.assertTrue(rep.downloadDetailedBookingReports());
		
		rep.DownloadReportExcel();
		Assert.assertTrue(rep.downloadDetailedBookingReports());

		rep.selectBookingReport();

		rep.selectCancellationsRadioBtn();
		rep.selectBookingDateRange();

		allureScreenshot("Bookings");

		rep.statisticalReport();

		Assert.assertTrue(rep.verifyCancellationsReport());
		allureScreenshot("StatisticalBookingsReport");
		

		
		logger.info("Test Case Ended");

	}

	@Test(priority = 3)
	@Description(" Verify that the user is able to view Detailed and statistical Booking Report for Arrivals.")
	@Severity(SeverityLevel.CRITICAL)
	@Epic("EP01")
	@Feature("Feature1: BookingReport Report")
	@Story("Story: BookingReport Report Page")
	@Step("Verify BookingReport Report Presence")
	public void bookingReport_TC_03() throws Exception {

		extentTest = extent.startTest("BookingReport_TC_03");
		logger.info("Test Case Started");
//		lp.login();
//		allureScreenshot("Login");
//
//		// Administrator Page
//
//		ahp.selectBrand();// Select the brand
//		ahp.selectProperty();// Select the property
//		allureScreenshot("Property");
//		ahp.selectReports();
		
		rep.selectBookingReport();

		rep.selectArrivalradioBtn();
		rep.selectArrivalDateRange();

		allureScreenshot("Bookings");

		rep.detailedReport();

		Assert.assertTrue(rep.verifyArrivalsReport());
		allureScreenshot("DetailedBookingsReport");

		rep.DownloadReportPdf();
		Assert.assertTrue(rep.downloadDetailedBookingReports());
		
		rep.DownloadReportExcel();
		Assert.assertTrue(rep.downloadDetailedBookingReports());
		
		rep.selectBookingReport();

		rep.selectArrivalradioBtn();
		rep.selectArrivalDateRange();

		allureScreenshot("Bookings");

		rep.statisticalReport();

		Assert.assertTrue(rep.verifyArrivalsReport());
		allureScreenshot("StatisticalBookingsReport");

		rep.DownloadReportPdf();
		Assert.assertTrue(rep.downloadStatisticalBookingReports());
		
		rep.DownloadReportExcel();
		Assert.assertTrue(rep.downloadStatisticalBookingReports());

		
		logger.info("Test Case Ended");
	}

	 @Test(priority = 4)
	@Description(" Verify that the user is able to view Detailed and statistical Booking Report for StayThrough.")
	@Severity(SeverityLevel.CRITICAL)
	@Epic("EP01")
	@Feature("Feature1: BookingReport Report")
	@Story("Story: BookingReport Report Page")
	@Step("Verify BookingReport Report Presence")
	public void bookingReport_TC_04() throws Exception {

		extentTest = extent.startTest("BookingReport_TC_04");
		logger.info("Test Case Started");
//		lp.login();
//		allureScreenshot("Login");
//
//		// Administrator Page
//
//		ahp.selectBrand();// Select the brand
//
//		ahp.selectProperty();// Select the property
//		allureScreenshot("Property");

//		ahp.selectReports();
		rep.selectBookingReport();

		rep.selectStayThroughradioBtn();
		rep.selectArrivalDateRange();

		allureScreenshot("Bookings");

		rep.detailedReport();

		Assert.assertTrue(rep.verifyStayThroughReport());
		allureScreenshot("DetailedBookingsReport");
		
		rep.DownloadReportPdf();
		Assert.assertTrue(rep.downloadDetailedBookingReports());
		
		rep.DownloadReportExcel();
		Assert.assertTrue(rep.downloadDetailedBookingReports());

		rep.selectBookingReport();

		rep.selectStayThroughradioBtn();
		rep.selectArrivalDateRange();

		allureScreenshot("Bookings");

		rep.statisticalReport();

		Assert.assertTrue(rep.verifyStayThroughReport());
		allureScreenshot("StatisticalBookingsReport");
		
		rep.DownloadReportPdf();
		Assert.assertTrue(rep.downloadStatisticalBookingReports());
		
		rep.DownloadReportExcel();
		Assert.assertTrue(rep.downloadStatisticalBookingReports());

		
		logger.info("Test Case Ended");

	}

	 @Test(priority = 5)
	@Description(" Verify that the user is able to view Detailed and statistical Booking Report for bookings and arrivals.")
	@Severity(SeverityLevel.CRITICAL)
	@Epic("EP01")
	@Feature("Feature1: BookingReport Report")
	@Story("Story: BookingReport Report Page")
	@Step("Verify BookingReport Report Presence")
	public void bookingReport_TC_05() throws Exception {

		extentTest = extent.startTest("BookingReport_TC_04");
		logger.info("Test Case Started");
//		lp.login();
//		allureScreenshot("Login");
//
//		// Administrator Page
//
//		ahp.selectBrand();// Select the brand
//
//		ahp.selectProperty();// Select the property
//		allureScreenshot("Property");
//
//		ahp.selectReports();
		
		rep.selectBookingReport();

		rep.selectBookingsRadioBtn();// Booking
		rep.selectArrivalradioBtn();// Arrival

		rep.selectBookingDateRange();
		rep.selectArrivalDateRange();

		allureScreenshot("Bookings");

		rep.detailedReport();

		Assert.assertTrue(rep.verifyBookingReport());
		allureScreenshot("DetailedBookingsReport");
		
		rep.DownloadReportPdf();
		Assert.assertTrue(rep.downloadDetailedBookingReports());
		
		rep.DownloadReportExcel();
		Assert.assertTrue(rep.downloadDetailedBookingReports());

		rep.selectBookingReport();

		rep.selectBookingsRadioBtn();// Booking
		rep.selectArrivalradioBtn();// Arrival

		rep.selectBookingDateRange();
		rep.selectArrivalDateRange();

		allureScreenshot("Bookings");

		rep.statisticalReport();

		Assert.assertTrue(rep.verifyBookingReport());
		allureScreenshot("StatisticalBookingsReport");


		
		logger.info("Test Case Ended");
	}

	 @Test(priority = 6)
	@Description(" Verify that the user is able to view Detailed and statistical Booking Report for booking and StayThrough.")
	@Severity(SeverityLevel.CRITICAL)
	@Epic("EP01")
	@Feature("Feature1: BookingReport Report")
	@Story("Story: BookingReport Report Page")
	@Step("Verify BookingReport Report Presence")
	public void bookingReport_TC_06() throws Exception {

		extentTest = extent.startTest("BookingReport_TC_06");
		logger.info("Test Case Started");
//		lp.login();
//		allureScreenshot("Login");
//
//		// Administrator Page
//
//		ahp.selectBrand();// Select the brand
//
//		ahp.selectProperty();// Select the property
//		allureScreenshot("Property");
//
//		ahp.selectReports();
		rep.selectBookingReport();

		rep.selectBookingsRadioBtn();// Booking
		rep.selectStayThroughradioBtn();//stayThrough
		
		rep.selectBookingDateRange();
		rep.selectArrivalDateRange();

		allureScreenshot("Bookings");

		rep.detailedReport();

		Assert.assertTrue(rep.verifyStayThroughReport());
		allureScreenshot("DetailedBookingsReport");
		
		rep.DownloadReportPdf();
		Assert.assertTrue(rep.downloadDetailedBookingReports());
		
		rep.DownloadReportExcel();
		Assert.assertTrue(rep.downloadDetailedBookingReports());

		rep.selectBookingReport();

		rep.selectBookingsRadioBtn();// Booking
		rep.selectStayThroughradioBtn();//stayThrough
		
		rep.selectBookingDateRange();
		rep.selectArrivalDateRange();

		allureScreenshot("Bookings");

		rep.statisticalReport();

		Assert.assertTrue(rep.verifyStayThroughReport());
		allureScreenshot("StatisticalBookingsReport");
		
		rep.DownloadReportPdf();
		Assert.assertTrue(rep.downloadStatisticalBookingReports());
		
		rep.DownloadReportExcel();
		Assert.assertTrue(rep.downloadStatisticalBookingReports());


		
		logger.info("Test Case Ended");

	}

	 @Test(priority = 7)
		@Description(" Verify that the user is able to view Detailed and statistical Booking Report for cancellations and arrivals.")
		@Severity(SeverityLevel.CRITICAL)
		@Epic("EP01")
		@Feature("Feature1: BookingReport Report")
		@Story("Story: BookingReport Report Page")
		@Step("Verify BookingReport Report Presence")
		public void bookingReport_TC_07() throws Exception {

			extentTest = extent.startTest("BookingReport_TC_07");
			logger.info("Test Case Started");
//			lp.login();
//			allureScreenshot("Login");
//
//			// Administrator Page
//
//			ahp.selectBrand();// Select the brand
//
//			ahp.selectProperty();// Select the property
//			allureScreenshot("Property");
//
//			ahp.selectReports();
			rep.selectBookingReport();

			rep.selectCancellationsRadioBtn();// Cancellations
			rep.selectArrivalradioBtn();// Arrival

			rep.selectBookingDateRange();
			rep.selectArrivalDateRange();

			allureScreenshot("Bookings");

			rep.detailedReport();

//			Assert.assertTrue(rep.verifyBookingReport());
			allureScreenshot("DetailedBookingsReport");
			
			rep.DownloadReportPdf();
			Assert.assertTrue(rep.downloadDetailedBookingReports());
			
			rep.DownloadReportExcel();
			Assert.assertTrue(rep.downloadDetailedBookingReports());

			rep.selectBookingReport();
			

			rep.selectCancellationsRadioBtn();// Cancellations
			rep.selectArrivalradioBtn();// Arrival

			rep.selectBookingDateRange();
			rep.selectArrivalDateRange();

			allureScreenshot("Bookings");

			rep.statisticalReport();

//			Assert.assertTrue(rep.verifyBookingReport());
			allureScreenshot("StatisticalBookingsReport");

			rep.DownloadReportPdf();
			Assert.assertTrue(rep.downloadStatisticalBookingReports());
			
			rep.DownloadReportExcel();
			Assert.assertTrue(rep.downloadStatisticalBookingReports());

			
			logger.info("Test Case Ended");
		}

		 @Test(priority = 8)
		@Description(" Verify that the user is able to view Detailed and statistical Booking Report for cancellations and StayThrough.")
		@Severity(SeverityLevel.CRITICAL)
		@Epic("EP01")
		@Feature("Feature1: BookingReport Report")
		@Story("Story: BookingReport Report Page")
		@Step("Verify BookingReport Report Presence")
		public void bookingReport_TC_08() throws Exception {

			extentTest = extent.startTest("BookingReport_TC_08");
			logger.info("Test Case Started");
//			lp.login();
//			allureScreenshot("Login");
//
//			// Administrator Page
//
//			ahp.selectBrand();// Select the brand
//
//			ahp.selectProperty();// Select the property
//			allureScreenshot("Property");
//
//			ahp.selectReports();
			rep.selectBookingReport();

			rep.selectCancellationsRadioBtn();// Cancellations
			rep.selectStayThroughradioBtn();//stayThrough
			
			rep.selectBookingDateRange();
			rep.selectArrivalDateRange();

			allureScreenshot("Bookings");

			rep.detailedReport();

			Assert.assertTrue(rep.verifyStayThroughReport());
			allureScreenshot("DetailedBookingsReport");
			
			rep.DownloadReportPdf();
			Assert.assertTrue(rep.downloadDetailedBookingReports());
			
			rep.DownloadReportExcel();
			Assert.assertTrue(rep.downloadDetailedBookingReports());

			rep.selectBookingReport();

			rep.selectCancellationsRadioBtn();// Cancellations
			rep.selectStayThroughradioBtn();//stayThrough
			
			rep.selectBookingDateRange();
			rep.selectArrivalDateRange();

			allureScreenshot("Bookings");

			rep.statisticalReport();

			Assert.assertTrue(rep.verifyStayThroughReport());
			allureScreenshot("StatisticalBookingsReport");
			
			rep.DownloadReportPdf();
			Assert.assertTrue(rep.downloadStatisticalBookingReports());
			
			rep.DownloadReportExcel();
			Assert.assertTrue(rep.downloadStatisticalBookingReports());

			lp.logout();
			logger.info("Test Case Ended");

		}

}
