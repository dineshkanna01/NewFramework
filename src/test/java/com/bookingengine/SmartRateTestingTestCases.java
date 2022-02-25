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
* Test class for Property Level Restriction
* @Author : UzairAsar
*/

public class SmartRateTestingTestCases extends TestBase {

	public static Utilitylog logger;
	LoginPage lp;
	BrandPage bp;
	PropertyBrandingPage pbp;
	ChannelPage cp;
	PropertyLevelRestrictionPage plrp;
	SmartRateTestingPage srtp;
	NewPropertyPage npp;
	AdministratorHomePage ahp;
	FBPStrikeThroughPricingPage fbp;

	public SmartRateTestingTestCases() {
		super();
		logger = new Utilitylog(SmartRateTestingTestCases.class.getName());
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
		fbp = new FBPStrikeThroughPricingPage(getDriver());

	}

	@Test(priority = 1)
	@Description("Verify user is able to add Manage smart rate plans in CRS Admin")
	@Severity(SeverityLevel.CRITICAL)
	@Epic("EP01")
	@Feature("Feature1: Smart Rate Plan")
	@Story("Story: Enable Smart Rate Plan")
	@Step("Verify smart rate plan enabled")
	public void BookingEngine_BookingsToVerifyRestrictionsAppliedAtPropertyLevel_TC_01() {
		
		logger.info("CRS Started");
		extentTest = extent.startTest("BookingEngine_BookingsToVerifyRestrictionsAppliedAtPropertyLevel_TC_01");
		lp.login();
		allureScreenshot("Logged In");
		screenShot("Logged In");
		bp.openBrands();
		allureScreenshot("Brands Open");
		screenShot("Brands Open");
		bp.brandSelect();
		pbp.selectProperty();
		cp.openPropertyTab();
		srtp.adminPropertyEdit();
		srtp.adminEnableSamrtRate();
		String editSave = npp.verifyEditSaveButton();
		Assert.assertEquals(editSave, "Save");
		npp.propertyEditPageSaveButton();
		srtp.adminConfirmOkButton();
		fbp.propertyDefaults();
		fbp.enableFBP();
		fbp.propertyDefaultsSaveButton();
		srtp.adminRatePlanTab();
		srtp.verifyadminManageSmartRate();
		allureScreenshot("Manage Smart rate Plan option");
		screenShot("Manage Smart rate Plan option");
		assertTrue(srtp.verifyadminManageSmartRate());
		System.out.println("Smart Rate is Enabled");

	}

	@Test(priority = 2)
	@Description("Verify user can able to add rate plans in smart rate plan.")
	@Severity(SeverityLevel.CRITICAL)
	@Epic("EP01")
	@Feature("Feature1: Smart Rate Plan")
	@Story("Story: Rate plan added in Smart rate Plan")
	@Step("Verify rate plan added in smart rate plan")
	public void BookingEngine_BookingsToVerifyRestrictionsAppliedAtPropertyLevel_TC_02() {
		
		extentTest = extent.startTest("BookingEngine_BookingsToVerifyRestrictionsAppliedAtPropertyLevel_TC_02");
		srtp.adminListAllRatePlan();
		srtp.editBARRatePlan();
		srtp.adminSmartRateSaveButton();
		srtp.editSmartRatePlan2();
		fbp.inputAmount();
		srtp.adminSmartRateSaveButton();
		srtp.adminSelectManageSmartRateOption();
		srtp.adminSmartRatePolicySelect();
		String manageSmartRateButton = srtp.verifyAdminSmartRateSaveButton();
		Assert.assertEquals(manageSmartRateButton, "Save");
		allureScreenshot("Rate Plans Added");
		screenShot("Rate Plans Added");
		assertTrue(srtp.verifRatePlan1AddenInSmartRate());
		assertTrue(srtp.verifRatePlan2AddenInSmartRate());
		srtp.adminSmartRateSaveButton();

	}

	@Test(priority = 3)
	@Description("Verify user is able to see smart rate plan in Booking Engine with basic policy")
	@Severity(SeverityLevel.CRITICAL)
	@Epic("EP01")
	@Feature("Feature1: Smart Rate Plan")
	@Story("Story: Smart rate plan with basic ploicy")
	@Step("Verify basic policy for smart rate plan")
	public void BookingEngine_BookingsToVerifyRestrictionsAppliedAtPropertyLevel_TC_03() {
		
		extentTest = extent.startTest("BookingEngine_BookingsToVerifyRestrictionsAppliedAtPropertyLevel_TC_03");
		logger.info("Booking Engine Started");
		openURL("be_url2");
		srtp.availabilityCheck();
		String buttonCheck = plrp.verifyBookNowBtn();
		Assert.assertEquals(buttonCheck, "BOOK NOW");
		allureScreenshot("Booking Available");
		screenShot("Booking Available");
		plrp.bookNow();
		assertTrue(srtp.verifySmartRatePlanInBE());
		srtp.SmartRatePlanOfferDetails();
		allureScreenshot("Basic Policy in Smart rate plan");
		screenShot("Basic Policy in Smart rate plan");
		assertTrue(srtp.verifySmartRatePlanBasicPolicy());

	}

	@Test(priority = 4)
	@Description("Verify user is able to add and verify smart rate plan in Booking Engine with smart policy")
	@Severity(SeverityLevel.CRITICAL)
	@Epic("EP01")
	@Feature("Feature1: Smart Rate Plan")
	@Story("Story: Smart rate plan with smart ploicy")
	@Step("Verify smart policy for smart rate plan")
	public void BookingEngine_BookingsToVerifyRestrictionsAppliedAtPropertyLevel_TC_04() {
		
		extentTest = extent.startTest("BookingEngine_BookingsToVerifyRestrictionsAppliedAtPropertyLevel_TC_04");
		Helper.switchWindow(0);
		Helper.sleep(1000);
		srtp.adminSelectManageSmartRateOption();
		srtp.adminSmartPolicy();
		String manageSmartRateButton = srtp.verifyAdminSmartRateSaveButton();
		Assert.assertEquals(manageSmartRateButton, "Save");
		srtp.adminSmartRateSaveButton();
		Helper.switchWindow(1);
		getDriver().navigate().refresh();
		assertTrue(srtp.verifySmartRatePlanInBE());
		srtp.SmartRatePlanOfferDetails();
		allureScreenshot("Samrt Policy in Smart rate plan");
		screenShot("Smart Policy in Smart rate plan");
		assertTrue(srtp.verifySmartRatePlanSpecialPolicy());

	}

	@Test(priority = 5)
	@Description("Verify user should be able to see most affordable rates in smart rate plan.")
	@Severity(SeverityLevel.CRITICAL)
	@Epic("EP01")
	@Feature("Feature1: Smart Rate Plan")
	@Story("Story: Most affordable Rates")
	@Step("Verify most affordable rates are there")
	public void BookingEngine_BookingsToVerifyRestrictionsAppliedAtPropertyLevel_TC_05(){
		
		extentTest = extent.startTest("BookingEngine_BookingsToVerifyRestrictionsAppliedAtPropertyLevel_TC_05");
		Helper.switchWindow(0);
		ahp.selectRatesandInventory();
		srtp.selectRateGrid();
		srtp.selectRatePlan();
		srtp.continueButton();
		srtp.adminRateGriddateRange();
		srtp.clickoverrideRoomCheckbox();
		srtp.clickdailyRateInvbutton();
		srtp.selectALLRoomType();
		srtp.nullavailability();
		srtp.clickQuickEntrybutton();
		srtp.clickUpdatebutton();
		srtp.clickConfirmbutton();
		Helper.sleep(2000);
		Helper.switchWindow(1);
		getDriver().navigate().refresh();
		Helper.sleep(1000);
		srtp.radioButtonSmartRate();
		srtp.verifySmartRateAmount();
		allureScreenshot("Smart rate plan amount");
		screenShot("Smart rate plan amount");
		srtp.radioButtonOtherRate();
		srtp.verifyOtherRateAmount();
		Helper.switchWindow(0);
		srtp.selectRatePlan();
		srtp.continueButton();
		srtp.adminRateGriddateRange();
		srtp.clickoverrideRoomCheckbox();
		srtp.clickdailyRateInvbutton();
		srtp.selectALLRoomType();
		srtp.availability();
		srtp.clickQuickEntrybutton();
		srtp.clickUpdatebutton();
		srtp.clickConfirmbutton();

	}

	@Test(priority = 6)
	@Description("Verify user can able to see the amount of the rate plan in smart rate but not the rate plan itself that is closed for some particular days in a date range for which booking is made")
	@Severity(SeverityLevel.CRITICAL)
	@Epic("EP01")
	@Feature("Feature1: Smart Rate Plan")
	@Story("Story: Amount of disbled rate plan can be seen")
	@Step("Verify Amount of disbled rate plan can be seen")
	public void BookingEngine_BookingsToVerifyRestrictionsAppliedAtPropertyLevel_TC_06(){
		
		extentTest = extent.startTest("BookingEngine_BookingsToVerifyRestrictionsAppliedAtPropertyLevel_TC_06");
		Helper.switchWindow(1);
		getDriver().navigate().refresh();
		String beRatePlan = srtp.beVerifyRatePlanName();
		Helper.switchWindow(0);
		srtp.selectRatePlan();
		srtp.continueButton();
		srtp.adminRateGriddateRange();
		srtp.clickoverrideRoomCheckbox();
		srtp.clickdailyRateInvbutton();
		String adminRatePlan = srtp.adminVerifyRatePlanName();
		Assert.assertEquals(beRatePlan, adminRatePlan);
		srtp.selectALLRoomType();
		srtp.nullavailability();
		srtp.clickQuickEntrybutton();
		srtp.clickUpdatebutton();
		srtp.clickConfirmbutton();
		Helper.sleep(2000);
		Helper.switchWindow(1);
		getDriver().navigate().refresh();
		Helper.sleep(1000);
		srtp.smartRateOfferDetails();
		allureScreenshot("Smart rate plan amount of each day");
		screenShot("Smart rate plan amount of each day");
		String firstDaySmartrateAmount = srtp.firstDaySmartRateAmountDetails();
		String secondDaySmartrateAmount = srtp.secondDaySmartRateAmountDetails();
		String thirdDaySmartrateAmount = srtp.thirdDaySmartRateAmountDetails();
		srtp.closeOfferDetails();
		String otherRatePalnAmount = srtp.otherRateAmountDetails();
		allureScreenshot("Other rate plan amount of each day");
		screenShot("Other rate plan amount of each day");
		Assert.assertNotEquals(firstDaySmartrateAmount, otherRatePalnAmount);
		System.out.println("First Day Amount is taken from BAR rate plan that is close on Second Day");
		Assert.assertEquals(secondDaySmartrateAmount, otherRatePalnAmount);
		System.out.println("Second Day Amount is taken from the rate plan that is not close on Second Day");
		Assert.assertNotEquals(thirdDaySmartrateAmount, otherRatePalnAmount);
		System.out.println("Third Day Amount is taken from BAR rate plan that is close on Second Day");
		srtp.closeOfferDetails();
		Helper.switchWindow(0);
		srtp.selectRatePlan();
		srtp.continueButton();
		srtp.adminRateGriddateRange();
		srtp.clickoverrideRoomCheckbox();
		srtp.clickdailyRateInvbutton();
		srtp.selectALLRoomType();
		srtp.availability();
		srtp.clickQuickEntrybutton();
		srtp.clickUpdatebutton();
		srtp.clickConfirmbutton();
		cp.openPropertyTab();
		srtp.adminPropertyEdit();
		srtp.adminDisableSamrtRate();
		String editSave = npp.verifyEditSaveButton();
		Assert.assertEquals(editSave, "Save");
		npp.propertyEditPageSaveButton();
		srtp.adminConfirmOkButton();

	}

	@Test(priority = 7)
	@Description("Verify user should not able to see Smart Rate when only one Rate plan is associated with it")
	@Severity(SeverityLevel.CRITICAL)
	@Epic("EP01")
	@Feature("Feature1: Smart Rate Plan")
	@Story("Story: Smart Rate not visible when one rate Plan attached")
	@Step("Verify Smart Rate not visible when one rate Plan attached")
	public void BookingEngine_BookingsToVerifyRestrictionsAppliedAtPropertyLevel_TC_07() {
		
		extentTest = extent.startTest("BookingEngine_BookingsToVerifyRestrictionsAppliedAtPropertyLevel_TC_07");
		Helper.switchWindow(1);
		getDriver().navigate().refresh();
		Helper.switchWindow(0);
		srtp.adminPropertyEdit();
		srtp.adminEnableSamrtRate();
		String editSave = npp.verifyEditSaveButton();
		Assert.assertEquals(editSave, "Save");
		npp.propertyEditPageSaveButton();
		srtp.adminConfirmOkButton();
		srtp.adminRatePlanTab();
		srtp.adminSelectManageSmartRateOption();
		srtp.adminSmartRatePolicySelect();
		String manageSmartRateButton = srtp.verifyAdminSmartRateSaveButton();
		Assert.assertEquals(manageSmartRateButton, "Save");
		srtp.adminSmartRateSaveButton();
		srtp.adminListAllRatePlan();
		srtp.editBARRatePlan();
		srtp.adminSmartRateSaveButton();
		Helper.sleep(2000);
		Helper.switchWindow(1);
		getDriver().navigate().refresh();
		Helper.sleep(1000);
		allureScreenshot("Smart Rate Plan not there");
		screenShot("Smart Rate Plan not there");
		Helper.switchWindow(0);
		srtp.adminListAllRatePlan();
		srtp.editSmartRatePlan2();
		srtp.adminSmartRateSaveButton();

	}

	@Test(priority = 8)
	@Description("Verify user is able to remove smart rate plan in Booking Engine")
	@Severity(SeverityLevel.CRITICAL)
	@Epic("EP01")
	@Feature("Feature1: Smart Rate Plan")
	@Story("Story: Smart Rate Plan removed")
	@Step("Verify Smart Rate Plan removed")
	public void BookingEngine_BookingsToVerifyRestrictionsAppliedAtPropertyLevel_TC_08() {
		
		extentTest = extent.startTest("BookingEngine_BookingsToVerifyRestrictionsAppliedAtPropertyLevel_TC_08");
		Helper.switchWindow(1);
		getDriver().navigate().refresh();
		Helper.switchWindow(0);
		cp.openPropertyTab();
		srtp.adminPropertyEdit();
		srtp.adminDisableSamrtRate();
		String editSave = npp.verifyEditSaveButton();
		Assert.assertEquals(editSave, "Save");
		npp.propertyEditPageSaveButton();
		srtp.adminConfirmOkButton();
		fbp.propertyDefaults();
		fbp.disableFBP();
		fbp.propertyDefaultsSaveButton();
		Helper.switchWindow(1);
		Helper.sleep(2000);
		getDriver().navigate().refresh();
		Helper.sleep(1000);
		allureScreenshot("Smart Rate Plan removed");
		screenShot("Smart Rate Plan removed");
		Helper.switchWindow(0);
		lp.logout();
		logger.info("CRS Closed");
		logger.info("Booking Engine Closed");

	}
}
