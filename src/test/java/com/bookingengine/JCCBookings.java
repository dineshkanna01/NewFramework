package com.bookingengine;

import java.util.ArrayList;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
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

//	@Test(priority = 1)
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

		ahp.selectBrand();
		ahp.selectProperty();

		allureScreenshot("Property Selected");
		screenShot("Property Selected");

		ahp.clickPropertyManagementTab();
		ahp.clickPaymentGatewayTab();

		pgp.selectPaymentGateway(e.getCellData("JCCBookings", "paymentGateway", 2));
		pgp.clickEnableButton();
		pgp.clickYesButton();

		pgp.clearMerchantId();
//		pgp.merchantId_JCCbookings();
//		pgp.clearAccessCode();
//		pgp.accessCode_JCCbookings();
//		pgp.clearSecureHashSecret();
//		pgp.secureHashSecret_JCCbookings();
//		pgp.delayTime();
//		pgp.orderTime();
//		pgp.clickUpdateButton();
//		String actText = pgp.administratorname();
//		String expText = e.getCellData("JCCBookings", "AdministratorText", 2);
//		soft.assertEquals(actText, expText, "Payment Gateway has updated");
//		soft.assertAll();

	}

//	@Test(priority = 2)
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

//		pgp.verifyJCCAutoPopulate();

	}

	@Test(priority = 3)
	@Description("User should be able to make reservations in Booking Engine using JCC Payment Gateway")
	@Severity(SeverityLevel.CRITICAL)
	@Epic("EP01")
	@Feature("Feature1:JCC Bookings")
	@Story("JCC Bookings")
	@Step("User should be able to make reservations in Booking Engine using JCC Payment Gateway")
	public void BookingEngine_JCCBookings_TC_03() throws InterruptedException  {
		logger.info("TestCase Started");
		extentTest = extent.startTest("BookingEngine_JCCBookings_TC_03");
		
		lp.login();

		allureScreenshot("Login");
		screenShot("Login");

//		ahp.selectBrand();
//		ahp.selectProperty();

//		allureScreenshot("Property Selected");
//		screenShot("Property Selected");

//		ahp.clickPropertyManagementTab();
//
//		ahp.clickPaymentGatewayTab();

//		pgp.selectPaymentGateway(e.getCellData("JCCBookings", "paymentGateway", 2));

	//.verifyJCCAutoPopulate();

		jbp.bETC01();
	
		
	}
}
