package com.admin;

import org.junit.Assert;
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

public class SearchReservationReport extends TestBase {


	ExcelData e = new ExcelData();
	public static Utilitylog logger;

	public SearchReservationReport() {
		super();
		logger = new Utilitylog(SearchReservationReport.class.getName());
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

	@Test(priority=1)
	@Description("Verify that the user is able to view search reservation report using Confirmation Number")
	@Severity(SeverityLevel.CRITICAL)
	@Epic("EP01")
	@Feature("Feature1: search reservation Report")
	@Story("Story: search reservation Report Page")
	@Step("Verify search reservation Report Presence")
	public void searchReservationReport_TC_01() throws Exception {

		extentTest = extent.startTest("SearchReservationReport_TC_01");
		logger.info("Test Case Started");
		lp.login();
		allureScreenshot("Login");

		// Administrator Page

		ahp.selectBrand();// Select the brand

		ahp.selectProperty2();// Select the property
		allureScreenshot("Property");

		ahp.selectReports();

		rep.selectSearchReservationReport();
		rep.enterConfirmationNo();
		allureScreenshot("Confirmation No.");
		rep.quicksearch();
		Assert.assertTrue(rep.verifySearchResReportisvisible());
		allureScreenshot("SearchReservation Report");
		Assert.assertTrue(rep.verifyConfirmationNo());
		
		rep.DownloadReportPdf();
		Assert.assertTrue(rep.downloadSearchResReports());
		
		rep.DownloadReportExcel();
		Assert.assertTrue(rep.downloadSearchResReports());

		logger.info("Test Case Ended");

	}

	@Test(priority = 2)
	@Description("Verify that the user is able to view and download search reservation report using Check-In Date range")
	@Severity(SeverityLevel.CRITICAL)
	@Epic("EP01")
	@Feature("Feature1: search reservation Report")
	@Story("Story: search reservation Report Page")
	@Step("Verify search reservation Report Presence")
	public void searchReservationReport_TC_02() throws Exception {

		extentTest = extent.startTest("SearchReservationReport_TC_02");
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

		rep.selectSearchReservationReport();
		
		rep.selectArrivalDateRange();

		allureScreenshot("ArrivalDate");

		rep.quicksearch();

		Assert.assertTrue(rep.verifySearchResReportisvisible());
		allureScreenshot("SearchReservation Report");
		
		rep.DownloadReportPdf();
		Assert.assertTrue(rep.downloadSearchResReports());
		
		rep.DownloadReportExcel();
		Assert.assertTrue(rep.downloadSearchResReports());

	
		logger.info("Test Case Ended");

	}

	@Test(priority=3)
	@Description("Verify that the user is able to view and download search reservation report using Check-Out Date range")
	@Severity(SeverityLevel.CRITICAL)
	@Epic("EP01")
	@Feature("Feature1: search reservation Report")
	@Story("Story: search reservation Report Page")
	@Step("Verify search reservation Report Presence")
	public void searchReservationReport_TC_03() throws Exception {

		extentTest = extent.startTest("SearchReservationReport_TC_03");
		logger.info("Test Case Started");
//		lp.login();
//		allureScreenshot("Login");
//
//		// Administrator Page
//		ahp.selectBrand();// Select the brand
//
//		ahp.selectProperty();// Select the property
//		allureScreenshot("Property");
//
//		ahp.selectReports();
		rep.selectSearchReservationReport();
		rep.selectCheckOutDateRange();

		allureScreenshot("CheckoutDate");

		rep.quicksearch();

		Assert.assertTrue(rep.verifySearchResReportisvisible());
		allureScreenshot("SearchReservation Report");
		
		rep.DownloadReportPdf();
		Assert.assertTrue(rep.downloadSearchResReports());
		
		rep.DownloadReportExcel();
		Assert.assertTrue(rep.downloadSearchResReports());

		logger.info("Test Case Ended");

	}

	 @Test(priority=4)
	@Description("Verify that the user is able to view  and download search reservation report using Booking Date range")
	@Severity(SeverityLevel.CRITICAL)
	@Epic("EP01")
	@Feature("Feature1: search reservation Report")
	@Story("Story: search reservation Report Page")
	@Step("Verify search reservation Report Presence")
	public void searchReservationReport_TC_04() throws Exception {

		extentTest = extent.startTest("SearchReservationReport_TC_04");
		logger.info("Test Case Started");
//		lp.login();
//		allureScreenshot("Login");
//
//		// Administrator Page
//		ahp.selectBrand();// Select the brand
//
//		ahp.selectProperty();// Select the property
//		allureScreenshot("Property");
//
//		ahp.selectReports();

		rep.selectSearchReservationReport();
		rep.selectBookingDateRange();

		allureScreenshot("BookingDate");

		rep.quicksearch();

		Assert.assertTrue(rep.verifySearchResReportisvisible());
		allureScreenshot("SearchReservation Report");
		
		rep.DownloadReportPdf();
		Assert.assertTrue(rep.downloadSearchResReports());
		
		rep.DownloadReportExcel();
		Assert.assertTrue(rep.downloadSearchResReports());

		logger.info("Test Case Ended");

	}

	@Test(priority = 5)
	@Description("Verify that the user is not able to view search reservation report if either From or To Date range is missing along with confirmation number")
	@Severity(SeverityLevel.CRITICAL)
	@Epic("EP01")
	@Feature("Feature1: search reservation Report")
	@Story("Story: search reservation Report Page")
	@Step("Verify search reservation Report Presence")
	public void searchReservationReport_TC_05() throws Exception {

		extentTest = extent.startTest("SearchReservationReport_TC_05");
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

		rep.selectSearchReservationReport();
		rep.selectBookingFromDateRange();

		allureScreenshot("FromDate");

		rep.quicksearch();

		Assert.assertTrue(rep.verifySearchResReportErrormsg());
		allureScreenshot("SearchReservation Report");
		
	

		lp.logout();
		logger.info("Test Case Ended");

	}

}
