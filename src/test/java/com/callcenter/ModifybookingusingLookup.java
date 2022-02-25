package com.callcenter;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.admin.pom.AdministratorHomePage;
import com.admin.pom.LoginPage;
import com.admin.pom.ReportsPage;
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
 * Test class for ModifybookingusingLookup
 * @author Rudraksh Aggarwal
 */
public class ModifybookingusingLookup extends TestBase {
	public static Utilitylog logger;

	// objects
	LoginPage lp;
	AdministratorHomePage ahp;
	NormalSingleRoomBookingandverifyRateGridupdatePage nsrb;
	ModifyBookingfromconfirmationpagePage mbcp;
	ModifybookingusingLookupPage mblp;
	ReportsPage rep;

	public ModifybookingusingLookup() {
		super();
		logger = new Utilitylog(ModifybookingusingLookup.class.getName());
	}

	@BeforeMethod
	public void setup() {
		lp = new LoginPage(getDriver());
		ahp = new AdministratorHomePage(getDriver());
		nsrb = new NormalSingleRoomBookingandverifyRateGridupdatePage(getDriver());
		mbcp = new ModifyBookingfromconfirmationpagePage(getDriver());
		mblp = new ModifybookingusingLookupPage(getDriver());
		rep = new ReportsPage(getDriver());
	}

	@Test(priority = 1)
	@Description("Verify user is able to Modify guest details for the booking using email and confirmation code in lookup in call Center")
	@Severity(SeverityLevel.CRITICAL)
	@Epic("EP01")
	@Feature("Feature1:Call Center")
	@Story("Call Center")
	@Step("Verify user is able to Modify guest details for the booking using email and confirmation code in lookup in call Center")
	public void CancelbookingusingLookup_TC_01() {
		logger.info("TestCase Started");
		extentTest = extent.startTest("CancelbookingusingLookup_TC_01");
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
		allureScreenshot("GuestDetails before");
		screenShot("GuestDetails before");
		Helper.switchWindow(0);
		ahp.selectReports();
		rep.selectSearchReservationReport();
		Assert.assertTrue(mbcp.searchReservation());
		allureScreenshot("Booking in Report");
		screenShot("Booking in Report");
		Helper.switchWindow(1);
		mblp.clickNewReservation();
		mblp.ModifyBookingLookupTC01();
		nsrb.clickpaymentButton();
		mblp.inputGuestDetailsTC01();
		nsrb.inputCardDetailsTC01();
		nsrb.inputBillingAddress();
		nsrb.selectTermsAndConditonCheckbox();
		nsrb.clickCompleteReservation();
		mbcp.getGuestDetailsafter();
		allureScreenshot("GuestDetails after");
		screenShot("GuestDetails after");
		Assert.assertTrue(mbcp.verifyGuestDetailsModify());
		logger.info("TestCase Ended");
	}

	@Test(priority = 2)
	@Description("Verify user is able to Modify guest details for the booking using Last name and email in lookup in call Center")
	@Severity(SeverityLevel.CRITICAL)
	@Epic("EP01")
	@Feature("Feature1:Call Center")
	@Story("Call Center")
	@Step("Verify user is able to Modify guest details for the booking using Last name and email in lookup in call Center")
	public void CancelbookingusingLookup_TC_02() {
		logger.info("TestCase Started");
		extentTest = extent.startTest("CancelbookingusingLookup_TC_02");
		mbcp.getGuestDetailsbefore();
		allureScreenshot("GuestDetails before");
		screenShot("GuestDetails before");
		mblp.getGuestDetailsLName();
		mblp.clickNewReservation();
		mblp.ModifyBookingLookupTC02();
		nsrb.clickpaymentButton();
		mblp.inputGuestDetailsTC02();
		nsrb.inputCardDetailsTC01();
		nsrb.inputBillingAddress();
		nsrb.selectTermsAndConditonCheckbox();
		nsrb.clickCompleteReservation();
		mbcp.getGuestDetailsafter();
		allureScreenshot("GuestDetails after");
		screenShot("GuestDetails after");
		Assert.assertTrue(mbcp.verifyGuestDetailsModify());
		logger.info("TestCase Ended");
	}

	@Test(priority = 3)
	@Description("Verify user is able to Modify guest details for the booking using Arrival Date and email in lookup in call Center")
	@Severity(SeverityLevel.CRITICAL)
	@Epic("EP01")
	@Feature("Feature1:Call Center")
	@Story("Call Center")
	@Step("Verify user is able to Modify guest details for the booking using Arrival Date and email in lookup in call Center")
	public void CancelbookingusingLookup_TC_03() {
		logger.info("TestCase Started");
		extentTest = extent.startTest("CancelbookingusingLookup_TC_03");
		mbcp.getGuestDetailsbefore();
		allureScreenshot("GuestDetails before");
		screenShot("GuestDetails before");
		mblp.clickNewReservation();
		mblp.ModifyBookingLookupTC03();
		nsrb.clickpaymentButton();
		mblp.inputGuestDetailsTC03();
		nsrb.inputCardDetailsTC01();
		nsrb.inputBillingAddress();
		nsrb.selectTermsAndConditonCheckbox();
		nsrb.clickCompleteReservation();
		mbcp.getGuestDetailsafter();
		allureScreenshot("GuestDetails after");
		screenShot("GuestDetails after");
		Assert.assertTrue(mbcp.verifyGuestDetailsModify());
		logger.info("TestCase Ended");
	}

	@Test(priority = 4)
	@Description("Verify user is able to Modify guest details for the booking using email and last 4 digit of credit card in lookup in call Center")
	@Severity(SeverityLevel.CRITICAL)
	@Epic("EP01")
	@Feature("Feature1:Call Center")
	@Story("Call Center")
	@Step("Verify user is able to Modify guest details for the booking using Arrival Date and email in lookup in call Center")
	public void CancelbookingusingLookup_TC_04() {
		logger.info("TestCase Started");
		extentTest = extent.startTest("CancelbookingusingLookup_TC_04");
		mbcp.getGuestDetailsbefore();
		allureScreenshot("GuestDetails before");
		screenShot("GuestDetails before");
		mblp.clickNewReservation();
		mblp.ModifyBookingLookupTC04();
		nsrb.clickpaymentButton();
		mblp.inputGuestDetailsTC04();
		nsrb.inputCardDetailsTC01();
		nsrb.inputBillingAddress();
		nsrb.selectTermsAndConditonCheckbox();
		nsrb.clickCompleteReservation();
		mbcp.getGuestDetailsafter();
		allureScreenshot("GuestDetails after");
		screenShot("GuestDetails after");
		Assert.assertTrue(mbcp.verifyGuestDetailsModify());
		logger.info("TestCase Ended");
	}

	@Test(priority = 5)
	@Description("Verify user is able to Modify room details for the booking using Confirmation code and email in lookup in call Center")
	@Severity(SeverityLevel.CRITICAL)
	@Epic("EP01")
	@Feature("Feature1:Call Center")
	@Story("Call Center")
	@Step("Verify user is able to Modify room details for the booking using Confirmation code and email in lookup in call Center")
	public void CancelbookingusingLookup_TC_05() {
		logger.info("TestCase Started");
		extentTest = extent.startTest("CancelbookingusingLookup_TC_04");
		mbcp.verifyRoomTypebefore();
		allureScreenshot("RoomType before");
		screenShot("RoomType before");
		mblp.clickNewReservation();
		mblp.ModifyBookingLookupTC01();
		nsrb.selectRoomTC08mbcp();
		nsrb.clickpaymentButton();
		mblp.inputGuestDetailsTC04();
		nsrb.inputCardDetailsTC01();
		nsrb.inputBillingAddress();
		nsrb.selectTermsAndConditonCheckbox();
		nsrb.clickCompleteReservation();
		mbcp.verifyRoomTypeafter();
		allureScreenshot("RoomType after");
		screenShot("RoomType after");
		Assert.assertTrue(mbcp.verifyRoomModify());
		logger.info("TestCase Ended");
	}

	@Test(priority = 6)
	@Description("Verify user is able to Room for the booking using Last name and email in lookup in call Center")
	@Severity(SeverityLevel.CRITICAL)
	@Epic("EP01")
	@Feature("Feature1:Call Center")
	@Story("Call Center")
	@Step("Verify user is able to Modify Room for the booking using Last name and email in lookup in call Center")
	public void CancelbookingusingLookup_TC_06() {
		logger.info("TestCase Started");
		extentTest = extent.startTest("CancelbookingusingLookup_TC_06");
		mbcp.verifyRoomTypebefore();
		allureScreenshot("RoomType before");
		screenShot("RoomType before");
		screenShot("GuestDetails before");
		mblp.getGuestDetailsLName();
		mblp.clickNewReservation();
		mblp.ModifyBookingLookupTC02();
		mblp.selectRoomTC06mblp();
		nsrb.clickpaymentButton();
		mblp.inputGuestDetailsTC04();
		nsrb.inputCardDetailsTC01();
		nsrb.inputBillingAddress();
		nsrb.selectTermsAndConditonCheckbox();
		nsrb.clickCompleteReservation();
		mbcp.verifyRoomTypeafter();
		allureScreenshot("RoomType after");
		screenShot("RoomType after");
		Assert.assertTrue(mbcp.verifyRoomModify());
		logger.info("TestCase Ended");
	}

	@Test(priority = 7)
	@Description("Verify user is able to Modify room details for the booking using Last 4 digits of credit card and email in lookup in call Center")
	@Severity(SeverityLevel.CRITICAL)
	@Epic("EP01")
	@Feature("Feature1:Call Center")
	@Story("Call Center")
	@Step("Verify user is able to Modify room details for the booking using Last 4 digits of credit card and email in lookup in call Center")
	public void CancelbookingusingLookup_TC_07() {
		logger.info("TestCase Started");
		extentTest = extent.startTest("CancelbookingusingLookup_TC_07");
		mbcp.verifyRoomTypebefore();
		allureScreenshot("RoomType before");
		screenShot("RoomType before");
		screenShot("GuestDetails before");
		mblp.clickNewReservation();
		mblp.ModifyBookingLookupTC04();
		nsrb.selectRoomTC08mbcp();
		nsrb.clickpaymentButton();
		mblp.inputGuestDetailsTC04();
		nsrb.inputCardDetailsTC01();
		nsrb.inputBillingAddress();
		nsrb.selectTermsAndConditonCheckbox();
		nsrb.clickCompleteReservation();
		mbcp.verifyRoomTypeafter();
		allureScreenshot("RoomType after");
		screenShot("RoomType after");
		Assert.assertTrue(mbcp.verifyRoomModify());
		logger.info("TestCase Ended");
	}

	@Test(priority = 8)
	@Description("Verify user is able to Modify room details for the booking using Last 4 digits of credit card and last name in lookup in call Center")
	@Severity(SeverityLevel.CRITICAL)
	@Epic("EP01")
	@Feature("Feature1:Call Center")
	@Story("Call Center")
	@Step("Verify user is able to Modify room details for the booking using Last 4 digits of credit card and last name in lookup in call Center")
	public void CancelbookingusingLookup_TC_08() {
		logger.info("TestCase Started");
		extentTest = extent.startTest("CancelbookingusingLookup_TC_08");
		mbcp.verifyRoomTypebefore();
		allureScreenshot("RoomType before");
		screenShot("RoomType before");
		screenShot("GuestDetails before");
		mblp.getGuestDetailsLName();
		mblp.clickNewReservation();
		mblp.ModifyBookingLookupTC08();
		mblp.selectRoomTC06mblp();
		nsrb.clickpaymentButton();
		mblp.inputGuestDetailsTC04();
		nsrb.inputCardDetailsTC01();
		nsrb.inputBillingAddress();
		nsrb.selectTermsAndConditonCheckbox();
		nsrb.clickCompleteReservation();
		mbcp.verifyRoomTypeafter();
		allureScreenshot("RoomType after");
		screenShot("RoomType after");
		Assert.assertTrue(mbcp.verifyRoomModify());
		logger.info("TestCase Ended");
	}

	@Test(priority = 9)
	@Description("Verify user is not able to Modify room details for the booking using incorrect Last 4 digits of credit card and email in lookup in call Center")
	@Severity(SeverityLevel.CRITICAL)
	@Epic("EP01")
	@Feature("Feature1:Call Center")
	@Story("Call Center")
	@Step("Verify user is not able to Modify room details for the booking using incorrect Last 4 digits of credit card and email in lookup in call Center")
	public void CancelbookingusingLookup_TC_09() {
		logger.info("TestCase Started");
		extentTest = extent.startTest("CancelbookingusingLookup_TC_08");
		mbcp.verifyRoomTypebefore();
		allureScreenshot("RoomType before");
		screenShot("RoomType before");
		screenShot("GuestDetails before");
		mblp.clickNewReservation();
		Assert.assertTrue(mblp.verifyBookingTC09());
		screenShot("error message");
		screenShot("error message");
		Helper.switchWindow(0);
		lp.logout();
		logger.info("TestCase Ended");
	}

}
