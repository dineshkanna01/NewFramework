package com.callcenter;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.admin.pom.AdministratorHomePage;
import com.admin.pom.LoginPage;
import com.admin.pom.ReportsPage;
import com.cc.pom.DenialReasonineverypageofbookingPage;
import com.cc.pom.ModifyBookingfromconfirmationpagePage;
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
 * Test class for DenialReasonineverypageofbooking
 * @author Rudraksh Aggarwal
 */
public class DenialReasonineverypageofbooking extends TestBase {
	public static Utilitylog logger;

	// objects
	LoginPage lp;
	AdministratorHomePage ahp;
	NormalSingleRoomBookingandverifyRateGridupdatePage nsrb;
	ReportsPage rep;
	ModifyBookingfromconfirmationpagePage mbcp;
	DenialReasonineverypageofbookingPage drep;

	public DenialReasonineverypageofbooking() {
		super();
		logger = new Utilitylog(DenialReasonineverypageofbooking.class.getName());
	}
	
	@BeforeMethod
	public void setup() {
		lp = new LoginPage(getDriver());
		ahp = new AdministratorHomePage(getDriver());
		nsrb = new NormalSingleRoomBookingandverifyRateGridupdatePage(getDriver());
		rep = new ReportsPage(getDriver());
		mbcp = new ModifyBookingfromconfirmationpagePage(getDriver());
		drep= new DenialReasonineverypageofbookingPage(getDriver());
	}

	@Test(priority = 1)
	@Description("Verify user should able to provide denial reason when modifying the reservation in the booking engine")
	@Severity(SeverityLevel.CRITICAL)
	@Epic("EP01")
	@Feature("Feature1:Call Center")
	@Story("Call Center")
	@Step("Verify user should able to provide denial reason when modifying the reservation in the booking engine")
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
		openURL("cc_url");
		nsrb.enterCCuser();
		allureScreenshot("Call Center");
		screenShot("Call Center");
		drep.titleBefore();
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
		Helper.switchWindow(0);
		ahp.selectReports();
		rep.selectSearchReservationReport();
		Assert.assertTrue(mbcp.searchReservation());
		allureScreenshot("Booking in Report");
		screenShot("Booking in Report");
		Helper.switchWindow(1);
		mbcp.modify();
		Assert.assertTrue(drep.verifyDenialReasonVisible());
		drep.clickDenialReasonField();
		drep.inputDenialReason();
		allureScreenshot("DenialReason");
		screenShot("DenialReason");
		drep.titleAfter();
		Assert.assertTrue(drep.verifyTitle());
		logger.info("TestCase Ended");
	}
	
	@Test(priority = 2)
	@Description("Verify user should able to see denial reason on first page of booking engine")
	@Severity(SeverityLevel.CRITICAL)
	@Epic("EP01")
	@Feature("Feature1:Call Center")
	@Story("Call Center")
	@Step("Verify user should able to see denial reason on first page of booking engine")
	public void CallCenter_DenialReasonineverypageofbooking_TC_02() {
		logger.info("TestCase Started");
		extentTest = extent.startTest("CallCenter_DenialReasonineverypageofbooking_TC_02");
		nsrb.selectDateRangeCCTC01();
		nsrb.clickAvailibilityButton();
		Assert.assertTrue(drep.verifyDenialReasonVisible());
		allureScreenshot("DenialReason");
		screenShot("DenialReason");
		logger.info("TestCase Ended");
	}
	
	@Test(priority = 3)
	@Description("Verify user should able to provide denial reason on first page of booking engine")
	@Severity(SeverityLevel.CRITICAL)
	@Epic("EP01")
	@Feature("Feature1:Call Center")
	@Story("Call Center")
	@Step("Verify user should able to provide denial reason on first page of booking engine")
	public void CallCenter_DenialReasonineverypageofbooking_TC_03() {
		logger.info("TestCase Started");
		extentTest = extent.startTest("CallCenter_DenialReasonineverypageofbooking_TC_03");
		drep.clickDenialReasonField();
		drep.inputDenialReason();
		allureScreenshot("DenialReason");
		screenShot("DenialReason");
		drep.titleAfter();
		Assert.assertTrue(drep.verifyTitle());
		logger.info("TestCase Ended");
	}
	
	@Test(priority = 4)
	@Description("Verify user should able to provide denial reason on payment page of booking engine")
	@Severity(SeverityLevel.CRITICAL)
	@Epic("EP01")
	@Feature("Feature1:Call Center")
	@Story("Call Center")
	@Step("Verify user should able to provide denial reason on payment page of booking engine")
	public void CallCenter_DenialReasonineverypageofbooking_TC_04() {
		logger.info("TestCase Started");
		extentTest = extent.startTest("CallCenter_DenialReasonineverypageofbooking_TC_04");
		drep.titleBefore();
		nsrb.selectDateRangeCCTC01();
		nsrb.clickAvailibilityButton();
		nsrb.selectRoom();
		nsrb.clickpaymentButton();
		allureScreenshot("Call Center payment details page");
		screenShot("Call Center payment page");
		drep.clickstartOver();
		Assert.assertTrue(drep.verifyDenialReasonPopupHeading());
		drep.inputDenialReason();
		allureScreenshot("DenialReason");
		screenShot("DenialReason");
		drep.titleAfter();
		Assert.assertTrue(drep.verifyTitle());
		Helper.switchWindow(0);
		lp.logout();
		logger.info("TestCase Ended");
	}
}
