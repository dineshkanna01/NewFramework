package com.bookingengine;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.admin.pom.AdministratorHomePage;
import com.admin.pom.BrandPage;
import com.admin.pom.ChannelPage;
import com.admin.pom.LoginPage;
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
* Test class for FBP Strike Through Pricing
* @Author : UzairAsar
*/
public class FBPStrikeThroughPricingTestCase extends TestBase {
	public static Utilitylog logger;
	LoginPage lp;
	BrandPage bp;
	PropertyBrandingPage pbp;
	ChannelPage cp;
	PropertyLevelRestrictionPage plrp;
	SmartRateTestingPage srtp;
	AdministratorHomePage ahp;
	CompoundAccessCodePage cacp;
	JCCBookingsPage jbp;
	FBPStrikeThroughPricingPage fbp;
	SoftAssert soft;

	public FBPStrikeThroughPricingTestCase() {
		super();
		logger = new Utilitylog(FBPStrikeThroughPricingTestCase.class.getName());
	}

	@BeforeMethod
	public void setup() {
		lp = new LoginPage(getDriver());
		bp = new BrandPage(getDriver());
		cp = new ChannelPage(getDriver());
		ahp = new AdministratorHomePage(getDriver());
		cacp = new CompoundAccessCodePage(getDriver());
		jbp = new JCCBookingsPage(getDriver());
		fbp = new FBPStrikeThroughPricingPage(getDriver());
		soft = new SoftAssert();
		pbp = new PropertyBrandingPage(getDriver());
		plrp = new PropertyLevelRestrictionPage(getDriver());
		srtp = new SmartRateTestingPage(getDriver());
		

	}

	@Test(priority = 1)
	@Description("Verify user should be able to verify the amount change in the Booking engine when FBP is added as flat amount.")
	@Severity(SeverityLevel.CRITICAL)
	@Epic("EP01")
	@Feature("Feature1: Formula Based Pricing")
	@Story("Story: Amount changed when flat amount FBP is applied")
	@Step("Verify amount changed when flat amount FBP is applied")
	public void BookingEngine_FBPStrikeThroughPricing_TC_01() {
		
		logger.info("CRS Started");
		extentTest = extent.startTest("BookingEngine_FBPStrikeThroughPricing_TC_01");
		lp.login();
		allureScreenshot("Logged In");
		screenShot("Logged In");
		bp.openBrands();
		allureScreenshot("Brands Open");
		screenShot("Brands Open");
		bp.brandSelect();
		pbp.selectProperty();
		logger.info("Booking Engine Started");
		openURL("be_url2");;
		plrp.availabilityCheck();
		String buttonCheck = plrp.verifyBookNowBtn();
		soft.assertEquals(buttonCheck, "BOOK NOW");
		allureScreenshot("Booking Available");
		screenShot("Booking Available");
		plrp.bookNow();
		soft.assertEquals(fbp.verifyOnyBARIsThere(), "BAR");
		Helper.switchWindow(0);
		cp.openPropertyTab();
		fbp.propertyDefaults();
		fbp.enableFBP();
		fbp.propertyDefaultsSaveButton();
		srtp.adminRatePlanTab();
		allureScreenshot("Manage FBP Option");
		screenShot("Manage FBP Option");
		soft.assertTrue(fbp.verifyManageFBP());
		System.out.println("Manage FBP is Enabled");
		srtp.adminListAllRatePlan();
		fbp.editFloatingRatePlanNameForFBP();
		String beforeAmount = fbp.pickAmountFromRatePlanBE();
		allureScreenshot("Amount Before");
		screenShot("Amount Before");
		Helper.switchWindow(0);
		fbp.selectFlatAmountOption();
		fbp.inputAmount();
		srtp.adminSmartRateSaveButton();
		String fbpSaveText = fbp.verifyFBPSavedText();
		soft.assertEquals(fbpSaveText, "List of Rate Plans");
		System.out.println("FBP saved for Floating Rate by Flat Amount");
		fbp.editFloatingRatePlanNameForFBP();
		String afterAmount = fbp.pickAmountFromRatePlanBE();
		allureScreenshot("Amount After");
		screenShot("Amount After");
		soft.assertNotEquals(beforeAmount, afterAmount);

	}

	@Test(priority = 2)
	@Description("Verify user should be able to modify flat amount in formula based pricing and verify amount in Booking Engine.")
	@Severity(SeverityLevel.CRITICAL)
	@Epic("EP01")
	@Feature("Feature1: Formula Based Pricing")
	@Story("Story: Amount changed when flat amount FBP is modified")
	@Step("Verify amount changed when flat amount FBP is modified")
	public void BookingEngine_FBPStrikeThroughPricing_TC_02() {
		
		logger.info("CRS Started");
		extentTest = extent.startTest("BookingEngine_FBPStrikeThroughPricing_TC_02");
		Helper.switchWindow(0);
		String beforeAmount = fbp.pickAmountFromRatePlanBE();
		allureScreenshot("Amount Before");
		screenShot("Amount Before");
		Helper.switchWindow(0);
		fbp.inputMofifyAmount();
		allureScreenshot("Amount Modify");
		screenShot("Amount Modify");
		srtp.adminSmartRateSaveButton();
		String fbpSaveText = fbp.verifyFBPSavedText();
		soft.assertEquals(fbpSaveText, "List of Rate Plans");
		System.out.println("FBP Modified for Floating Rate by flat amount");
		fbp.editFloatingRatePlanNameForFBP();
		String afterAmount = fbp.pickAmountFromRatePlanBE();
		allureScreenshot("Amount Before");
		screenShot("Amount Before");
		soft.assertNotEquals(beforeAmount, afterAmount);

	}

	@Test(priority = 3)
	@Description("Verify user should be able to nullify formula based pricing  price.")
	@Severity(SeverityLevel.NORMAL)
	@Epic("EP01")
	@Feature("Feature1: Formula Based Pricing")
	@Story("Story: Amount remained same when amount FBP is nullified")
	@Step("Verify amount remained same when amount FBP is nullified")
	public void BookingEngine_FBPStrikeThroughPricing_TC_03() {
		
		logger.info("CRS Started");
		extentTest = extent.startTest("BookingEngine_FBPStrikeThroughPricing_TC_03");
		Helper.switchWindow(0);
		String beforeAmount = fbp.pickAmountFromRatePlanBE();
		allureScreenshot("Amount Before");
		screenShot("Amount Before");
		Helper.switchWindow(0);
		fbp.inputNullAmount();
		allureScreenshot("Amount Null");
		screenShot("Amount Null");
		srtp.adminSmartRateSaveButton();
		String fbpSaveText = fbp.verifyFBPSavedText();
		soft.assertEquals(fbpSaveText, "List of Rate Plans");
		System.out.println("FBP Modified to 0 for Floating Rate by percentage");
		fbp.editFloatingRatePlanNameForFBP();
		String afterAmount = fbp.pickAmountFromRatePlanBE();
		allureScreenshot("Amount After");
		screenShot("Amount After");
		soft.assertNotEquals(beforeAmount, afterAmount);

	}

	@Test(priority = 4)
	@Description("Verify user should be able to verify the amount change in the Booking engine when FBP is added as percentage amount.")
	@Severity(SeverityLevel.CRITICAL)
	@Epic("EP01")
	@Feature("Feature1: Formula Based Pricing")
	@Story("Story: Amount changed when percentage amount FBP is applied")
	@Step("Verify amount changed when percentage amount FBP is applied")
	public void BookingEngine_FBPStrikeThroughPricing_TC_04() {
		
		extentTest = extent.startTest("BookingEngine_FBPStrikeThroughPricing_TC_04");
		Helper.switchWindow(0);
		String beforeAmount = fbp.pickAmountFromRatePlanBE();
		allureScreenshot("Amount Before");
		screenShot("Amount Before");
		Helper.switchWindow(0);
		fbp.selectPercentageAmountOption();
		fbp.inputAmount();
		allureScreenshot("Percentage Amount");
		screenShot("Percentage Amount");
		srtp.adminSmartRateSaveButton();
		String fbpSaveText = fbp.verifyFBPSavedText();
		soft.assertEquals(fbpSaveText, "List of Rate Plans");
		System.out.println("FBP saved for Floating Rate by percentage");
		fbp.editFloatingRatePlanNameForFBP();
		String afterAmount = fbp.pickAmountFromRatePlanBE();
		allureScreenshot("Amount After");
		screenShot("Amount After");
		soft.assertNotEquals(beforeAmount, afterAmount);

	}

	@Test(priority = 5)
	@Description("Verify user should be able to modify percentage amount in formula based pricing and verify amount change in Booking Engine.")
	@Severity(SeverityLevel.CRITICAL)
	@Epic("EP01")
	@Feature("Feature1: Formula Based Pricing")
	@Story("Story: Amount changed when percentage amount FBP is modified")
	@Step("Verify amount changed when percentage amount FBP is modified")
	public void BookingEngine_FBPStrikeThroughPricing_TC_05() {
		
		extentTest = extent.startTest("BookingEngine_FBPStrikeThroughPricing_TC_05");
		Helper.switchWindow(0);
		String beforeAmount = fbp.pickAmountFromRatePlanBE();
		allureScreenshot("Amount Before");
		screenShot("Amount Before");
		Helper.switchWindow(0);
		fbp.inputMofifyAmount();
		allureScreenshot("Amount Modify");
		screenShot("Amount Modify");
		srtp.adminSmartRateSaveButton();
		String fbpSaveText = fbp.verifyFBPSavedText();
		soft.assertEquals(fbpSaveText, "List of Rate Plans");
		System.out.println("FBP Modified for Floating Rate by percentage");
		fbp.editFloatingRatePlanNameForFBP();
		String afterAmount = fbp.pickAmountFromRatePlanBE();
		allureScreenshot("Amount After");
		screenShot("Amount After");
		soft.assertNotEquals(beforeAmount, afterAmount);

	}

	@Test(priority = 6)
	@Description("Verify user should be able to set and book a reservation through formula based pricing in Booking Engine without strike through.")
	@Severity(SeverityLevel.NORMAL)
	@Epic("EP01")
	@Feature("Feature1: Formula Based Pricing")
	@Story("Story: Reservation can be book without Strike Through in FBP")
	@Step("Verify reservation can be book without Strike Through in FBP")
	public void BookingEngine_FBPStrikeThroughPricing_TC_06() {

		extentTest = extent.startTest("BookingEngine_FBPStrikeThroughPricing_TC_06");
		Helper.switchWindow(0);
		cp.openPropertyTab();
		fbp.propertyDefaults();
		fbp.disableFBPStrikeThrough();
		allureScreenshot("Disable Strike through Admin");
		screenShot("Disable Strike through Admin");
		fbp.propertyDefaultsSaveButton();
		Helper.switchWindow(1);
		getDriver().navigate().refresh();
		Helper.sleep(1000);
//		TestBase.explicit(amountInBEw,3);
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
		Helper.switchWindow(0);
		srtp.adminRatePlanTab();
		Helper.sleep(2000);
		srtp.adminListAllRatePlan();
		Helper.sleep(2000);
		fbp.editFloatingRatePlanNameForFBP();
		fbp.inputNullAmount();
		srtp.adminSmartRateSaveButton();
		cp.openPropertyTab();
		fbp.propertyDefaults();
		fbp.disableFBP();
		fbp.propertyDefaultsSaveButton();
		lp.logout();
		logger.info("CRS Closed");
		logger.info("Booking Engine Closed");

	}
}
