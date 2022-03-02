package com.bookingengine;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.admin.pom.AdministratorHomePage;
import com.admin.pom.LoginPage;
import com.be.pom.CalendarViewBookingsPage;
import base.Helper;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import io.qameta.allure.Story;
import logfile.Utilitylog;

/*
 * Test class for Calendar View Bookings
 * @author Sudhakar Mourya
 */
public class CalendarViewBookings extends Helper {

	public static Utilitylog logger;

	LoginPage lp;
	AdministratorHomePage ahp;
	CalendarViewBookingsPage cvbp;
	SoftAssert soft;

	public CalendarViewBookings() {
		super();
		logger = new Utilitylog(CalendarViewBookings.class.getName());
	}

	@BeforeMethod
	public void setup() {
		lp = new LoginPage(getDriver());
		ahp = new AdministratorHomePage(getDriver());
		cvbp= new CalendarViewBookingsPage(getDriver());
		soft = new SoftAssert();
	}

		@Test(priority = 1)
	@Description("Verify user is able to configure Calendar View Booking")
	@Severity(SeverityLevel.CRITICAL)
	@Epic("EP01")
	@Feature("Feature1:Calendar View Booking")
	@Story("CalendarViewBookings Page")
	@Step("Verify configration for CVB")
	public void CalendarViewBookings_TC_01() throws InterruptedException {
		logger.info("TestCase Started");
		extentTest = extent.startTest("CalendarViewBookings_TC_01");
		lp.login();
		ahp.selectBrand();
		ahp.selectProperty();
		allureScreenshot("Property Selected");
		screenShot("Property Selected");
		openURL("config_url");
		Helper.implict(4);
		cvbp.inputFieldTc_01();
		allureScreenshot("Configration done for calender view");
		screenShot("Configration done for calender view");
		soft.assertTrue(cvbp.verifySubdomainUpdated());
		getDriver().close();
		Helper.switchWindow(0);
		logger.info("TestCase Ended");
	}

	@Test(priority = 2)
	@Description("Verify user is able to make reservation for current date from Calendar View Booking")
	@Severity(SeverityLevel.CRITICAL)
	@Epic("EP01")
	@Feature("Feature1:Calendar View Booking")
	@Story("CalendarViewBookings Page")
	@Step("Do current date reservation with CVB")
	public void CalendarViewBookings_TC_02() throws InterruptedException {
		logger.info("TestCase Started");
		extentTest = extent.startTest("CalendarViewBookings_TC_02");
		openURL("be_url4");
		allureScreenshot("Calendar view");
		screenShot("Calendar view");
		Helper.sleep(3000);
		cvbp.selectDateRange();
		Helper.sleep(3000);
		cvbp.clickOnSelectRoom();
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
		soft.assertTrue(cvbp.verificationBooking());
		logger.info("TestCase Ended");
	}	


	@Test(priority = 3)
	@Description("Verify user is able to make reservation for 5 day from Calendar View Booking")
	@Severity(SeverityLevel.CRITICAL)
	@Epic("EP01")
	@Feature("Feature1:Calendar View Booking")
	@Story("CalendarViewBookings Page")
	@Step("Do reservation for 5 day with CVB")
	public void CalendarViewBookings_TC_03() throws InterruptedException {
		logger.info("TestCase Started");
		extentTest = extent.startTest("CalendarViewBookings_TC_03");
		Helper.refreshBE();
		Helper.sleep(3000);
		cvbp.selectDateRangeTC_03();
		Helper.sleep(3000);
		cvbp.clickOnSelectRoom();
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
		soft.assertTrue(cvbp.verificationBooking());
		logger.info("TestCase Ended");
	}

	@Test(priority = 4)
	@Description("Verify user is able to do reset the date from Calendar View Booking")
	@Severity(SeverityLevel.CRITICAL)
	@Epic("EP01")
	@Feature("Feature1:Calendar View Booking")
	@Story("CalendarViewBookings Page")
	@Step("Reset the date from CVB")
	public void CalendarViewBookings_TC_04() throws InterruptedException {
		logger.info("TestCase Started");
		extentTest = extent.startTest("CalendarViewBookings_TC_04");
		Helper.refreshBE();
		Helper.sleep(3000);
		cvbp.selectDateRange();
		Helper.sleep(3000);
		allureScreenshot("Date selected in calender view");
		screenShot("Date selected in calender view");
		cvbp.clickOnSelectRoom();
		getDriver().navigate().back();
		cvbp.clickOnResetDate();
		allureScreenshot("Date reset in calender view");
		screenShot("Date reset in calender view");
		cvbp.selectDateRangeTC_03();
		Helper.sleep(3000);
		cvbp.clickOnSelectRoom();
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
		soft.assertTrue(cvbp.verificationBooking());
		lp.logout();
		logger.info("TestCase Ended");
	}
}