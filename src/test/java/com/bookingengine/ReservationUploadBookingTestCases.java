package com.bookingengine;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.admin.pom.AdministratorHomePage;
import com.admin.pom.BrandPage;
import com.admin.pom.LoginPage;
import com.admin.pom.PropertyBrandingPage;
import com.be.pom.ReservationUploadBookingPage;
import base.TestBase;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import io.qameta.allure.Story;
import logfile.Utilitylog;

/*
* Test class for Reservation Upload Booking
* @Author : UzairAsar
*/
public class ReservationUploadBookingTestCases extends TestBase {
	public static Utilitylog logger;
	LoginPage lp;
	BrandPage bp;
	PropertyBrandingPage pbp;
	AdministratorHomePage ahp;
	SoftAssert soft;
	ReservationUploadBookingPage rubp;

	public ReservationUploadBookingTestCases() {
		super();
		logger = new Utilitylog(ReservationUploadBookingTestCases.class.getName());
	}

	@BeforeMethod
	public void setup() {
		lp = new LoginPage(getDriver());
		bp = new BrandPage(getDriver());
		ahp = new AdministratorHomePage(getDriver());
		soft = new SoftAssert();
		pbp = new PropertyBrandingPage(getDriver());
		rubp = new ReservationUploadBookingPage(getDriver());

	}

	@Test(priority = 1)
	@Description("Verify user should be able to delete a reservation in the middle of creation of booking through reservation upload booking in CRS admin.")
	@Severity(SeverityLevel.NORMAL)
	@Epic("EP01")
	@Feature("Feature1: Reservation Upload Booking")
	@Story("Story: Delete reservation while creating booking")
	@Step("Verify reservation can be deleted while creating booking")
	public void BookingEngine_ReservationUploadBookings_TC_01() {
		
		logger.info("CRS Started");
		extentTest = extent.startTest("BookingEngine_ReservationUploadBookings_TC_01");
		lp.login();
		allureScreenshot("Login");
		screenShot("Login");
		bp.openBrands();
		allureScreenshot("Brands Open");
		screenShot("Brands Open");
		bp.brandSelect();
		pbp.selectProperty();
		allureScreenshot("Property Selected");
		screenShot("Property Selected");
		rubp.reservationManagementTab();
		rubp.downloadLinkReservationTemplate();
		rubp.fillingReservationData();
		rubp.uploadFile();
		rubp.deleteFile();
		allureScreenshot("Pop up to Delete");
		screenShot("Pop up to Delete");
		rubp.alertPopUp();
		Assert.assertTrue(rubp.verifyDeletion());
		System.out.println("Reservation Creation file Successfully Deleted");
		
	}
	
	@Test(priority = 2)
	@Description("Verify user should be able to book a reservation through reservation upload booking in CRS admin.")
	@Severity(SeverityLevel.CRITICAL)
	@Epic("EP01")
	@Feature("Feature1: Reservation Upload Booking")
	@Story("Story: Reservation can be done with reservation upload booking")
	@Step("Verify reservation can be done with reservation upload booking")
	public void BookingEngine_ReservationUploadBookings_TC_02() {
		
		rubp.uploadFile();
		allureScreenshot("Cancellation File Uploading");
		screenShot("Cancellation File Uploading");
		rubp.createReservation();
		rubp.outputFile();
		allureScreenshot("Reservation File Uploaded");
		screenShot("Reservation File Uploaded");
		String bookingStatus = rubp.statusOfBooking();
		Assert.assertEquals(bookingStatus, "PASS");
		System.out.println("Reservation Completed");
		
	}
	
	@Test(priority = 3)
	@Description("Verify user should be able to delete a reservation in middle of modify a reservation through reservation upload booking in CRS admin.")
	@Severity(SeverityLevel.NORMAL)
	@Epic("EP01")
	@Feature("Feature1: Reservation Upload Booking")
	@Story("Story: Delete reservation while modifying booking")
	@Step("Verify reservation can be deleted while modifying booking")
	public void BookingEngine_ReservationUploadBookings_TC_03() {
		
		extentTest = extent.startTest("BookingEngine_ReservationUploadBookings_TC_03");
		rubp.modification();
		rubp.uploadFile();
		rubp.deleteFile();
		allureScreenshot("Pop up to Delete");
		screenShot("Pop up to Delete");
		rubp.alertPopUp();
		Assert.assertTrue(rubp.verifyDeletion());
		System.out.println("Reservation Modification file Successfully Deleted");
		
		
	}
	
	@Test(priority = 4)
	@Description("Verify user should be able to modify a reservation through reservation upload booking in CRS admin.")
	@Severity(SeverityLevel.CRITICAL)
	@Epic("EP01")
	@Feature("Feature1: Reservation Upload Booking")
	@Story("Story: Modification can be done with reservation upload booking")
	@Step("Verify Modification can be done with reservation upload booking")
	public void BookingEngine_ReservationUploadBookings_TC_04() {
		
		extentTest = extent.startTest("BookingEngine_ReservationUploadBookings_TC_04");
		rubp.uploadFile();
		allureScreenshot("Modification File Uploading");
		screenShot("Modification File Uploading");
		rubp.createReservation();
		rubp.outputFile();
		allureScreenshot("Modification File Uploaded");
		screenShot("Modification File Uploaded");
		String bookingStatus = rubp.statusOfBooking();
		Assert.assertEquals(bookingStatus, "PASS");
		System.out.println("Modification Completed");
		
	}
	
	@Test(priority = 5)
	@Description("Verify user should be able to delete a reservation in middle of canceling of reservation through reservation upload booking in CRS admin.")
	@Severity(SeverityLevel.NORMAL)
	@Epic("EP01")
	@Feature("Feature1: Reservation Upload Booking")
	@Story("Story: Delete reservation while cancelling booking")
	@Step("Verify reservation can be deleted while cancelling booking")
	public void BookingEngine_ReservationUploadBookings_TC_05() {
		
		extentTest = extent.startTest("BookingEngine_ReservationUploadBookings_TC_05");
		rubp.cancellation();
		rubp.uploadFile();
		rubp.deleteFile();
		allureScreenshot("Pop up to Delete");
		screenShot("Pop up to Delete");
		rubp.alertPopUp();
		Assert.assertTrue(rubp.verifyDeletion());
		System.out.println("Reservation Cancellation file Successfully Deleted");
		
	}
	
	@Test(priority = 6)
	@Description("Verify user should be able to cancel a reservation through reservation upload booking in CRS admin.")
	@Severity(SeverityLevel.CRITICAL)
	@Epic("EP01")
	@Feature("Feature1: Reservation Upload Booking")
	@Story("Story: Cancellation can be done with reservation upload booking")
	@Step("Verify cancellation can be done with reservation upload booking")
	public void BookingEngine_ReservationUploadBookings_TC_06() {
		
		extentTest = extent.startTest("BookingEngine_ReservationUploadBookings_TC_06");
		rubp.uploadFile();
		allureScreenshot("Cancellation File Uploading");
		screenShot("Cancellation File Uploading");
		rubp.createReservation();
		rubp.outputFile();
		allureScreenshot("Cancellation File Uploaded");
		screenShot("Cancellation File Uploaded");
		String bookingStatus = rubp.statusOfBooking();
		Assert.assertEquals(bookingStatus, "PASS");
		System.out.println("Cancellation Completed");
		logger.info("CRS Closed");
		
	}
	
}
