package com.callcenter;

import java.io.IOException;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.admin.pom.AdministratorHomePage;
import com.admin.pom.LoginPage;
import com.admin.pom.RatesandInventoryPage;
import com.cc.pom.ModifyBookingfromconfirmationpagePage;
import com.cc.pom.MultiRoomBookingandverifyRateGridupdatePage;
import com.cc.pom.NormalSingleRoomBookingandverifyRateGridupdatePage;
import com.cc.pom.VerifyingFilters_allthelinksandSortingonAvailabilityPagePage;

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
 * Test class for MultiRoomBookingandverifyRateGridupdate
 * @author Rudraksh Aggarwal
 */
public class MultiRoomBookingandverifyRateGridupdate extends TestBase {

	public static Utilitylog logger;

// objects
	LoginPage lp;
	AdministratorHomePage ahp;
	RatesandInventoryPage rip;
	NormalSingleRoomBookingandverifyRateGridupdatePage nsrb;
	ModifyBookingfromconfirmationpagePage mbcp;
	SoftAssert soft;
	MultiRoomBookingandverifyRateGridupdatePage mrb;
	VerifyingFilters_allthelinksandSortingonAvailabilityPagePage vfas;

	public MultiRoomBookingandverifyRateGridupdate() {
		super();
		logger = new Utilitylog(MultiRoomBookingandverifyRateGridupdate.class.getName());
	}

	@BeforeMethod
	public void setup() {
		lp = new LoginPage(getDriver());
		ahp = new AdministratorHomePage(getDriver());
		rip = new RatesandInventoryPage(getDriver());
		nsrb = new NormalSingleRoomBookingandverifyRateGridupdatePage(getDriver());
		mbcp = new ModifyBookingfromconfirmationpagePage(getDriver());
		soft = new SoftAssert();
		mrb = new MultiRoomBookingandverifyRateGridupdatePage(getDriver());
		vfas = new VerifyingFilters_allthelinksandSortingonAvailabilityPagePage(getDriver());
	}

	@Test(priority = 1)
	@Description("Verify the Room availability in rate Grid after multi room booking in Call Center of 2 same rooms for 1 day for same rate plan")
	@Severity(SeverityLevel.CRITICAL)
	@Epic("EP01")
	@Feature("Feature1:Call Center")
	@Story("Call Center")
	@Step("Verify the Room availability in rate Grid after multi room booking in Call Center of 2 same rooms for 1 day for same rate plan")
	public void CallCentre_MultiRoomBookingandverifyRateGridupdate_TC_01() throws IOException {
		logger.info("TestCase Started");
		extentTest = extent.startTest("CallCentre_MultiRoomBookingandverifyRateGridupdate_TC_01");
		lp.login();
		allureScreenshot("Login");
		screenShot("Login");
		ahp.selectBrand();
		ahp.selectProperty2();
		allureScreenshot("Property Selected");
		screenShot("Property Selected");
		ahp.selectRatesandInventory();
		rip.selectRateGrid();
		Helper.sleep(3000);
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
		Helper.sleep(3000);
		nsrb.selectRatePlanRateGrid();
		rip.continueButton();
		nsrb.selectDateRangeTC01();
		rip.clickoverrideRoomCheckbox();
		rip.clickdailyRateInvbutton();
		nsrb.selectALLRoomType();
		nsrb.unSelectALLRoomType();
		nsrb.selectFirstRoomType();
		soft.assertTrue(mrb.takeSSandCompareBeforeAfterMulti2SameRoomRateGridUpdate1DayTC01(
				"beforeMulti2SameRoomRateGridupdate1Day_TC01(", "afterMulti2SameRoomRateGridupdate1Day_TC01"));
		logger.info("TestCase Ended");
	}

	@Test(priority = 2)
	@Description("Verify the Room availability in rate Grid after multi room booking in Call Center of 2 same rooms for 3 days for same rate plan")
	@Severity(SeverityLevel.CRITICAL)
	@Epic("EP01")
	@Feature("Feature1:Call Center")
	@Story("Call Center")
	@Step("Verify the Room availability in rate Grid after multi room booking in Call Center of 2 same rooms for 3 days for same rate plan")
	public void CallCentre_MultiRoomBookingandverifyRateGridupdate_TC_02() throws IOException {
		logger.info("TestCase Started");
		extentTest = extent.startTest("CallCentre_MultiRoomBookingandverifyRateGridupdate_TC_02");
		rip.selectRateGrid();
		Helper.sleep(3000);
		nsrb.selectRatePlanRateGrid();
		rip.continueButton();
		mrb.selectDateRangeTC02();
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
		Helper.sleep(3000);
		nsrb.selectRatePlanRateGrid();
		rip.continueButton();
		mrb.selectDateRangeTC02();
		rip.clickoverrideRoomCheckbox();
		rip.clickdailyRateInvbutton();
		nsrb.selectALLRoomType();
		nsrb.unSelectALLRoomType();
		nsrb.selectFirstRoomType();
		mrb.scroll2();
		soft.assertTrue(mrb.takeSSandCompareBeforeAfterMulti2SameRoomRateGridUpdate3DaysTC02(
				"beforeMulti2SameRoomRateGridupdate3Days_TC02", "afterMulti2SameRoomRateGridupdate3Days_TC02"));
		logger.info("TestCase Ended");
	}

	@Test(priority = 3)
	@Description("Verify the Room availability in rate Grid after multi room booking in Call Center of 3 same rooms for 1 day for same rate plan")
	@Severity(SeverityLevel.CRITICAL)
	@Epic("EP01")
	@Feature("Feature1:Call Center")
	@Story("Call Center")
	@Step("Verify the Room availability in rate Grid after multi room booking in Call Center of 3 same rooms for 1 day for same rate plan")
	public void CallCentre_MultiRoomBookingandverifyRateGridupdate_TC_03() throws IOException {
		logger.info("TestCase Started");
		extentTest = extent.startTest("CallCentre_MultiRoomBookingandverifyRateGridupdate_TC_03");
		rip.selectRateGrid();
		Helper.sleep(3000);
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
		Helper.sleep(3000);
		nsrb.selectRatePlanRateGrid();
		rip.continueButton();
		nsrb.selectDateRangeTC01();
		rip.clickoverrideRoomCheckbox();
		rip.clickdailyRateInvbutton();
		nsrb.selectALLRoomType();
		nsrb.unSelectALLRoomType();
		nsrb.selectFirstRoomType();
		soft.assertTrue(mrb.takeSSandCompareBeforeAfterMulti3SameRoomRateGridUpdate1DayTC03(
				"beforeMulti3SameRoomRateGridupdate1Day_TC03", "afterMulti3SameRoomRateGridupdate1Day_TC03"));
		logger.info("TestCase Ended");
	}

	@Test(priority = 4)
	@Description("Verify the Room availability in rate Grid after multi room booking in Call Center of 3 same rooms for 3 days")
	@Severity(SeverityLevel.CRITICAL)
	@Epic("EP01")
	@Feature("Feature1:Call Center")
	@Story("Call Center")
	@Step("Verify the Room availability in rate Grid after multi room booking in Call Center of 3 same rooms for 3 days")
	public void CallCentre_MultiRoomBookingandverifyRateGridupdate_TC_04() throws IOException {
		logger.info("TestCase Started");
		extentTest = extent.startTest("CallCentre_MultiRoomBookingandverifyRateGridupdate_TC_04");
		rip.selectRateGrid();
		Helper.sleep(3000);
		nsrb.selectRatePlanRateGrid();
		rip.continueButton();
		mrb.selectDateRangeTC02();
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
		Helper.sleep(3000);
		nsrb.selectRatePlanRateGrid();
		rip.continueButton();
		mrb.selectDateRangeTC02();
		rip.clickoverrideRoomCheckbox();
		rip.clickdailyRateInvbutton();
		nsrb.selectALLRoomType();
		nsrb.unSelectALLRoomType();
		nsrb.selectFirstRoomType();
		mrb.scroll2();
		soft.assertTrue(mrb.takeSSandCompareBeforeAfterMulti3SameRoomRateGridUpdate3DaysTC04(
				"beforeMulti3SameRoomRateGridupdate3DaysTC04", "afterMulti3SameRoomRateGridupdate3DaysTC04"));
		logger.info("TestCase Ended");
	}

	@Test(priority = 5)
	@Description("Verify the Room availability in rate Grid after multi room booking in Call Center by selecting 3 rooms first and then removing one room")
	@Severity(SeverityLevel.CRITICAL)
	@Epic("EP01")
	@Feature("Feature1:Call Center")
	@Story("Call Center")
	@Step("Verify the Room availability in rate Grid after multi room booking in Call Center by selecting 3 rooms first and then removing one room")
	public void CallCentre_MultiRoomBookingandverifyRateGridupdate_TC_05() throws IOException {
		logger.info("TestCase Started");
		extentTest = extent.startTest("CallCentre_MultiRoomBookingandverifyRateGridupdate_TC_05");
		rip.selectRateGrid();
		Helper.sleep(3000);
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
		Helper.sleep(3000);
		nsrb.selectRatePlanRateGrid();
		rip.continueButton();
		nsrb.selectDateRangeTC01();
		rip.clickoverrideRoomCheckbox();
		rip.clickdailyRateInvbutton();
		nsrb.selectALLRoomType();
		nsrb.unSelectALLRoomType();
		nsrb.selectFirstRoomType();
		soft.assertTrue(mrb.takeSSandCompareBeforeAfterSelecting3roomsFirstandRemove1RoomAfter(
				"beforeSelecting3roomsFirstandRemove1RoomTC05", "afterSelecting3roomsFirstandRemove1RoomTC05"));
		logger.info("TestCase Ended");
	}

	@Test(priority = 6)
	@Description("Verify the Room availability in rate Grid after multi room booking in Call Center by selecting 2 diff rooms for 1 day")
	@Severity(SeverityLevel.CRITICAL)
	@Epic("EP01")
	@Feature("Feature1:Call Center")
	@Story("Call Center")
	@Step("Verify the Room availability in rate Grid after multi room booking in Call Center by selecting 2 diff rooms for 1 day")
	public void CallCentre_MultiRoomBookingandverifyRateGridupdate_TC_06() throws IOException {
		logger.info("TestCase Started");
		extentTest = extent.startTest("CallCentre_MultiRoomBookingandverifyRateGridupdate_TC_06");
		ahp.clickOnRoomTab();
		ahp.clickOnAddNew();
		mrb.createRoom();
		mrb.clickOnSave();
		Helper.sleep(2000);
		ahp.clickOnRoomTab();
		Helper.sleep(2000);
		ahp.selectRatesandInventory();
		Helper.sleep(1000);
		rip.selectRateGrid();
		Helper.sleep(3000);
		nsrb.selectRatePlanRateGrid();
		rip.continueButton();
		nsrb.selectDateRangeTC01();
		rip.clickoverrideRoomCheckbox();
		rip.clickdailyRateInvbutton();
		nsrb.selectALLRoomType();
		nsrb.unSelectALLRoomType();
		mrb.select2Rooms();
		allureScreenshot("Rate Grid");
		screenShot("Rate Grid");
		nsrb.inputFieldRoomAvailable();
		mrb.inputFieldRate();
		nsrb.openYieldControls();
		nsrb.clickQuickEntrybutton();
		nsrb.clickUpdateButton();
		nsrb.clickConfirmButton();
		Helper.sleep(3000);
		nsrb.selectRatePlanRateGrid();
		rip.continueButton();
		nsrb.selectDateRangeTC01();
		rip.clickoverrideRoomCheckbox();
		rip.clickdailyRateInvbutton();
		nsrb.selectALLRoomType();
		nsrb.unSelectALLRoomType();
		mrb.select2Rooms();
		mrb.scroll3();
		soft.assertTrue(mrb.takeSSandCompareBeforeAfterSelecting2diffroomsfor1day(
				"beforeSelecting2DiffRoomsFor1DayTC06", "afterSelecting2DiffRoomsFor1DayTC06"));
		logger.info("TestCase Ended");
	}

	@Test(priority = 7)
	@Description("Verify the Room availability in rate Grid after multi room booking in Call Center by selecting 2 diff rooms for 2 days")
	@Severity(SeverityLevel.CRITICAL)
	@Epic("EP01")
	@Feature("Feature1:Call Center")
	@Story("Call Center")
	@Step("Verify the Room availability in rate Grid after multi room booking in Call Center by selecting 2 diff rooms for 2 days")
	public void CallCentre_MultiRoomBookingandverifyRateGridupdate_TC_07() throws IOException {
		logger.info("TestCase Started");
		extentTest = extent.startTest("CallCentre_MultiRoomBookingandverifyRateGridupdate_TC_07");
		rip.selectRateGrid();
		Helper.sleep(3000);
		nsrb.selectRatePlanRateGrid();
		rip.continueButton();
		mrb.selectDateRangeTC07();
		rip.clickoverrideRoomCheckbox();
		rip.clickdailyRateInvbutton();
		nsrb.selectALLRoomType();
		nsrb.unSelectALLRoomType();
		mrb.select2Rooms();
		allureScreenshot("Rate Grid");
		screenShot("Rate Grid");
		nsrb.inputFieldRoomAvailable();
		mrb.inputFieldRate();
		nsrb.openYieldControls();
		nsrb.clickQuickEntrybutton();
		nsrb.clickUpdateButton();
		nsrb.clickConfirmButton();
		Helper.sleep(3000);
		nsrb.selectRatePlanRateGrid();
		rip.continueButton();
		mrb.selectDateRangeTC07();
		rip.clickoverrideRoomCheckbox();
		rip.clickdailyRateInvbutton();
		nsrb.selectALLRoomType();
		nsrb.unSelectALLRoomType();
		mrb.select2Rooms();
		mrb.scroll4();
		soft.assertTrue(mrb.takeSSandCompareBeforeAfterSelecting2diffroomsfor2days(
				"beforeSelecting2DiffRoomsFor2DaysTC07", "afterSelecting2DiffRoomsFor2DaysTC07"));
		logger.info("TestCase Ended");
	}

	@Test(priority = 8)
	@Description("Verify the Room availability in rate Grid after multi room booking in Call Center by selecting 2 diff rooms for 2 days")
	@Severity(SeverityLevel.CRITICAL)
	@Epic("EP01")
	@Feature("Feature1:Call Center")
	@Story("Call Center")
	@Step("Verify the Room availability in rate Grid after multi room booking in Call Center by selecting 2 diff rooms for 2 days")
	public void CallCentre_MultiRoomBookingandverifyRateGridupdate_TC_08() throws IOException {
		logger.info("TestCase Started");
		extentTest = extent.startTest("CallCentre_MultiRoomBookingandverifyRateGridupdate_TC_08");
		rip.selectRateGrid();
		Helper.sleep(3000);
		nsrb.selectRatePlanRateGrid();
		rip.continueButton();
		mrb.selectDateRangeTC02();
		rip.clickoverrideRoomCheckbox();
		rip.clickdailyRateInvbutton();
		nsrb.selectALLRoomType();
		nsrb.unSelectALLRoomType();
		mrb.select2Rooms();
		allureScreenshot("Rate Grid");
		screenShot("Rate Grid");
		nsrb.inputFieldRoomAvailable();
		mrb.inputFieldRate();
		nsrb.openYieldControls();
		nsrb.clickQuickEntrybutton();
		nsrb.clickUpdateButton();
		nsrb.clickConfirmButton();
		Helper.sleep(3000);
		nsrb.selectRatePlanRateGrid();
		rip.continueButton();
		mrb.selectDateRangeTC02();
		rip.clickoverrideRoomCheckbox();
		rip.clickdailyRateInvbutton();
		nsrb.selectALLRoomType();
		nsrb.unSelectALLRoomType();
		mrb.select2Rooms();
		mrb.scroll5();
		soft.assertTrue(mrb.takeSSandCompareBeforeAfterSelecting2diffroomsfor3days(
				"beforeSelecting2DiffRoomsFor3DaysTC08", "afterSelecting2DiffRoomsFor3DaysTC08"));
		ahp.clickOnRoomTab();
		Helper.sleep(1000);
		ahp.clickOnListAllRoom();
		mrb.deleteRoom();
		lp.logout();
//		vfas.delFolder();
		logger.info("TestCase Ended");
	}
}
