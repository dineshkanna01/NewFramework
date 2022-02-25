package com.bookingengine;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.admin.pom.BrandPage;
import com.admin.pom.LoginPage;
import com.be.pom.JCCBookingsPage;
import com.be.pom.FBPStrikeThroughPricingPage;
import com.be.pom.PropertyLevelRestrictionPage;
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
 * Test class for Booking Engine Classic Flow
 * @Author : UzairAsar
 */
public class BEClassicFlowTestCase extends TestBase {
	public static Utilitylog logger;
	LoginPage lp;
	BrandPage bp;
	PropertyLevelRestrictionPage plrp;
	JCCBookingsPage jbp;
	FBPStrikeThroughPricingPage fbp;
	SoftAssert soft;

	public BEClassicFlowTestCase() {
		super();
		logger = new Utilitylog(BEClassicFlowTestCase.class.getName());
	}

	@BeforeMethod
	public void setup() {
		lp = new LoginPage(getDriver());
		bp = new BrandPage(getDriver());
		jbp = new JCCBookingsPage(getDriver());
		fbp = new FBPStrikeThroughPricingPage(getDriver());
		soft = new SoftAssert();
		plrp = new PropertyLevelRestrictionPage(getDriver());

	}

	@Test(priority = 1)
	@Description("Verify user should be able to do reservation through booking engine classic flow.")
	@Severity(SeverityLevel.CRITICAL)
	@Epic("EP01")
	@Feature("Feature1: Booking Engine Classic Flow")
	@Story("Story: Reservation through classic flow")
	@Step("Verify reservation can be book with classic flow")
	public void BookingEngine_BookingEngineclassicFlow_TC_01() {

		logger.info("CRS Started");
		extentTest = extent.startTest("BookingEngine_BookingEngineclassicFlow_TC_01");
		logger.info("Booking Engine Started");
		openURL("be_url2");
		plrp.availabilityCheck();
		String buttonCheck = plrp.verifyBookNowBtn();
		soft.assertEquals(buttonCheck, "BOOK NOW");
		allureScreenshot("Booking Available");
		screenShot("Booking Available");
		plrp.bookNow();
		soft.assertEquals(fbp.verifyOnyBARIsThere(), "BAR");
		jbp.inputGuestDetails();
		jbp.clickconfirmDetails();
		allureScreenshot("Payment Page");
		screenShot("Payment Page");
		jbp.inputCardDetailsTC01();
		jbp.inputBillingAddress();
		jbp.inputadditionalContactInfo();
		jbp.selectTermsAndConditonCheckbox();
		jbp.clickCompleteReservation();
		soft.assertTrue(fbp.verifyReservationCompleted());
		allureScreenshot("Booking Completed");
		screenShot("Booking Completed");
		logger.info("Booking Engine Closed");
		logger.info("CRS Closed");

	}
}
