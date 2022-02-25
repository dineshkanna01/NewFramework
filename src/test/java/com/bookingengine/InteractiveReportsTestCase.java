package com.bookingengine;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.admin.pom.AdministratorHomePage;
import com.admin.pom.BrandPage;
import com.admin.pom.ChannelPage;
import com.admin.pom.LoginPage;
import com.admin.pom.NewPropertyPage;
import com.admin.pom.PropertyBrandingPage;
import com.be.pom.JCCBookingsPage;
import com.be.pom.CompoundAccessCodePage;
import com.be.pom.FBPStrikeThroughPricingPage;
import com.be.pom.InteractiveReportsPage;
import com.be.pom.PropertyLevelRestrictionPage;
import com.be.pom.SmartRateTestingPage;

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
* Test class for Compound Access Code
* @Author : UzairAsar
*/
public class InteractiveReportsTestCase extends TestBase {
	public static Utilitylog logger;
	LoginPage lp;
	BrandPage bp;
	PropertyBrandingPage pbp;
	ChannelPage cp;
	PropertyLevelRestrictionPage plrp;
	SmartRateTestingPage srtp;
	NewPropertyPage npp;
	AdministratorHomePage ahp;
	CompoundAccessCodePage cacp;
	JCCBookingsPage jbp;
	FBPStrikeThroughPricingPage fbp;
	SoftAssert soft;
	InteractiveReportsPage irp;

	public InteractiveReportsTestCase() {
		super();
		logger = new Utilitylog(InteractiveReportsTestCase.class.getName());
	}

	@BeforeMethod
	public void setup() {
		lp = new LoginPage(getDriver());
		bp = new BrandPage(getDriver());
		ahp = new AdministratorHomePage(getDriver());
		cacp = new CompoundAccessCodePage(getDriver());
		jbp = new JCCBookingsPage(getDriver());
		fbp = new FBPStrikeThroughPricingPage(getDriver());
		soft= new SoftAssert();
		irp = new InteractiveReportsPage(getDriver());

	}

	@Test(priority = 1)
	@Description("Verify user should be able to see Rate plan analysis via booking dates in interactive reports.")
	@Severity(SeverityLevel.CRITICAL)
	@Epic("EP01")
	@Feature("Feature1: Formula Based Pricing")
	@Story("Story: Reservation can be book with compound access code")
	@Step("Verify reservation can be book with compound access code")
	public void BookingEngine_InteractiveReportsshowingallabovebookings_TC_01() {
		logger.info("CRS Started");
		extentTest = extent.startTest("BookingEngine_InteractiveReportsshowingallabovebookings_TC_01");

		lp.login();

		allureScreenshot("Logged In");
		screenShot("Logged In");

		bp.openBrands();

		allureScreenshot("Brands Open");
		screenShot("Brands Open");

		bp.brandSelect();

		pbp.selectProperty();

		irp.openInteractiveReports();
		
		
		
		
		
		
		
		
		
		

//		openBEurlinNewTab();
//
//		plrp.availabilityCheck();
//		String buttonCheck = plrp.verifyBookNowBtn();
//		
//		soft.assertEquals(buttonCheck, "BOOK NOW");
//
//		allureScreenshot("Booking Available");
//		screenShot("Booking Available");
//
//		plrp.bookNow();
//
//		soft.assertEquals(fbp.verifyOnyBARIsThere(), "BAR");
//
//		switchWindow(0);
//
//		cp.openPropertyTab();
//		fbp.propertyDefaults();
//		fbp.enableFBP();
//		fbp.propertyDefaultsSaveButton();
//
//		srtp.adminRatePlanTab();
//
//		allureScreenshot("Compound Access Code Option");
//		screenShot("Compound Access Code Option");
//
//		soft.assertTrue(fbp.verifyManageFBP());
//		System.out.println("Manage FBP is Enabled");
//
//		srtp.adminListAllRatePlan();
//		fbp.editFloatingRatePlanNameForFBP();
//		String beforeAmount = fbp.pickAmountFromRatePlanBE();
//		
//		switchWindow(0);
//		fbp.selectFlatAmountOption();
//		fbp.inputAmount();
//		srtp.adminSmartRateSaveButton();
//		
//		String fbpSaveText = fbp.verifyFBPSavedText();
//		soft.assertEquals(fbpSaveText, "List of Rate Plans");
//		System.out.println("FBP saved for Floating Rate by Flat Amount");
//
//		fbp.editFloatingRatePlanNameForFBP();
//		
//		
//		String afterAmount = fbp.pickAmountFromRatePlanBE();
//
//		soft.assertNotEquals(beforeAmount, afterAmount);
		

	}
}
