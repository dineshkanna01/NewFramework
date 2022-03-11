package com.callcenter;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.admin.pom.AdministratorHomePage;
import com.admin.pom.LoginPage;

import com.cc.pom.ModifyBookingfromconfirmationpagePage;

import com.cc.pom.MultipleTabsinRT3CCmodifyingtworeservationsatonceormaking2setsofreservationsatonceifthemaxroomcounthasbeenexceededPage;
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

/* Test class for MultipleTabsinRT3CCmodifyingtworeservationsatonceormaking2setsofreservationsatonceifthemaxroomcounthasbeenexceeded  
* @author Rudraksh Aggarwal
*/
public class MultipleTabsinRT3CCmodifyingtworeservationsatonceormaking2setsofreservationsatonceifthemaxroomcounthasbeenexceeded
		extends TestBase {

	public static Utilitylog logger;

	// objects
	LoginPage lp;
	AdministratorHomePage ahp;
	NormalSingleRoomBookingandverifyRateGridupdatePage nsrb;
	ModifyBookingfromconfirmationpagePage mbcp;
	MultipleTabsinRT3CCmodifyingtworeservationsatonceormaking2setsofreservationsatonceifthemaxroomcounthasbeenexceededPage mtr;

	public MultipleTabsinRT3CCmodifyingtworeservationsatonceormaking2setsofreservationsatonceifthemaxroomcounthasbeenexceeded() {
		super();
		logger = new Utilitylog(
				MultipleTabsinRT3CCmodifyingtworeservationsatonceormaking2setsofreservationsatonceifthemaxroomcounthasbeenexceeded.class
						.getName());
	}

	@BeforeMethod
	public void setup() {
		lp = new LoginPage(getDriver());
		ahp = new AdministratorHomePage(getDriver());
		nsrb = new NormalSingleRoomBookingandverifyRateGridupdatePage(getDriver());
		mbcp = new ModifyBookingfromconfirmationpagePage(getDriver());
		mtr = new MultipleTabsinRT3CCmodifyingtworeservationsatonceormaking2setsofreservationsatonceifthemaxroomcounthasbeenexceededPage(
				getDriver());
	}

	@Test(priority = 1)
	@Description("User should be able to book two reservations at once in multiple tabs")
	@Severity(SeverityLevel.CRITICAL)
	@Epic("EP01")
	@Feature("Feature1:Call Center")
	@Story("Call Center")
	@Step("User should be able to book two reservations at once in multiple tabs")
	public void CallCenter_MultipleTabsinRT3CCmodifyingtworeservationsatonceormaking2setsofreservationsatonceifthemaxroomcounthasbeenexceeded_TC_01() {
		logger.info("TestCase Started");
		extentTest = extent.startTest("CallCenter_ModifyRT3BookingfromCCsiteandviceversa_TC_01");
		openURL("cc_url");
		Helper.switchWindow(0);
		getDriver().close();
		Helper.switchWindow(0);
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
		Helper.sleep(1000);
		nsrb.inputBillingAddress();
		nsrb.selectTermsAndConditonCheckbox();
		openURL("cc_url");
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
		Helper.sleep(1000);
		nsrb.inputBillingAddress();
		nsrb.selectTermsAndConditonCheckbox();
		Helper.switchWindow(0);
		nsrb.clickCompleteReservation();
		Helper.switchWindow(1);
		nsrb.clickCompleteReservation();
		Helper.switchWindow(0);
		Assert.assertTrue(mtr.verifyConfirmationCodeTC01_1());
		Helper.switchWindow(1);
		Assert.assertTrue(mtr.verifyConfirmationCodeTC01_2());
		logger.info("TestCase Ended");
	}

	@Test(priority = 2)
	@Description("User should be able to book and modify  two reservation  at once in multiple tabs")
	@Severity(SeverityLevel.CRITICAL)
	@Epic("EP01")
	@Feature("Feature1:Call Center")
	@Story("Call Center")
	@Step("User should be able to book and modify  two reservation  at once in multiple tabs")
	public void CallCenter_MultipleTabsinRT3CCmodifyingtworeservationsatonceormaking2setsofreservationsatonceifthemaxroomcounthasbeenexceeded_TC_02() {
		logger.info("TestCase Started");
		extentTest = extent.startTest("CallCenter_ModifyRT3BookingfromCCsiteandviceversa_TC_02");
		Helper.switchWindow(0);
		mbcp.verifyRoomTypebefore();
		Helper.switchWindow(1);
		mbcp.verifyRoomTypebefore();
		Helper.switchWindow(0);
		mbcp.modify();
		mbcp.clickEditSearchButton();
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
		Assert.assertTrue(mtr.verifyRoomModifyTC02_1());
		Helper.switchWindow(1);
		mbcp.modify();
		mbcp.clickEditSearchButton();
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
		Assert.assertTrue(mtr.verifyRoomModifyTC02_2());
		logger.info("TestCase Ended");
	}

}
