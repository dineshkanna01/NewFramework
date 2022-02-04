package com.bookingengine;


import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.admin.AboutPropertyCreationScenario;
import com.admin.pom.AboutThePropertyPages;
import com.admin.pom.AdministratorHomePage;
import com.admin.pom.LoginPage;
import com.be.pom.URLParameterBookings;

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

public class URLParameterBookingsScenario extends TestBase {

	public static Utilitylog logger;

	ExcelData e = new ExcelData();

	public URLParameterBookingsScenario() {
		super();
		logger = new Utilitylog(URLParameterBookingsScenario.class.getName());
	}

	// objects
	LoginPage lp;
	AdministratorHomePage ahp;
	URLParameterBookings upb;

	@BeforeMethod
	public void setup() {

		lp = new LoginPage(getDriver());
		ahp = new AdministratorHomePage(getDriver());
		upb=new URLParameterBookings (getDriver());
	}


	@Test(priority = 1)
	@Description("Verify that user should be able to make a URL Parameter booking")
	@Severity(SeverityLevel.CRITICAL)
	@Epic("EP01")
	@Feature("Feature1:URL Parameter booking scenario")
	@Story("URL Parameter booking scenario")
	@Step("Verify that user should be able to URL Parameter booking scenario")
	public void URLParameterBooking_TC_01()  {
		extentTest = extent.startTest("URLParameterBooking_TC_01");

		openBEUrlParameter();

		upb.makeAReservationInURLParameterbooking();
		
		allureScreenshot("ReservationSuccessful");
        screenShot("ReservationSuccessful");
		
		upb.verifyReservationSuccessful();
		Assert.assertTrue(upb.verifyReservationSuccessful());
		
		
	}
	

	@Test(priority = 2)
	@Description("Verify that user should be able to make and change a URL Parameter booking")
	@Severity(SeverityLevel.CRITICAL)
	@Epic("EP01")
	@Feature("Feature1:URL Parameter booking scenario")
	@Story("URL Parameter booking scenario")
	@Step("Verify that user should be able to URL Parameter booking scenario")
	public void URLParameterBooking_TC_02()  {
		extentTest = extent.startTest("URLParameterBooking_TC_02");

		openBEUrlParameter();

		upb.makeAReservationToModifyInURLParameterbooking();
		allureScreenshot("ReservationToChangeSuccessful");
        screenShot("ReservationToChangeSuccessful");
        
		Assert.assertTrue(upb.verifyChangedReservation());
		
		upb.clickOnChangeReservation();
		
		upb.changeAReservationToModifyInURLParameterbooking();
		allureScreenshot("ReservationChangedSuccessful");
        screenShot("ReservationChangedSuccessful");
		Assert.assertFalse(upb.verifyChangedReservation());
		
	}
	
	@Test(priority = 3)
	@Description("Verify that user should be able to make and cancel a URL Parameter booking")
	@Severity(SeverityLevel.CRITICAL)
	@Epic("EP01")
	@Feature("Feature1:URL Parameter booking scenario")
	@Story("URL Parameter booking scenario")
	@Step("Verify that user should be able to URL Parameter booking scenario")
	public void URLParameterBooking_TC_03()  {
		extentTest = extent.startTest("URLParameterBooking_TC_03");

		openBEUrlParameter();

		upb.makeAReservationToCancelInURLParameterbooking();
		allureScreenshot("ReservationToCancelSuccessful");
        screenShot("ReservationToCancelSuccessful");
        
		Assert.assertTrue(upb.verifyReservationSuccessful());
		upb.clickOncancelReservation();
		
		allureScreenshot("ReservationCancelledSuccessful");
        screenShot("ReservationCancelledSuccessful");
		
		Assert.assertTrue(upb.verifyReservationCancelationSuccessful());
		
	}
	
	@Test(priority = 4)
	@Description("Verify that user should be able to book another room from confirmation page")
	@Severity(SeverityLevel.CRITICAL)
	@Epic("EP01")
	@Feature("Feature1:URL Parameter booking scenario")
	@Story("URL Parameter booking scenario")
	@Step("Verify that user should be able to book another room from confirmation page")
	public void URLParameterBooking_TC_04()  {
		extentTest = extent.startTest("URLParameterBooking_TC_04");

		openBEUrlParameter();

		upb.makeAReservationToBookAnotherRoomInURLParameterbooking();
		allureScreenshot("Reservation1Successful");
        screenShot("Reservation1Successful");
        
		Assert.assertTrue(upb.verifyReservation1Successful());
		
		upb.clickOnbookAnotherRoom();
		
		upb.BookAnotherRoomFromConfirmationPageInURLParameterbooking();
		allureScreenshot("Reservation2Successful");
        screenShot("Reservation2Successful");
        
		Assert.assertTrue(upb.verifyReservation2Successful());
		
		lp.browserClose();
		
	}
	
	@AfterSuite
	public void report() throws Exception {

		mail();

		cmdPrompt();
	}

}
