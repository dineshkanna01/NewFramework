package com.bookingengine;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.admin.pom.AdministratorHomePage;
import com.admin.pom.BrandPage;
import com.admin.pom.ChannelPage;
import com.admin.pom.LoginPage;
import com.admin.pom.PropertyBrandingPage;
import com.admin.pom.RatePlanPage;
import com.admin.pom.RatesandInventoryPage;
import com.be.pom.JCCBookingsPage;
import com.be.pom.BookingEngine;
import com.be.pom.PropertyLevelRestrictionPage;

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

public class BookingEngineTestCase extends TestBase {
	public static Utilitylog logger;
	LoginPage lp;
	BrandPage bp;
	PropertyBrandingPage pbp;
	ChannelPage cp;
	PropertyLevelRestrictionPage plrp;
	BookingEngine be;
	AdministratorHomePage ahp;
	RatePlanPage rpp;
	RatesandInventoryPage rip;
	JCCBookingsPage jbp;
	SoftAssert soft;

	public BookingEngineTestCase() {
		super();
		logger = new Utilitylog(BookingEngineTestCase.class.getName());
	}

	@BeforeMethod
	public void setup() {
		lp = new LoginPage(getDriver());
		pbp = new PropertyBrandingPage(getDriver());
		bp = new BrandPage(getDriver());
		cp = new ChannelPage(getDriver());
		plrp = new PropertyLevelRestrictionPage(getDriver());
		be = new BookingEngine(getDriver());
		ahp = new AdministratorHomePage(getDriver());
		rpp = new RatePlanPage(getDriver());
		rip = new RatesandInventoryPage(getDriver());
		jbp = new JCCBookingsPage(getDriver());
		soft = new SoftAssert();

	}

	@Test(priority = 1)
	@Description("Booking Engine end to end")
	@Severity(SeverityLevel.CRITICAL)
	@Epic("EP01")
	@Feature("Feature1: Booking Engine")
	@Story("Story: Complete Booking")
	@Step("Verify Complete Booking")
	public void BookingEngineE2E() throws Exception {
		logger.info("CRS Started");
		extentTest = extent.startTest("BookingEngineE2E");

		lp.login();

		allureScreenshot("Logged In");
		screenShot("Logged In");

		bp.openBrands();

		allureScreenshot("Brands Open");
		screenShot("Brands Open");

		bp.brandSelect();

		pbp.selectProperty();

		cp.openPropertyTab();

		be.adminBedType();
		allureScreenshot("Bed Created");
		screenShot("Bed Created");

		ahp.clickAddOnsTab();
		Thread.sleep(2000);
		ahp.clickAddNewAddOnsTab();

		be.inputTextFieldsAddOnsTc01();

		allureScreenshot("AddOns Create");
		screenShot("AddOns Create");

		be.clickOnSave();

		ahp.clickOnRoomTab();
		ahp.clickOnAddNew();
		allureScreenshot("New Room");
		screenShot("New Room");
		be.inputRoomData();

		ahp.clickRatePlansTab();
		Thread.sleep(2000);
		be.editRatePlanAddOn();
		rpp.attachAddOns();

		allureScreenshot("Bar Rate plan");
		screenShot("Bar Rate plan");

		rpp.clickSaveButton();

		ahp.selectRatesandInventory();

		Thread.sleep(2000);
		rip.selectRateGrid();
		be.selectRatePlan();
		allureScreenshot("selectRatePlan");
		rip.continueButton();
		rip.selectDateRange();
		rip.clickoverrideRoomCheckbox();
		rip.clickdailyRateInvbutton();
		allureScreenshot("RateGrid");
		Thread.sleep(3000);
		rip.selectALLRoomType();

		rip.updateRate();
		be.availability();
		allureScreenshot("Updating Rate Grid");
		screenShot("Updating Rate Grid");

		rip.clickQuickEntrybutton();
		rip.clickUpdatebutton();

		allureScreenshot("Rate Grid Updated");
		screenShot("Rate Grid Updated");

		rip.clickConfirmbutton();

		logger.info("Booking Engine Open");
		openURL("be_url2");

		allureScreenshot("Booking Engine");
		screenShot("Booking Engine");

		jbp.selectDate();
		jbp.clickAvailibilityButton();
		Thread.sleep(2000);
		be.beRoomSelect();
		jbp.clickBookNowButton();
		jbp.inputGuestDetails();
		jbp.clickconfirmDetails();

		be.verificationAddOn();
		allureScreenshot("Payment Page");
		screenShot("Payment Page");
		jbp.inputCardDetailsTC01();
		jbp.inputBillingAddress();
		jbp.inputadditionalContactInfo();
		jbp.selectTermsAndConditonCheckbox();
		jbp.clickCompleteReservation();
		be.verification();

		allureScreenshot("Reservation Done");
		screenShot("Reservation Done");

		Helper.switchWindow(0);
		Thread.sleep(2000);
		lp.logout();
		logger.info("crs closed");
		logger.info("booking engine closed");

	}
}
