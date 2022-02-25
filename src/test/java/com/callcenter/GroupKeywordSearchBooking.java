package com.callcenter;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.admin.pom.AddOnsPage;
import com.admin.pom.AdministratorHomePage;
import com.admin.pom.LoginPage;
import com.admin.pom.RatePlanCategoriesPage;
import com.admin.pom.RatePlanPage;
import com.admin.pom.RatesandInventoryPage;
import com.cc.pom.GroupKeywordSearchBookingPage;
import com.cc.pom.ModifyBookingfromconfirmationpagePage;
import com.cc.pom.ModifybookingusingLookupPage;
import com.cc.pom.NormalSingleRoomBookingandverifyRateGridupdatePage;

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

public class GroupKeywordSearchBooking extends TestBase {

	public static Utilitylog logger;

	// objects
	LoginPage lp;
	AdministratorHomePage ahp;
	RatePlanPage rpp;
	AddOnsPage aop;
	RatePlanCategoriesPage rcp;
	GroupKeywordSearchBookingPage gksb;
	NormalSingleRoomBookingandverifyRateGridupdatePage nsrb;
	ModifyBookingfromconfirmationpagePage mbcp;
	RatesandInventoryPage rip;
	ModifybookingusingLookupPage mblp;

	public GroupKeywordSearchBooking() {
		super();
		logger = new Utilitylog(GroupKeywordSearchBooking.class.getName());
	}

	@BeforeMethod
	public void setup() {
		lp = new LoginPage(getDriver());
		ahp = new AdministratorHomePage(getDriver());
		rpp = new RatePlanPage(getDriver());
		aop = new AddOnsPage(getDriver());
		rcp = new RatePlanCategoriesPage(getDriver());
		gksb = new GroupKeywordSearchBookingPage(getDriver());
		nsrb = new NormalSingleRoomBookingandverifyRateGridupdatePage(getDriver());
		mbcp = new ModifyBookingfromconfirmationpagePage(getDriver());
		rip = new RatesandInventoryPage(getDriver());
		mblp = new ModifybookingusingLookupPage(getDriver());
	}

	@Test(priority = 1)
	@Description("User is able to configure a Rate Plan for the Group Keyword Search Booking ")
	@Severity(SeverityLevel.CRITICAL)
	@Epic("EP01")
	@Feature("Feature1:Call Center")
	@Story("Call Center")
	@Step("User is able to configure a Rate Plan for the Group Keyword Search Booking ")
	public void CallCenter_GroupKeywordSearchBooking_TC_01() {
		logger.info("TestCase Started");
		extentTest = extent.startTest("CallCenter_GroupKeywordSearchBooking_TC_01");
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
		Assert.assertTrue(rcp.verifyAddNewCategory());
		gksb.createCategory();
		rcp.clickOnSave();
		Assert.assertTrue(gksb.verifyName());
		allureScreenshot("Category created");
		screenShot("Category created");
		ahp.clickAddNewRatePlansTab();
		allureScreenshot("Rate Plan Page");
		screenShot("Rate Plan Page");
		gksb.inputRateplanTC01();
		gksb.selectRoomType();
		rpp.deriveRatesNo();
		gksb.createGroupSearchTag();
		allureScreenshot("Group Search Tag");
		screenShot("Group Search Tag");
		rpp.clickSaveButton();
		openURL("cc_url");
		nsrb.enterCCuser();
		gksb.searchGroupKeywordCC();
		gksb.getRatePlanNameCCTC01();
		allureScreenshot("Group Search Tag rate plan");
		screenShot("Group Search Tag rate plan");
		Assert.assertEquals(ExcelData.CC_getCellData("NormalSingleRoomBookingData", "GroupRatePlanNames", 2),
				ExcelData.CC_getCellData("GroupKeywordData", "RPName", 2));
		logger.info("TestCase Ended");
	}

	@Test(priority = 2)
	@Description("User is able to configure multiple Rate Plans for the Group Keyword Search Booking ")
	@Severity(SeverityLevel.CRITICAL)
	@Epic("EP01")
	@Feature("Feature1:Call Center")
	@Story("Call Center")
	@Step("User is able to configure multiple Rate Plans for the Group Keyword Search Booking ")
	public void CallCenter_GroupKeywordSearchBooking_TC_02() throws InterruptedException {
		logger.info("TestCase Started");
		extentTest = extent.startTest("CallCenter_GroupKeywordSearchBooking_TC_02");
		Helper.switchWindow(0);
		ahp.clickAddNewRatePlansTab();
		allureScreenshot("Rate Plan Page");
		screenShot("Rate Plan Page");
		gksb.inputRateplanTC02();
		gksb.selectRoomType();
		rpp.deriveRatesNo();
		gksb.createGroupSearchTag();
		allureScreenshot("Group Search Tag");
		screenShot("Group Search Tag");
		rpp.clickSaveButton();
		Helper.switchWindow(1);
		Helper.refresh();
		Thread.sleep(1000);
		gksb.searchGroupKeywordCC();
		gksb.getRatePlanNameCCTC02();
		allureScreenshot("Group Search Tag rate plans");
		screenShot("Group Search Tag rate plans");
		Assert.assertEquals(ExcelData.CC_getCellData("NormalSingleRoomBookingData", "GroupRatePlanNames", 2),
				ExcelData.CC_getCellData("GroupKeywordData", "RPName", 2));
		Assert.assertEquals(ExcelData.CC_getCellData("NormalSingleRoomBookingData", "GroupRatePlanNames", 3),
				ExcelData.CC_getCellData("GroupKeywordData", "RPName", 3));
		logger.info("TestCase Ended");
	}

	@Test(priority = 3)
	@Description("User should be able to complete the booking using Group Keyword Search")
	@Severity(SeverityLevel.CRITICAL)
	@Epic("EP01")
	@Feature("Feature1:Call Center")
	@Story("Call Center")
	@Step("User should be able to complete the booking using Group Keyword Search")
	public void CallCenter_GroupKeywordSearchBooking_TC_03() throws InterruptedException {
		logger.info("TestCase Started");
		extentTest = extent.startTest("CallCenter_GroupKeywordSearchBooking_TC_03");
		Helper.switchWindow(0);
		ahp.selectRatesandInventory();
		Thread.sleep(2000);
		rip.selectRateGrid();
		gksb.selectRatePlan();
		allureScreenshot("Rate grid - rate plan");
		screenShot("Rate grid - rate plan");
		rip.continueButton();
		nsrb.selectDateRangeTC01();
		rip.clickoverrideRoomCheckbox();
		rip.clickdailyRateInvbutton();
		nsrb.selectALLRoomType();
		allureScreenshot("Rate Grid");
		screenShot("Rate Grid");
		gksb.inputFieldRate();
		nsrb.openYieldControls();
		nsrb.clickQuickEntrybutton();
		nsrb.clickUpdateButton();
		nsrb.clickConfirmButton();
		Helper.switchWindow(1);
		Helper.refresh();
		Thread.sleep(1000);
		gksb.selectGroupRatePlanBookingCC();
		allureScreenshot("selected Group RatePlan");
		screenShot("selected Group RatePlan");
		nsrb.selectDateRangeCCTC01();
		nsrb.clickAvailibilityButton();
		gksb.selectRoom();
		nsrb.clickpaymentButton();
		allureScreenshot("Call Center payment details");
		screenShot("Call Center payment details");
		nsrb.inputGuestDetails();
		nsrb.inputCardDetailsTC01();
		nsrb.inputBillingAddress();
		nsrb.selectTermsAndConditonCheckbox();
		nsrb.clickCompleteReservation();
		Thread.sleep(3000);
		Assert.assertTrue(mbcp.verifyConfirmationCode());
		allureScreenshot("Confirmation Page");
		screenShot("Confirmation Page");
		logger.info("TestCase Ended");
	}

	@Test(priority = 4)
	@Description("User should be able to search the Rate Plans using multiple Group Keyword Search in CC Booking Engine")
	@Severity(SeverityLevel.CRITICAL)
	@Epic("EP01")
	@Feature("Feature1:Call Center")
	@Story("Call Center")
	@Step("User should be able to search the Rate Plans using multiple Group Keyword Search in CC Booking Engine")
	public void CallCenter_GroupKeywordSearchBooking_TC_04() throws InterruptedException {
		logger.info("TestCase Started");
		extentTest = extent.startTest("CallCenter_GroupKeywordSearchBooking_TC_04");
		Helper.switchWindow(0);
		ahp.clickRatePlansTab();
		ahp.clickAddNewRatePlansTab();
		allureScreenshot("Rate Plan Page");
		screenShot("Rate Plan Page");
		gksb.inputRateplanTC04();
		gksb.selectRoomType();
		rpp.deriveRatesNo();
		gksb.createGroupSearchTagTC04();
		allureScreenshot("Group Search Tag");
		screenShot("Group Search Tag");
		rpp.clickSaveButton();
		Helper.switchWindow(1);
		Thread.sleep(1000);
		mblp.clickNewReservation();
		gksb.searchGroupKeywordCCTC04();
		gksb.getRatePlanNameCCTC04();
		allureScreenshot("Group Search Tag rate plans");
		screenShot("Group Search Tag rate plans");
		Assert.assertEquals(ExcelData.CC_getCellData("NormalSingleRoomBookingData", "GroupRatePlanNames", 2),
				ExcelData.CC_getCellData("GroupKeywordData", "RPName", 2));
		Assert.assertEquals(ExcelData.CC_getCellData("NormalSingleRoomBookingData", "GroupRatePlanNames", 3),
				ExcelData.CC_getCellData("GroupKeywordData", "RPName", 3));
		Assert.assertEquals(ExcelData.CC_getCellData("NormalSingleRoomBookingData", "GroupRatePlanNames", 4),
				ExcelData.CC_getCellData("GroupKeywordData", "RPName", 4));
		// to delete the data created
		Helper.switchWindow(0);
		gksb.deleteRatePlans();
		ahp.clickRatePlanCategories();
		rcp.deleteCategory();
		lp.logout();
		logger.info("TestCase Ended");
	}

}
