package com.bookingengine;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.admin.pom.AdministratorHomePage;
import com.admin.pom.LoginPage;
import com.be.pom.CalendarViewBookingsPage;
import com.be.pom.ModifyingReservationPage;

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
 * Test class for Modifying Reservation Page
 * @author Sudhakar Mourya
 */
public class ModifyingReservation extends TestBase {

	public static Utilitylog logger;

	LoginPage lp;
	AdministratorHomePage ahp;
	CalendarViewBookingsPage cvbp;
	SoftAssert soft;
	ModifyingReservationPage mrp;

	public ModifyingReservation() {
		super();
		logger = new Utilitylog(ModifyingReservation.class.getName());
	}

	@BeforeMethod
	public void setup() {
		lp = new LoginPage(getDriver());
		ahp = new AdministratorHomePage(getDriver());
		cvbp= new CalendarViewBookingsPage(getDriver());
		soft = new SoftAssert();
		mrp=new ModifyingReservationPage(getDriver());
	}

	@Test(priority = 1)
	@Description("Verify user is able to make reservation then Modifying Reservation")
	@Severity(SeverityLevel.CRITICAL)
	@Epic("EP01")
	@Feature("Feature1:Modifying Reservation")
	@Story("Modifying Reservation")
	@Step("Make reservation then Modifying Reservation")
	public void ModifyingReservation_TC_01() throws InterruptedException {
		logger.info("TestCase Started");
		extentTest = extent.startTest("ModifyingReservation_TC_01");
		lp.login();
		ahp.selectBrand();
		ahp.selectProperty();
		allureScreenshot("Property Selected");
		screenShot("Property Selected");
		openURL("be_url4");
		cvbp.selectDate();
		cvbp.clickAvailibilityButton();
		cvbp.clickBookNowButton();
		cvbp.inputGuestDetails();
		cvbp.selectRatePlanBar();
		cvbp.clickconfirmDetails();
		cvbp.inputCardDetails();
		cvbp.inputBillingAddress();
		cvbp.inputadditionalContactInfo();
		cvbp.selectTermsAndConditonCheckbox();
		cvbp.clickCompleteReservation();
		allureScreenshot("Reservation Completed");
		screenShot("Reservation Completed");
		mrp.guestDetailBefore();
		cvbp.clickOnChangeReservation();
		cvbp.clickOnYesForChangeReservation();
		cvbp.clickBookNowButton();
		mrp.inputGuestDetailsModify();
		cvbp.clickconfirmDetails();
		mrp.inputCardDetails();
		cvbp.selectTermsAndConditonCheckbox();
		cvbp.clickCompleteReservation();
		mrp.getConfirmationNo();
		allureScreenshot("Modified Guest Detail Page");
		screenShot("Modified Guest Detail Page");
		mrp.guestDetailAfter();
		soft.assertTrue(mrp.verifyBookingModify());
		logger.info("TestCase Ended");
	}	

		@Test(priority = 2)
	@Description("Verify user is able to check the modification by confirmation code")
	@Severity(SeverityLevel.CRITICAL)
	@Epic("EP01")
	@Feature("Feature1:Modifying Reservation")
	@Story("Modifying Reservation")
	@Step("Check Modifying Reservation")
	public void ModifyingReservation_TC_02() throws InterruptedException {
		logger.info("TestCase Started");
		extentTest = extent.startTest("ModifyingReservation_TC_02");
		Helper.refreshBE();
		mrp.inputTc_02();
		allureScreenshot("Error msg displayed");
		screenShot("Error msg displayed");
		soft.assertTrue(mrp.verifyTc_02());
		logger.info("TestCase Ended");
	}

	@Test(priority = 3)
	@Description("Verify user is not able to do modification with  wrong confirmation code")
	@Severity(SeverityLevel.CRITICAL)
	@Epic("EP01")
	@Feature("Feature1:Modifying Reservation")
	@Story("Modifying Reservation")
	@Step("Couldn't Modifying Reservation with wrong input")
	public void ModifyingReservation_TC_03() throws InterruptedException {
		logger.info("TestCase Started");
		extentTest = extent.startTest("ModifyingReservation_TC_03");
		Helper.refreshBE();
		mrp.inputTc_03();
		allureScreenshot("Error msg displayed");
		screenShot("Error msg displayed");
		soft.assertTrue(mrp.verifyTc_03());
		logger.info("TestCase Ended");
	}

	@Test(priority = 4)
	@Description("Verify user is not able to do modification with  only emailid")
	@Severity(SeverityLevel.CRITICAL)
	@Epic("EP01")
	@Feature("Feature1:Modifying Reservation")
	@Story("Modifying Reservation")
	@Step("Couldn't Modifying Reservation with only emailid")
	public void ModifyingReservation_TC_04() throws InterruptedException {
		logger.info("TestCase Started");
		extentTest = extent.startTest("ModifyingReservation_TC_03");
		Helper.refreshBE();
		mrp.inputTc_04();
		allureScreenshot("Error msg displayed");
		screenShot("Error msg displayed");
		soft.assertTrue(mrp.verifyTc_04());
		Helper.switchWindow(0);
		lp.logout();
		logger.info("TestCase Ended");
	}
}
