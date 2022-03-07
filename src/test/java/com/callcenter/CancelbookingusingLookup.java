package com.callcenter;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.admin.pom.AdministratorHomePage;
import com.admin.pom.LoginPage;
import com.admin.pom.ReportsPage;
import com.cc.pom.CancelBookingfromconfirmationpagePage;
import com.cc.pom.CancelbookingusingLookupPage;
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
 * Test class for CancelbookingusingLookup
 * @author Rudraksh Aggarwal
 */
public class CancelbookingusingLookup extends TestBase {
	public static Utilitylog logger;

	// objects
	LoginPage lp;
	AdministratorHomePage ahp;
	NormalSingleRoomBookingandverifyRateGridupdatePage nsrb;
	ModifyBookingfromconfirmationpagePage mbcp;
	ModifybookingusingLookupPage mblp;
	CancelbookingusingLookupPage cblp;
	CancelBookingfromconfirmationpagePage cbcp;
	ReportsPage rep;
	SoftAssert soft;

	public CancelbookingusingLookup() {
		super();
		logger = new Utilitylog(CancelbookingusingLookup.class.getName());
	}

	@BeforeMethod
	public void setup() {
		lp = new LoginPage(getDriver());
		ahp = new AdministratorHomePage(getDriver());
		nsrb = new NormalSingleRoomBookingandverifyRateGridupdatePage(getDriver());
		mbcp = new ModifyBookingfromconfirmationpagePage(getDriver());
		mblp = new ModifybookingusingLookupPage(getDriver());
		cblp = new CancelbookingusingLookupPage(getDriver());
		cbcp = new CancelBookingfromconfirmationpagePage(getDriver());
		rep = new ReportsPage(getDriver());
		soft = new SoftAssert();
	}

	@Test(priority = 1)
	@Description("Verify user is able to Cancel the booking using Confirmation code and email in lookup in call Center")
	@Severity(SeverityLevel.CRITICAL)
	@Epic("EP01")
	@Feature("Feature1:Call Center")
	@Story("Call Center")
	@Step("Verify user is able to Cancel the booking using Confirmation code and email in lookup in call Center")
	public void CallCenter_CancelbookingusingLookup_TC_01() {
		logger.info("TestCase Started");
		extentTest = extent.startTest("CallCenter_CancelbookingusingLookup_TC_01");
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
		soft.assertTrue(mbcp.verifyConfirmationCode());
		mblp.clickNewReservation();
		cblp.cancelBookingLookupTC01();
		soft.assertTrue(cblp.verifyCancelBookinglookup());
		allureScreenshot("Call Center booking Cancellation confirmation from lookup");
		screenShot("Call Center booking Cancellation confirmation from lookup");
		Helper.switchWindow(0);
		ahp.selectReports();
		rep.selectSearchReservationReport();
		soft.assertTrue(cblp.verifyCancelBookingTC01reports());
		allureScreenshot("Call Center booking Cancellation confirmation from reports");
		screenShot("Call Center booking Cancellation confirmation from reports");
		Helper.switchWindow(1);
		logger.info("TestCase Ended");
	}

	@Test(priority = 2)
	@Description("Verify user is able to Cancel the booking using Last name and email in lookup in call Center")
	@Severity(SeverityLevel.CRITICAL)
	@Epic("EP01")
	@Feature("Feature1:Call Center")
	@Story("Call Center")
	@Step("Verify user is able to Cancel the booking using Last name and email in lookup in call Center")
	public void CallCenter_CancelbookingusingLookup_TC_02() {
		logger.info("TestCase Started");
		extentTest = extent.startTest("CallCenter_CancelbookingusingLookup_TC_02");
		Helper.refresh();
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
		soft.assertTrue(mbcp.verifyConfirmationCode());
		mblp.getGuestDetailsLName();
		mblp.clickNewReservation();
		cblp.cancelBookingLookupTC02();
		soft.assertTrue(cblp.verifyCancelBookinglookup());
		allureScreenshot("Call Center booking Cancellation confirmation from lookup");
		screenShot("Call Center booking Cancellation confirmation from lookup");
		logger.info("TestCase Ended");
		logger.info("TestCase Ended");
	}

	@Test(priority = 3)
	@Description("Verify user is able to Cancel the booking using Arrival Date and email in lookup in call Center")
	@Severity(SeverityLevel.CRITICAL)
	@Epic("EP01")
	@Feature("Feature1:Call Center")
	@Story("Call Center")
	@Step("Verify user is able to Cancel the booking using Arrival Date and email in lookup in call Center")
	public void CallCenter_CancelbookingusingLookup_TC_03() {
		logger.info("TestCase Started");
		extentTest = extent.startTest("CallCenter_CancelbookingusingLookup_TC_03");
		Helper.refresh();
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
		soft.assertTrue(mbcp.verifyConfirmationCode());
		mblp.clickNewReservation();
		cblp.cancelBookingLookupTC03();
		soft.assertTrue(cblp.verifyCancelBookinglookup());
		allureScreenshot("Call Center booking Cancellation confirmation from lookup");
		screenShot("Call Center booking Cancellation confirmation from lookup");
		logger.info("TestCase Ended");
	}

	@Test(priority = 4)
	@Description("Verify user is able to Cancel the booking using Last 4 digits of credit card and email in lookup in call Center")
	@Severity(SeverityLevel.CRITICAL)
	@Epic("EP01")
	@Feature("Feature1:Call Center")
	@Story("Call Center")
	@Step("Verify user is able to Cancel the booking using Last 4 digits of credit card and email in lookup in call Center")
	public void CallCenter_CancelbookingusingLookup_TC_04() {
		logger.info("TestCase Started");
		extentTest = extent.startTest("CallCenter_CancelbookingusingLookup_TC_04");
		Helper.refresh();
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
		soft.assertTrue(mbcp.verifyConfirmationCode());
		mblp.clickNewReservation();
		cblp.cancelBookingLookupTC04();
		soft.assertTrue(cblp.verifyCancelBookinglookup());
		allureScreenshot("Call Center booking Cancellation confirmation from lookup");
		screenShot("Call Center booking Cancellation confirmation from lookup");
		logger.info("TestCase Ended");
	}

	@Test(priority = 5)
	@Description("Verify user is not able to Cancel the booking using incorrect Last 4 digits of credit card and email in lookup in call Center")
	@Severity(SeverityLevel.CRITICAL)
	@Epic("EP01")
	@Feature("Feature1:Call Center")
	@Story("Call Center")
	@Step("Verify user is not able to Cancel the booking using incorrect Last 4 digits of credit card and email in lookup in call Center")
	public void CallCenter_CancelbookingusingLookup_TC_05() {
		logger.info("TestCase Started");
		extentTest = extent.startTest("CallCenter_CancelbookingusingLookup_TC_05");
		Helper.refresh();
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
		soft.assertTrue(mbcp.verifyConfirmationCode());
		mblp.clickNewReservation();
		soft.assertTrue(cblp.cancelBookingLookupTC05());
		allureScreenshot("Call Center booking not cancelled");
		screenShot("Call Center booking not cancelled");
		Helper.switchWindow(0);
		lp.logout();
		logger.info("TestCase Ended");
	}

}
