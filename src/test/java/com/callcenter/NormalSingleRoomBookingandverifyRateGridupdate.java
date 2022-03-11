package com.callcenter;

import java.io.IOException;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.admin.pom.AdministratorHomePage;
import com.admin.pom.LoginPage;
import com.admin.pom.RatesandInventoryPage;
import com.cc.pom.NormalSingleRoomBookingandverifyRateGridupdatePage;

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
 * Test class for NormalSingleRoomBookingandverifyRateGridupdate
 * @author Rudraksh Aggarwal
 */
public class NormalSingleRoomBookingandverifyRateGridupdate extends TestBase {

	public static Utilitylog logger;

// objects
	LoginPage lp;
	AdministratorHomePage ahp;
	RatesandInventoryPage rip;
	NormalSingleRoomBookingandverifyRateGridupdatePage nsrb;
	SoftAssert soft;

	public NormalSingleRoomBookingandverifyRateGridupdate() {
		super();
		logger = new Utilitylog(NormalSingleRoomBookingandverifyRateGridupdate.class.getName());
	}

	@BeforeMethod
	public void setup() {
		lp = new LoginPage(getDriver());
		ahp = new AdministratorHomePage(getDriver());
		rip = new RatesandInventoryPage(getDriver());
		nsrb = new NormalSingleRoomBookingandverifyRateGridupdatePage(getDriver());
		soft = new SoftAssert();
	}

	@Test(priority = 1)
	@Description("Verify the Room availability in rate Grid after Single room booking in Call Center for 1 day")
	@Severity(SeverityLevel.CRITICAL)
	@Epic("EP01")
	@Feature("Feature1:Call Center")
	@Story("Call Center")
	@Step("Verify the Room availability in rate Grid after Single room booking in Call Center for 1 day")
	public void CallCentre_NormalSingleRoomBookingandverifyRateGridupdate_TC_01() throws IOException {
		logger.info("TestCase Started");
		extentTest = extent.startTest("CallCentre_NormalSingleRoomBookingandverifyRateGridupdate_TC_01");
		lp.login();
		allureScreenshot("Login");
		screenShot("Login");
		ahp.selectBrand();
		ahp.selectProperty2();
		allureScreenshot("Property Selected");
		screenShot("Property Selected");
		ahp.selectRatesandInventory();
		rip.selectRateGrid();
		nsrb.selectRatePlanRateGrid();
		rip.continueButton();
		nsrb.selectDateRangeTC01();
		rip.clickoverrideRoomCheckbox();
		rip.clickdailyRateInvbutton();
		nsrb.selectALLRoomType();
		nsrb.unSelectALLRoomType();
		nsrb.selectFirstRoomType();
		nsrb.getFirstRoomName();
		allureScreenshot("Rate Grid");
		screenShot("Rate Grid");
		nsrb.inputFieldRoomAvailable();
		nsrb.openYieldControls();
		nsrb.clickQuickEntrybutton();
		nsrb.clickUpdateButton();
		nsrb.clickConfirmButton();
		nsrb.selectRatePlanRateGrid();
		rip.continueButton();
		nsrb.selectDateRangeTC01();
		rip.clickoverrideRoomCheckbox();
		rip.clickdailyRateInvbutton();
		nsrb.selectALLRoomType();
		nsrb.unSelectALLRoomType();
		nsrb.selectFirstRoomType();
		soft.assertTrue(nsrb.takeSSandCompareBeforeAfterRateGridUpdate1Day("beforeRateGridupdate1Day",
				"afterRateGridupdate1Day"));

		logger.info("TestCase Ended");
	}

	@Test(priority = 2)
	@Description("Verify the Room availability in rate Grid after Single room booking in Call Center for 7 days")
	@Severity(SeverityLevel.CRITICAL)
	@Epic("EP01")
	@Feature("Feature1:Call Center")
	@Story("Call Center")
	@Step("Verify the Room availability in rate Grid after Single room booking in Call Center for 7 days")
	public void CallCentre_NormalSingleRoomBookingandverifyRateGridupdate_TC_02() throws IOException {
		logger.info("TestCase Started");
		extentTest = extent.startTest("CallCentre_NormalSingleRoomBookingandverifyRateGridupdate_TC_02");
		rip.selectRateGrid();
		nsrb.selectRatePlanRateGrid();
		rip.continueButton();
		nsrb.selectDateRangeTC02();
		allureScreenshot("Date Range Rate Grid");
		screenShot("Date Range Rate Grid");
		rip.clickoverrideRoomCheckbox();
		rip.clickdailyRateInvbutton();
		nsrb.selectALLRoomType();
		nsrb.unSelectALLRoomType();
		nsrb.selectFirstRoomType();
		nsrb.getFirstRoomName();
		nsrb.inputFieldRoomAvailable();
		nsrb.openYieldControls();
		nsrb.clickQuickEntrybutton();
		nsrb.clickUpdateButton();
		nsrb.clickConfirmButton();
		nsrb.selectRatePlanRateGrid();
		rip.continueButton();
		nsrb.selectDateRangeTC02();
		rip.clickoverrideRoomCheckbox();
		rip.clickdailyRateInvbutton();
		nsrb.selectALLRoomType();
		nsrb.unSelectALLRoomType();
		nsrb.selectFirstRoomType();
		nsrb.scroll();
		soft.assertTrue(nsrb.takeSSandCompareBeforeAfterRateGridUpdate7Days("beforeRateGridupdate7Days",
				"afterRateGridupdate7Days"));
		lp.logout();
		nsrb.delFolder();
		logger.info("TestCase Ended");
	}
}
