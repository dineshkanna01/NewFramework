package com.bookingengine;

import java.util.ArrayList;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.admin.AddOn_Scenario;
import com.admin.pom.AddOnsPage;
import com.admin.pom.AdministratorHomePage;
import com.admin.pom.LoginPage;
import com.admin.pom.PaymentGatewayPage;
import com.be.pom.JCCBookingsPage;

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
 * Test class for JCCBookings
 * @author Rudraksh Aggarwal
 */

public class JCCBookings extends TestBase {

	public static Utilitylog logger;

	// objects
	ExcelData e = new ExcelData();
	LoginPage lp;
	AdministratorHomePage ahp;
	PaymentGatewayPage pgp;
	JCCBookingsPage jbp;
	SoftAssert soft;

	public JCCBookings() {
		super();
		logger = new Utilitylog(JCCBookings.class.getName());
	}

	@BeforeMethod
	public void setup() {
		lp = new LoginPage(getDriver());
		ahp = new AdministratorHomePage(getDriver());
		pgp = new PaymentGatewayPage(getDriver());
		jbp = new JCCBookingsPage(getDriver());
		soft = new SoftAssert();
	}

	@Test(priority = 1)
	@Description("User should be able to configure the prequisite settings for JCC Payment Gateway")
	@Severity(SeverityLevel.CRITICAL)
	@Epic("EP01")
	@Feature("Feature1:JCC Bookings")
	@Story("JCC Bookings")
	@Step("User should be able to configure the prequisite settings for JCC Payment Gateway")
	public void BookingEngine_JCCBookings_TC_01() {
		logger.info("TestCase Started");
		extentTest = extent.startTest("BookingEngine_JCCBookings_TC_01");

		lp.login();

		allureScreenshot("Login");
		screenShot("Login");

		ahp.selectBrandJCC();
		ahp.selectPropertyJCC();

		allureScreenshot("Property Selected");
		screenShot("Property Selected");

		ahp.clickPropertyManagementTab();
		ahp.clickPaymentGatewayTab();

		allureScreenshot("payment gateway");
		screenShot("payment gateway");

		pgp.selectPaymentGateway(e.getCellData("JCCBookings", "paymentGateway", 2));
		pgp.clickEnableButton();
		pgp.clickYesButton();

		pgp.clearMerchantId();
		pgp.merchantId_JCCbookings();
		pgp.clearAccessCode();
		pgp.accessCode_JCC();
		pgp.clearSecureHashSecret();
		pgp.secureHashSecret_JCC();
		pgp.delayTime();
		pgp.orderTime();

		allureScreenshot("payment gateway details entered");
		screenShot("payment gateway details entered");

		pgp.clickUpdateButton();
		String actText = pgp.administratorname();
		String expText = e.getCellData("JCCBookings", "AdministratorText", 2);
		soft.assertEquals(actText, expText, "Payment Gateway has updated");
		soft.assertAll();

	}

	@Test(priority = 2)
	@Description("JCC Payment Gateway congfigurations should auto populate")
	@Severity(SeverityLevel.CRITICAL)
	@Epic("EP01")
	@Feature("Feature1:JCC Bookings")
	@Story("JCC Bookings")
	@Step("JCC Payment Gateway congfigurations should auto populate")
	public void BookingEngine_JCCBookings_TC_02() throws InterruptedException {
		logger.info("TestCase Started");
		extentTest = extent.startTest("BookingEngine_JCCBookings_TC_02");

		ahp.clickPaymentGatewayTab();

		pgp.selectPaymentGateway(e.getCellData("JCCBookings", "paymentGateway", 2));

		pgp.verifyJCCAutoPopulate();

	}

//	@Test(priority = 3)
	@Description("User should be able to make reservations in Booking Engine using JCC Payment Gateway")
	@Severity(SeverityLevel.CRITICAL)
	@Epic("EP01")
	@Feature("Feature1:JCC Bookings")
	@Story("JCC Bookings")
	@Step("User should be able to make reservations in Booking Engine using JCC Payment Gateway")
	public void BookingEngine_JCCBookings_TC_03() throws InterruptedException {
		logger.info("TestCase Started");
		extentTest = extent.startTest("BookingEngine_JCCBookings_TC_03");

		lp.login();

//
//		allureScreenshot("Login");
//		screenShot("Login");
//
//		ahp.selectBrandJCC();
//		ahp.selectPropertyJCC();
//
//		allureScreenshot("Property Selected");
//		screenShot("Property Selected");
//
//		ahp.clickPropertyManagementTab();
//
//		ahp.clickPaymentGatewayTab();
//
//		allureScreenshot("payment gateway");
//		screenShot("payment gateway");
//
//		pgp.selectPaymentGateway(e.getCellData("JCCBookings", "paymentGateway", 2));
//
//		pgp.verifyJCCAutoPopulate();

		openBEurlinNewTabJCC();

		jbp.selectDate();
		jbp.clickAvailibilityButton();
		jbp.clickBookNowButton();
		jbp.inputGuestDetails();
		jbp.selectRatePlanBar();
		jbp.clickconfirmDetails();

		jbp.inputCardDetailsTC01();
		jbp.inputBillingAddress();
		jbp.inputadditionalContactInfo();
		jbp.selectTermsAndConditonCheckbox();
		jbp.clickCompleteReservation();

		allureScreenshot("Reservation Completed");
		screenShot("Reservation Completed");

		Assert.assertTrue(jbp.verificationTC03());

		allureScreenshot("Reservation Done");
		screenShot("Reservation Done");

//		switchWindow(0);
		logger.info("TestCase Ended");
	}

	@Test(priority = 4)
	@Description("User should not be able to make reservations in Booking Engine using JCC Payment Gateway if CC number is incorrect")
	@Severity(SeverityLevel.CRITICAL)
	@Epic("EP01")
	@Feature("Feature1:JCC Bookings")
	@Story("JCC Bookings")
	@Step("User should not be able to make reservations in Booking Engine using JCC Payment Gateway if CC number is incorrect")
	public void BookingEngine_JCCBookings_TC_04() throws InterruptedException {
		logger.info("TestCase Started");
		extentTest = extent.startTest("BookingEngine_JCCBookings_TC_04");

//		lp.login();
//
//		allureScreenshot("Login");
//		screenShot("Login");
//
//		ahp.selectBrandJCC();
//		ahp.selectPropertyJCC();
//
//		allureScreenshot("Property Selected");
//		screenShot("Property Selected");
//
//		ahp.clickPropertyManagementTab();
//
//		ahp.clickPaymentGatewayTab();
//
//		allureScreenshot("payment gateway");
//		screenShot("payment gateway");
//
//		pgp.selectPaymentGateway(e.getCellData("JCCBookings", "paymentGateway", 2));
//
//		pgp.verifyJCCAutoPopulate();

		openBEurlinNewTabJCC();

		// refreshBE();
		jbp.selectDate();
		jbp.clickAvailibilityButton();
		jbp.clickBookNowButton();
		jbp.inputGuestDetails();
		jbp.selectRatePlanBar();
		jbp.clickconfirmDetails();

		jbp.inputCardDetailsTC02();
		jbp.inputBillingAddress();
		jbp.inputadditionalContactInfo();
		jbp.selectTermsAndConditonCheckbox();
		jbp.clickCompleteReservation();

		Assert.assertTrue(jbp.verificationTC04());

		allureScreenshot("Reservation not Done");
		screenShot("Reservation not Done TC04");

		// switchWindow(0);
		logger.info("TestCase Ended");
	}

	@Test(priority = 5)
	@Description("User should not be able to make reservations in Booking Engine using JCC Payment Gateway if JCC Payment gateway is not set as default")
	@Severity(SeverityLevel.CRITICAL)
	@Epic("EP01")
	@Feature("Feature1:JCC Bookings")
	@Story("JCC Bookings")
	@Step("User should not be able to make reservations in Booking Engine using JCC Payment Gateway if JCC Payment gateway is not set as default")
	public void BookingEngine_JCCBookings_TC_05() throws InterruptedException {
		logger.info("TestCase Started");
		extentTest = extent.startTest("BookingEngine_JCCBookings_TC_05");

//		lp.login();
//
//		allureScreenshot("Login");
//		screenShot("Login");
//
//		ahp.selectBrandJCC();
//		ahp.selectPropertyJCC();
//
//		allureScreenshot("Property Selected");
//		screenShot("Property Selected");
//
//		ahp.clickPropertyManagementTab();

		switchWindow(0);

		ahp.clickPaymentGatewayTab();

		allureScreenshot("payment gateway");
		screenShot("payment gateway");

		pgp.selectPaymentGateway(e.getCellData("JCCBookings", "paymentGateway", 2));
		pgp.clickNoButton();
		pgp.verifyJCCAutoPopulate();
		pgp.clickUpdateButton();

		// openBEurlinNewTab();
		switchWindow(1);
		refreshBEJCC();
		jbp.selectDate();
		jbp.clickAvailibilityButton();
		jbp.clickBookNowButton();
		jbp.inputGuestDetails();
		jbp.selectRatePlanBar();
		jbp.clickconfirmDetails();

		jbp.inputCardDetailsTC01();
		jbp.inputBillingAddress();
		jbp.inputadditionalContactInfo();
		jbp.selectTermsAndConditonCheckbox();
		jbp.clickCompleteReservation();

		Assert.assertFalse(jbp.verificationTC05());

		allureScreenshot("Reservation not Done");
		screenShot("Reservation not Done TC05");

		// switchWindow(0);
		logger.info("TestCase Ended");
	}

	@Test(priority = 6)
	@Description("User should not be able to make reservations in Booking Engine using JCC Payment Gateway if JJC gateway is not configured correctly")
	@Severity(SeverityLevel.CRITICAL)
	@Epic("EP01")
	@Feature("Feature1:JCC Bookings")
	@Story("JCC Bookings")
	@Step("User should not be able to make reservations in Booking Engine using JCC Payment Gateway if JJC gateway is not configured correctly")
	public void BookingEngine_JCCBookings_TC_06() throws InterruptedException {
		logger.info("TestCase Started");
		extentTest = extent.startTest("BookingEngine_JCCBookings_TC_06");
//
//		lp.login();
//
//		allureScreenshot("Login");
//		screenShot("Login");
//
//		ahp.selectBrandJCC();
//		ahp.selectPropertyJCC();
//
//		allureScreenshot("Property Selected");
//		screenShot("Property Selected");
//
//		ahp.clickPropertyManagementTab();

		switchWindow(0);
		ahp.clickPaymentGatewayTab();

		allureScreenshot("payment gateway");
		screenShot("payment gateway");

		pgp.selectPaymentGateway(e.getCellData("JCCBookings", "paymentGateway", 2));
		pgp.clickYesButton();
		pgp.clearSecureHashSecret();
		pgp.secureHashSecret_JCCTC06();
		pgp.clickUpdateButton();

		// openBEurlinNewTab();
		switchWindow(1);
		refreshBEJCC();

		jbp.selectDate();
		jbp.clickAvailibilityButton();
		jbp.clickBookNowButton();
		jbp.inputGuestDetails();
		jbp.selectRatePlanBar();
		jbp.clickconfirmDetails();

		jbp.inputCardDetailsTC01();
		jbp.inputBillingAddress();
		jbp.inputadditionalContactInfo();
		jbp.selectTermsAndConditonCheckbox();
		jbp.clickCompleteReservation();

		Assert.assertTrue(jbp.verificationTC06());

		allureScreenshot("Reservation not Done");
		screenShot("Reservation not Done TC06");

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
