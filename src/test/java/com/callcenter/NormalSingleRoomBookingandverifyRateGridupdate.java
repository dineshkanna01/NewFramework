package com.callcenter;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.admin.pom.AdministratorHomePage;
import com.admin.pom.LoginPage;
import com.admin.pom.RatesandInventoryPage;
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
	}

	@Test(priority = 1)
	@Description("Verify the Room availability in rate Grid after Single room booking in Call Center for 1 day")
	@Severity(SeverityLevel.CRITICAL)
	@Epic("EP01")
	@Feature("Feature1:Call Center")
	@Story("Call Center")
	@Step("Verify the Room availability in rate Grid after Single room booking in Call Center for 1 day")
	public void CallCentre_NormalSingleRoomBookingandverifyRateGridupdate_TC_01() {
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
		allureScreenshot("Rate Grid");
		screenShot("Rate Grid");
		nsrb.inputFieldRoomAvailable();
		nsrb.openYieldControls();
		nsrb.clickQuickEntrybutton();
		nsrb.clickUpdateButton();
		nsrb.clickConfirmButton();
		openURL("cc_url");
		nsrb.enterCCuser();
		nsrb.selectDateRangeCCTC01();
		allureScreenshot("Call Center");
		screenShot("Call Center");
		nsrb.clickAvailibilityButton();
		Assert.assertTrue(nsrb.verifyRoomsAvailibilty());
		nsrb.selectRoomModify();
		nsrb.clickpaymentButton();
		nsrb.inputGuestDetails();
		nsrb.inputCardDetailsTC01();
		nsrb.inputBillingAddress();
		nsrb.selectTermsAndConditonCheckbox();
		allureScreenshot("Payment Details");
		screenShot("Payment Details");
		nsrb.clickCompleteReservation();
		Assert.assertTrue(nsrb.verifyConfirmationCode());
		allureScreenshot("Call Center Confirmation Page");
		screenShot("Call Center Confirmation Page");
		Helper.switchWindow(0);
		nsrb.selectRatePlanRateGrid();
		rip.continueButton();
		nsrb.selectDateRangeTC01();
		rip.clickoverrideRoomCheckbox();
		rip.clickdailyRateInvbutton();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Assert.assertTrue(nsrb.verifyRateGridUpdateTC01());
		logger.info("TestCase Ended");
	}

	@Test(priority = 2)
	@Description("Verify the Room availability in rate Grid after Single room booking in Call Center for 7 days")
	@Severity(SeverityLevel.CRITICAL)
	@Epic("EP01")
	@Feature("Feature1:Call Center")
	@Story("Call Center")
	@Step("Verify the Room availability in rate Grid after Single room booking in Call Center for 7 days")
	public void CallCentre_NormalSingleRoomBookingandverifyRateGridupdate_TC_02() {
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
		nsrb.inputFieldRoomAvailable();
		nsrb.openYieldControls();
		nsrb.clickQuickEntrybutton();
		nsrb.clickUpdateButton();
		nsrb.clickConfirmButton();
		Helper.switchWindow(1);
		nsrb.clickNewReservation();
		allureScreenshot("New Reservation");
		screenShot("New Reservation");
		nsrb.selectDateRangeCCTC02();
		nsrb.clickAvailibilityButton();
		Assert.assertTrue(nsrb.verifyRoomsAvailibilty());
		nsrb.selectRoomModify();
		nsrb.clickpaymentButton();
		nsrb.inputGuestDetails();
		nsrb.inputCardDetailsTC01();
		nsrb.inputBillingAddress();
		nsrb.selectTermsAndConditonCheckbox();
		nsrb.clickCompleteReservation();
		allureScreenshot("Confirmation Page");
		screenShot("Confirmation Page");
		Assert.assertTrue(nsrb.verifyConfirmationCode());
		Helper.switchWindow(0);
		nsrb.selectRatePlanRateGrid();
		rip.continueButton();
		nsrb.selectDateRangeTC02();
		rip.clickoverrideRoomCheckbox();
		rip.clickdailyRateInvbutton();
		Assert.assertTrue(nsrb.verifyRateGridUpdateTC02());
		lp.logout();
		logger.info("TestCase Ended");
	}
}