package com.callcenter;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.admin.pom.AdministratorHomePage;
import com.admin.pom.LoginPage;
import com.admin.pom.ReportsPage;
import com.cc.pom.BookingwithIATAcodePage;
import com.cc.pom.CancelBookingfromconfirmationpagePage;
import com.cc.pom.DenialReasonineverypageofbookingPage;
import com.cc.pom.ModifyBookingfromconfirmationpagePage;
import com.cc.pom.ModifybookingusingLookupPage;
import com.cc.pom.NormalSingleRoomBookingandverifyRateGridupdatePage;

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
 * Test class for BookingwithIATAcode
 * @author Rudraksh Aggarwal
 */
public class BookingwithIATAcode extends TestBase {

	public static Utilitylog logger;

	// objects
	LoginPage lp;
	AdministratorHomePage ahp;
	NormalSingleRoomBookingandverifyRateGridupdatePage nsrb;
	ReportsPage rep;
	ModifyBookingfromconfirmationpagePage mbcp;
	DenialReasonineverypageofbookingPage drep;
	BookingwithIATAcodePage bwic;
	ModifybookingusingLookupPage mblp;
	CancelBookingfromconfirmationpagePage cbcp;

	public BookingwithIATAcode() {
		super();
		logger = new Utilitylog(BookingwithIATAcode.class.getName());
	}

	@BeforeMethod
	public void setup() {
		lp = new LoginPage(getDriver());
		ahp = new AdministratorHomePage(getDriver());
		nsrb = new NormalSingleRoomBookingandverifyRateGridupdatePage(getDriver());
		rep = new ReportsPage(getDriver());
		mbcp = new ModifyBookingfromconfirmationpagePage(getDriver());
		drep = new DenialReasonineverypageofbookingPage(getDriver());
		bwic = new BookingwithIATAcodePage(getDriver());
		mblp = new ModifybookingusingLookupPage(getDriver());
		cbcp = new CancelBookingfromconfirmationpagePage(getDriver());
	}

	@Test(priority = 1)
	@Description("Verify user is able to do the configuration for IATA code booking")
	@Severity(SeverityLevel.CRITICAL)
	@Epic("EP01")
	@Feature("Feature1:Call Center")
	@Story("Call Center")
	@Step("Verify user is able to do the configuration for IATA code booking")
	public void CallCenter_DenialReasonineverypageofbooking_TC_01() {
		logger.info("TestCase Started");
		extentTest = extent.startTest("CallCenter_DenialReasonineverypageofbooking_TC_01");
		lp.login();
		allureScreenshot("Login");
		screenShot("Login");
		ahp.selectBrand();
		ahp.selectProperty2();
		allureScreenshot("Property Selected");
		screenShot("Property Selected");
		drep.titleBefore();
		ahp.clickPropertyManagementTab();
		ahp.selectpropertyDefault();
		allureScreenshot("Property defaults");
		screenShot("Property defaults");
		ahp.yesRadioButtonIATA();
		allureScreenshot("IATA Button");
		screenShot("IATA Button");
		ahp.clickSaveButton();
		drep.titleAfter();
		Assert.assertTrue(drep.verifyTitle());
		logger.info("TestCase Ended");
	}

	@Test(priority = 2)
	@Description("Verify user is able to do the reservation with IATA code")
	@Severity(SeverityLevel.CRITICAL)
	@Epic("EP01")
	@Feature("Feature1:Call Center")
	@Story("Call Center")
	@Step("Verify user is able to booking the reservation with IATA code")
	public void CallCenter_DenialReasonineverypageofbooking_TC_02() {
		logger.info("TestCase Started");
		extentTest = extent.startTest("CallCenter_DenialReasonineverypageofbooking_TC_02");
		openURL("cc_url");
		nsrb.enterCCuser();
		allureScreenshot("Call Center");
		screenShot("Call Center");
		drep.titleBefore();
		nsrb.selectDateRangeCCTC01();
		bwic.inputIATACODE();
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
		logger.info("TestCase Ended");
	}

	@Test(priority = 3)
	@Description("User should verify the reservation with confirmation code")
	@Severity(SeverityLevel.CRITICAL)
	@Epic("EP01")
	@Feature("Feature1:Call Center")
	@Story("Call Center")
	@Step("User should verify the reservation with confirmation code")
	public void CallCenter_DenialReasonineverypageofbooking_TC_03() {
		logger.info("TestCase Started");
		extentTest = extent.startTest("CallCenter_DenialReasonineverypageofbooking_TC_03");
		mblp.clickNewReservation();
		bwic.bookinglookupIATATC01();
		Assert.assertTrue(bwic.getCCcodeIATA());
		allureScreenshot("cc code");
		screenShot("cc code");
		Assert.assertTrue(bwic.verifyCCcodeIATA());
		logger.info("TestCase Ended");
	}

	@Test(priority = 4)
	@Description("Verify user is able to Modify  the reservation with IATA code")
	@Severity(SeverityLevel.CRITICAL)
	@Epic("EP01")
	@Feature("Feature1:Call Center")
	@Story("Call Center")
	@Step("Verify user is able to Modify  the reservation with IATA code")
	public void CallCenter_DenialReasonineverypageofbooking_TC_04() {
		logger.info("TestCase Started");
		extentTest = extent.startTest("CallCenter_DenialReasonineverypageofbooking_TC_04");
		mblp.clickNewReservation();
		nsrb.selectDateRangeCCTC01();
		bwic.inputIATACODE();
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
		mbcp.modify();
		mbcp.clickEditSearchButton();
		bwic.inputIATACODE();
		nsrb.clickAvailibilityButton();
		nsrb.selectRoomModify();
		allureScreenshot("Room After");
		screenShot("Room After");
		nsrb.clickpaymentButton();
		nsrb.inputGuestDetails();
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
	@Description("Verify user is able to Cancel  the reservation with IATA code")
	@Severity(SeverityLevel.CRITICAL)
	@Epic("EP01")
	@Feature("Feature1:Call Center")
	@Story("Call Center")
	@Step("Verify user is able to Cancel  the reservation with IATA code")
	public void CallCenter_DenialReasonineverypageofbooking_TC_05() {
		logger.info("TestCase Started");
		extentTest = extent.startTest("CallCenter_DenialReasonineverypageofbooking_TC_05");
		mblp.clickNewReservation();
		nsrb.selectDateRangeCCTC01();
		bwic.inputIATACODE();
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
		allureScreenshot("Call Center booking confirmation code");
		screenShot("Call Center booking confirmation code");
		Assert.assertTrue(bwic.CancelBooking());
		allureScreenshot("Call Center booking Cancellation confirmation");
		screenShot("Call Center booking Cancellation confirmation");
		Helper.switchWindow(0);
		lp.logout();
		logger.info("TestCase Ended");
	}
}
