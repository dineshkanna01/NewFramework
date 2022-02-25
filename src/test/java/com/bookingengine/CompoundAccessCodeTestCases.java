package com.bookingengine;

import static org.testng.Assert.assertTrue;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.admin.pom.AdministratorHomePage;
import com.admin.pom.BrandPage;
import com.admin.pom.ChannelPage;
import com.admin.pom.LoginPage;
import com.admin.pom.NewPropertyPage;
import com.admin.pom.PropertyBrandingPage;
import com.be.pom.JCCBookingsPage;
import com.be.pom.CompoundAccessCodePage;
import com.be.pom.FBPStrikeThroughPricingPage;
import com.be.pom.PropertyLevelRestrictionPage;
import com.be.pom.SmartRateTestingPage;

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

/*
 * Test class for Compound Access Code
 * @Author : UzairAsar
 */
public class CompoundAccessCodeTestCases extends TestBase {
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

	public CompoundAccessCodeTestCases() {
		super();
		logger = new Utilitylog(CompoundAccessCodeTestCases.class.getName());
	}

	@BeforeMethod
	public void setup() {
		lp = new LoginPage(getDriver());
		pbp = new PropertyBrandingPage(getDriver());
		bp = new BrandPage(getDriver());
		cp = new ChannelPage(getDriver());
		plrp = new PropertyLevelRestrictionPage(getDriver());
		srtp = new SmartRateTestingPage(getDriver());
		npp = new NewPropertyPage(getDriver());
		ahp = new AdministratorHomePage(getDriver());
		cacp = new CompoundAccessCodePage(getDriver());
		jbp = new JCCBookingsPage(getDriver());
		fbp = new FBPStrikeThroughPricingPage(getDriver());

	}

	@Test(priority = 1)
	@Description("Verify user should be able to book a reservation using compound access code in Booking Engine.")
	@Severity(SeverityLevel.CRITICAL)
	@Epic("EP01")
	@Feature("Feature1: Compound Access Code")
	@Story("Story: Reservation can be book with compound access code")
	@Step("Verify reservation can be book with compound access code")
	public void BookingEngine_CompoundAccessCodeBookings_TC_01() {

		logger.info("CRS Started");
		extentTest = extent.startTest("BookingEngine_CompoundAccessCodeBookings_TC_01");
		lp.login();
		allureScreenshot("Logged In");
		screenShot("Logged In");
		bp.openBrands();
		allureScreenshot("Brands Open");
		screenShot("Brands Open");
		bp.brandSelect();
		pbp.selectProperty();
		logger.info("Booking Engine Started");
		openURL("be_url2");
		plrp.availabilityCheck();
		String buttonCheck = plrp.verifyBookNowBtn();
		Assert.assertEquals(buttonCheck, "BOOK NOW");
		allureScreenshot("Booking Available");
		screenShot("Booking Available");
		plrp.bookNow();
		Helper.switchWindow(0);
		cp.openPropertyTab();
		srtp.adminPropertyEdit();
		srtp.adminDisableSamrtRate();
		cacp.compoundAccessCodeEnable();
		allureScreenshot("Compound Access Code Enabled");
		screenShot("Compound Access Code Enabled");
		String editSave = npp.verifyEditSaveButton();
		Assert.assertEquals(editSave, "Save");
		npp.propertyEditPageSaveButton();
		srtp.adminConfirmOkButton();
		fbp.propertyDefaults();
		fbp.enableFBP();
		fbp.propertyDefaultsSaveButton();
		srtp.adminRatePlanTab();
		allureScreenshot("Compound Access Code Option");
		screenShot("Compound Access Code Option");
		assertTrue(cacp.verifyAdminCompoundAccessCode());
		System.out.println("Compound Access Code is Enabled");
		cacp.adminCompoundAccessCode();
		cacp.addingCompoundAccessCode();
		allureScreenshot("Adding Compound Access Code");
		screenShot("Adding Compound Access Code");
		cacp.saveCompoundAccessCode();
		assertTrue(cacp.verifyCompoundAccessCodeAdded());
		allureScreenshot("Compound Access Code added");
		screenShot("Compound Access Code added");
		String adminRatePlanAssociated = cacp.ratePlanAssociated();
		Helper.switchWindow(1);
		getDriver().navigate().back();
		cacp.beApplyCompoundAccessCode();
		cacp.checkAvailabilityButton();
		allureScreenshot("Compound Access Code applied in BE");
		screenShot("Compound Access Code applied in BE");
		Helper.sleep(2000);
		plrp.bookNow();
		Helper.sleep(3000);
		String RatePlanAssociatedBE = cacp.ratePlanAssociatedBE();
		Assert.assertEquals(adminRatePlanAssociated, RatePlanAssociatedBE);
		allureScreenshot("Compound Access Code Rate plan");
		screenShot("Compound Access Code Rate Plan");

	}

	@Test(priority = 2)
	@Description("Verify user should be able to change rate plans associated with compound access code.")
	@Severity(SeverityLevel.CRITICAL)
	@Epic("EP01")
	@Feature("Feature1: Compound Access Code")
	@Story("Story: Change Rate Plan in Compound Access Code")
	@Step("Verify Rate Plan can be change in Compound Access Code")
	public void BookingEngine_CompoundAccessCodeBookings_TC_02() {

		extentTest = extent.startTest("BookingEngine_CompoundAccessCodeBookings_TC_02");
		Helper.switchWindow(0);
		cacp.editCompoundAccessCode();
		allureScreenshot("Changing Rate plan");
		screenShot("Changing Rate Plan");
		cacp.saveCompoundAccessCode();
		allureScreenshot("Rate plan Changed");
		screenShot("Rate Plan Changed");
		String adminRatePlanAssociated = cacp.ratePlanAssociated();
		Helper.switchWindow(1);
		getDriver().navigate().refresh();
		Helper.sleep(2000);
		String RatePlanAssociatedBE = cacp.ratePlanAssociatedBE();
		Assert.assertEquals(adminRatePlanAssociated, RatePlanAssociatedBE);
		allureScreenshot("Compound Access Code with New Rate Plan");
		screenShot("Compound Access Code with New Rate Plan");

	}

	@Test(priority = 3)
	@Description("Verify user should be able to delete compound access code.")
	@Severity(SeverityLevel.CRITICAL)
	@Epic("EP01")
	@Feature("Feature1: Compound Access Code")
	@Story("Story: Delete Compound Access Code")
	@Step("Verify compound access code deleted")
	public void BookingEngine_CompoundAccessCodeBookings_TC_03() {

		extentTest = extent.startTest("BookingEngine_CompoundAccessCodeBookings_TC_03");
		cacp.ratePlanAssociatedBE();
		Helper.switchWindow(0);
		cacp.deleteCompoundAccessCode();
		allureScreenshot("Compound Access Code Deleted");
		screenShot("Compound Access Code Deleted");
		Helper.switchWindow(1);
		getDriver().navigate().refresh();
		Helper.sleep(1000);
		assertTrue(cacp.verifyRoomCharge());
		allureScreenshot("Compound Access Code removed from BE");
		screenShot("Compound Access Code removed from BE");

	}

	@Test(priority = 4)
	@Description("Verify user should be able to book a reservation directly through rate plan link in compound access code  in CRS admin.")
	@Severity(SeverityLevel.CRITICAL)
	@Epic("EP01")
	@Feature("Feature1: Compound Access Code")
	@Story("Story: Reservation through Compound Access Code link")
	@Step("Verify reservation through Compound Access Code link")
	public void BookingEngine_CompoundAccessCodeBookings_TC_04() {

		extentTest = extent.startTest("BookingEngine_CompoundAccessCodeBookings_TC_04");
		Helper.switchWindow(0);
		cacp.addingCompoundAccessCode();
		cacp.saveCompoundAccessCode();
		assertTrue(cacp.verifyCompoundAccessCodeAdded());
		allureScreenshot("Link Available");
		screenShot("Link Available");
		cacp.compoundAccessCodeBookingLink();
		cacp.availabilityCheck();
		String buttonCheck = plrp.verifyBookNowBtn();
		Assert.assertEquals(buttonCheck, "BOOK NOW");
		allureScreenshot("Booking Available");
		screenShot("Booking Available");
		plrp.bookNow();
		jbp.inputGuestDetails();
		jbp.clickconfirmDetails();
		allureScreenshot("Payment Page");
		screenShot("Payment Page");
		jbp.inputCardDetailsTC01();
		jbp.inputBillingAddress();
		jbp.inputadditionalContactInfo();
		jbp.selectTermsAndConditonCheckbox();
		jbp.clickCompleteReservation();
		allureScreenshot("Booking Completed");
		screenShot("Booking Completed");
		Helper.refreshAdmin("admin_url");
		lp.login();
		allureScreenshot("Logged In");
		screenShot("Logged In");
		bp.openBrands();
		allureScreenshot("Brands Open");
		screenShot("Brands Open");
		bp.brandSelect();
		pbp.selectProperty();
		srtp.adminRatePlanTab();
		cacp.adminCompoundAccessCode();
		cacp.deleteCompoundAccessCode();
		allureScreenshot("Compound Access Code Deleted");
		screenShot("Compound Access Code Deleted");
		cp.openPropertyTab();
		srtp.adminPropertyEdit();
		cacp.compoundAccessCodeDisable();
		String editSave = npp.verifyEditSaveButton();
		Assert.assertEquals(editSave, "Save");
		npp.propertyEditPageSaveButton();
		srtp.adminConfirmOkButton();
		fbp.propertyDefaults();
		fbp.disableFBP();
		fbp.propertyDefaultsSaveButton();
		lp.logout();
		logger.info("CRS Closed");
		logger.info("Booking Engine Closed");
		
	}
}
