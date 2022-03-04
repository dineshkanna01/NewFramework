package com.callcenter;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.admin.pom.AdministratorHomePage;
import com.admin.pom.LoginPage;
import com.admin.pom.ReportsPage;
import com.be.pom.JCCBookingsPage;
import com.cc.pom.ModifyBookingfromconfirmationpagePage;
import com.cc.pom.ModifyRT3BookingfromCCsiteandviceversaPage;
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

/*
 * Test class for ModifyRT3BookingfromCCsiteandviceversaPage
 * @author Rudraksh Aggarwal
 */
public class ModifyRT3BookingfromCCsiteandviceversa extends TestBase {
	public static Utilitylog logger;

	// objects
	LoginPage lp;
	AdministratorHomePage ahp;
	NormalSingleRoomBookingandverifyRateGridupdatePage nsrb;
	ReportsPage rep;
	ModifyBookingfromconfirmationpagePage mbcp;
	ModifyRT3BookingfromCCsiteandviceversaPage mbcv;
	JCCBookingsPage jbp;

	public ModifyRT3BookingfromCCsiteandviceversa() {
		super();
		logger = new Utilitylog(ModifyRT3BookingfromCCsiteandviceversa.class.getName());
	}

	@BeforeMethod
	public void setup() {
		lp = new LoginPage(getDriver());
		ahp = new AdministratorHomePage(getDriver());
		nsrb = new NormalSingleRoomBookingandverifyRateGridupdatePage(getDriver());
		rep = new ReportsPage(getDriver());
		mbcp = new ModifyBookingfromconfirmationpagePage(getDriver());
		mbcv = new ModifyRT3BookingfromCCsiteandviceversaPage(getDriver());
		jbp = new JCCBookingsPage(getDriver());
	}

	@Test(priority = 1)
	@Description("Verify user is able to do a booking from call center and then modify it using booking engine for room type")
	@Severity(SeverityLevel.CRITICAL)
	@Epic("EP01")
	@Feature("Feature1:Call Center")
	@Story("Call Center")
	@Step("Verify user is able to do a booking from call center and then modify it using booking engine for room type")
	public void CallCenter_ModifyRT3BookingfromCCsiteandviceversa_TC_01() {
		logger.info("TestCase Started");
		extentTest = extent.startTest("CallCenter_ModifyRT3BookingfromCCsiteandviceversa_TC_01");
		lp.login();
		allureScreenshot("Login");
		screenShot("Login");
		ahp.selectBrand();
		ahp.selectProperty2();
		allureScreenshot("Property Selected");
		screenShot("Property Selected");
		openURL("cc_url");
		nsrb.enterCCuser();
		allureScreenshot("Call Center");
		screenShot("Call Center");
		nsrb.selectDateRangeCCTC01();
		nsrb.clickAvailibilityButton();
		nsrb.selectRoom();
		allureScreenshot("Room Before");
		screenShot("Room Before");
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
		Helper.switchWindow(0);
		ahp.selectReports();
		rep.selectSearchReservationReport();
		Assert.assertTrue(mbcp.searchReservation());
		allureScreenshot("Booking in Report");
		screenShot("Booking in Report");
		getDriver().close();
		Helper.switchWindow(0);
		openURL("be_url1");
		allureScreenshot("Booking Engine");
		screenShot("Booking Engine");
		mbcv.LookupBE();
		Assert.assertTrue(mbcv.verifyConfirmationCodeBE());
		Assert.assertEquals(ExcelData.CC_getCellData("NormalSingleRoomBookingData", "CCcodeBE", 2),
				ExcelData.CC_getCellData("NormalSingleRoomBookingData", "ConfirmationCode", 2));
		mbcv.modifyReservationBE();
		mbcv.selectmodifiedroomBE();
		allureScreenshot("Room After");
		screenShot("Room After");
		jbp.clickBookNowButton();
		jbp.inputGuestDetails();
		jbp.selectRatePlanBar();
		jbp.clickconfirmDetails();
		jbp.inputCardDetailsTC01();
		jbp.inputBillingAddress();
		jbp.inputadditionalContactInfo();
		jbp.selectTermsAndConditonCheckbox();
		allureScreenshot("Payment Details Page BE");
		screenShot("Payment Details Page BE");
		jbp.clickCompleteReservation();
		mbcv.verifyRoomTypeafterTC01();
		Assert.assertTrue(mbcv.verifyRoomModify());
		allureScreenshot("Booking confirmation page BE");
		screenShot("Booking confirmation page BE");
		logger.info("TestCase Ended");
	}

	@Test(priority = 2)
	@Description("Verify user is able to do a booking from call center and then modify it using booking engine for stay dates")
	@Severity(SeverityLevel.CRITICAL)
	@Epic("EP01")
	@Feature("Feature1:Call Center")
	@Story("Call Center")
	@Step("Verify user is able to do a booking from call center and then modify it using booking engine for stay dates")
	public void CallCenter_ModifyRT3BookingfromCCsiteandviceversa_TC_02() {
		logger.info("TestCase Started");
		extentTest = extent.startTest("CallCenter_ModifyRT3BookingfromCCsiteandviceversa_TC_02");
		Helper.switchWindow(0);
		nsrb.clickNewReservation();
		;
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
		mbcp.getDatesBefore();
		allureScreenshot("Dates Before and Call Center booking confirmation code");
		screenShot("Dates Before and Call Center booking confirmation code");
		Helper.switchWindow(1);
		Helper.refreshBE();
		allureScreenshot("Booking Engine");
		screenShot("Booking Engine");
		mbcv.LookupBE();
		Assert.assertTrue(mbcv.verifyConfirmationCodeBE());
		Assert.assertEquals(ExcelData.CC_getCellData("NormalSingleRoomBookingData", "CCcodeBE", 2),
				ExcelData.CC_getCellData("NormalSingleRoomBookingData", "ConfirmationCode", 2));
		mbcv.modifyReservationBE();
		mbcv.selectDateTC02();
		jbp.clickAvailibilityButton();
		jbp.clickBookNowButton();
		jbp.inputGuestDetails();
		jbp.selectRatePlanBar();
		jbp.clickconfirmDetails();
		jbp.inputCardDetailsTC01();
		jbp.inputBillingAddress();
		jbp.inputadditionalContactInfo();
		jbp.selectTermsAndConditonCheckbox();
		allureScreenshot("Payment Details Page BE");
		screenShot("Payment Details Page BE");
		jbp.clickCompleteReservation();
		mbcv.getDatesAfterBETC02();
		Assert.assertTrue(mbcv.verifyDatesModifyTC02());
		allureScreenshot("Dates After and BE booking confirmation code");
		screenShot("Dates After and BE booking confirmation code");
		logger.info("TestCase Ended");
	}

	@Test(priority = 3)
	@Description("Verify user is able to do a booking from call center and then modify it using booking engine for Guest Details")
	@Severity(SeverityLevel.CRITICAL)
	@Epic("EP01")
	@Feature("Feature1:Call Center")
	@Story("Call Center")
	@Step("Verify user is able to do a booking from call center and then modify it using booking engine for Guest Details")
	public void CallCenter_ModifyRT3BookingfromCCsiteandviceversa_TC_03() {
		logger.info("TestCase Started");
		extentTest = extent.startTest("CallCenter_ModifyRT3BookingfromCCsiteandviceversa_TC_03");
		Helper.switchWindow(0);
		nsrb.clickNewReservation();
		;
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
		mbcp.getGuestDetailsbefore();
		allureScreenshot("Guest Details Before and Call Center booking confirmation code");
		screenShot("Guest Details Before and Call Center booking confirmation code");
		Helper.switchWindow(1);
		allureScreenshot("Booking Engine");
		screenShot("Booking Engine");
		Helper.refreshBE();
		mbcv.LookupBE();
		Assert.assertTrue(mbcv.verifyConfirmationCodeBE());
		Assert.assertEquals(ExcelData.CC_getCellData("NormalSingleRoomBookingData", "CCcodeBE", 2),
				ExcelData.CC_getCellData("NormalSingleRoomBookingData", "ConfirmationCode", 2));
		mbcv.modifyReservationBE();
		jbp.clickBookNowButton();
		mbcv.inputGuestDetailsTC03();
		jbp.selectRatePlanBar();
		jbp.clickconfirmDetails();
		jbp.inputCardDetailsTC01();
		jbp.inputBillingAddress();
		jbp.inputadditionalContactInfo();
		jbp.selectTermsAndConditonCheckbox();
		allureScreenshot("Payment Details Page BE");
		screenShot("Payment Details Page BE");
		jbp.clickCompleteReservation();
		mbcv.getGuestDetailsafterBETC03();
		Assert.assertTrue(mbcv.verifyGuestDetailsModifyTC03());
		allureScreenshot("Guest Details After and BE booking confirmation code");
		screenShot("Guest Details After and BE booking confirmation code");
		logger.info("TestCase Ended");
	}

	@Test(priority = 4)
	@Description("User should be able to do a call center booking with AddOns and then modify for No AddOns through Booking Engine")
	@Severity(SeverityLevel.CRITICAL)
	@Epic("EP01")
	@Feature("Feature1:Call Center")
	@Story("Call Center")
	@Step("User should be able to do a call center booking with AddOns and then modify for No AddOns through Booking Engine")
	public void CallCenter_ModifyRT3BookingfromCCsiteandviceversa_TC_04() {
		logger.info("TestCase Started");
		extentTest = extent.startTest("CallCenter_ModifyRT3BookingfromCCsiteandviceversa_TC_04");
		Helper.switchWindow(0);
		nsrb.clickNewReservation();
		nsrb.selectDateRangeCCTC01();
		nsrb.clickAvailibilityButton();
		nsrb.selectRoom();
		allureScreenshot("Room Before");
		screenShot("Room Before");
		nsrb.clickpaymentButton();
		allureScreenshot("Call Center payment details");
		screenShot("Call Center payment details");
		nsrb.inputGuestDetails();
		mbcp.selectAddOn();
		nsrb.inputCardDetailsTC01();
		nsrb.inputBillingAddress();
		nsrb.selectTermsAndConditonCheckbox();
		allureScreenshot("Grand Total Before");
		screenShot("Grand Total Before");
		nsrb.clickCompleteReservation();
		Assert.assertTrue(mbcp.verifyConfirmationCode());
		mbcv.getGrandTotalBeforeCCTC04();
		allureScreenshot("Call Center booking confirmation code");
		screenShot("Call Center booking confirmation code");
		Helper.switchWindow(1);
		allureScreenshot("BE");
		screenShot("BE");
		Helper.refreshBE();
		mbcv.LookupBE();
		Assert.assertTrue(mbcv.verifyConfirmationCodeBE());
		Assert.assertEquals(ExcelData.CC_getCellData("NormalSingleRoomBookingData", "CCcodeBE", 2),
				ExcelData.CC_getCellData("NormalSingleRoomBookingData", "ConfirmationCode", 2));
		mbcv.modifyReservationBE();
		jbp.clickBookNowButton();
		jbp.inputGuestDetails();
		jbp.selectRatePlanBar();
		mbcv.selectAddOn(); // to deselect
		jbp.clickconfirmDetails();
		jbp.inputCardDetailsTC01();
		jbp.inputBillingAddress();
		jbp.inputadditionalContactInfo();
		jbp.selectTermsAndConditonCheckbox();
		jbp.clickCompleteReservation();
		mbcv.getGrandTotalAfterBETC04();
		Assert.assertTrue(mbcv.verifyOtherServicesModifyTC04());
		logger.info("TestCase Ended");
	}

	@Test(priority = 5)
	@Description("User should be able to do a call center booking without AddOns and then modify it to have AddOns through Booking Engine")
	@Severity(SeverityLevel.CRITICAL)
	@Epic("EP01")
	@Feature("Feature1:Call Center")
	@Story("Call Center")
	@Step("User should be able to do a call center booking without AddOns and then modify it to have AddOns through Booking Engine")
	public void CallCenter_ModifyRT3BookingfromCCsiteandviceversa_TC_05() {
		logger.info("TestCase Started");
		extentTest = extent.startTest("CallCenter_ModifyRT3BookingfromCCsiteandviceversa_TC_05");
		Helper.switchWindow(0);
		nsrb.clickNewReservation();
		nsrb.selectDateRangeCCTC01();
		nsrb.clickAvailibilityButton();
		nsrb.selectRoom();
		allureScreenshot("Room Before");
		screenShot("Room Before");
		nsrb.clickpaymentButton();
		allureScreenshot("Call Center payment details");
		screenShot("Call Center payment details");
		nsrb.inputGuestDetails();
		nsrb.inputCardDetailsTC01();
		nsrb.inputBillingAddress();
		nsrb.selectTermsAndConditonCheckbox();
		allureScreenshot("Other Services before");
		screenShot("Other Services before");
		nsrb.clickCompleteReservation();
		Assert.assertTrue(mbcp.verifyConfirmationCode());
		mbcv.getOtherServicesBeforeTC05();
		allureScreenshot("Call Center booking confirmation code");
		screenShot("Center booking confirmation code");
		Helper.switchWindow(1);
		allureScreenshot("Booking Engine");
		screenShot("Booking Engine");
		Helper.refreshBE();
		mbcv.LookupBE();
		Assert.assertTrue(mbcv.verifyConfirmationCodeBE());
		Assert.assertEquals(ExcelData.CC_getCellData("NormalSingleRoomBookingData", "CCcodeBE", 2),
				ExcelData.CC_getCellData("NormalSingleRoomBookingData", "ConfirmationCode", 2));
		mbcv.modifyReservationBE();
		jbp.clickBookNowButton();
		jbp.inputGuestDetails();
		jbp.selectRatePlanBar();
		mbcv.selectAddOn();
		jbp.clickconfirmDetails();
		jbp.inputCardDetailsTC01();
		jbp.inputBillingAddress();
		jbp.inputadditionalContactInfo();
		jbp.selectTermsAndConditonCheckbox();
		jbp.clickCompleteReservation();
		mbcv.getOtherServicesafterBETC05();
		Assert.assertTrue(mbcp.verifyOtherServicesModify());
		logger.info("TestCase Ended");
	}

	@Test(priority = 6)
	@Description("User should be able to do a call center booking through Booking Engine and modify it from call center for room type")
	@Severity(SeverityLevel.CRITICAL)
	@Epic("EP01")
	@Feature("Feature1:Call Center")
	@Story("Call Center")
	@Step("User should be able to do a call center booking through Booking Engine and modify it from call center for room type")
	public void CallCenter_ModifyRT3BookingfromCCsiteandviceversa_TC_06() {
		logger.info("TestCase Started");
		extentTest = extent.startTest("CallCenter_ModifyRT3BookingfromCCsiteandviceversa_TC_06");
		Helper.switchWindow(1);
		Helper.refreshBE();
		jbp.selectDate();
		jbp.clickAvailibilityButton();
		mbcv.selectroomBE(); // standard room
		jbp.clickBookNowButton();
		jbp.inputGuestDetails();
		jbp.selectRatePlanBar();
		jbp.clickconfirmDetails();
		jbp.inputCardDetailsTC01();
		jbp.inputBillingAddress();
		jbp.inputadditionalContactInfo();
		jbp.selectTermsAndConditonCheckbox();
		jbp.clickCompleteReservation();
		Assert.assertTrue(mbcv.verifyConfirmationCodeBE());
		allureScreenshot("RoomType Before");
		screenShot("RoomType Before");
		mbcv.getRoomTypeBeforeBETC06();
		Helper.switchWindow(0);
		allureScreenshot("Call Center");
		screenShot("Call Center");
		nsrb.clickNewReservation();
		mbcv.LookupCC();
		Assert.assertTrue(mbcv.verifyConfirmationCodeCCLookup());
		Assert.assertEquals(ExcelData.CC_getCellData("NormalSingleRoomBookingData", "CCcodeBE", 2),
				ExcelData.CC_getCellData("NormalSingleRoomBookingData", "CCcodeCallCenterLookup", 2));
		mbcv.modifyLookupCC();
		nsrb.selectRoomTC08mbcp();// select classic room
		nsrb.clickpaymentButton();
		nsrb.inputGuestDetails();
		nsrb.inputCardDetailsTC01();
		nsrb.inputBillingAddress();
		nsrb.selectTermsAndConditonCheckbox();
		nsrb.clickCompleteReservation();
		Assert.assertTrue(mbcp.verifyConfirmationCode());
		allureScreenshot("RoomType after");
		screenShot("RoomType after");
		mbcp.verifyRoomTypeafter();
		Assert.assertTrue(mbcv.verifyRoomModifyTC06());
	}

	@Test(priority = 7)
	@Description("User should be able to do a call center booking through Booking Engine and modify it from call center for stay dates")
	@Severity(SeverityLevel.CRITICAL)
	@Epic("EP01")
	@Feature("Feature1:Call Center")
	@Story("Call Center")
	@Step("User should be able to do a call center booking through Booking Engine and modify it from call center for stay dates")
	public void CallCenter_ModifyRT3BookingfromCCsiteandviceversa_TC_07() {
		logger.info("TestCase Started");
		extentTest = extent.startTest("CallCenter_ModifyRT3BookingfromCCsiteandviceversa_TC_07");
		Helper.switchWindow(1);
		Helper.refreshBE();
		jbp.selectDate();
		jbp.clickAvailibilityButton();
		mbcv.selectroomBE(); // standard room
		jbp.clickBookNowButton();
		jbp.inputGuestDetails();
		jbp.selectRatePlanBar();
		jbp.clickconfirmDetails();
		jbp.inputCardDetailsTC01();
		jbp.inputBillingAddress();
		jbp.inputadditionalContactInfo();
		jbp.selectTermsAndConditonCheckbox();
		jbp.clickCompleteReservation();
		Assert.assertTrue(mbcv.verifyConfirmationCodeBE());
		allureScreenshot("Dates Before");
		screenShot("Dates Before");
		mbcv.getDatesBeforeBETC07();
		Helper.switchWindow(0);
		allureScreenshot("Call Center");
		screenShot("Call Center");
		nsrb.clickNewReservation();
		mbcv.LookupCC();
		Assert.assertTrue(mbcv.verifyConfirmationCodeCCLookup());
		Assert.assertEquals(ExcelData.CC_getCellData("NormalSingleRoomBookingData", "CCcodeBE", 2),
				ExcelData.CC_getCellData("NormalSingleRoomBookingData", "CCcodeCallCenterLookup", 2));
		mbcv.modifyLookupCC();
		mbcp.clickEditSearchButton();
		mbcv.selectDateRangeCCTC07();
		nsrb.clickAvailibilityButton();
		nsrb.selectRoom();
		nsrb.clickpaymentButton();
		nsrb.inputGuestDetails();
		nsrb.inputCardDetailsTC01();
		nsrb.inputBillingAddress();
		nsrb.selectTermsAndConditonCheckbox();
		nsrb.clickCompleteReservation();
		Assert.assertTrue(mbcp.verifyConfirmationCode());
		allureScreenshot("Dates After");
		screenShot("Dates After");
		mbcp.getDatesAfter();
		Assert.assertTrue(mbcv.verifyDatesModifyTC07());
	}

	@Test(priority = 8)
	@Description("User should be able to do a call center booking through Booking Engine and modify it from call center for Guest Details")
	@Severity(SeverityLevel.CRITICAL)
	@Epic("EP01")
	@Feature("Feature1:Call Center")
	@Story("Call Center")
	@Step("User should be able to do a call center booking through Booking Engine and modify it from call center for Guest Details")
	public void CallCenter_ModifyRT3BookingfromCCsiteandviceversa_TC_08() {
		logger.info("TestCase Started");
		extentTest = extent.startTest("CallCenter_ModifyRT3BookingfromCCsiteandviceversa_TC_08");
		Helper.switchWindow(1);
		Helper.refreshBE();
		jbp.selectDate();
		jbp.clickAvailibilityButton();
		mbcv.selectroomBE(); // standard room
		jbp.clickBookNowButton();
		jbp.inputGuestDetails();
		jbp.selectRatePlanBar();
		jbp.clickconfirmDetails();
		jbp.inputCardDetailsTC01();
		jbp.inputBillingAddress();
		jbp.inputadditionalContactInfo();
		jbp.selectTermsAndConditonCheckbox();
		jbp.clickCompleteReservation();
		Assert.assertTrue(mbcv.verifyConfirmationCodeBE());
		allureScreenshot("Guest Details before");
		screenShot("Guest Details before");
		mbcv.getGuestDetailsbeforeBETC08();
		Helper.switchWindow(0);
		allureScreenshot("Call Center");
		screenShot("Call Center");
		nsrb.clickNewReservation();
		mbcv.LookupCC();
		Assert.assertTrue(mbcv.verifyConfirmationCodeCCLookup());
		Assert.assertEquals(ExcelData.CC_getCellData("NormalSingleRoomBookingData", "CCcodeBE", 2),
				ExcelData.CC_getCellData("NormalSingleRoomBookingData", "CCcodeCallCenterLookup", 2));
		mbcv.modifyLookupCC();
		nsrb.clickpaymentButton();
		mbcp.inputGuestDetailsTC04();
		nsrb.inputCardDetailsTC01();
		nsrb.inputBillingAddress();
		nsrb.selectTermsAndConditonCheckbox();
		nsrb.clickCompleteReservation();
		Assert.assertTrue(mbcp.verifyConfirmationCode());
		allureScreenshot("Guest Details after");
		screenShot("Guest Details after");
		mbcp.getGuestDetailsafter();
		Assert.assertTrue(mbcv.verifyGuestDetailsModifyTC08());
	}

	@Test(priority = 9)
	@Description("User should be able to do a call center booking through Booking Engine with AddOns and modify it to No AddOns from call center ")
	@Severity(SeverityLevel.CRITICAL)
	@Epic("EP01")
	@Feature("Feature1:Call Center")
	@Story("Call Center")
	@Step("User should be able to do a call center booking through Booking Engine with AddOns and modify it to No AddOns from call center ")
	public void CallCenter_ModifyRT3BookingfromCCsiteandviceversa_TC_09() {
		logger.info("TestCase Started");
		extentTest = extent.startTest("CallCenter_ModifyRT3BookingfromCCsiteandviceversa_TC_09");
		Helper.switchWindow(1);
		Helper.refreshBE();
		jbp.selectDate();
		jbp.clickAvailibilityButton();
		mbcv.selectroomBE(); // standard room
		jbp.clickBookNowButton();
		jbp.inputGuestDetails();
		jbp.selectRatePlanBar();
		mbcv.selectAddOn(); // to select addon
		jbp.clickconfirmDetails();
		jbp.inputCardDetailsTC01();
		jbp.inputBillingAddress();
		jbp.inputadditionalContactInfo();
		jbp.selectTermsAndConditonCheckbox();
		jbp.clickCompleteReservation();
		Assert.assertTrue(mbcv.verifyConfirmationCodeBE());
		mbcv.getGrandTotalBeforeBETC09();
		Helper.switchWindow(0);
		allureScreenshot("Call Center");
		screenShot("Call Center");
		nsrb.clickNewReservation();
		mbcv.LookupCC();
		Assert.assertTrue(mbcv.verifyConfirmationCodeCCLookup());
		Assert.assertEquals(ExcelData.CC_getCellData("NormalSingleRoomBookingData", "CCcodeBE", 2),
				ExcelData.CC_getCellData("NormalSingleRoomBookingData", "CCcodeCallCenterLookup", 2));
		mbcv.modifyLookupCC();
		nsrb.clickpaymentButton();
		nsrb.inputGuestDetails();
		nsrb.inputCardDetailsTC01();
		nsrb.inputBillingAddress();
		nsrb.selectTermsAndConditonCheckbox();
		allureScreenshot("grand total after");
		screenShot("grand total after");
		nsrb.clickCompleteReservation();
		Assert.assertTrue(mbcp.verifyConfirmationCode());
		mbcv.getGrandTotalAfterCCTC09();
		Assert.assertTrue(mbcv.verifyOtherServicesModifyTC09());
	}

	@Test(priority = 10)
	@Description("User should be able to do a call center booking through Booking Engine without AddOns and modify it to have AddOns from call center ")
	@Severity(SeverityLevel.CRITICAL)
	@Epic("EP01")
	@Feature("Feature1:Call Center")
	@Story("Call Center")
	@Step("User should be able to do a call center booking through Booking Engine without AddOns and modify it to have AddOns from call center ")
	public void CallCenter_ModifyRT3BookingfromCCsiteandviceversa_TC_10() {
		logger.info("TestCase Started");
		extentTest = extent.startTest("CallCenter_ModifyRT3BookingfromCCsiteandviceversa_TC_10");
		Helper.switchWindow(1);
		Helper.refreshBE();
		jbp.selectDate();
		jbp.clickAvailibilityButton();
		mbcv.selectroomBE(); // standard room
		jbp.clickBookNowButton();
		jbp.inputGuestDetails();
		jbp.selectRatePlanBar();
		jbp.clickconfirmDetails();
		jbp.inputCardDetailsTC01();
		jbp.inputBillingAddress();
		jbp.inputadditionalContactInfo();
		jbp.selectTermsAndConditonCheckbox();
		jbp.clickCompleteReservation();
		Assert.assertTrue(mbcv.verifyConfirmationCodeBE());
		mbcv.getGrandTotalBeforeBETC09();
		Helper.switchWindow(0);
		allureScreenshot("Call Center");
		screenShot("Call Center");
		nsrb.clickNewReservation();
		mbcv.LookupCC();
		Assert.assertTrue(mbcv.verifyConfirmationCodeCCLookup());
		Assert.assertEquals(ExcelData.CC_getCellData("NormalSingleRoomBookingData", "CCcodeBE", 2),
				ExcelData.CC_getCellData("NormalSingleRoomBookingData", "CCcodeCallCenterLookup", 2));
		mbcv.modifyLookupCC();
		nsrb.clickpaymentButton();
		nsrb.inputGuestDetails();
		mbcp.selectAddOn();
		nsrb.inputCardDetailsTC01();
		nsrb.inputBillingAddress();
		nsrb.selectTermsAndConditonCheckbox();
		allureScreenshot("grand total after");
		screenShot("grand total after");
		nsrb.clickCompleteReservation();
		Assert.assertTrue(mbcp.verifyConfirmationCode());
		mbcv.getGrandTotalAfterCCTC09();
		Assert.assertTrue(mbcv.verifyOtherServicesModifyTC09());
	}

	@Test(priority = 11)
	@Description("Verify user is able to do a booking from call center and then modify it using booking engine for rate plan")
	@Severity(SeverityLevel.CRITICAL)
	@Epic("EP01")
	@Feature("Feature1:Call Center")
	@Story("Call Center")
	@Step("Verify user is able to do a booking from call center and then modify it using booking engine for rate plan")
	public void CallCenter_ModifyRT3BookingfromCCsiteandviceversa_TC_11() {
		logger.info("TestCase Started");
		extentTest = extent.startTest("CallCenter_ModifyRT3BookingfromCCsiteandviceversa_TC_02");
		Helper.switchWindow(0);
		allureScreenshot("CC");
		screenShot("CC");
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
		allureScreenshot("rate plan before");
		screenShot("rate plan before");
		mbcv.getRatePlanBeforeCCTC11();
		Helper.switchWindow(1);
		allureScreenshot("BE");
		screenShot("BE");
		Helper.refreshBE();
		mbcv.LookupBE();
		Assert.assertTrue(mbcv.verifyConfirmationCodeBE());
		Assert.assertEquals(ExcelData.CC_getCellData("NormalSingleRoomBookingData", "CCcodeBE", 2),
				ExcelData.CC_getCellData("NormalSingleRoomBookingData", "ConfirmationCode", 2));
		mbcv.modifyReservationBE();
		mbcv.selectDateTC02();
		jbp.clickAvailibilityButton();
		jbp.clickBookNowButton();
		jbp.inputGuestDetails();
		mbcv.selectRatePlanBE();
		jbp.clickconfirmDetails();
		jbp.inputCardDetailsTC01();
		jbp.inputBillingAddress();
		jbp.inputadditionalContactInfo();
		jbp.selectTermsAndConditonCheckbox();
		jbp.clickCompleteReservation();
		mbcv.getRatePlanAfterBETC11();
		Assert.assertTrue(mbcv.verifyRatePlanModifyTC11());
		allureScreenshot("rate plan after");
		screenShot("rate plan after");
		logger.info("TestCase Ended");
	}

}
