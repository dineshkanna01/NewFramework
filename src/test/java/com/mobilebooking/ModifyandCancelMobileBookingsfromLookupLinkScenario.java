package com.mobilebooking;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.admin.pom.AdministratorHomePage;
import com.admin.pom.LoginPage;
import com.mb.pom.ModifyandCancelMobileBookingsfromLookupLinkPages;

import base.Helper;
import base.TestBase;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import io.qameta.allure.Story;
import logfile.Utilitylog;

public class ModifyandCancelMobileBookingsfromLookupLinkScenario extends TestBase {
	public static Utilitylog logger;

		public ModifyandCancelMobileBookingsfromLookupLinkScenario() {
			super();
			logger = new Utilitylog(ModifyandCancelMobileBookingsfromLookupLinkScenario.class.getName());
		}

		// objects
		LoginPage lp;
		AdministratorHomePage ahp;
		ModifyandCancelMobileBookingsfromLookupLinkPages mcblp;
		@BeforeMethod
		public void setup() {
			lp = new LoginPage(getDriver());
			ahp = new AdministratorHomePage(getDriver());
			mcblp=new ModifyandCancelMobileBookingsfromLookupLinkPages(getDriver());
		}
		@Test(priority = 1)
		@Description("Verify user should able to do mobile booking and cancellation using look up")
		@Severity(SeverityLevel.CRITICAL)
		@Epic("EP01")
		@Feature("Feature1:Cancel Mobile Bookings from Lookup Link Scenario")
		@Story("Cancel Mobile Bookings from Lookup Link Scenario")
		@Step("Verify user should able to do mobile booking and cancellation using look up")
		public void MobileBookingUsingPromoURL_TC_01()  {
			extentTest = extent.startTest("ModifyandCancelMobileBookingsfromLookupLinkScenario");
			getDriver().quit();
		mobileTest("Moto G4", 318,850);
		mcblp.dateSelection();
		allureScreenshot("Date selected");
		screenShot("Date selected");
		mcblp.noAdult();
		mcblp.selectRoom();
		mcblp.avlOffers();
		allureScreenshot("Offer selected");
		screenShot("Offer selected");
		mcblp.comReservation();
		allureScreenshot("Confirmation page");
		screenShot("Confirmation page");
		mcblp.getConfirmationNo();
		//mcblp.getConfirmationMailId();
		mcblp.MobLookup();
		mcblp.scrollDownTen();
		mcblp.clickOnCancelinMobWebBEReservation();
		allureScreenshot("Cancel Booking From Mobile");
		screenShot("Cancel Booking From Mobile");
		Assert.assertTrue(mcblp.verifyMobileCancellationCode());
		Helper.refreshURL();
	}
		@Test(priority = 2)
		@Description("Verify user should able to do mobile booking and modify using look up")
		@Severity(SeverityLevel.CRITICAL)
		@Epic("EP01")
		@Feature("Feature1:Cancel Mobile Bookings from Lookup Link Scenario")
		@Story("Cancel Mobile Bookings from Lookup Link Scenario")
		@Step("Verify user should able to do mobile booking and modify using look up")
		public void MobileBookingUsingPromoURL_TC_02()  {
		extentTest = extent.startTest("ModifyandCancelMobileBookingsfromLookupLinkScenario");
		getDriver().quit();
		mobileTest("Moto G4", 318,850);
		mcblp.dateSelection();
		allureScreenshot("Date selected");
		screenShot("Date selected");
		mcblp.noAdult();
		mcblp.selectRoom();
		mcblp.avlOffers();
		allureScreenshot("Offer selected");
		screenShot("Offer selected");
		mcblp.comReservation();
		allureScreenshot("Confirmation page");
		screenShot("Confirmation page");
		mcblp.getConfirmationNo();
		//mcblp.getConfirmationMailId();
		mcblp.MobLookup();
		mcblp.scrollDownTen();
		mcblp.clickOnCallHotelinMobWebBEReservation();
		allureScreenshot("Cancel Booking From Mobile lookup");
		screenShot("Cancel Booking From Mobile look up");
		Assert.assertTrue(mcblp.verifyCallHotelOption());
		getDriver().close();
		
	}
		
	}

