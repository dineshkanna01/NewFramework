package com.callcenter;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.admin.pom.AdministratorHomePage;
import com.admin.pom.LoginPage;
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

/*
 * Test class for VerifyingCCSettingsAnnouncementfromAdmintoBookingUI
 * @author Rudraksh Aggarwal
 */
public class VerifyingCCSettingsAnnouncementfromAdmintoBookingUI extends TestBase {

	public static Utilitylog logger;

	// objects
	LoginPage lp;
	AdministratorHomePage ahp;
	NormalSingleRoomBookingandverifyRateGridupdatePage nsrb;
	VerifyingCCSettingsAnnouncementfromAdmintoBookingUIPage vcsaab;

	public VerifyingCCSettingsAnnouncementfromAdmintoBookingUI() {
		super();
		logger = new Utilitylog(VerifyingCCSettingsAnnouncementfromAdmintoBookingUI.class.getName());
	}

	@BeforeMethod
	public void setup() {
		lp = new LoginPage(getDriver());
		ahp = new AdministratorHomePage(getDriver());
		vcsaab = new VerifyingCCSettingsAnnouncementfromAdmintoBookingUIPage(getDriver());
		nsrb = new NormalSingleRoomBookingandverifyRateGridupdatePage(getDriver());
	}

	@Test(priority = 1)
	@Description("Verify user should able to see Announcement in the the CC booking engine when announcement is activated")
	@Severity(SeverityLevel.CRITICAL)
	@Epic("EP01")
	@Feature("Feature1:Call Center")
	@Story("Call Center")
	@Step("Verify user should able to see Announcement in the the CC booking engine when announcement is activated")
	public void CallCentre_VerifyingCCSettingsAnnouncementfromAdmintoBookingUI_TC01() {
		logger.info("TestCase Started");
		extentTest = extent.startTest("CallCentre_VerifyingCCSettingsAnnouncementfromAdmintoBookingUI_TC01");
		lp.login();
		allureScreenshot("Login");
		screenShot("Login");
		ahp.selectBrand();
		ahp.selectProperty2();
		allureScreenshot("Property Selected");
		screenShot("Property Selected");
		ahp.clickPropertyManagementTab();
		ahp.callCenterSettings();
		vcsaab.inputDetailsTC01();
		vcsaab.clickSaveButton();
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
		Assert.assertTrue(vcsaab.verifyAnnouncementCC());
		allureScreenshot("Announcement");
		screenShot("Announcement");
		getDriver().close();
		Helper.switchWindow(0);
		logger.info("TestCase Ended");
	}

	@Test(priority = 2)
	@Description("Verify user should not be able to see Announcement in the the CC booking engine when announcement text is provided and activation status is no")
	@Severity(SeverityLevel.CRITICAL)
	@Epic("EP01")
	@Feature("Feature1:Call Center")
	@Story("Call Center")
	@Step("Verify user should not be able to see Announcement in the the CC booking engine when announcement text is provided and activation status is no")
	public void CallCentre_VerifyingCCSettingsAnnouncementfromAdmintoBookingUI_TC02() {
		logger.info("TestCase Started");
		extentTest = extent.startTest("CallCentre_VerifyingCCSettingsAnnouncementfromAdmintoBookingUI_TC02");
		ahp.callCenterSettings();
		vcsaab.inputDetailsTC02();
		vcsaab.clickSaveButton();
		openURL("config_url");
		Assert.assertTrue(vcsaab.clearCacheIBE());
		allureScreenshot("IBE config");
		screenShot("IBE config");
		vcsaab.logoutIBE();
		getDriver().close();
		Helper.switchWindow(0);
		openURL("cc_url");
		Assert.assertFalse(vcsaab.verifyAnnouncementCC());
		allureScreenshot("Announcement");
		screenShot("Announcement");
		getDriver().close();
		Helper.switchWindow(0);
		logger.info("TestCase Ended");
	}

	@Test(priority = 3)
	@Description("Verify user should not be able to see Announcement in the the CC booking engine when announcement activation status is no")
	@Severity(SeverityLevel.CRITICAL)
	@Epic("EP01")
	@Feature("Feature1:Call Center")
	@Story("Call Center")
	@Step("Verify user should not be able to see Announcement in the the CC booking engine when announcement activation status is no")
	public void CallCentre_VerifyingCCSettingsAnnouncementfromAdmintoBookingUI_TC03() {
		logger.info("TestCase Started");
		extentTest = extent.startTest("CallCentre_VerifyingCCSettingsAnnouncementfromAdmintoBookingUI_TC03");
		Helper.switchWindow(0);
		ahp.callCenterSettings();
		vcsaab.inputDetailsTC03();
		vcsaab.clickSaveButton();
		openURL("config_url");
		Assert.assertTrue(vcsaab.clearCacheIBE());
		allureScreenshot("IBE config");
		screenShot("IBE config");
		vcsaab.logoutIBE();
		getDriver().close();
		Helper.switchWindow(0);
		openURL("cc_url");
		Assert.assertFalse(vcsaab.verifyAnnouncementCC());
		allureScreenshot("Announcement");
		screenShot("Announcement");
		Helper.switchWindow(0);
		lp.logout();
		logger.info("TestCase Ended");
	}

}
