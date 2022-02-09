package com.callcenter;

import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.admin.pom.AdministratorHomePage;
import com.admin.pom.LoginPage;
import com.admin.pom.RatesandInventoryPage;
import com.cc.pom.CancelBookingfromconfirmationpagePage;
import com.cc.pom.NormalSingleRoomBookingandverifyRateGridupdatePage;

import Utility.ExcelData;
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
 * Test class for CancelBookingfromconfirmationpageTest
 * @author Rudraksh Aggarwal
 */

public class CancelBookingfromconfirmationpageTest extends TestBase 	{

	public static Utilitylog logger;

	// objects
	ExcelData e = new ExcelData();
	LoginPage lp;
	AdministratorHomePage ahp;
	RatesandInventoryPage rip;
	NormalSingleRoomBookingandverifyRateGridupdatePage nsrb;
	CancelBookingfromconfirmationpagePage cbcp;

	public CancelBookingfromconfirmationpageTest() {
		super();
		logger = new Utilitylog(CancelBookingfromconfirmationpageTest.class.getName());
	}

	@BeforeMethod
	public void setup() {
		lp = new LoginPage(getDriver());
		ahp = new AdministratorHomePage(getDriver());
		rip = new RatesandInventoryPage(getDriver());
		nsrb = new NormalSingleRoomBookingandverifyRateGridupdatePage(getDriver());
		cbcp = new CancelBookingfromconfirmationpagePage(getDriver());

	}

	@Test(priority = 1)
	@Description("User should be able to cancel a call center booking from confirmation page")
	@Severity(SeverityLevel.CRITICAL)
	@Epic("EP01")
	@Feature("Feature1:Call Center")
	@Story("Call Center")
	@Step("User should be able to cancel a call center booking from confirmation page")
	public void CancelBookingfromconfirmationpageTest_TC01() {
		logger.info("TestCase Started");
		extentTest = extent.startTest("CancelBookingfromconfirmationpageTest_TC01");

		lp.login();
		allureScreenshot("Login");
		screenShot("Login");

		ahp.selectBrand();
		ahp.selectProperty2();

		allureScreenshot("Property Selected");
		screenShot("Property Selected");

		openCCurlinNewTab();
		nsrb.enterCCuser();

		allureScreenshot("Call Center");
		screenShot("Call Center");

		nsrb.selectDateRangeCCTC01();
		nsrb.clickAvailibilityButton();
		nsrb.selectClassicRoom();
		nsrb.clickpaymentButton();

		allureScreenshot("Call Center payment details");
		screenShot("Call Center payment details");

		nsrb.inputGuestDetails();
		nsrb.inputCardDetailsTC01();
		nsrb.inputBillingAddress();
		nsrb.selectTermsAndConditonCheckbox();
		nsrb.clickCompleteReservation();

		Assert.assertTrue(nsrb.verifyConfirmationCode());

		allureScreenshot("Call Center booking confirmation code");
		screenShot("Call Center booking confirmation code");

		Assert.assertTrue(cbcp.verifyCancelBookingTC01());

		allureScreenshot("Call Center booking Cancellation codenfirmation");
		screenShot("Call Center booking Cancellation codenfirmation");
		
		logger.info("TestCase Ended");
	}

	@Test(priority = 2)
	@Description("User should be able to Verify a Cancelled booking")
	@Severity(SeverityLevel.CRITICAL)
	@Epic("EP01")
	@Feature("Feature1:Call Center")
	@Story("Call Center")
	@Step("User should be able to Verify a Cancelled booking")
	public void CancelBookingfromconfirmationpageTest_TC02() {
		logger.info("TestCase Started");
		extentTest = extent.startTest("CancelBookingfromconfirmationpageTest_TC02");

		switchWindow(1);
		Assert.assertTrue(cbcp.verifyCancelBookingTC02());

		allureScreenshot("Call Center booking Cancellation codenfirmation");
		screenShot("Call Center booking Cancellation codenfirmation");

		logger.info("TestCase Ended");
	}

	@Test(priority = 3)
	@Description("User should be not be able to Verify a Cancelled booking if Email is incorrect and Confirmation code is correct")
	@Severity(SeverityLevel.CRITICAL)
	@Epic("EP01")
	@Feature("Feature1:Call Center")
	@Story("Call Center")
	@Step("User should be not be able to Verify a Cancelled booking if Email is incorrect and Confirmation code is correct")
	public void CancelBookingfromconfirmationpageTest_TC03() {
		logger.info("TestCase Started");
		extentTest = extent.startTest("CancelBookingfromconfirmationpageTest_TC03");

		Assert.assertTrue(cbcp.verifyCancelBookingTC03());

		allureScreenshot("Call Center cancelled booking not verified if email is incorrect");
		screenShot("Call Center cancelled booking not verified if email is incorrect");

		logger.info("TestCase Ended");
	}

	@Test(priority = 4)
	@Description("User should be not be able to Verify a Cancelled booking if Email is correct and Confirmation code is incorrect")
	@Severity(SeverityLevel.CRITICAL)
	@Epic("EP01")
	@Feature("Feature1:Call Center")
	@Story("Call Center")
	@Step("User should be not be able to Verify a Cancelled booking if Email is correct and Confirmation code is incorrect")
	public void CancelBookingfromconfirmationpageTest_TC04() {
		logger.info("TestCase Started");
		extentTest = extent.startTest("CancelBookingfromconfirmationpageTest_TC04");

		Assert.assertTrue(cbcp.verifyCancelBookingTC04());
		allureScreenshot("Call Center cancelled booking not verified if confirmation code is incorrect");
		screenShot("Call Center cancelled booking not verified if confirmation code is incorrect");

		logger.info("TestCase Ended");

	}

	@Test(priority = 5)
	@Description("User should be not be able to Verify a Cancelled booking if both Emailand confirmation code are incorrect")
	@Severity(SeverityLevel.CRITICAL)
	@Epic("EP01")
	@Feature("Feature1:Call Center")
	@Story("Call Center")
	@Step("User should be not be able to Verify a Cancelled booking if both Emailand confirmation code are incorrect")
	public void CancelBookingfromconfirmationpageTest_TC05() {
		logger.info("TestCase Started");
		extentTest = extent.startTest("CancelBookingfromconfirmationpageTest_TC05");

		Assert.assertTrue(cbcp.verifyCancelBookingTC05());

		allureScreenshot("Call Center cancelled booking not verified if both email & confirmation code is incorrect");
		screenShot("Call Center cancelled booking not verified if both email & confirmation code is incorrect");

		switchWindow(0);
		lp.logout();
		logger.info("TestCase Ended");
	}

	@AfterSuite
	public void report() {
		try {
			mail();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		cmdPrompt();
	}
	
}
