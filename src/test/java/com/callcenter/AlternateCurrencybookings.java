package com.callcenter;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.admin.pom.AdministratorHomePage;
import com.admin.pom.LoginPage;
import com.cc.pom.AlternateCurrencybookingsPage;
import com.cc.pom.ModifyBookingfromconfirmationpagePage;
import com.cc.pom.NormalSingleRoomBookingandverifyRateGridupdatePage;
import com.cc.pom.VerifyingCCSettingsAnnouncementfromAdmintoBookingUIPage;

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

/* Test class for AlternateCurrencybookings  
* @author Rudraksh Aggarwal
*/
public class AlternateCurrencybookings extends TestBase {

	static Utilitylog logger;

// objects
	LoginPage lp;
	AdministratorHomePage ahp;
	NormalSingleRoomBookingandverifyRateGridupdatePage nsrb;
	ModifyBookingfromconfirmationpagePage mbcp;
	AlternateCurrencybookingsPage acb;
	VerifyingCCSettingsAnnouncementfromAdmintoBookingUIPage vcsaab;

	public AlternateCurrencybookings() {
		super();
		logger = new Utilitylog(AlternateCurrencybookings.class.getName());
	}

	@BeforeMethod
	public void setup() {
		lp = new LoginPage(getDriver());
		ahp = new AdministratorHomePage(getDriver());
		nsrb = new NormalSingleRoomBookingandverifyRateGridupdatePage(getDriver());
		mbcp = new ModifyBookingfromconfirmationpagePage(getDriver());
		acb = new AlternateCurrencybookingsPage(getDriver());
		vcsaab = new VerifyingCCSettingsAnnouncementfromAdmintoBookingUIPage(getDriver());
	}

	@Test(priority = 1)
	@Description("User should be able to see the default currency selected in CC")
	@Severity(SeverityLevel.CRITICAL)
	@Epic("EP01")
	@Feature("Feature1:Call Center")
	@Story("Call Center")
	@Step("User should be able to see the default currency selected in CC")
	public void CallCenter_AlternateCurrencybookings_TC_01() {
		logger.info("TestCase Started");
		extentTest = extent.startTest("CallCenter_AlternateCurrencybookings_TC_01");
		lp.login();
		allureScreenshot("Login");
		screenShot("Login");
		ahp.selectBrand();
		ahp.selectProperty2();
		allureScreenshot("Property Selected");
		screenShot("Property Selected");
		ahp.clickPropertyManagementTab();
		ahp.selectpropertyDefault();
		acb.selectDefaultCurrencyAdmin();
		acb.clickSaveButton();
		allureScreenshot("Admin Default currency");
		screenShot("Admin Default currency");
		openURL("config_url");
		Assert.assertTrue(vcsaab.clearCacheIBE());
		allureScreenshot("IBE config");
		screenShot("IBE config");
		vcsaab.logoutIBE();
		getDriver().close();
		Helper.switchWindow(0);
		openURL("cc_url");
		nsrb.enterCCuser();
		allureScreenshot("Call Center");
		screenShot("Call Center");
		acb.selectDefaultCurrencyCC();
		allureScreenshot("Call Center Default currency");
		screenShot("Call Center Default currency");
		Assert.assertTrue(acb.verifyCurrencyTC01());
		Helper.switchWindow(0);
		ahp.clickPropertyManagementTab();
		ahp.selectpropertyDefault();
		acb.selectAlternateCurrencyAdmin();
		allureScreenshot("Admin Alternate currency");
		screenShot("Admin Alternate currency");
		acb.clickSaveButton();
		Helper.switchWindow(1);
		Helper.openconfigIBE();
		Assert.assertTrue(vcsaab.clearCacheIBE());
		allureScreenshot("IBE config");
		screenShot("IBE config");
		vcsaab.logoutIBE();
		getDriver().close();
		Helper.switchWindow(0);
		openURL("cc_url");
		acb.selectAlternateCurrencyCC();
		allureScreenshot("Call Center Alternate currency");
		screenShot("Call Center Alternate currency");
		Assert.assertTrue(acb.verifyAlternateCurrencyTC01());
	}

	@Test(priority = 2)
	@Description("Verify user should able to see amount on the first page in CC booking engine with alternate currency")
	@Severity(SeverityLevel.CRITICAL)
	@Epic("EP01")
	@Feature("Feature1:Call Center")
	@Story("Call Center")
	@Step("Verify user should able to see amount on the first page in CC booking engine with alternate currency")
	public void CallCenter_AlternateCurrencybookings_TC_02() {
		logger.info("TestCase Started");
		extentTest = extent.startTest("CallCenter_AlternateCurrencybookings_TC_02");
		acb.selectCurrencyCCTC02_1();
		allureScreenshot("Call Center Alternate currency_TC02_1");
		screenShot("Call Center Alternate currency_TC02_1");
		nsrb.selectDateRangeCCTC01();
		nsrb.clickAvailibilityButton();
		acb.getChargeFirstPageTC02_1();
		allureScreenshot("ChargeFirstPageTC02_1");
		screenShot("ChargeFirstPageTC02_1");
		acb.selectCurrencyCCTC02_2();
		allureScreenshot("Call Center Alternate currency_TC02_2");
		screenShot("Call Center Alternate currency_TC02_2");
		acb.getChargeFirstPageTC02_2();
		allureScreenshot("ChargeFirstPageTC02_2");
		screenShot("ChargeFirstPageTC02_2");
		Assert.assertTrue(acb.verifyChargeTC02());
		logger.info("TestCase Ended");
	}

	@Test(priority = 3)
	@Description("Verify user should able to change currency INR to USD on the payments page  in CC booking engine")
	@Severity(SeverityLevel.CRITICAL)
	@Epic("EP01")
	@Feature("Feature1:Call Center")
	@Story("Call Center")
	@Step("Verify user should able to change currency INR to USD on the payments page  in CC booking engine")
	public void CallCenter_AlternateCurrencybookings_TC_03() {
		logger.info("TestCase Started");
		extentTest = extent.startTest("CallCenter_AlternateCurrencybookings_TC_03");
		nsrb.selectRoom();
		nsrb.clickpaymentButton();
		acb.getChargePaymentPageTC03_1();
		allureScreenshot("ChargeFirstPageTC03_1");
		screenShot("ChargeFirstPageTC03_1");
		acb.selectCurrencyCCTC02_1();
		acb.getChargePaymentPageTC03_2();
		allureScreenshot("ChargeFirstPageTC03_2");
		screenShot("ChargeFirstPageTC03_2");
		Assert.assertTrue(acb.verifyChargeTC03());
		logger.info("TestCase Ended");
	}

	@Test(priority = 4)
	@Description("Verify user should able to change currency USD to INR on the payments page  in CC booking engine")
	@Severity(SeverityLevel.CRITICAL)
	@Epic("EP01")
	@Feature("Feature1:Call Center")
	@Story("Call Center")
	@Step("Verify user should able to change currency USD to INR on the payments page  in CC booking engine")
	public void CallCenter_AlternateCurrencybookings_TC_04() {
		logger.info("TestCase Started");
		extentTest = extent.startTest("CallCenter_AlternateCurrencybookings_TC_04");
		Helper.refreshCC();
		nsrb.selectDateRangeCCTC01();
		nsrb.clickAvailibilityButton();
		nsrb.selectRoom();
		nsrb.clickpaymentButton();
		acb.getChargePaymentPageTC04_1();
		allureScreenshot("ChargePaymentPageTC04_1");
		screenShot("ChargePaymentPageTC04_1");
		acb.selectCurrencyCCTC02_2();
		acb.getChargePaymentPageTC04_2();
		allureScreenshot("ChargePaymentPageTC04_2");
		screenShot("ChargePaymentPageTC04_2");
		Assert.assertTrue(acb.verifyChargeTC04());
		logger.info("TestCase Ended");
	}

	@Test(priority = 5)
	@Description("Verify user should able to change currency by modifying the reservation in CC booking engine USD TO INR")
	@Severity(SeverityLevel.CRITICAL)
	@Epic("EP01")
	@Feature("Feature1:Call Center")
	@Story("Call Center")
	@Step("Verify user should able to change currency by modifying the reservation in CC booking engine USD TO INR")
	public void CallCenter_AlternateCurrencybookings_TC_05() {
		logger.info("TestCase Started");
		extentTest = extent.startTest("CallCenter_AlternateCurrencybookings_TC_05");
		Helper.refreshCC();
		nsrb.selectDateRangeCCTC01();
		nsrb.clickAvailibilityButton();
		nsrb.selectRoom();
		allureScreenshot("Room");
		screenShot("Room");
		nsrb.clickpaymentButton();
		allureScreenshot("Call Center payment details");
		screenShot("Call Center payment details");
		nsrb.inputGuestDetails();
		nsrb.inputCardDetailsTC01();
		nsrb.inputBillingAddress();
		nsrb.selectTermsAndConditonCheckbox();
		allureScreenshot("Grand Total Before");
		screenShot("Grand Total Before");
		nsrb.clickCompleteReservation();
		Assert.assertTrue(mbcp.verifyConfirmationCode());
		allureScreenshot("Call Center booking confirmation code");
		screenShot("Call Center booking confirmation code");
		acb.getGrandTotalCCTC05_1();
		mbcp.modify();
		acb.selectCurrencyCCTC02_2();
		nsrb.clickpaymentButton();
		nsrb.inputGuestDetails();
		nsrb.inputCardDetailsTC01();
		nsrb.inputBillingAddress();
		nsrb.selectTermsAndConditonCheckbox();
		allureScreenshot("Grand Total After");
		screenShot("Grand Total After");
		nsrb.clickCompleteReservation();
		acb.getGrandTotalCCTC05_2();
		Assert.assertTrue(acb.verifyChargeTC05());
		logger.info("TestCase Ended");
	}
}
