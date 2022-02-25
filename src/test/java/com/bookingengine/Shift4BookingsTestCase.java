package com.bookingengine;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.admin.pom.AdministratorHomePage;
import com.admin.pom.BrandPage;
import com.admin.pom.ChannelPage;
import com.admin.pom.LoginPage;
import com.admin.pom.PaymentGatewayPage;
import com.admin.pom.PropertyBrandingPage;
import com.be.pom.JCCBookingsPage;
import com.be.pom.CompoundAccessCodePage;
import com.be.pom.FBPStrikeThroughPricingPage;
import com.be.pom.PropertyLevelRestrictionPage;
import com.be.pom.Shift4BookingsPage;
import com.be.pom.SmartRateTestingPage;

import Utility.ExcelData;
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
* Test class for Shift4 Bookings
* @Author : UzairAsar
*/
public class Shift4BookingsTestCase extends TestBase {
	public static Utilitylog logger;
	LoginPage lp;
	BrandPage bp;
	PropertyBrandingPage pbp;
	ChannelPage cp;
	PropertyLevelRestrictionPage plrp;
	SmartRateTestingPage srtp;
	AdministratorHomePage ahp;
	CompoundAccessCodePage cacp;
	JCCBookingsPage jbp;
	FBPStrikeThroughPricingPage fbp;
	SoftAssert soft;
	PaymentGatewayPage pgp;
	Shift4BookingsPage sbp;

	public Shift4BookingsTestCase() {
		super();
		logger = new Utilitylog(Shift4BookingsTestCase.class.getName());
	}

	@BeforeMethod
	public void setup() {
		lp = new LoginPage(getDriver());
		bp = new BrandPage(getDriver());
		ahp = new AdministratorHomePage(getDriver());
		cacp = new CompoundAccessCodePage(getDriver());
		jbp = new JCCBookingsPage(getDriver());
		fbp = new FBPStrikeThroughPricingPage(getDriver());
		soft = new SoftAssert();
		pbp = new PropertyBrandingPage(getDriver());
		plrp = new PropertyLevelRestrictionPage(getDriver());
		srtp = new SmartRateTestingPage(getDriver());
		pgp = new PaymentGatewayPage(getDriver());
		sbp = new Shift4BookingsPage(getDriver());
		

	}

//	@Test(priority = 1)
	@Description("User should be able to configure the prequisite settings for Shift4 Payment Gateway.")
	@Severity(SeverityLevel.CRITICAL)
	@Epic("EP01")
	@Feature("Feature1: Shift4 Payment Gateway")
	@Story("Story: Reservation can be book with compound access code")
	@Step("Verify reservation can be book with compound access code")
	public void BookingEngine_Shift4Bookings_TC_01() {
		logger.info("CRS Started");
		extentTest = extent.startTest("BookingEngine_Shift4Bookings_TC_01");


		lp.login();

		allureScreenshot("Login");
		screenShot("Login");

		ahp.selectBrandPaymentGateway();
		ahp.selectPropertyPaymentGateway();

		allureScreenshot("Property Selected");
		screenShot("Property Selected");

		ahp.clickPropertyManagementTab();
		ahp.clickPaymentGatewayTab();
		
		allureScreenshot("payment gateway");
		screenShot("payment gateway");

		pgp.selectPaymentGateway(ExcelData.getCellData("Sheet1", "paymentGateway", 4));
		
		pgp.clickEnableButton();
		pgp.clickYesButton();
		
		pgp.clearSecureHashSecret();
		pgp.secureHashSecret_SHIFT4();
		
		pgp.clearDelayTime();
		pgp.delayTime_SHIFT4();
		
//		sbp.clearOrderTime();
		
		pgp.orderTime();
		
		allureScreenshot("payment gateway details entered");
		screenShot("payment gateway details entered");

		pgp.clickUpdateButton();
		
		String actText = pgp.administratorname();
		
		String expText = ExcelData.getCellData("Shift4", "AdministratorText", 2);
		soft.assertEquals(actText, expText, "Payment Gateway has updated");
		soft.assertAll();
		
		
	}
	
//	@Test(priority = 2)
	@Description("User should be able to configure the prequisite settings for Shift4 Payment Gateway.")
	@Severity(SeverityLevel.CRITICAL)
	@Epic("EP01")
	@Feature("Feature1: Shift4 Payment Gateway")
	@Story("Story: Reservation can be book with compound access code")
	@Step("Verify reservation can be book with compound access code")
	public void BookingEngine_Shift4Bookings_TC_02() {
		logger.info("CRS Started");
		extentTest = extent.startTest("BookingEngine_Shift4Bookings_TC_02");


		ahp.clickPaymentGatewayTab();

		pgp.selectPaymentGateway(ExcelData.getCellData("Sheet1", "paymentGateway", 4));
		
		soft.assertTrue(sbp.verifyShift4AutoPopulate());
	
		
	}
	
//	@Test(priority = 3)
	@Description("User should be able to configure the prequisite settings for Shift4 Payment Gateway.")
	@Severity(SeverityLevel.CRITICAL)
	@Epic("EP01")
	@Feature("Feature1: Shift4 Payment Gateway")
	@Story("Story: Reservation can be book with compound access code")
	@Step("Verify reservation can be book with compound access code")
	public void BookingEngine_Shift4Bookings_TC_03() {
		logger.info("CRS Started");
		extentTest = extent.startTest("BookingEngine_Shift4Bookings_TC_03");


		lp.login();

		allureScreenshot("Login");
		screenShot("Login");

		ahp.selectBrandPaymentGateway();
		ahp.selectPropertyPaymentGateway();

		allureScreenshot("Property Selected");
		screenShot("Property Selected");

		ahp.clickPropertyManagementTab();
		ahp.clickPaymentGatewayTab();
		
		allureScreenshot("payment gateway");
		screenShot("payment gateway");

		pgp.selectPaymentGateway(ExcelData.getCellData("Sheet1", "paymentGateway", 4));
		
		soft.assertTrue(sbp.verifyShift4AutoPopulate());
	
		openBEurlinNewTabShift4();
		
		plrp.availabilityCheck();
		String buttonCheck = plrp.verifyBookNowBtn();

		soft.assertEquals(buttonCheck, "BOOK NOW");

		allureScreenshot("Booking Available");
		screenShot("Booking Available");

		plrp.bookNow();
		
		jbp.inputGuestDetails();
		jbp.clickconfirmDetails();

		allureScreenshot("Payment Page");
		screenShot("Payment Page");
		sbp.inputCardDetailsTC01();
		jbp.inputBillingAddress();
		jbp.inputadditionalContactInfo();
		jbp.selectTermsAndConditonCheckbox();
		jbp.clickCompleteReservation();

//		soft.assertTrue(fbp.verifyReservationCompleted());

		allureScreenshot("Booking Completed");
		screenShot("Booking Completed");
		
		soft.assertTrue(sbp.verificationTC03());

		allureScreenshot("Reservation Done");
		screenShot("Reservation Done");
		
	}
	
	@Test(priority = 4)
	@Description("User should be able to configure the prequisite settings for Shift4 Payment Gateway.")
	@Severity(SeverityLevel.CRITICAL)
	@Epic("EP01")
	@Feature("Feature1: Shift4 Payment Gateway")
	@Story("Story: Reservation can be book with compound access code")
	@Step("Verify reservation can be book with compound access code")
	public void BookingEngine_Shift4Bookings_TC_04() {
		logger.info("CRS Started");
		extentTest = extent.startTest("BookingEngine_Shift4Bookings_TC_04");


		lp.login();

		allureScreenshot("Login");
		screenShot("Login");

		ahp.selectBrandPaymentGateway();
		ahp.selectPropertyPaymentGateway();

		allureScreenshot("Property Selected");
		screenShot("Property Selected");

		ahp.clickPropertyManagementTab();
		ahp.clickPaymentGatewayTab();
		
		allureScreenshot("payment gateway");
		screenShot("payment gateway");

		pgp.selectPaymentGateway(ExcelData.getCellData("Sheet1", "paymentGateway", 4));
		
		soft.assertTrue(sbp.verifyShift4AutoPopulate());
	
		openBEurlinNewTabShift4();
		
		plrp.availabilityCheck();
		String buttonCheck = plrp.verifyBookNowBtn();

		soft.assertEquals(buttonCheck, "BOOK NOW");

		allureScreenshot("Booking Available");
		screenShot("Booking Available");

		plrp.bookNow();
		
		jbp.inputGuestDetails();
		jbp.clickconfirmDetails();

		allureScreenshot("Payment Page");
		screenShot("Payment Page");
		sbp.inputCardDetailsTC02();
		jbp.inputBillingAddress();
		jbp.inputadditionalContactInfo();
		jbp.selectTermsAndConditonCheckbox();
		jbp.clickCompleteReservation();

		soft.assertTrue(fbp.verifyReservationCompleted());

		allureScreenshot("Booking Completed");
		screenShot("Booking Completed");
		
	}
	
//	@Test(priority = 5)
	@Description("User should be able to configure the prequisite settings for Shift4 Payment Gateway.")
	@Severity(SeverityLevel.CRITICAL)
	@Epic("EP01")
	@Feature("Feature1: Shift4 Payment Gateway")
	@Story("Story: Reservation can be book with compound access code")
	@Step("Verify reservation can be book with compound access code")
	public void BookingEngine_Shift4Bookings_TC_05() {
		logger.info("CRS Started");
		extentTest = extent.startTest("BookingEngine_Shift4Bookings_TC_05");


//		lp.login();
//
//		allureScreenshot("Login");
//		screenShot("Login");
//
//		ahp.selectBrandPaymentGateway();
//		ahp.selectPropertyPaymentGateway();
//
//		allureScreenshot("Property Selected");
//		screenShot("Property Selected");
//
//		ahp.clickPropertyManagementTab();
		
		Helper.switchWindow(0);
		ahp.clickPaymentGatewayTab();
		
		allureScreenshot("payment gateway");
		screenShot("payment gateway");

		pgp.selectPaymentGateway(ExcelData.getCellData("Sheet1", "paymentGateway", 4));
		
		soft.assertTrue(sbp.verifyShift4AutoPopulate());
		
		pgp.clickNoButton();
		pgp.clickUpdateButton();
		
		Helper.switchWindow(1);
		refreshBEJCC();
		
		plrp.availabilityCheck();
		String buttonCheck = plrp.verifyBookNowBtn();

		soft.assertEquals(buttonCheck, "BOOK NOW");

		allureScreenshot("Booking Available");
		screenShot("Booking Available");

		plrp.bookNow();
		
		jbp.inputGuestDetails();
		jbp.clickconfirmDetails();

		allureScreenshot("Payment Page");
		screenShot("Payment Page");
		sbp.inputCardDetailsTC01();
		jbp.inputBillingAddress();
		jbp.inputadditionalContactInfo();
		jbp.selectTermsAndConditonCheckbox();
		jbp.clickCompleteReservation();

		soft.assertTrue(fbp.verifyReservationCompleted());

		allureScreenshot("Booking Completed");
		screenShot("Booking Completed");
		
	}
	
	@Test(priority = 6)
	@Description("User should be able to configure the prequisite settings for Shift4 Payment Gateway.")
	@Severity(SeverityLevel.CRITICAL)
	@Epic("EP01")
	@Feature("Feature1: Shift4 Payment Gateway")
	@Story("Story: Reservation can be book with compound access code")
	@Step("Verify reservation can be book with compound access code")
	public void BookingEngine_Shift4Bookings_TC_06() {
		logger.info("CRS Started");
		extentTest = extent.startTest("BookingEngine_Shift4Bookings_TC_06");


//		lp.login();
//
//		allureScreenshot("Login");
//		screenShot("Login");
//
//		ahp.selectBrandPaymentGateway();
//		ahp.selectPropertyPaymentGateway();
//
//		allureScreenshot("Property Selected");
//		screenShot("Property Selected");
//
//		ahp.clickPropertyManagementTab();
		
		Helper.switchWindow(0);
		ahp.clickPaymentGatewayTab();
		
		allureScreenshot("payment gateway");
		screenShot("payment gateway");

		pgp.selectPaymentGateway(ExcelData.getCellData("Sheet1", "paymentGateway", 4));
		pgp.clickYesButton();
		soft.assertTrue(sbp.verifyShift4AutoPopulate());
		pgp.clearSecureHashSecret();
		sbp.invalidSecureHashSecret_SHIFT4();
		
		pgp.clickUpdateButton();
		
		Helper.switchWindow(1);
		refreshBEJCC();
		
		plrp.availabilityCheck();
		String buttonCheck = plrp.verifyBookNowBtn();

		soft.assertEquals(buttonCheck, "BOOK NOW");

		allureScreenshot("Booking Available");
		screenShot("Booking Available");

		plrp.bookNow();
		
		jbp.inputGuestDetails();
		jbp.clickconfirmDetails();

		allureScreenshot("Payment Page");
		screenShot("Payment Page");
		sbp.inputCardDetailsTC01();
		jbp.inputBillingAddress();
		jbp.inputadditionalContactInfo();
		jbp.selectTermsAndConditonCheckbox();
		jbp.clickCompleteReservation();

		soft.assertTrue(fbp.verifyReservationCompleted());

		allureScreenshot("Booking Completed");
		screenShot("Booking Completed");
		
	}
}
