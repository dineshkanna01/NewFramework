package com.callcenter;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.admin.pom.AdministratorHomePage;
import com.admin.pom.LoginPage;
import com.admin.pom.ReportsPage;
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
 * Test class for ModifyBookingfromconfirmationpageTest
 * @author Rudraksh Aggarwal
 */
public class ModifyBookingfromconfirmationpageTest extends TestBase {
	public static Utilitylog logger;

	// objects
	LoginPage lp;
	AdministratorHomePage ahp;
	NormalSingleRoomBookingandverifyRateGridupdatePage nsrb;
	ReportsPage rep;
	ModifyBookingfromconfirmationpagePage mbcp;

	public ModifyBookingfromconfirmationpageTest() {
		super();
		logger = new Utilitylog(ModifyBookingfromconfirmationpageTest.class.getName());
	}

	@BeforeMethod
	public void setup() {
		lp = new LoginPage(getDriver());
		ahp = new AdministratorHomePage(getDriver());
		nsrb = new NormalSingleRoomBookingandverifyRateGridupdatePage(getDriver());
		rep = new ReportsPage(getDriver());
		mbcp = new ModifyBookingfromconfirmationpagePage(getDriver());
	}

	@Test(priority = 1)
	@Description("User should be able to modify a call center booking from confirmation page for room type through edit search")
	@Severity(SeverityLevel.CRITICAL)
	@Epic("EP01")
	@Feature("Feature1:Call Center")
	@Story("Call Center")
	@Step("User should be able to modify a call center booking from confirmation page for room type through edit search")
	public void ModifyBookingfromconfirmationpageTest_TC01() {
		logger.info("TestCase Started");
		extentTest = extent.startTest("ModifyBookingfromconfirmationpageTest_TC01");
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
		mbcp.selectKingBedType();
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
		Helper.switchWindow(1);
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

	@Test(priority = 2)
	@Description("User should be able to modify a call center booking from confirmation page for stay dates through edit search")
	@Severity(SeverityLevel.CRITICAL)
	@Epic("EP01")
	@Feature("Feature1:Call Center")
	@Story("Call Center")
	@Step("User should be able to modify a call center booking from confirmation page for stay dates through edit search")
	public void ModifyBookingfromconfirmationpageTest_TC02() {
		logger.info("TestCase Started");
		extentTest = extent.startTest("ModifyBookingfromconfirmationpageTest_TC02");
		mbcp.getDatesBefore();
		allureScreenshot("Dates Before");
		screenShot("Dates Before");
		mbcp.modify();
		mbcp.clickEditSearchButton();
		mbcp.selectDateRangeCCTC02();
		nsrb.clickAvailibilityButton();
		nsrb.selectRoom();
		nsrb.clickpaymentButton();
		nsrb.inputGuestDetails();
		nsrb.inputCardDetailsTC01();
		nsrb.inputBillingAddress();
		nsrb.selectTermsAndConditonCheckbox();
		nsrb.clickCompleteReservation();
		mbcp.getDatesAfter();
		allureScreenshot("Dates After");
		screenShot("Dates After");
		Assert.assertTrue(mbcp.verifyDatesModify());
		logger.info("TestCase Ended");
	}

	@Test(priority = 3)
	@Description("User should be able to modify a call center booking from confirmation page for stay dates through edit search")
	@Severity(SeverityLevel.CRITICAL)
	@Epic("EP01")
	@Feature("Feature1:Call Center")
	@Story("Call Center")
	@Step("User should be able to modify a call center booking from confirmation page for stay dates through edit search")
	public void ModifyBookingfromconfirmationpageTest_TC03() {
		logger.info("TestCase Started");
		extentTest = extent.startTest("ModifyBookingfromconfirmationpageTest_TC03");
		mbcp.getNumOfAdultsAndChildrenbefore();
		allureScreenshot("Num Of Adults And Children before");
		screenShot("Num Of Adults And Children before");
		mbcp.modify();
		mbcp.clickEditSearchButton();
		mbcp.modifyNumOfAdultsAndChildren();
		nsrb.clickAvailibilityButton();
		nsrb.selectRoom();
		nsrb.clickpaymentButton();
		nsrb.inputGuestDetails();
		nsrb.inputCardDetailsTC01();
		nsrb.inputBillingAddress();
		nsrb.selectTermsAndConditonCheckbox();
		nsrb.clickCompleteReservation();
		mbcp.getNumOfAdultsAndChildrenafter();
		allureScreenshot("Num Of Adults And Children after");
		screenShot("Num Of Adults And Children after");
		Assert.assertTrue(mbcp.verifyAdultsandChildrenModify());
		logger.info("TestCase Ended");
	}

	@Test(priority = 4)
	@Description("User should be able to modify a call center booking from confirmation page for Guest Details")
	@Severity(SeverityLevel.CRITICAL)
	@Epic("EP01")
	@Feature("Feature1:Call Center")
	@Story("Call Center")
	@Step("User should be able to modify a call center booking from confirmation page for Guest Details")
	public void ModifyBookingfromconfirmationpageTest_TC04() {
		logger.info("TestCase Started");
		extentTest = extent.startTest("ModifyBookingfromconfirmationpageTest_TC04");
		mbcp.getGuestDetailsbefore();
		allureScreenshot("GuestDetails before");
		screenShot("GuestDetails before");
		mbcp.modify();
		nsrb.clickpaymentButton();
		mbcp.inputGuestDetailsTC04();
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
	@Description("User should be able to do a call center booking without AddOns from confirmation page and then modify it to have AddOns through edit search")
	@Severity(SeverityLevel.CRITICAL)
	@Epic("EP01")
	@Feature("Feature1:Call Center")
	@Story("Call Center")
	@Step("User should be able to do a call center booking without AddOns from confirmation page and then modify it to have AddOns through edit search")
	public void ModifyBookingfromconfirmationpageTest_TC05() {
		logger.info("TestCase Started");
		extentTest = extent.startTest("ModifyBookingfromconfirmationpageTest_TC05");
		mbcp.getOtherServicesBefore();
		mbcp.modify();
		allureScreenshot("Modify");
		screenShot("Modify");
		mbcp.clickEditSearchButton();
		nsrb.clickAvailibilityButton();
		nsrb.selectRoom();
		nsrb.clickpaymentButton();
		nsrb.inputGuestDetails();
		mbcp.selectAddOn();
		nsrb.inputCardDetailsTC01();
		nsrb.inputBillingAddress();
		nsrb.selectTermsAndConditonCheckbox();
		nsrb.clickCompleteReservation();
		allureScreenshot("confirm reservation");
		screenShot("confirm reservation");
		mbcp.getOtherServicesafter();
		Assert.assertTrue(mbcp.verifyOtherServicesModify());
		logger.info("TestCase Ended");
	}

	@Test(priority = 6)
	@Description("User should be able to modify a call center booking from confirmation page for Bed Type Preferences through modify button through edit search")
	@Severity(SeverityLevel.CRITICAL)
	@Epic("EP01")
	@Feature("Feature1:Call Center")
	@Story("Call Center")
	@Step("User should be able to modify a call center booking from confirmation page for Bed Type Preferences through modify button through edit search")
	public void ModifyBookingfromconfirmationpageTest_TC06() {
		logger.info("TestCase Started");
		extentTest = extent.startTest("ModifyBookingfromconfirmationpageTest_TC06");
		mbcp.getBedTypebefore();
		mbcp.modify();
		allureScreenshot("Modify");
		screenShot("Modify");
		mbcp.clickEditSearchButton();
		nsrb.clickAvailibilityButton();
		nsrb.selectRoom();
		nsrb.clickpaymentButton();
		nsrb.inputGuestDetails();
		mbcp.selectClassicBedType();
		nsrb.inputCardDetailsTC01();
		nsrb.inputBillingAddress();
		nsrb.selectTermsAndConditonCheckbox();
		nsrb.clickCompleteReservation();
		allureScreenshot("confirm reservation");
		screenShot("confirm reservation");
		mbcp.getBedTypeafter();
		allureScreenshot("BedType after");
		screenShot("BedType after");
		Assert.assertTrue(mbcp.verifyBedTypeModify());
		logger.info("TestCase Ended");
	}

	@Test(priority = 7)
	@Description("User should be able to modify a call center booking from confirmation page for Bed Type Preferences through Edit request button")
	@Severity(SeverityLevel.CRITICAL)
	@Epic("EP01")
	@Feature("Feature1:Call Center")
	@Story("Call Center")
	@Step("User should be able to modify a call center booking from confirmation page for Bed Type Preferences through Edit request button")
	public void ModifyBookingfromconfirmationpageTest_TC07() {
		logger.info("TestCase Started");
		extentTest = extent.startTest("ModifyBookingfromconfirmationpageTest_TC07");
		mbcp.getBedTypebefore();
		allureScreenshot("BedType before");
		screenShot("BedType before");
		mbcp.clickEditRequestButton();
		allureScreenshot("Edit Request");
		screenShot("Edit Request");
		mbcp.selectQueenBedType();
		mbcp.clickSaveButton();
		mbcp.getBedTypeafter();
		allureScreenshot("BedType after");
		screenShot("BedType after");
		Assert.assertTrue(mbcp.verifyBedTypeModify());
		logger.info("TestCase Ended");
	}

	@Test(priority = 8)
	@Description("User should be able to modify a call center booking from confirmation page for room type")
	@Severity(SeverityLevel.CRITICAL)
	@Epic("EP01")
	@Feature("Feature1:Call Center")
	@Story("Call Center")
	@Step("User should be able to modify a call center booking from confirmation page for room type")
	public void ModifyBookingfromconfirmationpageTest_TC08() {
		logger.info("TestCase Started");
		extentTest = extent.startTest("ModifyBookingfromconfirmationpageTest_TC08");
		mbcp.verifyRoomTypebefore();
		allureScreenshot("RoomType before");
		screenShot("RoomType before");
		mbcp.modify();
		allureScreenshot("Modify");
		screenShot("Modify");
		nsrb.selectRoomTC08mbcp();
		nsrb.clickpaymentButton();
		nsrb.inputGuestDetails();
		mbcp.selectClassicBedType();
		nsrb.inputCardDetailsTC01();
		nsrb.inputBillingAddress();
		nsrb.selectTermsAndConditonCheckbox();
		nsrb.clickCompleteReservation();
		allureScreenshot("confirm reservation");
		screenShot("confirm reservation");
		mbcp.verifyRoomTypeafter();
		allureScreenshot("RoomType after");
		screenShot("RoomType after");
		Assert.assertTrue(mbcp.verifyRoomModify());
		logger.info("TestCase Ended");
	}

	@Test(priority = 9)
	@Description("User should be able to do a call center booking with AddOns from confirmation page and then modify for No AddOns through edit search")
	@Severity(SeverityLevel.CRITICAL)
	@Epic("EP01")
	@Feature("Feature1:Call Center")
	@Story("Call Center")
	@Step("User should be able to do a call center booking with AddOns from confirmation page and then modify for No AddOns through edit search")
	public void ModifyBookingfromconfirmationpageTest_TC09() {
		logger.info("TestCase Started");
		extentTest = extent.startTest("ModifyBookingfromconfirmationpageTest_TC09");
		nsrb.clickNewReservation();
		nsrb.selectDateRangeCCTC01();
		nsrb.clickAvailibilityButton();
		nsrb.selectRoom();
		nsrb.clickpaymentButton();
		allureScreenshot("Call Center payment details");
		screenShot("Call Center payment details");
		nsrb.inputGuestDetails();
		mbcp.selectAddOn();
		nsrb.inputCardDetailsTC01();
		nsrb.inputBillingAddress();
		nsrb.selectTermsAndConditonCheckbox();
		nsrb.clickCompleteReservation();
		mbcp.getOtherServicesBefore();
		mbcp.modify();
		allureScreenshot("Modify");
		screenShot("Modify");
		mbcp.clickEditSearchButton();
		nsrb.clickAvailibilityButton();
		nsrb.selectRoom();
		nsrb.clickpaymentButton();
		nsrb.inputGuestDetails();
		nsrb.inputCardDetailsTC01();
		nsrb.inputBillingAddress();
		nsrb.selectTermsAndConditonCheckbox();
		nsrb.clickCompleteReservation();
		allureScreenshot("confirm reservation");
		screenShot("confirm reservation");
		Assert.assertTrue(mbcp.verifyConfirmationCode());
		mbcp.getOtherServicesafter();
		Assert.assertTrue(mbcp.verifyOtherServicesModify());
		Helper.switchWindow(0);
		lp.logout();
		logger.info("TestCase Ended");
	}
}
