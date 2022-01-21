package com.admin;

import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.admin.pom.AddOnsPage;
import com.admin.pom.AdministratorHomePage;
import com.admin.pom.LoginPage;
import com.admin.pom.RatePlanPage;

import base.TestBase;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import io.qameta.allure.Story;
import logfile.Utilitylog;

public class RatePlan_Scenario extends TestBase{

	public static Utilitylog logger;

	public RatePlan_Scenario() {
		super();
		logger = new Utilitylog(RatePlanCategories.class.getName());
	}

	// objects
	LoginPage lp;
	AdministratorHomePage ahp;
	RatePlanPage rpp;
	AddOnsPage aop;

	@BeforeMethod
	public void setup() {

		lp = new LoginPage(getDriver());
		ahp = new AdministratorHomePage(getDriver());
		rpp = new RatePlanPage(getDriver());
		aop = new AddOnsPage(getDriver());

	}

	@Test(priority = 1)
	@Description("Verify that the user is able to create and delete a fixed rate plan ")
	@Severity(SeverityLevel.CRITICAL)
	@Epic("EP01")
	@Feature("Feature1:RatePlan")
	@Story("RatePlan Page")
	@Step("Verify user is able to create and delete fixed rate plan")
	public void RatePlan_TC_01() throws Exception {
		logger.info("TestCase Started");
		extentTest = extent.startTest("RatePlan_TC_01");

		lp.login();
		allureScreenshot("Login");
		screenShot("Login");

		ahp.selectBrand();
		ahp.selectProperty();

		allureScreenshot("Property Selected");
		screenShot("Property Selected");

		ahp.clickRatePlansTab();
		ahp.clickAddNewRatePlansTab();

		allureScreenshot("Rate Plan Page");
		screenShot("Rate Plan Page");

		rpp.inputfields_tc01();
		rpp.selectRoomType();
		rpp.deriveRatesNo();
		rpp.clickSaveButton();

		allureScreenshot("Rate Plan Created");
		screenShot("Rate Plan Created");

		Assert.assertTrue(rpp.verifyRateName());
		Assert.assertTrue(rpp.verifyRateAssociation());

		rpp.deleteRatePlan();

		allureScreenshot("Rate Plan Deleted");
		screenShot("Rate Plan Deleted");

		Assert.assertFalse(rpp.verifyRateName());

//		lp.logout();
		logger.info("TestCase Ended");
	}

	@Test(priority = 2)
	@Description("Verify that the user is able to create and delete a Floatings rate plan ")
	@Severity(SeverityLevel.CRITICAL)
	@Epic("EP01")
	@Feature("Feature1:RatePlan")
	@Story("RatePlan Page")
	@Step("Verify user is able to create and delete Floating rate plan")
	public void RatePlan_TC_02() throws Exception {
		logger.info("TestCase Started");
		extentTest = extent.startTest("RatePlan_TC_02");

		/*
		 * lp.login(); allureScreenshot("Login"); screenShot("Login");
		 * 
		 * ahp.selectBrand(); ahp.selectProperty();
		 * 
		 * allureScreenshot("Property Selected"); screenShot("Property Selected");
		 * 
		 * ahp.clickRatePlansTab();
		 */

		ahp.clickAddNewRatePlansTab();

		allureScreenshot("Rate Plan Page");
		screenShot("Rate Plan Page");

		rpp.selectRoomType();
		rpp.inputfields_tc02();
		rpp.clickSaveButton();

		allureScreenshot("Rate Plan Created");
		screenShot("Rate Plan Created");

		Assert.assertTrue(rpp.verifyRateName());
		Assert.assertFalse(rpp.verifyRateAssociation());

		rpp.deleteRatePlan();

		allureScreenshot("Rate Plan Deleted");
		screenShot("Rate Plan Deleted");

		Assert.assertFalse(rpp.verifyRateName());

		// lp.logout();
		logger.info("TestCase Ended");
	}

	@Test(priority = 3)
	@Description("Verify that the user is able to create and delete a rate plan having an Add-On ")
	@Severity(SeverityLevel.CRITICAL)
	@Epic("EP01")
	@Feature("Feature1:RatePlan")
	@Story("RatePlan Page")
	@Step("Verify user is able to create and delete rate plan having add on")
	public void RatePlan_TC_03() throws Exception {
		logger.info("TestCase Started");
		extentTest = extent.startTest("RatePlan_TC_03");

		/*
		 * lp.login(); allureScreenshot("Login"); screenShot("Login");
		 * 
		 * ahp.selectBrand(); ahp.selectProperty();
		 * 
		 * allureScreenshot("Property Selected"); screenShot("Property Selected");
		 */

		ahp.clickAddOnsTab();
		ahp.clickAddNewAddOnsTab();
		aop.inputTextFieldsAddOnsTc03();
		aop.clickOnSave();

		allureScreenshot("AddOn created");
		screenShot("AddOn created");

		Assert.assertTrue(aop.verifyAddOnName_tc02());

		ahp.clickRatePlansTab();
		ahp.clickAddNewRatePlansTab();

		allureScreenshot("Rate Plan Page");
		screenShot("Rate Plan Page");

		rpp.inputfields_tc01();
		rpp.selectRoomType();
		rpp.deriveRatesNo();

		rpp.attachAddOns();

		rpp.clickSaveButton();

		allureScreenshot("Rate Plan Created");
		screenShot("Rate Plan Created");

		Assert.assertTrue(rpp.verifyRateName());
		Assert.assertTrue(rpp.verifyRateAssociation());

		rpp.deleteRatePlan();

		allureScreenshot("Rate Plan Deleted");
		screenShot("Rate Plan Deleted");

		Assert.assertFalse(rpp.verifyRateName());

		ahp.clickAddOnsTab();
		ahp.clickListAllAddOn();

		aop.clickOnCheckbox();
		aop.clickOnDelete();
		aop.clickOnYes();

		// lp.logout();
		logger.info("TestCase Ended");
	}

	@AfterSuite
	public void report() throws Exception {
		mail();
		cmdPrompt();
	}
}
