package com.callcenter;

import java.io.IOException;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.admin.pom.AdministratorHomePage;
import com.admin.pom.LoginPage;
import com.admin.pom.RatePlanCategoriesPage;
import com.admin.pom.RatePlanPage;
import com.admin.pom.RatesandInventoryPage;
import com.cc.pom.CancelBookingfromconfirmationpagePage;
import com.cc.pom.GroupKeywordSearchBookingPage;
import com.cc.pom.ModifyBookingfromconfirmationpagePage;
import com.cc.pom.NormalSingleRoomBookingandverifyRateGridupdatePage;
import com.cc.pom.OfferAccessCodeBookingPage;
import com.cc.pom.VerifyingFilters_allthelinksandSortingonAvailabilityPagePage;

import Utility.ExcelData;
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
 * Test class for VerifyingFilters_allthelinksandSortingonAvailabilityPagePage
 * @author Rudraksh Aggarwal
 */
public class VerifyingFilters_allthelinksandSortingonAvailabilityPageTest extends TestBase {

	static Utilitylog logger;

// objects
	LoginPage lp;
	AdministratorHomePage ahp;
	RatePlanPage rpp;
	RatePlanCategoriesPage rcp;
	GroupKeywordSearchBookingPage gksb;
	NormalSingleRoomBookingandverifyRateGridupdatePage nsrb;
	ModifyBookingfromconfirmationpagePage mbcp;
	RatesandInventoryPage rip;
	OfferAccessCodeBookingPage oacb;
	CancelBookingfromconfirmationpagePage cbcp;
	VerifyingFilters_allthelinksandSortingonAvailabilityPagePage vfas;
	SoftAssert soft;

	public VerifyingFilters_allthelinksandSortingonAvailabilityPageTest() {
		super();
		logger = new Utilitylog(VerifyingFilters_allthelinksandSortingonAvailabilityPageTest.class.getName());
	}

	@BeforeMethod
	public void setup() {
		lp = new LoginPage(getDriver());
		ahp = new AdministratorHomePage(getDriver());
		rpp = new RatePlanPage(getDriver());
		rcp = new RatePlanCategoriesPage(getDriver());
		gksb = new GroupKeywordSearchBookingPage(getDriver());
		nsrb = new NormalSingleRoomBookingandverifyRateGridupdatePage(getDriver());
		mbcp = new ModifyBookingfromconfirmationpagePage(getDriver());
		rip = new RatesandInventoryPage(getDriver());
		oacb = new OfferAccessCodeBookingPage(getDriver());
		cbcp = new CancelBookingfromconfirmationpagePage(getDriver());
		soft = new SoftAssert();
		vfas = new VerifyingFilters_allthelinksandSortingonAvailabilityPagePage(getDriver());
	}

	@Test(priority = 1)
	@Description("Verify user should able to see filter applied as group by rate plan in CC booking engine")
	@Severity(SeverityLevel.CRITICAL)
	@Epic("EP01")
	@Feature("Feature1:Call Center")
	@Story("Call Center")
	@Step("Verify user should able to see filter applied as group by rate plan in CC booking engine")
	public void CallCenter_VerifyingFilters_allthelinksandSortingonAvailabilityPageTest_TC_01() {
		logger.info("TestCase Started");
		extentTest = extent.startTest("CallCenter_VerifyingFilters_allthelinksandSortingonAvailabilityPageTest_TC_01");
		lp.login();
		allureScreenshot("Login");
		screenShot("Login");
		ahp.selectBrand();
		ahp.selectProperty2();
		allureScreenshot("Property Selected");
		screenShot("Property Selected");
		ahp.clickRatePlansTab();
		ahp.clickRatePlanCategories();
		rcp.selectRadioButton();
		rcp.clickOnSave();
		soft.assertTrue(rcp.verifyAddNewCategory());
		vfas.createCategory();
		rcp.clickOnSave();
		soft.assertTrue(vfas.verifyName());
		allureScreenshot("Category created");
		screenShot("Category created");
		ahp.clickAddNewRatePlansTab();
		allureScreenshot("Rate Plan Page");
		screenShot("Rate Plan Page");
		vfas.inputRateplanTC01();
		gksb.selectRoomType();
		rpp.deriveRatesNo();
		rpp.clickSaveButton();
		ahp.selectRatesandInventory();
		Helper.sleep(2000);
		rip.selectRateGrid();
		vfas.selectRatePlanRateGrid();
		allureScreenshot("Rate grid - rate plan");
		screenShot("Rate grid - rate plan");
		rip.continueButton();
		nsrb.selectDateRangeTC01();
		rip.clickoverrideRoomCheckbox();
		rip.clickdailyRateInvbutton();
		nsrb.selectALLRoomType();
		allureScreenshot("Rate Grid");
		screenShot("Rate Grid");
		vfas.inputFieldRate();
		nsrb.openYieldControls();
		nsrb.clickQuickEntrybutton();
		nsrb.clickUpdateButton();
		nsrb.clickConfirmButton();
		openURL("cc_url");
		nsrb.enterCCuser();
		allureScreenshot("Call Center");
		screenShot("Call Center");
		vfas.clickRateTabCC();
		vfas.selectRatePlanCC();
		nsrb.selectDateRangeCCTC01();
		nsrb.clickAvailibilityButton();
		vfas.getRatePlanNameCC();
		allureScreenshot("Call Center rate tab created rate plan group by rate filter");
		screenShot("Call Center rate tab created rate plan and group by rate filter");
		soft.assertEquals(ExcelData.CC_getCellData("NormalSingleRoomBookingData", "RatePlanNameCCFilter", 2),
				ExcelData.CC_getCellData("FiltersData", "rpname", 2));
		logger.info("TestCase Ended");
	}

	@Test(priority = 2)
	@Description("Verify user should able to see that the price are sorted as low to high when filter is applied as group by rate plan in CC booking engine.")
	@Severity(SeverityLevel.CRITICAL)
	@Epic("EP01")
	@Feature("Feature1:Call Center")
	@Story("Call Center")
	@Step("Verify user should able to see that the price are sorted as low to high when filter is applied as group by rate plan in CC booking engine.")
	public void CallCenter_VerifyingFilters_allthelinksandSortingonAvailabilityPageTest_TC_02() throws IOException {
		logger.info("TestCase Started");
		extentTest = extent.startTest("CallCenter_VerifyingFilters_allthelinksandSortingonAvailabilityPageTest_TC_02");
		Helper.switchWindow(0);
		rip.selectRateGrid();
		vfas.selectRatePlanRateGrid();
		rip.continueButton();
		nsrb.selectDateRangeTC01();
		rip.clickoverrideRoomCheckbox();
		rip.clickdailyRateInvbutton();
		allureScreenshot("Rate Grid");
		screenShot("Rate Grid");
		vfas.inputFieldRateTC02();
		nsrb.openYieldControls();
		nsrb.clickQuickEntrybutton();
		nsrb.clickUpdateButton();
		nsrb.clickConfirmButton();
		Helper.switchWindow(1);
		Helper.refresh();
		Helper.sleep(2000);
		soft.assertTrue(vfas.takeSSandCompareBeforeAfterLowtoHigh("beforeFilterLowtoHigh", "AfterFilterLowtoHigh"));
		logger.info("TestCase Ended");
	}

	@Test(priority = 3)
	@Description("Verify user should able to see that the price are sorted as high to low when filter is applied as group by rate plan in CC booking engine")
	@Severity(SeverityLevel.CRITICAL)
	@Epic("EP01")
	@Feature("Feature1:Call Center")
	@Story("Call Center")
	@Step("Verify user should able to see that the price are sorted as high to low when filter is applied as group by rate plan in CC booking engine")
	public void CallCenter_VerifyingFilters_allthelinksandSortingonAvailabilityPageTest_TC_03() throws IOException {
		logger.info("TestCase Started");
		extentTest = extent.startTest("CallCenter_VerifyingFilters_allthelinksandSortingonAvailabilityPageTest_TC_03");
		Helper.sleep(2000);
		vfas.selectFilterNomral();
		soft.assertTrue(vfas.takeSSandCompareBeforeAfterHighToLow("beforeFilterHightoLow", "AfterFilterHightoLow"));
		logger.info("TestCase Ended");
	}

	@Test(priority = 4)
	@Description("Verify user should able to see filter applied as group by room type in CC booking engine")
	@Severity(SeverityLevel.CRITICAL)
	@Epic("EP01")
	@Feature("Feature1:Call Center")
	@Story("Call Center")
	@Step("Verify user should able to see filter applied as group by room type in CC booking engine")
	public void CallCenter_VerifyingFilters_allthelinksandSortingonAvailabilityPageTest_TC_04() throws IOException {
		logger.info("TestCase Started");
		extentTest = extent.startTest("CallCenter_VerifyingFilters_allthelinksandSortingonAvailabilityPageTest_TC_04");
		vfas.clickgroupByRoomTabCC();
		vfas.getRoomNamesCC();
		allureScreenshot("group by room filter");
		screenShot("group by room filter");
		soft.assertEquals(ExcelData.CC_getCellData("NormalSingleRoomBookingData", "roomNameCCgroubBy", 2),
				ExcelData.CC_getCellData("FiltersData", "roomNameCCgroubByVerify", 2));
		logger.info("TestCase Ended");

	}

	@Test(priority = 5)
	@Description("Verify user should able to see that the price are sorted as low to high when filter is applied as group by room type in CC booking engine")
	@Severity(SeverityLevel.CRITICAL)
	@Epic("EP01")
	@Feature("Feature1:Call Center")
	@Story("Call Center")
	@Step("Verify user should able to see that the price are sorted as low to high when filter is applied as group by room type in CC booking engine")
	public void CallCenter_VerifyingFilters_allthelinksandSortingonAvailabilityPageTest_TC_05() throws IOException {
		logger.info("TestCase Started");
		extentTest = extent.startTest("CallCenter_VerifyingFilters_allthelinksandSortingonAvailabilityPageTest_TC_05");
		vfas.selectRpBar();
		Helper.sleep(2000);
		soft.assertTrue(
				vfas.takeSSandCompareBeforeAfterLowtoHighRoom("beforeFilterLowtoHighRoom", "AfterFilterLowtoHighRoom"));
		logger.info("TestCase Ended");
	}

	@Test(priority = 6)
	@Description("Verify user should able to see that the price are sorted as high to low when filter is applied as group by room type in CC booking engine")
	@Severity(SeverityLevel.CRITICAL)
	@Epic("EP01")
	@Feature("Feature1:Call Center")
	@Story("Call Center")
	@Step("Verify user should able to see that the price are sorted as high to low when filter is applied as group by room type in CC booking engine")
	public void CallCenter_VerifyingFilters_allthelinksandSortingonAvailabilityPageTest_TC_06() throws IOException {
		logger.info("TestCase Started");
		extentTest = extent.startTest("CallCenter_VerifyingFilters_allthelinksandSortingonAvailabilityPageTest_TC_06");
		Helper.sleep(2000);
		vfas.selectFilterNomral();
		soft.assertTrue(
				vfas.takeSSandCompareBeforeAfterHightoLowRoom("beforeFilterHightoLowRoom", "AfterFilterHightoLowRoom"));
		logger.info("TestCase Ended");
	}

	@Test(priority = 7)
	@Description("Verify user should able to see only those rooms that are associated with the filtered bed types in CC booking engine")
	@Severity(SeverityLevel.CRITICAL)
	@Epic("EP01")
	@Feature("Feature1:Call Center")
	@Story("Call Center")
	@Step("Verify user should able to see only those rooms that are associated with the filtered bed types in CC booking engine")
	public void CallCenter_VerifyingFilters_allthelinksandSortingonAvailabilityPageTest_TC_07() throws IOException {
		logger.info("TestCase Started");
		extentTest = extent.startTest("CallCenter_VerifyingFilters_allthelinksandSortingonAvailabilityPageTest_TC_07");
		Helper.switchWindow(0);
		ahp.clickPropertyManagementTab();
		ahp.bedType();
		vfas.clickAddNewbedType();
		vfas.createBedType();
		Helper.sleep(2000);
		ahp.clickPropertyManagementTab();
		Helper.sleep(1000);
		ahp.clickOnRoomTab();
		Helper.sleep(3000);
		ahp.clickOnListAllRoom();
		vfas.getRoomNameAdmin();
		vfas.clickEditRoom();
		vfas.getBedTypenameAdmin();
		vfas.selectBedType();
		Helper.switchWindow(1);
		mbcp.clickEditSearchButton();
		nsrb.clickAvailibilityButton();
		soft.assertTrue(
				vfas.takessandComparebeforeAfterSelectingBedTypeCheckbox("beforebedTyepFilter", "afterBedTypeFilter"));
		logger.info("TestCase Ended");
	}

	@Test(priority = 8)
	@Description("Verify user should able to see only the filtered rooms in CC booking engine")
	@Severity(SeverityLevel.CRITICAL)
	@Epic("EP01")
	@Feature("Feature1:Call Center")
	@Story("Call Center")
	@Step("Verify user should able to see only the filtered rooms in CC booking engine")
	public void CallCenter_VerifyingFilters_allthelinksandSortingonAvailabilityPageTest_TC_08() throws IOException {
		logger.info("TestCase Started");
		extentTest = extent.startTest("CallCenter_VerifyingFilters_allthelinksandSortingonAvailabilityPageTest_TC_08");
		mbcp.clickEditSearchButton();
		nsrb.clickAvailibilityButton();
		soft.assertTrue(vfas.takessandComparebeforeAfterSelectingRoomTypeCheckbox("beforeRoomTypeFilter",
				"afterRoomTypeFilter"));
		logger.info("TestCase Ended");
	}

	@Test(priority = 9)
	@Description("Verify user should able to see only the filtered rate plans in CC booking engine")
	@Severity(SeverityLevel.CRITICAL)
	@Epic("EP01")
	@Feature("Feature1:Call Center")
	@Story("Call Center")
	@Step("Verify user should able to see only the filtered rate plans in CC booking engine")
	public void CallCenter_VerifyingFilters_allthelinksandSortingonAvailabilityPageTest_TC_09() throws IOException {
		logger.info("TestCase Started");
		extentTest = extent.startTest("CallCenter_VerifyingFilters_allthelinksandSortingonAvailabilityPageTest_TC_09");
		vfas.clickRateTabCC();
		vfas.selectRatePlansCCTC09();
		nsrb.selectDateRangeCCTC01();
		nsrb.clickAvailibilityButton();
		soft.assertTrue(vfas.takessandComparebeforeAfterSelectingRatePlanCheckbox("beforeRatePlanFilter",
				"afterRatePlanFilter"));
		logger.info("TestCase Ended");
	}

	@Test(priority = 10)
	@Description("Verify user should able to see only the filtered room and rate plans combination in CC booking engine")
	@Severity(SeverityLevel.CRITICAL)
	@Epic("EP01")
	@Feature("Feature1:Call Center")
	@Story("Call Center")
	@Step("Verify user should able to see only the filtered room and rate plans combination in CC booking engine")
	public void CallCenter_VerifyingFilters_allthelinksandSortingonAvailabilityPageTest_TC_10() throws IOException {
		logger.info("TestCase Started");
		extentTest = extent.startTest("CallCenter_VerifyingFilters_allthelinksandSortingonAvailabilityPageTest_TC_10");
		soft.assertTrue(vfas.takessandComparebeforeAfterSelectingRatePlanAndRoomTypeCheckbox(
				"beforeRatePlanAndRoomTypeFilter", "afterRatePlanAndRoomTypeFilter"));
		// deletion
		Helper.switchWindow(0);
		vfas.clickEditRoom();
		vfas.deselectBedType();
		Helper.sleep(1000);
		ahp.clickPropertyManagementTab();
		Helper.sleep(1000);
		ahp.bedType();
		vfas.deleteBedType();
		Helper.sleep(2000);
		ahp.clickOnRoomTab();
		Helper.sleep(1000);
		ahp.clickRatePlansTab();
		Helper.sleep(1000);
		ahp.clickListAllRatePlan();
		vfas.deleteRatePlans();
		ahp.clickRatePlanCategories();
		rcp.deleteCategory();
		Helper.sleep(2000);
		lp.logout();
		vfas.delFolder();
	}
}
