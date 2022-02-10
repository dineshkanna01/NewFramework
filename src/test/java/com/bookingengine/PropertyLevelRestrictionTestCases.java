package com.bookingengine;

import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.admin.pom.BrandPage;
import com.admin.pom.ChannelPage;
import com.admin.pom.LoginPage;
import com.admin.pom.PropertyBrandingPage;
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
* Test class for Property Level Restriction
* @Author : UzairAsar
*/
public class PropertyLevelRestrictionTestCases extends TestBase {
	
	public static Utilitylog logger;
	LoginPage lp;
	BrandPage bp;
	PropertyBrandingPage pbp;
	ChannelPage cp;
	PropertyLevelRestrictionPage plrp;

	public PropertyLevelRestrictionTestCases() {
		super();
		logger = new Utilitylog(PropertyLevelRestrictionTestCases.class.getName());
	}

	@BeforeMethod
	public void setup() {
		lp = new LoginPage(getDriver());
		pbp = new PropertyBrandingPage(getDriver());
		bp = new BrandPage(getDriver());
		cp = new ChannelPage(getDriver());
		plrp = new PropertyLevelRestrictionPage(getDriver());

	}

	@Test(priority = 1)
	@Description("Verify user should not be able to do Same Day Check-In if apply 'Do not allow Property' restrictions")
	@Severity(SeverityLevel.CRITICAL)
	@Epic("EP01")
	@Feature("Feature1: Property Level Restriction")
	@Story("Story: Same Day Check-In restriction")
	@Step("Verify same day check-in restriction applied")
	public void BookingEngine_BookingsToVerifyRestrictionsAppliedAtPropertyLevel_TC_01() throws InterruptedException {
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
		plrp.adminPropertyYeildRestriction();
		plrp.adminAllowOption();
		plrp.adminRemoverMaxLOS();
		plrp.adminMinLeadTimeClear();
		plrp.adminMaxLeadTimeClear();

		allureScreenshot("Clearing all fields");
		screenShot("Clearing all fields");

		plrp.adminSave();

		logger.info("Booking Engine Open");

		openBEurlinNewTab1();

		plrp.availabilityCheck();
		String buttonCheck = plrp.verifyBookNowBtn();
		Assert.assertEquals(buttonCheck, "BOOK NOW");

		allureScreenshot("Booking Available");
		screenShot("Booking Available");

		switchWindow(0);

		plrp.adminPropertyYeildRestriction();
		plrp.adminDoNotAllowOption();

		allureScreenshot("Do not Allow Restriction");
		screenShot("Do not Allow Restriction");

		plrp.adminSave();

		switchWindow(1);
		getDriver().navigate().refresh();
		Thread.sleep(2000);

		allureScreenshot("Booking Not Available");
		screenShot("Booking Not Available");

		String noBookText = plrp.verifyNoBookingText();
		Assert.assertEquals(noBookText, "Unfortunately, there are no available rooms");

		switchWindow(0);
		plrp.adminPropertyYeildRestriction();
		plrp.adminAllowOption();
		plrp.adminSave();

	}

	@Test(priority = 2)
	@Description("Verify user should not be able to do Same Day Check-In if apply to 'Do not allow after Property' restrictions")
	@Severity(SeverityLevel.CRITICAL)
	@Epic("EP01")
	@Feature("Feature1: Property Level Restriction")
	@Story("Story: Same Day Check-In restriction 'Do not allow after Property'")
	@Step("Verify same day check-in restriction 'Do not allow after Property' applied")
	public void BookingEngine_BookingsToVerifyRestrictionsAppliedAtPropertyLevel_TC_02() throws InterruptedException {
		extentTest = extent.startTest("BookingEngine_BookingsToVerifyRestrictionsAppliedAtPropertyLevel_TC_02");

		switchWindow(1);
		getDriver().navigate().refresh();
		Thread.sleep(1000);

		allureScreenshot("Booking Available");
		screenShot("Booking Available");

		String buttonCheck = plrp.verifyBookNowBtn();
		Assert.assertEquals(buttonCheck, "BOOK NOW");

		switchWindow(0);
		plrp.adminPropertyYeildRestriction();
		plrp.adminDoNotAllowAfterOption();

		allureScreenshot("Do not Allow After Restriction");
		screenShot("Do not Allow After Restriction");

		plrp.adminSave();

		switchWindow(1);
		getDriver().navigate().refresh();
		Thread.sleep(2000);

		allureScreenshot("Booking Not Available");
		screenShot("Booking Not Available");

		String noBookText = plrp.verifyNoBookingText();
		Assert.assertEquals(noBookText, "Unfortunately, there are no available rooms");

		switchWindow(0);
		plrp.adminPropertyYeildRestriction();
		plrp.adminAllowOption();
		plrp.adminSave();

	}

	@Test(priority = 3)
	@Description("Verify user should be able to put Max length of stay restriction at property level.")
	@Severity(SeverityLevel.CRITICAL)
	@Epic("EP01")
	@Feature("Feature1: Property Level Restriction")
	@Story("Story: Max LOS restriction")
	@Step("Verify Max LOS restriction applied")
	public void BookingEngine_BookingsToVerifyRestrictionsAppliedAtPropertyLevel_TC_03() throws InterruptedException {
		extentTest = extent.startTest("BookingEngine_BookingsToVerifyRestrictionsAppliedAtPropertyLevel_TC_03");

		switchWindow(1);
		getDriver().navigate().refresh();
		Thread.sleep(1000);
		plrp.bookNow();
		plrp.startOver();
		Thread.sleep(1000);
		plrp.availabilityCheckForMaxLOS();
		getDriver().navigate().refresh();

		allureScreenshot("Booking Available");
		screenShot("Booking Available");

		String buttonCheck = plrp.verifyBookNowBtn();
		Assert.assertEquals(buttonCheck, "BOOK NOW");

		switchWindow(0);
		plrp.adminPropertyYeildRestriction();
		plrp.adminImposeMaxLOS();

		allureScreenshot("MaxLOS Restriction");
		screenShot("MaxLOS Restriction");

		plrp.adminSave();

		switchWindow(1);
		getDriver().navigate().refresh();
		Thread.sleep(2000);

		allureScreenshot("MaxLOS Booking Not Available");
		screenShot("MaxLOS Booking Not Available");

		String maxLOSErrorText = plrp.verifyMaxLOSErrorText();
		Assert.assertEquals(maxLOSErrorText, "MAXIMUM LENGTH OF STAY CONSTRAINT VIOLATED!");

		switchWindow(0);
		plrp.adminPropertyYeildRestriction();
		plrp.adminRemoverMaxLOS();
		plrp.adminSave();

	}

	@Test(priority = 4)
	@Description("Verify user should be able to put Minimum Lead-Time restriction at property level.")
	@Severity(SeverityLevel.CRITICAL)
	@Epic("EP01")
	@Feature("Feature1: Property Level Restriction")
	@Story("Story: Min Lead Time restriction")
	@Step("Verify Min Lead Time restriction applied")
	public void BookingEngine_BookingsToVerifyRestrictionsAppliedAtPropertyLevel_TC_04() throws InterruptedException {
		extentTest = extent.startTest("BookingEngine_BookingsToVerifyRestrictionsAppliedAtPropertyLevel_TC_04");

		switchWindow(1);
		getDriver().navigate().refresh();
		Thread.sleep(1000);
		plrp.bookNow();
		plrp.startOver();
		Thread.sleep(1000);
		plrp.availabilityCheck();

		allureScreenshot("Booking Available");
		screenShot("Booking Available");

		String buttonCheck = plrp.verifyBookNowBtn();
		Assert.assertEquals(buttonCheck, "BOOK NOW");

		switchWindow(0);
		plrp.adminPropertyYeildRestriction();
		plrp.adminMinLeadTime();

		allureScreenshot("Min Lead Time Restriction");
		screenShot("Min Lead Time Restriction");

		plrp.adminSave();

		switchWindow(1);
		getDriver().navigate().refresh();
		Thread.sleep(2000);

		allureScreenshot("Booking Not Available");
		screenShot("Booking Not Available");

		String noBookText = plrp.verifyNoBookingText();
		Assert.assertEquals(noBookText, "Unfortunately, there are no available rooms");

		switchWindow(0);
		plrp.adminPropertyYeildRestriction();
		plrp.adminMinLeadTimeClear();
		plrp.adminSave();

	}

	@Test(priority = 5)
	@Description("Verify user should be able to put Maximum Lead-Time restriction at property level.")
	@Severity(SeverityLevel.CRITICAL)
	@Epic("EP01")
	@Feature("Feature1: Property Level Restriction")
	@Story("Story: Max Lead Time restriction")
	@Step("Verify Max Lead Time restriction applied")
	public void BookingEngine_BookingsToVerifyRestrictionsAppliedAtPropertyLevel_TC_05() throws InterruptedException {
		extentTest = extent.startTest("BookingEngine_BookingsToVerifyRestrictionsAppliedAtPropertyLevel_TC_05");

		switchWindow(1);
		getDriver().navigate().refresh();
		Thread.sleep(1000);
		plrp.availabilityCheckForMaxLeadTime();

		allureScreenshot("Booking Available");
		screenShot("Booking Available");

		String buttonCheck = plrp.verifyBookNowBtn();
		Assert.assertEquals(buttonCheck, "BOOK NOW");

		switchWindow(0);
		plrp.adminPropertyYeildRestriction();
		plrp.adminMaxLeadTime();

		allureScreenshot("Max Lead Time Restriction");
		screenShot("Max Lead Time Restriction");

		plrp.adminSave();

		switchWindow(1);
		getDriver().navigate().refresh();
		Thread.sleep(2000);

		allureScreenshot("Booking Not Available");
		screenShot("Booking Not Available");

		String noBookText = plrp.verifyNoBookingText();
		Assert.assertEquals(noBookText, "Unfortunately, there are no available rooms");

		switchWindow(0);
		plrp.adminPropertyYeildRestriction();
		plrp.adminMaxLeadTimeClear();
		plrp.adminSave();

	}

	@Test(priority = 6)
	@Description("Verify user should be able to put  Minimum Lead-Time and Maximum Lead-Time restriction together at property level.")
	@Severity(SeverityLevel.CRITICAL)
	@Epic("EP01")
	@Feature("Feature1: Property Level Restriction")
	@Story("Story: Min Max Lead Time restriction")
	@Step("Verify Min Max Lead Time restriction applied")
	public void BookingEngine_BookingsToVerifyRestrictionsAppliedAtPropertyLevel_TC_06() throws InterruptedException {
		extentTest = extent.startTest("BookingEngine_BookingsToVerifyRestrictionsAppliedAtPropertyLevel_TC_06");

		switchWindow(1);
		getDriver().navigate().refresh();
		Thread.sleep(1000);
		plrp.availabilityCheckForMinMaxLeadTime();
		Thread.sleep(1000);
		allureScreenshot("Booking Available");
		screenShot("Booking Available");

		String buttonCheck = plrp.verifyBookNowBtn();
		Assert.assertEquals(buttonCheck, "BOOK NOW");

		switchWindow(0);
		plrp.adminPropertyYeildRestriction();
		plrp.adminMinLeadTime();
		plrp.adminMaxLeadTime();

		allureScreenshot("Min Max Lead Time Restriction");
		screenShot("Min Max Lead Time Restriction");

		plrp.adminSave();

		switchWindow(1);
		getDriver().navigate().refresh();
		Thread.sleep(2000);

		allureScreenshot("Booking Not Available");
		screenShot("Booking Not Available");

		String noBookText = plrp.verifyNoBookingText();
		Assert.assertEquals(noBookText, "Unfortunately, there are no available rooms");

		switchWindow(0);
		plrp.adminPropertyYeildRestriction();
		plrp.adminMinLeadTimeClear();
		plrp.adminMaxLeadTimeClear();
		plrp.adminSave();

	}

	@Test(priority = 7)
	@Description("Verify user should be able to put Same day check-in ,MaxLOS, Maximum Lead-Time and Minimum Lead-Time restriction at property level with MaxLos error")
	@Severity(SeverityLevel.CRITICAL)
	@Epic("EP01")
	@Feature("Feature1: Property Level Restriction")
	@Story("Story: All Property Level restriction with Max LOS error")
	@Step("Verify All Property Level restriction applied with Max LOS error")
	public void BookingEngine_BookingsToVerifyRestrictionsAppliedAtPropertyLevel_TC_07() throws InterruptedException {
		extentTest = extent.startTest("BookingEngine_BookingsToVerifyRestrictionsAppliedAtPropertyLevel_TC_07");

		switchWindow(1);

		getDriver().navigate().refresh();
		Thread.sleep(1000);
		plrp.bookNow();
		plrp.startOver();
		Thread.sleep(1000);
		plrp.availabilityCheckForMinMaxLOSLeadTime();
		getDriver().navigate().refresh();

		allureScreenshot("Booking Available");
		screenShot("Booking Available");

		String buttonCheck = plrp.verifyBookNowBtn();
		Assert.assertEquals(buttonCheck, "BOOK NOW");

		switchWindow(0);
		plrp.adminPropertyYeildRestriction();
		plrp.adminDoNotAllowOption();
		plrp.adminImposeMaxLOS();
		plrp.adminMinLeadTime();
		plrp.adminMaxLeadTime();

		allureScreenshot("All Restriction");
		screenShot("All Restriction");

		plrp.adminSave();

		switchWindow(1);
		getDriver().navigate().refresh();
		Thread.sleep(2000);

		allureScreenshot("MaxLOS Booking Not Available");
		screenShot("MaxLOS Booking Not Available");

		String maxLOSErrorText = plrp.verifyMaxLOSErrorText();
		Assert.assertEquals(maxLOSErrorText, "MAXIMUM LENGTH OF STAY CONSTRAINT VIOLATED!");

		switchWindow(0);
		plrp.adminPropertyYeildRestriction();
		plrp.adminAllowOption();
		plrp.adminRemoverMaxLOS();
		plrp.adminMinLeadTimeClear();
		plrp.adminMaxLeadTimeClear();
		plrp.adminSave();

	}

	@Test(priority = 8)
	@Description("Verify user should be able to put Same day check-in MaxLOS, Maximum Lead-Time and Maximum Lead-Time restriction at property level with rooms not available.")
	@Severity(SeverityLevel.CRITICAL)
	@Epic("EP01")
	@Feature("Feature1: Property Level Restriction")
	@Story("Story: All Property Level restriction with room not available")
	@Step("Verify All Property Level restriction applied with room not available")
	public void BookingEngine_BookingsToVerifyRestrictionsAppliedAtPropertyLevel_TC_08() throws InterruptedException {
		extentTest = extent.startTest("BookingEngine_BookingsToVerifyRestrictionsAppliedAtPropertyLevel_TC_08");

		switchWindow(1);
		getDriver().navigate().refresh();
		Thread.sleep(1000);
		plrp.bookNow();
		plrp.startOver();
		Thread.sleep(1000);
		plrp.availabilityCheckForMinMaxLOSLeadTime08();

		allureScreenshot("Booking Available");
		screenShot("Booking Available");

		String buttonCheck = plrp.verifyBookNowBtn();
		Assert.assertEquals(buttonCheck, "BOOK NOW");

		switchWindow(0);
		plrp.adminPropertyYeildRestriction();
		plrp.adminDoNotAllowOption();
		plrp.adminImposeMaxLOS();
		plrp.adminMinLeadTime();
		plrp.adminMaxLeadTime();

		allureScreenshot("All Restriction");
		screenShot("All Restriction");

		plrp.adminSave();

		switchWindow(1);
		getDriver().navigate().refresh();
		Thread.sleep(2000);

		allureScreenshot("Booking Not Available");
		screenShot("Booking Not Available");

		String noBookText = plrp.verifyNoBookingText();
		Assert.assertEquals(noBookText, "Unfortunately, there are no available rooms");

		switchWindow(0);
		plrp.adminPropertyYeildRestriction();
		plrp.adminAllowOption();
		plrp.adminRemoverMaxLOS();
		plrp.adminMinLeadTimeClear();
		plrp.adminMaxLeadTimeClear();
		plrp.adminSave();

		lp.logout();

		logger.info("crs closed");
		logger.info("Booking Engine Closed");

	}

	@AfterSuite
	public void report() throws Exception {
		mail();
		cmdPrompt();
	}

}
