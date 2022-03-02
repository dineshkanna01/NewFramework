//package com.bookingengine;
//
//import org.testng.annotations.BeforeMethod;
//import org.testng.annotations.Test;
//import org.testng.asserts.SoftAssert;
//
//import com.admin.pom.AdministratorHomePage;
//import com.admin.pom.LoginPage;
//import com.admin.pom.TaxesAndFeesPage;
//import com.be.pom.CalendarViewBookingsPage;
//import com.be.pom.RatePlanTaxesPage;
//
//import base.Helper;
//import base.TestBase;
//import io.qameta.allure.Description;
//import io.qameta.allure.Epic;
//import io.qameta.allure.Feature;
//import io.qameta.allure.Severity;
//import io.qameta.allure.SeverityLevel;
//import io.qameta.allure.Step;
//import io.qameta.allure.Story;
//import logfile.Utilitylog;
///*
// * Test class for Rate Plan Taxes Page
// * @author Sudhakar Mourya
// */
//public class RatePlanTaxes extends TestBase {
//	public static Utilitylog logger;
//
//	LoginPage lp;
//	AdministratorHomePage ahp;
//	TaxesAndFeesPage tf;
//	CalendarViewBookingsPage cvbp;
//	RatePlanTaxesPage rptp;
//	SoftAssert soft;
//
//	public RatePlanTaxes() {
//		super();
//		logger = new Utilitylog(RatePlanTaxes.class.getName());
//	}
//
//	@BeforeMethod
//	public void setup() {
//		lp = new LoginPage(getDriver());
//		ahp = new AdministratorHomePage(getDriver());
//		tf = new TaxesAndFeesPage(getDriver());
//		cvbp=new CalendarViewBookingsPage(getDriver());
//		rptp=new RatePlanTaxesPage(getDriver());
//		soft = new SoftAssert();
//	}
//
//	@Test(priority = 1)
//	@Description("Verify user is able to add tax and should see in booking engine")
//	@Severity(SeverityLevel.CRITICAL)
//	@Epic("EP01")
//	@Feature("Feature1:Rate Plan Taxes ")
//	@Story("Rate Plan Taxes")
//	@Step("Verify user is able to add taxes")
//	public void RatePlanTaxes_TC_01() throws InterruptedException  {
//		logger.info("TestCase Started");
//		extentTest = extent.startTest("RatePlanTaxes_TC_01");
//		lp.login();
//		ahp.selectBrand();
//		ahp.selectProperty();
//		openURL("be_url4");
//		rptp.selectDate();
//		rptp.clickAvailibilityButton();
//		rptp.clickBookNowButton();
//		rptp.getAmountBeforeTaxTc01();
//		Helper.switchWindow(0);
//		ahp.selectPropertyManagement();
//		tf.clickTaxesAndFees();
//		tf.clickaddNewTaxtoProperty();
//		tf.addTaxForRatePlanTaxes();
//		tf.clickSave();
//		allureScreenshot("taxCreated");
//		screenShot("TaxCreated");
//		ahp.clickRatePlansTab();
//		ahp.clickOnRatePlanTaxes();
//		rptp.clickOnLastTaxForBarRatePlan();
//		rptp.clickOnSaveRatePlanTaxes();
//		Helper.switchWindow(1);
//		Helper.refresh();
//		allureScreenshot("Tax visible in Booking engine");
//		screenShot("Tax visible in Booking engine");
//		rptp.getAmountAfterTaxTc01();
//		soft.assertFalse(rptp.verifyTaxAddedTc01());
//		soft.assertAll();
//		logger.info("TestCase Ended");
//	}
//
//	@Test(priority = 2)
//	@Description("Verify user is able to remove rate plan taxes ")
//	@Severity(SeverityLevel.CRITICAL)
//	@Epic("EP01")
//	@Feature("Feature1:Rate Plan Taxes ")
//	@Story("Rate Plan Taxes")
//	@Step(" Rate plan taxes")
//	public void RatePlanTaxes_TC_02() throws InterruptedException  {
//		logger.info("TestCase Started");
//		extentTest = extent.startTest("RatePlanTaxes_TC_02");
//		Helper.refreshBE();
//		rptp.selectDate();
//		rptp.clickAvailibilityButton();
//		rptp.clickBookNowButton();
//		rptp.getAmountBeforeTaxTc02();
//		allureScreenshot("Tax is visible");
//		screenShot("Tax is visible");
//		Helper.switchWindow(0);
//		ahp.clickRatePlansTab();
//		ahp.clickOnRatePlanTaxes();
//		rptp.clickOnLastTaxForBarRatePlan();
//		rptp.clickOnSaveRatePlanTaxes();
//		Helper.switchWindow(1);
//		Helper.refresh();
//		rptp.getAmountAfterTaxTc02();
//		allureScreenshot("Tax is remove");
//		screenShot("Tax is remove");
//		soft.assertFalse(rptp.verifyTaxRemovedTc02());
//		soft.assertAll();
//		logger.info("TestCase Ended");
//	}
//
//	@Test(priority = 3)
//	@Description("Verify user is able to modify rate plan taxes")
//	@Severity(SeverityLevel.CRITICAL)
//	@Epic("EP01")
//	@Feature("Feature1:Rate Plan Taxes ")
//	@Story("Rate plan taxes")
//	@Step("Modify Rate plan taxes")
//	public void RatePlanTaxes_TC_03()  {
//		logger.info("TestCase Started");
//		extentTest = extent.startTest("RatePlanTaxes_TC_03");
//		Helper.switchWindow(0);
//		ahp.clickRatePlansTab();
//		ahp.clickOnRatePlanTaxes();
//		rptp.clickOnLastTaxForBarRatePlan();
//		rptp.clickOnSaveRatePlanTaxes();
//		Helper.switchWindow(1);
//		Helper.refreshBE();
//		rptp.selectDate();
//		rptp.clickAvailibilityButton();
//		rptp.clickBookNowButton();
//		rptp.getAmountBeforeTaxTc03();
//		allureScreenshot("Tax is visible 10%");
//		screenShot("Tax is visible 10%");
//		Helper.switchWindow(0);
//		ahp.selectPropertyManagement();
//		tf.clickTaxesAndFees();
//		tf.changeTaxAmount();
//		tf.clickSave();
//		Helper.switchWindow(1);
//		Helper.refreshBE();
//		rptp.selectDate();
//		rptp.clickAvailibilityButton();
//		rptp.clickBookNowButton();
//		rptp.getAmountAfterTaxTc03();
//		allureScreenshot("Tax is visible 5%");
//		screenShot("Tax is visible 5%");
//		soft.assertFalse(rptp.verifyTaxModifiedTc03());
//		soft.assertAll();
//		logger.info("TestCase Ended");
//	}
//
//	@Test(priority = 4)
//	@Description("Verify user is able to make reservation without taxes")
//	@Severity(SeverityLevel.CRITICAL)
//	@Epic("EP01")
//	@Feature("Feature1:Rate Plan Taxes ")
//	@Story("Rate plan taxes")
//	@Step("Make reservation without taxes")
//	public void RatePlanTaxes_TC_04() {
//		logger.info("TestCase Started");
//		extentTest = extent.startTest("RatePlanTaxes_TC_04");
//		Helper.refreshBE();
//		rptp.selectDate();
//		rptp.clickAvailibilityButton();
//		rptp.clickBookNowButton();
//		cvbp.inputGuestDetails();
//		cvbp.selectRatePlanBar();
//		cvbp.clickconfirmDetails();
//		cvbp.inputCardDetails();
//		cvbp.inputBillingAddress();
//		cvbp.inputadditionalContactInfo();
//		cvbp.selectTermsAndConditonCheckbox();
//		cvbp.clickCompleteReservation();
//		allureScreenshot("Reservation Completed");
//		screenShot("Reservation Completed");
//		soft.assertTrue(cvbp.verificationBooking());
//		logger.info("TestCase Ended");
//	}
//
//	@Test(priority = 5)
//	@Description("Verify user is not  able to add Rate Plan Taxes if use the existing Tax code")
//	@Severity(SeverityLevel.CRITICAL)
//	@Epic("EP01")
//	@Feature("Feature1:Rate Plan Taxes ")
//	@Story("Rate plan taxes")
//	@Step("Add rate plan code with existing tax code")
//	public void RatePlanTaxes_TC_05() throws InterruptedException  {
//		logger.info("TestCase Started");
//		extentTest = extent.startTest("RatePlanTaxes_TC_04");
//		Helper.switchWindow(0);
//		ahp.selectPropertyManagement();
//		tf.clickTaxesAndFees();
//		tf.clickaddNewTaxtoProperty();
//		tf.addTaxWithExistCode();
//		tf.clickSave();
//		allureScreenshot("Error msg show when enter duplicate tax code");
//		screenShot("Error msg show when enter duplicate tax code");
//		String a=rptp.duplicateTaxCodeErrorMsg();
//		soft.assertEquals(a,"A tax with that code already exists. Please select a different code.","Duplicate code error msg displayed");
//		soft.assertAll();
//		tf.clickTaxesAndFees();
//		tf.deleteLastTax();
//		lp.logout();
//		logger.info("TestCase Ended");
//	}
//}
