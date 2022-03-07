package com.callcenter;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

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
 * Test class for OfferAccessCodeBooking
 * @author Rudraksh Aggarwal
 */
public class OfferAccessCodeBooking extends TestBase {

	public static Utilitylog logger;

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

	public OfferAccessCodeBooking() {
		super();
		logger = new Utilitylog(OfferAccessCodeBooking.class.getName());
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
	}

	@Test(priority = 1)
	@Description("Verify user is able to do the configuration for Access code booking")
	@Severity(SeverityLevel.CRITICAL)
	@Epic("EP01")
	@Feature("Feature1:Call Center")
	@Story("Call Center")
	@Step("Verify user is able to do the configuration for Access code booking")
	public void CallCenter_OfferAccessCodeBooking_TC_01() {
		logger.info("TestCase Started");
		extentTest = extent.startTest("CallCenter_OfferAccessCodeBooking_TC_01");
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
		oacb.createCategory();
		rcp.clickOnSave();
		Assert.assertTrue(oacb.verifyName());
		allureScreenshot("Category created");
		screenShot("Category created");
		ahp.clickAddNewRatePlansTab();
		allureScreenshot("Rate Plan Page");
		screenShot("Rate Plan Page");
		oacb.inputRateplanTC01();
		gksb.selectRoomType();
		rpp.deriveRatesNo();
		rpp.clickSaveButton();
		ahp.selectRatesandInventory();
		Helper.sleep(2000);
		rip.selectRateGrid();
		oacb.selectRatePlanRateGrid();
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
		ahp.clickRatePlansTab();
		ahp.clickmanageAccessCode();
		oacb.searchRatePlanAC();
		allureScreenshot("Manage Access Code");
		screenShot("Manage Access Code");
		oacb.clickAddAccessCode();
		oacb.inputAccessCodeTC01();
		allureScreenshot("Access Code Page");
		screenShot("Access Code Page");
		rpp.clickSaveButton();
		Assert.assertTrue(oacb.verifyAccessCodeAdminTC01());
		allureScreenshot("Access Code Admin");
		screenShot("Access Code Admin");
		Assert.assertEquals(ExcelData.CC_getCellData("NormalSingleRoomBookingData", "AccessCodeAdmin", 2),
				ExcelData.CC_getCellData("OfferAccessCodeBooking", "AccCode", 2));
		logger.info("TestCase Ended");
	}

	@Test(priority = 2)
	@Description("Verify user is able to Edit the Access code and search in cc")
	@Severity(SeverityLevel.CRITICAL)
	@Epic("EP01")
	@Feature("Feature1:Call Center")
	@Story("Call Center")
	@Step("Verify user is able to Edit the Access code and search in cc")
	public void CallCenter_OfferAccessCodeBooking_TC_02() {
		logger.info("TestCase Started");
		extentTest = extent.startTest("CallCenter_OfferAccessCodeBooking_TC_02");
		ahp.clickmanageAccessCode();
		oacb.searchRatePlanAC();
		oacb.clickEditAccessCode();
		oacb.inputAccessCodeTC02();
		allureScreenshot("Access Code Page");
		screenShot("Access Code Page");
		rpp.clickSaveButton();
		Assert.assertTrue(oacb.verifyAccessCodeAdminTC02());
		allureScreenshot("Access Code Admin");
		screenShot("Access Code Admin");
		Assert.assertEquals(ExcelData.CC_getCellData("NormalSingleRoomBookingData", "AccessCodeAdmin", 3),
				ExcelData.CC_getCellData("OfferAccessCodeBooking", "AccCode", 3));
		openURL("cc_url");
		nsrb.enterCCuser();
		allureScreenshot("Call Center");
		screenShot("Call Center");
		nsrb.selectDateRangeCCTC01();
		oacb.inputOfferCodeCCTC02();
		allureScreenshot("Access Code CC");
		screenShot("Access Code CC");
		nsrb.clickAvailibilityButton();
		oacb.selectRoom();
		oacb.getofferNameCCTC02();
		allureScreenshot("Rate Plan Name CC");
		screenShot("Rate Plan Name CC");
		Assert.assertEquals(ExcelData.CC_getCellData("NormalSingleRoomBookingData", "RPNameCC", 2),
				ExcelData.CC_getCellData("OfferAccessCodeBooking", "RPName", 2));
		logger.info("TestCase Ended");
	}

	@Test(priority = 3)
	@Description("Verify user is able to do the booking in cc using Access code")
	@Severity(SeverityLevel.CRITICAL)
	@Epic("EP01")
	@Feature("Feature1:Call Center")
	@Story("Call Center")
	@Step("Verify user is able to do the booking in cc using Access code")
	public void CallCenter_OfferAccessCodeBooking_TC_03() {
		logger.info("TestCase Started");
		extentTest = extent.startTest("CallCenter_OfferAccessCodeBooking_TC_03");
		nsrb.clickpaymentButton();
		allureScreenshot("Call Center payment details");
		screenShot("Call Center payment details");
		nsrb.inputGuestDetails();
		nsrb.inputCardDetailsTC01();
		nsrb.inputBillingAddress();
		nsrb.selectTermsAndConditonCheckbox();
		nsrb.clickCompleteReservation();
		Assert.assertTrue(mbcp.verifyConfirmationCode());
		mbcp.verifyRoomTypebefore();
		allureScreenshot("Call Center booking confirmation code");
		screenShot("Call Center booking confirmation code");
		logger.info("TestCase Ended");
	}

	@Test(priority = 4)
	@Description("Verify user is able to modify the access code booking")
	@Severity(SeverityLevel.CRITICAL)
	@Epic("EP01")
	@Feature("Feature1:Call Center")
	@Story("Call Center")
	@Step("Verify user is able to modify the access code booking")
	public void CallCenter_OfferAccessCodeBooking_TC_04() {
		logger.info("TestCase Started");
		extentTest = extent.startTest("CallCenter_OfferAccessCodeBooking_TC_04");
		mbcp.modify();
		mbcp.clickEditSearchButton();
		nsrb.clickAvailibilityButton();
		nsrb.selectRoomModify();
		allureScreenshot("Room After");
		screenShot("Room After");
		nsrb.clickpaymentButton();
		nsrb.inputGuestDetails();
		mbcp.selectKingBedType();
		nsrb.inputCardDetailsTC01();
		nsrb.inputBillingAddress();
		nsrb.selectTermsAndConditonCheckbox();
		nsrb.clickCompleteReservation();
		allureScreenshot("Confirmation Page");
		screenShot("Confirmation Page");
		mbcp.verifyRoomTypeafter();
		Assert.assertTrue(mbcp.verifyRoomModify());
		logger.info("TestCase Ended");
	}

	@Test(priority = 5)
	@Description("Verify user is able to cancel the access code booking")
	@Severity(SeverityLevel.CRITICAL)
	@Epic("EP01")
	@Feature("Feature1:Call Center")
	@Story("Call Center")
	@Step("Verify user is able to cancel the access code booking")
	public void CallCenter_OfferAccessCodeBooking_TC_05() {
		logger.info("TestCase Started");
		extentTest = extent.startTest("CallCenter_OfferAccessCodeBooking_TC_05");
		nsrb.clickNewReservation();
		nsrb.selectDateRangeCCTC01();
		nsrb.clickAvailibilityButton();
		nsrb.selectRoom();
		nsrb.clickpaymentButton();
		allureScreenshot("Call Center payment details");
		screenShot("Call Center payment details");
		nsrb.inputGuestDetails();
		nsrb.inputCardDetailsTC01();
		nsrb.inputBillingAddress();
		nsrb.selectTermsAndConditonCheckbox();
		nsrb.clickCompleteReservation();
		Assert.assertTrue(mbcp.verifyConfirmationCode());
		allureScreenshot("Call Center booking confirmation code");
		screenShot("Call Center booking confirmation code");
		Assert.assertTrue(oacb.verifyCancelBookingTC05());
		allureScreenshot("Call Center booking Cancellation confirmation");
		screenShot("Call Center booking Cancellation confirmation");
		logger.info("TestCase Ended");
	}

	@Test(priority = 6)
	@Description("Verify user is able to associate multiple access code with single rate plan")
	@Severity(SeverityLevel.CRITICAL)
	@Epic("EP01")
	@Feature("Feature1:Call Center")
	@Story("Call Center")
	@Step("Verify user is able to associate multiple access code with single rate plan")
	public void CallCenter_OfferAccessCodeBooking_TC_06() {
		logger.info("TestCase Started");
		extentTest = extent.startTest("CallCenter_OfferAccessCodeBooking_TC_06");
		Helper.switchWindow(0);
		oacb.clickAddAccessCode();
		oacb.inputAccessCodeTC06_1();
		allureScreenshot("Access Code Page");
		screenShot("Access Code Page");
		rpp.clickSaveButton();
		Assert.assertTrue(oacb.verifyAccessCodeAdminTC06_1());
		allureScreenshot("Access Code Admin TC06_1");
		screenShot("Access Code Admin TC06_1");
		Assert.assertEquals(ExcelData.CC_getCellData("NormalSingleRoomBookingData", "AccessCodeAdmin", 4),
				ExcelData.CC_getCellData("OfferAccessCodeBooking", "AccCode", 4));
		oacb.clickAddAccessCode();
		oacb.inputAccessCodeTC06_2();
		allureScreenshot("Access Code Page");
		screenShot("Access Code Page");
		rpp.clickSaveButton();
		Assert.assertTrue(oacb.verifyAccessCodeAdminTC06_2());
		allureScreenshot("Access Code Admin TC06_2");
		screenShot("Access Code Admin TC06_2");
		Assert.assertEquals(ExcelData.CC_getCellData("NormalSingleRoomBookingData", "AccessCodeAdminTC06_2", 2),
				ExcelData.CC_getCellData("OfferAccessCodeBooking", "AccCode", 5));
		Helper.switchWindow(1);
		oacb.clickOkCancel();
		nsrb.selectDateRangeCCTC01();
		oacb.inputOfferCodeCCTC06_1();
		nsrb.clickAvailibilityButton();
		oacb.getofferCodeCCTC06_1();
		allureScreenshot("Rate Plan Name CC_1");
		screenShot("Rate Plan Name CC_1");
		Assert.assertEquals(ExcelData.CC_getCellData("NormalSingleRoomBookingData", "RPNameCC", 3),
				ExcelData.CC_getCellData("OfferAccessCodeBooking", "RPName", 2));
		mbcp.clickEditSearchButton();
		oacb.inputOfferCodeCCTC06_2();
		nsrb.clickAvailibilityButton();
		oacb.getofferCodeCCTC06_2();
		allureScreenshot("Rate Plan Name CC_2");
		screenShot("Rate Plan Name CC_2");
		Assert.assertEquals(ExcelData.CC_getCellData("NormalSingleRoomBookingData", "RPNameCC", 4),
				ExcelData.CC_getCellData("OfferAccessCodeBooking", "RPName", 2));
		logger.info("TestCase Ended");
	}

	@Test(priority = 7)
	@Description("Verify user is able to delete the Access codes and verify in cc")
	@Severity(SeverityLevel.CRITICAL)
	@Epic("EP01")
	@Feature("Feature1:Call Center")
	@Story("Call Center")
	@Step("Verify user is able to delete the Access codes and verify in cc")
	public void CallCenter_OfferAccessCodeBooking_TC_07() {
		logger.info("TestCase Started");
		extentTest = extent.startTest("CallCenter_OfferAccessCodeBooking_TC_07");
		Helper.switchWindow(0);
		oacb.DeleteAC();
		allureScreenshot("Access Code Delete");
		screenShot("Access Code Delete");
		Helper.switchWindow(1);
		mbcp.clickEditSearchButton();
		oacb.inputOfferCodeCCTC06_2();
		nsrb.clickAvailibilityButton();
		Assert.assertTrue(oacb.verifyDeleteAC());
		allureScreenshot("Access Code Delete CC");
		screenShot("Access Code Delete CC");
		
		// to delete the data created
		Helper.switchWindow(0);
		ahp.clickListAllRatePlan();
		oacb.deleteRatePlans();
		ahp.clickRatePlanCategories();
		rcp.deleteCategory();
		lp.logout();
	}

}
